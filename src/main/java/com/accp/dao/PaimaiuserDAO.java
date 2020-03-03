package com.accp.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.accp.pojo.Paimaiuser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface PaimaiuserDAO extends BaseMapper<Paimaiuser> {
	
	@Select("UPDATE paimaiuser set userpwd=#{pwd} where phone=#{phone}")
	Paimaiuser updatebyphone(@Param("pwd") String pwd,@Param("phone") String phone);
}