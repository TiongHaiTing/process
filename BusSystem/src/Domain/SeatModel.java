package Domain;
public class SeatModel{
    private String seatId;
    private String busId;
    private String status;

    public SeatModel() {
    }

    public SeatModel(String seatId, String busId, String status) {
        this.seatId = seatId;
        this.busId = busId;
        this.status = status;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }  
}