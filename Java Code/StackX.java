// infix.java
// converts infix arithmetic expressions to postfix
import java.io.*;
class StackX//declaring the class
{//beginning of class block
    private int maxSize;
    private char[] stackArray;
    private int top;//declaring the instance variables accessible from within the class
    public StackX(int s)       // constructor
    {//beginning of constructor
        maxSize = s;
        stackArray = new char[maxSize];
        top = -1;
    }//end of constructor
    public void push(char j)  // put item on top of stack
    {//beginning of method
        stackArray[++top] = j;
    }//end of method
    public char pop()         // take item from top of stack
    {//beginning of method
        return stackArray[top--];
    }//end of method
    public char peek()        // peek at top of stack
    {//beginning of method
        return stackArray[top];
    }//end of method
    public boolean isEmpty()  // true if stack is empty
    {//beginning of method
        return (top == -1);
    }//end of method
    public int size()         // return size
    {//beginning of method
        return top+1;
    }//end of method
    public char peekN(int n)  // return item at index n
    {//beginning of method
        return stackArray[n];
    }//end of method
    public void displayStack(String s)
    {//beginning of method
        System.out.print(s);
        System.out.print("Stack (bottom-->top): ");
        for(int j=0; j<size(); j++)
        {
            System.out.print( peekN(j) );
            System.out.print(' ');
        }
        System.out.println("");
    }//end of method
}  // end class StackX