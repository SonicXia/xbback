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
import com.xiaobao.mapper.TbUserMapper;
import com.xiaobao.pojo.TbUser;
import com.xiaobao.pojo.TbUserExample;
import com.xiaobao.pojo.TbUserExample.Criteria;
import com.xiaobao.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private TbUserMapper userMapper;
	
	/**
	 * 通过用户名查找代理
	 */
	@Transactional
	public TbUser getUserByName(String name) {
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		List<TbUser> users = userMapper.selectByExample(example);
		if(users != null && users.size() > 0){
			TbUser user = users.get(0);
			return user;
		}
		return null;
	}

	/**
	 * 保存代理
	 */
	@Override
	@Transactional
	public XiaobaoResult saveUser(TbUser user) {	
		TbUser user2 = Factory.createUserInfo();
		user2.setName(user.getName());
		user2.setCardid(user.getCardid());
		user2.setMobile(user.getMobile());
		user2.setPassword(user.getPassword());
		user2.setEmail(user.getEmail());
		user2.setReferrer(user.getReferrer());
		user2.setReferrermobile(user.getReferrermobile());
		user2.setTeamid(user.getTeamid());
		userMapper.insert(user2);	
		return XiaobaoResult.ok();
	}

	/**
	 * 获取代理列表
	 */
	@Override
	@Transactional
	public EUDataGridResult getUserList(int page, int rows) {	
		//查询用户列表
		TbUserExample example = new TbUserExample();
		//分页处理
		PageHelper.startPage(page, rows);
		List<TbUser> list = userMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TbUser> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());	
		return result;
	}
	
	/**
	 * 根据name查询代理
	 */
	@Override
	@Transactional
	public EUDataGridResult getUserByName(int page, int rows, String name) {
		//根据name查询代理
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		List<TbUser> list = userMapper.selectByExample(example);
		//分页处理
		PageHelper.startPage(page, rows);		
		//创建一个返回对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TbUser> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	/**
	 * 根据mobile查询代理
	 */
	@Override
	@Transactional
	public EUDataGridResult getUserByMobile(int page, int rows, String mobile) {
		//根据mobile查询代理
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andMobileEqualTo(mobile);
		List<TbUser> list = userMapper.selectByExample(example);
		//分页处理
		PageHelper.startPage(page, rows);		
		//创建一个返回对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TbUser> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	/**
	 * 根据name和mobile联合查询代理
	 */
	@Override
	@Transactional
	public EUDataGridResult getUserByNameAndMobile(int page, int rows, String name, String mobile) {
		//根据name和mobile联合查询代理
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		criteria.andMobileEqualTo(mobile);
		List<TbUser> list = userMapper.selectByExample(example);
		//分页处理
		PageHelper.startPage(page, rows);		
		//创建一个返回对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TbUser> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	/**
	 * 根据手机号删除用户
	 */
	@Override
	@Transactional
	public XiaobaoResult deleteUserList(String mobiles) {
		String[] mobileArr = mobiles.split(",");
		for(int i = 0; i < mobileArr.length; i++){
			String mobile = mobileArr[i];
			TbUserExample example = new TbUserExample();
			Criteria criteria = example.createCriteria();
			criteria.andMobileEqualTo(mobile);
			userMapper.deleteByExample(example);			
		}	
		return XiaobaoResult.ok();
	}

	/**
	 * 修改用户
	 */
	@Override
	@Transactional
	public XiaobaoResult updateUser(TbUser user) {
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andMobileEqualTo(user.getMobile());
		List<TbUser> users = userMapper.selectByExample(example);
		if(users.size() > 0 && users != null){
			TbUser user2 = users.get(0);
			user.setCreatedate(user2.getCreatedate());
			user.setUpdatedate(new Date());
			userMapper.updateByPrimaryKey(user);
		}			
		return XiaobaoResult.ok(user);
	}



}
