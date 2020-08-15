package com.phase1.lockedme;

import java.util.Scanner;

public class UserOperationsList {

	Operations op = new Operations();
	
	public void operationList() {
		Scanner input = new Scanner(System.in);
		System.out.println("");
		System.out.println("1 Fetch the User details");
		System.out.println("2 Fetch the files in a folder");
		System.out.println("3 Perform File operations");
		System.out.println("6 Back");
		System.out.println("***********************************");
 
		try {
			int keyboardInput = input.nextInt();
			switch (keyboardInput) {
			case 1:
				op.fetchUser();
				break;
			case 2:
				op.fetchFiles();
				break;
			case 3:
				System.out.println("3 Add a file");
				System.out.println("4 Delete a file");
				System.out.println("5 Search for a file");
				op.addFile();
				break;
			case 4:
				op.deleteFile();
				break;
			case 5:
				op.searchFile();
				break;
			case 6:
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
			operationList();
		}

		
	}
}
