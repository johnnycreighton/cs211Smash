package cs211;

import java.util.*;

public class LinkedListTry2 

{

	public static void main(String args[] ) throws Exception 
	{
		Scanner input = new Scanner(System.in);
		int num = Integer.parseInt(input.nextLine());
		Link[] array = new Link[num];
		for(int i=0;i<num;i++)
		{
			array[i]=new Link(input.nextLine());    
		}
		while(input.hasNext())
		{
			int select=input.nextInt();
			int previous=input.nextInt();
			int next=input.nextInt();
			if(previous!=-1)
			{
				array[select].previous=array[previous];
			}
			if(next!=-1)
			{
				array[select].next=array[next];
			}
		}
		LinkedList mylist = new LinkedList();
		if(num>0)
		{
			mylist.first=array[0];
			mylist.last=array[num-1];
		}
		System.out.println(check(mylist));
	}


	public static String check(LinkedList mylist)
	{
		/* return TRUE or FALSE depending on whether mylist is properly linked or not*/

		if(mylist.isEmpty())

			return "FALSE";

		else 
			return "TRUE";
	}


}


class Link{
	public String data;
	public Link next;
	public Link previous;

	public Link(String input){
		data=input;
		next=null;
		previous=null;
	}
}

class LinkedList {
	public Link first;
	public Link last;

	public LinkedList( ){
		first=null;
		last=null;
	}

	public boolean isEmpty( ){
		return (first==null);
	}

	public void insertHead(Link insert){
		if(isEmpty()){
			first=insert;
			last=insert;
		}else{
			first.previous=insert;
			insert.next=first;
			first=insert;
		}
	}
}
