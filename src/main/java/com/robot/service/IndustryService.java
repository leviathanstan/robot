package com.robot.service;

import com.robot.dao.IndustryDao;
import com.robot.entity.Industry;
import com.robot.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author Ning
 * @date 2018/9/22
 */
@Service
public class IndustryService {

    @Autowired
    private IndustryDao industryDao;

    public String getIndustryCount() {
        ArrayList<Industry> industryList = industryDao.getIndustryCount();
        return GsonUtil.getSuccessJson(industryList);
    }
}
