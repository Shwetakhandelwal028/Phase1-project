package com.phase1.lockedme;

import java.util.Scanner;

public class UserOperationsList {
	
	Operations op = new Operations();

	public void operationList() {
		Scanner input = new Scanner(System.in);
		System.out.println("");
		System.out.println("1 Fetch all users(only admin)");
		System.out.println("2 Add file");
		System.out.println("3 Delete file");
		System.out.println("4 Search file");
		System.out.println("5 Fetch User details");
		System.out.println("6 Fetch locker credentials");
		System.out.println("7 Back");
		System.out.println("***********************************");

		try {
			int keyboardInput = input.nextInt();
			switch (keyboardInput) {
			case 1:
				op.fetchFiles();
				break;
			case 2:
				op.addFile();
				break;
			case 3:
				op.deleteFile();
				break;
			case 4:
				op.searchFile();
				break;
			case 5:
				op.fetchUser();
				break;
			case 6:
				op.fetchLockerCredentials();
				break;
			case 7:
				Welcome user = new Welcome();
				user.welcomeUser();
			
				break;
			default:
				System.out.println("Invalid input, Enter valid number");
				System.out.println("***********************************");
				operationList();
			}
		} catch (Exception e) {
			System.out.println("Invalid input, Enter valid number");
			System.out.println("***********************************");
			operationList();
		}

	}
}