package com.accp.pojo;

import java.util.Date;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

//2.添加实体元注解
@TableName("tbl_person")
public class Person {

	//IdType.INPUT:自然主键    IdType.AUTO:自动标识
	@TableId(value = "pid",type = IdType.AUTO)
	//@TableField("pid")
	private Integer pid;
	private String pname;
	private Integer psex;
	private Date pdate;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String name) {
		this.pname = name;
	}

	public Integer getPsex() {
		return psex;
	}

	public void setPsex(Integer psex) {
		this.psex = psex;
	}

	public Date getPdate() {
		return pdate;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	public Person(Integer pid, String name, Integer psex, Date pdate) {
		super();
		this.pid = pid;
		this.pname = name;
		this.psex = psex;
		this.pdate = pdate;
	}

	public Person() {
		super();
	}

	public Person(String pname, Integer psex, Date pdate) {
		super();
		this.pname = pname;
		this.psex = psex;
		this.pdate = pdate;
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", psex=" + psex + ", pdate=" + pdate + "]";
	}

	public Person(Integer pid, String pname) {
		super();
		this.pid = pid;
		this.pname = pname;
	}

}
