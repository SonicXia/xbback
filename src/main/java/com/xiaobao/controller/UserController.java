package com.xiaobao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xiaobao.common.pojo.XiaobaoResult;
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

	@RequestMapping(value="/user/insert", method=RequestMethod.POST)
	@ResponseBody
	public XiaobaoResult createUser(@RequestBody JSONObject jsoncode){
		String name = jsoncode.getString("name");
		String cardId = jsoncode.getString("cardId");
		String mobile = jsoncode.getString("mobile");
		String password = jsoncode.getString("password");
		String email = jsoncode.getString("email");
		String referrer = jsoncode.getString("referrer");
		int teamId = jsoncode.getIntValue("teamId");
		XiaobaoResult result = userService.insertUser(name, cardId, mobile, password, email, referrer, teamId);
		return result;
		
	}
	
}
