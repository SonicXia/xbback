package com.xiaobao.common.factory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import com.xiaobao.pojo.TbUser;

/**
 * 用户工厂类
 *
 */
public class Factory {
	
	/**
	 * 用于生成原始订单Id
	 */
	private final static AtomicInteger atomicInteger = new AtomicInteger();
	
	/**
	 * 生成原始订单
	 * @return
	 */
	public static TbUser createUserInfo(){
		TbUser user = new TbUser();		
//		user.setMemberid(generateMemberId());
		user.setTotalcnt(0);
		user.setIsactive(true);
		user.setIsblacklist(false);
		user.setReferralcnt(0);
		user.setCreatedate(new Date());
		user.setUpdatedate(new Date());
		return user;
	}
	
	/**
	 * @return 生成的原子id供订单
	 */
	public static String generateOrderId() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		StringBuffer sb = new StringBuffer();
		sb.append("B");
		sb.append(sdf.format(new Date())).append(String.format("%03d", atomicInteger.getAndIncrement() % 1000));
		return sb.toString();
	}
	
	private static String generateMemberId(){
		StringBuffer sb = new StringBuffer();
		sb.append("A");
		sb.append(String.format("%06d", atomicInteger.getAndIncrement() % 1000));
		return sb.toString();
	}
	
}
