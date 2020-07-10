/*
A Smith Number is a composite number, the sum of whose digits is equal to the sum of the sum of the digits of its prime factors obtained as a result of prime factorisation (excluding 1).
For example: 4, 22, 27, 58, 85, 94, 121, ……………..  are Smith Numbers.
Write a program in Java to enter a number and check whether it is a Smith Number or not.
Sample Input: 666
	Sum of the digits: 6 + 6 + 6 = 18
	Prime Factors are: 2, 3, 3, 37
	Sum of the digits of the factors: 2 + 3 + 3 + (3 + 7) = 18
	Thus, 666 is a Smith Number.

*/

import java.io.*;
class SmithNumber//declaring class
{//beginning of class block
    int num=0;//declaring instance variable
    boolean isPrime(int p)//method to check for prime number
    {//beginning of method
        boolean b = true;
        for(int j=2;j<p;j++)
        {//beginning of for-loop
            if(p%j == 0)//checking for prime number
            b = false;
        }//end of for-loop
        return b;
    }//end of method
    void PrintFactors()
    {//beginning of method
        int i,cp=num,nf=0;//declaring the variable
        for(i=2;i<=cp;i++)//for-loop
        {//beginning of for-loop
            if((cp%i == 0)&&(isPrime(i)))//checking for prime-factor
            {//beginning of if-block
                if(nf != 0)
                System.out.print(", ");//adding commas
                System.out.print(i);//printingthe prime factor
                cp = cp/i;//method of prime factorisation
                nf++;
                if(cp%i == 0)//checking if i is again a prime factor of cp
                i--;
            }//end of if-block
        }//end of for-loop
    }//end of method
    int sumOfDigits(int n)//method to calculate the sum of digits
    {//beginning of method
        int s=0;
        while(n > 0)//while-loop
        {//beginning of while-loop
            s += n%10;//adding the value of each digit
            System.out.print(n%10);//printing each digit
            if(n/10 != 0)//adding '+' sign for certain values
            System.out.print(" + ");
            n /= 10;//eliminating the last digit of the number
        }//end of while-loop
        return s;//returning the value of s to the calling method
    }//end of method
    public void main()throws IOException//main method
    {//beginning of main-method
        int i,sdn,sfd,c,nl=0;//declaring the variables
        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);
        System.out.println("Enter the number. Please enter a composite number:");
        num = Integer.parseInt(in.readLine());//accepting the number
        System.out.print("The sum of digits = ");
        sdn=sumOfDigits(num);//storing sum of digits of the number
        sfd=0;
        c=num;//assigning values to each variable
        System.out.print(" = " + sdn);System.out.println();//printing sum of digits of number
        System.out.print("The prime factors of " + num + " are = ");
        PrintFactors();//printing the prime-factors of num
        System.out.println();
        System.out.print("The sum of the digits of the Prime Factors = ");
        for(i=2;i<=c;i++)//for-loop
        {//beginning of for-loop
            if((c%i == 0)&&(isPrime(i)))//checking for prime factor
            {//beginning of if-block
                if(nl != 0)//adding '+' sign at some positions
                System.out.print(" + ");
                sfd += sumOfDigits(i);//storing the sum of the sum of digits of the prime factors
                c /= i;//method of prime-factorising
                nl++;
                if(c%i == 0)//checking if c is again a factor of c
                i = i-1;
            }//end of if-block
        }//end of for-loop
        System.out.println(" = " + sfd);//printing the sum of the sum of digits of the prime factors
        if(sfd == sdn)//checking for a Smith Number
        System.out.println("The number " + num + " is a Smith Number.");
        else
        System.out.println("The number " + num + " is not a Smith Number.");
    }//end of main-method
}//end of class-block
