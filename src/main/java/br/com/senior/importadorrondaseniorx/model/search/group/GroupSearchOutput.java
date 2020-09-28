package br.com.senior.importadorrondaseniorx.model.search.group;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GroupSearchOutput {
	
	private List<GroupSearch> groups = new ArrayList<>();
	
	@JsonCreator
	public GroupSearchOutput(@JsonProperty() List<GroupSearch> groups) {
		this.groups = groups;
	}
	
	public List<GroupSearch> getGroups() {
		return groups;
	}

	public void setGroups(List<GroupSearch> groups) {
		this.groups = groups;
	}
}
