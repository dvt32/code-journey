/*
 * Created by JFormDesigner on Thu Feb 07 13:27:53 EET 2019
 */

package net.dvt32.gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.dvt32.jdbc.JdbcTemplate;

/**
 * @author dvt32
 */
public class WorksWithTableForm extends JFrame {
	
	private static final JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();
	
	public WorksWithTableForm() {
		initComponents();
		
		try {
			ResultSet worksWithRelationships = jdbcTemplate.selectAllFromTable("Works_With");

			Vector<String> tableColumnNames = new Vector<String>();
			tableColumnNames.add("buyer_id");
			tableColumnNames.add("agent_agentId");
			
			Vector<Object> tableData = new Vector<Object>();
			while (worksWithRelationships.next()) {
				Struct worksWithRelationship = (Struct) worksWithRelationships.getObject(1);
				Object[] attributeValues = worksWithRelationship.getAttributes();
				Vector<Object> rowData = new Vector<Object>();
				for (Object attributeValue : attributeValues) {
					if (attributeValue == null) {
						rowData.add(null);
					}
					else {
						Object refAttribute = ((Ref) attributeValue).getObject();
						if (refAttribute == null) {
							rowData.add(null);
						}
						else {
							Object[] refAttributeValues = ((Struct) refAttribute).getAttributes();
							rowData.add(refAttributeValues[0]);
						}
					}
				}
				tableData.add(rowData);
			}
			
			table1.setModel( new DefaultTableModel(tableData, tableColumnNames) {
				@Override
			    public boolean isCellEditable(int rowIndex, int columnIndex) {
					int buyerIdColumnIndex = 0;
					int agentIdColumnIndex = 1;
			        return (columnIndex == buyerIdColumnIndex || columnIndex == agentIdColumnIndex) ? false : true;
			    }
			});
		} 
		catch (SQLException e) {
			System.out.println( e.getMessage() );
		}
	}

	private void button1MouseClicked(MouseEvent e) {
		ResultSet buyersResultSet = jdbcTemplate.selectAllFromTable("Buyer");
		ResultSet agentsResultSet = jdbcTemplate.selectAllFromTable("Agent");
		
		List<Object> buyersList = new ArrayList<Object>();
		try {
			while (buyersResultSet.next()) {
				Struct buyer = (Struct) buyersResultSet.getObject(1);
				Object[] attributeValues = buyer.getAttributes();
				buyersList.add(attributeValues[0]);
			}
		}
		catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}
		
		List<Object> agentsList = new ArrayList<Object>();
		try {
			while (agentsResultSet.next()) {
				Struct agent = (Struct) agentsResultSet.getObject(1);
				Object[] attributeValues = agent.getAttributes();
				agentsList.add(attributeValues[0]);
			}
		}
		catch (SQLException e1) {
			System.out.println(e1.getMessage());
		}
		
		Object[] buyers_arr = buyersList.toArray();
		Object[] agents_arr = agentsList.toArray();
		
		Object buyer_id = JOptionPane.showInputDialog(
			null, 
			"Choose buyer ID", 
			"Choose buyer ID",
			JOptionPane.QUESTION_MESSAGE, 
			null,
			buyers_arr,
			null
		);
		
		Object agent_agentId = JOptionPane.showInputDialog(
			null, 
			"Choose agent ID", 
			"Choose agent ID",
			JOptionPane.QUESTION_MESSAGE, 
			null,
			agents_arr,
			null
		);
		
		if (buyer_id != null && agent_agentId != null) {
			DefaultTableModel model = (DefaultTableModel) table1.getModel(); 
			jdbcTemplate.insertIntoTable("Works_With", buyer_id, agent_agentId);
			model.addRow( new Object[] { buyer_id, agent_agentId } );
			System.out.println("[WorksWithTableForm] Successfully inserted new row in DB with buyer ID " + buyer_id + " and agent ID " + agent_agentId);
		}
		else {
			JOptionPane.showMessageDialog(this, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void button2MouseClicked(MouseEvent e) {
		if (table1.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(this, "Please select a row to delete!", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else {
			DefaultTableModel model = (DefaultTableModel) this.table1.getModel();
			int[] rowIndices = table1.getSelectedRows();
			
			for (int i = 0; i < rowIndices.length; ++i) {
				Object buyer_id = (model.getValueAt(rowIndices[i], 0) == null) ? null : model.getValueAt(rowIndices[i], 0);
				Object agent_agentId = (model.getValueAt(rowIndices[i], 1) == null) ? null : model.getValueAt(rowIndices[i], 1);
				jdbcTemplate.deleteByIdFromTable("Works_With", buyer_id, agent_agentId);
				System.out.println("[WorksWithTableForm] Successfully deleted row with buyer ID " + buyer_id + " and agent ID " + agent_agentId);
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
		setTitle("Works_With Table");
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridBagLayout());
		((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
		((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
		((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0, 1.0E-4};
		((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {1.0, 0.0, 0.0, 1.0E-4};

		//======== scrollPane1 ========
		{
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
