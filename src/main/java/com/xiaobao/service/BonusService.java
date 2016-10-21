package com.xiaobao.service;

import com.xiaobao.common.pojo.EUDataGridResult;

public interface BonusService {
	
	EUDataGridResult getBonusList(int page, int rows);
	
}
