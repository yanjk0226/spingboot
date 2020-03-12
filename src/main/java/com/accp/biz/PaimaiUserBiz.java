package com.accp.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.PaimaiuserDAO;
import com.accp.pojo.Paimaiuser;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;


@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class PaimaiUserBiz {
	@Autowired
	private PaimaiuserDAO dao;
	/****
	 * 登录 根据name 和 pwd
	 * **/
	public List<Paimaiuser> loginByNamePwd(String name,String pwd) {
		QueryWrapper<Paimaiuser> qw=Wrappers.query();
		qw.eq("username", name).eq("userpwd", pwd);
		return dao.selectList(qw);
	}
	/**
	 * 新增 传个对象过来 (注册)
	 * */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int add(Paimaiuser user) {
		return dao.insert(user);
		
	}
	/**
	 * 根据 id 查询
	 * **/
	public Paimaiuser selectByid(Integer id) {
		return dao.selectById(id);
	}
	/**
	 * 根据 phone 查询
	 * **/
	public Paimaiuser selectByphone(String phone) {
		return dao.selectByphone(phone);
	}
    /**
        * 根据手机号修改密码
     * */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public void updatebyphone(String pwd,String phone) {
		 dao.updatebyphone(pwd, phone);
	}
	/**
	 * 
	 * */
	
	
}
