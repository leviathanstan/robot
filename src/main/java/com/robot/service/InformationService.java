package com.robot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.robot.dao.InformationDao;
import com.robot.dao.UserDao;
import com.robot.dto.RelatedReadingDto;
import com.robot.entity.Detail;
import com.robot.entity.RobotNews;
import com.robot.entity.User;
import com.robot.util.CommonUtil;
import com.robot.util.GsonUtil;
import com.robot.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author asce
 * @date 2018/11/11
 */
@Service
public class InformationService {

    @Autowired
    private InformationDao informationDao;
    @Autowired
    private UserDao userDao;

    /**
     * information类别
     */
    private enum InformationEnum {
        PRODUCT_NEWS(1), PRODUCT_RECOMMEND(2), PRODUCT_EVALUATE(3), BASIC_KNOWLEDGE(4), ENTERPRISE_NEWS(5), INDUSTRY_INFORMATION(6),
        POLICY_INFORMATION(7), MEMBER_NEWS(8), NOTICE(9), ASSOCIATION_NEWS(10), EXPERT_WISDOM(11), CONSULTING_FOCUS(12);
        private final int id;

        InformationEnum(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }

    /**
     * 首页information数量
     */
    private enum NumberEnum {
        INFORMATION_NUMBER(15), ASSOCIATION_NUMBER(15), COMPANY_NUMBER(15), PRODUCT_NUMBER(15), KNOWLEDGE(15), EXPERT(15);
        private final int number;

        NumberEnum(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }
    }

    /**
     * 首页information封面要求数量
     */
    private enum CoverEnum {
        PRODUCT_NUMBER(4), KNOWLEDGE_NUMBER(3);
        private final int number;

        CoverEnum(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }
    }

    /**
     * 一列的数量
     */
    private final int PAGE_LENGTH = 12;

    private final int SUBSCRIBE_LENGTH = 15;

    //******************************************管理********************************************//

    /**
     * 添加文章
     * @param robotNews
     * @return
     */
    @Transactional
    public String addInformation(RobotNews robotNews){
        robotNews.setPostDate(LocalDateTime.now().toString());
        if(1!=informationDao.add(robotNews))
            return GsonUtil.getErrorJson();
        if(robotNews.getContent()==null){
            return GsonUtil.getErrorJson("正文内容不能为空");
        }
        for(Detail detail:robotNews.getContent()){
            HashMap map = new HashMap();
            map.put("id",robotNews.getId());
            map.put("content",detail.getContent());
            map.put("page",detail.getPage());
            if(1!=informationDao.addContent(map)) {
                throw new RuntimeException();
            }
        }
        return GsonUtil.getSuccessJson(robotNews);
    }
    /**
     * 删除文章
     * @param ids
     * @return
     */
    @Transactional
    public String deleteInformation(List<Integer> ids){
        int count = ids.size();
        try{
            informationDao.deleteContent(ids);
            if(count!=informationDao.deleteInformation(ids)){
                throw new RuntimeException();
            }
        }catch (Exception e){
            throw new RuntimeException();
        }
        return GsonUtil.getSuccessJson();
    }
    /**
     * 修改文章
     * @param robotNews
     * @return
     */
    @Transactional
    public String updateInformation(RobotNews robotNews){
        if(ValidateUtil.isInvalidString(informationDao.findInformationById(robotNews.getId())))
            return GsonUtil.getErrorJson("修改文章不存在");
        if(informationDao.update(robotNews)<1)
            return GsonUtil.getErrorJson();
        if(robotNews.getContent()!=null&&robotNews.getContent().size()!=0){
            for(Detail detail:robotNews.getContent()) {
                HashMap map = new HashMap();
                if (robotNews.getContent() != null) {
                    map.put("informationId", robotNews.getId());
                    map.put("content", detail.getContent());
                    map.put("page", detail.getPage());
                    try {
                        if (1 != informationDao.updateContent(map)) {
                            throw new RuntimeException();
                        }
                    } catch (Exception e) {
                        throw new RuntimeException();
                    }
                }
            }
        }

        return GsonUtil.getSuccessJson();
    }
    //******************************************搜索********************************************//

    /**
     * 搜索
     * @author asce
     * @date 2018/11/16
     * @param
     * @return
     */
    public PageInfo<RobotNews> findInformation(HashMap<String,String> args){
        int pageNum = CommonUtil.formatPageNum(args.get("pageNum"));
        int category = CommonUtil.formateParmNum(args.get("categoryId"));
        ArrayList<Integer> categoryIds = new ArrayList();
        //先判断是否是分类查找
        switch (category){
            case   0:
                categoryIds.add(InformationEnum.INDUSTRY_INFORMATION.getId());
                categoryIds.add(InformationEnum.CONSULTING_FOCUS.getId());
                categoryIds.add(InformationEnum.POLICY_INFORMATION.getId());
                categoryIds.add(InformationEnum.NOTICE.getId());
                categoryIds.add(InformationEnum.ASSOCIATION_NEWS.getId());
                categoryIds.add(InformationEnum.MEMBER_NEWS.getId());
                categoryIds.add(InformationEnum.ENTERPRISE_NEWS.getId());
                categoryIds.add(InformationEnum.PRODUCT_NEWS.getId());
                categoryIds.add(InformationEnum.PRODUCT_EVALUATE.getId());
                categoryIds.add(InformationEnum.PRODUCT_RECOMMEND.getId());
                categoryIds.add(InformationEnum.BASIC_KNOWLEDGE.getId());
                break;
            case 100:
                categoryIds.add(InformationEnum.INDUSTRY_INFORMATION.getId());
                categoryIds.add(InformationEnum.CONSULTING_FOCUS.getId());
                categoryIds.add(InformationEnum.POLICY_INFORMATION.getId());
                break;
            case 200:
                categoryIds.add(InformationEnum.NOTICE.getId());
                categoryIds.add(InformationEnum.ASSOCIATION_NEWS.getId());
                break;
            case 300:
                categoryIds.add(InformationEnum.MEMBER_NEWS.getId());
                categoryIds.add(InformationEnum.ENTERPRISE_NEWS.getId());
                break;
            case 400:
                categoryIds.add(InformationEnum.PRODUCT_NEWS.getId());
                categoryIds.add(InformationEnum.PRODUCT_EVALUATE.getId());
                categoryIds.add(InformationEnum.PRODUCT_RECOMMEND.getId());
                break;
            case 500:
                categoryIds.add(InformationEnum.BASIC_KNOWLEDGE.getId());
                break;
            default:
                break;
        }
        //如果还是空，则根据具体一个类别查找
        if (categoryIds.size()==0){
            categoryIds.add(category);
        }
        //由于泛型，另外封装一个map
        HashMap<String,Object> dataMap = new HashMap();
        dataMap.put("content",args.get("content"));
        dataMap.put("categoryIds",categoryIds);
        //查找
        PageHelper.startPage(pageNum,PAGE_LENGTH);
        List<RobotNews> informations = informationDao.find(dataMap);
        PageInfo<RobotNews> pageInfo = new PageInfo<>(informations);
        for (RobotNews information : informations) {
            information.setContent(CommonUtil.getPreview(information.getContent()));
            information.setPostDate(CommonUtil.formateDbTime(information.getPostDate()));
        }
        return pageInfo;
    }

    /**
     * information搜索总数
     * @param content
     * @return
     */
    public int getSearchCount(String content){
        return informationDao.searchCount(content);
    }

    /**
     * 获得不同分类下的搜索结果总数
     * @author asce
     * @date 2018/11/16
     * @param
     * @return
     */
    public HashMap<String,Integer> getCategoryCount(String content){
        HashMap map = new HashMap();
        HashMap countMap = new HashMap();
        map.put("content", content);
        ArrayList categoryIds = new ArrayList();
        //资讯
        categoryIds.add(InformationEnum.INDUSTRY_INFORMATION.getId());
        categoryIds.add(InformationEnum.CONSULTING_FOCUS.getId());
        categoryIds.add(InformationEnum.POLICY_INFORMATION.getId());
        map.put("categoryIds",categoryIds);
        countMap.put("informationCount",informationDao.searchCategoryCount(map));
        map.remove("categoryIds");
        categoryIds.clear();
        //协会
        categoryIds.add(InformationEnum.NOTICE.getId());
        categoryIds.add(InformationEnum.ASSOCIATION_NEWS.getId());
        map.put("categoryIds",categoryIds);
        countMap.put("associationCount",informationDao.searchCategoryCount(map));
        map.remove("categoryIds");
        categoryIds.clear();
        //企业
        categoryIds.add(InformationEnum.MEMBER_NEWS.getId());
        categoryIds.add(InformationEnum.ENTERPRISE_NEWS.getId());
        map.put("categoryIds",categoryIds);
        countMap.put("companyCount",informationDao.searchCategoryCount(map));
        map.remove("categoryIds");
        categoryIds.clear();
        //产品
        categoryIds.add(InformationEnum.PRODUCT_NEWS.getId());
        categoryIds.add(InformationEnum.PRODUCT_EVALUATE.getId());
        categoryIds.add(InformationEnum.PRODUCT_RECOMMEND.getId());
        map.put("categoryIds",categoryIds);
        countMap.put("productCount",informationDao.searchCategoryCount(map));
        map.remove("categoryIds");
        categoryIds.clear();
        //技术
        categoryIds.add(InformationEnum.BASIC_KNOWLEDGE.getId());
        map.put("categoryIds",categoryIds);
        countMap.put("knowledgeCount",informationDao.searchCategoryCount(map));
        map.remove("categoryIds");
        categoryIds.clear();
        return countMap;
    }
    //******************************************订阅内容********************************************//
    /**
     * 获取订阅内容
     * @author asce
     * @date 2018/11/28
     * @param
     * @return
     */
    public String getIndexSubscribe(HttpSession session){
        User user = (User) session.getAttribute("user");
        ArrayList<RobotNews> information = new ArrayList<>();
        ArrayList<Integer> categoryIds = userDao.getUserSubscribe(user.getId());
        Map<String,Integer> map = new HashMap<>();
        if(categoryIds!=null&&categoryIds.size()!=0){
            int average = SUBSCRIBE_LENGTH / categoryIds.size();
            int remainder = SUBSCRIBE_LENGTH % categoryIds.size();
            for(int i = 0;i<categoryIds.size();i++){
                int categoryId = categoryIds.get(i);
                if(i==0){
                    map.put("number",average+remainder);
                }else{
                    map.put("number",average);
                }
                map.put("categoryId", categoryId);
                information.addAll(informationDao.getIndexInformation(map));
            }
        }else{
            return GsonUtil.getSuccessJson();
        }
        CommonUtil.formateDateTimeToDate(information);
        return GsonUtil.getSuccessJson(information);
    }

    //******************************************协会********************************************//

    /**
     * 获取行业动态的具体内容
     *
     * @param id
     * @return
     * @author hua
     * @date 2018/9/24
     */
    public String findInformationInfo(String id) {
        int infoId;
        if ((infoId = CommonUtil.formatPageNum(id)) == 0) return GsonUtil.getErrorJson();
        RobotNews information = informationDao.findInformationInfo(infoId);
        if (information == null) {
            return GsonUtil.getErrorJson();
        }
        if(1 != informationDao.addCount(infoId))
            throw new RuntimeException();
        information.setPostDate(CommonUtil.formateDbTime(information.getPostDate()));
        information.setContent(CommonUtil.getAbsolutePath(information.getContent()));
        RelatedReadingDto relatedReadingDto = new RelatedReadingDto();
        relatedReadingDto.setKeywords(informationDao.findRelatedKeyword(infoId));
        relatedReadingDto.setInformation(informationDao.findRelatedInformation(infoId));
        Map<String,Object> dataMap = new HashMap();
        dataMap.put("information", information);
        dataMap.put("related", relatedReadingDto);
        return GsonUtil.getSuccessJson(dataMap);
    }

    /**
     * 获取首页行业动态
     *
     * @return
     * @author hua
     * @date 2018/10/17
     */
    public ArrayList<RobotNews> findInformationTop() {
        Map<String, Integer> map = new HashMap<>();
        map.put("number", NumberEnum.INFORMATION_NUMBER.getNumber());
        map.put("categoryId", InformationEnum.INDUSTRY_INFORMATION.getId());
        ArrayList<RobotNews> informations = informationDao.getIndexInformation(map);
        for (RobotNews robotNews : informations) {
            robotNews.setImg(CommonUtil.getFirstImgFromContent(informationDao.findInformationInfo(robotNews.getId()).getContent()));
        }
        CommonUtil.formateDateTimeToDate(informations);
        return informations;
    }

    /**
     * 行业动态列表
     *
     * @param Num
     * @return
     */
    public String findInformationByPage(Integer Num) {
        int pageNum = CommonUtil.formatPageNum(Num + "");
        PageHelper.startPage(pageNum, PAGE_LENGTH);
        List<RobotNews> informations = informationDao.getInformationList(InformationEnum.INDUSTRY_INFORMATION.getId());
        PageInfo<RobotNews> pageInfo = new PageInfo<>(informations);
        for (RobotNews information : informations) {
            information.setPostDate(CommonUtil.formateDbTime(information.getPostDate()));
            information.setContent(CommonUtil.getPreview(information.getContent()));
        }
        return GsonUtil.getSuccessJson(GsonUtil.getFilterJson(RobotNews.class, "url"), pageInfo);
    }

    /**
     * 获取政策的具体内容
     *
     * @param id
     * @return
     * @author hua
     * @date 2018/10/22
     */
    public String findPolicyInfo(int id) {
        RobotNews information = informationDao.findInformationInfo(id);
        if (information == null) {
            return GsonUtil.getErrorJson();
        }
        if(1 != informationDao.addCount(id))
            throw new RuntimeException();
        information.setPostDate(CommonUtil.formateDbTime(information.getPostDate()));
        information.setContent(CommonUtil.getAbsolutePath(information.getContent()));
        RelatedReadingDto relatedReadingDto = new RelatedReadingDto();
        relatedReadingDto.setKeywords(informationDao.findRelatedKeyword(id));
        relatedReadingDto.setInformation(informationDao.findRelatedInformation(id));
        Map<String,Object> dataMap = new HashMap();
        dataMap.put("information", information);
        dataMap.put("related", relatedReadingDto);
        return GsonUtil.getSuccessJson(dataMap);
    }

    /**
     * 获取政策的前12条
     *
     * @return
     * @author hua
     * @date 2018/10/22
     */
    public ArrayList<RobotNews> findPolicyTop() {
        Map<String, Integer> map = new HashMap<>();
        map.put("number", NumberEnum.INFORMATION_NUMBER.getNumber());
        map.put("categoryId", InformationEnum.POLICY_INFORMATION.getId());
        ArrayList<RobotNews> informations = informationDao.getIndexInformation(map);
        for (RobotNews robotNews : informations) {
            robotNews.setImg(CommonUtil.getFirstImgFromContent(informationDao.findInformationInfo(robotNews.getId()).getContent()));
        }
        CommonUtil.formateDateTimeToDate(informations);
        return informations;
    }

    /**
     * 获取分页显示的政策
     *
     * @param Num
     * @return
     * @author hua
     * @date 2018/10/22
     */
    public String findPolicyByPage(Integer Num) {
        int pageNum = CommonUtil.formatPageNum(Num + "");
        PageHelper.startPage(pageNum, PAGE_LENGTH);
        List<RobotNews> informations = informationDao.getInformationList(InformationEnum.POLICY_INFORMATION.getId());
        PageInfo<RobotNews> pageInfo = new PageInfo<>(informations);
        for (RobotNews information : informations) {
            information.setPostDate(CommonUtil.formateDbTime(information.getPostDate()));
            information.setContent(CommonUtil.getPreview(information.getContent()));
        }
        return GsonUtil.getSuccessJson(GsonUtil.getFilterJson(RobotNews.class, "url"), pageInfo);
    }

    /**
     * 首页资讯热点
     *
     * @return
     */
    public ArrayList<RobotNews> getIndexHot() {
        Map<String, Integer> map = new HashMap<>();
        map.put("number", NumberEnum.INFORMATION_NUMBER.getNumber());
        map.put("categoryId", InformationEnum.CONSULTING_FOCUS.getId());
        ArrayList<RobotNews> informations = informationDao.getIndexInformation(map);
        CommonUtil.formateDateTimeToDate(informations);
        return informations;
    }

    /**
     * 资讯热点具体内容
     * @param id
     * @return
     * @author hua
     * @date 2018/10/22
     */
    public String findHotInfo(String id) {
        int infoId;
        if ((infoId = CommonUtil.formatPageNum(id)) == 0) return GsonUtil.getErrorJson();
        RobotNews information = informationDao.findInformationInfo(infoId);
        information.setPostDate(CommonUtil.formateDbTime(information.getPostDate()));
        if (information == null) {
            return GsonUtil.getErrorJson();
        }
        if(1 != informationDao.addCount(infoId))
            throw new RuntimeException();
        RelatedReadingDto relatedReadingDto = new RelatedReadingDto();
        relatedReadingDto.setKeywords(informationDao.findRelatedKeyword(infoId));
        relatedReadingDto.setInformation(informationDao.findRelatedInformation(infoId));
        Map<String,Object> dataMap = new HashMap();
        dataMap.put("information", information);
        dataMap.put("related", relatedReadingDto);
        return GsonUtil.getSuccessJson(dataMap);
    }
    //******************************************协会********************************************//

    /**
     * 获取协会动态详细信息
     *
     * @param id
     * @return
     * @author hua
     * @date 2018/10/11
     */
    public String getAssociationNewsInfo(String id) {
        int infoId;
        if ((infoId = CommonUtil.formatPageNum(id)) == 0) return GsonUtil.getErrorJson();
        RobotNews information = informationDao.findInformationInfo(infoId);
        if (information != null) {
            if(1 != informationDao.addCount(infoId)) {
                throw new RuntimeException();
            }
            information.setContent(CommonUtil.getAbsolutePath(information.getContent()));
            information.setPostDate(CommonUtil.formateDbTime(information.getPostDate()));
            RelatedReadingDto relatedReadingDto = new RelatedReadingDto();
            relatedReadingDto.setKeywords(informationDao.findRelatedKeyword(infoId));
            relatedReadingDto.setInformation(informationDao.findRelatedInformation(infoId));
            Map<String,Object> dataMap = new HashMap();
            dataMap.put("information", information);
            dataMap.put("related", relatedReadingDto);
            return GsonUtil.getSuccessJson(dataMap);
        } else
            return GsonUtil.getErrorJson();
    }

    /**
     * 协会动态列表
     *
     * @param
     * @return
     */
    public String getAssociationNewsList(String page) {
        int pageNum = CommonUtil.formatPageNum(page);
        PageHelper.startPage(pageNum, PAGE_LENGTH);
        List<RobotNews> news = informationDao.getInformationList(InformationEnum.ASSOCIATION_NEWS.getId());
        PageInfo<RobotNews> pageInfo = new PageInfo<>(news);
        for (RobotNews news1 : news) {
            news1.setPostDate(CommonUtil.formateDbTime(news1.getPostDate()));
            news1.setContent(CommonUtil.getPreview(news1.getContent()));
        }
        return GsonUtil.getSuccessJson(pageInfo);
    }

    /**
     * 首页协会动态
     *
     * @return
     */
    public List<RobotNews> getIndexAssociationNews() {
        Map<String, Integer> map = new HashMap<>();
        map.put("number", NumberEnum.ASSOCIATION_NUMBER.getNumber());
        map.put("categoryId", InformationEnum.ASSOCIATION_NEWS.getId());
        ArrayList<RobotNews> informations = informationDao.getIndexInformation(map);
        for (RobotNews robotNews : informations) {
            robotNews.setImg(CommonUtil.getFirstImgFromContent(informationDao.findInformationInfo(robotNews.getId()).getContent()));
        }
        CommonUtil.formateDateTimeToDate(informations);
        return informations;
    }

    /**
     * 首页公告
     *
     * @return
     */
    public List<RobotNews> getIndexNotice() {
        Map<String, Integer> map = new HashMap<>();
        map.put("number", NumberEnum.ASSOCIATION_NUMBER.getNumber());
        map.put("categoryId", InformationEnum.NOTICE.getId());
        ArrayList<RobotNews> informations = informationDao.getIndexInformation(map);
        for (RobotNews robotNews : informations) {
            robotNews.setImg(CommonUtil.getFirstImgFromContent(informationDao.findInformationInfo(robotNews.getId()).getContent()));
        }
        CommonUtil.formateDateTimeToDate(informations);
        return informations;
    }

    /**
     * 公告列表
     *
     * @param page
     * @return
     * @author asce
     * @date 2018/10/12
     */
    public String getNoticeList(String page) {
        int pageNum = CommonUtil.formatPageNum(page);
        PageHelper.startPage(pageNum, PAGE_LENGTH);
        List<RobotNews> notices = informationDao.getInformationList(InformationEnum.NOTICE.getId());
        PageInfo<RobotNews> pageInfo = new PageInfo<>(notices);
        for (RobotNews notice : notices) {
            notice.setPostDate(CommonUtil.formateDbTime(notice.getPostDate()));
            notice.setContent(CommonUtil.getPreview(notice.getContent()));
        }
        return GsonUtil.getSuccessJson(pageInfo);
    }

    /**
     * 公告详细信息
     *
     * @param id
     * @return
     */
    public String getNoticeInfo(String id) {
        int infoId;
        if ((infoId = CommonUtil.formatPageNum(id)) == 0) return GsonUtil.getErrorJson();
        RobotNews information = informationDao.findInformationInfo(infoId);
        if (information == null)
            return GsonUtil.getErrorJson();
        if(1 != informationDao.addCount(infoId))
            throw new RuntimeException();
        information.setPostDate(CommonUtil.formateDbTime(information.getPostDate()));
        information.setContent(CommonUtil.getAbsolutePath(information.getContent()));
        RelatedReadingDto relatedReadingDto = new RelatedReadingDto();
        relatedReadingDto.setKeywords(informationDao.findRelatedKeyword(infoId));
        relatedReadingDto.setInformation(informationDao.findRelatedInformation(infoId));
        Map<String,Object> dataMap = new HashMap();
        dataMap.put("information", information);
        dataMap.put("related", relatedReadingDto);
        return GsonUtil.getSuccessJson(dataMap);
    }
    //******************************************企业********************************************//

    /**
     * 企业新闻(首页)
     */
    public ArrayList<RobotNews> getCompanyNews() {
        Map<String, Integer> map = new HashMap<>();
        map.put("number", NumberEnum.COMPANY_NUMBER.getNumber());
        map.put("categoryId", InformationEnum.ENTERPRISE_NEWS.getId());
        ArrayList<RobotNews> companyNews = informationDao.getIndexInformation(map);
        if (CommonUtil.judgeCover(companyNews, CoverEnum.KNOWLEDGE_NUMBER.getNumber())) {
            map.put("number", CoverEnum.KNOWLEDGE_NUMBER.getNumber());
            companyNews.addAll(informationDao.getIndexCover(map));
        }
        CommonUtil.formateDateTimeToDate(companyNews);
        return companyNews;
    }

    /**
     * 企业新闻列表
     */
    public String getCompanyNewsList(String pageNum) {
        int page = CommonUtil.formatPageNum(pageNum);
        PageHelper.startPage(page, PAGE_LENGTH);
        ArrayList<RobotNews> companyNewsList = informationDao.getInformationList(InformationEnum.ENTERPRISE_NEWS.getId());
        for (RobotNews robotNews : companyNewsList) {
            robotNews.setPostDate(CommonUtil.formateDbTime(robotNews.getPostDate()));
        }
        PageInfo<RobotNews> pageInfo = new PageInfo<>(companyNewsList);
        return GsonUtil.getSuccessJson(pageInfo);
    }

    /**
     * 企业新闻具体信息
     */
    public String getCompanyNewsInfo(String id) {
        int infoId;
        if ((infoId = CommonUtil.formatPageNum(id)) == 0) return GsonUtil.getErrorJson();
        RobotNews information = informationDao.findInformationInfo(infoId);
        if (information == null)
            return GsonUtil.getErrorJson();
        if(1 != informationDao.addCount(infoId))
            throw new RuntimeException();
        information.setPostDate(CommonUtil.formateDbTime(information.getPostDate()));
        information.setContent(CommonUtil.getAbsolutePath(information.getContent()));
        //相关
        RelatedReadingDto relatedReadingDto = new RelatedReadingDto();
        relatedReadingDto.setKeywords(informationDao.findRelatedKeyword(infoId));
        relatedReadingDto.setInformation(informationDao.findRelatedInformation(infoId));
        Map<String,Object> dataMap = new HashMap();
        dataMap.put("information", information);
        dataMap.put("related", relatedReadingDto);
        return GsonUtil.getSuccessJson(dataMap);
    }

    /**
     * 会员动态(首页)
     */
    public ArrayList<RobotNews> getCompanyDynamics() {
        Map<String, Integer> map = new HashMap<>();
        map.put("number", NumberEnum.COMPANY_NUMBER.getNumber());
        map.put("categoryId", InformationEnum.MEMBER_NEWS.getId());
        ArrayList<RobotNews> companyNews = informationDao.getIndexInformation(map);
        for (RobotNews robotNews : companyNews) {
            robotNews.setImg(CommonUtil.getFirstImgFromContent(informationDao.findInformationInfo(robotNews.getId()).getContent()));
        }
        CommonUtil.formateDateTimeToDate(companyNews);
        return companyNews;
    }

    /**
     * 会员动态列表
     */
    public String getCompanyDynamicsList(String pageNum) {
        int page = CommonUtil.formatPageNum(pageNum);
        PageHelper.startPage(page, PAGE_LENGTH);
        ArrayList<RobotNews> companyNewsList = informationDao.getInformationList(InformationEnum.MEMBER_NEWS.getId());
        for (RobotNews robotNews : companyNewsList) {
            robotNews.setPostDate(CommonUtil.formateDbTime(robotNews.getPostDate()));
        }
        PageInfo<RobotNews> pageInfo = new PageInfo<>(companyNewsList);
        return GsonUtil.getSuccessJson(pageInfo);
    }

    /**
     * 会员动态具体信息
     */
    public String getCompanyDynamicsInfo(String id) {
        int infoId;
        if ((infoId = CommonUtil.formatPageNum(id)) == 0) return GsonUtil.getErrorJson();
        RobotNews information = informationDao.findInformationInfo(infoId);
        if (information == null)
            return GsonUtil.getErrorJson();
        if(1 != informationDao.addCount(infoId))
            throw new RuntimeException();
        information.setPostDate(CommonUtil.formateDbTime(information.getPostDate()));
        //相关
        RelatedReadingDto relatedReadingDto = new RelatedReadingDto();
        relatedReadingDto.setKeywords(informationDao.findRelatedKeyword(infoId));
        relatedReadingDto.setInformation(informationDao.findRelatedInformation(infoId));
        Map<String,Object> dataMap = new HashMap();
        dataMap.put("information", information);
        dataMap.put("related", relatedReadingDto);
        return GsonUtil.getSuccessJson(dataMap);
    }
    //***************************技术********************************//

    /**
     * 首页基础知识
     *
     * @param
     * @return
     * @author asce
     * @date 2018/11/2
     */
    public List<RobotNews> getIndexBasic() {
        Map<String, Integer> map = new HashMap<>();
        map.put("number", NumberEnum.KNOWLEDGE.getNumber());
        map.put("categoryId", InformationEnum.BASIC_KNOWLEDGE.getId());
        ArrayList<RobotNews> basices = informationDao.getIndexInformation(map);
        if (CommonUtil.judgeCover(basices, CoverEnum.KNOWLEDGE_NUMBER.getNumber())) {
            map.put("number", CoverEnum.KNOWLEDGE_NUMBER.getNumber());
            basices.addAll(informationDao.getIndexCover(map));
        }
        CommonUtil.formateDateTimeToDate(basices);
        return basices;
    }

    /**
     * 基础知识列表
     */
    public String getBasicList(String pageNum) {
        int page = CommonUtil.formatPageNum(pageNum);
        PageHelper.startPage(page, PAGE_LENGTH);
        ArrayList<RobotNews> companyNewsList = informationDao.getInformationList(InformationEnum.BASIC_KNOWLEDGE.getId());
        for (RobotNews robotNews : companyNewsList) {
            robotNews.setPostDate(CommonUtil.formateDbTime(robotNews.getPostDate()));
        }
        PageInfo<RobotNews> pageInfo = new PageInfo<>(companyNewsList);
        return GsonUtil.getSuccessJson(pageInfo);
    }

    /**
     * 基础知识具体信息
     */
    public String getBasicInfo(String id) {
        int infoId;
        if ((infoId = CommonUtil.formatPageNum(id)) == 0) return GsonUtil.getErrorJson();
        RobotNews information = informationDao.findInformationInfo(infoId);
        if (information == null)
            return GsonUtil.getErrorJson();
        if(1 != informationDao.addCount(infoId))
            throw new RuntimeException();
        information.setPostDate(CommonUtil.formateDbTime(information.getPostDate()));
        //相关
        RelatedReadingDto relatedReadingDto = new RelatedReadingDto();
        relatedReadingDto.setKeywords(informationDao.findRelatedKeyword(infoId));
        relatedReadingDto.setInformation(informationDao.findRelatedInformation(infoId));
        Map<String,Object> dataMap = new HashMap();
        dataMap.put("information", information);
        dataMap.put("related", relatedReadingDto);
        return GsonUtil.getSuccessJson(dataMap);
    }
    //*************************产品****************************//

    /**
     * 首页产品评测
     *
     * @return java.lang.String
     * @data 2018/10/24
     */
    public ArrayList<RobotNews> getIndexEvaluate() {
        Map<String, Integer> map = new HashMap<>();
        map.put("number", NumberEnum.PRODUCT_NUMBER.getNumber());
        map.put("categoryId", InformationEnum.PRODUCT_EVALUATE.getId());
        ArrayList<RobotNews> evaluation = informationDao.getIndexInformation(map);
        if (CommonUtil.judgeCover(evaluation, CoverEnum.PRODUCT_NUMBER.getNumber())) {
            map.put("number", CoverEnum.PRODUCT_NUMBER.getNumber());
            evaluation.addAll(informationDao.getIndexCover(map));
        }
        CommonUtil.formateDateTimeToDate(evaluation);
        return evaluation;
    }

    /**
     * 产品评测列表
     */
    public String getEvaluateList(String pageNum) {
        int page = CommonUtil.formatPageNum(pageNum);
        PageHelper.startPage(page, PAGE_LENGTH);
        ArrayList<RobotNews> companyNewsList = informationDao.getInformationList(InformationEnum.PRODUCT_EVALUATE.getId());
        PageInfo<RobotNews> pageInfo = new PageInfo<>(companyNewsList);
        for (RobotNews robotNews : companyNewsList) {
            robotNews.setPostDate(CommonUtil.formateDbTime(robotNews.getPostDate()));
        }
        return GsonUtil.getSuccessJson(pageInfo);
    }

    /**
     * 产品评测具体信息
     */
    public String getEvaluateInfo(String id) {
        int infoId;
        if ((infoId = CommonUtil.formatPageNum(id)) == 0) return GsonUtil.getErrorJson();
        RobotNews information = informationDao.findInformationInfo(infoId);
        if (information == null)
            return GsonUtil.getErrorJson();
        if(1 != informationDao.addCount(infoId))
            throw new RuntimeException();
        information.setPostDate(CommonUtil.formateDbTime(information.getPostDate()));
        //相关
        RelatedReadingDto relatedReadingDto = new RelatedReadingDto();
        relatedReadingDto.setKeywords(informationDao.findRelatedKeyword(infoId));
        relatedReadingDto.setInformation(informationDao.findRelatedInformation(infoId));
        Map<String,Object> dataMap = new HashMap();
        dataMap.put("information", information);
        dataMap.put("related", relatedReadingDto);
        return GsonUtil.getSuccessJson(dataMap);
    }

    /**
     * 首页产品新闻
     *
     * @param
     * @return
     * @author asce
     * @date 2018/10/25
     */
    public ArrayList<RobotNews> getIndexProductNews() {
        Map<String, Integer> map = new HashMap<>();
        map.put("number", NumberEnum.PRODUCT_NUMBER.getNumber());
        map.put("categoryId", InformationEnum.PRODUCT_NEWS.getId());
        ArrayList<RobotNews> news = informationDao.getIndexInformation(map);
        if (CommonUtil.judgeCover(news, CoverEnum.PRODUCT_NUMBER.getNumber())) {
            map.put("number", CoverEnum.PRODUCT_NUMBER.getNumber());
            news.addAll(informationDao.getIndexCover(map));
        }
        CommonUtil.formateDateTimeToDate(news);
        return news;
    }

    /**
     * 产品新闻列表
     */
    public String getProductNewsList(String pageNum) {
        int page = CommonUtil.formatPageNum(pageNum);
        PageHelper.startPage(page, PAGE_LENGTH);
        ArrayList<RobotNews> companyNewsList = informationDao.getInformationList(InformationEnum.PRODUCT_NEWS.getId());
        PageInfo<RobotNews> pageInfo = new PageInfo<>(companyNewsList);
        for (RobotNews robotNews : companyNewsList) {
            robotNews.setPostDate(CommonUtil.formateDbTime(robotNews.getPostDate()));
        }
        return GsonUtil.getSuccessJson(pageInfo);
    }

    /**
     * 产品新闻具体信息
     */
    public String getProductNewsInfo(String id) {
        int infoId;
        if ((infoId = CommonUtil.formatPageNum(id)) == 0) return GsonUtil.getErrorJson();
        RobotNews information = informationDao.findInformationInfo(infoId);
        if (information == null)
            return GsonUtil.getErrorJson();
        if(1 != informationDao.addCount(infoId))
            throw new RuntimeException();
        information.setPostDate(CommonUtil.formateDbTime(information.getPostDate()));
        //相关
        RelatedReadingDto relatedReadingDto = new RelatedReadingDto();
        relatedReadingDto.setKeywords(informationDao.findRelatedKeyword(infoId));
        relatedReadingDto.setInformation(informationDao.findRelatedInformation(infoId));
        Map<String,Object> dataMap = new HashMap();
        dataMap.put("information", information);
        dataMap.put("related", relatedReadingDto);
        return GsonUtil.getSuccessJson(dataMap);
    }

    /**
     * 首页产品推荐
     *
     * @param
     * @return
     * @author asce
     * @date 2018/10/25
     */
    public ArrayList<RobotNews> getIndexRecommend() {
        Map<String, Integer> map = new HashMap<>();
        map.put("number", NumberEnum.PRODUCT_NUMBER.getNumber());
        map.put("categoryId", InformationEnum.PRODUCT_RECOMMEND.getId());
        ArrayList<RobotNews> recommend = informationDao.getIndexInformation(map);
        if (CommonUtil.judgeCover(recommend, CoverEnum.PRODUCT_NUMBER.getNumber())) {
            map.put("number", CoverEnum.PRODUCT_NUMBER.getNumber());
            recommend.addAll(informationDao.getIndexCover(map));
        }
        CommonUtil.formateDateTimeToDate(recommend);
        return recommend;
    }

    /**
     * 产品推荐列表
     */
    public String getRecommendList(String pageNum) {
        int page = CommonUtil.formatPageNum(pageNum);
        PageHelper.startPage(page, PAGE_LENGTH);
        ArrayList<RobotNews> companyNewsList = informationDao.getInformationList(InformationEnum.PRODUCT_RECOMMEND.getId());
        PageInfo<RobotNews> pageInfo = new PageInfo<>(companyNewsList);
        for (RobotNews robotNews : companyNewsList) {
            robotNews.setPostDate(CommonUtil.formateDbTime(robotNews.getPostDate()));
        }
        return GsonUtil.getSuccessJson(pageInfo);
    }

    /**
     * 产品推荐具体信息
     */
    public String getRecommendInfo(String id) {
        int infoId;
        if ((infoId = CommonUtil.formatPageNum(id)) == 0) return GsonUtil.getErrorJson();
        RobotNews information = informationDao.findInformationInfo(infoId);
        if (information == null)
            return GsonUtil.getErrorJson();
        if(1 != informationDao.addCount(infoId))
            throw new RuntimeException();
        information.setPostDate(CommonUtil.formateDbTime(information.getPostDate()));
        //相关
        RelatedReadingDto relatedReadingDto = new RelatedReadingDto();
        relatedReadingDto.setKeywords(informationDao.findRelatedKeyword(infoId));
        relatedReadingDto.setInformation(informationDao.findRelatedInformation(infoId));
        Map<String,Object> dataMap = new HashMap();
        dataMap.put("information", information);
        dataMap.put("related", relatedReadingDto);
        return GsonUtil.getSuccessJson(dataMap);
    }
    //*************************专家智点****************************//

    /**
     * 首页专家智点
     *
     * @return
     * @author hua
     * @date 2018/9/27
     */
    public ArrayList<RobotNews> getIndexExpertArt() {
        Map<String, Integer> map = new HashMap<>();
        map.put("number", NumberEnum.EXPERT.getNumber());
        map.put("categoryId", InformationEnum.EXPERT_WISDOM.getId());
        ArrayList<RobotNews> articles = informationDao.getIndexInformation(map);
        CommonUtil.formateDateTimeToDate(articles);
        return articles;
    }

    /**
     * 获取专家智点具体信息
     *
     * @param id
     * @return
     */
    public String getExpertArtInfo(String id) {
        int infoId;
        if ((infoId = CommonUtil.formatPageNum(id)) == 0) return GsonUtil.getErrorJson();
        RobotNews information = informationDao.findInformationInfo(infoId);
        if (null == information)
            return GsonUtil.getErrorJson();
        information.setContent(CommonUtil.getAbsolutePath(information.getContent()));
        information.setPostDate(CommonUtil.formateDbTime(information.getPostDate()));
        //相关
        RelatedReadingDto relatedReadingDto = new RelatedReadingDto();
        relatedReadingDto.setKeywords(informationDao.findRelatedKeyword(infoId));
        relatedReadingDto.setInformation(informationDao.findRelatedInformation(infoId));
        Map<String,Object> dataMap = new HashMap();
        dataMap.put("information", information);
        dataMap.put("related", relatedReadingDto);
        return GsonUtil.getSuccessJson(dataMap);
    }

    /**
     * 专家智点列表
     *
     * @param Num
     * @return
     */
    public String getExpertArtList(String Num) {
        int pageNum = CommonUtil.formatPageNum(Num);
        PageHelper.startPage(pageNum, PAGE_LENGTH);
        List<RobotNews> articles = informationDao.getInformationList(InformationEnum.EXPERT_WISDOM.getId());
        PageInfo<RobotNews> pageInfo = new PageInfo<>(articles);
        for (RobotNews article : articles) {
            article.setContent(CommonUtil.getPreview(article.getContent()));
            article.setPostDate(CommonUtil.formateDbTime(article.getPostDate()));
        }
        return GsonUtil.getSuccessJson(GsonUtil.getFilterJson(RobotNews.class, "url"), pageInfo);
    }

    //************************行业报告**********************************************//
    /**
     * 首页行业报告
     * @author hua
     * @date 2018/9/27
     * @return
     */
//    public ArrayList<RobotNews> getIndexReport(){
//        ArrayList<RobotNews> reports = informationDao.(map);
//        return reports;
//    }

    //************************技术研讨**********************************************//
    /**
     * 首页技术研讨
     * @author hua
     * @date 2018/9/27
     * @return
     */
    public ArrayList<RobotNews> getIndexDiscuss(){
        ArrayList<RobotNews> discuss = informationDao.getIndexDiscuss();
        return discuss;
    }

    //************************案列库************************************************//
    /**
     * 首页案列库
     * @author hua
     * @date 2018/9/27
     * @return
     */
//    public ArrayList<RobotNews> getIndexCase(){
//        Map<String,Integer> map = new HashMap<>();
//        map.put("number",NumberEnum.EXPERT.getNumber());
//        map.put("categoryId",InformationEnum.EXPERT_WISDOM.getId());
//        ArrayList<RobotNews> articles = informationDao.getIndexInformation(map);
//        return articles;
//    }

    /**
     * 获取资讯具体信息【安卓】
     * @author asce
     * @date 2018/12/4
     * @param
     * @return
     */
    public String getInformationDetail(int id){
        RobotNews information = informationDao.findInformationInfo(id);
        if (null == information)
            return GsonUtil.getErrorJson();
        information.setContent(CommonUtil.getAbsolutePath(information.getContent()));
        information.setPostDate(CommonUtil.formateDbTime(information.getPostDate()));
        //相关
        RelatedReadingDto relatedReadingDto = new RelatedReadingDto();
        relatedReadingDto.setKeywords(informationDao.findRelatedKeyword(id));
        relatedReadingDto.setInformation(informationDao.findRelatedInformation(id));
        Map<String,Object> dataMap = new HashMap();
        dataMap.put("information", information);
        dataMap.put("related", relatedReadingDto);
        return GsonUtil.getSuccessJson(dataMap);
    }


}
