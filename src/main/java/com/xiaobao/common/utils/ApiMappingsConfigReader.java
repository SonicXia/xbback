package com.xiaobao.common.utils;

import java.util.Properties;

import jodd.util.PropertiesUtil;

/**
 * config.properties属性文件文件读取
 * 
 * @author poner
 */
public abstract class ApiMappingsConfigReader {
	// config file for product
	private static String CONFIG_FILE_PATH = "/api_mappings.properties";
	private static Properties properties;
	public final static String DEFAULT_API_VERSION="V301";
	static {
		properties = PropertiesUtil.createFromClasspath(CONFIG_FILE_PATH);
	}

	public final static String getProp(final String key, final String defaultVal) {
		String val = "";
		if (null == properties) {
			properties = PropertiesUtil.createFromClasspath(CONFIG_FILE_PATH);
		} else {
			val = properties.getProperty(key, defaultVal);
		}
		if (StringUtils.isEmpty(val)) {
			val = defaultVal;
		}

		return val;
	}

	public final static String getProp(final String key) {
		return getProp(key, DEFAULT_API_VERSION);
	}
}
