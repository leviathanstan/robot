package com.service;

import com.robot.entity.Survey;
import com.robot.service.SurveyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author asce
 * @date 2018/11/15
 */
@WebAppConfiguration("src/main/resources")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:/config/spring.xml", "classpath*:/config/spring-mvc.xml"})
public class SurveyTest {

    @Autowired
    SurveyService surveyService;

    @Test
    public void testSurveyInfo(){
        //System.out.println(surveyService.getSurveyInfo("0"));
        Survey survey = new Survey();
        System.out.println(survey);
    }
}
