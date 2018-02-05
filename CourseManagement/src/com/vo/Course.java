package com.vo;

public class Course {
	private String cour_id;		// 课程号
	private String name;		// 课程名
	private String mark;		// 学分
	private String prepare;		// 预修课
	private String dep;			//系别
	private String class_id;	//班级号
	private String room_id;		// 课室号
	private String cour_time;	// 上课时间
	private String tea_name;	// 教师名
	
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCour_id() {
		return cour_id;
	}
	public void setCour_id(String cour_id) {
		this.cour_id = cour_id;
	}
	public String getClass_id() {
		return class_id;
	}
	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}
	public String getRoom_id() {
		return room_id;
	}
	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}
	public String getCour_time() {
		return cour_time;
	}
	public void setCour_time(String cour_time) {
		this.cour_time = cour_time;
	}
	public String getTea_name() {
		return tea_name;
	}
	public void setTea_name(String tea_name) {
		this.tea_name = tea_name;
	}
	public String getPrepare() {
		return prepare;
	}
	public void setPrepare(String prepare) {
		this.prepare = prepare;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}	
}
