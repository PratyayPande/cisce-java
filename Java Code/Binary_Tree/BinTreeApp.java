import java.io.*;
public class BinTreeApp
{
    public static void main(String[] args)throws Exception
    {
        boolean stayInTree = true;
        BinaryTree ob = new BinaryTree();
        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);
        System.out.println("Binary Tree Application Console");
        System.out.println("\n\nAn user Friendly Program to implement a binary tree");
        System.out.println("Version no.: 0.0.1");
        while(stayInTree)
        {
            System.out.print("ROOT:/" + ob.filepath() + "> ");
            String inp = in.readLine();
            if(!inp.equals("exit"))
                ob.command_center(inp);
            else
            {
                System.out.println("Exiting Binary Tree. Thank You");
                stayInTree = false;
            }
            //System.out.println("");
        }
    }
}
