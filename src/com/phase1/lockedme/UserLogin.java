package com.phase1.lockedme;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class UserLogin {
	
	UserOperationsList list = new UserOperationsList();
	

	public void login() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Username");
		String lockerUsername = input.nextLine();
		System.out.println("Enter Password");
		String lockerPassword = input.nextLine();
		boolean response = validateUser(lockerUsername, lockerPassword);
		if (response) {
			login();
		} else {
			verifyUser(lockerUsername, lockerPassword);
		}

	}

	public boolean validateUser(String lockerUsername, String lockerPassword) {
		boolean response = false;
		if (lockerUsername.isEmpty() || lockerPassword.isEmpty()) {
			System.out.println("Username & Password cannot be empty");
			return response = true;

		}
		return response;
	}

	public void verifyUser(String lockerUsername, String lockerPassword) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("locker.txt"));
			boolean found = false;
			String line = null;
			String tempUserName = "";
			String tempPassword = "";

			while ((line = reader.readLine()) != null) {

				String[] sArray = line.split(",");
				// System.out.println(Arrays.toString(sArray));
				tempUserName = sArray[0];
				tempPassword = sArray[1];
				if (lockerUsername.trim().equals(tempUserName) && lockerPassword.trim().equals(tempPassword)) {
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
