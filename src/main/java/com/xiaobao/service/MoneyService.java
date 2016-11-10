package com.xiaobao.service;

import com.xiaobao.common.pojo.EUDataGridResult;
import com.xiaobao.common.pojo.XiaobaoResult;

public interface MoneyService {
	
	EUDataGridResult getMoneyList(int page, int rows);
	
	EUDataGridResult getMoneyListByName(int page, int rows, String name);
	
	EUDataGridResult getMoneyListByMobile(int page, int rows, String mobile);
	
	EUDataGridResult getMoneyListByDate(int page, int rows, String releasedate);
	
	EUDataGridResult getMoneyListByNameAndMobile(int page, int rows, String name, String mobile);
	
	EUDataGridResult getMoneyListByNameAndDate(int page, int rows, String name, String releasedate);
	
	EUDataGridResult getMoneyListByMobileAndDate(int page, int rows, String mobile, String releasedate);
	
	EUDataGridResult getMoneyListByNameAndMobileAndDate (int page, int rows, String name, String mobile, String releasedate);
	
	XiaobaoResult distributeReward(String mobiles, String rewards);
	
	XiaobaoResult distributeBonus(String mobiles);
	
	boolean generateBonus(String name, String mobile);
	
}
