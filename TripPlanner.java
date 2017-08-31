/*
  First Java program created to practice Scanner inputs and method statements
  with some Math thrown in at the end.
  
  Author: McGregor Drummond
  Date/Finished: 29 August 2017
 */

import java.util.Scanner;

public class TripPlanner {
	public static void main(String[] args) {
		System.out.println("Welcome to the Vacation Planner!");
		greeting();
		budget();
		timezone();
		landarea();
		distance();
	}
    
	public static void greeting() {
		Scanner input = new Scanner(System.in);
		System.out.print("What is your name? ");
		String name = input.nextLine();
		System.out.print("Nice to meet you " + name + ", where are you travelling to? ");
		String location = input.nextLine();
		System.out.println("Great! " + location + " sounds like a great trip.");
		breaker();
    input.close();
	}
	
	public static void budget() {
		Scanner input = new Scanner(System.in);
		System.out.print("How many days are you going to spend travelling? ");
		int duration = input.nextInt();
		System.out.print("How much money, in EUR, are you planning to spend on your trip? ");
		double money = input.nextDouble();
		System.out.print("What is the three letter currency symbol for your travel destination? ");
		String currency = input.next();
		System.out.print("How many " + currency + " are there in 1 EUR?  ");
		double exchange = input.nextDouble();
		System.out.println("");
		System.out.println("If you are travelling for " + duration + " days, that is the same as " + duration*24 + " hours or " + duration*24*60 + " minutes.");
		System.out.println("If you are going to spend " + money + " EUR, that means per day you can spend up to " + ((int) (money/duration)*100)/100.0 + " EUR.");
		System.out.println("Your total budget in " + currency + " is " + money*exchange + " " + currency + ", which per day is " + ((int) (money*exchange/duration)*100)/100.0 + " " + currency);
		breaker();
    input.close();
		}
	
	public static void timezone() {
		Scanner input = new Scanner(System.in);
		System.out.print("What is the time difference, in hours, between your home and your destination? ");
		int tdiff = input.nextInt();
		System.out.println("That means that when it is midnight at home it will be " + (24+tdiff) % 24 + ":00 in your travel destination");
    System.out.println("and when it is noon at home it will be " + (12+tdiff) + ":00");
    breaker();
    input.close();
	}
	
	public static void landarea() {
		Scanner input = new Scanner(System.in);
		System.out.print("What is the square area of your destination country in km2? ");
		double areakm = input.nextDouble();
		System.out.println("In miles2 that is " + ((int) (areakm*0.386102)*100)/100.0);
		breaker();
    input.close();
	}
	
	public static void distance() {
		Scanner input = new Scanner(System.in);
		System.out.println("We are going to calculate the distance between your home and destination. Enter values in degrees.");
		System.out.print("What is the longitude of your home? ");
		double longHome = input.nextDouble();
		System.out.print("and the latitude of your home? ");
		double latHome = input.nextDouble();
		System.out.print("What is the longitude of your destination? ");
		double longDest = input.nextDouble();
		System.out.print("and the latitude of your destination? ");
		double latDest = input.nextDouble();
		System.out.println("");		
		
    //convert longs/lats to radians
		double radLongHome = Math.toRadians(longHome);
		double radLatHome = Math.toRadians(latHome);
		double radLongDest = Math.toRadians(latDest);
		double radLatDest = Math.toRadians(longDest);
		double delLong = radLongDest - radLongHome;
		double delLat = radLatDest - radLatHome;		
		double r = (6356.7 + 6378.1)/2; //approx radius of Earth
		
    //calculate elements of haversine function
		double sinLat = Math.sin(delLat/2.0);
		double sinLatSquared = Math.pow(sinLat, 2);
		double sinLong = Math.sin(delLong/2.0);
		double sinLongSquared = Math.pow(sinLong, 2);
		double cosLatHome = Math.cos(radLatHome);
		double cosLongHome = Math.cos(radLatDest);
		double squareRoot = Math.sqrt(sinLatSquared + cosLatHome*cosLongHome*sinLongSquared);
		double arcSin = Math.asin(squareRoot);
		
    //finally calculate the distance between locations
		double d = 2*r*arcSin; 
		System.out.println("The distance between home and destination is " + ((int) d*100)/100.0 + " km");
		breaker();
    input.close();
	}
		
	public static void breaker() {
		System.out.println("************");
		System.out.println("");
	}
}
