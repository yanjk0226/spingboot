package com.accp.biz;

import java.time.LocalDate;
import java.util.List;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.StudentDao;
import com.accp.pojo.Person;
import com.accp.pojo.Student;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;


@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class StudentBiz {
	@Autowired
	private StudentDao dao;
//	1．添加学员信息：姓名,密码,性别,生日
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public void add(Student stu) {
		dao.insert(stu);
		
	}
//	2．修改学员信息：用户必须输入学号，才能修改姓名，密码,性别，生日
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public void modify(Student stu) {
		dao.updateById(stu);
	}
//	3．删除学员信息：用户必须输入学号才能删除学生信息。
	public void delect(Integer stuid) {
		dao.deleteById(stuid);
	}
//	4．查询所有学员信息：按照生日降序显示所有学生表列数据
	public List<Student> selectList() {
		QueryWrapper<Student> qw=Wrappers.query();
		qw.orderByDesc("studate");
		return dao.selectList(qw);
	}
//	5．查询所有未成年男学员信息
	public List<Student> selectListBydate() {
		QueryWrapper<Student> qw=Wrappers.query();
		LocalDate ltime=LocalDate.now().minusYears(18);
		String time=ltime.toString();
		qw.ge("studate", time).eq("stusex", "男");
		return dao.selectList(qw);
	}
//	6．根据学号加载一个学生信息
	public Student selectByid(Integer id){
		return dao.selectById(id);
	}
//	7．根据学员姓名模糊查询学员信息：用户必须输入学员姓名才能模糊查询。
	public List<Student> selectByname(String name) {
		QueryWrapper<Student> qw=Wrappers.query();
		qw.like("stuname", name);
		return dao.selectList(qw);
	}
//	8．根据学员姓名和密码实现登陆验证
	public List<Student> selectdenglu(String name,String pwd) {
		QueryWrapper<Student> qw=Wrappers.query();
		qw.eq("stuname", name).eq("stupwd", pwd);
		return dao.selectList(qw);
	}
}
