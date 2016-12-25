package Domain;

import java.util.Date;

public class ScheduleModel{
    private String scheduleId;
    private Date departDate;
    private String departTime;
    private String fromLocation;
    private String toLocation;
    private double price;
    private String availability;
    private String busId;
    private String staffId;

    public ScheduleModel() {
    }

    public ScheduleModel(String scheduleId, Date departDate, String departTime, String fromLocation, String toLocation, double price, String availability, String busId, String staffId) {
        this.scheduleId = scheduleId;
        this.departDate = departDate;
        this.departTime = departTime;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.price = price;
        this.availability = availability;
        this.busId = busId;
        this.staffId = staffId;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Date getDepartDate() {
        return departDate;
    }

    public void setDepartDate(Date departDate) {
        this.departDate = departDate;
    }

    public String getDepartTime() {
        return departTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }    
}