package br.com.senior.importadorrondaseniorx.view.core;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import br.com.senior.importadorrondaseniorx.utils.Utils;

public abstract class GenericTableView extends JPanel {

	private static final long serialVersionUID = 1541263369265428187L;

	private JLabel emptyLabel = new JLabel(Utils.getImageIcon("/images/table-icon.png", "table-icon"));
	protected JTable table;
	protected JScrollPane scrollbar;

	public GenericTableView() {
		setConfigs();
	}

	private void setConfigs() {
		setBackground(Color.LIGHT_GRAY);
		setBounds(0, 0, 884, 405);
		setLayout(null);
		
		instantiateTable();
		insertTable();
		createEmptyLabel();
		showTable();
	}

	public void instantiateTable() {
		DefaultTableModel model = new DefaultTableModel();

		table = new JTable(model) {
			private static final long serialVersionUID = -3264116075674720667L;

			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component comp = super.prepareRenderer(renderer, row, column);
				Color alternateColor = new Color(200, 201, 210);
				Color whiteColor = Color.WHITE;
				
				if (!comp.getBackground().equals(getSelectionBackground())) {
					Color c = (row % 2 == 0 ? alternateColor : whiteColor);
					comp.setBackground(c);
					c = null;
				}
				return comp;
			}
		};
	}
	
	private void insertTable() {
		table.setEnabled(false);
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);

		table.setRowSelectionAllowed(false);
		table.setPreferredScrollableViewportSize(new Dimension(840, 343));
		
		scrollbar = new JScrollPane(table);
		scrollbar.setBounds(0, 0, 884, 405);
		add(scrollbar);
	}

	private void createEmptyLabel() {
		emptyLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		emptyLabel.setText("Nenhum resultado encontrado");
		emptyLabel.setHorizontalTextPosition(JLabel.CENTER);
		emptyLabel.setVerticalTextPosition(JLabel.BOTTOM);
		emptyLabel.setBackground(Color.RED);
		emptyLabel.setBounds(0, 0, 884, 405);
		add(emptyLabel);
	}

	public abstract void updateTable(Object objs) throws ArrayIndexOutOfBoundsException;
	
	public boolean tableIsEmpty() {
		return table.getRowCount() == 0 && table.getColumnCount() == 0;
	}

	public void showTable() {
		if (tableIsEmpty()) {
			scrollbar.setVisible(Boolean.FALSE);
			emptyLabel.setVisible(Boolean.TRUE);
		} else {
			scrollbar.setVisible(Boolean.TRUE);
			emptyLabel.setVisible(Boolean.FALSE);
		}
	}

	public DefaultTableModel newDefaultTable() {
		DefaultTableModel defaultTable = (DefaultTableModel) table.getModel();
		defaultTable.setRowCount(0);
		defaultTable.setColumnCount(0);
		return defaultTable;
	}
	
	public void resizeColumnWidth() {
	    final TableColumnModel columnModel = table.getColumnModel();
	    for (int column = 0; column < table.getColumnCount(); column++) {
	        int width = 50;
	        
	        for (int row = 0; row < table.getRowCount(); row++) {
	            TableCellRenderer renderer = table.getCellRenderer(row, column);
	            Component comp = table.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width + 1 , width);
	        }
	        
	        if(width > 300) {
	            width=300;
	        }
	        columnModel.getColumn(column).setPreferredWidth(width);
	    }
	}
}
