import java.io.IOException;
import java.io.FileInputStream;
import java.io.*;
import java.util.*;
import java.text.*;

/**
 * Class to read the binary file of the Customer object SortedSet
 * 
 * @author Aldwin Hermanudin 
 * @version 13.5.2016
 */

public class CustomerFileReader
{
    // instance variables - replace the example below with your own
    private File objectFile;
    private ObjectInputStream objectInputStream;
    private FileInputStream fileInputStream;

    /**
     * Constructor for objects of class CustomerFileReader
     */
    public CustomerFileReader(){

    }

    /**
     * Method readCustomers to read the file of the binary data of the SortedSet Customer object
     *
     * @return The return value is a sortedset object, or null if failed
     */
    public SortedSet<Customer> readCustomers(){
        SortedSet customersArraylist = new TreeSet<Customer>();
        SortedSet<Customer> customersOutputlist = new TreeSet<Customer>();
        try
        {
            fileInputStream = new FileInputStream("customer_data.jbank");
            objectInputStream = new ObjectInputStream(fileInputStream);

            customersArraylist = (SortedSet) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();

        }catch(IOException ioe){
            ioe.printStackTrace();
            return null;
        }catch(ClassNotFoundException c){
            System.out.println("Class not found");
            c.printStackTrace();
            return null;
        }     

        //Deep-copy
        Iterator it = customersArraylist.iterator();
        while (it.hasNext()) {
            Customer element = (Customer) it.next();
            customersOutputlist.add(element);
        }

        return customersOutputlist;
    }

}
