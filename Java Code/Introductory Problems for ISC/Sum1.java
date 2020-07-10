/*
Write a program in java to calculate the sum of the following series taking the value of a and n from the console:

S = a/(a + 1!) + a2/(a + 2!) + a3/(a + 3!) + ……….. + an/(a + n!)

*/

import java.util.Scanner;
public class Sum1//declaring the class
{//beginning of class block
    int a,n;//declaring the integer variables
    double S = 0.0;//declaring double variable to store the sum
    public void returnSum(int ind)//method to calculate sum
    {//beginning of method
        int i,f=1;
        for(i=1;i<=ind;i++)//loop to calculate the factorial
        f *= i;//calculating factorial
        S += Math.pow(a,ind)/(a + f);//calculating the sum
        if(ind < n)//calling the method returnSum to calculate the sum
        returnSum(ind+1);//calling the method
        else
        System.out.print("The value is: " + S);//returning the value of the sum
    }//end of method
    public void main()//of main-method
    {//beginning of method
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the value of a:");
        a = in.nextInt();//accepting the value of a
        System.out.print("Enter the value of n:");
        n = in.nextInt();//accepting value of n
        returnSum(1);//calculating the sum
    }//end of main-method
}//end of class
