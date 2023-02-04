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
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateAccountDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JTextField profileNumberField;
	private JTextField accountNumberField;
	String[] accountTypes = {"chequing","saving"};
	JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		try {
	//			CreateAccountDialog dialog = new CreateAccountDialog();
	//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	//			dialog.setVisible(true);
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		}
	//	}

	/**
	 * Create the dialog.
	 */
	public CreateAccountDialog() {
		setTitle("Create Account");
		setBounds(700, 350, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][][][grow]", "[][][][][][]"));
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
			JLabel accountNumberLabel = new JLabel("Account Number");
			contentPanel.add(accountNumberLabel, "cell 1 3");
		}
		{
			accountNumberField = new JTextField();
			accountNumberField.setEnabled(false);
			contentPanel.add(accountNumberField, "cell 3 3,growx");
			accountNumberField.setColumns(10);
		}
		{
			JLabel accountTypeLabel = new JLabel("Account Type");
			contentPanel.add(accountTypeLabel, "cell 1 5");
		}
		{
			comboBox = new JComboBox(accountTypes);
			contentPanel.add(comboBox, "cell 3 5,growx");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String profileNumber = profileNumberField.getText();
						String accountNumber = Storage.generateAccountNumber(Storage.accountsList);
						String accountType = (String) comboBox.getSelectedItem();
						double interestRate = 0;
						if (accountType.equals("chequing")) {
							interestRate = 0;
						}
						else if (accountType.equals("saving")) {
							interestRate = 5.0;
						}
						double accountBalance = 0.0;
						Account newAccount = new Account(profileNumber, accountNumber, accountType, interestRate, accountBalance);
						Storage.accountsList.add(newAccount);
						Storage.accountsListModel.addElement(newAccount);
						JOptionPane.showMessageDialog(null, "Account created successfully.");
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
						int resp = JOptionPane.showConfirmDialog(CreateAccountDialog.this, "Are you sure you want to cancel?","Cancel", JOptionPane.YES_NO_OPTION);
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
