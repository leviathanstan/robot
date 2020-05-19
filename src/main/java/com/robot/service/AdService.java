package com.robot.service;

import com.robot.dao.AdDao;
import com.robot.entity.Ad;
import com.robot.util.GsonUtil;
import com.robot.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Create 2020-05-19 19:40
 * @Author xm
 * @Description 广告
 */
@Service
public class AdService {

    @Autowired
    private AdDao adDao;

    /**
     * 增加广告
     * @Author  xm
     * @Date 2020/5/19 20:09
     * @param ad
     * @return java.lang.String
     */
    public String add(Ad ad) {
        if (ValidateUtil.isNullOrEmpty(ad.getImage())) {
            return GsonUtil.getErrorJson("图片不能为空");
        }

        adDao.insertSelective(ad);

        return GsonUtil.getSuccessJson("增加成功");
    }

    /**
     * 修改广告
     * @Author  xm
     * @Date 2020/5/19 20:09
     * @param ad
     * @return java.lang.String
     */
    public String update(Ad ad) {
        if (adDao.updateByPrimaryKeySelective(ad) == 1) {
            return GsonUtil.getSuccessJson("更新成功");
        }

        return GsonUtil.getErrorJson("更新失败");
    }

    /**
     * 删除广告
     * @Author  xm
     * @Date 2020/5/19 20:09
     * @param ids
     * @return java.lang.String
     */
    public String delete(List<Integer> ids) {
        adDao.deletes(ids);
        return GsonUtil.getSuccessJson("删除成功");
    }

    /**
     * 获取广告
     * @Author  xm
     * @Date 2020/5/19 20:10
     * @param
     * @return java.lang.String
     */
    public String get() {
        return GsonUtil.getSuccessJson(adDao.selectByExample(null));
    }
}
