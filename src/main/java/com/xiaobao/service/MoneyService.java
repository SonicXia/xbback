package com.xiaobao.service;

import com.xiaobao.common.pojo.EUDataGridResult;
import com.xiaobao.common.pojo.XiaobaoResult;

public interface MoneyService {
	
	EUDataGridResult getMoneyList(int page, int rows);
	
	EUDataGridResult getMoneyListByName(int page, int rows, String name);
	
	XiaobaoResult distributeReward(String mobiles);
	
	XiaobaoResult distributeBonus(String mobiles);
	
	
}
