package AppLogic;

import DA.CustomerDA;
import Domain.CustomerModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerAL{
    private CustomerDA da;
    
    public CustomerAL()throws SQLException{
        try {
            da = new CustomerDA();
        } catch (Exception e){
            throw new SQLException("Connection Error");
        }
    }
    
    //This method is used for get all the customers details
    public ArrayList<CustomerModel> getAllCustomerInfo()throws SQLException{
        ArrayList<CustomerModel> cusList =null;
        
        try {
            cusList = da.retrieveAllCustomers();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Unable view all customer details");
        }
        
        return cusList;
    }
    
    //This method is used to delete a custome details
    public void delACustomer(String cusId)throws SQLException{
        boolean success = da.delACustomer(cusId);
        
        if(success)
            throw new SQLException("Customer Id:" + cusId+" had been deleted");
        else
            throw new SQLException("Unable delete Customer details");
    }
    
    //This method is used to filter customer
    public ArrayList<CustomerModel> getFilteredCus(String[] values)throws SQLException{
        ArrayList<CustomerModel> cusList=null;
        
        try {
            cusList =da.filterCustomers(values);
        } catch (Exception e) {
            throw new SQLException("Unable get customer information");
        }
        
        return cusList;
    }

    //This method is used for get a customer details
    public CustomerModel getACustomer(String cusId)throws SQLException{
        CustomerModel cus= null;
        
        try {
            cus = da.retrieveACustomer(cusId);
        } catch (Exception e){
            throw new SQLException("Unable view Customer : "+ cusId);
        }
        return cus;
    }
    
    //This method is used to sort customer details by some specific column
    public ArrayList<CustomerModel> sortCustomerInf(String sortBy)throws SQLException{
        ArrayList<CustomerModel> cusList=null;
        
        String colName ="";
        if(sortBy.equals("Cus Id"))
            colName += "cusid";
        else if(sortBy.equals("IC No"))
            colName += "icNo";
        else if(sortBy.equals("Name"))
            colName += "cusName";
        
        try {
                cusList = da.sortCustomers(colName);
        } catch (Exception e) {
            throw new SQLException("Unable Sort");
        }
        return cusList;
    }

    //This method is used to get next customer id 
    public String getNextCusId()throws SQLException{
        String nextId="";
        try {
            String id = da.retrieveMaxCusId();
            
            if(id.equals(""))
                nextId="CUS0001";
            else{
                String subString = id.substring(3);
                int next = Integer.parseInt(subString);
                next++;
                
                String zeroDigit="0";
                
                if(next > 999)
                    zeroDigit = "";//1000
                else if(next > 99)
                    zeroDigit = "0";//0100
                else if(next >9)
                    zeroDigit = "00";//0010
                else
                    zeroDigit = "000";//0001
                
                nextId = "CUS"+zeroDigit + next;
            }
        } catch (Exception e) {
            throw new SQLException("Unable to get next customer id.");
        }
        
        return nextId;
    }
    
    //This method is used to insert values into db
    public boolean addACustomer(String[] values)throws SQLException{
        boolean success=false;
        /*
            values
            [0] - cusId
            [1] - icNo
            [2] - cusName
            [3] - gender,
            [4] - address
            [5] - email
            [6] - phone
        */
        
        if(values[1].equals(""))
            throw new SQLException("Please provides Malaysia IC number for Recording");
        else{
            if(!values[1].matches("\\d{6}\\-\\d{2}\\-\\d{4}"))
                throw new SQLException("IC No. Format 'xxxxxx-xx-xxxx'");
        }
        
        if(values[2].equals(""))
            throw new SQLException("Please enter 'Customer Name'");
        else{
            for (int i = 0; i < values[2].length(); i++) {
                if(Character.isDigit(values[2].charAt(i)))
                    throw new SQLException("'Customer Name' must be no other symbol or numbers");  
            }
        }
        
        if(values[3].equals("")||values[3]==null)
            throw new SQLException("Please select Customer's Gender");
        
        for(int i=4;i<6;i++){
            if(values[i].equals(""))
                values[i] ="-";
        }
        
        if(values[6].equals(""))
            throw new SQLException("Phone Number must be provided for contact purpose.");
        else{
            for(int i=0;i< values[6].length();i++){
                if(!Character.isDigit(values[6].charAt(i)))
                    throw new SQLException("Please just enter 'Number' without any symbol in 'Phone Number");
            }
        }
        CustomerModel cus = new CustomerModel();
        cus.setCusId(values[0]);
        cus.setIcNo(values[1]);
        cus.setCusName(values[2]);
        cus.setGender(values[3]);
        cus.setAddress(values[4]);
        cus.setEmail(values[5]);
        cus.setPhoneNo(values[6]);
        
        try {
         success = da.insertACustomer(cus);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Unable insert Record.");
        }
        
        return success;
    }
    
    //This method is used to update a customer information
    public void updateACustomer(String[] values)throws SQLException{
       
        /*
            values
            [0] - cusId
            [1] - icNo
            [2] - cusName
            [3] - gender,
            [4] - address
            [5] - email
            [6] - phone
        */
        
        if(values[1].equals(""))
            throw new SQLException("Please provides Malaysia IC number for Recording");
        else{
            if(!values[1].matches("\\d{6}\\-\\d{2}\\-\\d{4}"))
                throw new SQLException("IC No. Format 'xxxxxx-xx-xxxx'");
        }
        
        if(values[2].equals(""))
            throw new SQLException("Please enter 'Customer Name'");
        else{
            for (int i = 0; i < values[2].length(); i++) {
                if(Character.isDigit(values[2].charAt(i)))
                    throw new SQLException("'Customer Name' must be no other symbol or numbers");  
            }
        }
        
        if(values[3].equals("")||values[3]==null)
            throw new SQLException("Please select Customer's Gender");
        
        for(int i=4;i<6;i++){
            if(values[i].equals(""))
                values[i] ="-";
        }
        
        if(values[6].equals(""))
            throw new SQLException("Phone Number must be provided for contact purpose.");
        else{
            for(int i=0;i< values[6].length();i++){
                if(!Character.isDigit(values[6].charAt(i)))
                    throw new SQLException("Please just enter 'Number' without any symbol in 'Phone Number");
            }
        }
        CustomerModel cus = new CustomerModel();
        cus.setCusId(values[0]);
        cus.setIcNo(values[1]);
        cus.setCusName(values[2]);
        cus.setGender(values[3]);
        cus.setAddress(values[4]);
        cus.setEmail(values[5]);
        cus.setPhoneNo(values[6]);
        
        boolean success;

        success = da.updateCustomer(cus);
        if(success)
            throw new SQLException("Customer :"+cus.getCusId()+" had been updated.");
        else
            throw new SQLException("Unable update customer's details");


        
    }
}