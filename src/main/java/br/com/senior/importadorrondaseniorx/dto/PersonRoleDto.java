package br.com.senior.importadorrondaseniorx.dto;

import java.util.StringJoiner;

import br.com.senior.importadorrondaseniorx.utils.Utils;

public class PersonRoleDto {
	
	private Long id;
	private Long personId;
	private Long  roleId;
	private String startDate;
	private String endDate;
	private Boolean isIntegrated = Boolean.FALSE;
	
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
	
	public String toString() {
		return new StringJoiner("")
				.add("Id: ").add(id == null ? "" : id.toString()).add(Utils.NEW_LINE)
				.add("Id da pessoa: ").add(personId.toString()).add(Utils.NEW_LINE)
				.add("Id do papel: ").add(roleId.toString()).add(Utils.NEW_LINE)
				.add("Data de início: ").add(startDate).add(Utils.NEW_LINE)
				.add("Data de término: ").add(endDate).toString();
	}
}
