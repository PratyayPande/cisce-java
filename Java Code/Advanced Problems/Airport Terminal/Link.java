// class to store the values in each node and to access each data in each node

public class Link//declaring the class
{// beginning of class block
    Link next;// declaring object
    String data;// declaring variable to store data
    Link(String str) // constructor to store data
    {// beginning of constructor
        data = str;// storing data
    }// end of constructor
    String nodeData()// method to display data
    {// beginning of method
        return data;// returning the data stored in each node
    }// end of method
}// end of class
