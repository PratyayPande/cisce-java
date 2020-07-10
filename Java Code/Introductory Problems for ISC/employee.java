/*
Define a class employee having the following description:
Data members:                       int pan: 	To store the personal account number.
                                         String name:	To store name.
                              double taxincome: To store the annual taxable income.
                                            double tax:	To store the tax that is calculated.
Member Functions:
input()           :  Store the pan number, name, taxable income.
cal()                : Calculate tax of an employee.
display()        : Output details of an employee
Write a program to compute the tax according to the given conditions and display the output as per the given format:

Total Annual Taxable Income
Tax Rate
Up to Rs. 1,00,000 - No tax
From Rs. 1,00,001 to Rs. 1,50,000 - 10% of the income exceeding Rs. 1,00,000
From Rs. 1,50,001 to Rs. 2,50,000 - Rs. 5000 + 20% of the income exceeding Rs. 1,50,000
Above Rs. 2,50,000 - Rs. 25000 + 30% of the income exceeding Rs. 2,50,000

OUTPUT:
Pan Number                               Name                                                Tax-Income                          Tax
………………………                          ……………………………                 ………………………….            ……………………………
………………………                          ……………………………                 ………………………….            ……………………………
*/

import java.util.Scanner;
class employee    //declaring class
{    //beginning of class block
    int pan;    //declaring the instance variables
    String name;
    double taxincome, tax;
    void input()    //method to accept the elements
    {    //beginning of method
        Scanner in = new Scanner(System.in);
        System.out.print("ENTER THE NAME: ");
        name = in.next();    //accepting the name
        System.out.print("ENTER THE PAN NUMBER: ");
        pan = in.nextInt();    //accepting the pan number
        System.out.print("ENTER THE TAXABLE INCOME: ");
        taxincome = in.nextDouble();    //accepting the taxable income
        System.out.println("...DETAILS ACCEPTED...");
        in.close();
    }    //end of method
    void cal()    //method to calculate the tax
    {    //beginning of method
        if(taxincome <= 100000)    //calculating tax for various slots of taxable incomes
        tax = 0;
        if((taxincome > 100000)&&(taxincome <= 150000))
        tax = 0.1*(taxincome - 100000);
        if((taxincome > 150000)&&(taxincome <= 250000))
        tax = 5000 + 0.2*(taxincome - 150000);
        if(taxincome > 250000)
        tax = 25000 + 0.3*(taxincome - 250000);
    }    //end of method
    void display()
    {    //beginning of method
        System.out.println(pan + "\t \t" + name + "\t \t" + taxincome + "\t" + tax);
    }    //end of method
    public static void main()
    {    //beginning of main-method
        int c = 0;    //initialising the integer variable
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER 1 TO CONTINUE, OR 0 TO STOP THE APPLICATION:");
        c = sc.nextInt();    //accepting the user's choice
        employee ob = new employee();    //declaring the object of the class
        while(c == 1)
        {    //beginning of while-loop
            System.out.println("ENTER THE DETAILS:");
            ob.input();    //accepting the elements
            ob.cal();    //calculating the tax payable
            System.out.println("PAN NUMBER \t  NAME \t \t TAXABLE INCOME \t TAX");
            ob.display();    //displaying the data
            System.out.println("ENTER '1' TO CONTINUE, AND '0' TO DISCONTINUE");
            c = sc.nextInt();    //accepting the user's choice
        }    //end of while-loop
        sc.close();
    }    //end of main-method
}    //end  of class
