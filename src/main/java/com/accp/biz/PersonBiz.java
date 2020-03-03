package com.accp.biz;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.IPersonDao;
import com.accp.pojo.Person;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class PersonBiz {

	@Autowired
	private IPersonDao personDao;

	/**
	 * 分页查询
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageInfo<Person> findPersonListByPage(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<Person>(personDao.selectList(null));
	}

	/**
	 * 根据姓名模糊分页查询
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageInfo<Person> findPersonListWithNameByPage(String name, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		QueryWrapper<Person> qw=Wrappers.query();
		qw.like("pname", name);
		return new PageInfo<Person>(personDao.selectList(qw));
	}

	/**
	 * 获得单个会员信息
	 * 
	 * @param pid
	 * @return
	 */
	public Person getPersonById(Integer pid) {
		return personDao.selectById(pid);
	}

	/**
	 * 根据会员id修改会员信息
	 * 
	 * @param person
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public void modifyPerson(Person person) {
		personDao.updateById(person);
	}

	/**
	 * 新增会员信息
	 * 
	 * @param person
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public void addPerson(Person person) {
		personDao.insert(person);
		
	}
}
