package br.com.senior.importadorrondaseniorx.model.imports.personrole;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonRole {

	private Long id;
	private Long personId;
	private Long  roleId;
	private String startDate;
	private String endDate;
	
	@JsonProperty("isIntegrated")
	private Boolean isIntegrated;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getPersonId() {
		return personId;
	}
	
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	
	public Long getRoleId() {
		return roleId;
	}
	
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public String getEndDate() {
		return endDate;
	}
	
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public Boolean isIntegrated() {
		return isIntegrated;
	}
	
	public void setIntegrated(Boolean isIntegrated) {
		this.isIntegrated = isIntegrated;
	}
	
}
