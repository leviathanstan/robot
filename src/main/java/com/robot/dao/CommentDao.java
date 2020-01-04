package com.robot.dao;

import com.robot.entity.Comment;
import com.robot.entity.Reply;

import java.util.ArrayList;
import java.util.Map;

public interface CommentDao {

    int getCommentCount(int informationId);
    //发表评论
    int addBlogComment(Comment comment);
    //发表回复
    int addCommentReply(Reply reply);
    //得到评论者id，防止自己回复自己
    Integer getUserIdFromComment(int CommentId);
    //得到回复者id，防止自己回复自己
    Integer getUserIdFromReply(int replyId);
    //得到博客评论
    ArrayList<Comment> getCommentByBlog(Map<String, Integer> map);
    //得到评论回复
    ArrayList<Reply> getReplyByComment(int commentId);
    //得到评论回复数
    Integer getCommentReplyCount(int commentId);
    Integer deleteCommentByInformation(int informationId);
    Integer deleteCommentById(int id);
    Integer deleteReplyByComment(int commentId);
    Integer deleteReplyById(int id);
    Integer deleteReplyByInformation(int informationId);
}







