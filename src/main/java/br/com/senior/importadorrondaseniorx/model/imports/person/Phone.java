package br.com.senior.importadorrondaseniorx.model.imports.person;

public class Phone {

	private Boolean preferential = Boolean.FALSE;
	private Long idd;
	private String number;
	
	public Phone(Boolean preferential, Long idd, String number) {
		this.preferential = preferential;
		this.idd = idd;
		this.number = number;
	}
	
	public Boolean getPreferential() {
		return preferential;
	}
	
	public void setPreferential(Boolean preferential) {
		this.preferential = preferential;
	}
	
	public Long getIdd() {
		return idd;
	}
	
	public void setIdd(Long idd) {
		this.idd = idd;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
}
