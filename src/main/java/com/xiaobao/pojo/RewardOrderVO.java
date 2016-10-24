package com.xiaobao.pojo;

public class RewardOrderVO {
	
	private String name;
	private String mobile;
	private double todayReward;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public double getTodayReward() {
		return todayReward;
	}
	public void setTodayReward(double todayReward) {
		this.todayReward = todayReward;
	}
	
	public RewardOrderVO cloneRewardOrderVO(RewardOrderVO vo){
		RewardOrderVO vo2 = new RewardOrderVO();
		vo2.name = vo.getName();
		vo2.mobile = vo.getMobile();
		vo2.todayReward = vo.getTodayReward();
		return vo2;
	}
	
	
}
