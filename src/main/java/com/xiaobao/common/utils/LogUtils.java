package com.xiaobao.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtils
{
	private static final int MAX_LOGLENGTH = 999;

	public static void writeRequestLog(Class<?> clazz, String loginfo, String interfaceName)
	{
		Logger logger = LoggerFactory.getLogger(clazz);
		
		String logName = "Interface Name=" + interfaceName + ":";	

		// 超过255个字符，改为debug级别
		if (loginfo.length() > MAX_LOGLENGTH)
		{
			String tempStr = loginfo.substring(0, MAX_LOGLENGTH);
			logger.info("Request: " + logName + "data = " + tempStr + "... More use debug level..");
			//logger.info("Log info is too long, if you want to view the complete log, open debug level");
			logger.debug("Request: " + logName + "data = " + loginfo);
		}
		else
		{
			logger.info("Request: " + logName + "data = " + loginfo);
		}

	}

	public static void writeResponseLog(Class<?> clazz, String loginfo, String interfaceName)
	{
		Logger logger = LoggerFactory.getLogger(clazz);
		String logName = "Interface Name=" + interfaceName + ":";		
		// 超过255个字符，改为debug级别
		if (loginfo.length() > MAX_LOGLENGTH)
		{
			String tempStr = loginfo.substring(0, MAX_LOGLENGTH);
			logger.info("Response: " + logName + "data = " + tempStr + "... More use debug level..");
			//logger.info("Log info is too long, if you want to view the complete log, open debug level");
			logger.debug("Response: " + logName + "data = " + loginfo);
		}
		else
		{
			logger.info("Response: " + logName + "data = " + loginfo);
		}

	}

}
