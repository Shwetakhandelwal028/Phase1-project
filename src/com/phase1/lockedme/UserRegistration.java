package com.phase1.lockedme;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserRegistration {
	
	UserData user = new UserData();
	UserOperationsList list = new UserOperationsList();
	SaveUserData  save = new SaveUserData();

	public void register() {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter your FullName");
		user.setName(input.nextLine());

		System.out.println("Enter website name");
		user.setSiteName(input.nextLine());

		System.out.println("Enter Username");
		user.setUsername(input.nextLine());

		System.out.println("Enter Password");
		user.setPassword(input.nextLine());
		
		boolean response = validateUser(user.getName(), user.getSiteName(), user.getUsername(), user.getPassword());
        if(response) {
        	register();
        }
        
        else {
		save.savingUserData(user.getName(), user.getSiteName(), user.getUsername(), user.getPassword());
		save.savingUserCredentials(user.getUsername(), user.getPassword());
		System.out.println("Registration Successful!!!");
		System.out.println("***********************************");
		System.out.println("Enter the operation number that you want to perform");
		list.operationList();
        }

	}
	
	public boolean validateUser(String fullname, String sitename , String username, String password) {
		boolean response = false;
		if(username.isEmpty() || password.isEmpty() || fullname.isEmpty() || sitename.isEmpty()) {
			System.out.println("Name, sitename, Username & Password cannot be empty");
			return response = true;
			
		}
		return response;
	}

	
	
}
