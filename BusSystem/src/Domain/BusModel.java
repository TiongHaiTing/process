package Domain;

public class BusModel{
    private String busId;
    private String busTypeId;
    private String plateNo;
    private String model;
    private int totalSeats;

    public BusModel() {
    }

    public BusModel(String busId, String busTypeId, String plateNo, String model, int totalSeats) {
        this.busId = busId;
        this.busTypeId = busTypeId;
        this.plateNo = plateNo;
        this.model = model;
        this.totalSeats = totalSeats;
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public String getBusTypeId() {
        return busTypeId;
    }

    public void setBusTypeId(String busTypeId) {
        this.busTypeId = busTypeId;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }
}