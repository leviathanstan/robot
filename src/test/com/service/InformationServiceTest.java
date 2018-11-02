package com.service;


import com.robot.dao.InformationDao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:/config/spring.xml", "classpath*:/config/spring-mvc.xml"})
public class InformationServiceTest {

    @Autowired
    private InformationDao informationDao;

    @Test
    public void test(){


       // System.out.println(informationDao.findInformationInfo(1));
       // System.out.println(informationDao.findInformationTop(1));

//        PageHelper.startPage(1,12);
//        List<Information> informations = informationDao.findInformationByPage(1);
//        System.out.println("1" + informations);
//        PageInfo<Information> page = new PageInfo<>(informations);
//        System.out.println("2" + page);
//        System.out.println();
//        for(Information info:informations){
//            System.out.println(info);
//        }


    }
}
