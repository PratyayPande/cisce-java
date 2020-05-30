import java.io.*;
import java.util.*;
public class CheckAnagrams
{
    String str = "";
    HashMap<Character, Integer> map = new HashMap<>();
    
    int calFreq(String s, char c)
    {
        int count=0;
        char cLo = Character.toLowerCase(c),cUp = Character.toUpperCase(c);
        for(int i=0; i<str.length();i++)
        {
            if((str.charAt(i) == cLo)||(str.charAt(i) == cUp))
                count++;
        }
        return count;
    }
    public static void main(String[] args)throws IOException
    {
        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);
        System.out.print("Enter the first string: ");
        String str1 = in.readLine();
        System.out.print("Enter the second string: ");
        String str2 = in.readLine();
        CheckAnagrams ob = new CheckAnagrams();
        boolean b = true;
        for(int i=65;i<=90 && b;i++)
        {
            if(ob.calFreq(str1,(char)i) != ob.calFreq(str2,(char)i))
                b = false;
        }
        if(b)
            System.out.println("The strings are Anagrams");
        else
            System.out.println("The strings are NOT Anagrams");
    }
}
