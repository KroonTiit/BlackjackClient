package com.blackjackclient.tiit.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("service.client")
public class ClientProperties {
	private int readTimeout;
	private int connectTimeout;
	private String gameServiceUrl;
	
	public int getReadTimeout() {
		return readTimeout;
	}
	public void setReadTimeout(int readTimeout) {
		this.readTimeout = readTimeout;
	}
	public int getConnectTimeout() {
		return connectTimeout;
	}
	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}
	public String getGameServiceUrl() {
		return gameServiceUrl;
	}
	public void setGameServiceUrl(String gameServiceUrl) {
		this.gameServiceUrl = gameServiceUrl;
	}
	
}
