package com.xiaobao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaobao.common.factory.UserFactory;
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

	public XiaobaoResult insertUser(String name, String cardId, String mobile, String password, String email, String referrer, int teamId) {
		TbUser user = UserFactory.createUserInfo();
		user.setName(name);
		user.setCardid(cardId);
		user.setMobile(mobile);
		user.setPassword(password);
		user.setEmail(email);
		user.setReferrer(referrer);
		user.setTeamid(teamId);
		userMapper.insert(user);
		return XiaobaoResult.ok();
	}

}
