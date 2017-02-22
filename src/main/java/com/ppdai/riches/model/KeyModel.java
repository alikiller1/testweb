package com.ppdai.riches.model;

import java.io.Serializable;
import java.security.interfaces.RSAKey;
/**
 * 密钥
 * <pre>
 * Description
 * Copyright:	Copyright (c) 2016  
 * Company:		拍拍贷
 * Author:		liuqinghua
 * Version:		1.0  
 * Create at:	2016年1月21日 下午1:00:55  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------  
 * 
 * </pre>
 */
public class KeyModel implements Serializable {
	
	private static final long serialVersionUID = 7185100700491943461L;
	private RSAKey key;
	private long expiryTime;
	public RSAKey getKey() {
		return key;
	}
	public void setKey(RSAKey key) {
		this.key = key;
	}
	public long getExpiryTime() {
		return expiryTime;
	}
	public void setExpiryTime(long expiryTime) {
		this.expiryTime = expiryTime;
	}
	@Override
	public String toString() {
		return "KeyModel [key=" + key + ", expiryTime=" + expiryTime + "]";
	}
	
	

}
