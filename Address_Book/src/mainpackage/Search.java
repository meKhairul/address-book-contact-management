package mainpackage;

import java.util.*;
import java.util.Arrays;
import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;


public class Search {

	private ReadContacts readContacts = new ReadContacts();

	private ArrayList<ArrayList<String>> line_data = new ArrayList<ArrayList<String>>();

	public void setLine_data() {
		this.line_data = readContacts.getLine_data();
	}

	private static Search instance = new Search();

	private Search()
	{

	}

	public static Search getInstance() {
		return instance;
	}

	public int choose_field() throws FileNotFoundException, IOException {
		Scanner input = new Scanner(System.in);
		int exit = 0;
		int answer;
		//we will loop until user wants to exit the application
		do {
			System.out.println("Do you want to search beased on name or based on phone?");
			System.out.println("Give '1' or '2' or anser '0' to return to main menu.");	
			try {
				answer = input.nextInt();
			} catch (Exception e) {
				answer = 0;
			}
			return answer;
							
		}while(answer != exit);
	}
	
	public ArrayList<String> name_search(ArrayList<ArrayList<String>> line_data) {

		Scanner input = new Scanner(System.in);
		String name, surname;
		System.out.println("Give Name: ");
		name = input.nextLine();
		System.out.println("Give Surname: ");
		surname = input.nextLine();

		for (int i = 1; i < line_data.size(); i++) {
			boolean isfoundName = line_data.get(i).get(0).equals(name);
			boolean isfoundSurname = line_data.get(i).get(1).equals(surname);
			if (isfoundName && isfoundSurname) {
				System.out.println("----There is a contact for the information you gave----");
				for (int j = 0; j < line_data.get(i).size(); j++) {
					System.out.println(line_data.get(0).get(j) + ": " + line_data.get(i).get(j));
				}
			} else if (isfoundName && !isfoundSurname) {
				System.out.println("----There is a contact for the Name you gave----");
				for (int j = 0; j < line_data.get(i).size(); j++) {
					System.out.println(line_data.get(0).get(j) + ": " + line_data.get(i).get(j));
				}
				return line_data.get(i);
			}

		}
//		File file = new File(System.getProperty("user.dir")+"/Address_Book/src/contacts.txt");
//		BufferedReader reader = new BufferedReader(new FileReader(file));
//		String currentLine;
//		boolean first = false;
//		String[] fields = new String[0];
//		while((currentLine = reader.readLine()) !=null) {
//			if(!first) {
//				fields = currentLine.split(",");
//				first = true;
//			}
//			else {//if both fields that the user gave match a contact i show contact's info
//				String[] info=currentLine.split(",");
//				if(info[0].equals(f1) && info[1].equals(f2)) {
//					System.out.println("----There is a contact for the information you gave----");
//					for (int i = 0; i < fields.length; i++ ) {
//						System.out.println(fields[i] +": "+ info[i]);
//					}
//				}
//				else if(info[0].equals(f1) && !info[1].equals(f2)) {//if one of the fields that the user gave match a contact i show contact's info
//					System.out.println("----There is a contact for the Name you gave----");
//					for (int i = 0; i < fields.length; i++ ) {
//						System.out.println(fields[i] +": "+ info[i]);
//					}
//				}
//				else if(!info[0].equals(f1) && info[1].equals(f2)) {//if one of the fields that the user gave match a contact i show contact's info
//					System.out.println("----There is a contact for the Surname you gave----");
//					for (int i = 0; i < fields.length; i++ ) {
//						System.out.println(fields[i] +": "+ info[i]);
//					}
//				}
//
//			}
//		}
//		System.out.println("-------------------");
//		reader.close();
//		choose_field();
		return null;
	}
	
	public ArrayList<String> number_search(ArrayList<ArrayList<String>> line_data) {
		Scanner input = new Scanner(System.in);
		int phone = -1;
		int mobile = -1;
		boolean valid;
		List<String> lines = new ArrayList<String>();
		System.out.println("Give Phone number: ");
		phone = Integer.parseInt(input.nextLine());

		System.out.println("Give Mobile number: ");
		mobile = Integer.parseInt(input.nextLine());

		for (int i = 1; i < line_data.size(); i++) {
			boolean isfoundPhone = line_data.get(i).get(2).equals(phone);
			boolean isfoundMobile = line_data.get(i).get(3).equals(mobile);


			if (isfoundPhone && isfoundMobile) {
				String line = "";
				System.out.println("----There is a contact for the information you gave----");
				for (int j = 0; j < line_data.get(i).size(); j++) {
					line += line_data.get(i).get(j);
					System.out.println(line_data.get(0).get(j) + ": " + line_data.get(i).get(j));
					return line_data.get(i);
				}
			}
		}
	}

//		Scanner input= new Scanner(System.in);
//		int f1 = -1;
//		int f2 = -1;
//		boolean valid;
//		System.out.println("Give Phone number: ");
//		do {//this is a do-while loop in which I check for valid input (must me integer)
//			valid = true;
//			try {
//			    f1 = Integer.parseInt(input.nextLine());
//			} catch (NumberFormatException e) {
//			    //e.printStackTrace();
//				System.out.println("Phone number must be number.");
//				valid = false;
//			}
//		}while(valid == false);
//		System.out.println("Give mobile number: ");
//		do {
//			valid = true;
//			try {
//			    f2 = Integer.parseInt(input.nextLine());
//			} catch (NumberFormatException e) {
//			    //e.printStackTrace();
//				System.out.println("Mobile number must be number.");
//				valid = false;
//			}
//		}while(valid == false);
//		File file = new File(System.getProperty("user.dir")+"/src/contacts.txt");
//		BufferedReader reader = new BufferedReader(new FileReader(file));
//		String currentLine;
//		boolean first = false;
//		String[] fields = new String[0];
//		if(f1 == -1 && f2 == -1) {
//			System.out.println("-------------------");
//			System.out.println("You gave wrong information.");
//		}
//		else {
//			while((currentLine = reader.readLine()) !=null) {
//				if(!first) {
//					fields = currentLine.split(",");
//					first = true;
//				}
//				else {//if any of the user's inputs match a contact i show the contact's info
//					String[] info=currentLine.split(",");
//					if(f1 == -1 && f2 != -1) {
//						if(info[3].equals(String.valueOf(f2))) {
//							System.out.println("----There is a contact for the Mobile number you gave----");
//							for (int i = 0; i < fields.length; i++ ) {
//								System.out.println(fields[i] +": "+ info[i]);
//							}
//						}
//					}
//					else if(f1 != -1 && f2 == -1) {
//						if(info[2].equals(String.valueOf(f1))) {
//							System.out.println("----There is a contact for the Phone number you gave----");
//							for (int i = 0; i < fields.length; i++ ) {
//								System.out.println(fields[i] +": "+ info[i]);
//							}
//						}
//					}
//					else if (f1 != -1 && f2 != -1) {
//						if(info[2].equals(String.valueOf(f1)) && info[3].equals(String.valueOf(f2))) {
//							System.out.println("----There is a contact for the Phone and Mobile number you gave----");
//							for (int i = 0; i < fields.length; i++ ) {
//								System.out.println(fields[i] +": "+ info[i]);
//							}
//						}
//						else if(info[2].equals(String.valueOf(f1)) && !info[3].equals(String.valueOf(f2))) {
//							System.out.println("----There is a contact for the Phone number you gave----");
//							for (int i = 0; i < fields.length; i++ ) {
//								System.out.println(fields[i] +": "+ info[i]);
//							}
//						}
//						else if(!info[2].equals(String.valueOf(f1)) && info[3].equals(String.valueOf(f2))) {
//							System.out.println("----There is a contact for the Phone number you gave----");
//							for (int i = 0; i < fields.length; i++ ) {
//								System.out.println(fields[i] +": "+ info[i]);
//							}
//						}
//					}
//				}
//			}
//		}
//
//		System.out.println("-------------------");
//		reader.close();
		return null;
	}


}
