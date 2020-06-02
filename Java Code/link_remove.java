import java.io.*;
import java.util.*;
// code to remove the repeating nodes in a linked list
public class link_remove extends Link
{
    Link first;
    
    public static void main(String[] args) throws Exception
    {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader in= new BufferedReader(input);
        System.out.print("Enter the number of elements of the linked list: ");
        link_remove ob = new link_remove();
        int num = Integer.parseInt(in.readLine());
        for(int i=0;i<num;i++)
        {
            int nm = Integer.parseInt(in.readLine());
            ob.insert(nm);
            // accepting the elements of the linked list from the user
        }
        /*
         * start for loop from one node index pointed by i
         *
         * start for loop from the index pointed by j with initial value equal to i
         *
         *
         */

        ob.displayList();
        ob.removeDup();
        ob.displayList();
    
    }
    void removeDup()
    {
        for(LinkedList i=first;i!=null;i=i.next)
        {
            for(LinkedList j=i;j.next!= null)
            {
                if(i.getData() == j.next.getData())
                {
                    j.next.getData() = 0;
                    j.next = j.next.next;
                }
            }
        }
    }
    void insert(int num)
    {
        Link newnode = new Link(num);
        newnode.next = first;
        first = newnode;
    }
    void displayList()
    {
        System.out.print("NULL");
        for(LinkedList i=first;i!=null;i=i.next)
        {
            System.out.print(" <- " + i.getData());
        }
    }
    boolean checkPresence(Link testnode)
    {
        for(Link ob = first;ob.next!=testnode)
    }
    int calSize()
    {
        
    }
    void delCircular()
    {
        HashMap<Link,Integer> ob = new HashMap<>();
        Link ob = first;
        boolean repeats=false;
        while(!repeats)
        {
            for(Link testnode=first;testnode != ob && !repeats;testnode=testnode.next)
            {
                if(testnode == ob.next)
                    repeats = 
            }
            

        }
    }

}
