package com.robot.service;

import com.robot.dao.ExpertDao;
import com.robot.entity.Expert;
import com.robot.entity.University;
import com.robot.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hua
 * @date 2018/9/25
 */
@Service
public class ExpertService {

    @Autowired
    private ExpertDao expertDao;

    /**
     * 获取专家具体信息
     * @author hua
     * @date 2018/9/25
     * @param id
     * @return
     */
    public String findExpertInf(Integer id){
        Expert expert = expertDao.findExpertInf(id);
        return GsonUtil.getSuccessJson(expert);
    }

    /**
     * 获取高校具体信息
     * @author hua
     * @date 2018/9/25
     * @param id
     * @return
     */
    public String findUniversityInf(Integer id){
        University university = expertDao.findUniversityInf(id);
        return GsonUtil.getSuccessJson(university);
    }
}
