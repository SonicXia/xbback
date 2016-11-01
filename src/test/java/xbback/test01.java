package xbback;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.xiaobao.common.utils.DateUtils;
import com.xiaobao.common.utils.RewardDaysUtils;

public class test01 {

	public static void testRewardDays(String date, int month, int ext) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date2 = sdf.parse(date);

		for(int i = 0; i <= 60; i++){
			Date dateAdd = DateUtils.dateAdd(date2, i);
			
			String dateStr = sdf.format(dateAdd);
			int rewardDays = RewardDaysUtils.getRewardDays(dateStr, month, 0);
			System.out.println("投单日期：" + dateStr + "， 分红"+ month +"个月，共"+ rewardDays +"天");
		}
			
		
	}
	
	public static void main(String[] args) throws ParseException {
//		System.err.println(RewardDaysUtils.getRewardDays("2016-01-31", 4, 0));
		testRewardDays("2016-11-01", 4 , 0);
	}

}
