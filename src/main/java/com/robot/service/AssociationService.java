package com.robot.service;

import com.robot.dao.AssociationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ning
 * @date 2018/10/11
 */
@Service
public class AssociationService {
    @Autowired
    private AssociationDao associationDao;
}
