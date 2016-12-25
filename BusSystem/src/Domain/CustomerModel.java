package Domain;

public class CustomerModel{
    private String cusId;
    private String icNo;
    private String cusName;
    private String gender;
    private String address;
    private String email;
    private String phoneNo;

    public CustomerModel() {
    }

    public CustomerModel(String cusId, String icNo, String cusName, String gender, String address, String email, String phoneNo) {
        this.cusId = cusId;
        this.icNo = icNo;
        this.cusName = cusName;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getIcNo() {
        return icNo;
    }

    public void setIcNo(String icNo) {
        this.icNo = icNo;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    
}