package com.service;

import com.robot.dao.PositionDao;
import com.robot.entity.Member;
import com.robot.entity.Survey;
import com.robot.service.PositionService;
import com.robot.service.SurveyService;
import com.robot.util.CommonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    @Autowired
    PositionService positionService;

    @Test
    public void testSurveyInfo(){
        //System.out.println(surveyService.getSurveyInfo("0"));
        HashMap map = new HashMap<>();
        System.out.println(positionService.search(map));
        //System.out.println(positionService.getPositionInfo(1));
    }

}
