package com.xiaobao.service;

import com.xiaobao.common.pojo.EUDataGridResult;
import com.xiaobao.common.pojo.XiaobaoResult;
import com.xiaobao.pojo.TbOrder;

public interface OrderService {
	
//	public XiaobaoResult insertOrder(String cardId, int orderCnt, String address, double amont, 
//			String remark, String investmentDate, int rewardMonths, int extraDays);
	
	XiaobaoResult saveOrder(TbOrder order);
	
	EUDataGridResult getOrderList(int page, int rows);
	
	EUDataGridResult getOrderListByName(int page, int rows, String name);
	
	EUDataGridResult getOrderListByMobile(int page, int rows, String mobile);
	
	EUDataGridResult getOrderListByNameAndMobile(int page, int rows, String name, String mobile);
	
	XiaobaoResult deleteOrderList(String orderIdsStr);
	
	XiaobaoResult editOrder(TbOrder order);
	
	
}
