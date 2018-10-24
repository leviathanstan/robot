package com.robot.service;

import com.robot.dao.TechnologyDao;
import com.robot.entity.RobotNews;
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

    public List<RobotNews> getIndexBasic(){
        List<RobotNews> basic = technologyDao.getIndexBasic();
        return basic;
    }

    public List<RobotNews> getIndexCase(){
        List<RobotNews> cases = technologyDao.getIndexCase();
        return cases;
    }

    public List<RobotNews> getIndexScience(){
        List<RobotNews> science = technologyDao.getIndexScience();
        return science;
    }
}
