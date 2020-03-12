package com.accp.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
import com.accp.pojo.Paimaiuser;


@RestController
@RequestMapping("/api/paimai")
public class PaimaiAction {
	@Autowired
	private PaimaiUserBiz userbiz;
	@Autowired
	private PaimaicommodityBiz commbiz;
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
}
