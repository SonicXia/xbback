package com.xiaobao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaobao.common.factory.Factory;
import com.xiaobao.common.pojo.EUDataGridResult;
import com.xiaobao.common.pojo.XiaobaoResult;
import com.xiaobao.common.utils.RewardDaysUtils;
import com.xiaobao.mapper.TbOrderMapper;
import com.xiaobao.pojo.TbOrder;
import com.xiaobao.pojo.TbOrderExample;
import com.xiaobao.pojo.TbOrderExample.Criteria;
import com.xiaobao.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private TbOrderMapper orderMapper;
	
	/**
	 * 保存订单
	 */
	@Transactional
	public XiaobaoResult saveOrder(TbOrder order) {
		
		order.setOrderid(Factory.generateOrderId());
		order.setBonusalready(0.00);
		order.setRewardalready(0.00);
		String investmentDate = order.getInvestmentdate();
		int rewardMonths = order.getRewardmonths();
		int extraDays = order.getExtradays();
		int rewardDays = RewardDaysUtils.getRewardDays(investmentDate, rewardMonths, extraDays);
		order.setRewarddays(rewardDays);
		order.setDaysalready(0);
		order.setCreatedate(new Date());
		order.setUpdatedate(new Date());
		order.setOrderstatus((byte) 1);
		
		orderMapper.insert(order);
		
		return XiaobaoResult.ok();
	}
	
	/**
	 * 查询订单列表
	 */
	@Transactional
	public EUDataGridResult getOrderList(int page, int rows) {
		//查询订单列表
		TbOrderExample example = new TbOrderExample();
		//分页处理
		PageHelper.startPage(page, rows);
		List<TbOrder> list = orderMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TbOrder> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		
		return result;
	}
	
	/**
	 * 根据name查询订单列表
	 */
	@Override
	@Transactional
	public EUDataGridResult getOrderListByName(int page, int rows, String name) {
		//按照name查询订单列表
		TbOrderExample example = new TbOrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		List<TbOrder> list = orderMapper.selectByExample(example);
		//分页处理
		PageHelper.startPage(page, rows);		
		//创建一个返回对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TbOrder> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;	
	}

	/**
	 * 根据mobile查询订单列表
	 */
	@Override
	@Transactional
	public EUDataGridResult getOrderListByMobile(int page, int rows, String mobile) {
		//按照mobile查询订单列表
		TbOrderExample example = new TbOrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andMobileEqualTo(mobile);
		List<TbOrder> list = orderMapper.selectByExample(example);
		//分页处理
		PageHelper.startPage(page, rows);		
		//创建一个返回对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TbOrder> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;	
	}
	
	/**
	 * 根据name和mobile联合查询订单列表
	 */
	@Override
	@Transactional
	public EUDataGridResult getOrderListByNameAndMobile(int page, int rows, String name, String mobile) {
		//按照mobile查询订单列表
		TbOrderExample example = new TbOrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		criteria.andMobileEqualTo(mobile);
		List<TbOrder> list = orderMapper.selectByExample(example);
		//分页处理
		PageHelper.startPage(page, rows);		
		//创建一个返回对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TbOrder> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;	
	}

	/**
	 * 根据orderId删除订单
	 */
	@Transactional
	public XiaobaoResult deleteOrderList(String orderIdsStr) {		
		String[] orderIds = orderIdsStr.split(",");
		for(int i = 0; i < orderIds.length; i++){
			String orderId = orderIds[i];
			TbOrderExample example = new TbOrderExample();
			Criteria criteria = example.createCriteria();
			criteria.andOrderidEqualTo(orderId);
			orderMapper.deleteByExample(example);			
		}
		return XiaobaoResult.ok();
	}

	/**
	 * 修改订单
	 * @param order
	 * @return
	 */
	@Transactional
	public XiaobaoResult editOrder(TbOrder order) {
		TbOrder order2 = orderMapper.selectByPrimaryKey(order.getOrderid());
		order.setCreatedate(order2.getCreatedate());
		order.setUpdatedate(new Date());
		orderMapper.updateByPrimaryKey(order);
		
		return XiaobaoResult.ok(order);
	}


	

}
