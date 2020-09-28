package br.com.senior.importadorrondaseniorx.dto;

public class GroupSearchDto {
	
	private Long id;
	private String name;
	private Long parent;
	private Long vacancyAmont;
	private Long vacancyAmontUse;
	private Boolean controlVacancyAmount;
	private Long physicalLocationId;
	private String physicalLocationName;
	
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
	
	public Long getParent() {
		return parent;
	}
	
	public void setParent(Long parent) {
		this.parent = parent;
	}
	
	public Long getVacancyAmont() {
		return vacancyAmont;
	}
	
	public void setVacancyAmont(Long vacancyAmont) {
		this.vacancyAmont = vacancyAmont;
	}
	
	public Long getVacancyAmontUse() {
		return vacancyAmontUse;
	}
	
	public void setVacancyAmontUse(Long vacancyAmontUse) {
		this.vacancyAmontUse = vacancyAmontUse;
	}
	
	public Boolean getControlVacancyAmount() {
		return controlVacancyAmount;
	}
	
	public void setControlVacancyAmount(Boolean controlVacancyAmount) {
		this.controlVacancyAmount = controlVacancyAmount;
	}
	
	public Long getPhysicalLocationId() {
		return physicalLocationId;
	}
	
	public void setPhysicalLocationId(Long physicalLocationId) {
		this.physicalLocationId = physicalLocationId;
	}
	
	public String getPhysicalLocationName() {
		return physicalLocationName;
	}
	
	public void setPhysicalLocationName(String physicalLocationName) {
		this.physicalLocationName = physicalLocationName;
	}
}
