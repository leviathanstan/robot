package com.robot.service;

import com.robot.dao.AboutusDao;
import com.robot.util.GsonUtil;
import com.robot.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Create 2020-05-19 19:05
 * @Author xm
 * @Description 关于我们
 */
@Service
public class AboutusService {

    @Autowired
    private AboutusDao aboutusDao;

    /**
     * 获取关于我们
     * @Author  xm
     * @Date 2020/5/19 19:19
     * @param
     * @return java.lang.String
     */
    public String getAboutus() {
        return GsonUtil.getSuccessJson(aboutusDao.getAboutus());
    }

    /**
     * 更新关于我们
     * @Author  xm
     * @Date 2020/5/19 19:21
     * @param content
     * @return java.lang.String
     */
    public String updateAboutus(String content) {
        if (ValidateUtil.isNullOrEmpty(content)) {
            return GsonUtil.getErrorJson("内容不能为空");
        }

        aboutusDao.updateAboutus(content);

        return GsonUtil.getSuccessJson("更新成功");
    }
}
