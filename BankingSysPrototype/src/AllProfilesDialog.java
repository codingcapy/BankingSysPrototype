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
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AllProfilesDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	static JList<Profile> list;
	private ProfileDialog profileDialog;

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		try {
	//			AllProfilesDialog dialog = new AllProfilesDialog();
	//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	//			dialog.setVisible(true);
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		}
	//	}

	/**
	 * Create the dialog.
	 */
	public AllProfilesDialog() {
		profileDialog = new ProfileDialog();
		setTitle("All Profiles");
		setBounds(700, 350, 650, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][grow]", "[][grow]"));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, "cell 1 1,grow");
			{
				list = new JList<Profile>(Storage.profilesListModel);
				list.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Storage.accountsListModel.removeAllElements();
						profileDialog.profileNumberField.setText(list.getSelectedValue().getProfileNumber());
						profileDialog.firstNameField.setText(list.getSelectedValue().getFirstName());
						profileDialog.middleNameField.setText(list.getSelectedValue().getMiddleName());
						profileDialog.lastNameField.setText(list.getSelectedValue().getLastName());
						profileDialog.dateOfBirthField.setText(list.getSelectedValue().getDateOfBirth());
						profileDialog.addressField.setText(list.getSelectedValue().getAddress());
						profileDialog.phoneNumberField.setText(list.getSelectedValue().getPhoneNumber());
						profileDialog.emailAddressField.setText(list.getSelectedValue().getEmailAddress());
						for (Account account : Storage.accountsList) {
							if (profileDialog.profileNumberField.getText().equals(account.getProfileNumber())) {
								Storage.accountsListModel.addElement(account);
							}
						}
						profileDialog.setVisible(true);
					}
				});
				scrollPane.setViewportView(list);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
