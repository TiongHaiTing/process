package DA;

import Domain.BusModel;
import Domain.BusTypeModel;
import java.sql.*;
import java.util.ArrayList;

public class BusDA{
    private Connection con;
    private PreparedStatement preStmt;
    
    public BusDA() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/busexpressticketingsystem?zeroDateTimeBehavior=convertToNull";
        String host = "root";
        String pass = "";
        
        con = DriverManager.getConnection(url, host, pass);        
    }
    
    //This method is used to retrieve all bus types in DB
    public ArrayList<BusTypeModel> retrieveAllBusTypes() throws SQLException{
        ArrayList<BusTypeModel> busTypeList=new ArrayList();
        
        String preSql = "Select * from busType";
        preStmt = con.prepareStatement(preSql);
        ResultSet rs = preStmt.executeQuery();
        
        while (rs.next()){
            BusTypeModel busType = new BusTypeModel();
            busType.setBusTypeId(rs.getString(1));
            busType.setBusTypeName(rs.getString(2));
            
            busTypeList.add(busType);            
        }
        return busTypeList;
    }
    
    //This method is used to retrieve a bus type by busTypeid
    public BusTypeModel retrieveABusType(String busTypeId)throws SQLException{
        BusTypeModel busType = new BusTypeModel();
        
        String preSql = "select * from bustype where busTypeId = ?";
        preStmt = con.prepareStatement(preSql);
        
        preStmt.setString(1, busTypeId);
        
        ResultSet rs = preStmt.executeQuery();
        
        while(rs.next()){
            busType.setBusTypeId(rs.getString(1));
            busType.setBusTypeName(rs.getString(2));
        }
        
        return busType;
    }
    
    //This method is used to retrieve bus Id from bus db
    public String retrieveMaxBusId()throws SQLException{
        preStmt = con.prepareStatement("select Max(busId) from bus");
        
        ResultSet rs = preStmt.executeQuery();
        
        String busId="";
        while(rs.next()){
            busId = rs.getString("MAX(busId)");
        }
        
        if(busId == null)
            busId = "";
        
        return busId;
    }
    
    //This method us used to insert a new bus into bus db
    public boolean insertABus(BusModel bus) throws SQLException{
        
        String preSql = "insert into bus values(?,?,?,?,?)";
        
        preStmt = con.prepareStatement(preSql);
        
        preStmt.setString(1, bus.getBusId());
        preStmt.setString(2, bus.getBusTypeId());
        preStmt.setString(3, bus.getPlateNo());
        preStmt.setString(4, bus.getModel());
        preStmt.setInt(5, bus.getTotalSeats());
        
        int r = preStmt.executeUpdate();
        
        return r >0;
    }
    
    //This method is used to retrieve all bus information
    public ArrayList<BusModel> retrieveAllBusInfo() throws SQLException{
        ArrayList<BusModel> busList= new ArrayList();
        
        preStmt = con.prepareStatement("select * from bus");
        ResultSet rs = preStmt.executeQuery();
        
        while (rs.next()){
            BusModel bus = new BusModel();
            
            bus.setBusId(rs.getString(1));
            bus.setBusTypeId(rs.getString(2));
            bus.setPlateNo(rs.getString(3));
            bus.setModel(rs.getString(4));
            bus.setTotalSeats(rs.getInt(5));
            
            busList.add(bus);
        }
        return busList;
    }
    
    //This method is used to delete a bus information
    public boolean delBusInfo(String busId) throws SQLException{
        String preSql="delete From bus where busId = ?";
        
        preStmt = con.prepareStatement(preSql);
        preStmt.setString(1, busId);
        
        int success = preStmt.executeUpdate();
        
        return success>0;
    }
    
    //This method is used to retrieve a bus information
    public BusModel retrieveABus(String busId) throws SQLException{
        BusModel bus = new BusModel();
        
        String preSql = "select * from bus where busId=?";
        
        preStmt = con.prepareStatement(preSql);
        preStmt.setString(1, busId);
        ResultSet rs = preStmt.executeQuery();
        
        while (rs.next()) {
            bus.setBusId(busId);
            bus.setBusTypeId(rs.getString(2));
            bus.setPlateNo(rs.getString(3));
            bus.setModel(rs.getString(4));
            bus.setTotalSeats(rs.getInt(5));
        }
        return bus;
    }
    
    public boolean updateBus(BusModel bus)throws SQLException{
        
        String preSql = "update bus set busTypeId =?,plateNo =?,model=?,"
                                        + "totalSeat=? "
                                        +" where busId = ?";
        
        preStmt = con.prepareStatement(preSql);
        preStmt.setString(1, bus.getBusTypeId());
        preStmt.setString(2, bus.getPlateNo());
        preStmt.setString(3, bus.getModel());
        preStmt.setInt(4, bus.getTotalSeats());
        preStmt.setString(5, bus.getBusId());
        
        int r = preStmt.executeUpdate();
        return r>0;
    }
    
    //This method is used to retrieve bus info with specificed bus type
    public ArrayList<BusModel> retrieveFilteredBusInfo(String[] values)throws SQLException{
        
        ArrayList<BusModel> busList = new ArrayList();
        
        String preSql = "select * "
                      + "from bus b, bustype bt "
                      + "where b.bustypeid = bt.bustypeid "
                      + "AND (bt.busTypeName=? OR bt.busTypeName=? "
                      + "OR   bt.busTypeName=? OR bt.busTypeName=?)";
        
        preStmt = con.prepareStatement(preSql);
        preStmt.setString(1, values[0]);
        preStmt.setString(2, values[1]);
        preStmt.setString(3, values[2]);
        preStmt.setString(4, values[3]);
        
        ResultSet rs = preStmt.executeQuery();
        
        while (rs.next()){
            BusModel bus = new BusModel();
            
            bus.setBusId(rs.getString(1));
            bus.setBusTypeId(rs.getString(2));
            bus.setPlateNo(rs.getString(3));
            bus.setModel(rs.getString(4));
            bus.setTotalSeats(rs.getInt(5));
            
            busList.add(bus);
        }
        return busList;    
    }
    
    //This method is used to retrieve sort bus info by busid, busTypeid,or totalseat
    public ArrayList<BusModel> retrieveSortBus(String sortBy)throws SQLException{
        ArrayList<BusModel> busList = new ArrayList();
        
        preStmt = con.prepareStatement("select * from bus order by "+sortBy);
        ResultSet rs = preStmt.executeQuery();
        
        while (rs.next()){
            BusModel bus = new BusModel();
            
            bus.setBusId(rs.getString(1));
            bus.setBusTypeId(rs.getString(2));
            bus.setPlateNo(rs.getString(3));
            bus.setModel(rs.getString(4));
            bus.setTotalSeats(rs.getInt(5));
            
            busList.add(bus);
        }
        return busList;
        
        
        
    }
    
    
    
}