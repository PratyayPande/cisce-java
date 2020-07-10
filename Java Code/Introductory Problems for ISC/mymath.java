/*
The trigonometric function sec(x) can be computed as:
sec(x) = 1/cos(x), x is in radians and (0 <= x <= π/2)
The trigonometric function cos(x) can be computed by the following infinite series:
cos(x) = 1 – x2/2!  + x4/4! – x6/6! + ……………………….., where x is in radians and (0 <= x <= π/2)
A class mymath has been defined to calculate the trigonometric functions. Some of the functions in mymath are shown below:
                    Class name: mymath
Data members/instance variables:
                                      x: Angle in radians.
Member functions/methods:
      mymath(double x): Constructor to assign x = nx.
 double abs(double y): Calculates and returns the absolute value of y.
                                           y = -y when y < 0; and y = y when y > 0.
                 double cos(): Calculates and returns the cos value of the angle x correct upto  7 places after              the  decimal using the infinite series given above when x is within the range, otherwise it returns an error value of 9999999.9.
                 double sec(): Calculates and returns the value of secx by using the value of cosx(remember when x is in radian and 0 <= x <= π/2, then 0 <= cosx <= 1.
Specify the class mymath giving details of the constructor mymath(double nx), double abs(double y), double cos(), double sec() only. You should write the main function.
*/

import java.util.Scanner;
public class mymath    //declaring the class
{    //beginning of class block
    double x;    //declaring the instance variable
    mymath(double w)    //declaring the constructor
    {    //beginning of constructor
        x = w;
    }    //end of constructor
    double abs(double y)    //method to calculate the absilute value
    {    //beginning of method
        return((y >= 0)? y:-y);
    }    //end of method
    double cos()    //method to calculate cos(x)
    {    //beginning of method
        double cosine=0.0,f=1.0;
        int i,j;
        if((x >= 0)&&(x <= Math.PI))    //checking the range
        {    //beginning of if-block
            for(i=0;i<100;i++)
            {    //beginning of for-loop
                for(j=1;j<=2*i;j++)
                f *= (double)j;    //calculating the factorial
                if(i%2 == 0)
                cosine = cosine + Math.pow(x,2*i)/f;    //calculating cosine
                if(i%2 != 0)
                cosine = cosine - Math.pow(x,2*i)/f;
                f = 1.0;
            }    //end of for-loop
        }    //end of if-block
        else
        cosine = 9999999.9;    //error value
        return(Math.round(cosine*10000000.0)/10000000.0);    //printing the rounded cosine
    }    //end of method
    double sec()    //method to calculate sec(x)
    {    //beginning of method
        return(1/cos());    //calculating secant
    }    //end of method
    public static void main()    //main-method
    {    //beginning of main-method
        int ch=0;
        double num=0.0;
        Scanner in = new Scanner(System.in);
        mymath a = null;    //object to call the other methods
        while(ch != 4)
        {    //beginning of while-loop
            System.out.println("ENTER 1 TO CALCULATE ABSOLUTE VALUE:");
            System.out.println("ENTER 2 TO CALCULATE COSINE:");
            System.out.println("ENTER 3 TO CALCULATE SECANT:");
            System.out.println("ENTER 4 TO EXIT:");
            System.out.println("ENTER YOUR CHOICE:");
            ch = in.nextInt();    //accepting choice
            switch(ch)
            {    //beginning of switch block
                case 1:    //first case to calculate absolute value
                System.out.println("ENTER THE NUMBER:");
                num = in.nextDouble();
                a = new mymath(num);    //initialising object
                System.out.println("THE ABSOLUTE VALUE IS = " + a.abs(num));
                break;
                case 2:    //second case to calculate cosine
                System.out.println("ENTER THE ANGLE IN RADIANS:");
                num = in.nextDouble();    //accepting angle
                a = new mymath(num);    //initialising object
                System.out.println("cos(" + num + ") = " + a.cos());
                break;
                case 3:    //third case to calculate secant
                System.out.println("ENTER THE ANGLE IN RADIANS:");
                num = in.nextDouble();    //accepting the angle
                a = new mymath(num);    //initialising object
                if(num == Math.PI/2)    //checking for undefined value
                System.out.println("sec(" + num + ") IS UNDEFINED!");
                else
                System.out.println("sec(" + num + ") = " + a.sec());
                break;
                case 4:    //exit-case
                System.out.println("THANK YOU.");
                break;
                default:    //default case
                System.out.println("WRONG CHOICE!");
                break;
            }    //end of switch-case block
        }    //end of while-loop
    }    //end of main-method
}    //end of class block
