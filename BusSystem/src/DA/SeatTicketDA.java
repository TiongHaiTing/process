package DA;

import Domain.SeatTicketModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SeatTicketDA{
    private Connection con;
    private PreparedStatement preStmt;
   
    public SeatTicketDA() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/busexpressticketingsystem?zeroDateTimeBehavior=convertToNull";
        String host = "root";
        String pass = "";
        
        con = DriverManager.getConnection(url, host, pass);     
    }
    
    //This method is used to retrieve max seatTicket id fro db
    public int retrieveMaxSeatTicketId()throws SQLException{
        preStmt = con.prepareStatement("select Max(seatTicketId) from seatTicket");
        
        ResultSet rs = preStmt.executeQuery();
        
        int stId=0;
        while(rs.next()){
            stId = rs.getInt("MAX(seatTicketId)");
        }
        
        
        return stId;
    }
    
    //This method is used to insert a seatTicket
    public boolean insertASeatTicket(SeatTicketModel sc)throws SQLException{
        String preSql = "insert into seatticket values(?,?,?,?)";
        preStmt = con.prepareStatement(preSql);
        
        preStmt.setInt(1, sc.getSeatTicketId());
        preStmt.setString(2, sc.getSeatId());
        preStmt.setString(3, sc.getTicketId());
        preStmt.setString(4, sc.getStatus());
        
        int success = preStmt.executeUpdate();
        
        return success>0;
    }
    
    //This method is used to retrieve all seat id by ticket id
    public ArrayList<SeatTicketModel> retrieveAllSeatByTicketId(String ticketId)throws SQLException{
        String sql = "select * from seatticket where ticketId =?";
        preStmt = con.prepareStatement(sql);
        preStmt.setString(1, ticketId);
        
        ResultSet rs = preStmt.executeQuery();
        ArrayList<SeatTicketModel> seatIdList=new ArrayList();
        
        while(rs.next()){
            SeatTicketModel stM = new SeatTicketModel();
            stM.setSeatTicketId(rs.getInt(1));
            stM.setSeatId(rs.getString(2));
            stM.setTicketId(rs.getString(3));
            stM.setStatus(rs.getString(4));
            seatIdList.add(stM);
        }
        
        return seatIdList;
    }
    
    //This method is used to update seatticket's status by ticket id
    public boolean updateSeatTicketStatusByTicketId(String ticketId)throws SQLException{
        String sql="update seatTicket set status=? where ticketId =?";
        preStmt =con.prepareStatement(sql);
        
        preStmt.setString(1, "Unavailable");
        preStmt.setString(2, ticketId);
        int success = preStmt.executeUpdate();
        
        return success>0;
    }
    
    //This method is used to update seatticket id by ticket id and new seat ids
    public boolean updateSeatIdsByTicketId(String ticketId,String id, String origin)throws SQLException{
        String sql="update seatTicket set seatId=? where (ticketId =? AND seatId=?)";
        preStmt =con.prepareStatement(sql);
        
        preStmt.setString(1, id);
        preStmt.setString(2, ticketId);
        preStmt.setString(3, origin);
        int success=preStmt.executeUpdate();
        return success>0;
    }
    
    //This method is used to update seatticket's status by ticket id
    public boolean updateSeatTicketStatusByTicketIdAndSeatId(String ticketId, String seatId)throws SQLException{
        String sql="update seatTicket set status=? where (ticketId =? AND seatId=?)";
        preStmt =con.prepareStatement(sql);
        
        preStmt.setString(1, "Unavailable");
        preStmt.setString(2, ticketId);
        preStmt.setString(3, seatId);
        int success = preStmt.executeUpdate();
        
        return success>0;
    }
}