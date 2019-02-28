/*
 * Created by JFormDesigner on Wed Feb 13 13:23:08 EET 2019
 */

package net.dvt32.gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Struct;
import java.sql.Timestamp;
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
public class AgentTableForm extends JFrame {
	
	private static final JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();
	
	public AgentTableForm() {
		initComponents();
		
		try {
			ResultSet agents = jdbcTemplate.selectAllFromTable("Agent");
			
			Vector<String> tableColumnNames = new Vector<String>();
			tableColumnNames.add("agentId");
			tableColumnNames.add("name_firstName");
			tableColumnNames.add("name_lastName");
			tableColumnNames.add("phone");
			tableColumnNames.add("dateStarted");
			tableColumnNames.add("agency_id");
			
			Vector<Object> tableData = new Vector<Object>();
			while (agents.next()) {
				Struct agent = (Struct) agents.getObject(1);
				Object[] attributeValues = agent.getAttributes();
				Vector<Object> rowData = new Vector<Object>();
				
				for (Object attributeValue : attributeValues) {
					if (attributeValue instanceof Struct) {
						Object[] structAttributeValues = ((Struct) attributeValue).getAttributes();
						for (Object structAttributeValue : structAttributeValues) {
							rowData.add(structAttributeValue);
						}
					}
					else if (attributeValue instanceof Ref) {
						Object refAttribute = ((Ref) attributeValue).getObject();
						if (refAttribute == null) {
							rowData.add("");
						}
						else {
							Object[] refAttributeValues = ((Struct) refAttribute).getAttributes();
							rowData.add(refAttributeValues[0]);
						}
					}
					else if (attributeValue instanceof Timestamp) {
						attributeValue = String.valueOf(attributeValue).substring(0, 10); // hide time information
						rowData.add(attributeValue);
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
					
				    Object agentId = model.getValueAt(rowIndex, 0);
					Object name_firstName = model.getValueAt(rowIndex, 1);
					Object name_lastName = model.getValueAt(rowIndex, 2);
					Object phone = model.getValueAt(rowIndex, 3);
					Object dateStarted = model.getValueAt(rowIndex, 4);
					Object agency_id = model.getValueAt(rowIndex, 5);
					
					jdbcTemplate.updateByIdInTable(
						"Agent", 
						agentId, 
						name_firstName, 
						name_lastName, 
						phone,
						dateStarted,
						agency_id
					);
					
					System.out.println("[AgentTableForm] Successfully updated row with id " + agentId);
				}
			}
		});
	}

	private void button1MouseClicked(MouseEvent e) {
		DefaultTableModel model = (DefaultTableModel) this.table1.getModel();
		int numberOfRows = table1.getRowCount();
		BigDecimal agentId = null;
		
		if (numberOfRows == 0) {
			agentId = BigDecimal.ONE;
		}
		else {
			try {
				ResultSet maxIdResultSet = jdbcTemplate.getMaxIdFromTable("Agent");
				maxIdResultSet.next();
				BigDecimal maxId = maxIdResultSet.getBigDecimal(1);
				agentId = maxId.add(BigDecimal.ONE);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}		
		}
		
		java.util.Date currentDate = new java.util.Date();
		long currentTimeInMilliseconds = currentDate.getTime();
		java.sql.Date sqlDate = new java.sql.Date(currentTimeInMilliseconds);
		
		jdbcTemplate.insertIntoTable("Agent", agentId, sqlDate);
		
		model.addRow( new Object[] { agentId, "", "", "", sqlDate, "" } );
		
		System.out.println("[AgentTableForm] Successfully inserted new row in DB with id " + agentId);
	}

	private void button2MouseClicked(MouseEvent e) {
		if (table1.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(this, "Please select a row to delete!", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else {
			DefaultTableModel model = (DefaultTableModel) this.table1.getModel();
			int[] rowIndices = table1.getSelectedRows();
			
			for (int i = 0; i < rowIndices.length; ++i) {
				Object agentId = model.getValueAt(rowIndices[i], 0);
				jdbcTemplate.deleteByIdFromTable("Agent", agentId);
				System.out.println("[AgentTableForm] Successfully deleted row with id " + agentId);
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
		scrollPane2 = new JScrollPane();
		table2 = new JTable();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();

		//======== this ========
		setTitle("Agent Table");
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridBagLayout());
		((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
		((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
		((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {1.0, 1.0, 0.0, 1.0E-4};
		((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {1.0, 0.0, 0.0, 1.0E-4};

		//======== scrollPane1 ========
		{
			scrollPane1.setViewportView(table1);
		}
		contentPane.add(scrollPane1, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 0, 0), 0, 0));

		//======== scrollPane2 ========
		{
			scrollPane2.setViewportView(table2);
		}
		contentPane.add(scrollPane2, new GridBagConstraints(1, 0, 2, 1, 0.0, 0.0,
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

		//---- button3 ----
		button3.setText("DELETE");
		contentPane.add(button3, new GridBagConstraints(1, 2, 2, 1, 0.0, 0.0,
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
	private JScrollPane scrollPane2;
	private JTable table2;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
