package DA;

import Domain.StaffModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StaffDA{
    private Connection con;
    private PreparedStatement preStmt;

    public StaffDA() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/busexpressticketingsystem?zeroDateTimeBehavior=convertToNull";
        String host = "root";
        String pass = "";
        
        con = DriverManager.getConnection(url,host, pass);
    }
    
    //This method is used to insert a new staff records into database
    public boolean insertStaff(StaffModel staff) throws SQLException{
        
        //prepare sql statement
        String preSql = "insert into staff values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        preStmt = con.prepareStatement(preSql);
        
        preStmt.setString(1, staff.getStaffId());
        preStmt.setString(2, staff.getF_name());
        preStmt.setString(3, staff.getL_name());
        preStmt.setString(4, staff.getGender());
        preStmt.setDate(5, new java.sql.Date(staff.getDob().getTime()));
        preStmt.setString(6, staff.getMarialStatus());
        preStmt.setString(7, staff.getPhoneNo());
        preStmt.setString(8, staff.getAddress());
        preStmt.setString(9, staff.getEmail());
        preStmt.setString(10, staff.getPosition());
        preStmt.setDouble(11, staff.getSalary());
        preStmt.setString(12, staff.getPassword());
        preStmt.setString(13, staff.getRecoveryQuestion());
        preStmt.setString(14, staff.getRecoveryAns());    

        int insertNo = preStmt.executeUpdate();
        
        if(insertNo > 0)
            return true;
        
        return false;
    }
    
    //Tjis method is used for retrieve staff id for generate next staff id purpose
    public String retrieveStaffId() throws SQLException{
        String preSql = "select MAX(StaffId) from staff";
        preStmt = con.prepareStatement(preSql);
        
        ResultSet rs = preStmt.executeQuery();
        
        String staffId="";
        while(rs.next()){
            staffId = rs.getString("MAX(StaffId)");
        }
        if(staffId == null)
            staffId="";
        
        return staffId;
    }
    
    //This method is used to retrieve all the results from the staff table 
    public ArrayList<StaffModel> retrieveAllStaffs() throws SQLException{
        ArrayList<StaffModel> listOfStaff = new ArrayList();
        
        //prepare sql statement
        String preSql = "select * from staff";
        preStmt = con.prepareStatement(preSql);
        ResultSet rs = preStmt.executeQuery();
        
        while(rs.next()){
            StaffModel staff = new StaffModel();
            
            staff.setStaffId(rs.getString("staffid"));
            staff.setF_name(rs.getString("f_name"));
            staff.setL_name(rs.getString("l_name"));
            staff.setGender(rs.getString("gender"));
            staff.setPosition(rs.getString("position"));
            staff.setSalary(rs.getDouble("salary"));
            staff.setPassword(rs.getString("password"));
            listOfStaff.add(staff);
        }
        return listOfStaff;
    }
 
    //Rerieve only one staff information - for searching purpose
    public StaffModel retrieveStaff(String staffId) throws SQLException{
        StaffModel staff = new StaffModel();
        
        //Prepare sql for retrieve statement
        String preSql = "select * from staff where staffId = ?";
        preStmt = con.prepareStatement(preSql);
        preStmt.setString(1, staffId);
        
        ResultSet rs = preStmt.executeQuery();
        while(rs.next()){            
            staff.setStaffId(rs.getString("staffid"));
            staff.setF_name(rs.getString("f_name"));
            staff.setL_name(rs.getString("l_name"));
            staff.setGender(rs.getString("gender"));
            staff.setDob(rs.getDate("dob")); 
            staff.setMarialStatus(rs.getString("MarrialStatus"));
            staff.setPhoneNo(rs.getString("phoneNo"));
            staff.setAddress(rs.getString("address"));
            staff.setEmail(rs.getString("email"));
            staff.setPosition(rs.getString("position"));
            staff.setSalary(rs.getDouble("salary"));
            staff.setPassword(rs.getString("password"));
            staff.setRecoveryQuestion(rs.getString("recoveryQuestion"));
            staff.setRecoveryAns(rs.getString("recoveryAnswer"));
           
        }
        return staff;
    }
    
    //This method is used to delete a staff record from database
    public boolean deleteStaffInfo(String staffId) throws SQLException{
        String preSql = "delete From staff where staffId = ?";
        preStmt = con.prepareStatement(preSql);
        preStmt.setString(1, staffId);
        
        int success = preStmt.executeUpdate();
        
        if(success>0)
            return true;
        return false;
    }
    
    //This method is used to update the staff Information
    public boolean updateStaffInfo(StaffModel staff) throws SQLException{
        String preSql = "update staff set f_name =?,l_name =?,gender=?,"
                                        + "dob = ?, phoneNo =?,address=?,"
                                        + "email =?, position =?, salary =?,"
                                        + "password=?, marrialStatus =?"
                        +"where staffid = ?";
        preStmt = con.prepareStatement(preSql);
        
        preStmt.setString(1,  staff.getF_name());
        preStmt.setString(2,  staff.getL_name());
        preStmt.setString(3,  staff.getGender());
        preStmt.setDate(4,   new java.sql.Date(staff.getDob().getTime()));
        preStmt.setString(5,  staff.getPhoneNo());
        preStmt.setString(6,  staff.getAddress());
        preStmt.setString(7,  staff.getEmail());
        preStmt.setString(8,  staff.getPosition());
        preStmt.setDouble(9,  staff.getSalary());
        preStmt.setString(10, staff.getPassword());
        preStmt.setString(11, staff.getMarialStatus());
        preStmt.setString(12, staff.getStaffId());
                
                
        int success = preStmt.executeUpdate();
        
        if(success > 0)
            return true;        
        return false;
    }
    
    //This method is used to filter the staff information
    public ArrayList<StaffModel> filterStaff(String[] gender, String position, boolean flag) throws SQLException{
        String preSql = "select * from staff "
                      + "where (gender   = ? OR gender = ?) "
                      + "OR    (position = ?)";
        
        if(flag){
            preSql = "select * from staff "
                   + "where (gender   = ? OR gender = ?) "
                   + "AND    (position = ?)";
        }
        
        preStmt = con.prepareStatement(preSql);
        
        preStmt.setString(1, gender[0]);
        preStmt.setString(2, gender[1]);
        preStmt.setString(3, position);
        ResultSet rs = preStmt.executeQuery();
        
        ArrayList<StaffModel> staffList = new ArrayList();
        
        while(rs.next()){
            StaffModel staff = new StaffModel();
            staff.setStaffId(rs.getString("staffid"));
            staff.setF_name(rs.getString("f_name"));
            staff.setL_name(rs.getString("l_name"));
            staff.setGender(rs.getString("gender"));
            staff.setDob(rs.getDate("dob"));
            staff.setMarialStatus(rs.getString("MarrialStatus"));
            staff.setPhoneNo(rs.getString("phoneNo"));
            staff.setAddress(rs.getString("address"));
            staff.setEmail(rs.getString("email"));
            staff.setPosition(rs.getString("position"));
            staff.setSalary(rs.getDouble("salary"));
            staff.setPassword(rs.getString("password"));
            staff.setRecoveryQuestion(rs.getString("recoveryQuestion"));
            staff.setRecoveryQuestion(rs.getString("recoveryAnswer"));
           
            
            staffList.add(staff);
        }
        
        return staffList;
    }
    
    //This metod is used to sort the staff according to the user request
    public ArrayList<StaffModel> sortStaff(String sortBy) throws SQLException{
        ArrayList<StaffModel> staffList= new ArrayList();
        
        preStmt = con.prepareStatement("select * from staff order by "+sortBy);
        
        ResultSet rs = preStmt.executeQuery();
        
        while(rs.next()){
            StaffModel staff = new StaffModel();
            
            staff.setStaffId(rs.getString("staffid"));
            staff.setF_name(rs.getString("f_name"));
            staff.setL_name(rs.getString("l_name"));
            staff.setGender(rs.getString("gender"));
            staff.setPosition(rs.getString("position"));
            staff.setSalary(rs.getDouble("salary"));
            staff.setPassword(rs.getString("password"));
            staffList.add(staff);
        }
        
        return staffList;
    }
}