package AppLogic;

import DA.SeatTicketDA;
import Domain.SeatTicketModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class SeatTicketAL {
    SeatTicketDA da;
    
    public SeatTicketAL() throws SQLException{
        try {
            da = new SeatTicketDA();
        } catch (Exception e) {
            throw new SQLException("Connection error");
        }
    }
    
    //This method is used to get next seatTicketId
    public int getNextSeatTicketId()throws SQLException{
        String nextId;
        try {
            int id = da.retrieveMaxSeatTicketId();
            
            if(id==0)
                return 1;
            else{
                ++id;
                return id;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Unable get next seat Ticket Id");
        }
    }
    
    //This method is used to add seat ticket Id
    public boolean addSeatTicket(String[] seatIds,String ticketId)throws SQLException{
        
        for(int i=0;i<seatIds.length;i++){
            SeatTicketModel st = new SeatTicketModel();
            st.setSeatTicketId(getNextSeatTicketId());
            st.setSeatId(seatIds[i]);
            st.setTicketId(ticketId);
            st.setStatus("Available");
            
            boolean s =da.insertASeatTicket(st);
            if(!s){
                throw new SQLException("Seat Ticket:"+getNextSeatTicketId()+" unable to insert.");
            }
        }
        return true;
    }
    
    //This method is used to get all seat ids by ticket Id
    public ArrayList<SeatTicketModel> getAllSeatIdByTicketId(String ticketId)throws SQLException{
        ArrayList<SeatTicketModel> seatTicketList=null;
        try {
            seatTicketList = da.retrieveAllSeatByTicketId(ticketId);
        } catch (Exception e) {
            throw new SQLException("Unable get seat Ids");
        }
        return seatTicketList;
    }
    
    //This method is used to update seatticket status by ticket id
    public void updateSeatTicketStatusByTicketId(String ticketId)throws SQLException{
        
        boolean success = da.updateSeatTicketStatusByTicketId(ticketId);
        
        if(success)
            throw new SQLException("Update successful");
        else
            throw new SQLException("Unable to update ticket status");
    }
    
    //This method is used to update seatticket's seat id by ticket id and new seat id
    public boolean  updateSeatTicketIdByTicketId(String ticketId, ArrayList<String> seatIds,
                                ArrayList<String> originalSeatIds)throws SQLException{
    
        boolean success=false;
        
        if(seatIds.size() == originalSeatIds.size()){
            //same number of seats update
            for(int i=0;i<seatIds.size();i++){
                String id = seatIds.get(i);
                String origin = originalSeatIds.get(i);
                success= da.updateSeatIdsByTicketId(ticketId, id, origin);
                if(!success){
                    throw new SQLException("Unable to update");
                }
            }
            
        }else{
            //reduce number of seats
            ArrayList<String> tempIds = originalSeatIds;
            ArrayList<String> sameIds=new ArrayList();
            
            /*
              sameIds - get the same ids from new and original ids
              tempIds - get the differen ids from new and original ids 
                        by remove the same 
            */
            for (int i = 0; i < seatIds.size(); i++){
                String id = seatIds.get(i);
                
                for(int j=0;j<tempIds.size();j++){
                    String origin = tempIds.get(j);
                    if(id.equals(origin)){
                        sameIds.add(id);
                        tempIds.remove(j);
                    }
                }
            }
            
            //Removing the same ids from the new id list
            //As it remain available
            for(int i=0;i<sameIds.size();i++){
                String same = sameIds.get(i);
                
                for(int j=0;j<seatIds.size();j++){
                    String id = seatIds.get(j);

                    if(id.equals(same)){
                        seatIds.remove(j);
                    }
                }
            }
            
            //seatIds -leaves only not yet update list
            //tempIds - leaves only no same ids from db/original ids  
            for(int i=0;i<seatIds.size();i++){
                String origin = tempIds.get(i);
                String seatId = seatIds.get(i);
                
                success= da.updateSeatIdsByTicketId(ticketId, seatId, origin);
                tempIds.remove(i);
            }
            
            for(int i=0;i<tempIds.size();i++){
                String unselectedId = tempIds.get(i);
                System.out.println(unselectedId);
                success = da.updateSeatTicketStatusByTicketIdAndSeatId(ticketId,unselectedId);
            }
        }
        
        return success;
    }
    
}
