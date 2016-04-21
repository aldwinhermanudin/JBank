import java.io.IOException;
import java.io.FileInputStream;
import java.io.*;
import java.util.*;
import java.text.*;

/**
 * Write a description of class CustomerFileReader here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    public CustomerFileReader()
    {

        
    }
    
    public SortedSet<Customer> readCustomers(){
        
        SortedSet<Customer> customersArraylist = new TreeSet();
        try
        {
            fileInputStream = new FileInputStream("customer_data.txt");
            objectInputStream = new ObjectInputStream(fileInputStream);
            
            customersArraylist = (SortedSet<Customer>) objectInputStream.readObject();
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
          
        return customersArraylist;
    }

}
