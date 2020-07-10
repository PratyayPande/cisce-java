/*
Write a program in java to print the sum of the following series, taking the values of a and n as input:
S = 1 + a2/2! – a4/4! + a6/6! – a8/8! + ………….. upto n terms.
*/

import java.io.*;
class Sum2//declaring the class
{//beginning of class block
    int n=0,a=0;//declaring the integer variables
    double S = 0.0;//declaring variable to store the sum
    void calSum(int w)    //method to calculate cos(x)//method to find sum
    {//beginning of method
        int j,f=1;
        for(j=1;j<=2*w;j++)
        f *= j;//calculating the factorial
        if(w%2 == 0)
        S = S - Math.pow(a,2*w)/f;//calculating sum
        if(w%2 != 0)
        S = S + Math.pow(a,2*w)/f;
        f = 1;//resetting the variable
        if(w+1 < n)//calling the function itself
        calSum(w+1);//recallingg the function
        else
        System.out.println("The value of the sum is: " + S);//displaying the value of the function
    }//end of the method
    public void main()throws IOException//main method to call the main-method
    {//beginning of the main-method
        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);
        System.out.println("Enter the value of 'a':");
        a = Integer.parseInt(in.readLine());//beginning of the integer variable 'a'
        System.out.println("Enter the value of 'n':");
        n = Integer.parseInt(in.readLine());//beginning of the integer variable 'n'
        calSum(0);//calculating the sum
    }//end of main-method
}//end of class
