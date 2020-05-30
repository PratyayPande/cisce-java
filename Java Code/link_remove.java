import java.io.*;
// code to remove the repeating nodes in a linked list
public class link_remove
{
    public static void main(String[] args) throws Exception
    {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader in= new BufferedReader(input);
        System.out.print("Enter the number of elements of the linked list: ");
        int num = Integer.parseInt(in.readLine());
        for(int i=0;i<num;i++)
        {
            LinkedList ob = new LinkedList(Integer.parseInt(in.readLine()));
            // accepting the elements of the linked list from the user
        }
        /*
         * start for loop from one node index pointed by i
         *
         * start for loop from the index pointed by j with initial value equal to i
         *
         *
         */
    
    }
    void removeDup()
    {
        for(LinkedList i=first;i!=null;i=i.next)
        {
            for(LinkedList j=i;j.next!= null)
            {
                if(i.getData() == j.next.getData())
                {
                    j.next = j.next.next;
                }
            }
        }
    }

}
