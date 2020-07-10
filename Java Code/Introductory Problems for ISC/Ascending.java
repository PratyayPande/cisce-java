/*
There is a class Ascending that contains integers that are already arranged in ascending order. Some of the member methods of the class Ascending are given below:
Class name: Ascending
Instance variables:
                              int a[ ] : 	An array of integers sorted in ascending order.
                                  int n:	Number of integers in the array
Member methods:
           Ascending (int n) : Constructor to create an Ascending List of size n.
void displayList() : To display the list of integers.
Ascending merge(Ascending a1) : To merge the Ascending List a1 with the current ascending list object and return a third Ascending List which is also sorted in ascending order.
Important: While generating the final Ascending list which is also sorted in ascending order, both the original  ascending lists must be scanned only once. Elements common to the two lists should appear only once in the third Ascending list.
Specify the class Ascending, giving details of the functions void displayList() and Ascending   merge(Ascending a1). Write the main() function and provide two sets of input and output.
*/

import java.io.*;
public class Ascending    //declaring the class
{    //beginning of class block
    int a[] = new int[30];    //declaring the array
    int n;    //declaring the integer to store the length
    Ascending(int n1)//constructor
    {    //beginning of constructor
        n = n1;    //initialising the length
        for(int i=0;i<30;i++)
        this.a[i] = -999999;    //initialising the final array
    }   //end of constructor
    public void main()throws IOException    //main method
    {   //beginning of main method
        int i,num=0;    //declaring the variables
        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);
        System.out.println("CREATING NEW LIST...");
        System.out.println("Enter the number of elements for the first list:");
        num = Integer.parseInt(in.readLine());    //accepting no. of elements in first list
        Ascending nst = new Ascending(num);    //creating reference type variable for first list
        System.out.println("ENTER THE ELEMENTS OF THE FIRST LIST:");
        for(i=0;i<num;i++)
        nst.a[i] = Integer.parseInt(in.readLine());    //accepting the elements of the first list
        System.out.println("Enter the number of elements for the second list:");
        num = Integer.parseInt(in.readLine());    //accepting no. of elements in second list
        Ascending klo = new Ascending(num);    //creating reference type variable for second list
        System.out.println("ENTER THE ELEMENTS OF THE SECOND LIST:");
        for(i=0;i<num;i++)
        klo.a[i] = Integer.parseInt(in.readLine());    //accepting the elements of the second list
        System.out.println("THE ELEMENTS OF THE FIRST LIST ARE:");
        nst.displayList();    //displaying the elements of the first list
        System.out.println("THE ELEMENTS OF THE SECOND LIST ARE:");
        klo.displayList();    //displaying the elements of the secong list
        Ascending asc = merge(nst);    //merging the elements of the first list
        asc = merge(klo);    //merging the elements of the second list
        System.out.println("THE ELEMENTS OF THE MERGED LIST, SORTED IN ASCENDING ORDER IS:");
        asc.displayList();    //displaying the merged list
    }    //end of main method
    Ascending merge(Ascending a1) //method to merge two lists and arrange them in ascending order
    {    //beginning of method
        int i,k=0,h=0,j;    //declaring the variables
        //merging the list
        for(i=0;i<a1.n;i++)
        {    //beginning of for-loop
            for(j=0;j<this.n;j++)
            {    //beginning of nested for-loop
                if(this.a[j] == a1.a[i])
                k++;    //checking for repeating elements
            }    //end of nested for-loop
            if(k == 0)
            {
                this.a[this.n] = a1.a[i];
                this.n++;
            }
            k = 0;
        }    //end of for-loop
        //sorting section
        for(i=0;i<this.n;i++)
        {    //beginning of for-loop
            for(j=i;j<this.n;j++)
            {    //beginning of nested for-loop
                if(this.a[i] > this.a[j])  //sorting the list
                {    //beginning of if-block
                    h = this.a[j];
                    this.a[j] = this.a[i];
                    this.a[i] = h;
                }    //end of if-block
            }    //end of nested for-loop
        }    //end of for-loop
        return this;    //returning the new object for the sorted list
    }    //end of method
    void displayList()//method to display the lists
    {    //beginning of method
        System.out.print("{ ");
        for(int i=0;i<n;i++)
        {    //beginning of for-loop
            if(a[i] != -999999)
            System.out.print(a[i] + "; ");//printing the list
        }    //end of for-loop
        System.out.print("}");
        System.out.println();
    }    //end of method
}    //end of class
