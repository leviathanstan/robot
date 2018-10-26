package com.service;

import com.robot.dao.AssociationDao;

import com.robot.entity.RobotNews;
import com.robot.service.AssociationService;
import org.aspectj.weaver.ast.Not;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.regex.Pattern;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:/config/spring.xml", "classpath*:/config/spring-mvc.xml"})
public class AssociationServiceTest {

    @Autowired
    private AssociationService associationService;
    @Autowired
    private AssociationDao associationDao;

    @Test
    public void test(){
        //System.out.println(associationService.getRobotNewsTop());
        System.out.println(associationService.getRobotNewsInf("0ab5abb4ead8d66e7239d7410d589499"));

    }
}
