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

public class TransferDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JTextField fromAccountField;
	JTextField toAccountField;
	JTextField amountField;

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		try {
	//			TransferDialog dialog = new TransferDialog();
	//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	//			dialog.setVisible(true);
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		}
	//	}

	/**
	 * Create the dialog.
	 */
	public TransferDialog() {
		setTitle("Transfer");
		setBounds(700, 350, 450, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][][][grow]", "[][][][][][][]"));
		{
			JLabel fromAccountLabel = new JLabel("From Account");
			contentPanel.add(fromAccountLabel, "cell 1 2");
		}
		{
			fromAccountField = new JTextField();
			fromAccountField.setEnabled(false);
			contentPanel.add(fromAccountField, "cell 3 2,growx");
			fromAccountField.setColumns(10);
		}
		{
			JLabel toAccountLabel = new JLabel("To Account");
			contentPanel.add(toAccountLabel, "cell 1 4");
		}
		{
			toAccountField = new JTextField();
			contentPanel.add(toAccountField, "cell 3 4,growx");
			toAccountField.setColumns(10);
		}
		{
			JLabel amountLabel = new JLabel("Amount");
			contentPanel.add(amountLabel, "cell 1 6");
		}
		{
			amountField = new JTextField();
			contentPanel.add(amountField, "cell 3 6,growx");
			amountField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(toAccountField.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Please enter an account to transfer to");
						}
						else if (amountField.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Please enter an amount to transfer");
						}
						else {
							for(Account account : Storage.accountsList) {
								if (account.getAccountNumber().equals(fromAccountField.getText())) {
									double previousBalance = account.getAccountBalance();
									account.setAccountBalance(previousBalance - Double.parseDouble(amountField.getText()));
								}
							}
							for(Account account : Storage.accountsList) {
								if (account.getAccountNumber().equals(toAccountField.getText())) {
									double previousBalance = account.getAccountBalance();
									account.setAccountBalance(previousBalance + Double.parseDouble(amountField.getText()));
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
