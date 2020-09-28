package br.com.senior.importadorrondaseniorx.model.search.person;

public class Phone {

	private Long id;
	private Boolean preferential;
	private String phoneNumber;
	private String type;
	private Integer ddi;
	
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
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getDdi() {
		return ddi;
	}

	public void setDdi(Integer ddi) {
		this.ddi = ddi;
	}
	
}
