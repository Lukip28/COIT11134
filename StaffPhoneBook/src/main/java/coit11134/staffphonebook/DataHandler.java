/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coit11134.staffphonebook;

import java.util.*;
import java.io.*;

/**
 *
 * @author luke_
 */
public class DataHandler 
{
    private String fileName;
    private ArrayList<PhoneNumber>phoneNoList;
    
    public DataHandler(String fileName) throws FileNotFoundException 
    {
        this.fileName = fileName;
        this.phoneNoList = new ArrayList<PhoneNumber>();
        readDataFile();
    }
    
    private void readDataFile() throws FileNotFoundException 
    {
        try 
        {
            Scanner in = new Scanner(new FileReader(fileName));
            String myEntry = "";
            String name = "";
            String phone = "";
            
            while (in.hasNextLine()) 
            {
                myEntry = in.nextLine();
                StringTokenizer st = new StringTokenizer(myEntry, ",");
                
                while (st.hasMoreTokens()) 
                {
                    name = st.nextToken();
                    phone = st.nextToken();
                }
                
                PhoneNumber ph = new PhoneNumber(name, phone);
                phoneNoList.add(ph);
            }
            in.close();
        }
        catch (ArrayIndexOutOfBoundsException ex) 
        {
            
        }
        catch (FileNotFoundException ex) 
        {
            
        }
    }
    
    // Method for saving all phone numbers from the phoneNo ArrayList to the text file
    public void saveData() 
    {
        try 
        {
            Formatter out = new Formatter(fileName);
            int totalNumbers = phoneNoList.size();
            for (int i = 0; i < totalNumbers; i++) 
            {
                PhoneNumber curPhoneNo = phoneNoList.get(i);
                out.format("%s\n", curPhoneNo.toString());
            }
            out.close();
        }
        catch (SecurityException ex) 
        {
            
        }
        catch (FileNotFoundException ex) 
        {
            
        }
    }
    
    // Method for adding a phone number to the phoneNo ArrayList
    public void addPhoneNo(PhoneNumber ph) 
    {
        phoneNoList.add(ph);
    }
    
    public String getDisplayOutput() 
    {
        String allPhone = "";
        int count = phoneNoList.size();
        for (int i = 0; i < count; i++) 
        {
            PhoneNumber curPhoneNo = phoneNoList.get(i);
            allPhone += curPhoneNo.toString() + "\n";
        }
        return allPhone + "\n" + "Total number of phone entry is: " + count;
    }
}
