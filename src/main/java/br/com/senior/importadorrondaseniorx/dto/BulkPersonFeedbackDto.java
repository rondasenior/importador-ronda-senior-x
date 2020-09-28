package br.com.senior.importadorrondaseniorx.dto;

import java.util.StringJoiner;

import br.com.senior.importadorrondaseniorx.utils.Utils;

public class BulkPersonFeedbackDto {
	private String id;
	private String name;
	private String document;
	private String situation;
	private String message;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDocument() {
		return document;
	}
	
	public void setDocument(String document) {
		this.document = document;
	}
	
	public String getSituation() {
		return situation;
	}
	
	public void setSituation(String situation) {
		this.situation = situation;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String toString() {
		return new StringJoiner("")
				.add("Id: ").add(id).add(Utils.NEW_LINE)
				.add("Nome: ").add(name).add(Utils.NEW_LINE)
				.add("Documento: ").add(document).add(Utils.NEW_LINE)
				.add("Situação: ").add(situation).add(Utils.NEW_LINE)
				.add("Mensagem: ").add(message == null ? "" : message).toString();
	}
}
