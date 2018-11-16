package com.robot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.robot.dao.InformationDao;
import com.robot.entity.Detail;
import com.robot.entity.RobotNews;
import com.robot.util.CommonUtil;
import com.robot.util.Constant;
import com.robot.util.GsonUtil;
import com.robot.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author asce
 * @date 2018/11/11
 */
@Service
public class InformationService {

    @Autowired
    private InformationDao informationDao;

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
        INFORMATION_NUMBER(8), ASSOCIATION_NUMBER(13), COMPANY_NUMBER(12), PRODUCT_NUMBER(14), KNOWLEDGE(14), EXPERT(14);
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

    //******************************************管理********************************************//

    public PageInfo<RobotNews> findInformation(HashMap<String,String> args){
        int pageNum = CommonUtil.formatPageNum(args.get("pageNum"));
        PageHelper.startPage(pageNum,PAGE_LENGTH);
        List<RobotNews> information = informationDao.find(args);
        PageInfo<RobotNews> pageInfo = new PageInfo<>(information);
        return pageInfo;
    }

    public int getSearchCount(String content){
        return informationDao.searchCount(content);
    }

    public HashMap<String,Integer> getCategoryCount(String content){
        return informationDao.searchCategoryCount(content);
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
    public String findInformationInfo(int id) {
        RobotNews information = informationDao.findInformationInfo(id);
        if (information == null) {
            return GsonUtil.getErrorJson();
        }
        information.setContent(CommonUtil.getAbsolutePath(information.getContent()));
        return GsonUtil.getSuccessJson(information);
    }

    /**
     * 获取行业动态的前八条
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
        information.setContent(CommonUtil.getAbsolutePath(information.getContent()));
        return GsonUtil.getSuccessJson(information);
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
        map.put("categoryId", InformationEnum.INDUSTRY_INFORMATION.getId());
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
     *
     * @param id
     * @return
     * @author hua
     * @date 2018/10/22
     */
    public String findHotInfo(String id) {
        int infoId;
        if ((infoId = CommonUtil.formatPageNum(id)) == 0) return GsonUtil.getErrorJson();
        RobotNews information = informationDao.findInformationInfo(infoId);
        if (information == null) {
            return GsonUtil.getErrorJson();
        }
        return GsonUtil.getSuccessJson(information);
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
        RobotNews robotNews = informationDao.findInformationInfo(infoId);
        if (robotNews != null) {
            robotNews.setContent(CommonUtil.getAbsolutePath(robotNews.getContent()));
            return GsonUtil.getSuccessJson(robotNews);
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
        ArrayList<RobotNews> informations = informationDao.getIndexInformation(map);;
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
        RobotNews notice = informationDao.findInformationInfo(infoId);
        if (notice == null)
            return GsonUtil.getErrorJson();
        notice.setContent(CommonUtil.getAbsolutePath(notice.getContent()));
        return GsonUtil.getSuccessJson(notice);
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
            robotNews.setPostDate(CommonUtil.getDate(robotNews.getPostDate()));
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
        RobotNews news = informationDao.findInformationInfo(infoId);
        if (news == null)
            return GsonUtil.getErrorJson();
        news.setContent(CommonUtil.getAbsolutePath(news.getContent()));
        return GsonUtil.getSuccessJson(news);
    }

    /**
     * 会员动态(首页)
     */
    public ArrayList<RobotNews> getCompanyDynamics() {
        Map<String, Integer> map = new HashMap<>();
        map.put("number", NumberEnum.COMPANY_NUMBER.getNumber());
        map.put("categoryId", InformationEnum.MEMBER_NEWS.getId());
        ArrayList<RobotNews> companyNews = informationDao.getIndexInformation(map);
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
            robotNews.setPostDate(CommonUtil.getDate(robotNews.getPostDate()));
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
        RobotNews news = informationDao.findInformationInfo(infoId);
        if (news == null)
            return GsonUtil.getErrorJson();
        return GsonUtil.getSuccessJson(news);
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
            robotNews.setPostDate(CommonUtil.getDate(robotNews.getPostDate()));
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
        RobotNews news = informationDao.findInformationInfo(infoId);
        if (news == null)
            return GsonUtil.getErrorJson();
        return GsonUtil.getSuccessJson(news);
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
        return GsonUtil.getSuccessJson(pageInfo);
    }

    /**
     * 产品评测具体信息
     */
    public String getEvaluateInfo(String id) {
        int infoId;
        if ((infoId = CommonUtil.formatPageNum(id)) == 0) return GsonUtil.getErrorJson();
        RobotNews news = informationDao.findInformationInfo(infoId);
        if (news == null)
            return GsonUtil.getErrorJson();
        return GsonUtil.getSuccessJson(news);
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
        return GsonUtil.getSuccessJson(pageInfo);
    }

    /**
     * 产品新闻具体信息
     */
    public String getProductNewsInfo(String id) {
        int infoId;
        if ((infoId = CommonUtil.formatPageNum(id)) == 0) return GsonUtil.getErrorJson();
        RobotNews news = informationDao.findInformationInfo(infoId);
        if (news == null)
            return GsonUtil.getErrorJson();
        return GsonUtil.getSuccessJson(news);
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
        return GsonUtil.getSuccessJson(pageInfo);
    }

    /**
     * 产品推荐具体信息
     */
    public String getRecommendInfo(String id) {
        int infoId;
        if ((infoId = CommonUtil.formatPageNum(id)) == 0) return GsonUtil.getErrorJson();
        RobotNews news = informationDao.findInformationInfo(infoId);
        if (news == null)
            return GsonUtil.getErrorJson();
        return GsonUtil.getSuccessJson(news);
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
        RobotNews article = informationDao.findInformationInfo(infoId);
        if (null == article)
            return GsonUtil.getErrorJson();
        article.setContent(CommonUtil.getAbsolutePath(article.getContent()));
        return GsonUtil.getSuccessJson(article);
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
        }
        return GsonUtil.getSuccessJson(GsonUtil.getFilterJson(RobotNews.class, "url"), pageInfo);
    }

    /**
     * 添加文章
     * @param robotNews
     * @return
     */
    public String addInformation(RobotNews robotNews){

        if(1!=informationDao.add(robotNews))
            return GsonUtil.getErrorJson();

        for(Detail detail:robotNews.getContent()){
            HashMap map = new HashMap();
            map.put("id",robotNews.getId());
            map.put("content",detail.getContent());
            map.put("page",detail.getPage());
            if(1!=informationDao.addContent(map))
                return GsonUtil.getErrorJson();
        }
        return GsonUtil.getSuccessJson();
    }
    /**
     * 删除文章
     * @param id
     * @return
     */
    public String deleteInformation(String id){
        int infoId;
        if((infoId = CommonUtil.formatPageNum(id)) == 0)return GsonUtil.getErrorJson();
        if(1!=informationDao.delete(infoId))
            return GsonUtil.getErrorJson();
        return GsonUtil.getSuccessJson();
    }
    /**
     * 修改文章
     * @param robotNews
     * @return
     */
    public String updateInformation(RobotNews robotNews){
        if(ValidateUtil.isInvalidString(informationDao.findInformationById(robotNews.getId())))
            return GsonUtil.getErrorJson("修改文章不存在");
        if(informationDao.update(robotNews)<1)
            return GsonUtil.getErrorJson();
        return GsonUtil.getSuccessJson();
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
//    public ArrayList<RobotNews> getIndexDiscuss(){
//        ArrayList<RobotNews> discuss = informationDao.(map);
//        return discuss;
//    }

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
}
