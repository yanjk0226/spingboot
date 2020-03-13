package com.accp.biz;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.accp.dao.PaimaicommodityDao;
import com.accp.pojo.Paimaicommodity;
import com.accp.pojo.Paimaiuser;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class PaimaicommodityBiz {
	@Autowired
	private PaimaicommodityDao dao;
	/**
	 * 查询分页 （所有） 追加条件 （对象）
	 * */
	public PageInfo<Paimaicommodity> selectOrderPageinfo(int n,int s, String pmpname, String pmpms,Date pmpkssj, Date pmpjssj,String pmpqpj) {
		QueryWrapper<Paimaicommodity> qw=Wrappers.query();
		if(!pmpname.equals("null")) {qw.like("pcname", pmpname);};
		if(!pmpms.equals("null")) {qw.like("describetext",pmpms);};
		if(!(pmpkssj==null)) {qw.ge("startdate", pmpkssj);};
		if(!(pmpjssj==null)) {qw.le("stopdate",pmpjssj);};
		if(!pmpqpj.equals("null")) {qw.eq("pcfloorprice",pmpqpj);};
		PageHelper.startPage(n, s);
		return new PageInfo<Paimaicommodity>(dao.selectList(qw));
	}
	public Paimaicommodity jingpai(int id) {
		return dao.selectById(id);
	}
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int add(Paimaicommodity pm) {
		return dao.insert(pm);
	}
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int update(Paimaicommodity pm) {
		return dao.updateById(pm);
	}
	public List<Paimaicommodity> select() {
		return dao.selectList(null);
	}
	public int del(Integer id) {
		return dao.deleteById(id);
	}
}
