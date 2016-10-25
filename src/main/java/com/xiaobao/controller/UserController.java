package com.xiaobao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaobao.common.pojo.EUDataGridResult;
import com.xiaobao.common.pojo.XiaobaoResult;
import com.xiaobao.pojo.TbOrder;
import com.xiaobao.pojo.TbUser;
import com.xiaobao.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
//	@RequestMapping("/user/{memberId}")
//	@ResponseBody
//	public TbUser getUserByMemberId(@PathVariable String memberId){
//		TbUser user = userService.getUserByMemberId(memberId);
//		return user;
//		
//	}
	
	@RequestMapping("/user/{name}")
	@ResponseBody
	public TbUser getUserByName(@PathVariable String name){
		TbUser user = userService.getUserByName(name);
		return user;
		
	}

//	@RequestMapping(value="/user/insert", method=RequestMethod.POST)
//	@ResponseBody
//	public XiaobaoResult createUser(@RequestBody JSONObject jsoncode){
//		String name = jsoncode.getString("name");
//		String cardId = jsoncode.getString("cardId");
//		String mobile = jsoncode.getString("mobile");
//		String password = jsoncode.getString("password");
//		String email = jsoncode.getString("email");
//		String referrer = jsoncode.getString("referrer");
//		String referrerMobile = jsoncode.getString("referrerMobile");
//		int teamId = jsoncode.getIntValue("teamId");
//		XiaobaoResult result = userService.insertUser(name, cardId, mobile, password, email, referrer, teamId);
//		return result;
//		
//	}
	
	@RequestMapping(value="/user/save", method=RequestMethod.POST)
	@ResponseBody
	public XiaobaoResult createUser(@RequestBody JSONObject jsoncode){		
		String jsonString = jsoncode.toJSONString();
		TbUser user = JSON.parseObject(jsonString, TbUser.class);
		XiaobaoResult result = userService.saveUser(user);
		return result;	
	}
	
	@RequestMapping("/user/list")
	@ResponseBody
	public EUDataGridResult getUserList(Integer page, Integer rows){
		EUDataGridResult result = userService.getUserList(page, rows);
		return result;
	}
	
	@RequestMapping(value="/user/delete", method=RequestMethod.POST)
	@ResponseBody
	public XiaobaoResult deleteUserList(@RequestParam String mobiles){		
		XiaobaoResult result = userService.deleteUserList(mobiles);
		return result;
	}
	
	@RequestMapping("/user/update")
	@ResponseBody
	public XiaobaoResult updateUser(@RequestBody JSONObject jsoncode){
		String jsonString = jsoncode.toJSONString();	//jsonObject转jsonString
		TbUser user = JSON.parseObject(jsonString, TbUser.class);	//jsonString转bean对象
		XiaobaoResult result = userService.updateUser(user);
		return result;
	}
	
}
