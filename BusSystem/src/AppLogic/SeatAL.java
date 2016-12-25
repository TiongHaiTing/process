package AppLogic;

import DA.SeatDA;
import Domain.SeatModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class SeatAL{
    private SeatDA seatDa;

    public SeatAL() throws SQLException{
        seatDa = new SeatDA();
    }
    
    //This method is used add all available seats
    public void addAllSeats(String busId, String totalSeats)throws SQLException{
        //exp: A000 , ZA00
        
        
        char sub = busId.charAt(0);
        char sub2 = busId.charAt(1);
        int total = Integer.parseInt(totalSeats);
        
        if(Character.compare(sub2,'0') ==0){     

            for(int i=1;i<=total;i++){
                SeatModel seat = new SeatModel();
                String seatId;
                if(i<10)
                    seatId = sub + "00" + i;
                else
                    seatId = sub + "0" + i;

                seat.setSeatId(seatId);
                seat.setBusId(busId);
                seat.setStatus("Available");

                if(!seatDa.insertASeat(seat))
                    throw new SQLException("Seat ID: " + seatId+" unable to insert.");
            }
        }
        else{
            for(int i=1;i<=total;i++){
                SeatModel seat = new SeatModel();
                String seatId;
                if(i<10)
                    seatId = sub +""+sub2+ "0" + i;
                else
                    seatId = sub +"" +sub2+"" + i;

                seat.setSeatId(seatId);
                seat.setBusId(busId);
                seat.setStatus("Available");

                if(!seatDa.insertASeat(seat))
                    throw new SQLException("Seat ID: " + seatId+" unable to insert.");
            } 
        }
            
        throw new SQLException("Total Seats : " + totalSeats + " had been created in Database.");
        
    }
    
    //This method is used to retrieve all seats from db by bus id
    public ArrayList<SeatModel> getAllSeatsByBusId(String busId)throws SQLException{
        ArrayList<SeatModel> seatList = null;
        try {
            seatList =seatDa.retrieveAllSeatsInfoByBusId(busId);
        } catch (Exception e) {
            throw new SQLException("Unable to retrieve seat Id");
        }
        
        return seatList;
    }

    //This method is used to retrieve a seat from db by seat id
    public SeatModel getASeatBySeatId(String seatId)throws SQLException{
        SeatModel seat = null;
        try {
            seat =seatDa.retrieveASeatBySeatId(seatId);
        } catch (Exception e) {
            throw new SQLException("Unable get "+ seatId +" from database");
        }
        
        return seat;
    }
}