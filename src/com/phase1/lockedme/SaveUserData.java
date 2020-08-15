package com.phase1.lockedme;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveUserData {

	public void savingUserData(String name, String siteName, String userName, String password) {
		File file = new File("//home//ubuntu//eclipse-workspace//LockedMeApplication//database//database.txt");
		FileWriter fileWriter = null;

		try {
			if (!file.exists()) {
				file.createNewFile();

			}
		} catch (IOException e) {
			System.out.println("An Error occurred while file creation");
			e.printStackTrace();
		}

		try {
			fileWriter = new FileWriter(file, true);
			fileWriter.write(name);
			fileWriter.write("\n");
			fileWriter.write(siteName);
			fileWriter.write("\n");
			fileWriter.write(userName);
			fileWriter.write("\n");
			fileWriter.write(password);
			fileWriter.write("\n");

		} catch (IOException e) {
			System.out.println("An Error occurred while writing the user details");
			e.printStackTrace();
		} finally {
			try {
				fileWriter.close();
			} catch (IOException e) {
			}
		}
	}
	
	public void savingUserCredentials(String username, String password) {

		File file2 = new File("//home//ubuntu//eclipse-workspace//LockedMeApplication//database//locker.txt");

		FileWriter fileWriter2 = null;

		try {
			if (!file2.exists()) {
				file2.createNewFile();

			}
		} catch (IOException e) {
			System.out.println("An Error occurred while file creation");
			e.printStackTrace();
		}

		try {

			fileWriter2 = new FileWriter(file2, true);
			fileWriter2.write(username);
			fileWriter2.write(",");
			fileWriter2.write(password);
			fileWriter2.write("\n");

		} catch (IOException e) {
			System.out.println("An Error occurred while writing the user details");
			e.printStackTrace();
		} finally {
			try {
				fileWriter2.close();
			} catch (IOException e) {
			}
		}
	}

}
