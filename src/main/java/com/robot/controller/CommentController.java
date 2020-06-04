package com.robot.controller;

import com.robot.annotation.Authority;
import com.robot.entity.Comment;
import com.robot.entity.Reply;
import com.robot.entity.User;
import com.robot.enums.Role;
import com.robot.service.CommentService;
import com.robot.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.Arrays;

/**
 * @author asce
 * @date 2020/1/3
 */
@Controller
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 回复评论
     * Asce 2018-07-23
     * @param reply
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/commentReply",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String commentReply(MultipartFile mulFile, Reply reply, HttpSession session) throws Exception{
        User user = (User)session.getAttribute("user");
        if (user == null)   return GsonUtil.getErrorJson("还没登录");
        return commentService.addCommentReply(user.getId() ,reply, mulFile);
    }
    /**
     * 发表评论
     * Asce 2018-07-23
     * @param comment
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/addComment",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String blogComment(MultipartFile mulFile, Comment comment, HttpSession session) throws Exception{
        User user = (User)session.getAttribute("user");
        if (user == null)   return GsonUtil.getErrorJson("还没登录");
        return commentService.addBlogComment(user.getId() ,comment, mulFile);
    }

    /**
     * 取得评论的回复
     * @param commentId
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/getReply/{commentId}",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    public String getReply(@PathVariable int commentId) throws ParseException {
        return GsonUtil.getSuccessJson(commentService.getReply(commentId));
    }

    /**
     * 获取评论
     * @param page
     * @return
     * @throws ParseException
     */
    @ResponseBody
    @RequestMapping(value = "/getComment/{informationId}/{page}",produces = "text/html;charset=UTF-8")
    public String getCommentByBlog(@PathVariable int informationId, @PathVariable int page) throws ParseException {
        return GsonUtil.getSuccessJson(commentService.getCommentWithoutReply(informationId,page));
    }

    @Authority(role = Role.MEMBER)
    @ResponseBody
    @RequestMapping(value = "/deleteCommentById", method = RequestMethod.POST)
    public String deleteCommentById(@RequestParam int id) {
        return commentService.deleteCommentById(id);
    }

    @Authority(role = Role.MEMBER)
    @ResponseBody
    @RequestMapping(value = "/deleteReplyById", method = RequestMethod.POST)
    public String deleteReplyById(@RequestParam int id) {
        return commentService.deleteReplyById(id);
    }

    @Authority(role = Role.MEMBER)
    @ResponseBody
    @RequestMapping(value = "/deleteReplyByComment", method = RequestMethod.POST)
    public String deleteReplyByComment(@RequestParam int commentId) {
        return commentService.deleteReplyByComment(commentId);
    }

    @Authority(role = Role.MEMBER)
    @ResponseBody
    @RequestMapping(value = "/deleteCommentByInformation", method = RequestMethod.POST)
    public String deleteCommentByInformation(@RequestParam int informationId) {
        return GsonUtil.getSuccessJson(commentService.deleteByInformation(Arrays.asList(informationId)));
    }
}
