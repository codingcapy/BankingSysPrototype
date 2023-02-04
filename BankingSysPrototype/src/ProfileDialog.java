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
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
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
	JList<Account> list;

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
		setTitle("Profile");
		createAccountDialog = new CreateAccountDialog();
		accountDialog = new AccountDialog();
		setBounds(600, 250, 1200, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][][][grow][-81.00][][-21.00][][][][-27.00][grow][]", "[][][][][][][][][][grow]"));
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
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, "cell 3 9,grow");
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
			contentPanel.add(selectAccountButton, "flowy,cell 5 9");
		}
		{
			JButton createAccountButton = new JButton("Create Account");
			createAccountButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					createAccountDialog.profileNumberField.setText(profileNumberField.getText());
					createAccountDialog.setVisible(true);
				}
			});
			contentPanel.add(createAccountButton, "cell 5 9");
		}
		{
			JButton deleteAccountButton = new JButton("Delete Account");
			deleteAccountButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (Account account : Storage.accountsList) {
						if (account.getAccountNumber().equals(list.getSelectedValue().getAccountNumber())) {
							Storage.accountsList.remove(account);
							break;
						}
					}
					Storage.accountsListModel.removeElement(list.getSelectedValue());
				}
			});
			contentPanel.add(deleteAccountButton, "cell 5 9");
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
