package br.com.senior.importadorrondaseniorx.view.menu.search.group;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import br.com.senior.importadorrondaseniorx.dto.GroupSearchDto;
import br.com.senior.importadorrondaseniorx.utils.Utils;
import br.com.senior.importadorrondaseniorx.view.core.GenericTableView;

public class GroupSearchTableView extends GenericTableView {

	private static final long serialVersionUID = 4289635105530091233L;
	
	public static final String[] HEADERS = {"Id", "Nome", "Id Pai", "Quant. de Vagas", "Quant. de Vagas Usadas", "Id Local Físico", "Nome do Local Físico"};

	@SuppressWarnings("unchecked")
	@Override
	public void updateTable(Object objs) {
		addBadgeInTable((List<GroupSearchDto>) objs, newDefaultTable());
		showTable();
		resizeColumnWidth();
	}
	
	private void addBadgeInTable(List<GroupSearchDto> dtos, DefaultTableModel defaultTable) {
		if (!dtos.isEmpty()) {
			defaultTable.setColumnIdentifiers(HEADERS);
		} else {
			Utils.showDialogMessageError("Erro", "Nenhum resultado encontrado");
		}
		
		for (GroupSearchDto dto : dtos) {
			String id = dto.getId().toString();
			String name = dto.getName();
			String parent = dto.getParent() == null ? "" : dto.getParent().toString();
			String vacancyAmont = dto.getVacancyAmont().toString();
			String vacancyAmontUse = dto.getVacancyAmontUse().toString();
			String physicalLocationId = dto.getPhysicalLocationId() == null ? "" : dto.getPhysicalLocationId().toString();
			String physicalLocationName = dto.getPhysicalLocationName();
			
			defaultTable.addRow(new Object[] {id, name, parent, vacancyAmont, vacancyAmontUse, physicalLocationId, physicalLocationName});
		}
	}

}
