package br.com.senior.importadorrondaseniorx.model.imports.person;

import java.util.ArrayList;
import java.util.List;

public class BulkPersonWithFeedbackInput {
	private List<Person> people = new ArrayList<>();

	public BulkPersonWithFeedbackInput(List<Person> people) {
		this.people = people;
	}
	
	public List<Person> getPeople() {
		return people;
	}

	public void setPeople(List<Person> people) {
		this.people = people;
	}
	
}
