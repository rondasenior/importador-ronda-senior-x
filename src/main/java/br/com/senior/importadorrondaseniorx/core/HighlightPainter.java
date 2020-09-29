package br.com.senior.importadorrondaseniorx.core;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import javax.swing.text.DefaultHighlighter.DefaultHighlightPainter;

import br.com.senior.importadorrondaseniorx.utils.Utils;

public class HighlightPainter extends DefaultHighlightPainter {
	
	private static List<Integer> positions = new ArrayList<>();
	private static Integer cursorPosition;
	
	public HighlightPainter(Color color) {
		super(color);
	}
	
	public static void highlight(JTextComponent textComp, String pattern, Highlighter.HighlightPainter highlightPainter) {
		positions = new ArrayList<>();
		cursorPosition = 0;
		
		removeHighlights(textComp);
		
		try {
			Highlighter hilite = textComp.getHighlighter();
			Document doc = textComp.getDocument();
			String text = doc.getText(0, doc.getLength());
			int pos = 0;
			
			while ((pos=text.toUpperCase().indexOf(pattern.toUpperCase(), pos)) >= 0) {
				positions.add(pos);
				hilite.addHighlight(pos, (pos + pattern.length()), highlightPainter);
				pos += pattern.length();
			}
			
		} catch (Exception e) {
			Utils.showDialogMessageError("Erro", "Erro ao buscar texto.");
		}
	}
	
	public static void removeHighlights(JTextComponent textComp) {
		Highlighter hilite = textComp.getHighlighter();
		Highlighter.Highlight[] hilites = hilite.getHighlights();
		
		for (int i = 0; i < hilites.length; i++) {
			if (hilites[i].getPainter() instanceof HighlightPainter) {
				hilite.removeHighlight(hilites[i]);
			}
		}
	}
	
	public static void next(JTextArea textArea) {
		if (positions.isEmpty()) {
			return;
		}
		
		if (cursorPosition == positions.size()) {
			cursorPosition = 0;
		}
		textArea.setCaretPosition(positions.get(cursorPosition++));
	}
	
	public static void previous(JTextArea textArea) {
		if (positions.isEmpty()) {
			return;
		}
		
		if (cursorPosition == 0) {
			cursorPosition = positions.size();
		}
		textArea.setCaretPosition(positions.get(--cursorPosition));
	}
}
