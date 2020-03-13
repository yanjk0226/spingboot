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
import org.springframework.web.bind.annotation.DeleteMapping;
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
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date kssj1 = null;
			Date kssj2=null;
			try {
				if (startdate!="null") {
					kssj1= sdf.parse(startdate);
				}
				if (stopdate!="null") {
					kssj2= sdf.parse(stopdate);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return commbiz.selectOrderPageinfo(pageNum, pageSize, pcname, describetext, kssj1, kssj2, pcfloorprice);
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
		//新增修改拍卖品
				@PostMapping("addpm")
				public Map<String, Object> addpmp(@RequestBody Paimaicommodity pm) {
					Map<String, Object> message = new HashMap<String, Object>();
						if(pm.getPcid()==0) {
							int count =commbiz.add(pm) ;
							if(count>0) {
								message.put("code", "200");
								message.put("msg", "拍卖品添加成功");
							}else{
								message.put("code", "300");
								message.put("msg", "拍卖品添加失败");
							}
						}else {
							int count=commbiz.update(pm);
							if(count>0) {
								message.put("code", "200");
								message.put("msg", "拍卖品修改成功");
							}else{
								message.put("code", "300");
								message.put("msg", "拍卖品修改失败");
							}
						}
						
					return message;
				}
				//自己的拍卖的详情
				@GetMapping("zzdpmxx")
				public List<Paimaicommodity> zzdpmxx() {
					return commbiz.select();
				}
				@GetMapping("ck/{pcid}")
				public String ck(@PathVariable Integer pcid) {
					int id=0;
					int price=0;
					PageInfo<Paimaijp> pm=jbiz.cha(pcid);
					System.out.println(pm);
					if((pm.getList().size()>0)) {
					for (Paimaijp jp : pm.getList()) {
						id=jp.getUserid();price=jp.getJpprice();
					}
					Paimaiuser user=userbiz.selectByid(id);
					return "该拍卖品已被"+user.getUsername()+"已"+price+"购买。"+"请打电话联系:"+user.getPhone()+"发货";
					
					}else {
						return "该拍卖品已流拍";
					}
				}
				//比较时间
				@GetMapping("datebj/{date}")
				public Map<String, Object> datebj(@PathVariable Date date) {
					Map<String, Object> message = new HashMap<String, Object>();
					int count=date.compareTo(new Date());
					if(count>0) {
						message.put("code", "200");
						message.put("msg", "可修改");
					}else{
						message.put("code", "300");
						message.put("msg", "拍卖品修改失败,开始时间已到!");
					}
					return message;
				}
				@GetMapping("datebj2/{date}")
				public Map<String, Object> datebj2(@PathVariable Date date) {
					Map<String, Object> message = new HashMap<String, Object>();
					int count=date.compareTo(new Date());
					if(count<0) {
						message.put("code", "200");
						message.put("msg", "可查看");
					}else{
						message.put("code", "300");
						message.put("msg", "拍卖品查看失败,时间未结束!");
					}
					return message;
				}
				@DeleteMapping("shangchu/{pcid}")
				public Map<String, Object> shangchu(@PathVariable int pcid ) {
					Map<String, Object> message = new HashMap<String, Object>();
					try {
							commbiz.del(pcid);
							message.put("code", "200");
							message.put("msg", "删除成功");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return message;
				}
}
