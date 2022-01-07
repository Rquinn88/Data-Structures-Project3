# Data-Structures-Project3

This project addresses three algorithms and provides analysis into which algorithm runs fastest in a Word Document and Excel Spreadsheet

Assignment: Given three algorithms shown below, which calculate the nth partial sum of the series:

Algorithm A:
int sum = 0;
for (int i=1; i <= n; i++)
{
 sum = sum + 1;
}

Algorithm B:
int sum = 0;
for (int i=1; i <= n; i++)
{
 for (int j=1; j <= i; j++)
 {
 sum = sum + 1;
 }
}

Algorithm C:
int sum = n * (n + 1) / 2;

Task:
Implement all three algorithms in one program and time the execution of each, for different values of n. Display the times on the screen
in a tabular form as well as save these values into an Excel .csv file. The .csv file is where all values are separated
by commas, which can easily be imported into an Excel workbook. Once the values are imported into
the workbook, create four chats, one for each algorithm to illustrate its growth rate, and one for all
algorithms, to illustrate their comparison.
