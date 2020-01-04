package com.robot.entity;

/**
 * 回复
 */
public class Reply {

	private int id;
	private String comments;	//回复内容
	private String time;	//时间
	private User user;	//用户
	private int commentId;	//评论的id
	private int fromReplyId;	//回复的id
	private String file;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getCommentId() {
		return commentId;
	}

	public int getFromReplyId() {
		return fromReplyId;
	}

	public void setFromReplyId(int fromReplyId) {
		this.fromReplyId = fromReplyId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Reply{" + "id=" + id + ", comments='" + comments + '\'' + ", time='" + time + '\'' + ", user=" + user + ", commentId=" + commentId + ", fromReplyId=" + fromReplyId + ", file='" + file + '\'' + '}';
	}
}
