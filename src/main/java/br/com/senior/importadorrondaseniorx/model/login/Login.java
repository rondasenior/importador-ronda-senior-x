package br.com.senior.importadorrondaseniorx.model.login;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class Login {
	@SerializedName("scope")
	private String scope;
	
	@SerializedName("expires_in")
   	private int expiresIn;
   	
	@SerializedName("username")
   	private String userName;
   	
	@SerializedName("token_type")
   	private String tokenType;
   	
	@SerializedName("access_token")
   	private String accessToken;
   	
	@SerializedName("refresh_token")
   	private String refreshToken;
	 
   	@JsonCreator
	public Login(@JsonProperty("jsonToken") String jsonToken) {
   		Login responseToken = new Gson().fromJson(jsonToken, Login.class);
		this.scope = responseToken.getScope();
		this.expiresIn = responseToken.getExpiresIn();
		this.userName = responseToken.getUserName();
		this.tokenType = responseToken.getTokenType();
		this.accessToken = responseToken.getAccessToken();
		this.refreshToken = responseToken.getRefreshToken();
	}

	public String getScope() {
		return scope;
	}
	
	public void setScope(String scope) {
		this.scope = scope;
	}
	
	public int getExpiresIn() {
		return expiresIn;
	}
	
	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getTokenType() {
		return tokenType;
	}
	
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	
	public String getAccessToken() {
		return accessToken;
	}
	
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	public String getRefreshToken() {
		return refreshToken;
	}
	
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
}
