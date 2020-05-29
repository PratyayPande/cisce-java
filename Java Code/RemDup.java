import java.util.*;
// removes duplicate characters in a string
// algorithm checks only the letters; does not take spaces into account
// High complexity ( > O(n^2) for n <= 26)
// Low complexity ( ~ O(n) for n >> 26)
class RemDup
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = sc.nextLine();
        for(int i=65;i<=90;i++)
        {
            int count = 0;
            char chCaps = (char)i; // small letters
            char chSmall = (char)(i+32);// capital letters
            int j=0;
            while(j<str.length())
            {
                if((str.charAt(j) == chCaps) || (str.charAt(j) == chSmall))
                {
                    count++;
                    if(count > 1)
                        str = str.substring(0, j) + str.substring(j+1);
                    else
                        ++j;
                }
                else
                    ++j;
            }
        }
        System.out.println("The modified string is: " + str);
    }
}
