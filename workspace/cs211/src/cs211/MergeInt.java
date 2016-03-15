package cs211;
import java.util.*;
public class MergeInt 
{
		//integerMergeSort
	
		public static void main(String[] args) 
		
		{
			
		}
		
		public static void mergeSort(int[] numbers)
		{
			if(numbers.length>=2)
			{
				int []left = new int[numbers.length/2];
				int []right = new int[numbers.length-numbers.length/2];

				for(int i = 0;i<left.length;i++)
				{
					left[i] = numbers[i];
				}
				for(int i = 0;i<right.length;i++)
				{
					right[i] = numbers[i+numbers.length/2];
				}
				mergeSort(left);
				mergeSort(right);
				merge(numbers,left,right);
			}
		}
		
		public static void merge(int[] numbers, int[] left, int[] right) 
		{
			int a = 0;
			int b = 0;
			for(int i = 0;i<numbers.length;i++)
			{
				if(b>=right.length || (a<left.length && left[a]<right[b]))
				{
					numbers[i] = left[a];
					a++;
				}
				else
				{
					numbers[i] = right[b];
							b++;
				}
			}
		}
	}