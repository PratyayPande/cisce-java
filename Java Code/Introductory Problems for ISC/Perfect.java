/*
A perfect square is an integer which is the square of another integer. For example, 4,9,16… are perfect squares. Design a class perfect. Design a class Perfect with the following description:
               Class name: Perfect
Data members/ instance variables
                                 n: Stores an integer number
Member functions:
                   Perfect(): Default constructor
              Perfect(int): Parameterized constructor to assign a value to ‘n’
    void perfect_sq(): To display the next 5 perfect squares larger than ‘n’
          void sum_of(): To display all combinations of consecutive integers whose sum is equal to n.
Specify the class Perfect giving details of the constructors, void perfect_sq() and void sum_of(). Also define the main function to create an object and call the methods accordingly to enable the task.
*/

import java.util.Scanner;
class Perfect    //declaring class
{    //beginning of class block
    int n;    //declaring the instance variables
    Perfect()    //declaring the default constructor
    {    //beginning of constructor
        n = 0;
    }    //end of procedure
    Perfect(int w)    //declaring the constructor to initialise n
    {    //beginning of constructor
        n = w;
    }    //end of procedure
    void perfect_sq()
    {    //beginning of method
        int sqc=0, h=0;
        System.out.println("THE FIRST 5 PERFECT SQUARES AFTER " + n + " ARE:");
        h = n;
        while(sqc != 5)
        {    //beginning of while-loop
            h = h + 1;    //increasing the value of h
            if((Math.sqrt(h) - Math.floor(Math.sqrt(h))) == 0)    //checking for perfect square
            {    //beginning of if-block
                System.out.println(h);    //printing the perfect square
                sqc = sqc + 1;    //counting the number of squares printed
            }    //end of if-block
        }    //end of while-loop
    }    //end of method
    void sum_of()
    {    //beginning of method
        int i,j,k,sum,pc=0;
        System.out.println("THE POSSIBLE SUM-COMBINATIONS OF CONSECUTIVE INTEGERS ARE:");
        for(i=1;i<n;i++)
        {    //beginning of for-loop
            sum = 0;
            for(j=i;sum<n;j++)
            sum += j;    //calculating the sum of consecutive integers
            if(n == sum)
            {    //beginning of if-block
                for(k=i;k<j;k++)
                System.out.print(k + "  ");    //printing the consecutive integers
                System.out.println();pc++;
            }    //end of if-block
        }    //end of for-loop
        if(pc ==  0)
        System.out.println("<<<NO CONSECUTIVE INTEGERS ARE POSSIBLE>>>");
    }    //end of method
    public static void main()
    {    //beginning of main method
        Scanner in = new Scanner(System.in);
        Perfect f = new Perfect();
        System.out.println("ENTER THE NUMBER:");
        int a = in.nextInt();    //accepting the number
        Perfect ob = new Perfect(a);
        ob.perfect_sq();    //printing the perfect squares
        ob.sum_of();    //printing the consecutive integers adding to be equal to n
    }    //end of main method
}    //end of class block
