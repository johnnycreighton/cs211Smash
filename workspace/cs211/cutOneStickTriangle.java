package algorithims;

import java.util.Random;
import java.util.Scanner;

public class cutOneStickTriangle 
{
	/*
	 * The goal is to get the probability of snapping a stick at two random places
	 * that the resulting pieces can be turned into a triangle. I look online to find the 
	 * constraints for a triangle in this sense.
	 * 
	 * If one of the three pieces is greater than half of the stick length then we cannot 
	 * have a triangle of the three pieces.
	 * 
	 * We will use a stick length of 100, and randomly cut it. 
	 */
	static int stick = 100;
		static int piece1;
		static int piece2;
		static int piece3;
		
		public static void main(String [] args)
		{
			Scanner input = new Scanner(System.in); // prompt user
			System.out.println("Enter number of sticks to cut...");
			int sticks = input.nextInt(); // store input
			
			// call and print the probability
			System.out.println("Probability = " + probChecks(sticks));	
			
		} // main
		
		
		
		
		
		
		
		
		
		
		public static int cutting(int length)
		{
			Random rand = new Random(); // create random object
			int cutPoint = rand.nextInt(length + 1) - 1; // +1 ensures we dont pass 0
			 
			return cutPoint;
		} // makeCut
		
		
		
		
		
		
		
		
		public static boolean possTriangle(int len1, int len2, int len3)
		{
			boolean isTriangle = true;
			int midPoint = stick / 2; // the midPoint is 50
			// if two cuts are made below or above the midpoint 
			// a triangle is not possible
			// so if one len is greater than 50 a triangle is not possible
			if((len1 > midPoint || len2 > midPoint || len3 > midPoint))
					isTriangle = false;
			
			return isTriangle;
				
		} // possTriangle
		
		
		
		
		
		
		public static double probChecks(int stickCount)
		{
			int counter = 0; // log current stick
			int triCount = 0; // log number of triangle
			
			while(counter < stickCount)
			{
				System.out.println("\nTriangle #" + counter);
				
				piece1 = cutting(stick);// make first cut
				piece2 = stick - piece1; // piece_2 is remainder after cut
				
				// now find the largest and make the second cut			
				if(piece1 >= piece2)
				{
					piece3 = cutting(piece1); // make second cut from piece_1
					piece1 = piece1 - piece3; // get new piece_1 length
				}
				
				else
				{
					piece3 = cutting(piece2); // make second cut from piece_2
					piece2 = piece2 - piece3; // get new piece_2 length
				} //else				
				
				// print values for piece's
				System.out.println("P1: " + piece1 + "\nP2: " 
							+ piece2 + "\nP3: " + piece3);
				
				boolean isTri = false;
				
				// check if triangle is possible with our random pieces
				if(possTriangle(piece1, piece2, piece3))
				{
					isTri = true; 
					triCount++; // increase triangle count
				} // if
				
				if(isTri)
					System.out.println("##### - is a triangle - ####");
					
				
				// reset values for next triangle
				piece1 = 0;
				piece2 = 0;
				piece3 = 0;		
				
				counter++;
			} // while counter
			
			System.out.println("\ntriCount = " + triCount + "\nstickCount = " + stickCount);
			
			return (double) ((double) triCount / (double) stickCount);
		} // probChecks
	} // Stick_Triangle
