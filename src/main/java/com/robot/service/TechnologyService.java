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
            basic.get(1).setImg("http://images.ofweek.com/Upload/News/2017-12/summary/2017129113320841.jpg");
            basic.get(1).setImg("http://images.ofweek.com/Upload/News/2017-3/summary/20173169121846.jpg");
            basic.get(2).setImg("http://images.ofweek.com/Upload/News/2016-2/RB/16/249.jpg");
        }
        return basic;
    }

    public List<Technology> getIndexCase(){
        List<Technology> cases = technologyDao.getIndexCase();
        for(int i = 0;i<3;i++){
            cases.get(0).setImg("http://images.ofweek.com/Upload/News/2018-6/summary/2018620102332369.jpg");
            cases.get(1).setImg("http://images.ofweek.com/Upload/News/2016-2/summary/20162229024146.jpg");
            cases.get(2).setImg("http://images.ofweek.com/Upload/News/2016-2/summary/2016220971922.jpg");
        }
        return cases;
    }

    public List<Technology> getIndexScience(){
        List<Technology> science = technologyDao.getIndexScience();
        for(int i = 0;i<3;i++){
            science.get(i).setImg("http://images.ofweek.com/Upload/News/2016-2/RB/16/248.jpg");
            science.get(1).setImg("http://images.ofweek.com/Upload/News/2016-2/RB/16/185.jpg");
            science.get(2).setImg("http://images.ofweek.com/Upload/News/2016-2/RB/16/249.jpg");
        }
        return science;
    }
}
