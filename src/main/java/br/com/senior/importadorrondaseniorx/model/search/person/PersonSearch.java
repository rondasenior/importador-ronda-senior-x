package br.com.senior.importadorrondaseniorx.model.search.person;

import java.util.ArrayList;
import java.util.List;

public class PersonSearch {

	private Long id;
	private String name;
	private List<Document> mandatoryDocuments = new ArrayList<>();
	private Phone preferentialPhone;
	private Email preferentialEmail;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Document> getMandatoryDocuments() {
		return mandatoryDocuments;
	}
	
	public void setMandatoryDocuments(List<Document> mandatoryDocuments) {
		this.mandatoryDocuments = mandatoryDocuments;
	}
	
	public Phone getPreferentialPhone() {
		return preferentialPhone;
	}
	
	public void setPreferentialPhone(Phone preferentialPhone) {
		this.preferentialPhone = preferentialPhone;
	}
	
	public Email getPreferentialEmail() {
		return preferentialEmail;
	}

	public void setPreferentialEmail(Email preferentialEmail) {
		this.preferentialEmail = preferentialEmail;
	}
	
}
