package com.accp.biz;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.PaimaijpDAO;
import com.accp.pojo.Paimaicommodity;
import com.accp.pojo.Paimaijp;
import com.accp.pojo.Person;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class paimaiJpBiz {
	@Autowired
	private PaimaijpDAO dao;
	public PageInfo<Paimaijp> chajl(int pcid) {
		QueryWrapper<Paimaijp> qw=Wrappers.query();
		qw.eq("pcid", pcid).orderByDesc("jpprice");
		PageHelper.startPage(1, 3);
		return new PageInfo<Paimaijp>(dao.selectList(qw));
	}
	public PageInfo<Paimaijp> cha(int pcid) {
		QueryWrapper<Paimaijp> qw=Wrappers.query();
		qw.eq("pcid", pcid).orderByDesc("jpprice");
		PageHelper.startPage(1,1);
		return new PageInfo<Paimaijp>(dao.selectList(qw));
	}
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int add(Paimaijp jp) {
		return dao.insert(jp);
		
	}
}
