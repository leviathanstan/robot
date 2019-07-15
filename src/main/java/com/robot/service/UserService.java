package com.robot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.robot.dao.UserDao;
import com.robot.entity.Introduction;
import com.robot.entity.Member;
import com.robot.entity.RepresentativeWork;
import com.robot.entity.User;
import com.robot.util.*;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.awt.dnd.peer.DragSourceContextPeer;
import java.util.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private JavaMailSender mailSender;

    private final int PAGE_LENGTH = 8;

    /**
     * 定时清除session,可考虑数据库或redis实现
     */
    ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);

    /**
     * 判断用户权限
     *
     * @param
     * @return
     * @author asce
     * @date 2018/12/5
     */
    public String getPermission(HttpSession session) {
        User user = (User) session.getAttribute("user");
        Integer role = (Integer) session.getAttribute("role");
        if (user != null) {
            return GsonUtil.getSuccessJson(role);
        } else {
            return GsonUtil.getSuccessJson(0);
        }
    }

    /**
     * 得到所有订阅标签
     *
     * @param
     * @return
     * @author asce
     * @date 2018/12/5
     */
    public String getAllSubscribe() {
        ArrayList<Map> map = userDao.getAllSubscribe();
        return GsonUtil.getSuccessJson(map);
    }

    /**
     * 得到订阅内容列表
     *
     * @param
     * @return
     * @author asce
     * @date 2018/12/5
     */
    public String getSubscribeList(HttpSession session) {
        User user = (User) session.getAttribute("user");
        ArrayList<Map> map = userDao.getUserSubscribeInfo(user.getId());
        return GsonUtil.getSuccessJson(map);
    }

    /**
     * 删除订阅
     *
     * @param
     * @return
     * @author asce
     * @date 2018/11/28
     */
    public String deleteSubscribe(int categoryId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Map<String, Integer> map = new HashMap<>();
        map.put("userId", user.getId());
        map.put("categoryId", categoryId);
        if (userDao.deleteSubscribe(map) != 1) {
            return GsonUtil.getErrorJson("你没有这个订阅");
        }
        return GsonUtil.getSuccessJson();
    }

    /**
     * 订阅
     *
     * @param
     * @return
     * @author asce
     * @date 2018/11/28
     */
    public String addSubscribe(int categoryId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Map<String, Integer> map = new HashMap<>();
        map.put("userId", user.getId());
        map.put("categoryId", categoryId);
        Integer dbRecord = userDao.selectSubscribeInfo(map);
        if (dbRecord != null) {
            return GsonUtil.getErrorJson("你已订阅过");
        }
        userDao.addSubscribe(map);
        return GsonUtil.getSuccessJson();
    }

    /**
     * 搜索用户
     *
     * @param
     * @return
     * @author asce
     * @date 2018/11/15
     */
    public String findUser(User user, String pageNumStr) {
        int pageNum = CommonUtil.formatPageNum(pageNumStr);
        PageHelper.startPage(pageNum, Constant.PRODUCT_PAGE_COUNT);
        List<User> users = userDao.find(user);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return GsonUtil.getSuccessJson(pageInfo);
    }

    /**
     * @param user
     * @return
     * @function 用户登录
     */
    public String login(User user, HttpSession session) {
        User dbUser = null;
        user.setPassword(Md5Util.GetMD5Code(user.getPassword()));
        if ((dbUser = userDao.login(user)) == null) {
            return GsonUtil.getErrorJson("密码或账号错误");
        } else {
            session.setAttribute("user", dbUser);
            switch (dbUser.getRole()) {
                case 1:
                    session.setAttribute("role", User.ROLE_SUPER);
                    break;
                case 2:
                    session.setAttribute("role", User.ROLE_MANAGER);
                    break;
                default:
                    session.setAttribute("role", User.ROLE_NORMAL);
                    break;
            }
            return GsonUtil.getSuccessJson(dbUser);
        }
    }

    /**
     * @param user
     * @return
     * @function 用户注册信息判断
     */
    public String validate(User user, final HttpSession session) {
        if (ValidateUtil.isInvalidString(user.getUsername()) || ValidateUtil.isInvalidString(user.getPassword()) || ValidateUtil.isInvalidString(user.getEmail())) {
            return GsonUtil.getErrorJson("输入不能为空");
        }
        if (!ValidateUtil.isMatchEmail(user.getEmail())) {
            return GsonUtil.getErrorJson("邮箱格式不正确");
        }
        User user1 = new User();
        user1.setEmail(user.getEmail());
        if (userDao.find(user1).size() != 0) {
            return GsonUtil.getErrorJson("邮箱已经注册过");
        }

        Integer enterpriseId = (Integer) session.getAttribute("enterpriseId");
        if (enterpriseId != null) {
            user.setRole(User.ROLE_MEMBER);
            user.setStatus(User.STATUS_WAIT);
            user.setEnterpriseId(enterpriseId);
        }
        session.setAttribute("registerUser", user);
        String code = CharacterUtil.getRandomString(5);
        try {
            EmailUtil.sendEmail(mailSender, user.getEmail(), code);
        } catch (Exception e) {
            e.printStackTrace();
            return GsonUtil.getErrorJson("邮件发送失败！");
        }
        session.setAttribute("emailCode", code);
        exec.schedule(() -> {
            if (session.getAttribute("emailCode") != null)
                session.removeAttribute("emailCode");
        }, 1000 * 60 * 5, TimeUnit.MILLISECONDS);
        return GsonUtil.getSuccessJson("已经发送验证码到你的邮箱,请验证");
    }

    /**
     * @param checkCode
     * @param
     * @return
     * @function 注册验证码验证
     */
    public String register(String checkCode, HttpSession session) {
        String code = (String) session.getAttribute("emailCode");
        User user = (User) session.getAttribute("registerUser");
        if (ValidateUtil.isInvalidString(checkCode)) {
            return GsonUtil.getErrorJson("输入不能为空");
        } else {
            if (!code.equals(checkCode)) {
                return GsonUtil.getErrorJson("验证码错误");
            } else {
                user.setPassword(Md5Util.GetMD5Code(user.getPassword()));
                Integer userId = userDao.register(user);
                if (userId != null) {

                    if (user.getEnterpriseId() != null) {
                        userDao.insertMemberUser(user);
                    }
                    //两个去除session方案：成功则去除session，不成功过期了也去除
                    session.removeAttribute("emailCode");
                    session.removeAttribute("registerUser");
                    return GsonUtil.getSuccessJson();
                } else
                    return GsonUtil.getErrorJson();
            }
        }
    }

    /**
     * 忘记密码
     *
     * @param email
     * @return
     */
    public String forgetPassword(String email, final HttpSession session) {
        User user = new User();
        user.setEmail(email);
        if (userDao.find(user).size() != 0) {
            return GsonUtil.getErrorJson("该邮箱未注册");
        } else {
            String code = CharacterUtil.getRandomString(5);
            try {
                EmailUtil.sendEmail(mailSender, email, code);
            } catch (Exception e) {
                e.printStackTrace();
                return GsonUtil.getErrorJson("邮件发送失败！");
            }
            session.setAttribute("emailCode", code);
            session.setAttribute("email", email);
            exec.schedule(() -> {
                if (session.getAttribute("emailCode") != null)
                    session.removeAttribute("emailCode");
                if (session.getAttribute("email") != null)
                    session.removeAttribute("email");
            }, 1000 * 60 * 5, TimeUnit.MILLISECONDS);
            return GsonUtil.getSuccessJson("已发送验证码到你的邮箱，请验证");
        }
    }

    /**
     * 忘记密码时邮箱验证
     *
     * @param checkCode
     * @return
     */
    public String validateEmail(String checkCode, HttpSession session) {
        String code = (String) session.getAttribute("emailCode");
        if (ValidateUtil.isInvalidString(checkCode)) {
            return GsonUtil.getErrorJson("输入不能为空");
        } else {
            if (!code.equals(checkCode)) {
                return GsonUtil.getErrorJson("验证码错误");
            } else {
                session.removeAttribute("emailCode");
                return GsonUtil.getSuccessJson();
            }
        }
    }

    /**
     * 重置密码
     *
     * @param password
     * @param
     * @return
     */
    public String resetPassword(String password, HttpSession session) {
        String email = (String) session.getAttribute("email");
        if (userDao.resetPassword(Md5Util.GetMD5Code(password), email) > 0) {
            session.removeAttribute("email");
            return GsonUtil.getSuccessJson();
        }
        return GsonUtil.getErrorJson();
    }

    /**
     * 新增会员
     *
     * @param member
     * @return
     */
    @Transactional
    public String insertNewMember(HttpSession session, Member member, MultipartFile authenticationDatas, MultipartFile contactInfoDatas) {

        if (contactInfoDatas == null) {
            return GsonUtil.getErrorJson("联络人资料不能为空");
        } else {
            member.setContactInfo(contactInfoDatas.getOriginalFilename());
            String realNameOfContactInfo = CommonUtil.uploadMember(contactInfoDatas, Constant.MEMBER_CONTACTINFODATAS_PATH);
            member.setContactInfoUrl(realNameOfContactInfo);
        }

        if (member.getEnterpriseName() == null || "".equals(member.getEnterpriseName()) || !member.getEnterpriseName().matches(Constant.USER_COMPANY_NAME_REGULAR_EXPRESSION)) {
            return GsonUtil.getErrorJson("企业名称格式不正确");
        }

        if (userDao.isExistMember(member.getEnterpriseName()) != 0) {
            return GsonUtil.getErrorJson("企业已存在");
        }

        member.setMemberNumber(Md5Util.encryptMd5(CommonUtil.convertToString(new Date(), "yyyy-MM-dd")) + member.getEnterpriseName());

        member.setMemberName(member.getEnterpriseName()); //会员全称
        if (member.getEnterpriseType() == null || "".equals(member.getEnterpriseType()) || !CommonUtil.isContains(member.getEnterpriseType(), Member.ENTERPRISE_TYPE)) {
            return GsonUtil.getErrorJson("企业类型格式不正确");
        }
        member.setMemberType(member.getEnterpriseType()); //会员类型
        if (member.getEnterpriseScale() == null || "".equals(member.getEnterpriseScale())) {
            return GsonUtil.getErrorJson("企业规模格式不正确");
        }
        if (member.getLocation() == null || "".equals(member.getLocation()) || !member.getLocation().matches(Constant.ADDRESS_REGULAR_EXPRESSION)) {
            return GsonUtil.getErrorJson("所在地格式不正确");
        }
        if (member.getRegisteredCapital() == null || "".equals(member.getRegisteredCapital())) {
            return GsonUtil.getErrorJson("注册资本格式不正确");
        }
        if (member.getRegisteredDate() == null || "".equals(member.getRegisteredDate())) {
            return GsonUtil.getErrorJson("注册年份格式不正确");
        }
        if (authenticationDatas == null) {
            return GsonUtil.getErrorJson("资料认证文件不能为空");
        } else {
            member.setAuthenticationData(authenticationDatas.getOriginalFilename());
            String realNameOfAuthenticationDatas = CommonUtil.uploadMember(authenticationDatas, Constant.MEMBER_AUTHENTICATIONDATA_PATH);
            member.setAuthenticationDataUrl(realNameOfAuthenticationDatas);
        }
        if (member.getManagementModel() == null || "".equals(member.getManagementModel()) || !CommonUtil.isContains(member.getManagementModel(), Member.MANAGEMENT_MODEL)) {
            return GsonUtil.getErrorJson("经营模式格式不正确");
        }
        if (member.getManagementScope() == null || "".equals(member.getManagementScope())) {
            return GsonUtil.getErrorJson("经营范围格式不正确");
        }
        if (member.getMainCamp() == null || "".equals(member.getMainCamp())) {
            return GsonUtil.getErrorJson("主营行业格式不正确");
        }
        if (member.getMainApplication() == null || "".equals(member.getMainApplication())) {
            return GsonUtil.getErrorJson("擅长应用格式不正确");
        }
        if (member.getDeveloping() == null || "".equals(member.getDeveloping())) {
            return GsonUtil.getErrorJson("发展历程格式不正确");
        }
        if (member.getCooperativePartner() == null || "".equals(member.getCooperativePartner())) {
            return GsonUtil.getErrorJson("合作伙伴格式不正确");
        }
        if (member.getMainCustomer() == null || "".equals(member.getMainCustomer())) {
            return GsonUtil.getErrorJson("主要客户格式不正确");
        }
        if (member.getPostalCode() == null || "".equals(member.getPostalCode()) || !member.getPostalCode().matches(Constant.POSTAL_CODE)) {
            return GsonUtil.getErrorJson("邮政编码格式不正确");
        }
        if (member.getContactNumber() == null || "".equals(member.getContactNumber()) || !member.getContactNumber().matches(Constant.PHONE_REGULAR_EXPRESSION)) {
            return GsonUtil.getErrorJson("联系电话格式不正确");
        }
        if (member.getFax() == null || "".equals(member.getFax())) {
            return GsonUtil.getErrorJson("传真格式不正确");
        }
        if (member.getEmail() == null || "".equals(member.getEmail()) || !member.getEmail().matches(Constant.EMAIL_REGULAR_EXPRESSION)) {
            return GsonUtil.getErrorJson("电子邮件格式不正确");
        }
        if (member.getContactAddress() == null || "".equals(member.getContactAddress()) || !member.getContactAddress().matches(Constant.ADDRESS_REGULAR_EXPRESSION)) {
            return GsonUtil.getErrorJson("联系地址格式不正确");
        }
        if (member.getContacts() == null || "".equals(member.getContacts())) {
            return GsonUtil.getErrorJson("联系人格式不正确");
        }

        member.setContact(member.getContacts()); //联络人

        if (member.getDepartment() == null || "".equals(member.getDepartment())) {
            return GsonUtil.getErrorJson("所在部门格式不正确");
        }
        if (member.getPost() == null || "".equals(member.getPost())) {
            return GsonUtil.getErrorJson("职务格式不正确");
        }
        if (member.getQq() == null || "".equals(member.getQq()) || !member.getQq().matches(Constant.QQ)) {
            return GsonUtil.getErrorJson("qq格式不正确");
        }
        if (member.getWechat() == null || "".equals(member.getWechat()) || !member.getWechat().matches(Constant.USER_WECHAT_REGULAR_EXPRESSION)) {
            return GsonUtil.getErrorJson("微信格式不正确");
        }

        userDao.insertMember(member); //插入会员
        userDao.insertMemberInfo(member);   //注册基本信息
        userDao.insertMemberContact(member);    //注册联系方式

        session.setAttribute("enterpriseId", member.getEnterpriseId());
        session.setAttribute("memberId", member.getId());
        return GsonUtil.getSuccessJson("注册成功");
    }

    @Transactional
    public String insertRepresentativeWork(HttpSession session, RepresentativeWork representativeWork) {
        Integer enterpriseId = (Integer) session.getAttribute("enterpriseId");
        if (enterpriseId == null) {
            return GsonUtil.getErrorJson("服务器错误");
        }
        System.out.println(representativeWork.getBrand());
        if (representativeWork.getBrand() == null || "".equals(representativeWork.getBrand())) {
            return GsonUtil.getErrorJson("品牌格式不正确");
        }
        if (representativeWork.getVersion() == null || "".equals(representativeWork.getVersion())) {
            return GsonUtil.getErrorJson("版本格式不正确");
        }
        if (representativeWork.getApplicationArea() == null || "".equals(representativeWork.getApplicationArea())) {
            return GsonUtil.getErrorJson("应用领域格式不正确");
        }
        if (representativeWork.getApplicationIndustry() == null || "".equals(representativeWork.getApplicationIndustry())) {
            return GsonUtil.getErrorJson("应用行业格式不正确");
        }
        if (representativeWork.getApplicationScenario() == null || "".equals(representativeWork.getApplicationScenario())) {
            return GsonUtil.getErrorJson("应用场景格式不正确");
        }
        representativeWork.setEnterpriseId(enterpriseId);
        userDao.insertMemberProduct(representativeWork);
        return GsonUtil.getSuccessJson("信息填写完毕");
    }

    public String insertMemberUser(User user) {
        if (ValidateUtil.isInvalidString(user.getUsername()) || ValidateUtil.isInvalidString(user.getPassword()) || ValidateUtil.isInvalidString(user.getEmail())) {
            return GsonUtil.getErrorJson("输入不能为空");
        }
        if (!ValidateUtil.isMatchEmail(user.getEmail())) {
            return GsonUtil.getErrorJson("邮箱格式不正确");
        }
        if (userDao.isExist(user) != 0) {
            return GsonUtil.getErrorJson("用户已存在");
    }
        user.setStatus(User.STATUS_ACCESS);
        user.setPassword(Md5Util.GetMD5Code(user.getPassword()));
        userDao.register(user);
        return GsonUtil.getSuccessJson("用户添加成功");
    }

    public String getMemberInfo() {
        ArrayList<Member> members = userDao.getMemberInfo();
        return GsonUtil.getSuccessJson(members);
    }

    @Transactional
    public String judgeMember(Member member, String status) {
        System.out.println(member);
        System.out.println(status);
        userDao.judgeMember(member);
        userDao.judgeUser(String.valueOf(member.getEnterpriseId()), status);
        return GsonUtil.getSuccessJson("填写完成");
    }
}
