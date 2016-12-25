package File;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class PrintBill{
    
    private String[] seats;
    private String ticketId;
    private String scId;
    private String busId;
    private String busType;
    private String purchaseDate,purchaseTime;
    private String cusId;
    private String paidAmount;
    private String price,amount,amountWithGST;
    private double changes;
    private String totalSeats;

    private String paymentType,cardNo;

    public boolean printBill()throws Exception{
        
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("Receipt.pdf"));
            document.open();
            document.add(new Paragraph("Happy Journey Express Sdn Bhd"));
            document.add(new Paragraph("Taiping Bus Terminal, Jalan Masjid,"+"\n"
                                     + " 34000 Taiping, Perak"+"\n"
                                     + ", Malaysia\n"
                                       ));
            
            document.add(new Paragraph("Tel: +607474488 "));
            
            document.add(new Paragraph("Date : " + purchaseDate +"\t\t\t\t\t"
                                      +"Time: " + purchaseTime));
            
            document.add(new Paragraph("Ticket ID :" +ticketId));
            document.add(new Paragraph("Schedule ID :" +scId));
            document.add(new Paragraph("Bus ID :" +busId));
            document.add(new Paragraph("Bus Type :" +busType));
            
            String tab="";
            String tab2="";
            int count=0;
            for(int j=0;j<30;j++){
                tab += "\t";
                count++;
                if(count<25)
                    tab2+="\t";
            }
                
            document.add(new Paragraph("-------------------------------------------------------------------------\n"
                                     + "Seat Id"+tab2+"Price"));
            
            
            String statement ="";
            for(int i=0;i< seats.length;i++){
                statement += (seats[i]+ ""+ tab+ ""+price+ "\n");
            }
            

            document.add(new Paragraph(statement));
            document.add(new Paragraph("-------------------------------------------------------------------------\n"));
            
            document.add(new Paragraph("Total Seat(s) :" + totalSeats));
            document.add(new Paragraph("Customer ID :" + cusId));
            document.add(new Paragraph("Total Amount :" + amount));
            document.add(new Paragraph("Total Amount(incl.GST) : RM " + amountWithGST+"\n"));
            
            document.add(new Paragraph("Paid Amount            : RM " + paidAmount));
            DecimalFormat f = new DecimalFormat("###,###.00");
            document.add(new Paragraph("Changes                  : RM "+ f.format(changes)));
            document.add(new Paragraph("-------------------------------------------------------------------------\n"
                                     + "Happy Journey Express Sdn Bhd\n"
                                     + "Than You!\nSee You Again!"));
            document.close();  
            return true;
        } catch (Exception e){
            throw new Exception("Unable to Generate receipt");
        }
        
    }

    public boolean printCardBill()throws Exception{
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("Receipt.pdf"));
            document.open();
            document.add(new Paragraph("Happy Journey Express Sdn Bhd"));
            document.add(new Paragraph("Taiping Bus Terminal, Jalan Masjid,"+"\n"
                                     + " 34000 Taiping, Perak"+"\n"
                                     + ", Malaysia\n"
                                       ));
            
            document.add(new Paragraph("Tel: +607474488 "));
            
            document.add(new Paragraph("Date : " + purchaseDate +"\t\t\t\t\t"
                                      +"Time: " + purchaseTime));
            
            document.add(new Paragraph("Ticket ID :" +ticketId));
            document.add(new Paragraph("Schedule ID :" +scId));
            document.add(new Paragraph("Bus ID :" +busId));
            document.add(new Paragraph("Bus Type :" +busType));
            
            String tab="";
            String tab2="";
            int count=0;
            for(int j=0;j<30;j++){
                tab += "\t";
                count++;
                if(count<25)
                    tab2+="\t";
            }
                
            document.add(new Paragraph("-------------------------------------------------------------------------\n"
                                     + "Seat Id"+tab2+"Price"));
            
            
            String statement ="";
            for(int i=0;i< seats.length;i++){
                statement += (seats[i]+ ""+ tab+ ""+price+ "\n");
            }
            

            document.add(new Paragraph(statement));
            document.add(new Paragraph("-------------------------------------------------------------------------\n"));
            
            document.add(new Paragraph("Total Seat(s) :" + totalSeats));
            document.add(new Paragraph("Customer ID :" + cusId));
            document.add(new Paragraph("Total Amount :" + amount));
            document.add(new Paragraph("Total Amount(incl.GST) : RM " + amountWithGST+"\n"));
            
            document.add(new Paragraph("Payment Type            : " + paymentType));
            document.add(new Paragraph("Card Number             : " + cardNo));
            
            document.add(new Paragraph("-------------------------------------------------------------------------\n"
                                     + "Happy Journey Express Sdn Bhd\n"
                                     + "Than You!\nSee You Again!"));
          
            document.close();  
        }catch(Exception ex){
            throw new Exception("Unable print receipt");
        }
        return true;
    }
 
 
    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    
    public String[] getSeats() {
        return seats;
    }

    public void setSeats(String[] seats) {
        this.seats = seats;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getScId() {
        return scId;
    }

    public void setScId(String scId) {
        this.scId = scId;
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(String paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAmountWithGST() {
        return amountWithGST;
    }

    public void setAmountWithGST(String amountWithGST) {
        this.amountWithGST = amountWithGST;
    }
    
    public String getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(String totalSeats) {
        this.totalSeats = totalSeats;
    }
    
    public double getChange() {
        return changes;
    }

    public void setChange(double change) {
        this.changes = change;
    }
    
}