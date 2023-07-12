package com.spring.domain;

import java.sql.Date;

public class MemberVO {
	public String userid;
	public String userpw;
	public String username;
	public String useremail;
	public Date userregdate;
	public Date userupdatedate;
	public String admin;
	
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
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", userpw=" + userpw + ", username=" + username + ", useremail="
				+ useremail + ", userregdate=" + userregdate + ", userupdatedate=" + userupdatedate + ", admin=" + admin
				+ "]";
	}
}