package AppLogic;

import DA.BusDA;
import Domain.BusModel;
import Domain.BusTypeModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class BusAL{
    BusDA busDA;

    public BusAL() throws SQLException{
        try {
            busDA = new BusDA();
        } catch (Exception e) {
            throw new SQLException("Connection Error");
        }
    }
    
    //get all bus types 
    public ArrayList<BusTypeModel> getAllBusTypes() throws SQLException{
        ArrayList<BusTypeModel> busTypes;
        
        try {
            busTypes = busDA.retrieveAllBusTypes();
        } catch (Exception e) {
            throw new SQLException("Unable get bus type from database");
        }
        
        return busTypes;
    }
    
    //get a bus type
    public BusTypeModel getABusType(String busTypeId) throws SQLException{
        BusTypeModel busType;
        try {
            busDA = new BusDA();
            busType = busDA.retrieveABusType(busTypeId);
        } catch (Exception e) {
            throw new SQLException("Unable retrieve bus type name");
        }
        return busType;
    }
   
    //This method is used to get the next bus Id from DB
    public String getBusId() throws SQLException{
        String nextBusId="";
        
        try {
            String busId = busDA.retrieveMaxBusId();
            
            if(busId.equals(""))
                nextBusId +="A000";
            else{
                if(!busId.substring(0,1).equals("Z")){
                    
                    char sub = busId.charAt(0);
                    for(char letter='A';letter<='Z';letter++){
                        if(Character.compare(sub, letter)<0){
                            nextBusId += ((letter++) + "000");
                            break;
                        }
                    }
                }
                else{
                    char sub2 = busId.charAt(1);
                   
                    for(char letter='A';letter<='Z';letter++){
                        if(Character.compare(sub2, letter)<0){
                            nextBusId += ("Z"+ (letter++) + "00");
                            break;
                        }
                    }                    
                }
            }
        } catch (Exception e) {
            throw new SQLException("Unable to generate bus ID");
        }
        return nextBusId;
    }
    
    //This method is used to add a new bus information
    public void addNewBus(String[] values)throws SQLException{
        /*
            values[]
            [0] - busId
            [1] - busTypeId
            [2] - plateNo
            [3] - model
            [4] - totalSeat
        */
        
        if(values[0].equals(""))//check empty bus id field
            throw new SQLException("'Bus Id' cannot be empty");
        
        if(values[1].equals(""))//check bus type with empty field
            throw new SQLException("Please select the bust type according to bus type ID.");
        
        if(values[2].equals(""))
            throw new SQLException("Please provides Bus's Plate number for Recording purpose.'");
        else{
            ArrayList<BusModel> busList = busDA.retrieveAllBusInfo();
            System.out.println("h1");
            for (int i = 0; i < busList.size(); i++){
                BusModel bus = busList.get(i);
                
                System.out.println("h2");
                if(values[2].equals(bus.getPlateNo()))
                    throw new SQLException("Bus Plate Number 'already exists' in Bus Id: "+ bus.getBusId());
            }
        }
            
        
        if(values[3].equals(""))
            throw new SQLException("'Bus Model' must be specificed");
        
        if(values[4].equals(""))
            throw new SQLException("Please select the number of customers' seats within the bus");
            
        int totalSeats = Integer.parseInt(values[4]);
        
        BusModel bus = new BusModel();
        bus.setBusId(values[0]);
        bus.setBusTypeId(values[1]);
        bus.setPlateNo(values[2]);
        bus.setModel(values[3]);
        bus.setTotalSeats(totalSeats);
         
        boolean success = busDA.insertABus(bus);
        
        if(success)
            throw new SQLException("Bus Id :" + values[0] + " had been added.");
        else
            throw new SQLException("Bus ID :" + values[0] + " unable insert to database.");
    }
    
    //This method is used to get all bus information
    public ArrayList<BusModel> getAllBusInfo() throws SQLException{
        ArrayList<BusModel> busList=null;
        
        try {
            busList = busDA.retrieveAllBusInfo();
            
        } catch (Exception e) {
            throw new SQLException("Unable retrieve all Bus Information from DB");
        }
        
        return busList;
        
    }
    
    //This method is used to delete a bus information
    public void delBusInfo(String busId)throws SQLException{
        
        if(busId.equals(""))
            throw new SQLException("Please select a 'Bus' from the table");
        
        boolean success = busDA.delBusInfo(busId);
        
        if(success)
            throw new SQLException("Bus Id :" + busId +" had been deleted");
        else
            throw new SQLException("Unable delete busId :'" + busId +"'");
    }
    
    //This method is used to get a bus information
    public BusModel getABusInfo(String busId) throws SQLException{
        BusModel bus=null;
        
        try {
            bus = busDA.retrieveABus(busId);
        } catch (Exception e) {
            new SQLException("Unable to retrieve '"+busId+"' Information");
        }
        return bus;
    }
    
    //This method is used to update a bus 
    public void updateBusInfo(String[] values)throws SQLException{
        /*
            values[]
            [0] - busId
            [1] - busTypeId
            [2] - plateNo
            [3] - model
            [4] - totalSeat
        */
        
        if(values[0].equals(""))//check empty bus id field
            throw new SQLException("'Bus Id' cannot be empty");
        
        if(values[1].equals(""))//check bus type with empty field
            throw new SQLException("Please select the bust type according to bus type ID.");
        
        if(values[2].equals(""))
            throw new SQLException("Please provides Bus's Plate number for Recording purpose.'");
        else{
            ArrayList<BusModel> busList = busDA.retrieveAllBusInfo();
            
            for (int i = 0; i < busList.size(); i++){
                BusModel bus = busList.get(i);
                if(values[2].equals(bus.getPlateNo()) && !values[0].equals(bus.getBusId()))
                    throw new SQLException("Bus Plate Number 'already exists' in Bus Id: "+ bus.getBusId());
                
            }
        }
        if(values[3].equals(""))
            throw new SQLException("'Bus Model' must be specificed");
        
        if(values[4].equals(""))
            throw new SQLException("Please select the number of customers' seats within the bus");
            
        int totalSeats = Integer.parseInt(values[4]);
        
        BusModel bus = new BusModel();
        bus.setBusId(values[0]);
        bus.setBusTypeId(values[1]);
        bus.setPlateNo(values[2]);
        bus.setModel(values[3]);
        bus.setTotalSeats(totalSeats);
         
        boolean success =busDA.updateBus(bus);
        
        if(success)
            throw new SQLException("Bus Id :" + values[0] + " had been updated.");
        else
            throw new SQLException("Bus ID :" + values[0] + " unable update to database.");
    }
    
    //This method is used to filter purpose
    public ArrayList<BusModel> filterBusInfo(String[] busTypes)throws SQLException{
        ArrayList<BusModel> busList=null;
        
        
        try {
            busList = busDA.retrieveFilteredBusInfo(busTypes);
        } catch (Exception e) {
            throw new SQLException("Unable display filtered results");
            
        }
        return busList;
    }
    
    public ArrayList<BusModel> sortBusInfo(String sortBy)throws SQLException{
        ArrayList<BusModel> busList = null;
        String colName="";
        try {
            
            if(sortBy.equals("Bus Id"))
                colName = "busId";
            if(sortBy.equals("Bus Type Id"))
                colName = "busTypeId";
            if(sortBy.equals("Total Seats"))  
               colName = "totalSeat";
                
            busList = busDA.retrieveSortBus(colName);
        } catch (Exception e) {
            throw new SQLException("Unable sort bus information.");
        }
        
        return busList;
    }
}