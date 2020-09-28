package br.com.senior.importadorrondaseniorx.dto;

public class SearchPersonDto {

	private Long id;
	private String name;
	private Long documentId;
	private String document;
	private Long documentTypeId;
	private String documentTypeLabel;
	private Integer phoneDdi;
	private String phoneNumber;
	private String email;
	
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
	
	public Long getDocumentId() {
		return documentId;
	}
	
	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}
	
	public String getDocument() {
		return document;
	}
	
	public void setDocument(String document) {
		this.document = document;
	}
	
	public Long getDocumentTypeId() {
		return documentTypeId;
	}
	
	public void setDocumentTypeId(Long documentTypeId) {
		this.documentTypeId = documentTypeId;
	}
	
	public String getDocumentTypeLabel() {
		return documentTypeLabel;
	}
	
	public void setDocumentTypeLabel(String documentTypeLabel) {
		this.documentTypeLabel = documentTypeLabel;
	}
	
	public Integer getPhoneDdi() {
		return phoneDdi;
	}
	
	public void setPhoneDdi(Integer phoneDdi) {
		this.phoneDdi = phoneDdi;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}
