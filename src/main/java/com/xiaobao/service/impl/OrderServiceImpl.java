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
import com.xiaobao.mapper.TbUserMapper;
import com.xiaobao.pojo.TbOrder;
import com.xiaobao.pojo.TbOrderExample;
import com.xiaobao.pojo.TbOrderExample.Criteria;
import com.xiaobao.pojo.TbUser;
import com.xiaobao.pojo.TbUserExample;
import com.xiaobao.service.MoneyService;
import com.xiaobao.service.OrderService;

import jodd.util.StringUtil;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private TbOrderMapper orderMapper;
	@Autowired
	private TbUserMapper userMapper;
	@Autowired
	private MoneyService moneyService;
	
	/**
	 * 保存订单
	 */
	@Transactional
	public XiaobaoResult saveOrder(TbOrder order) {
		String mobile = order.getMobile();
		String name = order.getName();
		if(StringUtil.isNotEmpty(name) && StringUtil.isNotEmpty(mobile)){
			// 投单人身份校验
			if(!validateUser(name, order.getMobile())){
				return XiaobaoResult.build(400, "投单人身份信息填写错误");
			}
			order.setOrderid(Factory.generateOrderId());
			order.setBonusalready(0.00);
			order.setRewardalready(0.00);
			String investmentDate = order.getInvestmentdate();
			int rewardMonths = order.getRewardmonths();
			int extraDays = order.getExtradays();
			int rewardDays = RewardDaysUtils.getRewardDays(investmentDate, rewardMonths, extraDays);
			int orderCnt = order.getOrdercnt();
			order.setRewarddays(rewardDays);
			order.setDaysalready(0);
			order.setCreatedate(new Date());
			order.setUpdatedate(new Date());
			order.setOrderstatus((byte) 1);
			orderMapper.insert(order);			
			// 根据mobile查询订单对应的投单人信息
			TbUserExample example = new TbUserExample();
			com.xiaobao.pojo.TbUserExample.Criteria criteria = example.createCriteria();
			criteria.andMobileEqualTo(mobile);
			List<TbUser> userList = userMapper.selectByExample(example);
			if(userList != null && userList.size() > 0){
				TbUser user = userList.get(0);
				Integer totalCnt = user.getTotalcnt();
				// 如果投单人之前没有投过单（即首次投单），则推荐人获得奖励
				if(totalCnt == 0){
					if(StringUtil.isNotEmpty(user.getReferrer()) && StringUtil.isNotEmpty(user.getReferrermobile())){
						String referrer = user.getReferrer();
						String referrerMobile = user.getReferrermobile();
						moneyService.generateBonus(referrer, referrerMobile);
					}
				}
				// 投单人投单总数增加
				totalCnt += orderCnt;
				user.setTotalcnt(totalCnt);
				// 更新投单人投单总次数
				userMapper.updateByExample(user, example);

			}
		}
		return XiaobaoResult.ok();
	}
	
	/**
	 * 投单人身份校验
	 * 
	 * @param name
	 * @param mobile
	 * @return
	 */
	private boolean validateUser(String name, String mobile){
		TbUserExample example = new TbUserExample();
		com.xiaobao.pojo.TbUserExample.Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		criteria.andMobileEqualTo(mobile);
		List<TbUser> userList = userMapper.selectByExample(example);
		if(userList != null && userList.size() > 0){
			return true;
		}
		return false;
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
