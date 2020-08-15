package com.phase1.lockedme;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class UserLogin {
	
	UserOperationsList list = new UserOperationsList();

	public void login() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Username");
		String username = input.nextLine();
		System.out.println("Enter Password");
		String password = input.nextLine();
		boolean response = validateUser(username, password);
		if (response) {
			login();
		} else {
			verifyUser(username, password);
		}

	}

	public boolean validateUser(String username, String password) {
		boolean response = false;
		if (username.isEmpty() || password.isEmpty()) {
			System.out.println("Username & Password cannot be empty");
			return response = true;

		}
		return response;
	}

	public void verifyUser(String username, String password) {

		try {
			BufferedReader reader = new BufferedReader(new FileReader("//home//ubuntu//eclipse-workspace//LockedMeApplication//database//locker.txt"));
			boolean found = false;
			String line = null;
			String tempUserName = "";
			String tempPassword = "";

			while ((line = reader.readLine()) != null) {

				String[] sArray = line.split(",");
				// System.out.println(Arrays.toString(sArray));
				tempUserName = sArray[0];
				tempPassword = sArray[1];
				if (username.trim().equals(tempUserName) && password.trim().equals(tempPassword)) {
					System.out.println("Valid User");
					System.out.println("***********************************");
					System.out.println("Enter the operation number that you want to perform");
					found = true;
                    list.operationList();
				}
			}
			if (found == false) {
				System.out.println("Invalid User");
				login();
			}
			reader.close();

		} catch (Exception e) {
			System.out.println("Error Occurred " + e.getMessage());
			e.printStackTrace();
		}
	}

}
