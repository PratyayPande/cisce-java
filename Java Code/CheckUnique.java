import java.io.*;
// accept a string and determine if the characters in the string are unique or not
class CheckUnique
{
    public static void main(String[] args)throws IOException
    {
        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);
        System.out.print("Enter the string: ");
        String str = in.readLine();
        int num = 65;
        boolean b = true;
        outer_loop : for(int i=num; i<num+26;i++) // assigning id to the loop to access it from inside the loop
        {
            char chCaps = (char)i;
            char chSmall = (char)(i+32);
            int count = 0;
            for(int j=0;j<str.length();j++)
            {
                if((str.charAt(j) == chCaps)||(str.charAt(j) == chSmall))
                    count++;
                if(count >= 2)
                {
                    b = false;
                    break outer_loop;
                }
            }
        }
        if(b)
            System.out.println("Characters unique");
        else
            System.out.println("Characters not unique");
    }
}
