package br.com.senior.importadorrondaseniorx.view.menu.imports.group;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringJoiner;

import br.com.senior.importadorrondaseniorx.controller.GroupController;
import br.com.senior.importadorrondaseniorx.core.MandatoryFieldEmptyException;
import br.com.senior.importadorrondaseniorx.utils.Utils;
import br.com.senior.importadorrondaseniorx.view.frame.LogFrame;
import br.com.senior.importadorrondaseniorx.view.menu.imports.ImportGenericView;

public class GroupImportView extends ImportGenericView implements ActionListener {

	private static final long serialVersionUID = -8054925103004621916L;

	private GroupController controller = new GroupController();
	private String log = null;
	
	public GroupImportView() {
		super(new GroupImportTableView());
		setBounds(0, 0, 884, 463);
		setLayout(null);
	}

	private void setDefaultLog(String message) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		log = new StringJoiner("")
				.add("Processo realizado em: ").add(format.format(new Date()))
				.add("\n\n")
				.add(message)
				.toString();
	}
	
	@Override
	protected void confirmImportButtonAction() {
        try {
        	setDefaultLog(controller.persistGroupPerson(csvReaderValues));
        	if (log.contains("ERRO")) {
        		Utils.showDialogMessageWarn("Atenção", "Registros não foram importados corretamente, verifique o LOG.");
        	} else {
        		Utils.showDialogMessageInfo("Sucesso", "Importação realizada com sucesso");
        	}
		} catch (MandatoryFieldEmptyException e) {
			e.showError();
		} catch (Exception e) {
			Utils.showDialogMessageError("Erro", "Erro inesperado: " + e.getMessage());
		}
	}

	@Override
	protected void showLog() {
		new LogFrame("Vincular Grupos", log);
	}
	
	@Override
	protected void templateCsvFileButtonAction() {
		saveTemplateCsvFileButtonAction("importLinkGroup", GroupImportTableView.HEADERS);
	}
}
