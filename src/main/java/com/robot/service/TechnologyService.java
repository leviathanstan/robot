package com.robot.service;

import com.robot.dao.TechnologyDao;
import com.robot.entity.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author asce
 * @date 2018/10/23
 */
@Service
public class TechnologyService {

    @Autowired
    private TechnologyDao technologyDao;

    public List<Technology> getIndexBasic(){
        List<Technology> basic = technologyDao.getIndexBasic();
        for(int i = 0;i<3;i++){
            basic.get(i).setImg("abc.jpg");
        }
        return basic;
    }

    public List<Technology> getIndexCase(){
        List<Technology> cases = technologyDao.getIndexCase();
        for(int i = 0;i<3;i++){
            cases.get(i).setImg("abc.jpg");
        }
        return cases;
    }

    public List<Technology> getIndexScience(){
        List<Technology> science = technologyDao.getIndexScience();
        for(int i = 0;i<3;i++){
            science.get(i).setImg("abc.jpg");
        }
        return science;
    }
}
