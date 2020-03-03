package com.accp.pojo;


import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("student")
public class Student {
  @TableId(type=IdType.AUTO,value = "stuno")
  private Integer stuno;
  private String stuname;
  private String stupwd;
  private String stusex;
  private Date studate;
public Integer getStuno() {
	return stuno;
}



public void setStuno(Integer stuno) {
	this.stuno = stuno;
}
public String getStuname() {
	return stuname;
}
public void setStuname(String stuname) {
	this.stuname = stuname;
}
public String getStupwd() {
	return stupwd;
}
public void setStupwd(String stupwd) {
	this.stupwd = stupwd;
}
public String getStusex() {
	return stusex;
}
public void setStusex(String stusex) {
	this.stusex = stusex;
}
public Date getStudate() {
	return studate;
}
public void setStudate(Date studate) {
	this.studate = studate;
}
public Student() {
	super();
}

public Student(String stuname, String stupwd, String stusex, Date date) {
	super();
	this.stuname = stuname;
	this.stupwd = stupwd;
	this.stusex = stusex;
	this.studate = date;
}

public Student(Integer stuno, String stuname, String stupwd, String stusex, Date studate) {
	super();
	this.stuno = stuno;
	this.stuname = stuname;
	this.stupwd = stupwd;
	this.stusex = stusex;
	this.studate = studate;
}



@Override
public String toString() {
	return "Student [stuno=" + stuno + ", stuname=" + stuname + ", stupwd=" + stupwd + ", stusex=" + stusex
			+ ", studate=" + studate + "]";
}

  
}
