package cs211;

public class fibbonaciRecursion 
{

	public static void main(String[] args) 
	  {
	    for (int counter = 0; counter <= 100; counter++)
	      System.out.printf("Fibonacci of %d is: %d\n", counter, fibonacci(counter));
	  }
	
	
		  public static long fibonacci(long number) 
		  {
		    if ((number == 0) || (number == 1)) // base cases
		      return number;
		    else
		    	
		      // recursion step
		      return fibonacci(number - 1) + fibonacci(number - 2);
		  }

		  
}
