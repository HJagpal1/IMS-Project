package com.qa.project.utils;

import java.util.Scanner;

public class Utils {
	
	private Utils() {
		
	}
	public static String getInput() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}
