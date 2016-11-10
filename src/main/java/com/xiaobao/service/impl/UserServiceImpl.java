package com.xiaobao.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
import com.xiaobao.service.MoneyService;
import com.xiaobao.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private TbUserMapper userMapper;
	@Autowired
	private MoneyService moneyService;
	
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
	 * 新增代理
	 */
	@Override
	@Transactional
	public XiaobaoResult saveUser(TbUser user) {	
		TbUser newUser = Factory.createUserInfo();
		newUser.setName(user.getName());
		newUser.setCardid(user.getCardid());
		newUser.setMobile(user.getMobile());
		newUser.setPassword(user.getPassword());
		newUser.setEmail(user.getEmail());
		newUser.setReferrer(user.getReferrer());
		newUser.setReferrermobile(user.getReferrermobile());
		newUser.setTeamid(user.getTeamid());		
		//判断是否填入了推荐人信息
		if(StringUtils.isNotEmpty(user.getReferrer()) && StringUtils.isNotEmpty(user.getReferrermobile())){	
			referralCntAdd(user.getReferrermobile());	//有推荐人的情况下，推荐人推荐次数加1
		}	
		//没有填推荐人信息则忽略推荐人信息插入
		userMapper.insert(newUser);
		return XiaobaoResult.ok();
		
	}
	
	/**
	 * 推荐人推荐次数加1
	 * @param referrerMobile
	 * @return
	 */
	@Transactional
	private boolean referralCntAdd(String referrerMobile){
		System.err.println("---进入referralCntAdd---");
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andMobileEqualTo(referrerMobile);
		System.err.println("根据推荐人手机号查找推荐人信息");
		List<TbUser> list = userMapper.selectByExample(example);	//根据推荐人手机号查找推荐人信息
		System.err.println("根据推荐人手机号查找推荐人信息---结束");
		if(list != null && list.size() > 0){
			TbUser referrer = list.get(0);
			Integer referralcnt = referrer.getReferralcnt();
			referralcnt += 1;	//推荐人数加1
			referrer.setReferralcnt(referralcnt);
			referrer.setUpdatedate(new Date());
			System.err.println("根据推荐人手机号修改推荐人信息");
			userMapper.updateByExample(referrer, example);	//根据推荐人手机号修改推荐人信息
			System.err.println("---结束referralCntAdd---");
			return true;
		}
		return false;
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
