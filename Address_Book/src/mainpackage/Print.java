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

public class Print extends Main{

	private static Print instance = new Print();

	ReadContacts readContacts = new ReadContacts();

	private ArrayList<ArrayList<String>> line_data = new ArrayList<ArrayList<String>>();

	public void setLine_data() {
		this.line_data = readContacts.getLine_data();
	}

	private Print()
	{

	}

	public static Print getInstance() {
		return instance;
	}

	public void show_contacts() throws IOException, FileNotFoundException{

		for(int i=0;i<line_data.size();i++)
		{
			for (int j=0;j<line_data.get(i).size();j++)
			{
				System.out.print(
						line_data.get(i).get(j) + "\t\t\t\t"
				);
			}
			System.out.println("");

		}
		
	}
}
