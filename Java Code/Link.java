public class Link//declaring the class
{// beginning of class block
    Link next;// declaring object
    int data;// declaring variable to store data
    Link()
    {
        next = null;
    }
    Link(int num)// constructor to store data
    {
        data = num;// storing data
    }
    int nodeData()// method to display data
    {
        return data;// returning the data stored in each node
    }
}// end of class
