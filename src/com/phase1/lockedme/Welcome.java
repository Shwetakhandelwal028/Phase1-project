package com.phase1.lockedme;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Welcome {

	public void welcomeUser() {

		Scanner input = new Scanner(System.in);
		System.out.println("1 Registtration");
		System.out.println("2 Login");
		System.out.println("3 Exit");
		

		try {
			int keyboardInput = input.nextInt();
			switch (keyboardInput) {
			case 1:
				UserRegistration u1 = new UserRegistration();
				u1.register();
				break;
			case 2:
				UserLogin l1 = new UserLogin();
				l1.login();
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid input, Enter valid number");
				System.out.println("***********************************");
				welcomeUser();
			}
		} catch (Exception e) {
			System.out.println("Invalid input, Enter valid number");
			welcomeUser();
		}

	}

}
