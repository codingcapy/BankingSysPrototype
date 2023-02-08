/*
 * author: Paul Kim
 * date: February 4, 2023
 * version: 1.0
 * This is a banking system prototype program
 */

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProfileDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JTextField profileNumberField;
	JTextField firstNameField;
	JTextField middleNameField;
	JTextField lastNameField;
	JTextField addressField;
	JTextField phoneNumberField;
	JTextField emailAddressField;
	AccountDialog accountDialog;
	JButton saveButton;
	JTextField dateOfBirthField;
	CreateAccountDialog createAccountDialog;
	NotesDialog notesDialog;
	JList<Account> list;
	JList<String> notesList;
	static DefaultListModel<String> notesListModel = new DefaultListModel<String>();

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		try {
	//			ProfileDialog dialog = new ProfileDialog();
	//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	//			dialog.setVisible(true);
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		}
	//	}

	/**
	 * Create the dialog.
	 */
	public ProfileDialog() {
		notesDialog = new NotesDialog();
		setTitle("Profile");
		createAccountDialog = new CreateAccountDialog();
		accountDialog = new AccountDialog();
		setBounds(600, 250, 1000, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][85px:85px][][185px:185px,grow][][75px:75px][][185px:185px][][75px:75px][][150px:150px][][][][-81.00][-21.00][-27.00]", "[][][][][][][][][][grow][][grow][]"));
		{
			JLabel profileNumberLabel = new JLabel("Profile Number");
			contentPanel.add(profileNumberLabel, "cell 1 1");
		}
		{
			profileNumberField = new JTextField();
			profileNumberField.setEnabled(false);
			contentPanel.add(profileNumberField, "cell 3 1,growx");
			profileNumberField.setColumns(10);
		}
		{
			JLabel firstNameLabel = new JLabel("First Name");
			contentPanel.add(firstNameLabel, "cell 1 3");
		}
		{
			firstNameField = new JTextField();
			firstNameField.setEnabled(false);
			contentPanel.add(firstNameField, "cell 3 3,growx");
			firstNameField.setColumns(10);
		}
		{
			JLabel middleNameLabel = new JLabel("Middle Name");
			contentPanel.add(middleNameLabel, "cell 5 3");
		}
		{
			middleNameField = new JTextField();
			middleNameField.setEnabled(false);
			contentPanel.add(middleNameField, "cell 7 3,growx");
			middleNameField.setColumns(10);
		}
		{
			JLabel lastNameLabel = new JLabel("Last Name");
			contentPanel.add(lastNameLabel, "cell 9 3");
		}
		{
			lastNameField = new JTextField();
			lastNameField.setEnabled(false);
			contentPanel.add(lastNameField, "cell 11 3,growx");
			lastNameField.setColumns(10);
		}
		{
			JLabel addressLabel = new JLabel("Address");
			contentPanel.add(addressLabel, "cell 1 5");
		}
		{
			addressField = new JTextField();
			addressField.setEnabled(false);
			contentPanel.add(addressField, "cell 3 5,growx");
			addressField.setColumns(10);
		}
		{
			JLabel dateOfBirthLabel = new JLabel("Date of Birth");
			contentPanel.add(dateOfBirthLabel, "cell 5 5");
		}
		{
			dateOfBirthField = new JTextField();
			dateOfBirthField.setText("YYYY-MM-DD");
			dateOfBirthField.setEnabled(false);
			contentPanel.add(dateOfBirthField, "cell 7 5,growx");
			dateOfBirthField.setColumns(10);
		}
		{
			JLabel phoneNumberLabel = new JLabel("Phone Number");
			contentPanel.add(phoneNumberLabel, "cell 1 7");
		}
		{
			phoneNumberField = new JTextField();
			phoneNumberField.setText("###-###-####");
			phoneNumberField.setEnabled(false);
			contentPanel.add(phoneNumberField, "cell 3 7,growx");
			phoneNumberField.setColumns(10);
		}
		{
			JLabel emailAddressLabel = new JLabel("Email Address");
			contentPanel.add(emailAddressLabel, "cell 5 7");
		}
		{
			emailAddressField = new JTextField();
			emailAddressField.setEnabled(false);
			contentPanel.add(emailAddressField, "cell 7 7,growx");
			emailAddressField.setColumns(10);
		}
		{
			JLabel accountsLabel = new JLabel("Accounts");
			contentPanel.add(accountsLabel, "cell 1 9");
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, "cell 3 9 9 1,grow");
			{
				list = new JList<Account>(Storage.accountsListModel);
				scrollPane.setViewportView(list);
			}
		}
		{
			JButton selectAccountButton = new JButton("Select Account");
			selectAccountButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					accountDialog.profileNumberField.setText(profileNumberField.getText());
					accountDialog.accountNumberField.setText(list.getSelectedValue().getAccountNumber());
					accountDialog.interestRateField.setText(Double.toString(list.getSelectedValue().getInterestRate()));
					accountDialog.balanceField.setText(Double.toString(list.getSelectedValue().getAccountBalance()));
					accountDialog.setVisible(true);
				}
			});
			contentPanel.add(selectAccountButton, "flowy,cell 13 9");
		}
		{
			JButton createAccountButton = new JButton("Create Account");
			createAccountButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					createAccountDialog.profileNumberField.setText(profileNumberField.getText());
					createAccountDialog.setVisible(true);
				}
			});
			contentPanel.add(createAccountButton, "cell 13 9");
		}
		{
			JButton deleteAccountButton = new JButton("Delete Account");
			deleteAccountButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int resp = JOptionPane.showConfirmDialog(ProfileDialog.this, "Are you sure you want to delete?", "Delete Account", JOptionPane.YES_NO_OPTION);
					if (resp == JOptionPane.YES_OPTION) {
						for (Account account : Storage.accountsList) {
							if (account.getAccountNumber().equals(list.getSelectedValue().getAccountNumber())) {
								Storage.accountsList.remove(account);
								break;
							}
						}
						Storage.accountsListModel.removeElement(list.getSelectedValue());
						JOptionPane.showMessageDialog(null, "All funds have been withdrawn in cash and provided to customer");
					}
				}
			});
			contentPanel.add(deleteAccountButton, "cell 13 9");
		}
		{
			JLabel notesLabel = new JLabel("Notes");
			contentPanel.add(notesLabel, "cell 1 11");
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, "cell 3 11 9 1,grow");
			{
				notesList = new JList<String>(notesListModel);
				scrollPane.setViewportView(notesList);
			}
		}
		{
			JButton addNotesButton = new JButton("Add Notes");
			addNotesButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					notesDialog.notesField.setText("");
					notesDialog.setVisible(true);
				}
			});
			contentPanel.add(addNotesButton, "cell 13 11");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				saveButton = new JButton("Save");
				saveButton.setVisible(false);
				saveButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int index = 0;
						String firstName = firstNameField.getText();
						String middleName = middleNameField.getText();
						String lastName = lastNameField.getText();
						String dateOfBirth = dateOfBirthField.getText();
						String address = addressField.getText();
						String phoneNumber = phoneNumberField.getText();
						String emailAddress = emailAddressField.getText();

						for (Profile profile : Storage.profilesList) {
							if (profile.getProfileNumber().equals(profileNumberField.getText())) {
								profile.setFirstName(firstName);
								profile.setMiddleName(middleName);
								profile.setLastName(lastName);
								profile.setDateOfBirth(dateOfBirth);
								profile.setAddress(address);
								profile.setPhoneNumber(phoneNumber);
								profile.setEmailAddress(emailAddress);
								index = Storage.profilesList.indexOf(profile);
								System.out.println(profile);
							}
						}
						Storage.profilesListModel.get(index).setFirstName(firstName);
						Storage.profilesListModel.get(index).setMiddleName(middleName);
						Storage.profilesListModel.get(index).setLastName(lastName);
						Storage.profilesListModel.get(index).setDateOfBirth(dateOfBirth);
						Storage.profilesListModel.get(index).setAddress(address);
						Storage.profilesListModel.get(index).setPhoneNumber(phoneNumber);
						Storage.profilesListModel.get(index).setEmailAddress(emailAddress);
						firstNameField.setEnabled(false);
						middleNameField.setEnabled(false);
						lastNameField.setEnabled(false);
						dateOfBirthField.setEnabled(false);
						addressField.setEnabled(false);
						phoneNumberField.setEnabled(false);
						emailAddressField.setEnabled(false);
						saveButton.setVisible(false);
					}
				});
				buttonPane.add(saveButton);
			}
			{
				JButton editProfileButton = new JButton("Edit Profile");
				editProfileButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						firstNameField.setEnabled(true);
						middleNameField.setEnabled(true);
						lastNameField.setEnabled(true);
						dateOfBirthField.setEnabled(true);
						addressField.setEnabled(true);
						phoneNumberField.setEnabled(true);
						emailAddressField.setEnabled(true);
						saveButton.setVisible(true);
					}
				});
				buttonPane.add(editProfileButton);
			}
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
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
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
