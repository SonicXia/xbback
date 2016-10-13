package com.xiaobao.common.utils;

import java.io.IOException;
import java.util.Properties;

import jodd.util.PropertiesUtil;

/**
 * config.properties属性文件文件读取
 * 
 * @author poner
 */
public abstract class ConfigReader {
	// config file for product
	public static String CONFIG_FILE_PATH = "/opt/mobile/application.properties";
	private static Properties properties;

	static {
		try {
			if (!MiscContants.ENV_PROD) {
				properties = PropertiesUtil.createFromClasspath("/application.properties");
			} else {
				properties = PropertiesUtil.createFromFile(CONFIG_FILE_PATH);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public final static String getProp(final String key, final String defaultVal) {
		String val = "";
		if (null == properties) {
			try {
				if (!MiscContants.ENV_PROD) {
					properties = PropertiesUtil.createFromClasspath("/application.properties");
				} else {
					properties = PropertiesUtil.createFromFile(CONFIG_FILE_PATH);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			val = properties.getProperty(key, defaultVal);
		}
		if (StringUtils.isEmpty(val)) {
			val = defaultVal;
		}

		return val;
	}

	public final static String getProp(final String key) {
		return getProp(key, "");
	}
}
