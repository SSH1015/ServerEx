package com.spring.member.vo;

import java.sql.Date;

public class MemberVO {
	//member테이블의 필드를 변수로 선언
	//이곳에 변수명은 EL형식에서 사용
	String userid;
	String userpw;
	String username;
	String useremail;
	Date userregdate;
	Date userupdatedate;
	
	//getter, setter, toString
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public Date getUserregdate() {
		return userregdate;
	}
	public void setUserregdate(Date userregdate) {
		this.userregdate = userregdate;
	}
	public Date getUserupdatedate() {
		return userupdatedate;
	}
	public void setUserupdatedate(Date userupdatedate) {
		this.userupdatedate = userupdatedate;
	}
	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", userpw=" + userpw + ", username=" + username + ", useremail="
				+ useremail + ", userregdate=" + userregdate + ", userupdatedate=" + userupdatedate + "]";
	}
	
}
