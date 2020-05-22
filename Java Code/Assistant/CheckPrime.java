package Assistant;
public class CheckPrime//declaring class
{//beginning of class
    public boolean isPrime(int num)
    {//beginning of method
        int i;
        boolean b = true;//declaring boolean variable
        for(i=2;i<num;i++)
        {//beginning of for-loop
            if(num%i == 0)//divisibility check
            b = false;
        }//end of for-loop
        if(num == 1)
        b = false;
        return b;//returning the decision
    }//end of method
}//end of class
/*
Package Assistant

        START
Step 1: Declare the class CheckPrime.
Step 2: Call the procedure public boolean isPrime(int num), accessible from inside as well as outside the class CheckPrime
        END

Procedure public boolean isPrime(int num)

Step 1: Declare the variables.
Step 2: Declare the integer variable i.
Step 3: Declare the boolean variable b. Initialise the boolean variable b with ‘true’ value.
Step 4: i = 2.
Step 5: If the remainder obtained when the integer variable num is divided by i is 0, then execute Step 6.
Step 6: b = ‘false’.
Step 7: i = i + 1.
Step 8: If i < num, then go to Step 5. Else, go to Step 9.
Step 9: If num = 1, then execute Step 10. Else, go to Step 11.
Step 10: b = false;
Step 11: Return the value of b to the calling procedure.

End of Procedure

End of Package

 */