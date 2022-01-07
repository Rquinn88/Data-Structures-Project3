import java.lang.Thread;
import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;
public class AlgorithmTesting 
{
	public static void main(String[] args) 
	{
		String name;
		//for writing to a file
		File outfile;
		PrintWriter pw;
		//implement the scanners for the n man and the increment value 
		//implement scanner for the file name 
		int n;
		int inc;
		int j = 0;
		int i = 0;
		Scanner keyin = new Scanner(System.in);
		System.out.printf("Please enter the number you want to increment by: .\n");
		inc = keyin.nextInt();
		System.out.printf("Please enter the maximum number of iterations: .\n");
		n = keyin.nextInt();
		System.out.printf("Enter the name of the file you want to write to. \n");
		name = keyin.next();

		outfile = new File (name);
			if (outfile.exists())
			{	
				System.out.printf ("Are you sure?\n");
				System.out.printf ("If not, exit the program.\n");
				System.out.printf ("If so, enter the filename to write to again: \n");
				name = keyin.next(); //this is name of the scanner "keyin"
				//getting and error bc there isn't a scanner yet 
			}

		try
		{
			pw = new PrintWriter(outfile);

			int maxN[] = new int[n]; 
			for (i = 0; i <= n; i = i+inc)
			{
				maxN[j] = i;
				j++;
			}
			j = 0; 

			long Algorithm_A[] = new long[n]; 
			for (i = 0; i <= n; i = i+inc)
			{
				Algorithm_A[j] = AlgorithmA(i);
				j++;
			}
			j = 0; 

			long Algorithm_B[] = new long[n];
			for (i = 0; i <= n; i = i+inc)
			{
				Algorithm_B[j] = AlgorithmB(i);
				j++;
			}
			j = 0; 

			long Algorithm_C[] = new long[n]; 
			for (i = 0; i <= n; i = i+inc)
			{
				Algorithm_C[j] = AlgorithmC(i);
				j++;
			}
			 
				pw.printf("N, Algorithm A, Algorithm B, Algorithm C\n");
				System.out.printf("   n   |   Algorithm A   |   Algorithm B   |   Algorithm C  \n"); 
				
				for(i = 0; i < j; i++)
				{
					pw.printf("%d, %d, %d, %d\n", maxN[i], 
					Algorithm_A[i], Algorithm_B[i], Algorithm_C[i]);
					System.out.printf("%4d   | %15d | %15d |%14d  \n", 
					maxN[i], Algorithm_A[i], Algorithm_B[i], Algorithm_C[i]);
				}
			
				//to quit writing to file
				pw.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.printf ("You should never see this!\n");
			System.exit(0);
		}
	}

	long startTime = System.nanoTime();
	public static long AlgorithmA(int n)
	{
		long startTime = System.nanoTime();
		int sum0 = 0;
		for (int i=1; i <= n; i++)		//This algorithm is linear
			{
				sum0 = sum0 + 1; 
				try 
				{Thread.sleep(0, 1);}		//This is a 1ns delay 
      			catch (Exception e) { }
			}
		
		long stopTime = System.nanoTime(); 
		long elapsedTime = stopTime - startTime;

		return elapsedTime;
	}
			


	public static long AlgorithmB(int n)
	{
		long startTime = System.nanoTime();
		int sum1 = 0;
		for (int i=1; i <= n; i++)
		{
		   for (int j=1; j <= i; j++)	//this algorithm is quadratic 
			{ 
				sum1 = sum1 + 1; 
				try 
				{Thread.sleep(0, 1);}		//This is a 1ns delay 
      			catch (Exception e) { }
			}
		}
		long stopTime = System.nanoTime(); 
		long elapsedTime = stopTime - startTime;

		return elapsedTime;
	}
	


	
	public static long AlgorithmC(int n)
	{
		long startTime = System.nanoTime();
		int sum2 = n * (n + 1) / 2;		//This algorithm is a summation 
		try 
				{Thread.sleep(0, 1);}		//This is a 1ns delay 
      			catch (Exception e) { }
      	
      	long stopTime = System.nanoTime(); 
		long elapsedTime = stopTime - startTime;

		return elapsedTime; 
	}
	
}

