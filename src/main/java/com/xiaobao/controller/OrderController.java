package com.xiaobao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaobao.common.pojo.XiaobaoResult;
import com.xiaobao.pojo.TbOrder;
import com.xiaobao.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/order/save", method=RequestMethod.POST)
	@ResponseBody
	public XiaobaoResult createUser(@RequestBody JSONObject jsoncode){		
		String jsonString = jsoncode.toJSONString();
		TbOrder order = JSON.parseObject(jsonString, TbOrder.class);
		XiaobaoResult result = orderService.saveOrder(order);
		return result;	
	}
	
//	@RequestMapping(value="/order/save", method=RequestMethod.POST)
//	@ResponseBody
//	public XiaobaoResult createUser(@RequestParam TbOrder order){		
//		
//		XiaobaoResult result = orderService.saveOrder(order);
//		return result;	
//	}
	
	@RequestMapping(value="/order/findAll", method=RequestMethod.POST)
	@ResponseBody
	public XiaobaoResult findAll(){
		return orderService.findAll();
	}
	
}
