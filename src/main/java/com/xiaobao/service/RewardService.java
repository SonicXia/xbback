package com.xiaobao.service;

import com.xiaobao.common.pojo.EUDataGridResult;
import com.xiaobao.common.pojo.XiaobaoResult;

public interface RewardService {
	
	EUDataGridResult getRewardList(int page, int rows);
	
	XiaobaoResult distributeReward(String mobiles);
	
	XiaobaoResult distributeBonus(String mobiles);
	
}
