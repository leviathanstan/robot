package com.robot.controller;

import com.robot.service.ExpertService;
import com.robot.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author hua
 * @date 2018/9/25
 */
@Controller
@RequestMapping("/expert")
public class ExpertController {

    @Autowired
    private ExpertService expertService;

    /**
     * 获取专家具体信息
     * @author hua
     * @date 2018/9/25
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findExpertInf/{id}",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String findExpertInf(@PathVariable Integer id){
        return expertService.findExpertInf(id);
    }

    /**
     * 获取高校具体信息
     * @author hua
     * @date 2018/9/25
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findUniversityInf/{id}",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String findUniversityInf(@PathVariable Integer id){
        return expertService.findUniversityInf(id);
    }

    /**
     * 获取专家的分页显示
     * @param pageNum
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "findExpertByPage/{pageNum}",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String findExpertByPage(@PathVariable Integer pageNum){
        return expertService.findExpertByPage(pageNum);
    }

    /**
     * 获取高校的分页显示
     * @param pageNum
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "findUniversityByPage/{pageNum}",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String findUniversityByPage(@PathVariable Integer pageNum){
        return expertService.findUniversityByPage(pageNum);
    }

    /**
     * 获取专家智点具体信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "findExpertArtInf/{id}",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String findExpertArtInf(@PathVariable Integer id){
        return expertService.findExpertArtInf(id);
    }

    /**
     * 获取专家智点的分页显示
     * @param pageNum
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "findExpertArtByPage",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String findExpertArtByPage( Integer pageNum){
        return expertService.findExpertArtByPage(pageNum);
    }
}
