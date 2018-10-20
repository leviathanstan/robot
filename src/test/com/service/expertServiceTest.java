package com.service;

import com.robot.dao.ExpertDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration("src/main/resources")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:/config/spring.xml", "classpath*:/config/spring-mvc.xml"})
public class expertServiceTest {

    @Autowired
    public ExpertDao expertDao;

    @Test
    public void test(){
        //System.out.println(expertDao.findExpertInf(1));
      //  System.out.println(expertDao.findUniversityInf(1));

        //System.out.println(expertDao.findExpertArtTop());
        expertDao.findAllExpert();
    }
}
