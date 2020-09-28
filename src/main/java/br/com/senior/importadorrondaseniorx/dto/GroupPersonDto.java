package br.com.senior.importadorrondaseniorx.dto;

import java.util.StringJoiner;

import br.com.senior.importadorrondaseniorx.utils.Utils;

public class GroupPersonDto {

	private Long groupId;
	private Long personId;
	
	public Long getGroupId() {
		return groupId;
	}
	
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	
	public Long getPersonId() {
		return personId;
	}
	
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	
	public String toString() {
		return new StringJoiner("")
				.add("Id do grupo: ").add(groupId.toString()).add(Utils.NEW_LINE)
				.add("Id da pessoa: ").add(personId.toString())
				.toString();
	}
}
