package com.xiaobao.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaobao.common.pojo.XiaobaoResult;
import com.xiaobao.common.utils.RewardDaysUtils;
import com.xiaobao.mapper.TbOrderMapper;
import com.xiaobao.pojo.TbOrder;
import com.xiaobao.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private TbOrderMapper orderMapper;
	
	public XiaobaoResult insertOrder(String cardId, int orderCnt, String address, double amont, double bonus,
			double reward, String remark, String investmentDate, int rewardMonths, int extraDays) {
		
		TbOrder order = new TbOrder();
		order.setCardid(cardId);
		order.setOrdercnt(orderCnt);
		order.setAddress(address);
		order.setAmont(amont);
		order.setBonus(bonus);
		order.setReward(reward);
		order.setRemark(remark);
		order.setInvestmentdate(investmentDate);
		order.setRewardmonths(rewardMonths);
		order.setExtradays(extraDays);
		int rewardDays = RewardDaysUtils.getRewardDays(investmentDate, rewardMonths, extraDays);
		order.setRewarddays(rewardDays);		
		order.setDaysalready(0);
		order.setCreatedate(new Date());
		order.setUpdatedate(new Date());
		order.setOrderstatus(1);
		
		orderMapper.insert(order);
		
		return XiaobaoResult.ok();
	}

	public XiaobaoResult getOrderByOrderId(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

}
