package com.xiaobao.service;

import com.xiaobao.common.pojo.EUDataGridResult;
import com.xiaobao.common.pojo.XiaobaoResult;
import com.xiaobao.pojo.TbUser;

public interface UserService {
	TbUser getUserByName(String name);
//	public XiaobaoResult insertUser(String name, String cardId, String mobile, String password, String email, String referrer, int teamId);
	
	XiaobaoResult saveUser(TbUser user);
	
	EUDataGridResult getUserList(int page, int rows);
	
	XiaobaoResult deleteUserList(String mobiles);
	
	XiaobaoResult updateUser(TbUser user);
	
}
