package com.xiaobao.controller;

import java.io.UnsupportedEncodingException;

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

	@RequestMapping("/money/moneyList")
	@ResponseBody
	public EUDataGridResult getMoneyList(Integer page, Integer rows, String name, String mobile, String releasedate) throws UnsupportedEncodingException{
		//name、mobile和releasedate检索条件为空（无条件搜索）
		if(StringUtils.isEmpty(name) && StringUtils.isEmpty(mobile) && StringUtils.isEmpty(releasedate)){	
			EUDataGridResult result = moneyService.getMoneyList(page, rows);
			return result;
		}
		//按name搜索
		else if(StringUtils.isNotEmpty(name) && StringUtils.isEmpty(mobile) && StringUtils.isEmpty(releasedate)){	
			String nameUtf = codeConertUtil.iso2Utf(name);	//解决jsp页面传输中文到Spring MVC的乱码问题
			EUDataGridResult result = moneyService.getMoneyListByName(page, rows, nameUtf);
			return result;
		}
		//按mobile搜索
		else if(StringUtils.isEmpty(name) && StringUtils.isNotEmpty(mobile) && StringUtils.isEmpty(releasedate)){	
			EUDataGridResult result = moneyService.getMoneyListByMobile(page, rows, mobile);
			return result;
		}
		//按releasedate搜索
		else if(StringUtils.isEmpty(name) && StringUtils.isEmpty(mobile) && StringUtils.isNotEmpty(releasedate)){	
			String nameUtf = codeConertUtil.iso2Utf(name);	
			EUDataGridResult result = moneyService.getMoneyListByDate(page, rows, releasedate);
			return result;
		}
		//按name和mobile联合搜索
		else if(StringUtils.isNotEmpty(name) && StringUtils.isNotEmpty(mobile) && StringUtils.isEmpty(releasedate)){	
			String nameUtf = codeConertUtil.iso2Utf(name);	
			EUDataGridResult result = moneyService.getMoneyListByNameAndMobile(page, rows, nameUtf, mobile);
			return result;
		}
		//按name和releasedate联合搜索
		else if(StringUtils.isNotEmpty(name) && StringUtils.isEmpty(mobile) && StringUtils.isNotEmpty(releasedate)){	
			String nameUtf = codeConertUtil.iso2Utf(name);	
			EUDataGridResult result = moneyService.getMoneyListByNameAndDate(page, rows, nameUtf, releasedate);
			return result;
		}
		//按mobile和releasedate联合搜索
		else if(StringUtils.isEmpty(name) && StringUtils.isNotEmpty(mobile) && StringUtils.isNotEmpty(releasedate)){	
			EUDataGridResult result = moneyService.getMoneyListByMobileAndDate(page, rows, mobile, releasedate);
			return result;
		}
		//按name、mobile和releasedate联合搜索
		else if(StringUtils.isNotEmpty(name) && StringUtils.isNotEmpty(mobile) && StringUtils.isNotEmpty(releasedate)){
			String nameUtf = codeConertUtil.iso2Utf(name);
			EUDataGridResult result = moneyService.getMoneyListByNameAndMobileAndDate(page, rows, nameUtf, mobile, releasedate);
			return result;
		}
		return null;	
	}
	
	@RequestMapping(value="/money/distributeReward", method=RequestMethod.POST)
	@ResponseBody
	public XiaobaoResult distributeReward(@RequestParam String mobiles, @RequestParam String rewards){
		System.err.println(mobiles);
		System.err.println(rewards);
		XiaobaoResult result = moneyService.distributeReward(mobiles, rewards);
		return result;
	}
	
	@RequestMapping(value="/money/distributeBonus", method=RequestMethod.POST)
	@ResponseBody
	public XiaobaoResult distributeBonus(@RequestParam String mobiles){		
		XiaobaoResult result = moneyService.distributeBonus(mobiles);
		return result;
	}
	
}
