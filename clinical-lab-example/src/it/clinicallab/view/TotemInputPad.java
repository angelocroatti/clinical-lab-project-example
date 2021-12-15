package it.clinicallab.view;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import it.clinicallab.controller.Hub;

@SuppressWarnings("serial")
public class TotemInputPad extends JFrame {
	
	private final Hub hub;
	
	private JLabel boxIdLabel, destinationPathLabel;
	private JTextField boxIdTextField;
	private JCheckBox refrigeratedCheckBox;
	private JComboBox<String> destinationPathsComboBox;
	private JButton confirmButton;
	
	public TotemInputPad(final Hub hub) {
		this.hub = hub;
		
		setTitle("ClinicalLab - InputPad");
		initUI();
		
		pack();
	}
	
	private void initUI() {
		setResizable(false);
		
		final JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		mainPanel.add(createBoxIdGroup());
		mainPanel.add(createDestinationsGroup());
	    
		confirmButton = new JButton("Confirm Box Delivery");
		confirmButton.addActionListener(this::confirmButtonHandler);
		
		mainPanel.add(confirmButton);
		
		getContentPane().add(mainPanel);
	}
	
	private JPanel createBoxIdGroup() {
		boxIdLabel = new JLabel("Box Id: ");
		boxIdTextField = new JTextField();
		refrigeratedCheckBox = new JCheckBox("Refrigerated");
		
		final JPanel boxIdPanel = new JPanel();
		boxIdPanel.setBorder(new EmptyBorder(0, 0, 10, 0));
		final GroupLayout boxIdPanelLayout = new GroupLayout(boxIdPanel);
		boxIdPanel.setLayout(boxIdPanelLayout);
		
		boxIdPanelLayout.setHorizontalGroup(  
				boxIdPanelLayout.createSequentialGroup()  
                             .addComponent(boxIdLabel)   
                             .addComponent(boxIdTextField)
                             .addComponent(refrigeratedCheckBox));
		
		boxIdPanelLayout.setVerticalGroup(  
				boxIdPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)  
                            .addComponent(boxIdLabel)  
                            .addComponent(boxIdTextField)
                            .addComponent(refrigeratedCheckBox));
		
		return boxIdPanel;
	}

	private JPanel createDestinationsGroup() {
		destinationPathLabel = new JLabel("Destination Path: ");
	    destinationPathsComboBox = new JComboBox<String>(hub.getRoutesMap().routesArray());    
	    
	    final JPanel destinationPanel = new JPanel();
	    destinationPanel.setBorder(new EmptyBorder(0, 0, 10, 0));
		final GroupLayout destinationPanelLayout = new GroupLayout(destinationPanel);
		destinationPanel.setLayout(destinationPanelLayout);
		
		destinationPanelLayout.setHorizontalGroup(  
				destinationPanelLayout.createSequentialGroup()  
                             .addComponent(destinationPathLabel)   
                             .addComponent(destinationPathsComboBox));
		
		destinationPanelLayout.setVerticalGroup(  
				destinationPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)  
                            .addComponent(destinationPathLabel)  
                            .addComponent(destinationPathsComboBox));
		
		return destinationPanel;
	}
	
	private void confirmButtonHandler(final ActionEvent event) {
		
		String boxId = boxIdTextField.getText();
		boolean refrigerated = refrigeratedCheckBox.isSelected();
		String destination = destinationPathsComboBox.getSelectedItem().toString();
		
		boolean res = hub.addBoxDelivery(boxId, refrigerated, destination);
		
		if(res) {
			JOptionPane.showMessageDialog(this, "Box Added!");
			
			boxIdTextField.setText("");
			refrigeratedCheckBox.setSelected(false);
			
		} else {
			JOptionPane.showMessageDialog(this, "An Error Occurred...");
		}
	}
}
