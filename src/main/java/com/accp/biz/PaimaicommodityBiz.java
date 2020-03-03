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
	public PageInfo<Paimaicommodity> selectOrderPageinfo(Integer pageNum, Integer pageSize,Paimaicommodity pm){
		PageHelper.startPage(pageNum, pageSize);
		QueryWrapper<Paimaicommodity> qw=Wrappers.query();
		//qw.like("pcname", pm.getPcname()).like("describe", pm.getDescribe()).eq("pcstartingprice",pm.getPcstartingprice()).eq("startdate",pm.getStartdate()).eq("stopdate",pm.getStopdate());
		return new PageInfo<Paimaicommodity>(dao.selectList(qw));
	}
}
