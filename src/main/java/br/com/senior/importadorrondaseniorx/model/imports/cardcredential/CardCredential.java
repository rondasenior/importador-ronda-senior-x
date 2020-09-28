package br.com.senior.importadorrondaseniorx.model.imports.cardcredential;

import java.util.ArrayList;
import java.util.List;

import br.com.senior.importadorrondaseniorx.model.imports.person.Person;

public class CardCredential {
	
	private Long id;
	private String expirationDate;
	private String startDate;
	private Person person;
	private Integer situation;
	private List<InformationCardCredential> cardCredentialList = new ArrayList<>();

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getExpirationDate() {
		return expirationDate;
	}
	
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public Integer getSituation() {
		return situation;
	}
	
	public void setSituation(Integer situation) {
		this.situation = situation;
	}
	
	public List<InformationCardCredential> getCardCredentialList() {
		return cardCredentialList;
	}

	public void setCardCredentialList(List<InformationCardCredential> cardCredentialList) {
		this.cardCredentialList = cardCredentialList;
	}
	
}
