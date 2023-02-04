/*
 * author: Paul Kim
 * date: February 4, 2023
 * version: 1.0
 * This is a banking system prototype program
 */

import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class Storage {
	static ArrayList<Profile> profilesList = new ArrayList<Profile>();
	static DefaultListModel<Profile> profilesListModel = new DefaultListModel<Profile>();
	static ArrayList<Account> accountsList = new ArrayList<Account>();
	static DefaultListModel<Account> accountsListModel = new DefaultListModel<Account>();

	public static String generateProfileNumber(ArrayList inputArray) {
		String newNumber = null;
		if (inputArray.size() == 0) {
			newNumber = String.format("%08d", Integer.parseInt("0"));
		}
		else {
			newNumber = String.format("%08d", inputArray.size());
		}
		return newNumber;
	}
	public static String generateAccountNumber(ArrayList inputArray) {
		String newNumber = null;
		if (inputArray.size() == 0) {
			newNumber = String.format("%012d", Integer.parseInt("0"));
		}
		else {
			newNumber = String.format("%012d", inputArray.size());
		}
		return newNumber;
	}
}
