package com.xiaobao.common.utils;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONObject;

public abstract class ParamUtils {
	/**
	 * 请求数据Map对象拼接成请求参数
	 * 
	 * @param paramObj
	 * @return
	 */
	public static final String buildParams(final Map<String,Object> paramObj) {
		if (paramObj == null) {
			return StringUtils.EMPTY;
		}

		final StringBuffer sb = new StringBuffer();
		for (Map.Entry<String, Object> entry : paramObj.entrySet()) {
			sb.append(entry.getKey() + "=" + entry.getValue());
			sb.append("&");
		}
		String s = sb.toString();
		if (s.endsWith("&")) {
			s = StringUtils.substringBeforeLast(s, "&");
		}
		return s;
	}
	
	/**
	 * 请求数据JSON对象拼接成请求参数
	 * 
	 * @param paramObj
	 * @return
	 */
	public static final String buildParams(final JSONObject paramObj) {
		if (paramObj == null) {
			return StringUtils.EMPTY;
		}

		final StringBuffer sb = new StringBuffer();
		for (Map.Entry<String, Object> entry : paramObj.entrySet()) {
			sb.append(entry.getKey() + "=" + entry.getValue());
			sb.append("&");
		}
		String s = sb.toString();
		if (s.endsWith("&")) {
			s = StringUtils.substringBeforeLast(s, "&");
		}
		return s;
	}
}
