package br.com.senior.importadorrondaseniorx.model.imports.person;

import java.util.ArrayList;
import java.util.List;

import br.com.senior.importadorrondaseniorx.enums.Gender;
import br.com.senior.importadorrondaseniorx.enums.PersonSituationType;

public class Person {
	private Long id;
	private String name;
	private Gender gender;
	private String birthday;
	private String address;
	private String district;
	private String city;
	private String federalState;
	private String zipCode;
	private String nationality;
	private PersonSituationType situation;
	private List<Document> documents = new ArrayList<>();
	private List<Email> emails = new ArrayList<>();
	private List<Phone> phones = new ArrayList<>();
	
	public Person() {
	}
	
	public Person(Long id) {
		this.id = id;
	}
	
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
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public String getBirthday() {
		return birthday;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getDistrict() {
		return district;
	}
	
	public void setDistrict(String district) {
		this.district = district;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getFederalState() {
		return federalState;
	}
	
	public void setFederalState(String federalState) {
		this.federalState = federalState;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getNationality() {
		return nationality;
	}
	
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	public PersonSituationType getSituation() {
		return situation;
	}
	
	public void setSituation(PersonSituationType situation) {
		this.situation = situation;
	}
	
	public List<Document> getDocuments() {
		return documents;
	}
	
	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}
	
	public List<Email> getEmails() {
		return emails;
	}
	
	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}
	
	public List<Phone> getPhones() {
		return phones;
	}
	
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
}
