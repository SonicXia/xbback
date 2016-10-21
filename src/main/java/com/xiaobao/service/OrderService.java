package com.xiaobao.service;

import com.xiaobao.common.pojo.EUDataGridResult;
import com.xiaobao.common.pojo.XiaobaoResult;
import com.xiaobao.pojo.TbOrder;

public interface OrderService {
	
//	public XiaobaoResult insertOrder(String cardId, int orderCnt, String address, double amont, 
//			String remark, String investmentDate, int rewardMonths, int extraDays);
	
	XiaobaoResult saveOrder(TbOrder order);
	
	EUDataGridResult getOrderList(int page, int rows);
	
	EUDataGridResult getOrderByMobile(String mobile, int page, int rows);
	
	XiaobaoResult deleteOrderList(String orderIdsStr);
	
	XiaobaoResult editOrder(TbOrder order);
	
	
}
