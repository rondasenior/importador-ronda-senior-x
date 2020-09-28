package br.com.senior.importadorrondaseniorx.core;

import java.util.StringJoiner;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import br.com.senior.importadorrondaseniorx.utils.Utils;

public class SSecureError {
	@SerializedName("id")
	private String id;

	@SerializedName("code")
	private String code;

	@SerializedName("message")
	private String message;

	public SSecureError(String jsonMessage) {
		SSecureError error = new Gson().fromJson(jsonMessage, SSecureError.class);
		this.id = error.id;
		this.code = error.code;
		this.message = error.message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String toString() {
		return new StringJoiner("")
				.add("Id do erro: ").add(id).add(Utils.NEW_LINE)
				.add("Código do erro: ").add(code).add(Utils.NEW_LINE)
				.add("Mensagem de erro: ").add(message).toString();
	}
}
