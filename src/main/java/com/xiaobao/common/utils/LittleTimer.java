package com.xiaobao.common.utils;

/**
 * 计时器，用以统计执行时间
 * @version 1.0
 */
public class LittleTimer {
	private long startTimer;

	/**
	 * 开始计时
	 */
	public void start() {
		startTimer = System.currentTimeMillis();
	}

	/**
	 * 结束计时
	 * @return 经过的时间（单位：毫秒数）
	 */
	public long end() {
		return System.currentTimeMillis() - startTimer;
	}
}
