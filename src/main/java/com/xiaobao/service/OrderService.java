package com.xiaobao.service;

import com.xiaobao.common.pojo.XiaobaoResult;
import com.xiaobao.pojo.TbOrder;

public interface OrderService {
//	public XiaobaoResult insertOrder(String cardId, int orderCnt, String address, double amont, 
//			String remark, String investmentDate, int rewardMonths, int extraDays);
	
	public XiaobaoResult saveOrder(TbOrder order);
	
	public XiaobaoResult findAll();
	
	public XiaobaoResult getOrderByOrderId(String orderId);
	
	
	
}
