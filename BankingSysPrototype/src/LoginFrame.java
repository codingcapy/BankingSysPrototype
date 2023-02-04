/*
 * author: Paul Kim
 * date: February 4, 2023
 * version: 1.0
 * This is a banking system prototype program
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField userNameField;
	private JTextField passwordField;
	private JButton forgotPasswordButton;
	private HomeFrame homeFrame;
	private ForgotPasswordDialog forgotPasswordDialog;

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					LoginFrame frame = new LoginFrame();
	//					frame.setVisible(true);
	//				} catch (Exception e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		});
	//	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		homeFrame = new HomeFrame();
		forgotPasswordDialog = new ForgotPasswordDialog();
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 350, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][grow][][grow]", "[][][][][][][][]"));

		JLabel userNameLabel = new JLabel("Username");
		contentPane.add(userNameLabel, "cell 2 3");

		userNameField = new JTextField();
		contentPane.add(userNameField, "cell 4 3,growx");
		userNameField.setColumns(10);

		JLabel passwordLabel = new JLabel("Password");
		contentPane.add(passwordLabel, "cell 2 5");

		passwordField = new JTextField();
		contentPane.add(passwordField, "cell 4 5,growx");
		passwordField.setColumns(10);

		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homeFrame.setVisible(true);
				dispose();
			}
		});
		contentPane.add(loginButton, "flowx,cell 4 7");

		forgotPasswordButton = new JButton("Forgot Password");
		forgotPasswordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				forgotPasswordDialog.setVisible(true);
			}
		});
		contentPane.add(forgotPasswordButton, "cell 4 7");
	}

}
