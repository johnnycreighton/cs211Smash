package cs211;
import java.io.*;
import java.util.*;               // for Stack class

public class FullCompressionProgram 
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.print("Enter your sentence: ");
		String sentence = input.nextLine();
		String binaryString="";      //this stores the string of binary code


		for(int i=0; i < sentence.length(); i++)
		{        //go through the sentence
			int decimalValue = (int)sentence.charAt(i);      //convert to decimal
			String binaryValue = Integer.toBinaryString(decimalValue);      //convert to binary
			for(int j=7;j>binaryValue.length();j--)
			{
				binaryString+="0";           //this loop adds in those pesky leading zeroes
			}
			binaryString += binaryValue+" "; //add to the string of binary
		}
		System.out.println(binaryString);    //print out the binary


		int[] array = new int[256];      //an array to store all the frequencies

		for(int i=0; i < sentence.length(); i++)
		{    //go through the sentence
			array[(int)sentence.charAt(i)]++;    //increment the appropriate frequencies     
		}


	//	PriorityQueue < Tree >  PQ = new PriorityQueue < Tree >() ;  //make a priority queue to hold the forest of trees    


		for(int i=0; i<array.length; i++) //go through frequency array
		{     
			if(array[i]>0)
			{ //print out non-zero frequencies - cast to a char
				System.out.println("'"+(char)i+"' appeared "+array[i]+((array[i] == 1) ? " time" : " times"));

				//FILL THIS IN:

				//MAKE THE FOREST OF TREES AND ADD THEM TO THE PQ

				//create a new Tree 
				//set the cumulative frequency of that Tree
				//insert the letter as the root node 
				//add the Tree into the PQ

			}
		}


		//while(PQ.size()>1)
	//	{             //while there are two or more Trees left in the forest

			//FILL THIS IN:

			//IMPLEMENT THE HUFFMAN ALGORITHM

			//when you're making the new combined tree, don't forget to assign a default root node (or else you'll get a null pointer exception)
			//if you like, to check if everything is working so far, try printing out the letter of the roots of the two trees you're combining
	//	}

		//Tree HuffmanTree = PQ.poll();   //now there's only one tree left - get its codes


		//FILL THIS IN:

		//get all the codes for the letters and print them out
		//call the getCode() method on the HuffmanTree Tree object for each letter in the sentence

		//print out all the info

	}      
}

/*
 * 
 * 	%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 * 
 * 
 * 
// */
//public class Tree implements Comparable<Tree>
//{
//	public Node root;             // first node of tree
//	public int frequency=0;
//
//
//	public Tree()                  // constructor
//	{   
//		root = null; 			   // no nodes in tree yet
//	}         
//
//
//	//the PriorityQueue needs to be able to somehow rank the objects in it
//	//thus, the objects in the PriorityQueue must implement an interface called Comparable
//	//the interface requires you to write a compareTo() method so here it is:
//
//	public int compareTo(Tree object)
//	{ //
//		if(frequency-object.frequency>0)
//		{ //compare the cumulative frequencies of the tree
//			return 1;
//		}
//		else if(frequency-object.frequency<0)
//		{
//			return -1;   //return 1 or -1 depending on whether these frequencies are bigger or smaller
//		}else
//		{
//			return 0;   //return 0 if they're the same
//		}
//	}
//
//
//
//	String path="error";     //this variable will track the path to the letter we're looking for 
//
//	public String getCode(char letter) //we want the code for this letter
//	{ 
//
//		//FILL THIS IN:
//
//		//How do you get the code for the letter? Maybe try a traversal of the tree
//		//Track the path along the way and store the current path when you arrive at the right letter
//
//		return path;     //return the path that results
//
//	}
//
//}  
///*
// * 
// * 	%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
// * 
// * 
// * 
// */
class Node
{
	
	public char letter;            //stores letter
	public Node leftKid;         // this node's left child
	public Node rightKid;        // this node's right child
	
	Node(char letter)
	{
		this.letter = letter;
		rightKid = null;
		leftKid = null;
	}
	
	  public void setLetter(char Letter) 
	  {
	        this.letter = letter;
	    }

	    public int getletter() 
	    {
	        return letter;
	    }

	    public void setLeftkid(Node left) 
	    {
	        this.leftKid = left;
	    }

	    public Node getLeftKid() 
	    {
	        return leftKid;
	    }

	    public void setRightKid(Node right ) 
	    {
	        this.rightKid = right;
	    }

	    public Node getRightKid() {
	        return rightKid;
	    }
		
}
  // end class Node

