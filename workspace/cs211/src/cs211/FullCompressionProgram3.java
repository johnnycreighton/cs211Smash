package cs211;
import java.io.*;
import java.util.*;               // for Stack class

public class FullCompressionProgram3 
{
	


	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the sentence you wish to compress: ");
		String sentence = input.nextLine();
		input.close();
		String binaryString="";      //this will store the string of binary code
		double total = sentence.length()*7;
		double huffmanCode = 0;//set a double to find compression %

		
		
		
		
		
		
		
		
		for(int i=0; i < sentence.length(); i++)
		{        //go through the sentence
			int decimalValue = (int)sentence.charAt(i);      //convert to decimal
			String binaryValue = Integer.toBinaryString(decimalValue);      //convert to binary
			for(int j=7;j>binaryValue.length();j--)
			{
				binaryString+="0";           //this loop will add the leading zeros to our binary numbers
			}
			binaryString += binaryValue+" "; //add to the string of binary
		}
		System.out.println(binaryString);    //print out the binary


		int mant[] = new int[256];      //an array to store all the frequencies

		for(int i=0; i < sentence.length(); i++){    //go through the sentence
			mant[(int)sentence.charAt(i)]++;    //increment the appropriate frequencies

		}

		
		
		

		PriorityQueue < Tree >  PQ = new PriorityQueue < Tree >() ;  //make a priority queue to hold the forest of trees    

		
		
		
		

		for(int i=0; i<mant.length; i++)		//looping through frequency array to print out how many times individual letters were used
		{ 
			if(mant[i]>0)						
			{ 
				System.out.println("'"+(char)i+"' appeared "+mant[i]+((mant[i] == 1) ? " time" : " times"));//printing out non-zero frequencies - cast back to a char

				
				
				Tree boom = new Tree();//creating a new Tree
				
				boom.frequency=mant[i];//setting the cumulative frequency of that Tree	
				
				boom.root.letter =(char)i;//insert the letter as the root node 	 
				
				PQ.add(boom);//add the Tree into the PQ

			}
		}
		

		
		

		while(PQ.size()>1)             //while there are two or more Trees left in the forest     
		{    
			Tree tree1 = PQ.remove();//remove first element in queue, set as tree1
			
			Tree tree2 = PQ.remove();//remove second element in queue, set as tree2
			
			Tree newTree = new Tree(tree1,tree2);
			//System.out.println("Tree 1 " + tree1.root.letter+" Tree1: Freq "+ tree1.frequency+"****"+" Tree 2"+tree2.root.letter+ " Tree2: Freq"+ tree2.frequency+"  |  "+" Total Freq "+ newTree.frequency);


			PQ.add(newTree);//make a new tree taking in both removed trees and add it back to the PQ }
		}
		
		
		
		
		
		
			Tree HuffmanTree = PQ.poll();   //now there's only one tree left - get its codes



		
			
			for (int i = 0; i < sentence.length(); i++) 
			{
				System.out.print(HuffmanTree.getCode(sentence.charAt(i))+ " ");//get huffman codes for every letter in the initial String

				huffmanCode = huffmanCode+HuffmanTree.path.length();//get current bit size for compressed string
			}
		   
			
			
			
		System.out.println();
		System.out.print("Size after compression is "+ huffmanCode + " bits divided by "+ total + " bits = ");
		System.out.printf("%.4f",huffmanCode/total*100);
		System.out.print("%");
	}

	
}