package com.phase1.lockedme;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserRegistration {
	
	
	UserOperationsList list = new UserOperationsList();
	SaveUserData  save = new SaveUserData();
	

	public void register() {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter your Name");
		String name = input.nextLine();

		String sitename = "Locker Credentials";
		
		System.out.println("Enter Username");
		String lockerUsername = input.nextLine();

		System.out.println("Enter Password");
		String lockerPassword =input.nextLine();
		
		boolean response = validateUser(name, lockerUsername, lockerPassword);
        if(response) {
        	register();
        }
        
        else {
        
        User user = new User(name, sitename, lockerUsername,  lockerPassword);
		save.savingUserData("database.txt",name, sitename, lockerUsername,  lockerPassword);
		save.savingUserCredentials(lockerUsername, lockerPassword);
		System.out.println("Registration Successful!!!");
		System.out.println("***********************************");
		System.out.println("Enter the operation number that you want to perform");
		list.operationList();
        }

	}
	
	public boolean validateUser(String name, String lockerUserName, String lockerPassword) {
		boolean response = false;
		if(name.isEmpty() || lockerUserName.isEmpty() || lockerPassword.isEmpty()) {
			System.out.println("Name, Username & Password cannot be empty");
			return response = true;
			
		}
		return response;
	}

	
	
}
