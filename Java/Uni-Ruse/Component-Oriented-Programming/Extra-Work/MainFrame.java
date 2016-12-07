import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class LoadDialog extends JDialog {
	
	JFileChooser fileChooser;
	FileNameExtensionFilter textFileFilter;
	SpringLayout dialogLayout;
	JLabel studentNameLabel, facultyNumberLabel, genderLabel, gradeOneLabel, gradeTwoLabel, gradeThreeLabel;
	JLabel studentNameValueLabel, facultyNumberValueLabel, genderValueLabel, gradeOneValueLabel, gradeTwoValueLabel, gradeThreeValueLabel;
	String[] fileContents;
	String studentNameValue, facultyNumberValue, genderValue, gradeOneValue, gradeTwoValue, gradeThreeValue;
	
	// Default constructor
	public LoadDialog(JFrame parent) {
		super(parent, "Load File", true);
		
		// Choose input text file from system & store its contents in a String array
		fileChooser = new JFileChooser();
		textFileFilter = new FileNameExtensionFilter(".TXT", "txt", "text");
		fileChooser.setFileFilter(textFileFilter);
		int userSelection = fileChooser.showOpenDialog(this);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			String inputPath = fileChooser.getSelectedFile().getAbsolutePath();
			fileContents = loadFromFile(inputPath);
			studentNameValue = fileContents[0];
			facultyNumberValue = fileContents[1];
			genderValue = fileContents[2];
			gradeOneValue = fileContents[3];
			gradeTwoValue = fileContents[4];
			gradeThreeValue = fileContents[5];
		}
		else {
			return;
		}
		
		// Set dialog layout
		dialogLayout = new SpringLayout();
		setLayout(dialogLayout);
		setBounds(200, 100, 250, 260);
				
		// Add all left side labels
		studentNameLabel = new JLabel("Student Name: ");
		setComponentPosition(studentNameLabel, dialogLayout, 5, 5, this);
		add(studentNameLabel);
		facultyNumberLabel = new JLabel("Faculty \u2116: ");
		setComponentPosition(facultyNumberLabel, dialogLayout, 5, 30, this);
		add(facultyNumberLabel);
		genderLabel = new JLabel("Gender: ");
		setComponentPosition(genderLabel, dialogLayout, 5, 55, this);
		this.add(genderLabel);
		gradeOneLabel = new JLabel("Grade 1: ");
		setComponentPosition(gradeOneLabel, dialogLayout, 5, 83, this);
		add(gradeOneLabel);
		gradeTwoLabel = new JLabel("Grade 2: ");
		setComponentPosition(gradeTwoLabel, dialogLayout, 5, 108, this);
		add(gradeTwoLabel);
		gradeThreeLabel = new JLabel("Grade 3: ");
		setComponentPosition(gradeThreeLabel, dialogLayout, 5, 133, this);
		add(gradeThreeLabel);
		
		/*
		 *  Add all right side labels (values from file)
		 */
		studentNameValueLabel = new JLabel(studentNameValue);
		studentNameValueLabel.setForeground(Color.RED);
		setComponentPosition(studentNameValueLabel, dialogLayout, 5, 5, studentNameLabel, this);
		add(studentNameValueLabel);
		
		facultyNumberValueLabel = new JLabel(facultyNumberValue);
		facultyNumberValueLabel.setForeground(Color.RED);
		setComponentPosition(facultyNumberValueLabel, dialogLayout, 5, 30, facultyNumberLabel, this);
		add(facultyNumberValueLabel);
		
		genderValueLabel = new JLabel(genderValue);
		genderValueLabel.setForeground(Color.RED);
		setComponentPosition(genderValueLabel, dialogLayout, 5, 55, genderLabel, this);
		add(genderValueLabel);
		
		gradeOneValueLabel = new JLabel(gradeOneValue);
		gradeOneValueLabel.setForeground(Color.RED);
		setComponentPosition(gradeOneValueLabel, dialogLayout, 5, 83, gradeOneLabel, this);
		add(gradeOneValueLabel);
		
		gradeTwoValueLabel = new JLabel(gradeTwoValue);
		gradeTwoValueLabel.setForeground(Color.RED);
		setComponentPosition(gradeTwoValueLabel, dialogLayout, 5, 108, gradeTwoLabel, this);
		add(gradeTwoValueLabel);
		
		gradeThreeValueLabel = new JLabel(gradeThreeValue);
		gradeThreeValueLabel.setForeground(Color.RED);
		setComponentPosition(gradeThreeValueLabel, dialogLayout, 5, 133, gradeThreeLabel, this);
		add(gradeThreeValueLabel);
		
		// Make dialog visible
		setVisible(true);
	}
	
	// Class methods
	public static void setComponentPosition(Component targetComponent, SpringLayout dialogLayout, int westEdgeDistance, int northEdgeDistance, Component linkComponent) {
		dialogLayout.putConstraint(SpringLayout.WEST, targetComponent, westEdgeDistance, SpringLayout.WEST, linkComponent);
		dialogLayout.putConstraint(SpringLayout.NORTH, targetComponent, northEdgeDistance, SpringLayout.NORTH, linkComponent);
	}
	public static void setComponentPosition(Component targetComponent, SpringLayout dialogLayout, int westEdgeDistance, int northEdgeDistance, Component eastLinkComponent, Component northLinkComponent) {
		dialogLayout.putConstraint(SpringLayout.WEST, targetComponent, westEdgeDistance, SpringLayout.EAST, eastLinkComponent);
		dialogLayout.putConstraint(SpringLayout.NORTH, targetComponent, northEdgeDistance, SpringLayout.NORTH, northLinkComponent);
	}
	public static String[] loadFromFile(String inputPath) {
		/*
		 * Expected file contents:
		 *  Line 1: <Student Name - string, may contain spaces>
		 *  Line 2: <Faculty Number - 6 digit integer>
		 *  Line 3: <Gender string - "Male" or "Female">
		 *  Line 4: <Grade 1 - integer in range [2, 6]>
		 *  Line 5: <Grade 2 - integer in range [2, 6]>
		 *  Line 6: <Grade 3 - integer in range [2, 6]>
		 */
		String[] fileContents = new String[7];
		BufferedReader bufferedReader;
		FileReader fileReader;
		String lineInFile = "";
		
		// Try to open input file
		try {
			fileReader = new FileReader(inputPath);
			bufferedReader = new BufferedReader(fileReader);
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
			return fileContents;
		}
		
		// Read file line by line
		try {
			int i = 0;
			while ((lineInFile = bufferedReader.readLine()) != null) {
				fileContents[i] = lineInFile;
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
		// Close streams
		try {
			fileReader.close();
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return fileContents;
	}
}

class SaveDialog extends JDialog implements ActionListener, DocumentListener {
	
	SpringLayout dialogLayout;
	JLabel studentNameLabel, facultyNumberLabel, genderLabel, gradeOneLabel, gradeTwoLabel, gradeThreeLabel;
	JTextField studentNameTextField, facultyNumberTextField;
	JRadioButton genderMaleRadioButton, genderFemaleRadioButton;
	ButtonGroup genderButtonGroup;
	Integer[] possibleGrades;
	JComboBox<Integer> gradeOneComboBox, gradeTwoComboBox, gradeThreeComboBox;
	JButton saveButton, exitButton;
	String studentNameValue, facultyNumberValue, genderValue, gradeOneValue, gradeTwoValue, gradeThreeValue;
	
	// Default constructor
	public SaveDialog(JFrame parent) {
		super(parent, "Save File", true);
		
		// Set dialog layout
		dialogLayout = new SpringLayout();
		setLayout(dialogLayout);
		setBounds(200, 100, 250, 250);
		
		// Initialize default values
		possibleGrades = new Integer[] { 2, 3, 4, 5, 6 };
		studentNameValue = "";
		facultyNumberValue = "";
		genderValue = "Male";
		gradeOneValue = "2";
		gradeTwoValue = "2";
		gradeThreeValue = "2";
		
		// Add all labels
		studentNameLabel = new JLabel("Student Name: ");
		setComponentPosition(studentNameLabel, dialogLayout, 5, 5, this);
		add(studentNameLabel);
		facultyNumberLabel = new JLabel("Faculty \u2116: ");
		setComponentPosition(facultyNumberLabel, dialogLayout, 5, 30, this);
		add(facultyNumberLabel);
		genderLabel = new JLabel("Gender: ");
		setComponentPosition(genderLabel, dialogLayout, 5, 55, this);
		add(genderLabel);
		gradeOneLabel = new JLabel("Grade 1: ");
		setComponentPosition(gradeOneLabel, dialogLayout, 5, 83, this);
		add(gradeOneLabel);
		gradeTwoLabel = new JLabel("Grade 2: ");
		setComponentPosition(gradeTwoLabel, dialogLayout, 5, 108, this);
		add(gradeTwoLabel);
		gradeThreeLabel = new JLabel("Grade 3: ");
		setComponentPosition(gradeThreeLabel, dialogLayout, 5, 133, this);
		add(gradeThreeLabel);
		
		/*
		 *  Add all text fields
		 */
		studentNameTextField = new JTextField(10);
		studentNameTextField.getDocument().addDocumentListener(this);
		studentNameTextField.getDocument().putProperty("owner", studentNameTextField);
		setComponentPosition(studentNameTextField, dialogLayout, 5, 5, studentNameLabel, this);
		add(studentNameTextField);
		
		facultyNumberTextField = new JTextField(5);
		facultyNumberTextField.getDocument().addDocumentListener(this);
		facultyNumberTextField.getDocument().putProperty("owner", facultyNumberTextField);
		setComponentPosition(facultyNumberTextField, dialogLayout, 5, 30, facultyNumberLabel, this);
		add(facultyNumberTextField);
		
		/*
		 * Add all radio buttons
		 */
		genderMaleRadioButton = new JRadioButton("Male");
		genderMaleRadioButton.addActionListener(this);
		setComponentPosition(genderMaleRadioButton, dialogLayout, 5, 53, genderLabel, this);
		add(genderMaleRadioButton);
		
		genderFemaleRadioButton = new JRadioButton("Female");
		genderFemaleRadioButton.addActionListener(this);
		setComponentPosition(genderFemaleRadioButton, dialogLayout, 5, 53, genderMaleRadioButton, this);
		add(genderFemaleRadioButton);
		
		genderButtonGroup = new ButtonGroup();
		genderButtonGroup.add(genderMaleRadioButton);
		genderButtonGroup.add(genderFemaleRadioButton);
		genderMaleRadioButton.setSelected(true);
		
		/*
		 * Add all combo boxes
		 */
		gradeOneComboBox = new JComboBox<Integer>(possibleGrades);
		gradeOneComboBox.addActionListener(this);
		setComponentPosition(gradeOneComboBox, dialogLayout, 5, 80, gradeOneLabel, this);
		add(gradeOneComboBox);
		
		gradeTwoComboBox = new JComboBox<Integer>(possibleGrades);
		gradeTwoComboBox.addActionListener(this);
		setComponentPosition(gradeTwoComboBox, dialogLayout, 5, 105, gradeTwoLabel, this);
		add(gradeTwoComboBox);
		
		gradeThreeComboBox = new JComboBox<Integer>(possibleGrades);
		gradeThreeComboBox.addActionListener(this);
		setComponentPosition(gradeThreeComboBox, dialogLayout, 5, 130, gradeThreeLabel, this);
		add(gradeThreeComboBox);
		
		/*
		 * Add Save & Exit buttons
		 */
		saveButton = new JButton("Save");
		saveButton.addActionListener(this);
		setComponentPosition(saveButton, dialogLayout, 60, 170, this);
		add(saveButton);
		
		exitButton = new JButton("Exit");
		exitButton.addActionListener(this);
		setComponentPosition(exitButton, dialogLayout, 70, 0, saveButton);
		add(exitButton);
		
		// Make dialog visible
		setVisible(true);
	}
	
	// Class methods
	public static void setComponentPosition(Component targetComponent, SpringLayout dialogLayout, int westEdgeDistance, int northEdgeDistance, Component linkComponent) {
		dialogLayout.putConstraint(SpringLayout.WEST, targetComponent, westEdgeDistance, SpringLayout.WEST, linkComponent);
		dialogLayout.putConstraint(SpringLayout.NORTH, targetComponent, northEdgeDistance, SpringLayout.NORTH, linkComponent);
	}
	public static void setComponentPosition(Component targetComponent, SpringLayout dialogLayout, int westEdgeDistance, int northEdgeDistance, Component eastLinkComponent, Component northLinkComponent) {
		dialogLayout.putConstraint(SpringLayout.WEST, targetComponent, westEdgeDistance, SpringLayout.EAST, eastLinkComponent);
		dialogLayout.putConstraint(SpringLayout.NORTH, targetComponent, northEdgeDistance, SpringLayout.NORTH, northLinkComponent);
	}
	public void closeDialog() {
		setVisible(false);
		dispose();
	}
	public void saveToFile(String outputPath, String[] fileContents) {
		BufferedWriter bufferedWriter = null;
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(outputPath);
			bufferedWriter = new BufferedWriter(fileWriter);
			for (String line : fileContents) {
				bufferedWriter.write(line);
				bufferedWriter.newLine();
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if (bufferedWriter != null)
					bufferedWriter.close();
				if (fileWriter != null) {
					fileWriter.close();
				}	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// Overridden listener methods
	@Override
	public void actionPerformed(ActionEvent e) {
		Object eventPerformer = e.getSource();
		
		// Handle radio buttons events
		if (eventPerformer == genderMaleRadioButton) {
			genderValue = ((JRadioButton) eventPerformer).getText();
		}
		else if (eventPerformer == genderFemaleRadioButton) {
			genderValue = ((JRadioButton) eventPerformer).getText();
		}
		// Handle combo box events
		else if (eventPerformer == gradeOneComboBox) {
			gradeOneValue = ((JComboBox) eventPerformer).getSelectedItem().toString();
		}
		else if (eventPerformer == gradeTwoComboBox) {
			gradeTwoValue = ((JComboBox) eventPerformer).getSelectedItem().toString();
		}
		else if (eventPerformer == gradeThreeComboBox) {
			gradeThreeValue = ((JComboBox) eventPerformer).getSelectedItem().toString();
		}
		// Handle button events
		else if (eventPerformer == saveButton) {
			String[] fileContents = new String[] { studentNameValue, facultyNumberValue, genderValue, gradeOneValue, gradeTwoValue, gradeThreeValue };
			JFileChooser fileChooser = new JFileChooser();  
			int userSelection = fileChooser.showSaveDialog(this);
			if (userSelection == JFileChooser.APPROVE_OPTION) {
			    String outputPath = fileChooser.getSelectedFile().getAbsolutePath();
			    saveToFile(outputPath, fileContents);
			    closeDialog();
			}
		}
		else if (eventPerformer == exitButton) {
			closeDialog();
		}
	}
	@Override
	public void changedUpdate(DocumentEvent e) {
		Object eventPerformer = e.getDocument().getProperty("owner");
		if (eventPerformer == studentNameTextField) {
			studentNameValue = ((JTextField) eventPerformer).getText();
		}
		else if (eventPerformer == facultyNumberTextField) {
			facultyNumberValue = ((JTextField) eventPerformer).getText();
		}
	}
	@Override
	public void insertUpdate(DocumentEvent e) {
		Object eventPerformer = e.getDocument().getProperty("owner");
		if (eventPerformer == studentNameTextField) {
			studentNameValue = ((JTextField) eventPerformer).getText();
		}
		else if (eventPerformer == facultyNumberTextField) {
			facultyNumberValue = ((JTextField) eventPerformer).getText();
		}
	}
	@Override
	public void removeUpdate(DocumentEvent e) {
		Object eventPerformer = e.getDocument().getProperty("owner");
		if (eventPerformer == studentNameTextField) {
			studentNameValue = ((JTextField) eventPerformer).getText();
		}
		else if (eventPerformer == facultyNumberTextField) {
			facultyNumberValue = ((JTextField) eventPerformer).getText();
		}
	}
}	

public class MainFrame extends JFrame implements ActionListener {

	JButton loadFileButton, saveFileButton;
	
	// Default constructor
	public MainFrame() {
		setTitle("COP Extra Work - dvt32, 146518, Computer Science");
		setSize(320, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		loadFileButton = new JButton("Load File");
		loadFileButton.addActionListener(this);
		saveFileButton = new JButton("Save File");
		saveFileButton.addActionListener(this);
		
		Container mainContainer = getContentPane();
		mainContainer.setLayout(new FlowLayout());
		mainContainer.add(loadFileButton);
		mainContainer.add(saveFileButton);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String buttonText = e.getActionCommand();
		if (buttonText.equals("Load File")) {
			LoadDialog loadFileDialog = new LoadDialog(this);
		}
		else if (buttonText.equals("Save File")) {
			SaveDialog saveFileDialog = new SaveDialog(this);
		}
	}
	
}
