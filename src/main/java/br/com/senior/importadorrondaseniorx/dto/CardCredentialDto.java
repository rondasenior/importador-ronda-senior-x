package br.com.senior.importadorrondaseniorx.dto;

import java.util.StringJoiner;

import br.com.senior.importadorrondaseniorx.utils.Utils;

public class CardCredentialDto {
	
	private Long id;
	private String startDate;
	private String endDate;
	private Long personId;
	private Integer situation;
	private Integer cardTechnology;
	private Long cardNumber;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	public Long getPersonId() {
		return personId;
	}
	
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	
	public Integer getSituation() {
		return situation;
	}
	
	public void setSituation(Integer situation) {
		this.situation = situation;
	}
	
	public Integer getCardTechnology() {
		return cardTechnology;
	}
	
	public void setCardTechnology(Integer cardTechnology) {
		this.cardTechnology = cardTechnology;
	}
	
	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public String toString() {
		return new StringJoiner("")
				.add("Id da pessoa: ").add(personId.toString()).add(Utils.NEW_LINE)
				.add("Data de término: ").add(endDate).add(Utils.NEW_LINE)
				.add("Situação: ").add(situation.toString()).add(Utils.NEW_LINE)
				.add("Tecnologia: ").add(cardTechnology.toString()).add(Utils.NEW_LINE)
				.add("Número: ").add(cardNumber.toString()).toString();
	}
}
