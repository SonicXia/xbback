package com.xiaobao.common.exception;

/**
 * 基本服务错误代码，编号为从1至19
 *
 */
public class ServiceExceptionConstants {

	public static final int NORMAL_STATUS = 0;
	/**
	 * 正常状态，业务处理有报警，但不影响正常业务
	 */
	public static final int WARNING_STATUS = 1;

	/**
	 * 未知服务错误
	 */
	public static final int UNKNOWN_SERVICE_ERROR = 2;

	/**
	 * 信息验证错误
	 */
	public static final int VALIDATION_ERROR = 3;

	/**
	 * 客户端错误
	 */
	public static final int CLIENT_ERROR = 4;
	/**
	 * 缓存异常
	 */
	public static final int MEMCACHED_ERROR = 5;
	/**
	 * 日期格式化异常
	 */
	public static final int PARSE_ERROR = 6;
	
	/**
	 * 支付密码错误
	 */
	public static final int PASSWORD_ERROR = 3;
	
	/**
	 * 未设置支付密码
	 */
	public static final int PASSWORD_NOTSET = 2;
}
