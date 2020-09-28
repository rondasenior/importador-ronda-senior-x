package br.com.senior.importadorrondaseniorx.model.search.person;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonSearchOutput {
	
	private List<PersonSearch> people = new ArrayList<>();
	
	@JsonCreator
	public PersonSearchOutput(@JsonProperty() List<PersonSearch> people) {
		this.people = people;
	}
	
	public List<PersonSearch> getPeople() {
		return people;
	}

	public void setPeople(List<PersonSearch> people) {
		this.people = people;
	}
}
