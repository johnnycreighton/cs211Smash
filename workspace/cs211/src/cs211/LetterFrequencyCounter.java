package cs211;
import java.util.*;
public class LetterFrequencyCounter 
{
	
	
//	**************************************************************************************************************
	//CODE WAS BUILT BY ME ON A LINUX OS AND THUS HAS CERTIAIN PROBLEMS WITH RUNING ON WINDOWS//
	
//	**************************************************************************************************************
	
	
            public static void main(String[] args)
            {
                System.out.println("Document is loading, please stand by....");
                Fileio reader = new Fileio();
                String mystery[]= reader.load("X://COLLEGE2NDYEAR/semester2/CS211/dict.txt");
                double counter = 0;
 //               int counter3 = 0;
                double total = 0;
                int mant[] = new int[65534];      //an array to store all the frequencies
                String bigram[] = new String[mystery.length];
               
                for(int i = 0; i<mystery.length-1;i++)
                {
                    for(int j  = 0; j<mystery[i].length()-1;j++)
                    {
                        bigram[j] = mystery[i].charAt(j)+""+mystery[i].charAt(j+1);   
                    }
                    //System.out.println(mystery[i]);
                }
//                System.out.println(counter3+"    &&&&");
//                for(int i =0 ; i <bigram.length-1;i++)
//                {
//                    if(!(bigram[i]== null))
//                    {
//                        System.out.println(bigram[i]);
//                    }
//                }
               
                System.out.println();
                System.out.println();
                System.out.println();
               
//                for(int i =0; i<bigram.length;i++)
//                {
//                    if(bigram[i]!=null)
//                    {
//                        System.out.println(bigram[i]);
//                    }
//                }
                System.out.println(mystery.length);
               
                for(int i=0; i < mystery.length; i++)
                {   
                    for(int j=0; j < mystery[i].length(); j++)
                    {   
                        mant[(int)mystery[i].charAt(j)]++;    //increment the appropriate frequencies
                        counter++;
                    }

                }
               
               
               
System.out.println(counter);// comment: thiw iw ffor
           
               
//counter = counter-216555;
int counter2=0;
           
          mergeSort(mant);  //working but losing precision on visuals
                for(int i=0; i<mant.length; i++)        //looping through frequency array to print out how many times individual letters were used
                {
                    if(mant[i]>0)                        //print out non-zero frequencies - cast to a char
                    {
//                        if(mant[i]==216555)//taking out spaces,known capitals and full stops HACKKKK
//                        {
//                           
//                        }
//                        else
//                        {
                        System.out.println("'"+(char)i+"'appeared "+mant[i]+((mant[i] == 1) ? " time " : " times    ")+"       frequency = "+(100/counter*mant[i]));
                        total += (100/counter*mant[i]);
                        counter2++;
                      //  }
                       
                    }
                }
                System.out.println(total);
                System.out.println("There are "+counter2+" unique characters!!! ");
               
            }
       

public static void mergeSort(int[] ar)
{
    if (ar.length >= 2) {
        int[] left = new int[ar.length / 2];
        int[] right = new int[ar.length-ar.length / 2];

        for (int i = 0; i < left.length; i++)
        {
            left[i] = ar[i];
        }
        for (int i = 0; i < right.length; i++)
        {
            right[i] = ar[i + ar.length / 2];
        }
        mergeSort(left);
        mergeSort(right);

        merge(ar, left, right);
    }
}

public static void merge(int[] workspace, int[] left, int[] right)
{
    int x = 0;
    int y = 0;
    for (int i = 0; i < workspace.length; i++)
    {
        if (y >= right.length || (x < left.length && left[x] >(right[y])))

        {
            workspace[i] = left[x];
            x++;
        }
        else
        {
            workspace[i] = right[y];
            y++;
        }
    }
}
}
	

