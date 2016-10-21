package com.xiaobao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@RequestMapping("/order/list")
	@ResponseBody
	public EUDataGridResult getOrderList(Integer page, Integer rows){
		EUDataGridResult result = orderService.getOrderList(page, rows);
		return result;
	}
	
	@RequestMapping("/order/getByMobile")
	@ResponseBody
	public EUDataGridResult getOrderListByMobile(String smobile, Integer page, Integer rows){
		EUDataGridResult result = orderService.getOrderByMobile(smobile, page, rows);
		return result;
	}
	
	
	@RequestMapping(value="/order/delete", method=RequestMethod.POST)
	@ResponseBody
	public XiaobaoResult createUser(@RequestParam String ids){		
		XiaobaoResult result = orderService.deleteOrderList(ids);
		return result;
	}
	
	@RequestMapping("/order/update")
	@ResponseBody
	public XiaobaoResult editContent(@RequestBody JSONObject jsoncode){
		String jsonString = jsoncode.toJSONString();
		TbOrder order = JSON.parseObject(jsonString, TbOrder.class);
		XiaobaoResult result = orderService.editOrder(order);
		return result;
	}
	
}
