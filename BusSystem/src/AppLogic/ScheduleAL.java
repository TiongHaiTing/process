package AppLogic;

import DA.ScheduleDA;
import Domain.BusModel;
import Domain.ScheduleModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class ScheduleAL{
    private ScheduleDA da;
    
    public ScheduleAL()throws SQLException{
        try {
            da = new ScheduleDA();
        } catch (Exception e){
            throw new SQLException("Connection Error");
        }
    }
    
    //This method us used to get next schedule id
    public String getNextScheduleId()throws SQLException{        
        String scheduleId = da.retrieveMaxScheduleId();
        
        if(scheduleId.equals(""))
            return "SCH0000";
        
        String sub = scheduleId.substring(3,7);
        int num = Integer.parseInt(sub);
        num++;
        
        String zero="";
        
        if(num< 10)
            zero+="000";
        else if(num< 100)
            zero+="00";
        else if(num<1000)
            zero+="0";
        
        String nextId = ("SCH" + zero + num);
        
        return nextId;
    }
    
    public double getPrice(String fromLocation, String toLocation, String busId)throws Exception{
        double price=0.0;
        
        if(fromLocation.equals(""))
            throw new Exception("Please select where the 'bus depart'.");
        else if(toLocation.equals(""))
            throw new Exception("Please select the 'Destination'.");
        else if(busId==null || busId.equals(""))
            throw new Exception("Please select the 'Bus ID'.");
        
        BusAL busAl = new BusAL();
        BusModel bus = busAl.getABusInfo(busId);
        String busTypeId = bus .getBusTypeId();
        
        /*
        Taiping
        Kuala Lumpur
        Gen-Highlands
        Johor
        Kuantan
        Malacca
        KLIA
        */
        if(fromLocation.equals("Taiping")){
            if(toLocation.equals("Kuala Lumpur"))
                price = kl(busTypeId);
            else if(toLocation.equals("Gen-Highlands"))
                price = gh(busTypeId);
            else if(toLocation.equals("Johor"))
                price = johor(busTypeId);
            else if(toLocation.equals("Kuantan"))
                price = kuantan(busTypeId);
            else if(toLocation.equals("Malacca"))
                price = malacca(busTypeId);
            else if(toLocation.equals("KLIA"))
                price = klia(busTypeId);
            
        }
        else{
            if(fromLocation.equals("Kuala Lumpur"))
                price = kl(busTypeId);
            else if(fromLocation.equals("Gen-Highlands"))
                price = gh(busTypeId);
            else if(fromLocation.equals("Johor"))
                price = johor(busTypeId);
            else if(fromLocation.equals("Kuantan"))
                price = kuantan(busTypeId);
            else if(fromLocation.equals("Malacca"))
                price = malacca(busTypeId);
            else if(fromLocation.equals("KLIA"))
                price = klia(busTypeId);
        }

        return price;
    }
    
    private double kl(String busTypeId){
        double price=0.0;
        if(busTypeId.equals("BT001"))
            price = 30;
        else if(busTypeId.equals("BT002"))
            price = 40;
        else if(busTypeId.equals("BT003"))
            price = 50;
        else if(busTypeId.equals("BT004"))
            price = 60;
        
        return price;
    }
    
    private double gh(String busTypeId){
        double price=0.0;
        if(busTypeId.equals("BT001"))
            price = 45;
        else if(busTypeId.equals("BT002"))
            price = 60;
        else if(busTypeId.equals("BT003"))
            price = 70;
        else if(busTypeId.equals("BT004"))
            price = 100;
        return price;
    }
    
    private double johor(String busTypeId){
        double price=0.0;
        if(busTypeId.equals("BT001"))
            price = 45;
        else if(busTypeId.equals("BT002"))
            price = 60;
        else if(busTypeId.equals("BT003"))
            price = 70;
        else if(busTypeId.equals("BT004"))
            price = 85;
        return price;
    }
    
    private double kuantan(String busTypeId){
        double price=0.0;
        if(busTypeId.equals("BT001"))
            price = 35;
        else if(busTypeId.equals("BT002"))
            price = 45;
        else if(busTypeId.equals("BT003"))
            price = 50;
        else if(busTypeId.equals("BT004"))
            price = 75;
        return price;
    }
    
    private double malacca(String busTypeId){
        double price=0.0;
        if(busTypeId.equals("BT001"))
            price = 55;
        else if(busTypeId.equals("BT002"))
            price = 60;
        else if(busTypeId.equals("BT003"))
            price = 75;
        else if(busTypeId.equals("BT004"))
            price = 85;
        return price;
    }
    
    private double klia(String busTypeId){
        double price=0.0;
        if(busTypeId.equals("BT001"))
            price = 50;
        else if(busTypeId.equals("BT002"))
            price = 60;
        else if(busTypeId.equals("BT003"))
            price = 80;
        else if(busTypeId.equals("BT004"))
            price = 95;
        return price;
    }
    
    //This method is used to add new schedule
    public void addSchedule(String[] values, Date departDate)throws SQLException{
        /*
        values[]
        [0] - staffId
        [1] - scheduleId
        [2] - busId
        [3] - departTime
        [4] - fromLocation
        [5] - toLocation
        [6] - price

        Date departDate
        */

        values[0] ="S0001";
        
        if(values[2].equals("") ||values[2]==null ){
            throw new SQLException("Please select bus ID");
        }
        else if(departDate==null)
            throw new SQLException("Invalid Depart Date.Please choose again!");
        else if(values[3].equals(""))            
            throw new SQLException("Please select a 'Bus Depart Time'");
        else if(values[4].equals(""))
            throw new SQLException("Please select where 'the location of bus depart'");
        else if(values[5].equals(""))
            throw new SQLException("Please select the 'Destination'");        
        else if(values[6].equals("")||values[6] ==null) 
            throw new SQLException("Please click 'Check Price' Button to get the ticket price");
        
        ScheduleModel schedule = new ScheduleModel();
        schedule.setStaffId(values[0]);
        schedule.setScheduleId(values[1]);
        schedule.setBusId(values[2]);
        schedule.setDepartDate(departDate);
        schedule.setDepartTime(values[3]);
        schedule.setFromLocation(values[4]);
        schedule.setToLocation(values[5]);
        schedule.setAvailability("Available");
        double price = Double.parseDouble(values[6]);
        schedule.setPrice(price);
        
        if(matchSchedule(schedule)){
            throw new SQLException("Schedule already Exist Or Bus : "+values[2] 
                                  +" is not available during time: "+ values[3]);
        }
        else{

            boolean success = da.insertASchedule(schedule);
            
            if(success)
                throw new SQLException("Schedule was Added into database");
            else
                throw new SQLException("Unable insert a data");
        }
    }
    
    //This method is used to matching the new schedule with existing schedule
    public boolean matchSchedule(ScheduleModel sc)throws SQLException{
        boolean flag=false;
        try {
            ArrayList<ScheduleModel> scheduleList = da.retrieveAllSchedules();

            if(scheduleList ==null)
                return false;

            for(ScheduleModel s: scheduleList){
                if(!s.getScheduleId().equals(sc.getScheduleId())){
                    if(sc.getBusId().equals(s.getBusId())){
                        Date d = new java.sql.Date(sc.getDepartDate().getTime());

                        if(d.toString().equals(s.getDepartDate().toString())){
                            if(sc.getDepartTime().equals(s.getDepartTime())){
                                if(s.getAvailability().equals("Available")){
                                    flag = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        } catch (SQLException e){
            throw new SQLException("Unable check schedule from database");
        }
        
        return flag;
    }
    
    //This method is used to get all the schedules from database
    public ArrayList<ScheduleModel> getAllSchedules()throws SQLException{
        ArrayList<ScheduleModel> scheduleList= new ArrayList();
        
        try {
            scheduleList = da.retrieveAllSchedules();
            
        } catch (Exception e) {
            throw new SQLException("Unable view all the bus schedules.");
        }
        
        return scheduleList;
    }
    
    //This method is used to get after searched according to bus depart location
    public ArrayList<ScheduleModel> getSearchedByFromLocationSchedules(String fromLocation)throws SQLException{
        ArrayList<ScheduleModel> scList;
                
        try {
            scList = da.retrieveSchedulesByFromLocation(fromLocation);
        } catch (Exception e) {
            throw new SQLException("Unable search...");
        }
        return scList;
    }
    
    //This method is used to get after sorted schedules details
    public ArrayList<ScheduleModel> getSortSchedules(String sortBy)throws SQLException{
        ArrayList<ScheduleModel> scList=null;
        
        try {
            String sqlCol="";
            if(sortBy.equals("Schedule ID"))
                sqlCol +="scheduleId";
            else if(sortBy.equals("Depart Date"))
                sqlCol += "departDate";
            else if(sortBy.equals("Price"))
                sqlCol += "price";
            
            scList = da.retrieveSortSchedules(sqlCol);
        } catch (Exception e) {
            throw new SQLException("Unable sort schedules by "+ sortBy);
        }
        
        return scList;
    }
    
    //This method is used to get after filter schedules details
    public ArrayList<ScheduleModel> getFilterSchedules(String values[])throws SQLException{
        ArrayList<ScheduleModel> scList=null;
        
        try {
            scList = da.retrieveFilterSchedules(values);
        } catch (Exception e) {
            throw new SQLException("Unable filter schedule");
        }
        
        return scList;
    }
    
    //This method is used to get the selected depart date schedule details 
    public ArrayList<ScheduleModel> getSelectedDateSchedules(Date departDate)throws SQLException{
        ArrayList<ScheduleModel> scList=null;
        
        if(departDate==null)
            throw new SQLException("Please enter the chosen date");
        
        try {
            scList = da.retrieveSelectedDateSchedules(departDate);
        } catch (Exception e) {
            throw new SQLException("Unable show schedules with selected date...");
        }
        return scList;
    }
    
    //This method is used to set availability from available to unavailable 
    public void setAvailability(String scheduleId)throws SQLException{
        if(da.updateAvailability(scheduleId))
            throw new SQLException("Schedule ID: " + scheduleId +" had been changed status.\nPlease press 'Refresh Button' to refresh the table.");
        else
            throw new SQLException("unable change status");            
    }
    
    //This method is used to get A Schedule from Database
    public ScheduleModel getASchedule(String selectedId)throws SQLException{
        ScheduleModel schedule=null;
        
        try {
            schedule = da.retrieveASchedule(selectedId);
        } catch (Exception e) {
            throw new SQLException("Unable view Id: " +selectedId);
        }
        
        return schedule;
    }
    
    //This method is used to change the selected schedule 
    public void changeASchedule(String[] values, Date departDate)throws SQLException{
        if(values[2].equals("") ||values[2]==null ){
            throw new SQLException("Please select bus ID");
        }
        else if(departDate==null)
            throw new SQLException("Invalid Depart Date.Please choose again!");
        else if(values[3].equals(""))            
            throw new SQLException("Please select a 'Bus Depart Time'");
        else if(values[4].equals(""))
            throw new SQLException("Please select where 'the location of bus depart'");
        else if(values[5].equals(""))
            throw new SQLException("Please select the 'Destination'");        
        else if(values[6].equals("")||values[6] ==null) 
            throw new SQLException("Please click 'Check Price' Button to get the ticket price");
        
        ScheduleModel schedule = new ScheduleModel();
        schedule.setStaffId(values[0]);
        schedule.setScheduleId(values[1]);
        schedule.setBusId(values[2]);
        schedule.setDepartDate(departDate);
        schedule.setDepartTime(values[3]);
        schedule.setFromLocation(values[4]);
        schedule.setToLocation(values[5]);
        schedule.setAvailability(values[7]);
        double price = Double.parseDouble(values[6]);
        schedule.setPrice(price);
        
        if(matchSchedule(schedule)){
            throw new SQLException("Schedule already Exist Or Bus : "+values[2] 
                                  +" is not available during time: "+ values[3]);
        }
        else{
            boolean success = da.updateASchedule(schedule);
            
             if(success)
                throw new SQLException("Schedule was updated into database");
            else
                throw new SQLException("Unable update a data");               


        }
    }

    //This method is used for get all the depart date
    public ArrayList<Date> getAllDepartDates()throws SQLException{
        ArrayList<Date> departDates = null;
        
        try {
            departDates = da.retrieveAllDepartDate();
        } catch (Exception e) {
            throw new SQLException("Unable retrieve Depart Dates");
        }
        
        return departDates;
    }
    
    
}