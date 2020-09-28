package br.com.senior.importadorrondaseniorx.model.search.person;

public class Email {

	private Long id;
	private Boolean preferential;
	private String emailAddress;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Boolean getPreferential() {
		return preferential;
	}
	
	public void setPreferential(Boolean preferential) {
		this.preferential = preferential;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}
