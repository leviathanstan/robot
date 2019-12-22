package com.service;

import com.robot.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author asce
 * @date 2019/6/6
 */
@WebAppConfiguration("src/main/resources")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:/config/spring.xml", "classpath*:/config/spring-mvc.xml"})
public class ConcurrentTest {

    @Autowired
    CompanyService companyService;
    @Autowired
    InformationService informationService;
    @Autowired
    IntroductionService introductionService;
    @Autowired
    ProductService productService;
    @Autowired
    PositionService positionService;
    @Autowired
    ConferenceService conferenceService;
    @Autowired
    CommonService commonService;

    @Test
    public void testSub() throws Exception{
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("getIndexAssociationNews", informationService);
        dataMap.put("getIndexMember", introductionService);
        dataMap.put("getIndexNotice", informationService);
        dataMap.put("findInformationTop", informationService);
        dataMap.put("findPolicyTop", informationService);
        dataMap.put("getIndexUniversity", introductionService);
        dataMap.put("getIndexExpert", introductionService);
        dataMap.put("getIndexExpertArt", informationService);
        dataMap.put("getCompanyNews", informationService);
        dataMap.put("getCompanyBrand", companyService);
        dataMap.put("getCompanyDynamics", informationService);
        dataMap.put("getIndexHot", informationService);
        dataMap.put("findReportTop", informationService);
        dataMap.put("getIndexBasic", informationService);
        dataMap.put("getIndexDiscuss", informationService);
        dataMap.put("getEducationTrain", informationService);
        dataMap.put("getIndexEvaluate", informationService);
        dataMap.put("getProductLibrary", productService);
        dataMap.put("getIndexProductNews", informationService);
        dataMap.put("getIndexRecommend", informationService);
        dataMap.put("getIndexConference", conferenceService);
        dataMap.put("getIndexMetting", conferenceService);
        dataMap.put("findIndexRelatedHot", informationService);
        ExecutorTest executorTest = new ExecutorTest();
        List<Object> res = executorTest.doIt(dataMap);
    }

    @Test
    public void testFork(){
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("getIndexAssociationNews", informationService);
        dataMap.put("getIndexMember", introductionService);
        dataMap.put("getIndexNotice", informationService);
        dataMap.put("findInformationTop", informationService);
        dataMap.put("findPolicyTop", informationService);
        dataMap.put("getIndexUniversity", introductionService);
        dataMap.put("getIndexExpert", introductionService);
        dataMap.put("getIndexExpertArt", informationService);
        dataMap.put("getCompanyNews", informationService);
        dataMap.put("getCompanyBrand", companyService);
        dataMap.put("getCompanyDynamics", informationService);
        dataMap.put("getIndexHot", informationService);
        dataMap.put("findReportTop", informationService);
        dataMap.put("getIndexBasic", informationService);
        dataMap.put("getIndexDiscuss", informationService);
        dataMap.put("getEducationTrain", informationService);
        dataMap.put("getIndexEvaluate", informationService);
        dataMap.put("getProductLibrary", productService);
        dataMap.put("getIndexProductNews", informationService);
        dataMap.put("getIndexRecommend", informationService);
        dataMap.put("getIndexConference", conferenceService);
        dataMap.put("getIndexMetting", conferenceService);
        dataMap.put("findIndexRelatedHot", informationService);
        ForkJoinPool pool = new ForkJoinPool(4);
        ForkJoinTest joinTest = new ForkJoinTest(dataMap);
        ArrayList<Object> result;
        result = pool.invoke(joinTest);
    }
}