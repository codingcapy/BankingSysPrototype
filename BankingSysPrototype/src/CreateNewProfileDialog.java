/*
 * author: Paul Kim
 * date: February 4, 2023
 * version: 1.0
 * This is a banking system prototype program
 */

import java.awt.BorderLayout;
import java.awt.Color;
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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class CreateNewProfileDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JTextField lastNameField;
	JTextField middleNameField;
	JTextField firstNameField;
	JTextField streetAddressField;
	JTextField phoneNumberField;
	JTextField emailField;
	JTextField cityField;
	JTextField provinceField;
	JTextField postalCodeField;
	JTextField countryField;
	JComboBox<String> birthDayBox;
	JComboBox<String> birthMonthBox;
	JComboBox<String> birthYearBox;
	String[] birthDays = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25",
			"26","27","28","29","30", "31"};
	String[] birthMonths = {"1","2","3","4","5","6","7","8","9","10","11","12"};
	String[] birthYears = {
			"1911","1912","1913","1914","1915","1916","1917","1918","1919","1920","1921","1922","1923","1924","1925","1926","1927","1928","1929","1930",
			"1931","1932","1933","1934","1935","1936","1937","1938","1939","1940","1941","1942","1943","1944","1945","1946","1947","1948","1949","1950",
			"1951","1952","1953","1954","1955","1956","1957","1958","1959","1960","1961","1962","1963","1964","1965","1966","1967","1968","1969","1970",
			"1971","1972","1973","1974","1975","1976","1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990",
			"1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010",
			"2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023"};


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
		setBounds(700, 350, 700, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][][][grow][][grow][][grow][][grow][][grow]", "[][][][][][][][][]"));
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
			JLabel dateOfBirthLabel = new JLabel("Date of Birth");
			contentPanel.add(dateOfBirthLabel, "cell 1 3");
		}
		{
			birthDayBox = new JComboBox<String>(birthDays);
			contentPanel.add(birthDayBox, "cell 3 3,growx");
		}
		{
			birthMonthBox = new JComboBox<String>(birthMonths);
			contentPanel.add(birthMonthBox, "cell 5 3,growx");
		}
		{
			birthYearBox = new JComboBox<String>(birthYears);
			contentPanel.add(birthYearBox, "cell 7 3,growx");
		}
		{
			JLabel addressLabel = new JLabel("Address");
			contentPanel.add(addressLabel, "cell 1 5");
		}
		{
			streetAddressField = new JTextField("Street address");
			contentPanel.add(streetAddressField, "cell 3 5,growx");
			streetAddressField.setColumns(10);
			streetAddressField.setForeground(Color.GRAY);
			streetAddressField.addFocusListener(new FocusListener() {
				@Override
				public void focusGained(FocusEvent e) {
					if (streetAddressField.getText().equals("Street address")) {
						streetAddressField.setText("");
						streetAddressField.setForeground(Color.BLACK);
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if (streetAddressField.getText().isEmpty()) {
						streetAddressField.setForeground(Color.GRAY);
						streetAddressField.setText("Street address");
					}
				}
			});
		}
		{
			cityField = new JTextField("City");
			contentPanel.add(cityField, "cell 5 5,growx");
			cityField.setColumns(10);
			cityField.setForeground(Color.GRAY);
			cityField.addFocusListener(new FocusListener() {
				@Override
				public void focusGained(FocusEvent e) {
					if (cityField.getText().equals("City")) {
						cityField.setText("");
						cityField.setForeground(Color.BLACK);
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if (cityField.getText().isEmpty()) {
						cityField.setForeground(Color.GRAY);
						cityField.setText("City");
					}
				}
			});
		}
		{
			provinceField = new JTextField("Province");
			contentPanel.add(provinceField, "cell 7 5,growx");
			provinceField.setColumns(10);
			provinceField.setForeground(Color.GRAY);
			provinceField.addFocusListener(new FocusListener() {
				@Override
				public void focusGained(FocusEvent e) {
					if (provinceField.getText().equals("Province")) {
						provinceField.setText("");
						provinceField.setForeground(Color.BLACK);
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if (provinceField.getText().isEmpty()) {
						provinceField.setForeground(Color.GRAY);
						provinceField.setText("Province");
					}
				}
			});
		}
		{
			postalCodeField = new JTextField("Postal Code");
			contentPanel.add(postalCodeField, "cell 9 5,growx");
			postalCodeField.setColumns(10);
			postalCodeField.setForeground(Color.GRAY);
			postalCodeField.addFocusListener(new FocusListener() {
				@Override
				public void focusGained(FocusEvent e) {
					if (postalCodeField.getText().equals("Postal Code")) {
						postalCodeField.setText("");
						postalCodeField.setForeground(Color.BLACK);
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if (postalCodeField.getText().isEmpty()) {
						postalCodeField.setForeground(Color.GRAY);
						postalCodeField.setText("Postal Code");
					}
				}
			});
		}
		{
			countryField = new JTextField("Country");
			contentPanel.add(countryField, "cell 11 5,growx");
			countryField.setColumns(10);
			countryField.setForeground(Color.GRAY);
			countryField.addFocusListener(new FocusListener() {
				@Override
				public void focusGained(FocusEvent e) {
					if (countryField.getText().equals("Country")) {
						countryField.setText("");
						countryField.setForeground(Color.BLACK);
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if (countryField.getText().isEmpty()) {
						countryField.setForeground(Color.GRAY);
						countryField.setText("Country");
					}
				}
			});
		}
		{
			JLabel phoneNumberLabel = new JLabel("Phone Number");
			contentPanel.add(phoneNumberLabel, "cell 1 7");
		}
		{
			phoneNumberField = new JTextField();
			contentPanel.add(phoneNumberField, "cell 3 7,growx");
			phoneNumberField.setColumns(10);
		}
		{
			JLabel emailLabel = new JLabel("Email");
			contentPanel.add(emailLabel, "cell 5 7");
		}
		{
			emailField = new JTextField();
			contentPanel.add(emailField, "cell 7 7,growx");
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
						if(firstNameField.getText().isEmpty()||lastNameField.getText().isEmpty()||streetAddressField.getText().isEmpty()
								||phoneNumberField.getText().isEmpty()||emailField.getText().isEmpty()) {
							JOptionPane.showMessageDialog(okButton, "Warning: Mandatory fields must be filled");
						}
						else {
							String profileNumber = Storage.generateProfileNumber(Storage.profilesList);
							String firstName = firstNameField.getText();
							String middleName = middleNameField.getText();
							String lastName = lastNameField.getText();
							String birthDay = (String) birthDayBox.getSelectedItem();
							String birthMonth = (String) birthMonthBox.getSelectedItem();
							String birthYear = (String) birthYearBox.getSelectedItem();
							String streetAddress = streetAddressField.getText();
							String city = cityField.getText();
							String province = provinceField.getText();
							String postalCode = postalCodeField.getText();
							String country = countryField.getText();
							String phoneNumber = phoneNumberField.getText();
							String emailAddress = emailField.getText();
							Profile newProfile = new Profile(profileNumber,firstName,middleName,lastName,birthYear,birthMonth,birthDay,
									streetAddress,city,province,postalCode,country,phoneNumber,emailAddress);
							Storage.profilesList.add(newProfile);
							Storage.profilesListModel.addElement(newProfile);
							JOptionPane.showMessageDialog(null, "Profile created successfully.");
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
