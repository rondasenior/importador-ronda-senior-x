package br.com.senior.importadorrondaseniorx.model.search.group;

public class GroupSearch {

	private Long id;
	private String name;
	private Long parent;
	private Long vacancyAmont;
	private Long vacancyAmontUse;
	private Boolean controlVacancyAmount;
	private SimplePhysicalLocation physicalLocation;
	
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
	
	public SimplePhysicalLocation getPhysicalLocation() {
		return physicalLocation;
	}
	
	public void setPhysicalLocation(SimplePhysicalLocation physicalLocation) {
		this.physicalLocation = physicalLocation;
	}
}
