package DA;

import Domain.CustomerModel;
import Domain.StaffModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDA{
 private Connection con;
    private PreparedStatement preStmt;
    
    public CustomerDA() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/busexpressticketingsystem?zeroDateTimeBehavior=convertToNull";
        String host = "root";
        String pass = "";
        
        con = DriverManager.getConnection(url, host, pass);        
    }
    
    //This method is used to insert a new customer into db
    public boolean insertACustomer(CustomerModel cus)throws SQLException{
        
        String preSql = "insert into customer values(?,?,?,?,?,?,?)";
        preStmt = con.prepareStatement(preSql);
        
        preStmt.setString(1, cus.getCusId());
        preStmt.setString(2, cus.getIcNo());
        preStmt.setString(3,cus.getCusName());
        preStmt.setString(4,cus.getGender());
        preStmt.setString(5, cus.getAddress());
        preStmt.setString(6, cus.getEmail());
        preStmt.setString(7, cus.getPhoneNo());
        
        int success = preStmt.executeUpdate();
        
        return success>0;
    }
    
    //This method is used to retrieve all customer details
    public ArrayList<CustomerModel> retrieveAllCustomers()throws SQLException{
        preStmt = con.prepareStatement("select * from customer");
        
        ResultSet rs = preStmt.executeQuery();
        ArrayList<CustomerModel> cusList = new ArrayList();
        
        while(rs.next()){
            CustomerModel cus = new CustomerModel();
            
            cus.setCusId(rs.getString(1));
            cus.setIcNo(rs.getString(2));
            cus.setCusName(rs.getString(3));
            cus.setGender(rs.getString(4));
            cus.setAddress(rs.getString(5));
            cus.setEmail(rs.getString(6));
            cus.setPhoneNo(rs.getString(7));
            
            cusList.add(cus);
        }
        
        return cusList;
    }
    
    //This method is used delete a customer
    public boolean delACustomer(String cusId)throws SQLException{
        
        String preSql = "delete From customer where cusId = ?";
        
        preStmt = con.prepareStatement(preSql);
        preStmt.setString(1, cusId);
        
        int row = preStmt.executeUpdate();
        
        return row >0;
    }
    
    //This method is used to filter the customer information
    public ArrayList<CustomerModel> filterCustomers(String[] gender) throws SQLException{
        String preSql = "select * from customer "
                      + "where (gender   = ? OR gender = ?) ";
        
        preStmt = con.prepareStatement(preSql);
        
        preStmt.setString(1, gender[0]);
        preStmt.setString(2, gender[1]);

        ResultSet rs = preStmt.executeQuery();
        
        ArrayList<CustomerModel> cusList = new ArrayList();
        
        while(rs.next()){
            CustomerModel cus = new CustomerModel();
            
            cus.setCusId(rs.getString(1));
            cus.setIcNo(rs.getString(2));
            cus.setCusName(rs.getString(3));
            cus.setGender(rs.getString(4));
            cus.setAddress(rs.getString(5));
            cus.setEmail(rs.getString(6));
            cus.setPhoneNo(rs.getString(7));
            
            cusList.add(cus);
        }
        
        return cusList;
    }
    
    //This method is used to retrieve a customer details
    public CustomerModel retrieveACustomer(String cusId)throws SQLException{
        CustomerModel cus = new CustomerModel();
        
        //Prepare sql for retrieve statement
        String preSql = "select * from customer where cusId = ?";
        preStmt = con.prepareStatement(preSql);
        preStmt.setString(1, cusId);
        
        ResultSet rs = preStmt.executeQuery();
        while(rs.next()){              
            cus.setCusId(rs.getString(1));
            cus.setIcNo(rs.getString(2));
            cus.setCusName(rs.getString(3));
            cus.setGender(rs.getString(4));
            cus.setAddress(rs.getString(5));
            cus.setEmail(rs.getString(6));
            cus.setPhoneNo(rs.getString(7));
        }
        return cus;
    }
    
    //This method is used to sort customer details
    public ArrayList<CustomerModel> sortCustomers(String sortBy)throws SQLException{
        
        preStmt = con.prepareStatement("select * from customer order by "+sortBy);
        
        ResultSet rs = preStmt.executeQuery();
        ArrayList<CustomerModel> cusList = new ArrayList();
        
        while(rs.next()){
            CustomerModel cus = new CustomerModel();
            
            cus.setCusId(rs.getString(1));
            cus.setIcNo(rs.getString(2));
            cus.setCusName(rs.getString(3));
            cus.setGender(rs.getString(4));
            cus.setAddress(rs.getString(5));
            cus.setEmail(rs.getString(6));
            cus.setPhoneNo(rs.getString(7));
            
            cusList.add(cus);
        }
        
        return cusList;
    }
    
    //This method is used to retrieve max customer id from db
    public String retrieveMaxCusId() throws SQLException{
        String preSql = "select MAX(cusId) from customer";
        preStmt = con.prepareStatement(preSql);
        
        ResultSet rs = preStmt.executeQuery();
        String cusId="";
        
        while(rs.next()){
            cusId = rs.getString("MAX(cusId)");
        }
        
        if(cusId ==null)
            cusId ="";
        return cusId;
    }
    
    //This method is used update a customer details
    public boolean updateCustomer(CustomerModel cus)throws SQLException{
        String preSql = "update customer set icNo=?,"
                                          + "cusName=?,"
                                          + "gender=?,"
                                          + "address=?,"
                                          + "email= ?,"
                                          + "phoneNo=?"
                                          + " where cusId=?";
        
        preStmt = con.prepareStatement(preSql);
        
        preStmt.setString(1, cus.getIcNo());
        preStmt.setString(2,cus.getCusName());
        preStmt.setString(3,cus.getGender());
        preStmt.setString(4, cus.getAddress());
        preStmt.setString(5, cus.getEmail());
        preStmt.setString(6, cus.getPhoneNo());
        preStmt.setString(7, cus.getCusId());
        
        int success = preStmt.executeUpdate();
        
        return success>0;
    }
}