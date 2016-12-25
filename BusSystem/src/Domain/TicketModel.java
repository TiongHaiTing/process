package Domain;

public class TicketModel {
    private String ticketId;
    private String scheduleId;
    private String cusId;
    private double totalAmount;
    private String paymentType;
    private String cardNo;
    
    public TicketModel() {
    }

    public TicketModel(String ticketId, String scheduleId, String cusId, double totalAmount, String paymentType, String cardNo) {
        this.ticketId = ticketId;
        this.scheduleId = scheduleId;
        this.cusId = cusId;
        this.totalAmount = totalAmount;
        this.paymentType = paymentType;
        this.cardNo = cardNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
    
    
}
