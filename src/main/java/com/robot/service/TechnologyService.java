package com.robot.service;

import com.robot.dao.TechnologyDao;
import com.robot.entity.Robot;
import com.robot.entity.RobotNews;
import com.robot.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author asce
 * @date 2018/10/23
 */
@Service
public class TechnologyService {

    @Autowired
    private TechnologyDao technologyDao;
    //首页要求最少封面数
    private final int countCover = 3;

    public List<RobotNews> getIndexBasic(){
        ArrayList<RobotNews> basices = technologyDao.getIndexBasic();
        if (CommonUtil.judgeCover(basices,countCover)) {
            basices.addAll(technologyDao.getIndexCoverBasic());
        }
        return basices;
    }

    public List<RobotNews> getIndexCase(){
        List<RobotNews> cases = technologyDao.getIndexCase();
        return cases;
    }

    public List<RobotNews> getIndexDiscuss(){
        ArrayList<RobotNews> discusses = technologyDao.getIndexDiscuss();
        if (CommonUtil.judgeCover(discusses,countCover)){
            discusses.addAll(technologyDao.getIndexCoverDiscuss());
        }
        return discusses;
    }
}
