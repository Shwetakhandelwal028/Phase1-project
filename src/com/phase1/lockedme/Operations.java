package com.phase1.lockedme;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Operations {

	public void addFile() {
		UserOperationsList list = new UserOperationsList();
		FileWriter fileWriter = null;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your name");
		String fileName = input.nextLine();
		File folder = new File("users");
		if (!folder.exists()) {
			folder.mkdir();
		}

		File file = new File(folder + "//" + fileName);
		try {
			if (!file.exists()) {
				file.createNewFile();
				System.out.println("File created by name : " + fileName);
				System.out.println(file.getAbsolutePath());

			} else {
				System.out.println("File already exists by name : " + file.getName());
			}
		} catch (IOException e) {
			System.out.println("Error occurred " + e);
		}

		System.out.println("Enter your sitename");
		String sitename = input.nextLine();
		System.out.println("Enter your username");
		String username = input.nextLine();
		System.out.println("Enter your password");
		String password = input.nextLine();

		try {
			fileWriter = new FileWriter(file, true);
			fileWriter.write(fileName);
			fileWriter.write("\n");
			fileWriter.write(sitename);
			fileWriter.write("\n");
			fileWriter.write(username);
			fileWriter.write("\n");
			fileWriter.write(password);
			fileWriter.write("\n");
			System.out.println("");
			System.out.println("Details are added!!!");
		} catch (IOException e) {
			System.out.println("An Error occurred while writing the user details");
			e.printStackTrace();
		} finally {
			try {
				fileWriter.close();
			} catch (IOException e) {
			}

			System.out.println("");
			System.out.println("***********************************");
			System.out.println("Enter the operation number that you want to perform");
			list.operationList();
		}

	}

	public void fetchUser() {
		UserOperationsList list = new UserOperationsList();
		BufferedReader reader;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the file name");
		String name = input.nextLine();
		File file = new File("users//" + name);

		try {
			if (file.exists()) {

				reader = new BufferedReader(new FileReader(file));

				String line = null;
				String tempUserName = "";
				String tempPassword = "";
				String tempName = "";
				String tempSiteName = "";

				while ((line = reader.readLine()) != null) {

					if (line.equalsIgnoreCase(name)) {
						tempName = line.toString();
						tempSiteName = reader.readLine();
						tempUserName = reader.readLine();
						tempPassword = reader.readLine();
						System.out.println("User details are :");
						System.out.println("Name : " + tempName);
						System.out.println("Site name : " + tempSiteName);
						System.out.println("username : " + tempUserName);
						System.out.println("password : " + tempPassword);
					}
				}
				reader.close();
			} else {
				System.out.println("File does not exist by name : " + name);

			}
			System.out.println("");
			System.out.println("***********************************");
			System.out.println("Enter the operation number that you want to perform");
			list.operationList();

		} catch (Exception e) {
			System.out.println("An Error occurred " + e);
		}
	}

	public void deleteFile() {

		UserOperationsList list = new UserOperationsList();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the file name that you want to delete");
		String fileName = input.nextLine();
		File file = new File("users//" + fileName);
		try {
			boolean response = file.delete();
			if (response) {
				System.out.println("File deleted by name : " + file.getName());
			} else {
				System.out.println("File not found by name : " + file.getName());
			}
			System.out.println("");
			System.out.println("***********************************");
			System.out.println("Enter the operation number that you want to perform");
			list.operationList();
		} catch (Exception e) {
			System.out.println("An error occurred " + e.getMessage());
		}
	}

	public void searchFile() {
		UserOperationsList list = new UserOperationsList();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the file name");
		String fileName = input.nextLine();

		File file = new File("users//" + fileName);
		if (file.exists()) {
			System.out.println("File exists by name : " + fileName);
		} else {
			System.out.println("File does not exists by name : " + fileName);
		}

		System.out.println("");
		System.out.println("***********************************");
		System.out.println("Enter the operation number that you want to perform");
		list.operationList();
	}

	public void fetchFiles() {

		UserOperationsList list = new UserOperationsList();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter username");
		String username = input.nextLine();
		System.out.println("Enter password");
		String password = input.nextLine();
		if (username.trim().equals("admin") && password.trim().equals("admin1234")) {

			File dirPath = new File("users");

			File[] fileList = dirPath.listFiles();
			Arrays.sort(fileList);
			System.out.println("Sorted file list is :");
			for (File file : fileList) {

				System.out.println(file.getName());

			}
		} else {
			System.out.println("You does not have access for this operation");
		}
		System.out.println("");
		System.out.println("***********************************");
		System.out.println("Enter the operation number that you want to perform");
		list.operationList();

	}

	public void fetchLockerCredentials() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your name");
		String name = input.nextLine();

		try {
			UserOperationsList list = new UserOperationsList();
			BufferedReader reader = new BufferedReader(new FileReader("database.txt"));

			String line = null;
			String tempUserName = "";
			String tempPassword = "";
			String tempName = "";
			String tempSiteName = "";

			boolean count = false;
			while ((line = reader.readLine()) != null) {

				if (line.equalsIgnoreCase(name)) {
					tempName = line.toString();
					tempSiteName = reader.readLine();
					tempUserName = reader.readLine();
					tempPassword = reader.readLine();
					System.out.println("User details are :");
					System.out.println("Name : " + tempName);
					System.out.println("Site name : " + tempSiteName);
					System.out.println("username : " + tempUserName);
					System.out.println("password : " + tempPassword);

					count = true;

				}

			}
			if (!count) {
				System.out.println("User does not exist by name : " + name);

			}
			System.out.println("");
			System.out.println("***********************************");
			System.out.println("Enter the operation number that you want to perform");
			list.operationList();

			reader.close();
		} catch (Exception e) {
			System.out.println("An Error occurred " + e);
		}
	}
}