package AppLogic;

import DA.StaffDA;
import Domain.StaffModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


public class StaffAL{
    StaffDA staffDA;

    public StaffAL() throws SQLException{
        try {
            staffDA = new StaffDA();
        } catch (Exception e) {
            throw new SQLException("Connection error");
        }
    }
    
    //this method is to add new staff
    public void addStaff(String staff[], Date dob) throws Exception{
        /*Staff array 12 values
 
        [0] = staff_id,
        [1] = f_name,
        [2] = l_name,
        [3] = gender
        [4] = marialStatus,
        [5] = phoneNo,
        [6] = addr,
        [7] = email,
        [8] = position,
        [9] = salary,
        [10] = password,
        [11] = recoveryQues,
        [12] = recoveryAns
        */
        
        if(staff[0].equals(""))//check empty staff id
            throw new Exception("Enter 'Generate ID' Button to get new Staff id");
        
        if(staff[1].equals(""))//fist name vs empty string
            throw new Exception("Please enter 'First Name'");
        
        if(staff[2].equals(""))//last name vs empty string
            throw new Exception("Please enter 'Last Name'");
        
        //first name vs digit
        for (int i = 0; i < staff[1].length(); i++) {
            if(Character.isDigit(staff[1].charAt(i)))
                throw new Exception("'First Name' must be no other symbol or numbers");  
        }
        
        //last name vs digit
        for (int i = 0; i < staff[2].length(); i++) {
            if(Character.isDigit(staff[2].charAt(i)))
                throw new Exception("'Last Name' must be no other symbol or numbers");  
        }       
        
        if(staff[3].equals(""))//check empty gender in combo box
            throw new Exception("Please select gender");
        
        if(dob == null)//dob cannot be null
            throw new Exception("Please choose your date of birth");
        
        if(staff[4].equals(""))//check the marial status
            throw new Exception("Please select ur current marial status.");
        
        if(staff[6].equals(""))//check the address
            throw new Exception("Please select ur current living address.");

        if(staff[7].equals(""))//check email
            throw new Exception("Email Address must be provided for information purpose");
        
        if(staff[8].equals(""))//check position
            throw new Exception("Please select the working position.");
        
        
        //salary only allows decimal number to enter
        double salary;
        try {
             salary = Double.parseDouble(staff[9]);
        } catch (Exception e){
            throw new Exception("Only enter decimal number for 'Basic salary'");
        }
        
        //password field cannot be empty
        if(staff[10].equals(""))
            throw new Exception("Password must be enter for login purpose");
        
        if(staff[11].equals(""))
            throw new Exception("Please provides a question for password recovery purpose.");
        
        if(staff[12].equals(""))
            throw new Exception("You must Provides the answer for the question");
        
        StaffModel staffModel = new StaffModel();
        staffModel.setStaffId(staff[0]);
        staffModel.setF_name(staff[1]);
        staffModel.setL_name(staff[2]);
        staffModel.setGender(staff[3]);
        staffModel.setDob(dob);
        staffModel.setMarialStatus(staff[4]);
        staffModel.setPhoneNo(staff[5]);
        staffModel.setAddress(staff[6]);
        staffModel.setEmail(staff[7]);
        staffModel.setPosition(staff[8]);
        staffModel.setSalary(salary);
        staffModel.setPassword(staff[10]);
        staffModel.setRecoveryQuestion(staff[11]);
        staffModel.setRecoveryAns(staff[12]);
        
        boolean success = staffDA.insertStaff(staffModel);
        if(!success)
            throw new Exception("Insertion error");
        else
            throw new Exception("Staff Details are added");
   
    }
    
    //password checking
    public void passwordCheck(char[] pass, char[] rePass) throws Exception{
        if(!Arrays.equals(pass, rePass))
            throw new Exception("Password not match!!!Please enter again");
    }
    
    //generating new Id
    public String generateId() throws Exception{
        String nextId="";
        try {
            String id = staffDA.retrieveStaffId();
            
            if(id.equals(""))
                nextId = "S0001";
            else{
                String subString = id.substring(1, id.length());
                int next = Integer.parseInt(subString);
                next ++;
                
                String zeroDigit="0";
                
                if(next > 999)
                    zeroDigit = "";//S9999
                else if(next > 99)
                    zeroDigit = "0";//S0100
                else if(next >9)
                    zeroDigit = "00";//S0099
                else
                    zeroDigit = "000";//S0001
                nextId = id.substring(0,1)+zeroDigit + next;
            }
        } catch (Exception e) {
            throw new Exception("Error occur in 'Staff ID Generation',Please inform Administration");
        }    
        return nextId;
    }
    
    //Retrieve all the staff information
    public ArrayList<StaffModel> getAllInformation() throws Exception{
        ArrayList<StaffModel> model;
        
        try {
            model = staffDA.retrieveAllStaffs();
            
        } catch (Exception e) {
            throw new Exception("Table content cannot be viewed.Please inform Administrator.");
        }
        
        return model;
    }
    
    //Retrieve a staff details 
    public StaffModel getAStaffInform(String id) throws Exception{
        StaffModel staff;
        try {
            staff = staffDA.retrieveStaff(id);  

        } catch (SQLException ex) {
            throw new Exception("No Record Found");
        }
        return staff;
    }
    
    //delete staff details
    public void delStaff(String id) throws Exception{
        if(id.equals(""))
            throw new Exception("Please 'Select Staff' for delete");
        
        boolean success = staffDA.deleteStaffInfo(id);
        
        if(success)
            throw new Exception("Staff '" +id+"' had been Deleted");
        else
            throw new Exception("Staff Details still available");
    }
    
    //Update staff Details
    public void updateStaff(StaffModel staff) throws Exception{
        
        boolean success =staffDA.updateStaffInfo(staff);
        if(success)    
            throw new Exception("'Successful' Updated.");
        else    
            throw new Exception("'Staff Details remain 'Unchanged'");
            
    }
    
    //filter staff details according to the gender and position
    public ArrayList<StaffModel> filterStaffInfo(String[] gender,String position) throws Exception{
        ArrayList<StaffModel> staffList=null;
        boolean  flag=false;//for SQL purpose
        
        if(gender[0]==null && gender[1]==null){
            if(position.equals(""))
                throw new Exception("Please select 'Gender' or 'Position' for filter purpose");
        }
        else{      
            if(gender[0]==null)
                gender[0]="";

            if(gender[1]==null)
                gender[1]="";
            
            if(!position.equals("") && (gender[0]!=null || gender[1]!=null))
                flag = true;
        }     

        staffList = staffDA.filterStaff(gender,position, flag);
     
        return staffList;
    }
    
    //Sort Function
    public ArrayList<StaffModel> sortStaffInfo(String sortBy) throws Exception{
        ArrayList<StaffModel> staffList=null;
        String colNameInSQL="";
        
        // , Staff ID, Salary, Position
        if(sortBy.equals("Staff ID"))
            colNameInSQL +="staffid";
        else if(sortBy.equals("Salary"))
            colNameInSQL += "salary";
        else if(sortBy.equals("Position"))
            colNameInSQL += "position";
        
        try {
            staffList = staffDA.sortStaff(colNameInSQL);
        } catch (Exception e){
            throw new Exception("System Cannot Sort according to " +sortBy); 
        }
        
        return staffList;
    }
    
    //This method is used to validate staff id
    public boolean isStaffId(String staffId)throws SQLException{
        try {
            ArrayList<StaffModel> staffList = getAllInformation();
            
            
            for(StaffModel s:staffList){
                if(staffId.equals(s.getStaffId()))
                    return true;
            }
        } catch (Exception e){
            throw new SQLException(e.getMessage());
        }
        
        return false;
    }
    
    //This method is used for password recovery purpose by answering the question
    public boolean matchAnswer(String staffId, String ans)throws SQLException{
        
        try {
            StaffModel staff = getAStaffInform(staffId);
            String originalAns = staff.getRecoveryAns().toLowerCase();
            String lowercaseAns = ans.toLowerCase();
            
            if(originalAns.equals(lowercaseAns)){
                return true;
            }
            
        } catch (Exception e) {
            throw new SQLException("Unable match your answer");
        }
        
        return false;
    }
    
}