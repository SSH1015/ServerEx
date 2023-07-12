package com.spring.domain;

public class eyeListVO {

	public String eye_num;
	public String eye_list;
	public String eye_location;
	public String eye_ringnum;
	public float eye_latitude;
	public float eye_longitude;
	public String getEye_num() {
		return eye_num;
	}
	public void setEye_num(String eye_num) {
		this.eye_num = eye_num;
	}
	public String getEye_list() {
		return eye_list;
	}
	public void setEye_list(String eye_list) {
		this.eye_list = eye_list;
	}
	public String getEye_location() {
		return eye_location;
	}
	public void setEye_location(String eye_location) {
		this.eye_location = eye_location;
	}
	public String getEye_ringnum() {
		return eye_ringnum;
	}
	public void setEye_ringnum(String eye_ringnum) {
		this.eye_ringnum = eye_ringnum;
	}
	public float getEye_latitude() {
		return eye_latitude;
	}
	public void setEye_latitude(float eye_latitude) {
		this.eye_latitude = eye_latitude;
	}
	public float getEye_longitude() {
		return eye_longitude;
	}
	public void setEye_longitude(float eye_longitude) {
		this.eye_longitude = eye_longitude;
	}
	@Override
	public String toString() {
		return "eyeListVO [eye_num=" + eye_num + ", eye_list=" + eye_list + ", eye_location=" + eye_location
				+ ", eye_ringnum=" + eye_ringnum + ", eye_latitude=" + eye_latitude + ", eye_longitude=" + eye_longitude
				+ "]";
	}
}