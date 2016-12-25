package DA;

import Domain.TicketModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TicketDA {
    private Connection con;
    private PreparedStatement preStmt;
    
    public TicketDA() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/busexpressticketingsystem?zeroDateTimeBehavior=convertToNull";
        String host = "root";
        String pass = "";
        
        con = DriverManager.getConnection(url,host, pass);
    }
    
    //This method is used to retrieve Max ticket Id from db
    public String retrievemaxTicketId() throws SQLException{
        String preSql = "select MAX(ticketId) from ticket";
        preStmt = con.prepareStatement(preSql);
        
        ResultSet rs = preStmt.executeQuery();
        
        String ticketId="";
        while(rs.next()){
            ticketId = rs.getString("MAX(ticketId)");
        }
        if(ticketId == null)
            ticketId="";
        
        return ticketId;
    }
    
    //This method is used to insert data into db
    public boolean insertATicket(TicketModel ticket)throws SQLException{
        String preSql = "insert into ticket values(?,?,?,?,?,?)";
        preStmt = con.prepareStatement(preSql);
        
        preStmt.setString(1, ticket.getTicketId());
        preStmt.setString(2, ticket.getScheduleId());
        preStmt.setString(3, ticket.getCusId());
        preStmt.setDouble(4, ticket.getTotalAmount());
        preStmt.setString(5, ticket.getPaymentType());
        preStmt.setString(6, ticket.getCardNo());
        
        int success = preStmt.executeUpdate();
        
        return success>0;
    }
    
    //This method is used to retrieve tickets by schedule Id 
    public ArrayList<String> retrieveTicketIdsByScId(String scId)throws SQLException{
        String preSql = "select ticketId from ticket where scheduleId =?";
        preStmt = con.prepareStatement(preSql);
        
        preStmt.setString(1, scId);
        ResultSet rs = preStmt.executeQuery();
        ArrayList<String> ticketIdList=new ArrayList();
        while(rs.next()){
            ticketIdList.add(rs.getString("ticketId"));
        }
        return ticketIdList;
    }
    
    //This method is used to retrieve tickets
    public ArrayList<TicketModel> retrieveAllTickets()throws SQLException{
        String preSql = "select * from ticket";
        preStmt = con.prepareStatement(preSql);
        
        ResultSet rs = preStmt.executeQuery();
        ArrayList<TicketModel> ticketIdList=new ArrayList();
        while(rs.next()){
            TicketModel td = new TicketModel();
            
            td.setTicketId(rs.getString(1));
            td.setScheduleId(rs.getString(2));
            td.setCusId(rs.getString(3));
            td.setTotalAmount(rs.getDouble(4));
            td.setPaymentType(rs.getString(5));
            td.setCardNo(rs.getString(6));
            
            ticketIdList.add(td);
        }
        return ticketIdList;
    }
    
    //This method is used to retrieve a ticket
    public TicketModel retrieveATicket(String ticketId)throws SQLException{
        String preSql = "select * from ticket where ticketId =?";

        preStmt = con.prepareStatement(preSql);
        preStmt.setString(1, ticketId);
        
        ResultSet rs = preStmt.executeQuery();
        TicketModel t = new TicketModel();
        
        while(rs.next()){
            t.setTicketId(rs.getString(1));
            t.setScheduleId(rs.getString(2));
            t.setCusId(rs.getString(3));
            t.setTotalAmount(rs.getDouble(4));
            t.setPaymentType(rs.getString(5));
            t.setCardNo(rs.getString(6));
             
        }
        return t;
        
    }
}



