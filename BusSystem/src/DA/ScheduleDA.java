package DA;

import Domain.ScheduleModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class ScheduleDA{
    private Connection con;
    private PreparedStatement preStmt;
    
    public ScheduleDA() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/busexpressticketingsystem?zeroDateTimeBehavior=convertToNull";
        String host = "root";
        String pass = "";
        
        con = DriverManager.getConnection(url, host, pass);        
    }
    
    //This method is used to retrieve schedule Id from schedule db
    public String retrieveMaxScheduleId()throws SQLException{
        preStmt = con.prepareStatement("select Max(scheduleId) from schedule");
        
        ResultSet rs = preStmt.executeQuery();
        
        String scId="";
        while(rs.next()){
            scId = rs.getString("MAX(scheduleId)");
        }
        
        if(scId == null)
            scId = "";
        
        return scId;
    }
    
    public ArrayList<ScheduleModel> retrieveAllSchedules() throws SQLException{
        preStmt = con.prepareStatement("select * from schedule");
        ResultSet rs = preStmt.executeQuery();
         ArrayList<ScheduleModel> scheduleList = new ArrayList();
        while(rs.next()){
            ScheduleModel schedule = new ScheduleModel();
            schedule.setScheduleId(rs.getString(1));
            schedule.setDepartDate(rs.getDate(2));
            schedule.setDepartTime(rs.getString(3));
            schedule.setFromLocation(rs.getString(4));
            schedule.setToLocation(rs.getString(5));
            schedule.setPrice(rs.getDouble(6));
            schedule.setAvailability(rs.getString(7));
            schedule.setBusId(rs.getString(8));
            schedule.setStaffId(rs.getString(9));
            
            scheduleList.add(schedule);
        }
       
        return scheduleList;
    }
    
    //This method is used to insert a new schedule into database
    public boolean insertASchedule(ScheduleModel sc)throws SQLException{
        String preSql = "insert into schedule values(?,?,?,?,?,?,?,?,?)";
        
        preStmt = con.prepareStatement(preSql);
        
        preStmt.setString(1,sc.getScheduleId());
        preStmt.setDate(2,new java.sql.Date(sc.getDepartDate().getTime()));
        preStmt.setString(3, sc.getDepartTime());
        preStmt.setString(4, sc.getFromLocation());
        preStmt.setString(5,sc.getToLocation());
        preStmt.setDouble(6, sc.getPrice());
        preStmt.setString(7, sc.getAvailability());
        preStmt.setString(8, sc.getBusId());
        preStmt.setString(9, sc.getStaffId());
        
        int success = preStmt.executeUpdate();

        return success>0;
    }
    
    //This method is used to retrieve schedules details by selected 'from location'
    public ArrayList<ScheduleModel> retrieveSchedulesByFromLocation(String fromLocation)throws SQLException{
        String preSql = "select * from schedule where fromLocation=?";
        
        preStmt = con.prepareStatement(preSql);
        preStmt.setString(1, fromLocation);
        
        ResultSet rs = preStmt.executeQuery();
        ArrayList<ScheduleModel> scList = new ArrayList();
        while(rs.next()){
            ScheduleModel schedule = new ScheduleModel();
            schedule.setScheduleId(rs.getString(1));
            schedule.setDepartDate(rs.getDate(2));
            schedule.setDepartTime(rs.getString(3));
            schedule.setFromLocation(rs.getString(4));
            schedule.setToLocation(rs.getString(5));
            schedule.setPrice(rs.getDouble(6));
            schedule.setAvailability(rs.getString(7));
            schedule.setBusId(rs.getString(8));
            schedule.setStaffId(rs.getString(9));
            
            scList.add(schedule);
        }
       
        return scList;
    }
    
    //This method is used to retrieve after sorted schedules details
    public ArrayList<ScheduleModel> retrieveSortSchedules(String sortBy)throws SQLException{
        preStmt = con.prepareStatement("select * from schedule order by "+sortBy);
        
        ResultSet rs = preStmt.executeQuery();
        ArrayList<ScheduleModel> scList = new ArrayList();
        while(rs.next()){
            ScheduleModel schedule = new ScheduleModel();
            schedule.setScheduleId(rs.getString(1));
            schedule.setDepartDate(rs.getDate(2));
            schedule.setDepartTime(rs.getString(3));
            schedule.setFromLocation(rs.getString(4));
            schedule.setToLocation(rs.getString(5));
            schedule.setPrice(rs.getDouble(6));
            schedule.setAvailability(rs.getString(7));
            schedule.setBusId(rs.getString(8));
            schedule.setStaffId(rs.getString(9));
            
            scList.add(schedule);
        }
        return scList;
    }
    
    //This method is used to retrieve only selected schedules 
    public ArrayList<ScheduleModel> retrieveFilterSchedules(String[] values)throws SQLException{
        String preSql = "select * from schedule "
                      + "where (availability   = ? OR availability  = ?) ";
        
        preStmt = con.prepareStatement(preSql);
        preStmt.setString(1, values[0]);
        preStmt.setString(2, values[1]);
        ResultSet rs = preStmt.executeQuery();
        ArrayList<ScheduleModel> scList=new ArrayList();
        
        while(rs.next()){
            ScheduleModel schedule = new ScheduleModel();
            schedule.setScheduleId(rs.getString(1));
            schedule.setDepartDate(rs.getDate(2));
            schedule.setDepartTime(rs.getString(3));
            schedule.setFromLocation(rs.getString(4));
            schedule.setToLocation(rs.getString(5));
            schedule.setPrice(rs.getDouble(6));
            schedule.setAvailability(rs.getString(7));
            schedule.setBusId(rs.getString(8));
            schedule.setStaffId(rs.getString(9));
            
            scList.add(schedule);
        }
        return scList;
        
    }
    
    //This method is used to retrieve the schedules with selected date
    public ArrayList<ScheduleModel> retrieveSelectedDateSchedules(Date departDate)throws SQLException{
        String preSql = "select * from schedule where departDate=?";
        preStmt = con.prepareStatement(preSql);
        preStmt.setString(1,new java.sql.Date(departDate.getTime())+"");
        
        ArrayList<ScheduleModel> scList= new ArrayList();        
        ResultSet rs = preStmt.executeQuery();

        while(rs.next()){
            ScheduleModel schedule = new ScheduleModel();
            schedule.setScheduleId(rs.getString(1));
            schedule.setDepartDate(rs.getDate(2));
            schedule.setDepartTime(rs.getString(3));
            schedule.setFromLocation(rs.getString(4));
            schedule.setToLocation(rs.getString(5));
            schedule.setPrice(rs.getDouble(6));
            schedule.setAvailability(rs.getString(7));
            schedule.setBusId(rs.getString(8));
            schedule.setStaffId(rs.getString(9));
            
            scList.add(schedule);
        }
        return scList;
    }
    
    //This method is used to update availability from schedule
    public boolean updateAvailability(String scheduleId)throws SQLException{
        String preSql = "update schedule set availability=? where scheduleId=?";
        preStmt = con.prepareStatement(preSql);
        preStmt.setString(1,"Unavailable");
        preStmt.setString(2, scheduleId);
        
        int success = preStmt.executeUpdate();
        
        return success>0;
    }
    
    //This method is used to retrieve a schedule from database
    public ScheduleModel retrieveASchedule(String scheduleId)throws SQLException{
        preStmt = con.prepareStatement("select * from schedule where scheduleId = ?");
        preStmt.setString(1, scheduleId);
        ResultSet rs = preStmt.executeQuery();
        
        ScheduleModel schedule= new ScheduleModel();

        while(rs.next()){
            schedule.setScheduleId(rs.getString(1));
            schedule.setDepartDate(rs.getDate(2));
            schedule.setDepartTime(rs.getString(3));
            schedule.setFromLocation(rs.getString(4));
            schedule.setToLocation(rs.getString(5));
            schedule.setPrice(rs.getDouble(6));
            schedule.setAvailability(rs.getString(7));
            schedule.setBusId(rs.getString(8));
            schedule.setStaffId(rs.getString(9));
        }
        return schedule;
    }
    
    //This method is used update a schedule details from database
    public boolean updateASchedule(ScheduleModel sc)throws SQLException{
        String preSql = "update schedule set departDate=?,"
                                          + "departTime=?,"
                                          + "fromLocation=?,"
                                          + "toLocation=?,"
                                          + "price= ?,"
                                          + "availability=?,"
                                          + "busId=?,"
                                          + "staffId=?"
                                          + " where scheduleId=?";
        preStmt = con.prepareStatement(preSql);
        
        
        preStmt.setDate(1,new java.sql.Date(sc.getDepartDate().getTime()));
        preStmt.setString(2, sc.getDepartTime());
        preStmt.setString(3, sc.getFromLocation());
        preStmt.setString(4,sc.getToLocation());
        preStmt.setDouble(5, sc.getPrice());
        preStmt.setString(6, sc.getAvailability());
        preStmt.setString(7, sc.getBusId());
        preStmt.setString(8, sc.getStaffId());
        preStmt.setString(9,sc.getScheduleId());
        
        int success = preStmt.executeUpdate();
        
        return success>0;
    }
    
    //This method is used to retrieve all the depart dates without duplicated
    public ArrayList<Date> retrieveAllDepartDate()throws SQLException{
        preStmt = con.prepareStatement("select departDate from schedule group by departDate");
        ResultSet rs = preStmt.executeQuery();
        
        ArrayList<Date> departDates = new ArrayList();
        while(rs.next()){
            departDates.add(rs.getDate("departDate"));
        }
        
        return departDates;
    }
   
}