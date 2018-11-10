package com.service;

<<<<<<< HEAD
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.robot.dao.InformationDao;
import com.robot.entity.Information;
import com.robot.service.InformationService;
=======

import com.robot.dao.InformationDao;


>>>>>>> c6bdb2c26a1aabdf0358f9d750b3eee24fd510cc
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
<<<<<<< HEAD
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
=======

>>>>>>> c6bdb2c26a1aabdf0358f9d750b3eee24fd510cc


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:/config/spring.xml", "classpath*:/config/spring-mvc.xml"})
public class InformationServiceTest {

    @Autowired
    private InformationDao informationDao;

<<<<<<< HEAD

=======
>>>>>>> c6bdb2c26a1aabdf0358f9d750b3eee24fd510cc
    @Test
    public void test(){


       // System.out.println(informationDao.findInformationInfo(1));
       // System.out.println(informationDao.findInformationTop(1));

<<<<<<< HEAD
        PageHelper.startPage(1,12);
        List<Information> informations = informationDao.findInformationByPage(1);
        System.out.println("1" + informations);
        PageInfo<Information> page = new PageInfo<>(informations);
        System.out.println("2" + page);
        System.out.println();
        for(Information info:informations){
            System.out.println(info);
        }
=======
//        PageHelper.startPage(1,12);
//        List<Information> informations = informationDao.findInformationByPage(1);
//        System.out.println("1" + informations);
//        PageInfo<Information> page = new PageInfo<>(informations);
//        System.out.println("2" + page);
//        System.out.println();
//        for(Information info:informations){
//            System.out.println(info);
//        }


>>>>>>> c6bdb2c26a1aabdf0358f9d750b3eee24fd510cc
    }
}
