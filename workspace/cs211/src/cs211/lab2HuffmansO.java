package cs211;
import java.util.*;

public class lab2HuffmansO 
{
	private static int counter;
	public static void main(String[] args) 
	{
		Scanner input  = new Scanner(System.in);
		int  mant[] = new int [256];
		int[] mant2 = new int[256];


		System.out.println("Please enter a line of text to compresss:\n");
		String s1 = input.nextLine(); //take in user input and store in s1
		input.close(); //closing scanner
		int ascii;

		for(int i = 0;i<s1.length();i++) /*loop to cast all my characters to ascii value integers*/
		{
			ascii = (int)s1.charAt(i);
			mant[ascii]++; 						//increment the index of the ascii value in my first array
			System.out.print(ascii+" ");		//for referencing sake
		}
		
		for(int i = 0;i<mant.length;i++) /*loop to cast all my characters to ascii value integers*/
		{
			if(mant[i]>0)
			{
				counter++; 			//getting the amount of unique characters and storing in counter, to be used later
			}
					
		}

		for(int i = 32;i<mant2.length;i++) //incrementing my parallel array ///////starting a
		{
			mant2[i] = i;					//mant2 is my parallel array , here i am simply mapping its index to what is in stored in it,
			//example position 101 in my array will hold the value 101;
			//this will make the sorting a lot easier
		}

		mant2 = bubbleSort(mant, mant2);	//sending my two arrays down to bubble sort ----see below----
		System.out.println();
		//mant = bubbleSort(mant, mant2);

		for(int i = 0; i<=counter;i++)//running the length counter.
		{
			if(mant2[i] == 0)
			{
				//doing nothing if it encounters a zero.
			}
			else
			{
				System.out.print((char)(mant2[i]));		//casting back to characters as I print and boom!

			}
		}
	}



		public static int[] bubbleSort(int [] array, int [] array1)
		{
			int temp = 0;
			int temp1 = 0;


			for(int i =0;i<array.length;i++)
			{
				for(int j = 1;j<array.length-1;j++)
				{
					if(array[j]<array[j+1])
					{
						temp = array[j];
						array[j] = array[j+1];   	//this is sorting my first array in ascending order.
						array[j+1] = temp;

						temp1 = array1[j];
						array1[j] = array1[j+1];	//here i am sorting my second array by mimicking the first arrays position.
						array1[j+1] = temp1;
					
					}	
				}
			}
			return (array1);						//only returning the array i want and storing it back into mant2;
		}


	}