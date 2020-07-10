/*
A triangular number is formed by the addition of consecutive integers starting from 1.
For example: 
		1 + 2 = 3
		1 + 2 + 3 = 6
		1 + 2 + 3 + 4 = 10.
		1 + 2 + 3 + 4 + 5 = 15
Thus,    3, 6, 10, 15, 21, ……………………………   are triangular numbers.
Write a program in Java to display all the triangular numbers from 3 to n, taking the value of n as an input.

*/

import java.util.Scanner;
public class TriangularNumber//declaring class
{//beginning of class
    int pr=1,n=0;//declaring instance variables
    TriangularNumber(int e)//declaring the constructor
    {//beginning of constructor
        n = e;//initialising the variable n
    }//end of constructor
    void calculate(int w)//method to calculate series
    {//beginning of method
        pr += w;//calcullating term of the series
        if(pr <= n)//checking if the term is within the limit or not
        {//beginning of if-block
            System.out.print(pr);//printing the value
            if(pr+w+1 <= n)
            System.out.print(", ");
            calculate(w+1);
        }//end of if-block
    }//end of method
    public static void main()
    {//beginning of main-method
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the upper limit:");
        int hn = in.nextInt();//accepting limit
        TriangularNumber ob = new TriangularNumber(hn);//declaring the object
        System.out.println("The next numbers are:");
        System.out.print("{");
        ob.calculate(2);//calling the method to calculate sum
        System.out.print("}");
        in.close();
    }//end of main method
}//end of class block
