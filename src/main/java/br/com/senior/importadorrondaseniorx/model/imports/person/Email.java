package br.com.senior.importadorrondaseniorx.model.imports.person;

public class Email {
	private Boolean preferential = Boolean.FALSE;
	private String email;
	
	public Email(Boolean preferential, String email) {
		this.preferential = preferential;
		this.email = email;
	}
	
	public Boolean getPreferential() {
		return preferential;
	}
	
	public void setPreferential(Boolean preferential) {
		this.preferential = preferential;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
