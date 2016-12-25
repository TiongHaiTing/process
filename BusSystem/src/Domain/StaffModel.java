package Domain;

import java.util.Date;

public class StaffModel{
    private String staffId;
    private String f_name;
    private String l_name;
    private String gender;
    private Date dob;
    private String marialStatus;
    private String phoneNo;
    private String address;
    private String email;
    private String position;
    private double salary;
    private String password;
    private String recoveryQuestion;
    private String recoveryAns;

    public StaffModel() {
    }

    public StaffModel(String staffId, String f_name, String l_name, String gender, Date dob, String marialStatus, String phoneNo, String address, String email, String position, double salary, String password, String recoveryQuestion, String recoveryAns) {
        this.staffId = staffId;
        this.f_name = f_name;
        this.l_name = l_name;
        this.gender = gender;
        this.dob = dob;
        this.marialStatus = marialStatus;
        this.phoneNo = phoneNo;
        this.address = address;
        this.email = email;
        this.position = position;
        this.salary = salary;
        this.password = password;
        this.recoveryQuestion = recoveryQuestion;
        this.recoveryAns = recoveryAns;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getMarialStatus() {
        return marialStatus;
    }

    public void setMarialStatus(String marialStatus) {
        this.marialStatus = marialStatus;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRecoveryQuestion() {
        return recoveryQuestion;
    }

    public void setRecoveryQuestion(String recoveryQuestion) {
        this.recoveryQuestion = recoveryQuestion;
    }

    public String getRecoveryAns() {
        return recoveryAns;
    }

    public void setRecoveryAns(String recoveryAns) {
        this.recoveryAns = recoveryAns;
    }

    
}