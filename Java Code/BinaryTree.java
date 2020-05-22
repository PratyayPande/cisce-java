
public class BinaryTree
{
    private BinaryTree root,  currentnode;
    private BinaryTree left, right, up;//pointers to the left and right children
    private boolean root_exists;
    private String current_path;
    private int data = 0;
    public BinaryTree()
    {
        root = null;
        root_exists = false;
    }
    private BinaryTree(int num)
    {
        data = num;
    }
    public String filepath()
    {
        updateCurrentPath();
        return current_path;
    }
    public boolean treeExists()
    {
        return root_exists;
    }
    private void viewTree(BinaryTree ob, int indent)
    {
        if(ob != null)
        {
            System.out.print(ob.data);
            System.out.print(": L -> ");
            
            indent += Integer.toString(ob.data).length();
            ob.viewTree(ob.left,indent+7);
            System.out.println("");
            //printing the indent string for printing the tree
            for(int i=0;i<indent;i++)
                System.out.print(" ");
            //if(ob != root)
            //    indent += 7;            
            System.out.print("");
            
            System.out.print(": R -> ");
            
            ob.viewTree(ob.right,indent+7);
            System.out.println();
        }
        else
            System.out.print("NULL");
    }
    private void node_navigator(String str)
    { // navigate through the nodes in the tree the same way we navigate through files using cmd or terminal
        str = str.trim();
        String[] inp = str.split("/");
        int i = str.indexOf(" ");
        String files = inp[0];
        BinaryTree bck = currentnode;
        for(i = 0;i<inp.length;i++)
        {
            try
            {
                String fl = inp[i];
                if(fl.equals("u")||fl.equals(".."))
                    currentnode = currentnode.up;
                else if(fl.equals("r"))
                    currentnode = currentnode.right;
                else if(fl.equals("l"))
                    currentnode = currentnode.left;
                else if(fl.equals("root"))
                    currentnode = root;
                else
                {
                    System.out.println("INVALID SYMBOL: '" + fl + "'. Node change command not found");
                    System.out.println("Must be eiither 'u', 'r' or 'l' for up, left and right");
                    System.out.println("\nError(s) found! \n\tAborting Operation. Node switch NOT successful \n\tReturning to original node.");
                    currentnode = bck;
                }
            }
            catch(NullPointerException ob1)
            {
                System.out.println("NULL NODE ENCOUNTERED!! Node change unsuccessful \n\t Reverting back to original node.");
                currentnode = bck;
                i = files.length();
            }
        }
        updateCurrentPath();
    }
    private void insertNode(int n, boolean direction, boolean doOverwrite)
    {//inserts node to the left or the right of the current node
        if(direction)
        {
            if((!doOverwrite)&&(currentnode.left != null))
            {
                System.out.println("\tThe node left to the current node already contains data! \nTo overwrite existing data specify 'ow' after specifying direction");
                System.out.println("Example code: \n\t insert l ow 123 \nThis will overwrite the existing data with 123");
            }
            if((doOverwrite))
            {
                currentnode.left.data = n;
            }
            else
            {
                BinaryTree newnode = new BinaryTree(n);
                currentnode.left = newnode;
                newnode.up = currentnode;
            }
        }
        if(!direction)
        {
            if((!doOverwrite)&&(currentnode.right != null))
            {
                System.out.println("\tCurrent node already contains data! \nTo overwrite existing data specify 'ow' after specifying direction");
                System.out.println("Example code: \n\t insert r ow 123 \nThis will overwrite the existing data with 123");
            }
            if((doOverwrite))
            {
                currentnode.left.data = n;
            }
            else
            {
                BinaryTree newnode = new BinaryTree(n);
                currentnode.right = newnode;
                newnode.up = currentnode;
            }
        }

    }
    private void updateCurrentPath()
    {
        String path = ">";
        for(BinaryTree ob = currentnode; ob != null; ob = ob.up)
            path += "/" + Integer.toString(ob.data);
        current_path = path;
    }
    private void insertRoot(int n)
    {
        root = new BinaryTree(n);
        currentnode = root;
        updateCurrentPath();
    }
    public boolean syntaxCheck(String s)
    {
        
    }
    public void command_center(String str)
    {
        str = str.trim() + " ";
        int i = str.indexOf(" ");
        boolean direction = false, overwrite = false;
        String[] rem = str.split(" ");
        String cmd = rem[0];
        switch(cmd)
        {
            case "cd":
                node_navigator(rem[1]);
            break;
            case "insert":
                String[] fls = str.substring(i + 1).split(" ");
                if(fls.length == 1)
                {
                    System.out.println("Default: Inserting Element on the left node to the current node.");
                }
                else
                {
                    for(i=0;i<fls.length;i++)
                    {
                        if(fls[i].equals("l")||fls[i].equals("r"))
                            direction = (fls[i].equals("l"));
                        if(fls[i].equals("ow"))
                            overwrite = true;
                    }
                }
                if(root != null)
                    insertNode(Integer.parseInt(fls[fls.length - 1]),direction, overwrite);
                else
                    insertRoot(Integer.parseInt(fls[fls.length - 1]));
            break;
            case "display":
                viewTree(currentnode,0);
            break;
            case "ls":
                viewTree(currentnode,0);
            break;
            default:
                System.out.println("COMMAND NOT RECOGNISED!! Please check your commmand and try again");
            break;
        }
    }

    /*public void insert(int val)
    {
        BinaryTree newnode = null;
        //BinaryTree newnode = new BinaryTree(val);
        if((root == null)||(val == false))
            root =  new BinaryTree(val);
        else
        {
            if(root.left == null)
            {
                root.left = new BinaryTree(val);
                //st = false;
                newnode = root.left;
            }
            else if(root.right == null)
                root.right = new BinaryTree(val);
            newnode.up = root;
        }
    }*/
}
