package br.com.senior.importadorrondaseniorx.utils;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringJoiner;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.opencsv.CSVWriter;

import br.com.senior.importadorrondaseniorx.core.MandatoryFieldEmptyException;

public class Utils {
	
	public static final String NEW_LINE = "\n";
	
	public static ImageIcon getImageIcon(String path, String description) {
		URL imgURL = Utils.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		}
		showDialogMessageError("Erro", "Não foi possível encontrar a imagem: " + path);
		return null;
	}
	
	public static Image getImage(String path) {
		URL imgURL = Utils.class.getResource(path);
		if (imgURL != null) {
			return Toolkit.getDefaultToolkit().getImage(imgURL);
		}
		showDialogMessageError("Erro", "Não foi possível encontrar a imagem: " + path);
		return null;
	}
	
	public static Image getSeniorImage() {
		return getImage("/images/senior-icon.png");
	}
	
	public static JDialog loading() {
		JDialog dialog = new JDialog();
		dialog.setSize(70, 50);
		dialog.add(new JLabel(getImageIcon("/images/loading.gif", "loading")));
		dialog.setUndecorated(Boolean.TRUE);
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(Boolean.TRUE);
		return dialog;
	}
	
	@SuppressWarnings("resource")
	public static void download(String path, String[] header) throws IOException {
		Writer writer = Files.newBufferedWriter(Paths.get(path));
        CSVWriter csvWriter = new CSVWriter(writer);
        csvWriter.writeNext(header);
		csvWriter.flush();
        writer.close();
	}

	public static void showDialogMessageError(String title, String msg) {
		JOptionPane.showMessageDialog(null, msg, title, JOptionPane.ERROR_MESSAGE);
	}
	
	public static void showDialogMessageInfo(String title, String msg) {
		JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void showDialogMessageWarn(String title, String msg) {
		JOptionPane.showMessageDialog(null, msg, title, JOptionPane.WARNING_MESSAGE);
	}
	
	public static int showDialogOptionDefault(String title, String msg) {
		Object[] options = { "Sim", "Não" }; 
		return showDialogOption(title, msg, JOptionPane.INFORMATION_MESSAGE, options, options[0]);
	}
	
	public static int showDialogOption(String title, String msg, Integer optionType, Object[] options, Object initialValue) {
		return JOptionPane.showOptionDialog(null, msg, title, JOptionPane.DEFAULT_OPTION, optionType, null, options, initialValue); 
	}
	
	public static String defaultLogError(String text) {
		return new StringJoiner(NEW_LINE)
				.add("______________________________________________________________________________________________")
				.add("                                             ERRO                                             ")
				.add("----------------------------------------------------------------------------------------------")
				.add(text)
				.add("______________________________________________________________________________________________")
				.add("").add("").add("").toString();
	}
	
	public static String defaultLogSucess(String text) {
		return new StringJoiner(NEW_LINE)
				.add("_________________________________________________________________________________________________")
				.add("                                             SUCESSO                                             ")
				.add("-------------------------------------------------------------------------------------------------")
				.add(text)
				.add("_________________________________________________________________________________________________")
				.add("").add("").add("").toString();
	}
	
	public static void validateMandatoryFieldEmpty(String field, String fieldName) throws MandatoryFieldEmptyException {
		if (isEmpty(field)) {
			throw new MandatoryFieldEmptyException("Campo obrigatório não informado: " + fieldName.toUpperCase());
		}
	}
	
	public static Boolean isEmpty(String value) {
		return value == null || value.trim().isEmpty();
	}
}
