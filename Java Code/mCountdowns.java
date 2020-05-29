import java.io.*;
import java.util.*;
class mCountdowns
{
    public static void main(String[] srgs)throws IOException
    {
        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);
        System.out.print("Enter the number of elements in the array: ");
        int num = Integer.parseInt(in.readLine());
        System.out.print("Enter the value of m: ");
        int m = Integer.parseInt(in.readLine());
        int[] a = new int[num];
        System.out.println("Enter the elements of the array: ");
        
        // Alternative 1: Adding elements manually
        /*
        for(int i=0;i<num;i++)
        {
            a[i] = Integer.parseInt(in.readLine());
        }
        // END
        */

        // Alternative 2: Adding elements using String array and regex
        
        String[] str = in.readLine().split(" ");
        for(int i=0;i<num;i++)
        {
            a[i] = Integer.parseInt(str[i]);
        }

        // END
        
        int count = 0;
        //k = m;
        for(int i=0;i<num-m+1;i++)
        {
            int j=0;
            if(a[i] == m)
            {
                boolean b = true;
                for(j=1;j<m&&b;j++)
                {
                    if(a[i+j] != m-j)
                        b = false;
                }
                if(b)
                {
                    count++;
                    i += m;
                }
            }
        }
        System.out.println("Number of m-countdowns: " + count);
    }
}
