package DA;

import Domain.SeatModel;
import java.sql.*;
import java.util.ArrayList;

public class SeatDA{
   private Connection con;
   private PreparedStatement preStmt;

    public SeatDA() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/busexpressticketingsystem?zeroDateTimeBehavior=convertToNull";
        String host = "root";
        String pass = "";
        
        con = DriverManager.getConnection(url, host, pass);     
    }
    
    //this method is used to insert a new seat 
    public boolean insertASeat(SeatModel seat)throws SQLException{
        String preSql = "insert into seat values(?,?,?)";
        preStmt = con.prepareStatement(preSql);
        
        preStmt.setString(1, seat.getSeatId());
        preStmt.setString(2, seat.getBusId());
        preStmt.setString(3, seat.getStatus());
        
        int success = preStmt.executeUpdate();
        
        return success > 0;
    }
   
    //This method is used to retrieve all seats from database by bus id
    public ArrayList<SeatModel> retrieveAllSeatsInfoByBusId(String busId)throws SQLException{
        preStmt = con.prepareStatement("select * from seat where busId = ?");
        preStmt.setString(1, busId);
        
        ResultSet rs = preStmt.executeQuery();
        ArrayList<SeatModel> seatsList = new ArrayList();
        while(rs.next()){
            SeatModel s = new SeatModel();
            s.setSeatId(rs.getString(1));
            s.setBusId(rs.getString(2));
            s.setStatus(rs.getString(3));
            
            seatsList.add(s);
        }
        return seatsList;
    }
   
    //This method is used to retrieve a seat from db by seat id
    public SeatModel retrieveASeatBySeatId(String seatId)throws SQLException{
        preStmt = con.prepareStatement("select * from seat where seatId=?");
        
        preStmt.setString(1, seatId);
        ResultSet rs = preStmt.executeQuery();
        
        SeatModel seat = new SeatModel();
        while(rs.next()){
            seat.setSeatId(rs.getString(1));
            seat.setBusId(rs.getString(2));
            seat.setStatus(rs.getString(3));
        }
                
        return seat;
    }
}