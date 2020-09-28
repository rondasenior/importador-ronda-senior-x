package br.com.senior.importadorrondaseniorx.model.search.role;

public class RoleSearch {

	private Long id;
	private String name;
	private Boolean usesProvisory;
	private Boolean sendEmailToVisited;
	private Boolean receivesVisit;
	private Boolean usedBySelfServiceTerminal;
	private Boolean inheritSuspensionByImportedRole;
	private Boolean usesFacialRecognition;
	private Integer validateLevel;
	private Integer validateAntiPassback;
	private Integer validateStocking;
	private Integer validateCreditAccess;
	private Integer validateScaleRange;
	private Integer validateTimeBand;
	private Integer validateAuthorizerRole;
	private Integer validateAuthorizerPlace;
	private Integer validateVacancy;
	private Integer validatePhysicallocation;
	private Integer checkCustomValidation;
	private Integer checkInBetweenWorkdays;
	private Integer inBetweenWorkdaysTimeInHours;
	private Integer inBetweenWorkdaysToleranceInMinutes;
	private Boolean integrated;
	private Boolean indexPersonPhoto;
	
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
	
	public Boolean getUsesProvisory() {
		return usesProvisory;
	}
	
	public void setUsesProvisory(Boolean usesProvisory) {
		this.usesProvisory = usesProvisory;
	}
	
	public Boolean getSendEmailToVisited() {
		return sendEmailToVisited;
	}
	
	public void setSendEmailToVisited(Boolean sendEmailToVisited) {
		this.sendEmailToVisited = sendEmailToVisited;
	}
	
	public Boolean getReceivesVisit() {
		return receivesVisit;
	}
	
	public void setReceivesVisit(Boolean receivesVisit) {
		this.receivesVisit = receivesVisit;
	}
	
	public Boolean getUsedBySelfServiceTerminal() {
		return usedBySelfServiceTerminal;
	}
	
	public void setUsedBySelfServiceTerminal(Boolean usedBySelfServiceTerminal) {
		this.usedBySelfServiceTerminal = usedBySelfServiceTerminal;
	}
	
	public Boolean getInheritSuspensionByImportedRole() {
		return inheritSuspensionByImportedRole;
	}
	
	public void setInheritSuspensionByImportedRole(Boolean inheritSuspensionByImportedRole) {
		this.inheritSuspensionByImportedRole = inheritSuspensionByImportedRole;
	}
	
	public Boolean getUsesFacialRecognition() {
		return usesFacialRecognition;
	}
	
	public void setUsesFacialRecognition(Boolean usesFacialRecognition) {
		this.usesFacialRecognition = usesFacialRecognition;
	}
	
	public Integer getValidateLevel() {
		return validateLevel;
	}
	
	public void setValidateLevel(Integer validateLevel) {
		this.validateLevel = validateLevel;
	}
	
	public Integer getValidateAntiPassback() {
		return validateAntiPassback;
	}
	
	public void setValidateAntiPassback(Integer validateAntiPassback) {
		this.validateAntiPassback = validateAntiPassback;
	}
	
	public Integer getValidateStocking() {
		return validateStocking;
	}
	
	public void setValidateStocking(Integer validateStocking) {
		this.validateStocking = validateStocking;
	}
	
	public Integer getValidateCreditAccess() {
		return validateCreditAccess;
	}
	
	public void setValidateCreditAccess(Integer validateCreditAccess) {
		this.validateCreditAccess = validateCreditAccess;
	}
	
	public Integer getValidateScaleRange() {
		return validateScaleRange;
	}
	
	public void setValidateScaleRange(Integer validateScaleRange) {
		this.validateScaleRange = validateScaleRange;
	}
	
	public Integer getValidateTimeBand() {
		return validateTimeBand;
	}
	
	public void setValidateTimeBand(Integer validateTimeBand) {
		this.validateTimeBand = validateTimeBand;
	}
	
	public Integer getValidateAuthorizerRole() {
		return validateAuthorizerRole;
	}
	
	public void setValidateAuthorizerRole(Integer validateAuthorizerRole) {
		this.validateAuthorizerRole = validateAuthorizerRole;
	}
	
	public Integer getValidateAuthorizerPlace() {
		return validateAuthorizerPlace;
	}
	
	public void setValidateAuthorizerPlace(Integer validateAuthorizerPlace) {
		this.validateAuthorizerPlace = validateAuthorizerPlace;
	}
	
	public Integer getValidateVacancy() {
		return validateVacancy;
	}
	
	public void setValidateVacancy(Integer validateVacancy) {
		this.validateVacancy = validateVacancy;
	}
	
	public Integer getValidatePhysicallocation() {
		return validatePhysicallocation;
	}
	
	public void setValidatePhysicallocation(Integer validatePhysicallocation) {
		this.validatePhysicallocation = validatePhysicallocation;
	}
	
	public Integer getCheckCustomValidation() {
		return checkCustomValidation;
	}
	
	public void setCheckCustomValidation(Integer checkCustomValidation) {
		this.checkCustomValidation = checkCustomValidation;
	}
	
	public Integer getCheckInBetweenWorkdays() {
		return checkInBetweenWorkdays;
	}
	
	public void setCheckInBetweenWorkdays(Integer checkInBetweenWorkdays) {
		this.checkInBetweenWorkdays = checkInBetweenWorkdays;
	}
	
	public Integer getInBetweenWorkdaysTimeInHours() {
		return inBetweenWorkdaysTimeInHours;
	}
	
	public void setInBetweenWorkdaysTimeInHours(Integer inBetweenWorkdaysTimeInHours) {
		this.inBetweenWorkdaysTimeInHours = inBetweenWorkdaysTimeInHours;
	}
	
	public Integer getInBetweenWorkdaysToleranceInMinutes() {
		return inBetweenWorkdaysToleranceInMinutes;
	}
	
	public void setInBetweenWorkdaysToleranceInMinutes(Integer inBetweenWorkdaysToleranceInMinutes) {
		this.inBetweenWorkdaysToleranceInMinutes = inBetweenWorkdaysToleranceInMinutes;
	}
	
	public Boolean getIntegrated() {
		return integrated;
	}
	
	public void setIntegrated(Boolean integrated) {
		this.integrated = integrated;
	}
	
	public Boolean getIndexPersonPhoto() {
		return indexPersonPhoto;
	}
	
	public void setIndexPersonPhoto(Boolean indexPersonPhoto) {
		this.indexPersonPhoto = indexPersonPhoto;
	}
	
}
