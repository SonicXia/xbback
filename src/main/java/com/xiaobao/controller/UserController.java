package com.xiaobao.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaobao.common.pojo.EUDataGridResult;
import com.xiaobao.common.pojo.XiaobaoResult;
import com.xiaobao.common.utils.codeConertUtil;
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
	public EUDataGridResult getUserList(Integer page, Integer rows, String name, String mobile) throws UnsupportedEncodingException{
		//name和mobile检索条件为空（无条件搜索）
		if(StringUtils.isEmpty(name) && StringUtils.isEmpty(mobile)){	
			EUDataGridResult result = userService.getUserList(page, rows);
			return result;
		}
		//按name搜索
		else if(StringUtils.isNotEmpty(name) && StringUtils.isEmpty(mobile)){	
			String nameUtf = codeConertUtil.iso2Utf(name);	//解决jsp页面传输中文到Spring MVC的乱码问题
			EUDataGridResult result = userService.getUserByName(page, rows, nameUtf);
			return result;
		}
		//按mobile搜索
		else if(StringUtils.isEmpty(name) && StringUtils.isNotEmpty(mobile)){	
			EUDataGridResult result = userService.getUserByMobile(page, rows, mobile);
			return result;
		}
		//按name和mobile联合搜索
		else if(StringUtils.isNotEmpty(name) && StringUtils.isNotEmpty(mobile)){	
			String nameUtf = codeConertUtil.iso2Utf(name);	
			EUDataGridResult result = userService.getUserByNameAndMobile(page, rows, nameUtf, mobile);
			return result;
		}
		return null;
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
