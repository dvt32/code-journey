/*
 * Created by JFormDesigner on Wed Feb 13 13:12:15 EET 2019
 */

package net.dvt32.gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Struct;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import net.dvt32.jdbc.JdbcTemplate;

/**
 * @author dvt32
 */
public class AgencyTableForm extends JFrame {
	
	private static final JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();
	
	public AgencyTableForm() {
		initComponents();
		
		try {
			ResultSet agencies = jdbcTemplate.selectAllFromTable("Agency");
			
			Vector<String> tableColumnNames = new Vector<String>();
			tableColumnNames.add("id");
			tableColumnNames.add("name");
			tableColumnNames.add("address");
			
			Vector<Object> tableData = new Vector<Object>();
			while (agencies.next()) {
				Struct agency = (Struct) agencies.getObject(1);
				Object[] attributeValues = agency.getAttributes();
				Vector<Object> rowData = new Vector<Object>();
				for (Object attributeValue : attributeValues) {
					rowData.add(attributeValue);
				}
				tableData.add(rowData);
			}
			
			table1.setModel( new DefaultTableModel(tableData, tableColumnNames) {
				@Override
			    public boolean isCellEditable(int rowIndex, int columnIndex) {
					int idColumnIndex = 0;
			        return columnIndex == idColumnIndex ? false : true;
			    }
			});
		} 
		catch (SQLException e) {
			System.out.println( e.getMessage() );
		}

		table1.getModel().addTableModelListener(new TableModelListener() {
			public void tableChanged(TableModelEvent e) {
				if (e.getType() == TableModelEvent.UPDATE) {
				    DefaultTableModel model = (DefaultTableModel) table1.getModel();    
				    int rowIndex = table1.getSelectedRow();
					Object id = model.getValueAt(rowIndex, 0);
					Object name = model.getValueAt(rowIndex, 1);
					Object address = model.getValueAt(rowIndex, 2);
					jdbcTemplate.updateByIdInTable("Agency", id, name, address);
					System.out.println("[AgencyTableForm] Successfully updated row with id " + id);
				}
			}
		});
	}
	
	private void button1MouseClicked(MouseEvent e) {
		DefaultTableModel model = (DefaultTableModel) this.table1.getModel();
		int numberOfRows = table1.getRowCount();
		BigDecimal id = null;
		
		if (numberOfRows == 0) {
			id = BigDecimal.ONE;
		}
		else {
			try {
				ResultSet maxIdResultSet = jdbcTemplate.getMaxIdFromTable("Agency");
				maxIdResultSet.next();
				BigDecimal maxId = maxIdResultSet.getBigDecimal(1);
				id = maxId.add(BigDecimal.ONE);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}		
		}
		
		jdbcTemplate.insertIntoTable("Agency", id);
		
		model.addRow( new Object[] { id } );
		
		System.out.println("[AgencyTableForm] Successfully inserted new row in DB with id " + id);
	}
	
	private void button2MouseClicked(MouseEvent e) {
		if (table1.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(this, "Please select a row to delete!", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else {
			DefaultTableModel model = (DefaultTableModel) this.table1.getModel();
			int[] rowIndices = table1.getSelectedRows();
			
			for (int i = 0; i < rowIndices.length; ++i) {
				Object id = model.getValueAt(rowIndices[i], 0);
				jdbcTemplate.deleteByIdFromTable("Agency", id);
				System.out.println("[AgencyTableForm] Successfully deleted row with id " + id);
			}
			
			for (int i = 0; i < rowIndices.length; ++i) {
				model.removeRow(rowIndices[i] - i);
			}
			
			JOptionPane.showMessageDialog(this, "Data successfully deleted from DB!", "Success", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - MilenV
		scrollPane1 = new JScrollPane();
		table1 = new JTable();
		button1 = new JButton();
		button2 = new JButton();

		//======== this ========
		setTitle("Agency Table");
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridBagLayout());
		((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
		((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
		((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0, 1.0E-4};
		((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {1.0, 0.0, 0.0, 1.0E-4};

		//======== scrollPane1 ========
		{

			//---- table1 ----
			table1.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null},
					{null, null},
				},
				new String[] {
					null, null
				}
			));
			scrollPane1.setViewportView(table1);
		}
		contentPane.add(scrollPane1, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 0, 0), 0, 0));

		//---- button1 ----
		button1.setText("NEW");
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				button1MouseClicked(e);
			}
		});
		contentPane.add(button1, new GridBagConstraints(0, 1, 3, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 0, 0), 0, 0));

		//---- button2 ----
		button2.setText("DELETE");
		button2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				button2MouseClicked(e);
			}
		});
		contentPane.add(button2, new GridBagConstraints(0, 2, 3, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 0, 0), 0, 0));
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - MilenV
	private JScrollPane scrollPane1;
	private JTable table1;
	private JButton button1;
	private JButton button2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}