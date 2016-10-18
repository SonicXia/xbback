package com.xiaobao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xiaobao.common.pojo.XiaobaoResult;
import com.xiaobao.common.utils.JsonUtils;
import com.xiaobao.pojo.TbOrder;
import com.xiaobao.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/order/insert", method=RequestMethod.POST)
	@ResponseBody
	public XiaobaoResult createUser(@RequestBody JSONObject jsoncode){
		TbOrder tbOrder = new TbOrder();
		JsonUtils.jsonToPojo(jsoncode, );
		
		XiaobaoResult result = orderService.insertOrder(cardId, orderCnt, address, amont, bonus, reward, remark, investmentDate, rewardMonths, extraDays);
		return result;
		
	}
	
}
