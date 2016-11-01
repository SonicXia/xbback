package com.xiaobao.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public EUDataGridResult getOrderList(Integer page, Integer rows, String name, String mobile) throws UnsupportedEncodingException{	
		//name和mobile检索条件为空（无条件搜索）
		if(StringUtils.isEmpty(name) && StringUtils.isEmpty(mobile)){	
			EUDataGridResult result = orderService.getOrderList(page, rows);
			return result;
		}
		//按name搜索
		else if(StringUtils.isNotEmpty(name) && StringUtils.isEmpty(mobile)){	
			String nameUtf = codeConertUtil.iso2Utf(name);	//解决jsp页面传输中文到Spring MVC的乱码问题
			EUDataGridResult result = orderService.getOrderListByName(page, rows, nameUtf);
			return result;
		}
		//按mobile搜索
		else if(StringUtils.isEmpty(name) && StringUtils.isNotEmpty(mobile)){	
			EUDataGridResult result = orderService.getOrderListByMobile(page, rows, mobile);
			return result;
		}
		//按name和mobile联合搜索
		else if(StringUtils.isNotEmpty(name) && StringUtils.isNotEmpty(mobile)){	
			String nameUtf = codeConertUtil.iso2Utf(name);	
			EUDataGridResult result = orderService.getOrderListByNameAndMobile(page, rows, nameUtf, mobile);
			return result;
		}
		return null;
	}
	
	@RequestMapping(value="/order/delete", method=RequestMethod.POST)
	@ResponseBody
	public XiaobaoResult deleteOrderList(@RequestParam String ids){		
		XiaobaoResult result = orderService.deleteOrderList(ids);
		return result;
	}
	
	@RequestMapping("/order/update")
	@ResponseBody
	public XiaobaoResult updateOrder(@RequestBody JSONObject jsoncode){
		String jsonString = jsoncode.toJSONString();	//jsonObject转jsonString
		TbOrder order = JSON.parseObject(jsonString, TbOrder.class);	//json转bean对象
		XiaobaoResult result = orderService.editOrder(order);
		return result;
	}

	
}
