package com.xiaobao.common.utils;

/**
 * 用于定义一台server，在memcache和mq的spring配置中使用
 * @version 1.0
 */
public class Host {
	private String hostname;
	private int port;

	public Host(String hostname, int port) {
		super();
		this.hostname = hostname;
		this.port = port;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return hostname + ":" + port;
	}

}
