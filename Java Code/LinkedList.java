import java.io.*;
class LinkedList// declaring of class
{// beginning of class
    Link first=null;// declaring object to reference to last node
    void input(int num)// accepting data
    {// beginning of method
        Link node = new Link(num);// storing data
        node.next = first;// creating link
        first = node;
    }// end of method
    void delete()// deletes the last entered element in the list
    {// beginning of method
        if(first == null) // case if list is empty
        System.out.println("LINKED LIST IS EMPTY!!");
        else
        {// beginning of else block
            System.out.println("Deleted element = " + first.nodeData());
            first = first.next;// moving the variable first to the next node
        }// end of else block
    }// end of method
    void display()
    {// beginning of method
        System.out.println("The elements of the Linked list are:");
        if(first != null)
        {// beginning of if-block
            for(Link c=first;c!=null;c=c.next)
            System.out.print(c.data + ";");//printing data
            System.out.println("");
        }// end of if-block
        else//case if the list is empty
        System.out.println("LINKED LIST IS EMPTY!!");
    }// end of method
    void displayReverse(Link ob)
    {
        if(ob != null)
        {
            displayReverse(ob.next);
            System.out.print("{" + ob.data + "} ");
        }
    }
    void deleteNextNode(Link ob)
    {
        if(ob != first)
            ob.next = ob.next.next
    }
}// end of class



