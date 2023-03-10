/*
 * author: Paul Kim
 * date: February 4, 2023
 * version: 1.0
 * This is a banking system prototype program
 */

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HomeFrame extends JFrame {

	private JPanel contentPane;
	private JTextField byProfileNumberField;
	private JTextField byPhoneNumberField;
	private JLabel byEmailLabel;
	private JTextField byEmailField;
	private JLabel byAccountNumberLabel;
	private JLabel byPhoneNumberLabel;
	private JTextField byAccountNumberField;
	private JButton displayAllProfilesButton;
	private JButton searchButton;
	private ProfileDialog profileDialog;
	private AllProfilesDialog allProfilesDialog;
	private JButton createNewProfileButton;
	private JButton logoutButton;
	private CreateNewProfileDialog createNewProfileDialog;
	private File file;
	private File file2;
	private File file3;
	private Scanner scanner;
	private Scanner scanner2;
	private Scanner scanner3;
	private FileWriter writer;
	private FileWriter writer2;
	private FileWriter writer3;

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					HomeFrame frame = new HomeFrame();
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
	public HomeFrame() {
		setTitle("Banking System Prototype");
		file = new File("profile_data.csv");
		file2 = new File("account_data.csv");
		file3 = new File("note_data.csv");
		try {
			scanner = new Scanner(file);
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				String[] pData = line.split(",");
				String profileNumber = pData[0];
				String firstName = pData[1];
				String middleName = pData[2];
				String lastName = pData[3];
				String birthYear = pData[4];
				String birthMonth = pData[5];
				String birthDay = pData[6];
				String streetAddress = pData[7];
				String city = pData[8];
				String province = pData[9];
				String postalCode = pData[10];
				String country = pData[11];
				String phoneNumber = pData[12];
				String emailAddress = pData[13];
				Profile newProfile = new Profile(profileNumber,firstName,middleName,lastName,birthYear, birthMonth,birthDay,streetAddress,
						city,province,postalCode,country,phoneNumber,emailAddress);
				Storage.profilesList.add(newProfile);
				Storage.profilesListModel.addElement(newProfile);
			}
			scanner.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			scanner2 = new Scanner(file2);
			while (scanner2.hasNext()) {
				String line2 = scanner2.nextLine();
				String[] aData = line2.split(",");
				String profileNumber = aData[0];
				String accountNumber = aData[1];
				String accountType = aData[2];
				double interestRate = Double.parseDouble(aData[3]);
				double balance = Double.parseDouble(aData[4]);
				Account newAccount = new Account(profileNumber, accountNumber, accountType, interestRate, balance);
				Storage.accountsList.add(newAccount);
			}
			scanner2.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			scanner3 = new Scanner(file3);
			while (scanner3.hasNext()) {
				String line3 = scanner3.nextLine();
				String[] nData = line3.split(",");
				String profileNumber = nData[0];
				String note = nData[1];
				Note newNote = new Note(profileNumber, note);
				Storage.notesList.add(newNote);
			}
			scanner3.close();
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		profileDialog = new ProfileDialog();
		allProfilesDialog = new AllProfilesDialog();
		createNewProfileDialog = new CreateNewProfileDialog();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				try {
					writer = new FileWriter(file);
					for (Profile profile : Storage.profilesList) {
						writer.write(profile.profileData());
					}
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					writer2 = new FileWriter(file2);
					for (Account account : Storage.accountsList) {
						writer2.write(account.accountData());
					}
					writer2.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					writer3 = new FileWriter(file3);
					for (Note note : Storage.notesList) {
						writer3.write(note.noteData());
					}
					writer3.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		setBounds(700, 350, 650, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][grow][][]", "[][][][][][][][][][][][][][]"));

		JLabel searchProfileLabel = new JLabel("Search Profile using a category below");
		contentPane.add(searchProfileLabel, "cell 1 1 3 1");

		logoutButton = new JButton("Log out");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					writer = new FileWriter(file);
					for (Profile profile : Storage.profilesList) {
						writer.write(profile.profileData());
					}
					writer.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					writer2 = new FileWriter(file2);
					for (Account account : Storage.accountsList) {
						writer2.write(account.accountData());
					}
					writer2.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					writer3 = new FileWriter(file3);
					for (Note note : Storage.notesList) {
						writer3.write(note.noteData());
					}
					writer3.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		contentPane.add(logoutButton, "cell 4 1");

		JLabel byProfileNumberLabel = new JLabel("By Profile Number");
		contentPane.add(byProfileNumberLabel, "cell 1 3");

		byProfileNumberField = new JTextField();
		byProfileNumberField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				byProfileNumberField.setEnabled(true);
				byProfileNumberLabel.setEnabled(true);
				byPhoneNumberField.setEnabled(false);
				byPhoneNumberLabel.setEnabled(false);
				byPhoneNumberField.setText("");
				byEmailField.setEnabled(false);
				byEmailLabel.setEnabled(false);
				byEmailField.setText("");
				byAccountNumberField.setEnabled(false);
				byAccountNumberLabel.setEnabled(false);
				byAccountNumberField.setText("");
			}
		});
		contentPane.add(byProfileNumberField, "cell 3 3,growx");
		byProfileNumberField.setColumns(10);

		byPhoneNumberLabel = new JLabel("By Phone Number");
		contentPane.add(byPhoneNumberLabel, "cell 1 5");

		byPhoneNumberField = new JTextField();
		byPhoneNumberField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				byProfileNumberField.setEnabled(false);
				byProfileNumberLabel.setEnabled(false);
				byProfileNumberField.setText("");
				byPhoneNumberField.setEnabled(true);
				byPhoneNumberLabel.setEnabled(true);
				byEmailField.setEnabled(false);
				byEmailLabel.setEnabled(false);
				byEmailField.setText("");
				byAccountNumberField.setEnabled(false);
				byAccountNumberLabel.setEnabled(false);
				byAccountNumberField.setText("");
			}
		});
		contentPane.add(byPhoneNumberField, "cell 3 5,growx");
		byPhoneNumberField.setColumns(10);

		byEmailLabel = new JLabel("By email");
		contentPane.add(byEmailLabel, "cell 1 7");

		byEmailField = new JTextField();
		byEmailField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				byProfileNumberField.setEnabled(false);
				byProfileNumberLabel.setEnabled(false);
				byProfileNumberField.setText("");
				byPhoneNumberField.setEnabled(false);
				byPhoneNumberLabel.setEnabled(false);
				byPhoneNumberField.setText("");
				byEmailField.setEnabled(true);
				byEmailLabel.setEnabled(true);
				byAccountNumberField.setEnabled(false);
				byAccountNumberLabel.setEnabled(false);
				byAccountNumberField.setText("");
			}
		});
		contentPane.add(byEmailField, "cell 3 7,growx");
		byEmailField.setColumns(10);

		byAccountNumberLabel = new JLabel("By Account Number");
		contentPane.add(byAccountNumberLabel, "cell 1 9");

		byAccountNumberField = new JTextField();
		byAccountNumberField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				byProfileNumberField.setEnabled(false);
				byProfileNumberLabel.setEnabled(false);
				byProfileNumberField.setText("");
				byPhoneNumberField.setEnabled(false);
				byPhoneNumberField.setText("");
				byEmailField.setEnabled(false);
				byEmailField.setText("");
				byAccountNumberField.setEnabled(true);
				byAccountNumberLabel.setEnabled(true);
			}
		});
		contentPane.add(byAccountNumberField, "cell 3 9,growx");
		byAccountNumberField.setColumns(10);

		searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Storage.accountsListModel.removeAllElements();
				Storage.notesListModel.removeAllElements();
				if (byProfileNumberField.getText().isEmpty() && byPhoneNumberField.getText().isEmpty() && byEmailField.getText().isEmpty() && byAccountNumberField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please input search");
				}
				if (!byProfileNumberField.getText().isEmpty()) {
					String inputSearch = byProfileNumberField.getText();
					for (Profile profile : Storage.profilesList) {
						if (profile.getProfileNumber().equals(inputSearch)) {
							profileDialog.profileNumberField.setText(profile.getProfileNumber());
							profileDialog.firstNameField.setText(profile.getFirstName());
							profileDialog.middleNameField.setText(profile.getMiddleName());
							profileDialog.lastNameField.setText(profile.getLastName());
							profileDialog.streetAddressField.setText(profile.getStreetAddress());
							profileDialog.cityField.setText(profile.getCity());
							profileDialog.provinceField.setText(profile.getProvince());
							profileDialog.postalCodeField.setText(profile.getPostalCode());
							profileDialog.countryField.setText(profile.getCountry());
							profileDialog.birthDayField.setText(profile.getBirthDay());
							profileDialog.birthMonthField.setText(profile.getBirthMonth());
							profileDialog.birthYearField.setText(profile.getBirthYear());
							profileDialog.phoneNumberField.setText(profile.getPhoneNumber());
							profileDialog.emailAddressField.setText(profile.getEmailAddress());
						}
					}
					for (Account account : Storage.accountsList) {
						if (profileDialog.profileNumberField.getText().equals(account.getProfileNumber())) {
							Storage.accountsListModel.addElement(account);
						}
					}
					for (Note note : Storage.notesList) {
						if (profileDialog.profileNumberField.getText().equals(note.getProfileNumber())) {
							Storage.notesListModel.addElement(note);
						}
					}
					profileDialog.setVisible(true);
				}
				else if(!byPhoneNumberField.getText().isEmpty()) {
					String inputSearch = byPhoneNumberField.getText();
					for (Profile profile : Storage.profilesList) {
						if (profile.getPhoneNumber().equals(inputSearch)) {
							profileDialog.profileNumberField.setText(profile.getProfileNumber());
							profileDialog.firstNameField.setText(profile.getFirstName());
							profileDialog.middleNameField.setText(profile.getMiddleName());
							profileDialog.lastNameField.setText(profile.getLastName());
							profileDialog.streetAddressField.setText(profile.getStreetAddress());
							profileDialog.cityField.setText(profile.getCity());
							profileDialog.provinceField.setText(profile.getProvince());
							profileDialog.postalCodeField.setText(profile.getPostalCode());
							profileDialog.countryField.setText(profile.getCountry());
							profileDialog.birthDayField.setText(profile.getBirthDay());
							profileDialog.birthMonthField.setText(profile.getBirthMonth());
							profileDialog.birthYearField.setText(profile.getBirthYear());
							profileDialog.phoneNumberField.setText(profile.getPhoneNumber());
							profileDialog.emailAddressField.setText(profile.getEmailAddress());
						}
					}
					for (Account account : Storage.accountsList) {
						if (profileDialog.profileNumberField.getText().equals(account.getProfileNumber())) {
							Storage.accountsListModel.addElement(account);
						}
					}
					for (Note note : Storage.notesList) {
						if (profileDialog.profileNumberField.getText().equals(note.getProfileNumber())) {
							Storage.notesListModel.addElement(note);
						}
					}
					profileDialog.setVisible(true);
				}
				else if(!byEmailField.getText().isEmpty()) {
					String inputSearch = byEmailField.getText();
					for (Profile profile : Storage.profilesList) {
						if (profile.getEmailAddress().equals(inputSearch)) {
							profileDialog.profileNumberField.setText(profile.getProfileNumber());
							profileDialog.firstNameField.setText(profile.getFirstName());
							profileDialog.middleNameField.setText(profile.getMiddleName());
							profileDialog.lastNameField.setText(profile.getLastName());
							profileDialog.streetAddressField.setText(profile.getStreetAddress());
							profileDialog.cityField.setText(profile.getCity());
							profileDialog.provinceField.setText(profile.getProvince());
							profileDialog.postalCodeField.setText(profile.getPostalCode());
							profileDialog.countryField.setText(profile.getCountry());
							profileDialog.birthDayField.setText(profile.getBirthDay());
							profileDialog.birthMonthField.setText(profile.getBirthMonth());
							profileDialog.birthYearField.setText(profile.getBirthYear());
							profileDialog.phoneNumberField.setText(profile.getPhoneNumber());
							profileDialog.emailAddressField.setText(profile.getEmailAddress());
						}
					}
					for (Account account : Storage.accountsList) {
						if (profileDialog.profileNumberField.getText().equals(account.getProfileNumber())) {
							Storage.accountsListModel.addElement(account);
						}
					}
					for (Note note : Storage.notesList) {
						if (profileDialog.profileNumberField.getText().equals(note.getProfileNumber())) {
							Storage.notesListModel.addElement(note);
						}
					}
					profileDialog.setVisible(true);
				}
				else if(!byAccountNumberField.getText().isEmpty()) {
					String inputSearch = byAccountNumberField.getText();
					for (Account account : Storage.accountsList) {
						if (account.getAccountNumber().equals(inputSearch)) {
							for (Profile profile : Storage.profilesList) {
								if (profile.getProfileNumber().equals(account.getProfileNumber())) {
									profileDialog.profileNumberField.setText(profile.getProfileNumber());
									profileDialog.firstNameField.setText(profile.getFirstName());
									profileDialog.middleNameField.setText(profile.getMiddleName());
									profileDialog.lastNameField.setText(profile.getLastName());
									profileDialog.streetAddressField.setText(profile.getStreetAddress());
									profileDialog.cityField.setText(profile.getCity());
									profileDialog.provinceField.setText(profile.getProvince());
									profileDialog.postalCodeField.setText(profile.getPostalCode());
									profileDialog.countryField.setText(profile.getCountry());
									profileDialog.birthDayField.setText(profile.getBirthDay());
									profileDialog.birthMonthField.setText(profile.getBirthMonth());
									profileDialog.birthYearField.setText(profile.getBirthYear());
									profileDialog.phoneNumberField.setText(profile.getPhoneNumber());
									profileDialog.emailAddressField.setText(profile.getEmailAddress());
								}
							}
						}
					}
					for (Account account : Storage.accountsList) {
						if (profileDialog.profileNumberField.getText().equals(account.getProfileNumber())) {
							Storage.accountsListModel.addElement(account);
						}
					}
					for (Note note : Storage.notesList) {
						if (profileDialog.profileNumberField.getText().equals(note.getProfileNumber())) {
							Storage.notesListModel.addElement(note);
						}
					}
					profileDialog.setVisible(true);
				}
			}
		});

		contentPane.add(searchButton, "cell 3 11");

		displayAllProfilesButton = new JButton("Display All Profiles");
		displayAllProfilesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allProfilesDialog.setVisible(true);
			}
		});
		contentPane.add(displayAllProfilesButton, "cell 1 13");

		createNewProfileButton = new JButton("Create New Profile");
		createNewProfileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createNewProfileDialog.firstNameField.setText("");
				createNewProfileDialog.middleNameField.setText("");
				createNewProfileDialog.lastNameField.setText("");
				createNewProfileDialog.streetAddressField.setForeground(Color.GRAY);
				createNewProfileDialog.streetAddressField.setText("Street address");
				createNewProfileDialog.cityField.setForeground(Color.GRAY);
				createNewProfileDialog.cityField.setText("City");
				createNewProfileDialog.provinceField.setForeground(Color.GRAY);
				createNewProfileDialog.provinceField.setText("Province");
				createNewProfileDialog.postalCodeField.setForeground(Color.GRAY);
				createNewProfileDialog.postalCodeField.setText("Postal Code");
				createNewProfileDialog.countryField.setForeground(Color.GRAY);
				createNewProfileDialog.countryField.setText("Country");
				createNewProfileDialog.phoneNumberField.setText("");
				createNewProfileDialog.emailField.setText("");
				createNewProfileDialog.setVisible(true);
			}
		});
		contentPane.add(createNewProfileButton, "cell 3 13");
	}

}
