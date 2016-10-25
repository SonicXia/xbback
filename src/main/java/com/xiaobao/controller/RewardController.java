package com.xiaobao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaobao.common.pojo.EUDataGridResult;
import com.xiaobao.service.RewardService;

@Controller
public class RewardController {
	
	@Autowired
	private RewardService rewardService;

	@RequestMapping("/reward/rewardOrderList")
	@ResponseBody
	public EUDataGridResult getRewardOrderList(Integer page, Integer rows){
		EUDataGridResult result = rewardService.getRewardList(page, rows);
		return result;
	}
	
}
