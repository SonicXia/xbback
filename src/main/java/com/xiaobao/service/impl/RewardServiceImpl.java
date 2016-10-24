package com.xiaobao.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaobao.common.pojo.EUDataGridResult;
import com.xiaobao.pojo.RewardOrderVO;
import com.xiaobao.service.RewardService;

@Service
public class RewardServiceImpl implements RewardService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional
	public EUDataGridResult getRewardList(int page, int rows) {
		
		final String reward = "63";
		
		//分页处理
		PageHelper.startPage(page, rows);

		final String sql = "select name, mobile, sum(orderCnt*"+ reward +") todayReward from tb_order where orderStatus = 1 group by name, mobile";
		List<Map<String, Object>> rewardOrderListMap = new ArrayList<Map<String, Object>>();
		rewardOrderListMap = jdbcTemplate.queryForList(sql);
		
		List<RewardOrderVO> rewardOrderList = new ArrayList<RewardOrderVO>();	
		if(rewardOrderListMap.size() != 0){	
			
			//不能写在for循环外，因为for循环中List会给rewardOrderVO多次赋予对象值，但是rewardOrderVO对象引用是同一个，
			//这会导致后来的对象值会覆盖之前的对象引用，造成最终的结果是：对象的个数没有问题，但是所有对象都会相同，并且都为最后一个赋值对象
//			RewardOrderVO rewardOrderVO = new RewardOrderVO();	
			
            for(Map<String, Object> obj : rewardOrderListMap){          	
            	RewardOrderVO rewardOrderVO = new RewardOrderVO();	//
            	try {
					BeanUtils.populate(rewardOrderVO, obj);
				} catch (IllegalAccessException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	rewardOrderList.add(rewardOrderVO);	//接收rewardOrderVO
            }	         
        }else{
            return null;
        }	
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(rewardOrderList);
		//取记录总条数
		PageInfo<RewardOrderVO> pageInfo = new PageInfo<>(rewardOrderList);
		result.setTotal(pageInfo.getTotal());	
		return result;	
	}
	
	

}
