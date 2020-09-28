package br.com.senior.importadorrondaseniorx.view.menu.search.role;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.senior.importadorrondaseniorx.dto.RoleSearchDto;
import br.com.senior.importadorrondaseniorx.enums.ValidateRolesType;
import br.com.senior.importadorrondaseniorx.utils.Utils;
import br.com.senior.importadorrondaseniorx.view.core.GenericTableView;

public class RoleSearchTableView extends GenericTableView {

	private static final long serialVersionUID = 4289635105530091233L;
	
	public static final String[] HEADERS = {"Id", "Nome", "Uso provisório", "Envia e-mail p/ visitado", "Recebe visitas", "Usado para o terminal de autoatendimento",
											"Herdar suspensão por papel importado", "Utiliza reconhecimento facial", "Valida nível", "Valida anti-dupla",
											"Validar lotação", "Valida crédito de acesso", "Valida faixa escala", "Valida faixa horária", "Valida autorizador do papel",
											"Valida autorizador do local", "Valida vaga", "Valida local", "Controla validação customizada", "Controla interjonada",
											"Tempo interjonada horas", "Tolerância interjonada minutos", "Integrado", "Indexa foto da pessoa"};

	@SuppressWarnings("unchecked")
	@Override
	public void updateTable(Object objs) {
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		addBadgeInTable((List<RoleSearchDto>) objs, newDefaultTable());
		showTable();
		resizeColumnWidth();
	}
	
	private void addBadgeInTable(List<RoleSearchDto> dtos, DefaultTableModel defaultTable) {
		if (!dtos.isEmpty()) {
			defaultTable.setColumnIdentifiers(HEADERS);
		} else {
			Utils.showDialogMessageError("Erro", "Nenhum resultado encontrado");
		}
		
		for (RoleSearchDto dto : dtos) {
			String id = dto.getId().toString();
			String name = dto.getName();
			String usesProvisory = dto.getUsesProvisory() == null ? "" : getYesOrNo(dto.getUsesProvisory());
			String sendEmailToVisited = dto.getSendEmailToVisited() == null ? "" : getYesOrNo(dto.getSendEmailToVisited());
			String receivesVisit = dto.getReceivesVisit() == null ? "" : getYesOrNo(dto.getReceivesVisit());
			String usedBySelfServiceTerminal = dto.getUsedBySelfServiceTerminal() == null ? "" : getYesOrNo(dto.getUsedBySelfServiceTerminal());
			String inheritSuspensionByImportedRole = dto.getInheritSuspensionByImportedRole() == null ? "" : getYesOrNo(dto.getInheritSuspensionByImportedRole());
			String usesFacialRecognition = dto.getUsesFacialRecognition() == null ? "" : getYesOrNo(dto.getUsesFacialRecognition());
			String validateLevel = dto.getValidateLevel() == null ? "" : getValidateTypeValue(dto.getValidateLevel());
			String validateAntiPassback = dto.getValidateAntiPassback() == null ? "" : getValidateTypeValue(dto.getValidateAntiPassback());
			String validateStocking = dto.getValidateStocking() == null ? "" : getValidateTypeValue(dto.getValidateStocking());
			String validateCreditAccess = dto.getValidateCreditAccess() == null ? "" : getValidateTypeValue(dto.getValidateCreditAccess());
			String validateScaleRange = dto.getValidateScaleRange() == null ? "" : getValidateTypeValue(dto.getValidateScaleRange());
			String validateTimeBand = dto.getValidateTimeBand() == null ? "" : getValidateTypeValue(dto.getValidateTimeBand());
			String validateAuthorizerRole = dto.getValidateAuthorizerRole() == null ? "" : getValidateTypeValue(dto.getValidateAuthorizerRole());
			String validateAuthorizerPlace = dto.getValidateAuthorizerPlace() == null ? "" : getValidateTypeValue(dto.getValidateAuthorizerPlace());
			String validateVacancy = dto.getValidateVacancy() == null ? "" : getValidateTypeValue(dto.getValidateVacancy());
			String validatePhysicallocation = dto.getValidatePhysicallocation() == null ? "" : getValidateTypeValue(dto.getValidatePhysicallocation());
			String checkCustomValidation = dto.getCheckCustomValidation() == null ? "" : getValidateTypeValue(dto.getCheckCustomValidation());
			String checkInBetweenWorkdays = dto.getCheckInBetweenWorkdays() == null ? "" : getValidateTypeValue(dto.getCheckInBetweenWorkdays());
			String inBetweenWorkdaysTimeInHours = dto.getInBetweenWorkdaysTimeInHours() == null ? "" : dto.getInBetweenWorkdaysTimeInHours().toString();
			String inBetweenWorkdaysToleranceInMinutes = dto.getInBetweenWorkdaysToleranceInMinutes() == null ? "" : dto.getInBetweenWorkdaysToleranceInMinutes().toString();
			String integrated = dto.getIntegrated() == null ? "" : getYesOrNo(dto.getIntegrated());
			String indexPersonPhoto = dto.getIndexPersonPhoto() == null ? "" : getYesOrNo(dto.getIndexPersonPhoto());
			
			defaultTable.addRow(new Object[] {id, name, usesProvisory, sendEmailToVisited, receivesVisit, usedBySelfServiceTerminal, inheritSuspensionByImportedRole,
											  usesFacialRecognition, validateLevel, validateAntiPassback, validateStocking, validateCreditAccess, validateScaleRange,
											  validateTimeBand, validateAuthorizerRole, validateAuthorizerPlace, validateVacancy, validatePhysicallocation, checkCustomValidation,
											  checkInBetweenWorkdays, inBetweenWorkdaysTimeInHours, inBetweenWorkdaysToleranceInMinutes, inBetweenWorkdaysToleranceInMinutes,
											  integrated, indexPersonPhoto});
		}
	}

	private String getValidateTypeValue(Integer index) {
		return ValidateRolesType.values()[index].toString();
	}
	
	private String getYesOrNo(Boolean value) {
		return value ? "Sim" : "Não";
	}
}
