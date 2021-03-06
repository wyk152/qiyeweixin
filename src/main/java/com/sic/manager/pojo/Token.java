package com.sic.manager.pojo;

public class Token {

	private String access_token; //访问令牌
	private Integer expires_in;  //过期时间
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public Integer getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}
	@Override
	public String toString() {
		return "Token [access_token=" + access_token + ", expires_in=" + expires_in + "]";
	}
	
}
