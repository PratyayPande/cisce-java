/*
Define a class Telephone having the following description:
Data members: int prv, pre 	: To store the previous and present meter reading.
	int calls       	: To store the calls made.
	String name	: To store the name of the consumer.
	double amt   	: To store the amount.
	double total          : To store the total amount to be paid.
Member Functions:
input()	: Stores the previous reading, present reading, name of the consumer
cal()	: Calculates the amount and the total amount to be paid.
display()	: Displays the name of the consumer, calls made, amount, total amount to be paid.
Write a program to compute the monthly bill to be paid according to the given conditions and display the output as per given format:
*/

import java.util.*;
public class Telephone//declaring the class
{//beginning of class block
    int prv,pre,calls;//declaring the data members
    String name;
    double total,amt;
    void input()//method to accept the data
    {//beginning of method
        Scanner in = new Scanner(System.in);
        System.out.print("ENTER THE PREVIOUS METER READING:");
        prv = in.nextInt();//accepting the previous reading
        System.out.print("ENTER THE PRESENT METER READING:");
        pre = in.nextInt();//accepting the current reading
        System.out.print("ENTER THE NAME OF THE CONSUMER:");
        name = in.next();//accepting the name of the consumer
        calls = pre - prv;//calculating the number of calls
    }//end of method
    void cal()
    {//beginning of method
        if(calls <= 100)//checking for required conditions
        amt = 0;
        if((calls > 100)&&(calls <= 200))
        amt = 0.9*(calls - 100);
        if((calls > 200)&&(calls <= 400))
        amt = 90 + 0.8*(calls - 200);
        if(calls > 400)
        amt = 90 + 160 + 0.7*(calls - 400);
        total = amt + 180;//calculating the total amount to be paid
    }//end of method
    void display()
    {//beginning of method
        System.out.println("NAME \t\t CALLS MADE \t\t AMOUNT TO BE PAID");
        System.out.println(name + "\t \t" + calls + " \t \t \t " + total);//printing data
    }//end of method
    public static void main()
    {//beginning of main-method
        int c=0;
        Scanner in = new Scanner(System.in);
        Telephone ob = new Telephone();//creating object
        System.out.print("ENTER '1'TO CONTINUE AND '0' TO DISCONTINUE");
        c = in.nextInt();//accepting user's choice
        while(c == 1)
        {//beginning of while-loop
            System.out.println("ENTER THE DETAILS:");
            ob.input();//accepting the input
            ob.cal();//calculating the total amount to be paid
            System.out.println("... DETAILS ACCEPTED ...");
            ob.display();//displaying the elements
            System.out.print("ENTER '1' TO CONTINUE OR '0' TO FINISH: ");
            c = in.nextInt();//acceptin user's choice whether to accept more data or not
        }//end of while-loop
    }//end of main-method
}//end of class-block
