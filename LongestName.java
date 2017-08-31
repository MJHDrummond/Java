/*
  Second small program used to practice loops and arrays.

  Author: McGregor Drummond.
  Date/Finished: 31 August 2017.
 */

import java.util.Scanner;

public class LongestName {

	public static void main(String[] args) {
	    
        longestName(new Scanner("roy\nDANE\nErik\nsTeFaNiE\nLaurA\n"), 5);
	}

	public static void longestName(Scanner console, int n) {

      //loop to assign given names to an array and find name/string lengths
	    String[] array = new String[n];
	    int[] strLen = new int[n];
	    for (int i = 0; i < n; i++) {
	        System.out.print("name #" + (i+1) + "? ");
	        array[i] = console.nextLine();
	        strLen[i] = array[i].length();
	    }
      
      //loop to find the longest name in the list
	    int max = strLen[0];	    
	    for (int i = 0; i < n; i++) {
	        if (strLen[i] >= max) {
	            max = strLen[i];
	            String maxName = array[i];
	        }
	    }
	   
      //loop to print the longest name
	    int counter = 0;
	    for (int i = 0; i < n; i++) {
	        if (strLen[i] == max) {
	            counter++;
              //format longest name to make it look nice
	            String maxName = array[i].substring(0,1).toUpperCase() + array[i].substring(1).toLowerCase();
              
	            if (counter > 1) {
	                System.out.println("(There was a tie! First occuring longest name has been printed.)");
	                break;
	            }
              
	            System.out.println(maxName + "'s name is longest");	        
	         }
	    }	    
	 }
}
