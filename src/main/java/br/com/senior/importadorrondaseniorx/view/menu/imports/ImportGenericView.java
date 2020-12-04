package br.com.senior.importadorrondaseniorx.view.menu.imports;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.opencsv.CSVReader;

import br.com.senior.importadorrondaseniorx.utils.Utils;
import br.com.senior.importadorrondaseniorx.view.core.GenericTableView;

public abstract class ImportGenericView extends JPanel implements ActionListener {

	private static final long serialVersionUID = 2259029828085905720L;

	protected final JButton importFileButton = new JButton("Importar Arquivo", Utils.getImageIcon("/images/file.png", "file"));
	protected final JButton templateFileButton = new JButton("Arquivo modelo", Utils.getImageIcon("/images/down.png", "down"));
	protected final JButton confirmImportButton = new JButton("Confirmar");
	protected final JButton logButton = new JButton("Log");
	
	private JFileChooser fileChooser;
	
	protected List<String[]> csvReaderValues;
	
	private GenericTableView genericTableView;
	
	public ImportGenericView(GenericTableView genericTableView) {
		csvReaderValues = new ArrayList<>();
		this.genericTableView = genericTableView;
		createFileChooser();
		addTable();
		addButtons();
	}
	
	private void addTable() {
		genericTableView.setBounds(0, 0, 884, 405);
		add(genericTableView);
	}
	
	private void createFileChooser() {
		UIManager.put("FileChooser.cancelButtonText", "Cancelar");
		fileChooser = new JFileChooser();
		fileChooser.setAcceptAllFileFilterUsed(Boolean.FALSE);
	}
	
	protected void saveTemplateCsvFileButtonAction(String fileName, String[] headers) {
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setDialogTitle("Pasta para download");
		fileChooser.setApproveButtonText("Selecionar");
		
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
            	File file = fileChooser.getSelectedFile();
            	String absolutePath = file.getAbsolutePath() + "\\" + fileName + ".csv";
            	Utils.download(absolutePath, headers);
            	int optionSelected = Utils.showDialogOptionDefault("Sucesso", "Arquivo baixado em " + absolutePath + ".\nDeseja abrir o local do arquivo?");
            	if (optionSelected == 0) {
            		Runtime.getRuntime().exec("explorer " + file.getAbsolutePath());
            	}
			} catch (IOException e) {
				Utils.showDialogMessageError("Erro", "Erro inesperado ao fazer download do arquivo: " + e.getMessage());
			}
        }
	}
	
	protected void importFileButtonAction() {
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fileChooser.setFileFilter(new FileNameExtensionFilter("*.csv", "csv"));
		fileChooser.setDialogTitle("Importar Arquivo");
		fileChooser.setApproveButtonText("Abrir");
		
        int returnVal = fileChooser.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
			try {
				CSVReader csvReader = new CSVReader(new InputStreamReader(new FileInputStream(file.getAbsolutePath()), "UTF-8"));
				csvReader.skip(1);
				csvReaderValues = csvReader.readAll();
				if (csvReaderValues.size() == 0) {
					Utils.showDialogMessageError("Erro", "Nenhum resultado encontrado no arquivo");
					confirmImportButton.setEnabled(Boolean.FALSE);
				}
				confirmImportButton.setEnabled(Boolean.TRUE);
				reloadTable();
			} catch (IOException e) {
				Utils.showDialogMessageError("Erro", "Erro inesperado ao importar o arquivo: " + e.getMessage());
			}
        }
	}

	protected void addButtons() {
		importFileButton.setBounds(564, 416, 161, 25);
		importFileButton.addActionListener(this);
		add(importFileButton);
		
		templateFileButton.setBounds(399, 416, 155, 25);
		templateFileButton.addActionListener(this);
		add(templateFileButton);
		
		confirmImportButton.setEnabled(Boolean.FALSE);
		confirmImportButton.setBounds(735, 416, 149, 25);
		confirmImportButton.addActionListener(this);
		add(confirmImportButton);
		
		logButton.setEnabled(Boolean.FALSE);
		logButton.setBounds(287, 416, 100, 25);
		logButton.addActionListener(this);
		add(logButton);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getSource() == importFileButton) {
			importFileButtonAction();
        } else if (actionEvent.getSource() == templateFileButton) {
        	templateCsvFileButtonAction();
        } else if (actionEvent.getSource() == confirmImportButton) {
        	loadConfirmImport();
        } else if (actionEvent.getSource() == logButton) {
        	showLog();
        }
	}
	
	private void loadConfirmImport() {
		JDialog loading = Utils.loading();
		
		@SuppressWarnings("rawtypes")
		SwingWorker worker = new SwingWorker() {
			@Override
			protected Void doInBackground() throws Exception {
	        	logButton.setEnabled(Boolean.TRUE);
	        	setVisible(Boolean.FALSE);
				confirmImportButtonAction();
				return null;
			}
		};
		
		worker.addPropertyChangeListener(evt -> {
			if (SwingWorker.StateValue.DONE == evt.getNewValue()) {
				loading.setVisible(Boolean.FALSE);
				setVisible(Boolean.TRUE);
		    }
		});

		worker.execute();
	}

	protected void reloadTable() {
		try {
			this.genericTableView.updateTable(csvReaderValues);
		} catch (ArrayIndexOutOfBoundsException e) {
			Utils.showDialogMessageError("Erro", "Ocorreu um erro ao carregar o CSV: " + e.getMessage());
		}
	}
	
	protected abstract void confirmImportButtonAction();
	
	protected abstract void showLog();
	
	protected abstract void templateCsvFileButtonAction();
}
