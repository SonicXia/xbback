package com.xiaobao.service;

import com.xiaobao.common.pojo.EUDataGridResult;

public interface RewardService {
	
	EUDataGridResult getRewardList(int page, int rows);
	
}
