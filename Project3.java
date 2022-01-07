import java.lang.Thread;
import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class Project3
{
	//Global Variables
	static int n;
	static String out;
	static long elapsedTimeA;
	static long elapsedTimeB;
	static long elapsedTimeC;
	
	public static void main (String args[]){
		
		Scanner in = new Scanner(System.in); //Create Scanner for user prompt
		
		int inc, max; //Increment and Maximum variables
		
		String out; //For output file
		
		File outfile; //Output file which will be csv file
		
		PrintWriter pw; //Printwriter which will allow the program to print to a file
		
		//Prompt user for Increment Value
		System.out.printf("Please Enter the Increment Value for n:\t\t >>");
		inc = in.nextInt();
		
		//Prompt user for Maximum Value
		System.out.printf("Please Enter the Maximum Value for n:\t\t >>");
		max = in.nextInt();
		
		//Prompt user for Output File Name
		System.out.printf("Please Enter the Name of the Output File:\t >>");
		out = in.next();
		
		//Initialize arrays for algorithm time values 
		//Long used because of the legnth of the values
		long algA[] = new long[max + 1];
		long algB[] = new long[max + 1];
		long algC[] = new long[max + 1];
		
		System.out.format("\n+-------+---------------+---------------+---------------+%n");
		System.out.format("|   n   |  Algorithm A  |  Algorithm B  |  Algorithm C  |%n"); // Formating to create a table in the command prompt
		System.out.format("+-------+---------------+---------------+---------------+%n");
		
		for (int i = 0; i <= max; i = i + inc){
			
			timeA(); //Time algorithm A with method 
			timeB(); //Time algorithm B with method 
			timeC(); //Time algorithm C with method 
			
			String leftAlignFormat = "| %-5s | %-13d | %-13d | %-13d |%n"; // Aligns data in collumns in the command prompt

			System.out.format(leftAlignFormat, i, elapsedTimeA, elapsedTimeB, elapsedTimeC); //A formant to align data in 	collums in command prompt 
				algA[i] = elapsedTimeA; // Assign the elapsed time found from the timeA method to an array for each increment
				algB[i] = elapsedTimeB; // Assign the elapsed time found from the timeB method to an array for each increment
				algC[i] = elapsedTimeC; // Assign the elapsed time found from the timeC method to an array for each increment
				
			System.out.format("+-------+---------------+---------------+---------------+%n"); //Formating 
			
		}
		
		outfile = new File (out); //Create new output File 
		
		try{
          pw = new PrintWriter(outfile); //Printwriter is created here. It is used to create the csv file and populate it with data
		  
		  pw.printf("Increment , Algorithm A, Algorithm B, Algorithm C\n"); //Headers for csv file
		  
		  for(int i = 0; i < max + 1; i = i+inc)
					pw.printf("%d, %d, %d, %d\n", i, algA[i], algB[i], algC[i]); //Print data values in the arrays for each algorithm time in the csv file through use of a for loop

		  pw.close(); // Close printwriter
		  
		}
		catch (FileNotFoundException e){ //Catch a file not found excpetion (this will never happen)
			
			System.out.printf ("Error");
			System.exit(0);
		}
    
       
	}

	//AlgorithmA
	public static void algA(){
		int sum = 0;
		
			for (int i=1; i <= n; i++)
				sum = sum + 1;
			
			try { Thread.sleep(0, 1); } // Delay by 1 ns 
					
					catch (Exception e) { }

	}
	
	//AlgorithmB
	public static void algB(){
		int sum = 0;
			for (int i=1; i <= n; i++){

				for (int j=1; j <= i; j++){

						sum = sum + 1;
						
					try { Thread.sleep(0, 1); } // Delay by 1 ns 
					
					catch (Exception e) { }
				}
			}

	}
	
	//AlgorithmC
	public static void algC(){
		int sum = n * (n + 1) / 2;
		
		try { Thread.sleep(0, 1); } // Delay by 1 ns 
					
					catch (Exception e) { }

	}
	
	//Method to time algorithm A 
	public static void timeA(){
		
			long startTime = System.nanoTime(); // get current time
			algA(); // code being timed
			long stopTime = System.nanoTime(); // get current time
			elapsedTimeA = stopTime - startTime; // compute nanoseconds
	}
	
	//Method to time algorithm B
	public static void timeB(){
		
			long startTime = System.nanoTime(); // get current time
			algB(); // code being timed
			long stopTime = System.nanoTime(); // get current time
			elapsedTimeB = stopTime - startTime; // compute nanoseconds
	}
	
	//Method to time algorithm B
	public static void timeC(){
		
			long startTime = System.nanoTime(); // get current time
			algC(); // code being timed
			long stopTime = System.nanoTime(); // get current time
			elapsedTimeC = stopTime - startTime; // compute nanoseconds
	}
	
}
