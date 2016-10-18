package com.xiaobao.service;

import com.xiaobao.common.pojo.XiaobaoResult;
import com.xiaobao.pojo.TbUser;

public interface UserService {
	public TbUser getUserByName(String name);
	public XiaobaoResult insertUser(String name, String cardId, String mobile, String password, String email, String referrer, int teamId);
}
