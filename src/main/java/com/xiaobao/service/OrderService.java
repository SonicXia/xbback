package com.xiaobao.service;

import com.xiaobao.common.pojo.XiaobaoResult;

public interface OrderService {
	public XiaobaoResult insertOrder(String cardId, int orderCnt, String address, double amont, double bonus, double reward, String remark, int days );
}
