package com.xiaobao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaobao.common.persistence.BaseDao;
import com.xiaobao.common.pojo.EUDataGridResult;
import com.xiaobao.pojo.TbOrder;
import com.xiaobao.pojo.TbOrderExample;
import com.xiaobao.service.BonusService;

public class BonusServiceImpl extends BaseDao implements BonusService {

	@Override
	public EUDataGridResult getBonusList(int page, int rows) {
		
		//查询订单列表
		TbOrderExample example = new TbOrderExample();
		//分页处理
		PageHelper.startPage(page, rows);
		
//		List<TbOrder> list = orderMapper.selectByExample(example);
		String sql = "insert into t_address(mobile, receiver, receiver_mobile, address) values (?,?,?,?)";
		
		
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TbOrder> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		
		return result;
		
		return null;
	}

}
