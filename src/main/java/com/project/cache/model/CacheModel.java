package com.project.cache.model;

public class CacheModel {

	private String datas;
	private Long expirationTime;
	
	public String getDatas() {
		return datas;
	}
	public void setDatas(String datas) {
		this.datas = datas;
	}
	public Long getExpirationTime() {
		return expirationTime;
	}
	public void setExpirationTime(Long expirationTime) {
		this.expirationTime = expirationTime;
	}
	
	public boolean isExpired() {
		return System.currentTimeMillis() > getExpirationTime();
	}
}
