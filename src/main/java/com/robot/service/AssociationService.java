package com.robot.service;

import com.robot.dao.AssociationDao;
import com.robot.entity.Member;
import com.robot.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author Ning
 * @date 2018/10/11
 */
@Service
public class AssociationService {
    @Autowired
    private AssociationDao associationDao;

    public String getAssociationMember() {
        ArrayList<Member> memberArrayList = associationDao.getAssociationMember();
        return GsonUtil.getSuccessJson(memberArrayList);
    }
}
