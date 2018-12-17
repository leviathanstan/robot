package com.service;

import com.robot.dao.InformationDao;

import com.robot.entity.RobotNews;
import com.robot.schedule.ScheduleTask;
import com.robot.service.InformationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

@WebAppConfiguration("src/main/resources")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:/config/spring.xml", "classpath*:/config/spring-mvc.xml"})
public class InformationServiceTest {

    @Autowired
    private InformationDao informationDao;
    @Autowired
    private ScheduleTask scheduleTask;
    @Autowired
    private InformationService informationService;

    @Test
    public void testList(){
        System.out.println(informationDao.getInformationList(1));
    }

    @Test
    public void testS(){
        ArrayList<RobotNews> robotNews = informationService.getCompanyNews();
        robotNews.forEach(c-> System.out.println(c));
    }
}
