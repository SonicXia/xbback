package com.xiaobao.service;

import com.xiaobao.common.pojo.XiaobaoResult;
import com.xiaobao.pojo.TbUser;

public interface UserService {
	public TbUser getUserByMemberId(String memberId);
	public TbUser getUserByName(String name);
	public XiaobaoResult insertUser(String name, String cardId, String password, String email, String referrer);
}
