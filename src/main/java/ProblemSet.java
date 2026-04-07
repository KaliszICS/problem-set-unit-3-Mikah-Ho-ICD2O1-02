/**
 * File: Problem Set 1 - Email Validator & Parser
 * Author: Mikah Ho
 * Date Created: March 31, 2026
 * Date Last Modified: April 7, 2026
 */

import java.util.Scanner;

public class ProblemSet {

	public static void main(String args[]) { //input is taken here

		Scanner input = new Scanner(System.in);

		System.out.print("Input two emails: ");
		String emails = input.nextLine();

		String email1 = emails.substring(0, emails.indexOf(","));
		String email2 = emails.substring(emails.indexOf(",") + 2);
		
		System.out.println(email1 + ": " + emailValidator(email1) + "\n" + 
		email2 + ": " + emailValidator(email2));

	}

	public static String emailValidator(String email) { //function used to avoid repetition for multiple emails to be checked

		if (email.length() < 6) { //checking basic email components -- email needs to be at least 6 characters (c@c.cc)
	    
	        return "Invalid: Email too short";
	    }
		
		if (!email.contains("@")) {

			return "Invalid: Missing @";
		}

		if (email.indexOf("@") != email.lastIndexOf("@")) { //checks for single use of @
		
			return "Invalid: Contains multiple @";
		}

		if (email.startsWith(".") || email.startsWith("+") || email.startsWith("_") || //checks if starts or ends with dot, plus or underscore
		email.endsWith(".") || email.endsWith("+") || email.endsWith("_")) { 

			return "Invalid: Starts and/or ends with invalid character(s)";
		}
 
		if (email.contains(" ")) {

			return "Invalid: Contains spaces";
		}

		String local = email.substring(0, email.indexOf("@"));
		String domain = email.substring(email.indexOf("@") + 1);

		if (local.length() < 1) { //local validation

			return "Invalid: Local part too short";
		}
						
		if (local.length() > 64) {

			return "Invalid: Local part too long";
		}

		if (domain.length() < 4) { //domain validation -- domain needs at least 4 characters (c.cc)

			return "Invalid: Domain is too short";
		}

		if (!domain.contains(".")) {

			return "Invalid: Missing dot in domain";
		}

		if (domain.contains("+") || domain.contains("_")) {

			return "Invalid: Invalid character(s) in domain";
		}

		String extension = domain.substring(domain.lastIndexOf(".") + 1);

		if (extension.length() < 2) { //extension validation

			return "Invalid: Domain extension too short";
		}

		if (extension.length() > 6) {

			return "Invalid: Domain extension too long";
		}

		if (domain.equals("gmail.com")) { //gmail normalized (idk what this means)

			return "Valid (Gmail normalized) | Local: " + local + " | Domain: " + domain;
		}

		return "Valid | Local: " + local + " | Domain: " + domain;
	}
}

// here's my random question:
// which artist or song do you listen to that you consider the most underrated?