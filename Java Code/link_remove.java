import java.io.*;

// code to remove the repeating nodes in a linked list
public class link_remove
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
        for(Link i=first;i!=null;i=i.next)
        {
            for(Link j=i;j.next!= null;j=j.next)
            {
                if(i.nodeData() == j.next.nodeData())
                {
                    //j.next.nodeData() = 0;
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
        for(Link i=first;i != null;i=i.next)
        {
            System.out.print(" <- " + i.nodeData());
        }
    }
    boolean checkPresence(Link testnode)
    {
        boolean k = false;
        loopID : for(Link ob = testnode;ob.next != null;ob = ob.next)
        {
            if(ob == testnode)
            {
                k = true;
                break loopID;
            }
        }
        return k;
    }
    /*int calSize()
    {
        
    }*/
    void delCircular()
    {
        //HashMap<Link,Integer> ob = new HashMap<>();
        Link ob = first;
        boolean repeats=false;
        while(!repeats)
        {
            for(Link testnode=first;testnode != ob && !repeats;testnode=testnode.next)
            {
                if(testnode == ob.next)
                    repeats = true;
            }
            

        }
    }

}
