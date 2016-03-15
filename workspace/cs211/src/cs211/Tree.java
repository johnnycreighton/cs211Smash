package cs211;

public class Tree implements Comparable<Tree>
{
	public NewNode root;             // first node of tree
	public int frequency=0;

	public Tree()                  
	{  
		root  =  new NewNode(); //create a new empty node
	}  
	
	
	
	
	public Tree(Tree tree1, Tree tree2)
	{  
		root = new NewNode();
		root.leftKid = tree1.root;
		root.rightKid = tree2.root;
		this.frequency = tree1.frequency+tree2.frequency;	
	}    
	
	
	
	public int compareTo(Tree object)
	{ 
		if(frequency-object.frequency>0)//comparing the cumulative frequencies of the tree
		{ 
			return 1;
		}
		else if(frequency-object.frequency<0)
		{
			return -1;   //return 1 or -1 depending on whether these frequencies are bigger or smaller
		}
		else
		{
			return 0;   //return 0 if they're the same
		}
	}

	
	
	String path="";     //this variable will track the path to the letter we're looking for 

	
	
	public String getCode(char letter)//getting code for variable letter
	{  
		inOrderTraversal(root,letter,"");
		return path;     //return the path that results
	}

	
	
	
	private void inOrderTraversal(NewNode root, char letter, String path) 
	{
		if (root != null)
		{
			if (root.letter == letter)//Check to see if the letter stored in the node is the letter wanted, if its true we are done for that letter
			{
				this.path = path;//setting 'path' to the current
			}
			else
			{
				inOrderTraversal(root.leftKid, letter, path + "0");//check left child, add 0 to current path
				inOrderTraversal(root.rightKid, letter, path + "1");//check right child, add 1 to current path
			}
		}
	}

}  