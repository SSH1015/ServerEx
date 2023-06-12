package com.spring.member.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class boardVO {
	//getter와 setter 생성전에 대소문자 확인, 오타 확인
	int bno;  //게시글 번호
	String title; //제목
	String content; //내용
	String writer; //작성자 id
	Date regdate; //작성일
	int viewcnt;  //조회수    --board 테이블
	String username; //작성자 --member 테이블(Join)
	int recnt; //댓글         --reply 테이블(Join)
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getRecnt() {
		return recnt;
	}
	public void setRecnt(int recnt) {
		this.recnt = recnt;
	}
	@Override
	public String toString() {
		return "boardVO [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regdate="
				+ regdate + ", viewcnt=" + viewcnt + ", username=" + username + ", recnt=" + recnt + "]";
	}
	
	
	
}
