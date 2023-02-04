/*
 * author: Paul Kim
 * date: February 4, 2023
 * version: 1.0
 * This is a banking system prototype program
 */

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateNewProfileDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JTextField lastNameField;
	JTextField middleNameField;
	JTextField firstNameField;
	JTextField addressField;
	JTextField phoneNumberField;
	JTextField emailField;
	JTextField dateOfBirthField;

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		try {
	//			CreateNewProfileDialog dialog = new CreateNewProfileDialog();
	//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	//			dialog.setVisible(true);
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		}
	//	}

	/**
	 * Create the dialog.
	 */
	public CreateNewProfileDialog() {
		setTitle("Create New Profile");
		setBounds(700, 350, 650, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][][][grow][][][][grow][][][][grow]", "[][][][][][]"));
		{
			JLabel firstNameLabel = new JLabel("First Name");
			contentPanel.add(firstNameLabel, "cell 1 1");
		}
		{
			firstNameField = new JTextField();
			contentPanel.add(firstNameField, "cell 3 1,growx");
			firstNameField.setColumns(10);
		}
		{
			JLabel middleNameLabel = new JLabel("Middle Name");
			contentPanel.add(middleNameLabel, "cell 5 1");
		}
		{
			middleNameField = new JTextField();
			contentPanel.add(middleNameField, "cell 7 1,growx");
			middleNameField.setColumns(10);
		}
		{
			JLabel lastNameLabel = new JLabel("Last Name");
			contentPanel.add(lastNameLabel, "cell 9 1");
		}
		{
			lastNameField = new JTextField();
			contentPanel.add(lastNameField, "cell 11 1,growx");
			lastNameField.setColumns(10);
		}
		{
			JLabel addressLabel = new JLabel("Address");
			contentPanel.add(addressLabel, "cell 1 3");
		}
		{
			addressField = new JTextField();
			contentPanel.add(addressField, "cell 3 3,growx");
			addressField.setColumns(10);
		}
		{
			JLabel dateOfBirthLabel = new JLabel("Date of Birth");
			contentPanel.add(dateOfBirthLabel, "cell 5 3");
		}
		{
			dateOfBirthField = new JTextField();
			contentPanel.add(dateOfBirthField, "cell 7 3,growx");
			dateOfBirthField.setColumns(10);
		}
		{
			JLabel phoneNumberLabel = new JLabel("Phone Number");
			contentPanel.add(phoneNumberLabel, "cell 1 5");
		}
		{
			phoneNumberField = new JTextField();
			contentPanel.add(phoneNumberField, "cell 3 5,growx");
			phoneNumberField.setColumns(10);
		}
		{
			JLabel emailLabel = new JLabel("Email");
			contentPanel.add(emailLabel, "cell 5 5");
		}
		{
			emailField = new JTextField();
			contentPanel.add(emailField, "cell 7 5,growx");
			emailField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String profileNumber = Storage.generateProfileNumber(Storage.profilesList);
						String firstName = firstNameField.getText();
						String middleName = middleNameField.getText();
						String lastName = lastNameField.getText();
						String dateOfBirth = dateOfBirthField.getText();
						String address = addressField.getText();
						String phoneNumber = phoneNumberField.getText();
						String emailAddress = emailField.getText();
						Profile newProfile = new Profile(profileNumber,firstName,middleName,lastName,dateOfBirth,address,phoneNumber,emailAddress);
						Storage.profilesList.add(newProfile);
						Storage.profilesListModel.addElement(newProfile);
						JOptionPane.showMessageDialog(null, "Profile created successfully.");
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int resp =JOptionPane.showConfirmDialog(CreateNewProfileDialog.this, "Are you sure you want to cancel?", "Cancel", JOptionPane.YES_NO_OPTION);
						if (resp == JOptionPane.YES_OPTION) {
							dispose();
						}
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
