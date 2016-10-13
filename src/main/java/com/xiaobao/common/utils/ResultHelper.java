package com.xiaobao.common.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * 控制器响应结果的处理辅助类
 * 
 * @author poner
 *
 */
public abstract class ResultHelper {
	public static final String S_OK="ok";
	public static final String S_FAIL="fail";
	/**
	 * 正常结果返回
	 * @param data 服务查询结果数据
	 * @return
	 */
	public static final Map<String, Object> ok(Object data) {
		final Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", data);
		resMap.put("msg", StringUtils.EMPTY);
		resMap.put("syncTime", new Date().getTime());
		resMap.put("status", S_OK);
		return resMap;
	}
	
	/**
	 * 正常结果返回
	 * @param data 服务查询结果数据
	 * @return
	 */
	public static final  Map<String, Object> emptyResult() {
		final Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", null);
		resMap.put("msg", StringUtils.EMPTY);
		resMap.put("syncTime", new Date().getTime());
		resMap.put("status", S_OK);
		return resMap;
	}

	/**
	 * 结果返回（可能正常，也可能异常）
	 * @param data
	 * @param status
	 * @return
	 */
	public static final  Map<String, Object> result(final Object data, String status) {
		final Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", data);
		resMap.put("msg", StringUtils.EMPTY);
		resMap.put("syncTime", new Date().getTime());
		resMap.put("status", status);
		return resMap;
	}
	
	/**
	 * 带附加消息内容的正常结果返回
	 * @param data
	 * @param status
	 * @return
	 */
	public static final  Map<String, Object> okWithMsg(final Object data,String msg) {
		final Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", data);
		resMap.put("msg", msg);
		resMap.put("syncTime", new Date().getTime());
		resMap.put("status", S_OK);
		return resMap;
	}
	/**
	 * 错误结果返回
	 * @param data 服务查询结果数据
	 * @return
	 */
	public static final  Map<String, Object> failResult(String failMsg,String code) {
		final Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("data", null);
		resMap.put("msg", failMsg);
		resMap.put("syncTime", new Date().getTime());
		if(StringUtils.isNotBlank(code)) {
			resMap.put("code", code);
		}
		resMap.put("status", S_FAIL);
		return resMap;
	}
}
