package com.accp.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	public PageInfo<Paimaicommodity> selectOrderPageinfo(int n,int s, String pmpname, String pmpms,String pmpkssj, String pmpjssj,String pmpqpj) {
		QueryWrapper<Paimaicommodity> qw=Wrappers.query();
		if(!pmpname.equals("null")) {qw.like("pcname", pmpname);};
		if(!pmpms.equals("null")) {qw.like("describetext",pmpms);};
		if(!pmpkssj.equals("null")) {qw.ge("startdate", pmpkssj);};
		if(!pmpjssj.equals("null")) {qw.le("stopdate",pmpjssj);};
		if(!pmpqpj.equals("null")) {qw.between("pcfloorprice",(Integer.parseInt(pmpqpj)-1000),(Integer.parseInt(pmpqpj)+1000));};
		PageHelper.startPage(n, s);
		return new PageInfo<Paimaicommodity>(dao.selectList(qw));
	}
	public Paimaicommodity jingpai(int id) {
		return dao.selectById(id);
	}
}
