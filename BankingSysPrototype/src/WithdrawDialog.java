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

public class WithdrawDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JTextField accountNumberField;
	JTextField withdrawalField;

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		try {
	//			WithdrawDialog dialog = new WithdrawDialog();
	//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	//			dialog.setVisible(true);
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		}
	//	}

	/**
	 * Create the dialog.
	 */
	public WithdrawDialog() {
		setTitle("Withdraw");
		setBounds(700, 350, 450, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][][][grow]", "[][][][]"));
		{
			JLabel accountNumberLabel = new JLabel("Account Number");
			contentPanel.add(accountNumberLabel, "cell 1 1");
		}
		{
			accountNumberField = new JTextField();
			accountNumberField.setEnabled(false);
			contentPanel.add(accountNumberField, "cell 3 1,growx");
			accountNumberField.setColumns(10);
		}
		{
			JLabel withdrawalLabel = new JLabel("Withdrawal Amount");
			contentPanel.add(withdrawalLabel, "cell 1 3");
		}
		{
			withdrawalField = new JTextField();
			contentPanel.add(withdrawalField, "cell 3 3,growx");
			withdrawalField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(withdrawalField.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Please input an amount to deposit");
						}
						else {
							for(Account account : Storage.accountsList) {
								if (account.getAccountNumber().equals(accountNumberField.getText())) {
									double previousBalance = account.getAccountBalance();
									account.setAccountBalance(previousBalance - Double.parseDouble(withdrawalField.getText()));
								}
							}
							dispose();
						}
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
