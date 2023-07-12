package com.spring.domain;

import java.sql.Date;

public class ReplyVO {


	public int bno;
	public int rno;
	public String re_userid;
	public String replytext;
	public String re_username;
	public String replyer;
	public Date re_regdate;
	public Date re_updatedate;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getRe_userid() {
		return re_userid;
	}
	public void setRe_userid(String re_userid) {
		this.re_userid = re_userid;
	}
	public String getReplytext() {
		return replytext;
	}
	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}
	public String getRe_username() {
		return re_username;
	}
	public void setRe_username(String re_username) {
		this.re_username = re_username;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public Date getRe_regdate() {
		return re_regdate;
	}
	public void setRe_regdate(Date re_regdate) {
		this.re_regdate = re_regdate;
	}
	public Date getRe_updatedate() {
		return re_updatedate;
	}
	public void setRe_updatedate(Date re_updatedate) {
		this.re_updatedate = re_updatedate;
	}
	@Override
	public String toString() {
		return "ReplyVO [bno=" + bno + ", rno=" + rno + ", re_userid=" + re_userid + ", replytext=" + replytext
				+ ", re_username=" + re_username + ", replyer=" + replyer + ", re_regdate=" + re_regdate
				+ ", re_updatedate=" + re_updatedate + "]";
	}
}