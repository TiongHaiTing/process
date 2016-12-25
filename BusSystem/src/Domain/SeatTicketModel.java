package Domain;

public class SeatTicketModel {
    private int seatTicketId;
    private String seatId;
    private String ticketId;
    private String status;

    public SeatTicketModel() {
    }

    public SeatTicketModel(int seatTicketId, String seatId, String ticketId, String status) {
        this.seatTicketId = seatTicketId;
        this.seatId = seatId;
        this.ticketId = ticketId;
        this.status = status;
    }

    public int getSeatTicketId() {
        return seatTicketId;
    }

    public void setSeatTicketId(int seatTicketId) {
        this.seatTicketId = seatTicketId;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
