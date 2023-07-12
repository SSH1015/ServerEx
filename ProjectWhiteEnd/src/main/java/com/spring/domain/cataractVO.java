package com.spring.domain;

import java.sql.Date;

public class cataractVO {
	public String c_id;
	public String c_name;
	public String c_catecode;
	public String c_detail;
	public Date c_regdate;
	public Date c_updatedate;
	public String c_img;
	public String c_simg;
	public int c_num;
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_catecode() {
		return c_catecode;
	}
	public void setC_catecode(String c_catecode) {
		this.c_catecode = c_catecode;
	}
	public String getC_detail() {
		return c_detail;
	}
	public void setC_detail(String c_detail) {
		this.c_detail = c_detail;
	}
	public Date getC_regdate() {
		return c_regdate;
	}
	public void setC_regdate(Date c_regdate) {
		this.c_regdate = c_regdate;
	}
	public Date getC_updatedate() {
		return c_updatedate;
	}
	public void setC_updatedate(Date c_updatedate) {
		this.c_updatedate = c_updatedate;
	}
	public String getC_img() {
		return c_img;
	}
	public void setC_img(String c_img) {
		this.c_img = c_img;
	}
	public String getC_simg() {
		return c_simg;
	}
	public void setC_simg(String c_simg) {
		this.c_simg = c_simg;
	}
	public int getC_num() {
		return c_num;
	}
	public void setC_num(int c_num) {
		this.c_num = c_num;
	}
	@Override
	public String toString() {
		return "cataractVO [c_id=" + c_id + ", c_name=" + c_name + ", c_catecode=" + c_catecode + ", c_detail="
				+ c_detail + ", c_regdate=" + c_regdate + ", c_updatedate=" + c_updatedate + ", c_img=" + c_img
				+ ", c_simg=" + c_simg + ", c_num=" + c_num + "]";
	}
	
}