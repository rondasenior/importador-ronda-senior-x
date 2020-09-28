package br.com.senior.importadorrondaseniorx.view.menu.imports.person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringJoiner;

import br.com.senior.importadorrondaseniorx.controller.PersonController;
import br.com.senior.importadorrondaseniorx.utils.Utils;
import br.com.senior.importadorrondaseniorx.view.frame.LogFrame;
import br.com.senior.importadorrondaseniorx.view.menu.imports.ImportGenericView;

public class PeopleImportView extends ImportGenericView {

	private static final long serialVersionUID = 3601424075794078665L;
	
	private PersonController personController = new PersonController();
	private String log = null;
	
	public PeopleImportView() {
		super(new PeopleImportTableView());
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
        	setDefaultLog(personController.persistPeople(csvReaderValues));
        	Utils.showDialogMessageInfo("Sucesso", "Importação realizada com sucesso");
		} catch (ParseException e) {
			Utils.showDialogMessageError("Erro", "Erro inesperado converter uma data: " + e.getMessage());
		} catch (Exception e) {
			Utils.showDialogMessageError("Erro", "Erro inesperado: " + e.getMessage());
		}
	}
	
	@Override
	protected void showLog() {
		new LogFrame("Pessoas", log);
	}

	@Override
	protected void templateCsvFileButtonAction() {
		saveTemplateCsvFileButtonAction("importPeople", PeopleImportTableView.HEADERS);
	}
}
