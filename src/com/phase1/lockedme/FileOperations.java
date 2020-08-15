package com.phase1.lockedme;

import java.util.Scanner;

public class FileOperations {

	Scanner input = new Scanner(System.in);
	Operations op = new Operations();

	public void fileOperationList() {
		System.out.println(" ");
		System.out.println("1 Add a file");
		System.out.println("2 Delete a file");
		System.out.println("3 Search for a file");
		System.out.println("4 Back");
		System.out.println("***********************************");

		int option = input.nextInt();
		try {
			switch (option) {
			case 1: {
				op.addFile();
				break;
			}
			case 2: {
				op.deleteFile();
				break;
			}
			case 3: {
				op.searchFile();
				break;
			}
			case 4: {
				System.out.println("Enter the operation number that you want to perform");
				UserOperationsList list = new UserOperationsList();
				list.operationList();
				break;
			}
			default: {
				System.out.println("Invalid input, Enter valid number");
				System.out.println("***********************************");
				fileOperationList();
				break;
			}
			}
		} catch (Exception e) {
			System.out.println("Invalid input, Enter valid number");
			System.out.println("***********************************");
			fileOperationList();
		}
	}
}
