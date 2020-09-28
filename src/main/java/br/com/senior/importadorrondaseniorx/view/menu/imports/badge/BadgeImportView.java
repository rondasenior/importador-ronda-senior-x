package br.com.senior.importadorrondaseniorx.view.menu.imports.badge;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringJoiner;

import br.com.senior.importadorrondaseniorx.controller.CardCredentialController;
import br.com.senior.importadorrondaseniorx.utils.Utils;
import br.com.senior.importadorrondaseniorx.view.frame.LogFrame;
import br.com.senior.importadorrondaseniorx.view.menu.imports.ImportGenericView;

public class BadgeImportView extends ImportGenericView implements ActionListener {

	private static final long serialVersionUID = -8054925103004621916L;
	
	private CardCredentialController controller = new CardCredentialController();
	private String log = null;
	
	public BadgeImportView() {
		super(new BadgeImportTableView());
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
        	setDefaultLog(controller.persistCredentialCard(csvReaderValues));
        	Utils.showDialogMessageInfo("Sucesso", "Importação realizada com sucesso");
		} catch (Exception e) {
			Utils.showDialogMessageError("Erro", "Erro inesperado: " + e.getMessage());
		}
	}

	@Override
	protected void showLog() {
		new LogFrame("Vincular Crachás", log);
	}
	
	@Override
	protected void templateCsvFileButtonAction() {
		saveTemplateCsvFileButtonAction("importLinkBadge", BadgeImportTableView.HEADERS);
	}
}
