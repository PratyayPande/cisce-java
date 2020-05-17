import java.io.*;
class InfixApp
{//beginning of class
    public static void main(String args[])throws IOException
    {//beginning of main method
        String input,output;//declaring the variables
        while(true)
        {//beginning of while loop
            System.out.print("Enter infix. Else, enter 'END' when you are done: ");
            System.out.flush();
            input = getString();         // read a string from kbd
            if( input.equals("END") )       // quit if [Enter]
                break;
                                      // make a translator
            InToPost theTrans = new InToPost(input);
            output = theTrans.doTrans(); // do the translation
            System.out.println("Postfix is " + output + '\n');
        }//end of while loop
    }//end of main method
    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}// end class InfixApp
