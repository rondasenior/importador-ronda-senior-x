package br.com.senior.importadorrondaseniorx.view.menu.imports.group;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import br.com.senior.importadorrondaseniorx.view.core.GenericTableView;

public class GroupImportTableView extends GenericTableView {

	private static final long serialVersionUID = -6455398102670403888L;
	
	public static final String[] HEADERS = {"ID do Grupo", "ID da Pessoa"};

	@SuppressWarnings("unchecked")
	@Override
	public void updateTable(Object objs) {
		addGroupInTable((List<String[]>) objs, newDefaultTable());
		showTable();
	}
	
	private void addGroupInTable(List<String[]> objs, DefaultTableModel defaultTable) {
		if (!objs.isEmpty()) {
			defaultTable.setColumnIdentifiers(HEADERS);
		}
		
		for (String[] person : objs) {
			int position = 0;
			String groupId = person[position++];
			String personId = person[position++];
			
			defaultTable.addRow(new Object[] {groupId, personId});
		}
	}
}
