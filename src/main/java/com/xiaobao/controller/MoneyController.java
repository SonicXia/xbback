package com.xiaobao.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.xiaobao.common.pojo.EUDataGridResult;
import com.xiaobao.common.pojo.XiaobaoResult;
import com.xiaobao.common.utils.codeConertUtil;
import com.xiaobao.service.MoneyService;

@Controller
public class MoneyController {
	
	@Autowired
	private MoneyService moneyService;

	@RequestMapping("/reward/rewardOrderList")
	@ResponseBody
	public EUDataGridResult getMoneyList(Integer page, Integer rows, String name) throws UnsupportedEncodingException{
		
		if(StringUtils.isEmpty(name)){
			EUDataGridResult result = moneyService.getMoneyList(page, rows);
			return result;
		}else{
			String nameUtf = codeConertUtil.iso2Utf(name);
			EUDataGridResult result = moneyService.getMoneyListByName(page, rows, nameUtf);
			return result;
		}	
	}
	
	@RequestMapping(value="/reward/distributeReward", method=RequestMethod.POST)
	@ResponseBody
	public XiaobaoResult distributeReward(@RequestParam String mobiles){		
		XiaobaoResult result = moneyService.distributeReward(mobiles);
		return result;
	}
	
	@RequestMapping(value="/reward/distributeBonus", method=RequestMethod.POST)
	@ResponseBody
	public XiaobaoResult distributeBonus(@RequestParam String mobiles){		
		XiaobaoResult result = moneyService.distributeBonus(mobiles);
		return result;
	}
	
}
