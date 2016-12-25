package AppLogic;

import DA.TicketDA;
import Domain.TicketModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class TicketAL {
    TicketDA da;
    
    public TicketAL() throws SQLException{
        try {
            da = new TicketDA();
        } catch (Exception e) {
            throw new SQLException("Connection error");
        }
    }
    
    //This method is used to get next ticket id from db
    public String getNextTicketId()throws SQLException{
        String nextId="";
        
        try {
            String id = da.retrievemaxTicketId();
            
            if(id.equals(""))
                nextId +="T0001";
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
            throw new SQLException("Unable get Ticket Id");
        }
        return nextId;
    }
    
    //This method is used to calculate the charge 
    public double getCharge(String paidAmount, String AmountWithGST )throws Exception{
        double paid;
        double total;
        
        if(paidAmount.equals(""))
            throw new Exception("The 'Paid Amount' Field is Empty.\nPlease enter amount of paid");
        
        try {
            paid = Double.parseDouble(paidAmount);
        } catch (Exception e){
            throw new Exception("Only Enter Decimal Numberic in 'Paid Amount'");
        }
        
        try {
            total = Double.parseDouble(AmountWithGST);
        } catch (Exception e) {
            throw new Exception("System not able to capture the 'Total Amount'.\n"
                    + "Please inform Administrator");
        }
        
        double changes=paid-total;
        if(changes< 0)
            throw new Exception("Changes return invalid values\n"
                    + "Please checking your 'Paid Amount'");
        
        return changes;
    }
    
    //This method is used to add new ticket into db
    public boolean addTicket(String[] values)throws SQLException{
        /*
            ticketId
            scId
            cusId
            amountWithGST
            paymentType
            cardNo
        */
        
        if(!values[4].equals("Cash")){
            if(values[4].equals(""))
                throw new SQLException("Please select the Payment Type");
            else{
               String cardNo = values[5];

               if(!cardNo.matches("^(?:4[0-9]{12}(?:[0-9]{3})?| 5[1-5][0-9]{14}| 3[47][0-9]{13})$"))
                    throw new SQLException("Invalid "+ values[4] +" Number.Please try again.");
            }
        }
        try {            
            TicketModel ticket =new TicketModel();
            ticket.setTicketId(values[0]);
            ticket.setScheduleId(values[1]);
            ticket.setCusId(values[2]);
            
            try {
                double amountGST =Double.parseDouble(values[3]);
                ticket.setTotalAmount(amountGST);
            } catch (Exception e) {
                throw new SQLException("Unable convert "+values[3] +"into number");
            }
            ticket.setPaymentType(values[4]);
            ticket.setCardNo(values[5]);
            
            boolean success =da.insertATicket(ticket);
            
            return success;
        } catch (Exception e) {
            throw new SQLException("Unable insert Ticket ID: " + values[0]);
        }
    }

    //Thid method is used to get all ticket Id by schedule Id
    public ArrayList<String> getAllTicketIdsByScId(String scId)throws SQLException{
        ArrayList<String> ticketIdList=null;
        
        try {
            ticketIdList =da.retrieveTicketIdsByScId(scId);
        } catch (Exception e) {
            throw new SQLException("Unable get ticket Id List");
        }
        return ticketIdList;
    }
    
    //This method is used to get all ticket Id
    public ArrayList<TicketModel> getAllTicketIds()throws SQLException{
        ArrayList<TicketModel> ticketIdList=null;
        
        try {
            ticketIdList =da.retrieveAllTickets();
            
        } catch (Exception e) {
            throw new SQLException("Unable get ticket Id List");
        }
        return ticketIdList;
    }
    
    //This method is used to get a ticket id by ticket Id
    public TicketModel getATicket(String ticketId)throws SQLException{
        TicketModel ticket =null;
        
        try {
            ticket = da.retrieveATicket(ticketId);
            
            if(ticket==null)
                throw new SQLException("No record found");
            
            
        } catch (Exception e) {
            throw new SQLException("Unable to retrieve "+ ticketId +" from databse");
        }
        
        return ticket;
        
    }
}
