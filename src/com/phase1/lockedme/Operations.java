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
	
	
	public void fetchUser() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the user's full name, whose details you want to fetch");
		String name = input.nextLine();

		try {
			UserOperationsList list = new UserOperationsList();
			BufferedReader reader = new BufferedReader(new FileReader("//home//ubuntu//eclipse-workspace//LockedMeApplication//database//database.txt"));

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
					System.out.println("Name : "+tempName);
					System.out.println("Site name : "+tempSiteName);
					System.out.println("username : "+tempUserName);
					System.out.println("password : "+tempPassword);
					
					count = true;
					
				}

			}
			if(!count) {
				System.out.println("User does not exist by name : "+name);
				
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

	
	public void fetchFiles() {
		UserOperationsList list = new UserOperationsList();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the folder path");
		String path = input.nextLine();

		File dirPath = new File(path);
		if(dirPath.isDirectory()) {
			File[] fileList = dirPath.listFiles();
			Arrays.sort(fileList);
			System.out.println("Sorted file list is :");
			for(File file: fileList) {
				
				System.out.println(file.getName());
				
			}
		}else {
			System.out.println("Folder does not exist");
		}
		System.out.println("");
		System.out.println("***********************************");
		System.out.println("Enter the operation number that you want to perform");
		list.operationList();
		
	}

	public void addFile() {
        FileOperations list = new FileOperations();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the name of the file");
		String fileName = input.nextLine();
		
		File file = new File("//home//ubuntu//eclipse-workspace//LockedMeApplication//users//"+fileName);
		try {
			if(!file.exists()) {
				file.createNewFile();
				System.out.println("File created!!");
				System.out.println(file.getAbsolutePath());
			}
			else {
				System.out.println("File already exists by name : "+file.getName());
			}
			System.out.println("");
			System.out.println("***********************************");
			System.out.println("Enter the operation number that you want to perform");
			list.fileOperationList();
			
			
		} catch (IOException e) {
			System.out.println("Error occurred "+e);
		}
		
	}

	public void deleteFile() {
        FileOperations list = new FileOperations();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the file name that you want to delete");
		String fileName = input.nextLine();
		File file = new File("//home//ubuntu//eclipse-workspace//LockedMeApplication//users//"+fileName);
		try {
			boolean response = file.delete();
			if(response) {
				System.out.println("File deleted by name : "+file.getName());
			}else {
				System.out.println("File not found by name : "+file.getName());
			}
			System.out.println("");
			System.out.println("***********************************");
			System.out.println("Enter the operation number that you want to perform");
			list.fileOperationList();
		} catch (Exception e) {
			System.out.println("An error occurred "+e.getMessage());
		}
		
		
	}

	public void searchFile() {
		FileOperations list = new FileOperations();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the file name");
        String fileName = input.nextLine();
        File filepath1 = new File("//home//"+fileName);
        File filepath2 = new File("//home//ubuntu//"+fileName);
        File filepath3 = new File("//home//ubuntu//eclipse-workspace//"+fileName);
        
        File filepath4 = new File("//home//ubuntu//eclipse-workspace//LockedMeApplication//"+fileName);
       File filepath5 = new File("//home//ubuntu//eclipse-workspace//LockedMeApplication//database//"+fileName);
      File filepath6 = new File("//home//ubuntu//eclipse-workspace//LockedMeApplication//users//"+fileName);  
          
        if(filepath1.exists()) {
        	System.out.println("File exists by name : "+ filepath1.getName());
        	System.out.println("Path of the file is "+filepath1.getAbsolutePath());
        }else if(filepath2.exists()) {
        	System.out.println("File exists by name : "+ filepath2.getName());
        	System.out.println("Path of the file is "+filepath2.getAbsolutePath());
        }else if(filepath3.exists()) {
        	System.out.println("File exists by name : "+ filepath3.getName());
        	System.out.println("Path of the file is "+filepath3.getAbsolutePath());
        }else if(filepath4.exists()) {
        	System.out.println("File exists by name : "+ filepath4.getName());
        	System.out.println("Path of the file is "+filepath4.getAbsolutePath());
        }else if(filepath5.exists()) {
        	System.out.println("File exists by name : "+ filepath5.getName());
        	System.out.println("Path of the file is "+filepath5.getAbsolutePath());
        }else if(filepath6.exists()) {
        	System.out.println("File exists by name : "+ filepath6.getName());
        	System.out.println("Path of the file is "+filepath6.getAbsolutePath());
        }else {
        	System.out.println("File does not exists by name : "+fileName);
        }
		System.out.println("");
		System.out.println("***********************************");
		System.out.println("Enter the operation number that you want to perform");
		list.fileOperationList();

	}

}
