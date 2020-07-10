/*
A Set is a collection in which there is no duplication of elements. S = {1, 6, 9, 16} is a set of 4 integer elements. An array of integers may be used to represent a set. You may assume that there will be a maximum of 50 elements in the set. The member functions of the class set are given as:
Class name: set
Data members/Instance variables:
                        arr[ ] : An array of integers to store the elements of the set.
                               n : An integer to store total number of elements in the set.
Member functions/methods:
                        set(int nn) : Constructor to initialize n = nn, and the array arr[ ].
      void readelements() : Reads the elements of the sets.
  void displayelements() : Displays the elements of the sets.
                      int getsize() : Returns n, the number of elements of the set.
                 int has(int ele) : Returns 1, if ele belongs to the current object, otherwise 0.
   set intersection(set d) : Returns the intersection of the set object d, and the current set object, i.e., the set containing the elements that are common to both the sets.
               set union(set d) : Returns the union of the set object d, and the current set object, i.e., the set containing the elements that are present in both the sets.
Specify the class set giving the details of the functions. You have to write the main function.
*/

import java.io.*;
class set    //declaring the class
{    //beginning of class block
    int arr[] = new int[50];    //declaring the set to contain elements
    int n;    //instance variable to store the no. of elements in each set
    set(int nn)    //constructor to initialise the instance variables
    {    //beginning of constructor block
        n = nn;    //initialising the no. of elements
        for(int i=0;i<50;i++)
        arr[i] = 0;    //initialising the set
    }    //end of constructor
    void readelements()throws IOException    //method to read elements
    {    //beginning of method
        int i;
        InputStreamReader read =new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);
        for(i=0;i<n;i++)
        arr[i] = Integer.parseInt(in.readLine());    //accepting elements
    }    //end of method
    void displayelements()    //method to display elements
    {    //beginning of method
        int i;
        System.out.print("{");
        for(i=0;i<n;i++)
        {
            System.out.print(arr[i]);    //printing elements
            if(i != n-1)
            System.out.print(", ");
        }
        System.out.print("}");
        System.out.println();
    }    //end of method
    int getsize()    //method to return the size
    {    //beginning of method
        return n;    //returning the size of the set
    }    //end of method
    int has(int ele)    //checking if ele is present in the set or not
    {    //beginning of method
        int i,k=0;
        for(i=0;i<n;i++)
        {
            if(ele == arr[i])
            k=1;    //checking if the element is present in the set arr[] or not
        }
        return k;    //returning decision
    }    //end of method
    set intersection(set d)    //method to return the intersection
    {    //beginning of method
        int i,k=0;
        set ins = new set(0);    //creating new object to store the intersection set
        for(i=0;i<n;i++)
        {
            if((d.has(arr[i]) == 1)&&(ins.has(arr[i]) == 0))
            {    //checking for common elements and if each elements is already present in the      intersection set
                ins.arr[ins.getsize()] = arr[i];    //storing elements in the intersection set
                ins.n++;
            }    //end of if-block
        }
        return ins;    //returning the intersection object
    }    //end of method
    set union(set d)
    {    //beginning of method
        int i,k=0;
        set un = new set(0);    //creating new object to store the union set
        for(i=0;i<n;i++)
        {    //beginning of for-loop
            if(un.has(arr[i]) == 0)    //checking if each element is already stored in the union set or not
            {    //beginning of if-block
                un.arr[un.getsize()] = arr[i];    //storing the element in the union set
                un.n++;
            }    //end of if-block
        }    //end of for-loop
        for(i=0;i<d.getsize();i++)
        {    //beginning of for-loop
            if(un.has(d.arr[i]) == 0)
            {
                un.arr[un.getsize()] = d.arr[i];    //storing the element in the union set
                un.n++;
            }
        }    //end of for-loop
        return un;    //returning the new object
    }    //end of method
    public void main()throws IOException
    {    //beginning of main-method
        int num=0;
        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);
        System.out.println("ENTER THE NUMBER OF ELEMENTS OF THE FIRST SET (MAX: 25):");
        num = Integer.parseInt(in.readLine());    //accepting the number of elements in the first set
        set a1 = new set(num);
        System.out.println("ENTER THE ELEMENTS OF THE FIRST LIST:");
        a1.readelements();    //accepting the elements
        System.out.println("ENTER THE NUMBER OF ELEMENTS OF THE SECOND SET (MAX: 25):");
        num = Integer.parseInt(in.readLine());
        set a2 = new set(num);    //accepting the number of elements in the second set
        System.out.println("ENTER THE ELEMENTS OF THE SECOND LIST:");
        a2.readelements();    //accepting the elements
        System.out.println("THE ELEMENTS OF THE FIRST SET ARE:");
        a1.displayelements();    //displaying the elements in the first set
        System.out.println("THE ELEMENTS OF THE SECOND SET ARE:");
        a2.displayelements();    //displaying the elements in the second set
        System.out.println("THE INTERSECTION OF THE TWO SETS IS:");
        set insc = a1.intersection(a2);    //intersection object
        insc.displayelements();    //displaying the intersection of the two sets
        System.out.println("THE UNION OF THE TWO SETS IS:");
        set uni = a1.union(a2);    //union object
        uni.displayelements();    //displaying the union of the two sets
    }    //end of main-method
}    //end of class
