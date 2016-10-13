package com.xiaobao.common.utils;

import java.io.IOException;
import java.util.Properties;

import jodd.util.PropertiesUtil;

/**
 * 通过属性文件读取sql语句
 * 
 * @author poner
 */
public abstract class PropertiesReader {
	private static Properties sqlProperties = PropertiesUtil.createFromClasspath("/sql.properties");
	private static Properties jpushProperties = PropertiesUtil.createFromClasspath("/application.properties");

	public final static String getSql(String key) {
		return sqlProperties.getProperty(key, "").trim();
	}

	public final static String getJPushAppKey() {
		return jpushProperties.getProperty("Jpush.appKey", "").trim();
	}

	public final static String getJPushMasterSecret() {
		return jpushProperties.getProperty("Jpush.masterSecret", "").trim();
	}

	public static void main(String[] args) throws IOException {
		// System.out.println(getSql("findUser.sql"));
		System.out.println(getJPushAppKey());
		System.out.println(getJPushMasterSecret());
	}
}
