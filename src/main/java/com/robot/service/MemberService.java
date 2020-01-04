package com.robot.service;

import com.robot.dao.*;
import com.robot.entity.Introduction;
import com.robot.entity.Member;
import com.robot.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberService {

    @Autowired
    private IntroductionDao introductionDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private InformationDao informationDao;
    @Autowired
    private ConferenceDao conferenceDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private InformationService informationService;
    @Autowired
    private CompanyService companyService;

    @Autowired
    private PositionService positionService;

    /**
     * information类别
     */
    private enum InformationEnum {
        PRODUCT_NEWS(1), PRODUCT_RECOMMEND(2), PRODUCT_EVALUATE(3), BASIC_KNOWLEDGE(4), ENTERPRISE_NEWS(5), INDUSTRY_INFORMATION(6),
        POLICY_INFORMATION(7), MEMBER_NEWS(8), NOTICE(9), ASSOCIATION_NEWS(10), EXPERT_WISDOM(11), CONSULTING_FOCUS(12), NEWS_HOTSPOT_DAY(20),
        NEWS_HOTSPOT_WEEK(21), NEWS_HOTSPOT_MONTH(22), EDUCATION_TRAIN(23), CASE(24);
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
     * introduction类别
     */
    private enum IntroductionEnum {
        EXPERT(16), UNIVERSITIES(17), MEMBER(18);
        private final int id;
        IntroductionEnum(int id) {
            this.id = id;
        }
        public int getId(){
            return id;
        }
    }
    /**
     * introduction 首页数量
     */
    private enum IntroductionNumberEnum{
        EXPERT(10), UNIVERSITIES(10), MEMBER(10);
        private final int number;
        IntroductionNumberEnum(int number) {
            this.number = number;
        }
        public int getNumber(){
            return number;
        }
    }

    private enum ConferenceEnum{
        MEETING("1"),CONFERENCE("2");
        private final String type;
        ConferenceEnum(String type){
            this.type = type;
        }
        public String getType(){
            return type;
        }
    }
    /**
     * 获取会员单位资讯等信息
     *
     * @param introductionId
     * @return
     * @author chen
     */
    public String getMemberInfo(int introductionId) {
        Introduction introduction = introductionDao.findIntroductionInfo(introductionId);
        Member member = userDao.selectMemberByName(introduction.getName());
        if (member == null)
            return null;
        List<Integer> userIds = userDao.selectUIds(member.getId());
        List<Integer> informationIds = informationDao.selectMemberInformationByUIds(userIds);
        Map<String, Object> dataMap = new HashMap<>();
        if (informationIds.size() != 0) {
            dataMap.put("information1", informationDao.selectIndexMemberInformation(InformationEnum.INDUSTRY_INFORMATION.getId(), informationIds, NumberEnum.INFORMATION_NUMBER.getNumber()));
            dataMap.put("news", informationDao.selectIndexMemberInformation(InformationEnum.ASSOCIATION_NEWS.getId(), informationIds, NumberEnum.INFORMATION_NUMBER.getNumber()));
            dataMap.put("hotspot", informationDao.selectIndexMemberInformation(InformationEnum.CONSULTING_FOCUS.getId(), informationIds, NumberEnum.INFORMATION_NUMBER.getNumber()));
            dataMap.put("notices", informationDao.selectIndexMemberInformation(InformationEnum.NOTICE.getId(), informationIds, NumberEnum.INFORMATION_NUMBER.getNumber()));
            dataMap.put("educationTrain", informationDao.selectIndexMemberInformation(InformationEnum.EDUCATION_TRAIN.getId(), informationIds, NumberEnum.INFORMATION_NUMBER.getNumber()));
            dataMap.put("productEvaluation", informationDao.selectIndexMemberInformation(InformationEnum.PRODUCT_EVALUATE.getId(), informationIds, NumberEnum.INFORMATION_NUMBER.getNumber()));
            dataMap.put("productNews", informationDao.selectIndexMemberInformation(InformationEnum.PRODUCT_NEWS.getId(), informationIds, NumberEnum.INFORMATION_NUMBER.getNumber()));
            dataMap.put("productRecommend", informationDao.selectIndexMemberInformation(InformationEnum.PRODUCT_RECOMMEND.getId(), informationIds, NumberEnum.INFORMATION_NUMBER.getNumber()));
            dataMap.put("companyNews", informationDao.selectIndexMemberInformation(InformationEnum.ENTERPRISE_NEWS.getId(), informationIds, NumberEnum.INFORMATION_NUMBER.getNumber()));
            dataMap.put("companyDynamics", informationDao.selectIndexMemberInformation(InformationEnum.MEMBER_NEWS.getId(), informationIds, NumberEnum.INFORMATION_NUMBER.getNumber()));
            dataMap.put("expertArts", informationDao.selectIndexMemberInformation(InformationEnum.EXPERT_WISDOM.getId(), informationIds, NumberEnum.INFORMATION_NUMBER.getNumber()));
            dataMap.put("policy", informationDao.selectIndexMemberInformation(InformationEnum.POLICY_INFORMATION.getId(), informationIds, NumberEnum.INFORMATION_NUMBER.getNumber()));
            dataMap.put("case", informationDao.selectIndexMemberInformation(InformationEnum.CASE.getId(), informationIds, NumberEnum.INFORMATION_NUMBER.getNumber()));
            dataMap.put("basic", informationDao.selectIndexMemberInformation(InformationEnum.BASIC_KNOWLEDGE.getId(), informationIds, NumberEnum.INFORMATION_NUMBER.getNumber()));
            dataMap.put("science", informationService.getIndexDiscuss());
        }
        List<Integer> introductionIds = introductionDao.selectMemberIntroductionByUIds(userIds);
        if(introductionIds.size() != 0) {
            dataMap.put("school", introductionDao.selectIndexMemberIntroduction(IntroductionEnum.UNIVERSITIES.getId(),introductionIds,IntroductionNumberEnum.UNIVERSITIES.getNumber()));
            dataMap.put("experts", introductionDao.selectIndexMemberIntroduction(IntroductionEnum.EXPERT.getId(),introductionIds,IntroductionNumberEnum.UNIVERSITIES.getNumber()));
            dataMap.put("members",introductionDao.selectIndexMemberIntroduction(IntroductionEnum.MEMBER.getId(),introductionIds,IntroductionNumberEnum.UNIVERSITIES.getNumber()));
        }
        List<Integer> productIds = productDao.selectMemberProductByUIds(userIds);
        if(productIds.size() != 0) {
            dataMap.put("productLibrary",productDao.selectIndexMemberProduct(productIds,NumberEnum.PRODUCT_NUMBER.getNumber()));
        }
        List<Integer> conferenceIds = conferenceDao.selectMemberConferenceByUIds(userIds);
        if(conferenceIds.size() != 0) {
            dataMap.put("conference", conferenceDao.selectIndexMemberConference(Integer.parseInt(ConferenceEnum.CONFERENCE.getType()),conferenceIds,5));
            dataMap.put("meeting",conferenceDao.selectIndexMemberConference(Integer.parseInt(ConferenceEnum.MEETING.getType()),conferenceIds,5));
        }
        dataMap.put("position", positionService.getIndex());
        dataMap.put("report", informationService.findReportTop());
        dataMap.put("companyBrand", companyService.getCompanyBrand());
        dataMap.put("relatedHot",informationService.findIndexRelatedHot());
        return GsonUtil.getSuccessJson(dataMap);
    }
}
