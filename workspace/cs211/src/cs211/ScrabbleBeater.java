package cs211;
import java.util.*;

public class ScrabbleBeater 
{

	public static void main(String[] args) 
	{
		Fileio reader = new Fileio();
		int counter = 0;
		Scanner input = new Scanner(System.in);

		String mant[] = reader.load("X:/COLLEGE2NDYEAR/semester2/CS211/dict.txt");    //Reading the File as a String array
		for(int i=0;i<mant.length;i++)
		{
			//System.out.println(mant[i]);
			counter++;
		}
		mergeSort(mant);

		System.out.println("There are "+counter+" words in this dictionary");

		//****************************************************************************************************************************
		//problem solving starts here 
		System.out.println("Input your letters cheater......");
		String ScrabbleLetters = input.next();
		input.close();
		String mant2[] = new String[10];
		Boolean keepGoing = true;
		String dictWord; 
		String character;
		String dictWord2;
		int count;
		int w =0;
		String dictWord3 =null;
		String found[] = new String[mant.length-1];

		for(int i =0; i<mant.length;i++)
		{
			dictWord = mant[i];
			dictWord2 = dictWord;

			//character = dictWord.substring(i, i);
			//System.out.println(character);
			//break;
			if(dictWord2.length()-1<dictWord.length())
			{
				i++;
			}
			else
			{
				
			for(int j =0; j<dictWord.length();j++)
			{
				for(int k =0;k<dictWord2.length();k++)
				{
					if(dictWord.charAt(j)==dictWord2.charAt(k))
					{
						char [] dict2Words = dictWord2.toCharArray();
						dict2Words[k] ='*';
						dictWord2 = String.valueOf(dict2Words);
						count=0;

						char [] dictWords = dictWord.toCharArray();
						dictWords[k] ='-';
						dictWord = String.valueOf(dict2Words);

						for(int q= 0; q<dictWord2.length(); q++)
						{
							if(dictWord.charAt(q)=='*')
							{
								count++;
								if(count==dictWord.length()-1)
								{
									found[w] = dictWord2;
									w++;
								}
							}
						}

					}
				}
			}

		}
	}
		for(int i=0;i<found.length;i++)
		{
			System.out.println(found[i]);
		
		}
}



////			for(int j =0;j<ScrabbleLetters.length();j++)
//			{
//				if(dictWord.contains(character))
//				{
//					
//				}
//			}

//			
//			if(counter<10)
//			{
//				if(dictWord.contains(ScrabbleLetters))
//				{
//					mant2[counter]=dictWord;
//					counter++;
//				}
//				else
//				{
//				}



//		System.out.println("Your top ten words are:");
//			for(int i =0; i<10;i++)
//			{
//				
//				System.out.println(mant2[i]);
//				
//			}
//			for(int i = 0; i<mant2.length;i++)
//			{
//				System.out.println(mant2[i]);
//			}
//		}
//			for(int i =0;i<10;i++)
//			{
//				if(ScrabbleLetters.contains(mant[i]))
//				{
//					System.out.println(mant[i]+" %");
//
//				}
//				else
//				{
//					System.out.println(mant[i]);
//				}
//				
//			}



public static String stringContainsItemsFromInput(String letters, String dictWord)
{
	for(int i =0; i < dictWord.length(); i++)
	{
		if(letters.contains(dictWord))
		{
			System.out.println(dictWord);
		}
	}
	return null;
}


public static void mergeSort(String mant[]) 
{

	if (mant.length >= 2) {
		String[] left = new String[mant.length / 2];
		String[] right = new String[mant.length-mant.length / 2];

		for (int i = 0; i < left.length; i++)
		{
			left[i] = mant[i]; 
		}
		for (int i = 0; i < right.length; i++)
		{
			right[i] = mant[i + mant.length / 2];
		}
		mergeSort(left);
		mergeSort(right);

		merge(mant, left, right);
	}
}

public static void merge(String[] mant, String[] left, String[] right) 
{
	int x = 0;
	int y = 0;
	for (int i = 0; i < mant.length; i++)
	{
		if (y >= right.length || (x < left.length && left[x].length()>(right[y].length())))

		{
			mant[i] = left[x];
			x++;
		} 
		else 
		{
			mant[i] = right[y];
			y++;
		}
	}
}


}
