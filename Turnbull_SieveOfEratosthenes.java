//Thessalonica Turnbull
//Spring 2023 Advanced Java
//Sieve of Eratosthenes
//Created February 10, 2023
//
//takes command line parameters or not Command line parameters to get start value and stop value
//

import java.util.Arrays;
import java.util.Scanner;

public class Turnbull_SieveOfEratosthenes 
{
	public static void displayArray(Boolean[] array)
	{
		for(int i = 0; i < array.length; i++)
		{  
	        System.out.print(array[i] + " ");
		}
	}
	
	public static void main(String[] args)
	{
		//declare variables
		int start = 0;
		int stop = 0;
		Scanner s = new Scanner(System.in);
			
		// Assign input values from command line arguments if provided, otherwise prompt the user for input
	    if (args.length >= 2) 
	    {
	    	System.out.println("Extra parameters ignored...");
	    	System.out.println(" ");
	    	System.out.println("Hello User!");
	    	start = Integer.parseInt(args[0]);
	    	stop = Integer.parseInt(args[1]);
	    }
	    
	    if (args.length < 2) 
	    {	
				
	    	System.out.print("Not enough or too few parameters entered into command line prompt.");
	    	System.out.println(" ");
	    	System.out.println("Hello User!");
	    	System.out.print("Please enter a start value number greater than 1: ");
			start = Integer.parseInt(s.nextLine());
			System.out.print("Please enter a stop value number greater than the start value: ");
			stop = Integer.parseInt(s.nextLine());
			
			if (stop < start)
			{
				System.out.println("Stop value must be larger than the start value.");
				s.close();
				return;
			}
	    }
		
	    //create array of numbers, fill all true
	    //cycle through to assign falses
	    Boolean theArray[] = new Boolean[stop + 1];
	    Arrays.fill(theArray, true);
//	    int sqrtOfStop = (int)(Math.sqrt(stop));
	    int count = 0;
	    
//	    for (int k = 2; k <= sqrtOfStop; k++) //tried this per video but I kept getting the wrong number of counts in return when doing 1k+ arrays
	    for (int k = 2; k <= stop / k; k++)
	    {
		    if (theArray[k]) 
		    {
			    for (int i = k; i <= stop / k; i++) 
			    {
			    	theArray[k * i] = false; 
			    }
		    }
	    }
	    
    	
    	//count how many prime numbers
    	for (int i = start; i < theArray.length; i++) 
    	{
	    	if (theArray[i]) 
	    	{
	    		if (i >= start)
	    			{
	    				count++;
	    			}
	    	}
	    }
	    	
	    System.out.println("\nThere are " + count + " prime(s) between the numbers " + start + " and " + stop);
	    System.out.println("Thank you!");
	    
		//closes all
		s.close();
		return;
	}
}