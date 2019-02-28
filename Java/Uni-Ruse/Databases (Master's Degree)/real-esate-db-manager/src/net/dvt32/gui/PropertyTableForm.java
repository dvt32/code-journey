/*
 * Created by JFormDesigner on Fri Feb 08 11:21:18 EET 2019
 */

package net.dvt32.gui;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Struct;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import net.dvt32.jdbc.JdbcTemplate;
import net.miginfocom.swing.MigLayout;

/**
 * @author dvt32
 */
public class PropertyTableForm extends JFrame {
	
	private static final JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();
	
	public PropertyTableForm() {
		initComponents();
		
		// Initialize Houses JTable
		try {
			ResultSet houses = jdbcTemplate.selectAllFromTable("Property/House");
			
			Vector<String> tableColumnNames = new Vector<String>();
			tableColumnNames.add("address");
			tableColumnNames.add("ownerName_firstName");
			tableColumnNames.add("ownerName_lastName");
			tableColumnNames.add("priceInLeva");
			tableColumnNames.add("numberOfRooms");
			tableColumnNames.add("sizeInSquareMeters");
			
			Vector<Object> tableData = new Vector<Object>();
			while (houses.next()) {
				Struct house = (Struct) houses.getObject(1);
				Object[] attributeValues = house.getAttributes();
				Vector<Object> rowData = new Vector<Object>();
				
				for (Object attributeValue : attributeValues) {
					if (attributeValue instanceof Struct) {
						Object[] structAttributeValues = ((Struct) attributeValue).getAttributes();
						for (Object structAttributeValue : structAttributeValues) {
							rowData.add(structAttributeValue);
						}
					}
					else {
						rowData.add(attributeValue);
					}
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
		
		// Initialize Business Properties JTable
		try {
			ResultSet businessProperties = jdbcTemplate.selectAllFromTable("Property/BusinessProperty");
			
			Vector<String> tableColumnNames = new Vector<String>();
			tableColumnNames.add("address");
			tableColumnNames.add("ownerName_firstName");
			tableColumnNames.add("ownerName_lastName");
			tableColumnNames.add("priceInLeva");
			tableColumnNames.add("businessPropertyType");
			tableColumnNames.add("sizeInSquareMeters");
			
			Vector<Object> tableData = new Vector<Object>();
			while (businessProperties.next()) {
				Struct businessProperty = (Struct) businessProperties.getObject(1);
				Object[] attributeValues = businessProperty.getAttributes();
				Vector<Object> rowData = new Vector<Object>();
				
				for (Object attributeValue : attributeValues) {
					if (attributeValue instanceof Struct) {
						Object[] structAttributeValues = ((Struct) attributeValue).getAttributes();
						for (Object structAttributeValue : structAttributeValues) {
							rowData.add(structAttributeValue);
						}
					}
					else {
						rowData.add(attributeValue);
					}
				}
				
				tableData.add(rowData);
			}
			
			table2.setModel( new DefaultTableModel(tableData, tableColumnNames) {
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
				    
				    Object address = model.getValueAt(rowIndex, 0);
					Object ownerName_firstName = model.getValueAt(rowIndex, 1);
					Object ownerName_lastName = model.getValueAt(rowIndex, 2);
					Object priceInLeva = model.getValueAt(rowIndex, 3);
					Object numberOfRooms = model.getValueAt(rowIndex, 4);
					Object sizeInSquareMeters = model.getValueAt(rowIndex, 5);
					
					jdbcTemplate.updateByIdInTable(
						"Property/House", 
						address, 
						ownerName_firstName, 
						ownerName_lastName, 
						priceInLeva, 
						numberOfRooms, 
						sizeInSquareMeters
					);
					
					System.out.println("[PropertyTableForm] Successfully updated row with address " + address + " (house)");
				}
			}
		});
		
		table2.getModel().addTableModelListener(new TableModelListener() {
			public void tableChanged(TableModelEvent e) {
				if (e.getType() == TableModelEvent.UPDATE) {
				    DefaultTableModel model = (DefaultTableModel) table2.getModel();    
				    int rowIndex = table2.getSelectedRow();
					
				    Object address = model.getValueAt(rowIndex, 0);
					Object ownerName_firstName = model.getValueAt(rowIndex, 1);
					Object ownerName_lastName = model.getValueAt(rowIndex, 2);
					Object priceInLeva = model.getValueAt(rowIndex, 3);
					Object businessPropertyType = model.getValueAt(rowIndex, 4);
					Object sizeInSquareMeters = model.getValueAt(rowIndex, 5);
					
					jdbcTemplate.updateByIdInTable(
						"Property/BusinessProperty", 
						address, 
						ownerName_firstName, 
						ownerName_lastName, 
						priceInLeva, 
						businessPropertyType, 
						sizeInSquareMeters
					);
					
					System.out.println("[PropertyTableForm] Successfully updated row with address " + address + " (business property)");
				}
			}
		});
	}

	private void button1MouseClicked(MouseEvent e) {
		String address = JOptionPane.showInputDialog("Enter address: ");
		boolean isValidAddress = (address != null) && ( (address = address.trim()).isEmpty() != true );
		if (isValidAddress) {
			jdbcTemplate.insertIntoTable("Property/House", address);
			DefaultTableModel model = (DefaultTableModel) this.table1.getModel();
			model.addRow( new Object[] { address } );
			System.out.println("[PropertyTableForm] Successfully inserted new row in DB with address " + address + " (house)");
		}
		else {
			JOptionPane.showMessageDialog(this, "Invalid address!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void button2MouseClicked(MouseEvent e) {
		String address = JOptionPane.showInputDialog("Enter address: ");
		boolean isValidAddress = (address != null) && ( (address = address.trim()).isEmpty() != true );
		if (isValidAddress) {
			jdbcTemplate.insertIntoTable("Property/BusinessProperty", address);
			DefaultTableModel model = (DefaultTableModel) this.table2.getModel();
			model.addRow( new Object[] { address } );
			System.out.println("[PropertyTableForm] Successfully inserted new row in DB with address " + address + " (business property)");
		}
		else {
			JOptionPane.showMessageDialog(this, "Invalid address!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void button3MouseClicked(MouseEvent e) {
		if (table1.getSelectedRow() == -1 && table2.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(this, "Please select a row to delete!", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else {
			DefaultTableModel table1Model = (DefaultTableModel) this.table1.getModel();
			DefaultTableModel table2Model = (DefaultTableModel) this.table2.getModel();
			
			int[] table1SelectedRowIndices = table1.getSelectedRows();
			int[] table2SelectedRowIndices = table2.getSelectedRows();
			
			for (int i = 0; i < table1SelectedRowIndices.length; ++i) {
				Object address = table1Model.getValueAt(table1SelectedRowIndices[i], 0);
				jdbcTemplate.deleteByIdFromTable("Property/House", address);
				System.out.println("[PropertyTableForm] Successfully deleted row with address " + address + " (house)");
			}
			for (int i = 0; i < table2SelectedRowIndices.length; ++i) {
				Object address = table2Model.getValueAt(table2SelectedRowIndices[i], 0);
				jdbcTemplate.deleteByIdFromTable("Property/BusinessProperty", address);
				System.out.println("[PropertyTableForm] Successfully deleted row with address " + address + " (business property)");
			}
			
			for (int i = 0; i < table1SelectedRowIndices.length; ++i) {
				table1Model.removeRow(table1SelectedRowIndices[i] - i);
			}
			for (int i = 0; i < table2SelectedRowIndices.length; ++i) {
				table2Model.removeRow(table2SelectedRowIndices[i] - i);
			}
			
			JOptionPane.showMessageDialog(this, "Data successfully deleted from DB!", "Success", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - MilenV
		scrollPane2 = new JScrollPane();
		label1 = new JLabel();
		scrollPane1 = new JScrollPane();
		table1 = new JTable();
		label2 = new JLabel();
		scrollPane3 = new JScrollPane();
		table2 = new JTable();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();

		//======== this ========
		setTitle("Property Table");
		Container contentPane = getContentPane();
		contentPane.setLayout(new MigLayout(
			"insets 0,hidemode 3,gap 0 0",
			// columns
			"[grow,fill]" +
			"[grow,fill]" +
			"[grow,fill]" +
			"[grow,fill]" +
			"[grow,fill]" +
			"[grow,fill]" +
			"[grow,fill]",
			// rows
			"[grow,fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]" +
			"[fill]"));

		//======== scrollPane2 ========
		{

			//---- label1 ----
			label1.setText("Houses");
			label1.setHorizontalAlignment(SwingConstants.CENTER);
			label1.setLabelFor(table1);
			scrollPane2.setViewportView(label1);
		}
		contentPane.add(scrollPane2, "cell 0 0 7 1");

		//======== scrollPane1 ========
		{
			scrollPane1.setViewportView(table1);
		}
		contentPane.add(scrollPane1, "cell 0 1 7 1");

		//---- label2 ----
		label2.setText("Business Properties");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setLabelFor(table2);
		contentPane.add(label2, "cell 0 2 7 1");

		//======== scrollPane3 ========
		{
			scrollPane3.setViewportView(table2);
		}
		contentPane.add(scrollPane3, "cell 0 3 7 1");

		//---- button1 ----
		button1.setText("NEW HOUSE");
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				button1MouseClicked(e);
			}
		});
		contentPane.add(button1, "cell 0 4 7 1");

		//---- button2 ----
		button2.setText("NEW BUSINESS PROPERTY");
		button2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				button2MouseClicked(e);
			}
		});
		contentPane.add(button2, "cell 0 5 7 1");

		//---- button3 ----
		button3.setText("DELETE");
		button3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				button3MouseClicked(e);
			}
		});
		contentPane.add(button3, "cell 0 6 7 1");
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - MilenV
	private JScrollPane scrollPane2;
	private JLabel label1;
	private JScrollPane scrollPane1;
	private JTable table1;
	private JLabel label2;
	private JScrollPane scrollPane3;
	private JTable table2;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
