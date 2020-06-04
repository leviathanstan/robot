package com.robot.service;

import com.robot.dao.CommentDao;
import com.robot.entity.Comment;
import com.robot.entity.Reply;
import com.robot.entity.User;
import com.robot.util.CommonUtil;
import com.robot.util.ConvertUtil;
import com.robot.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.HtmlUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CommentService {

	private final static int COMMENT_SIZE = 10;
	@Autowired
	private CommentDao commentDao;

	@Transactional
	public boolean deleteByInformation(List<Integer> informations) {
		for (int i: informations) {
			commentDao.deleteReplyByInformation(i);
			commentDao.deleteCommentByInformation(i);
		}
		return true;
	}

	@Transactional
	public String deleteCommentById(int id) {
		deleteReplyByComment(id);
		if (1 == commentDao.deleteCommentById(id)) {
			return GsonUtil.getSuccessJson();
		}
		return GsonUtil.getErrorJson();
	}

	@Transactional
	public String deleteReplyById(int id) {
		if (1 == commentDao.deleteReplyById(id)) {
			return GsonUtil.getSuccessJson();
		}
		return GsonUtil.getErrorJson();
	}

	@Transactional
	public String deleteReplyByComment(int commentId) {
		if (commentDao.deleteReplyByComment(commentId) > 0) {
			return GsonUtil.getSuccessJson();
		}
		return GsonUtil.getErrorJson();
	}

	/**
	 * 获取一篇文章：评论数+回复数
	 * @param informationId
	 * @return
	 */
	public int getCommentSize(int informationId) {
		return commentDao.getCommentCount(informationId);
	}

	/**
	 * 获取回复
	 * @param commentId
	 * @return
	 */
	public ArrayList<Reply> getReply(int commentId) throws ParseException {
		ArrayList<Reply> replies = commentDao.getReplyByComment(commentId);	//评论下的回复
		for (int j=0;j<replies.size();j++){
			replies.get(j).setTime(ConvertUtil.msecToMinutes(replies.get(j).getTime()));	//格式化时间
		}
		return replies;
	}
	/**
	 * Asce 2018/7/25
	 * 获取评论
	 * @param blogId
	 * @param page
	 * @return
	 */
	public ArrayList<Comment> getComment(int blogId, int page) throws ParseException {
		int begin = page*COMMENT_SIZE;
		Map<String,Integer> map= new HashMap<>();
		map.put("informationId",blogId);
		map.put("begin",begin);
		ArrayList<Comment> comments = commentDao.getCommentByBlog(map);

		for(int i=0;i<comments.size();i++){
			//有无回复
			Integer replyCount = commentDao.getCommentReplyCount(comments.get(i).getId());
			comments.get(i).setReplyCount(replyCount);
			comments.get(i).setTime(ConvertUtil.msecToMinutes(comments.get(i).getTime()));
		}
		return comments;
	}

	/**
	 * 获取评论（前端）
	 * @param blogId
	 * @param page
	 * @return
	 */
	public ArrayList<Comment> getCommentWithoutReply(int blogId,int page) throws ParseException {
		return getComment(blogId,page);
	}

	/**
	 * 发表回复
	 * @param userId
	 * @param reply
	 * @return
	 */
	@Transactional
	public String addCommentReply(int userId, Reply reply, MultipartFile file) throws Exception{
		//判断是否为自己回复自己
		if(reply.getFromReplyId()==0){	//评论的回复
			if(userId == commentDao.getUserIdFromComment(reply.getCommentId())){
				return GsonUtil.getErrorJson("不能自己回复自己");
			}
		}else {	//回复的回复
			Integer dbUserId = commentDao.getUserIdFromReply(reply.getFromReplyId());
			//考虑到使用外键做约束时，删除回复时麻烦，在此做关联的判断，可直接添加索引（或使用CASCADE约束)
			if (dbUserId == null)	return GsonUtil.getErrorJson("不存在此条回复");
			if (dbUserId == userId)	return GsonUtil.getErrorJson("不能自己回复自己");
		}

		reply = replyConvert(reply);
		if(reply == null)
			return GsonUtil.getErrorJson("格式错误");
		//上传附件
		if (file != null) {
			MultipartFile[] files = new MultipartFile[1];
			files[0] = file;
			List<String> path = CommonUtil.saveZip(files);
			if (path == null || path.size() == 0) return GsonUtil.getErrorJson("文件上传失败！请检查文件格式或稍后再试");
			reply.setFile(path.get(0));
		}
		User user = new User();
		user.setId(userId);
		reply.setUser(user);
		int result = commentDao.addCommentReply(reply);

		if(result == 1){
			return GsonUtil.getSuccessJson(reply.getId());
		}
		return GsonUtil.getErrorJson("请稍后再试");
	}
	/**
	 * 发表评论
	 * @param userId
	 * @param comment
	 * @return
	 */
	@Transactional
	public String addBlogComment(int userId, Comment comment, MultipartFile file) throws Exception{

		comment = commentConvert(comment);
		if(comment == null){
			return GsonUtil.getErrorJson("格式不正确");
		}
		//上传附件
		if (file != null) {
			MultipartFile[] files = new MultipartFile[1];
			files[0] = file;
			List<String> path = CommonUtil.saveZip(files);
			if (path == null || path.size() == 0) return GsonUtil.getErrorJson("文件上传失败！请检查文件格式或稍后再试");
			comment.setFile(path.get(0));
		}
		User user = new User();
		user.setId(userId);
		comment.setUser(user);
		if (commentDao.addBlogComment(comment) == 1) {
			return GsonUtil.getSuccessJson(comment.getId());
		}
		return GsonUtil.getErrorJson();
	}

	/**
	 * 校验评论
	 * @param comment
	 * @return
	 */
	public Comment commentConvert(Comment comment){
		if(comment == null)	return null;
		if(comment.getComments() == null || comment.getComments().length()>200 || comment.getComments().length()==0){
			return null;
		}
		comment.setComments(HtmlUtils.htmlEscape(comment.getComments()));
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		comment.setTime(date.format(cal.getTime()));
		return comment;
	}

	/**
	 * 校验回复
	 * @param reply
	 * @return
	 */
	public Reply replyConvert(Reply reply){
		if (reply == null)	return null;
		if(reply.getComments() == null || reply.getComments().length()>200 || reply.getComments().length()==0){
			return null;
		}
		reply.setComments(HtmlUtils.htmlEscape(reply.getComments()));
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		reply.setTime(date.format(cal.getTime()));
		return reply;
	}
}
