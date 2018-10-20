package com.service;

import com.robot.dao.CategoryDao;
import com.robot.dao.ExpertDao;
import com.robot.dao.ProductDao;
import com.robot.dto.CategoryDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author asce
 * @date 2018/9/22
 */
@WebAppConfiguration("src/main/resources")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:config/spring.xml", "classpath*:/config/spring-mvc.xml"})
public class CategoryServiceTest {

    @Autowired
    public CategoryDao categoryDao;

    @Autowired
    public ExpertDao expertDao;

    @Test
    public void testCollection(){
        //CategoryDto categoryDto = categoryDao.testCollection();
        expertDao.findAllExpert();
    }
}
