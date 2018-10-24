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
        return basic;
    }

    public List<Technology> getIndexCase(){
        List<Technology> cases = technologyDao.getIndexCase();
        return cases;
    }

    public List<Technology> getIndexScience(){
        List<Technology> science = technologyDao.getIndexScience();
        return science;
    }
}
