package com.robot.controller;

import com.robot.annotation.Authority;
import com.robot.entity.Position;
import com.robot.enums.Role;
import com.robot.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @author asce
 * @date 2018/11/20
 */
@Controller
@RequestMapping(value = "/position")
public class PositionController {
    @Autowired
    PositionService positionService;

    @ResponseBody
    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String search(@RequestParam HashMap args){
        return positionService.search(args);
    }

    @ResponseBody
    @RequestMapping(value = "/getPositionInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getPositionInfo(int id){
        return positionService.getPositionInfo(id);
    }

    @ResponseBody
    @RequestMapping(value = "/getLevelAreas", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getLevelAreas(String parentId){
        return positionService.getLevelArea(parentId);
    }

    @ResponseBody
    @RequestMapping(value = "/getLevelIndustry", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String getLevelIndustry(String parentId){
        return positionService.getLevelIndustry(parentId);
    }

    @Authority(role = Role.MEMBER)
    @ResponseBody
    @RequestMapping(value = "manager/deletePosition", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String deletePosition(@RequestParam List<Integer> ids){
        return positionService.deletePosition(ids);
    }

    @Authority(role = Role.MEMBER)
    @ResponseBody
    @RequestMapping(value = "manager/updatePosition", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String updatePosition(Position position, @RequestParam List<Integer> regionIds){
        return positionService.updatePosition(position,regionIds);
    }

    @Authority(role = Role.MEMBER)
    @ResponseBody
    @RequestMapping(value = "manager/addPosition", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String addPosition(Position position, @RequestParam List<Integer> regionIds, HttpSession session){
        return positionService.addPosition(position, regionIds, session);
    }

    @Authority(role = Role.MEMBER)
    @ResponseBody
    @RequestMapping(value = "manager/findPosition", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String addPosition(HttpSession session, @RequestParam Integer pageNum, @RequestParam(required = false) String content){
        return positionService.findPosition(pageNum, content, session);
    }
}
