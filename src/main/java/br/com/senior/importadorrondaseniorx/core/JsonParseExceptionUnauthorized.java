package br.com.senior.importadorrondaseniorx.core;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class JsonParseExceptionUnauthorized {
	@SerializedName("message")
	private String message;

	@SerializedName("errorCode")
	private String errorCode;

	@SerializedName("reason")
	private String reason;

	@SerializedName("domain")
	private String domain;

	@SerializedName("service")
	private String service;

	public JsonParseExceptionUnauthorized(String jsonMessage) {
		JsonParseExceptionUnauthorized responseToken = getJsonParser(jsonMessage);
		this.message = responseToken.getMessage();
		this.errorCode = responseToken.getErrorCode();
		this.reason = responseToken.getReason();
		this.domain = responseToken.getDomain();
		this.service = responseToken.getService();
	}
	
	public static String getMessage(String jsonMessage) {
		return getJsonParser(jsonMessage).getMessage();
	}
	
	private static JsonParseExceptionUnauthorized getJsonParser(String jsonMessage) {
		return new Gson().fromJson(jsonMessage, JsonParseExceptionUnauthorized.class);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}
}
