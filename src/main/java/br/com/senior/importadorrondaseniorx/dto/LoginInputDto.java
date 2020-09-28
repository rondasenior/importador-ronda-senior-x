package br.com.senior.importadorrondaseniorx.dto;

public class LoginInputDto {
	private String username;
	private String password;
	private String accessKey;
	private String secret;
	private String tenantName;
	private String scope;
	
	public LoginInputDto(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public LoginInputDto(String accessKey, String secret, String tenantName, String scope) {
		this.accessKey = accessKey;
		this.secret = secret;
		this.tenantName = tenantName;
		this.scope = scope == null ? "desktop" : scope;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAccessKey() {
		return accessKey;
	}
	
	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}
	
	public String getSecret() {
		return secret;
	}
	
	public void setSecret(String secret) {
		this.secret = secret;
	}
	
	public String getTenantName() {
		return tenantName;
	}
	
	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
	
	public String getScope() {
		return scope;
	}
	
	public void setScope(String scope) {
		this.scope = scope;
	}
}
