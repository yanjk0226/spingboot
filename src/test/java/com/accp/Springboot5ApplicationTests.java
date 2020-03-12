package com.accp;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.accp.biz.PaimaiUserBiz;
import com.accp.biz.PaimaicommodityBiz;
import com.accp.biz.StudentBiz;
import com.accp.biz.paimaiJpBiz;
import com.accp.dao.IPersonDao;
import com.accp.dao.StudentDao;
import com.accp.pojo.Person;
import com.accp.pojo.Student;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.mysql.cj.protocol.Warning;

import ch.qos.logback.core.status.WarnStatus;

@SpringBootTest
public class Springboot5ApplicationTests {

	@Autowired
	private IPersonDao dao;
	
	@Autowired
	private StudentDao sdao;
	
	@Autowired
	private StudentBiz sbiz;
	
	
	@Autowired
	private PaimaiUserBiz ubiz;
	
	@Autowired
	private PaimaicommodityBiz cbiz;
	@Autowired
	private paimaiJpBiz jbiz;
	
	@Test
	public void text() {
//		System.out.println(jbiz.chajl(1));
//		System.out.println(cbiz.selectOrderPageinfo(1, 1, "唐","好","2020-1-1","2020-5-9","1000000000"));
		//sdao.insert(new Student("xjj", "123456","男", new Date()));
//		PageHelper.startPage(1,1);
//		List<Student> data=sdao.selectList(null);
		//sdao.updateById(new Student(1,"xjj2",null,null,null));
		//sdao.deleteById(2);
//		data.forEach(temp->{
//			System.out.println(temp);
//		});
//		Student stu=sdao.selectById(1);
//		System.out.println(stu);
//		QueryWrapper<Student> qw=Wrappers.query();//qw.orderByDesc("studate")
//		qw.likeRight("stuname", "x").or(temp->{
//			temp.eq("stusex","男");
//		});
//		List<Student> data=sdao.selectList(qw);
//		data.forEach(temp->{
//			System.out.println(temp);
//		});
//		System.out.println(sdao.selectCount(qw));
//		LocalDate ltime=LocalDate.now().minusYears(18);
//		String time=ltime.toString();
//		System.out.println(time);
		
//		sbiz.selectListBydate().forEach(temp->{
//			System.out.println(temp);
//		});
//	}
//		ubiz.updatebyphone("1234567", "1234567891");
	}
	@Test
	public void contextLoads() {
		//1.新增,修改，移除
		//int count=dao.insert(new Person("小标",1,new Date()));
		//int count=dao.updateById(new Person(10005,"小标标",null,null));
//		int count=dao.deleteById(10005);
//		if(count!=0) {
//			System.out.println("持久化成功");
//		}else {
//			System.out.println("持久化失败");
//		}
		//2.查询
		//标准查询
//		List<Person> data=dao.selectList(null);
//		Person obj=dao.selectById(4);
		//组合条件查询
//		QueryWrapper<Person> qw=Wrappers.query();
//		//qw.eq("pname", "李星").or().eq("psex", 0);
//		//qw.like("pname", "李");
//		qw.likeRight("pname", "李").eq("psex", 1).or(temp->{
//			temp.likeRight("pname", "杜").eq("psex", 0);
//		}).orderByDesc("pdate");
//		List<Person> data=dao.selectList(qw);
//		data.forEach(temp->{
//			System.out.println(temp);
//		});
		//登陆
//		QueryWrapper<Person> qw=Wrappers.query();
//		qw.eq("name", "admin").eq("pwd", "123");
//		int count=dao.selectCount(qw);
//		if(count!=0) {
//			System.out.println("登陆成功");
//		}else {
//			System.out.println("登陆失败");
//		}
//		Person person=dao.selectOne(qw);
//		if(person!=null) {
//			System.out.println("登陆成功");
//		}else {
//			System.out.println("登陆失败");
//		}
		
	}

}
