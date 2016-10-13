package com.xiaobao.common.utils;

import java.math.BigDecimal;


/**
 * 常用数值计算方法
 * 
 * 
 */
public class MathUtils {
	/**
	 * 订单用, 去尾法, 到角(十位)
	 * @param money
	 * @return
	 */
	public static long round(long money) {
		return money / 10 * 10;
	}

	/**
	 * 订单用, 去尾法, 到角(十位)
	 * @param money
	 * @return
	 */
	public static long round(double money) {
		return (long) money / 10 * 10;
	}

	/**
	 * 价格精确到分
	 * @param money
	 * @return
	 */
	public static long retenteDecimal(double money) {
		return (long) (Math.round(money * 100));
	}

	/**
	 * 元到分
	 * 
	 * @param y 元
	 * @return 分
	 */
	public static long yuan2branch(Double y) {
		if (y == null) {
			return 0;
		}
		return BigDecimal.valueOf(y).multiply(new BigDecimal(100)).longValue();
	}

	/**
	 * 分到元
	 * 
	 * @param b 分
	 * @return 元
	 */
	public static Double branch2yuan(long b) {
		return BigDecimal.valueOf(b).divide(new BigDecimal(100)).doubleValue();
	}

	public static void main(String[] args) {
		System.out.print(retenteDecimal(100));
	}

}
