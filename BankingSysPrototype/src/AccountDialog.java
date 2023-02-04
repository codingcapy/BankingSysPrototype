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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccountDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JTextField profileNumberField;
	JTextField accountNumberField;
	JTextField interestRateField;
	JTextField balanceField;
	private TransferDialog transferDialog;
	private WithdrawDialog withdrawDialog;
	private DepositDialog depositDialog;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			AccountDialog dialog = new AccountDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public AccountDialog() {
		setTitle("Account");
		transferDialog = new TransferDialog();
		depositDialog = new DepositDialog();
		withdrawDialog = new WithdrawDialog();
		setBounds(700, 350, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][][][grow][]", "[][][][][][][][]"));
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
			JLabel interestRateLabel = new JLabel("Interest Rate");
			contentPanel.add(interestRateLabel, "cell 1 5");
		}
		{
			interestRateField = new JTextField();
			interestRateField.setEnabled(false);
			contentPanel.add(interestRateField, "cell 3 5,growx");
			interestRateField.setColumns(10);
		}
		{
			JLabel balanceLabel = new JLabel("Balance");
			contentPanel.add(balanceLabel, "cell 1 7");
		}
		{
			balanceField = new JTextField();
			balanceField.setEnabled(false);
			contentPanel.add(balanceField, "cell 3 7,growx");
			balanceField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton depositButton = new JButton("Deposit");
				depositButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						depositDialog.accountNumberField.setText(accountNumberField.getText());
						depositDialog.depositAmountField.setText("");
						depositDialog.setVisible(true);
					}
				});
				buttonPane.add(depositButton);
			}
			{
				JButton withdrawButton = new JButton("Withdraw");
				withdrawButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						withdrawDialog.accountNumberField.setText(accountNumberField.getText());
						withdrawDialog.withdrawalField.setText("");
						withdrawDialog.setVisible(true);
					}
				});
				buttonPane.add(withdrawButton);
			}
			{
				JButton transferButton = new JButton("Transfer");
				transferButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						transferDialog.fromAccountField.setText(accountNumberField.getText());
						transferDialog.toAccountField.setText("");
						transferDialog.amountField.setText("");
						transferDialog.setVisible(true);
					}
				});
				buttonPane.add(transferButton);
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
