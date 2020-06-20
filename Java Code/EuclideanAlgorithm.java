import java.io.*;
public class EuclideanAlgorithm
{
    public long gcd(long a, long b)
    {
        long t;
        // gcd(a,b) = gcd(b,a%b)
        while((a != 0)&&(b != 0))
        {
            t = a%b;
            a = b;
            b = t;
        }
        return(a+b);
    }
    public static void main(String[] args)throws IOException
    {
        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);
        System.out.print("Enter the first number: ");
        long a = Long.parseLong(in.readLine());
        System.out.print("Enter the second  number: ");
        long b = Long.parseLong(in.readLine());
        EuclideanAlgorithm ob = new EuclideanAlgorithm();
        System.out.println("The gcd of the 2 numbers is: " + ob.gcd(a,b));

    }
}
