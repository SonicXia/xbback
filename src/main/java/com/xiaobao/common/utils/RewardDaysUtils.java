package com.xiaobao.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RewardDaysUtils {
	
	/**
	 * 计算分红天数
	 * @param startDay	投单时间
	 * @param to	分红月数
	 * @param extraDays	额外分红天数
	 * @return
	 */
	public static int getRewardDays(String startDay, int to, int extraDays){
		String endDay = DateUtils.getTheSameDate(startDay, to);
		try {
			int betweenDays = DateUtils.getBetweenDays(startDay, endDay, "yyyy-MM-dd");
			
			int actualDays = betweenDays - 1;//如本月18号投单，从19号开始算分红，到结束月份的17号结束分红（从投单那天开始算时间）
			int weekendDays = 0;
			int rewardDays;

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date startDay2 = sdf.parse(startDay);
			for(int i = 1; i <= actualDays; i++){
				Date dateAdd = DateUtils.dateAdd(startDay2, i);
				if(DateUtils.isWeekend(dateAdd)){
					weekendDays++;
				}
			}
			rewardDays = actualDays - weekendDays + extraDays;			
			
			return rewardDays;
			
		} catch (ParseException e) {
			throw new IllegalArgumentException("Invalid date format(yyyy-MM-dd): " + startDay);			
		}
	}
}
