package com.accp.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.biz.PaimaiUserBiz;
import com.accp.biz.PaimaicommodityBiz;
import com.accp.biz.paimaiJpBiz;
import com.accp.pojo.Jl;
import com.accp.pojo.Paimaicommodity;
import com.accp.pojo.Paimaijp;
import com.accp.pojo.Paimaiuser;
import com.github.pagehelper.PageInfo;


@RestController
@RequestMapping("/api/paimai")
public class PaimaiAction {
	@Autowired
	private PaimaiUserBiz userbiz;
	@Autowired
	private PaimaicommodityBiz commbiz;
	@Autowired
	private paimaiJpBiz jbiz;
	/**
	 * 
	 * 登录*/
	@GetMapping("denglu/{username}/{usermm}")
	public Map<String, Object> denglu(@PathVariable String username, @PathVariable String usermm,HttpSession session) {
		Map<String, Object> message = new HashMap<String, Object>();
		 List<Paimaiuser> u=userbiz.loginByNamePwd(username,usermm);
		if(userbiz.loginByNamePwd(username,usermm)!=null) {
			session.setAttribute("user",u);
			message.put("code", "200");
			message.put("msg", "登录成功");
			message.put("data", u);
			message.put("token", session.getId());
		}else {
			message.put("code", "300");
			message.put("msg", "用户名或密码错误");
		}
		return message;
	}
	   //注册
		@PostMapping("zhuce")
		public Map<String, Object> zhuce(@RequestBody Paimaiuser u) {
			int count=userbiz.add(u);
			Map<String, Object> message = new HashMap<String, Object>();
			if(count!=0) {
				message.put("code", "200");
				message.put("msg", "注册成功");
			}else {
				message.put("code", "300");
				message.put("msg", "注册失败");
			}
			return message;
		}
		/*
		 * 忘记密码
		 * */
		
		@GetMapping("wjmm/{pwd}/{phone}")
		public Map<String, Object> wjmm(@PathVariable String pwd,@PathVariable String phone) {
			System.out.println(pwd+phone);
			userbiz.updatebyphone(pwd, phone);
			Map<String, Object> message = new HashMap<String, Object>();
				message.put("code", "200");
				message.put("msg", "修改成功");
			return message;
		}
		/*
		 * 电话
		 * */
		@GetMapping("phone/{phone}")
		public String phone(@PathVariable String phone) {
			if(userbiz.selectByphone(phone)!=null) {
			return userbiz.selectByphone(phone).getPhone();
			}
			else {
				return "";
			}
		}
		/*
		 * 列表
		 * */
		@GetMapping("commdity/{pageNum}/{pageSize}/{pcname}/{describetext}/{startdate}/{stopdate}/{pcfloorprice}")
		public PageInfo<Paimaicommodity> selectcomm(@PathVariable Integer pageNum,@PathVariable Integer pageSize,
				@PathVariable String pcname,@PathVariable String describetext,
				@PathVariable String startdate,@PathVariable String stopdate,
				@PathVariable String pcfloorprice
				) {
			return commbiz.selectOrderPageinfo(pageNum, pageSize, pcname, describetext, startdate, stopdate, pcfloorprice);
		}
		//用户
		@GetMapping("user")
		public Object user(HttpSession session) {
			return session.getAttribute("user");
		}
		//判断是否正在竞拍
		@GetMapping("date/{startdate}/{stopdate}")
		public Map<String, Object> jingpai(@PathVariable String startdate,@PathVariable String stopdate) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Map<String, Object> message = new HashMap<String, Object>();
			try {
				Date kssj1 = sdf.parse(startdate);
				Date jssj1 = sdf.parse(stopdate);
				Date dqsj=new Date();
				/*
				 * String jqsj1=dqsj.toString(); Date dqsj2 = sdf.parse(jqsj1);
				 */
				if(dqsj.getTime()>jssj1.getTime()) {
					message.put("code", "100");
					message.put("msg", "该拍卖品竞拍已结束");
				}else if(dqsj.getTime()<kssj1.getTime()) {
					message.put("code", "200");
					message.put("msg", "敬请期待");
				}else {
					message.put("code", "300");
					message.put("msg", "可以");
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return message;
		}
		//竞拍物
		@GetMapping("shapin/{id}")
		public Paimaicommodity jingpaiwu(@PathVariable int id) {
			return commbiz.jingpai(id);
		}
		//竞拍人
		@GetMapping("jingpairen/{id}")
		public Paimaiuser jingpairen(@PathVariable int id) {
			return  userbiz.selectByid(id);
		}
		//竞拍价
		@GetMapping("jingpaijia/{id}")
		public PageInfo<Paimaijp> jingpaijia(@PathVariable int id) {
			return jbiz.chajl(id);
		}
		//新增记录
		@PostMapping("addjp")
		public Map<String, Object> addjl(@RequestBody Paimaijp jp) {
			jp.setJpdate(new Date());
			int count=jbiz.add(jp);
			Map<String, Object> message = new HashMap<String, Object>();
			if(count!=0) {
				message.put("code", "200");
				message.put("msg", "竞价成功");
			}else {
				message.put("code", "300");
				message.put("msg", "竞价失败");
			}
			return message;
		}
}
