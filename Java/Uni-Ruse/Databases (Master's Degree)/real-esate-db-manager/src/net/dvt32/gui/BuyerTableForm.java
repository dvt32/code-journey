/*
 * Created by JFormDesigner on Wed Feb 13 14:59:01 EET 2019
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
public class BuyerTableForm extends JFrame {
	
	private static final JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();
	
	public BuyerTableForm() {
		initComponents();
		
		try {
			ResultSet buyers = jdbcTemplate.selectAllFromTable("Buyer");
			
			Vector<String> tableColumnNames = new Vector<String>();
			tableColumnNames.add("id");
			tableColumnNames.add("name_firstName");
			tableColumnNames.add("name_lastName");
			tableColumnNames.add("phone");
			tableColumnNames.add("propertyType");
			tableColumnNames.add("numberOfDesiredRooms");
			tableColumnNames.add("businessPropertyType");
			tableColumnNames.add("minimumDesiredPriceInLeva");
			tableColumnNames.add("maximumDesiredPriceInLeva");
			
			Vector<Object> tableData = new Vector<Object>();
			while (buyers.next()) {
				Struct buyer = (Struct) buyers.getObject(1);
				Object[] attributeValues = buyer.getAttributes();
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
		
		table1.getModel().addTableModelListener(new TableModelListener() {
			public void tableChanged(TableModelEvent e) {
				if (e.getType() == TableModelEvent.UPDATE) {
				    DefaultTableModel model = (DefaultTableModel) table1.getModel();    
				    int rowIndex = table1.getSelectedRow();
					
				    Object id = model.getValueAt(rowIndex, 0);
					Object name_firstName = model.getValueAt(rowIndex, 1);
					Object name_lastName = model.getValueAt(rowIndex, 2);
					Object phone = model.getValueAt(rowIndex, 3);
					Object propertyType = model.getValueAt(rowIndex, 4);
					Object numberOfDesiredRooms = model.getValueAt(rowIndex, 5);
					Object businessPropertyType = model.getValueAt(rowIndex, 6);
					Object minimumDesiredPriceInLeva = model.getValueAt(rowIndex, 7);
					Object maximumDesiredPriceInLeva = model.getValueAt(rowIndex, 8);
					
					jdbcTemplate.updateByIdInTable(
						"Buyer", 
						id, 
						name_firstName, 
						name_lastName, 
						phone, 
						propertyType, 
						numberOfDesiredRooms, 
						businessPropertyType,
						minimumDesiredPriceInLeva,
						maximumDesiredPriceInLeva
					);
					
					System.out.println("[BuyerTableForm] Successfully updated row with id " + id);
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
				ResultSet maxIdResultSet = jdbcTemplate.getMaxIdFromTable("Buyer");
				maxIdResultSet.next();
				BigDecimal maxId = maxIdResultSet.getBigDecimal(1);
				id = maxId.add(BigDecimal.ONE);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}		
		}
		
		jdbcTemplate.insertIntoTable("Buyer", id);

		model.addRow( new Object[] { id } );
		
		System.out.println("[BuyerTableForm] Successfully inserted new row in DB with id " + id);
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
				jdbcTemplate.deleteByIdFromTable("Buyer", id);
				System.out.println("[BuyerTableForm] Successfully deleted row with id " + id);
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
		setTitle("Buyer Table");
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridBagLayout());
		((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 0, 0};
		((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
		((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0E-4};
		((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {1.0, 0.0, 0.0, 1.0E-4};

		//======== scrollPane1 ========
		{
			scrollPane1.setViewportView(table1);
		}
		contentPane.add(scrollPane1, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
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
		contentPane.add(button1, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0,
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
		contentPane.add(button2, new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0,
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
