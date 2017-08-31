/*
  Fun program to further practice methods and statements.
  I also played with sharing variables across methods which
  took a while to figure out but successfully compiled in the end.
  
  Author: McGregor Drummond.
  Date/Finished: 31 August 2017.
*/

import java.util.*;

public class OddsAndEvens {

	private String name; //variables to be shared across methods
	private String side;
	
	public static void main(String[] args) {
    
		Scanner input = new Scanner(System.in);
		OddsAndEvens oddEven = new OddsAndEvens();
        
		System.out.println("Let's play a game called \"Odds and Evens\".");
        
		System.out.print("What is your name? "); //request player name
		oddEven.name = input.nextLine();
		System.out.println("Hi " + oddEven.name);
        
		oddEven.chooseSides(); //call methods
		oddEven.playTheGame();
		
		System.out.println("Thanks for playing " + oddEven.name + "!");
	}
	
	public void chooseSides() {
  
		Scanner input = new Scanner(System.in);    
		System.out.print("Which do you choose? (O)odds or (E)vens? "); //request side to play
		side = input.next();
		
        //statements returning chosen sides
		if (side.equalsIgnoreCase("o")) {
		  	System.out.println(name + " has chosen odds! Computer will be evens.");
		  	System.out.println("----------------------------------------");

		} else if (side.equalsIgnoreCase("e")) {
		  	System.out.println(name + " has chosen evens! Computer will be odds.");
		  	System.out.println("----------------------------------------");

		} else {
		  	System.out.println("Wrong input character, rechoose!");
		  	System.out.println("Re-enter name: ");
		  	chooseSides();
		}
	}
	
	public void playTheGame() {
    
		Scanner input = new Scanner(System.in);
		System.out.print("How many \"fingers\" do you put out? "); //request number of fingers to play
		int fingers = input.nextInt();
        
		Random rand = new Random(); //computer fingers chosen at random
		int computer = rand.nextInt(6);
		System.out.println("The computer has played " + computer + " fingers.");
		System.out.println("----------------------------------------");

		int result = computer + fingers; //calculate sum of fingers
		System.out.println(fingers + " + " + computer + " = " + result);
		
        //statements to determine the winner and print to console
		boolean oddOrEven = result % 2 == 0; 
		if (oddOrEven == true) {
			System.out.println(result + " is ...even!");
            
			if (side.equalsIgnoreCase("e")) {
				System.out.println("That means " + name + " wins!");
			} else {
				System.out.println("The computer wins!");
			}
            
		} else {
			System.out.println(result + " is ...odd!");
            
			if (side.equalsIgnoreCase("o")) {
				System.out.println("That means " + name + " wins!");
			} else {
				System.out.println("The computer wins!");
			}
		}
        
		System.out.println("----------------------------------------");
		}
	}
	
