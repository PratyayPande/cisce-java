package Assistant;
public class SumofDigits
{
    public int sumDigits(int num)
    {
        int c=0;
        while(num > 0)
        {
            c += num%10;
            num = num/10;
        }
        return(c);
    }
}