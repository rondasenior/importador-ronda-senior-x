package br.com.senior.importadorrondaseniorx.model.imports.person;

import br.com.senior.importadorrondaseniorx.enums.PersonSituationType;

public class BulkPersonFeedback {
	
	private Long id;
	private String name;
	private String document;
	private PersonSituationType situation;
	private String message;
	private Boolean personExists;
	
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
	
	public String getDocument() {
		return document;
	}
	
	public void setDocument(String document) {
		this.document = document;
	}
	
	public PersonSituationType getSituation() {
		return situation;
	}
	
	public void setSituation(PersonSituationType situation) {
		this.situation = situation;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

    public Boolean isPersonExists() {
        return personExists;
    }

    public void setPersonExists(Boolean personExists) {
        this.personExists = personExists;
    }
}
