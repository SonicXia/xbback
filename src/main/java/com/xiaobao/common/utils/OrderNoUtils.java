package com.xiaobao.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderNoUtils {
	private static int serial = 1;

	/***
	 * 获取订单号
	 * @return 年月日时分秒＋6位数字
	 */
	public static String generateOrder() {
		StringBuilder date = new StringBuilder();
		date.append(serial++);
		while (date.length() < 6) {
			date.insert(0, "0");
		}
		String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		date.insert(0, now);

		return date.toString();
	}
}