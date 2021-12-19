import java.util.Scanner;
/**
 *
 * @author charlie.weber
 * @version 1.0.0
 * 
 * Example of the scanner reading input and passes it off to the x object
 *
 */


public class Scan {
	
	public static boolean isDouble (String possibleDouble) {
		boolean isDoubleResult = true;
		
		try {
			Double.parseDouble(possibleDouble);
		} catch (NumberFormatException e) {
			isDoubleResult = false;
		}
		return isDoubleResult;
	}
	
	public static void main (String [] args) {
		
		Scanner myInput = new Scanner (System.in);
		System.out.print("What is your First Name : ");
		
		String firstName = myInput.nextLine();
		
		System.out.println("First Name is : " + firstName);
		
		
		double latestPurchase = 0.00;
		String tempLatestPurchase = "";
		
		do {
		
			System.out.print("What was the amount in dollars and cents of your latest purchase : $ ");
			
			tempLatestPurchase = myInput.nextLine();
			 // System.out.println("Is your entry a valid double? " + isDouble(tempLatestPurchase) );
			
			if (isDouble(tempLatestPurchase)) {
				latestPurchase = Double.parseDouble(tempLatestPurchase);
			} else {
				System.out.println("Sorry, your entry was invalid for dollars in cents. Please enter in dd.cc ");
			}
			
		} while (!isDouble(tempLatestPurchase) );
		
		
		System.out.println ("Successfully done!");
		
		
		myInput.close();
		
	}
}
