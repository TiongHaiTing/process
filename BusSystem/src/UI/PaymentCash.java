package UI;

import AppLogic.BusAL;
import AppLogic.SeatTicketAL;
import AppLogic.TicketAL;
import Domain.BusModel;
import Domain.SeatTicketModel;
import File.PrintBill;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PaymentCash extends javax.swing.JDialog {
    DefaultTableModel tableModel;
    private String[] seatIds;
    private double price;
    private String busId;
    private String cusId;
    private String scId;
    
    public PaymentCash(java.awt.Frame parent, boolean modal,String scId,
            String[] seatIds, String busId, double price, String cusId) {
        
        super(parent, modal);
        initComponents();
        setTitle("Payment By Cash");
        tableModel = (DefaultTableModel)tableTable.getModel();
        this.seatIds = seatIds;
        this.busId =  busId;
        this.price = price;
        this.cusId =cusId;
        this.scId = scId;
        
        boolean s1 = viewSeatIds();
        boolean s2 = viewBus();
        boolean s3 = viewCusId();
        boolean s4 = viewTicketId();
        boolean s5 = viewScheduleId();
        boolean s6 = viewDate();
        boolean s7 = getTotalAmount();
        setLocationRelativeTo(null);
    }

    private boolean viewSeatIds(){
        Arrays.sort(seatIds);
        
        for(int i=0;i<seatIds.length;i++){
            String[] tableValues={seatIds[i], price+""};
            tableModel.addRow(tableValues);
        }
        return true;
    }
    
    private boolean viewBus(){
        tfBusId.setText(busId);
        try {
            BusAL al = new BusAL();
            BusModel bus = al.getABusInfo(busId);
            String busTypeName = al.getABusType(bus.getBusTypeId()).getBusTypeName();
            
            tfBusType.setText(busTypeName);
        } catch (SQLException ex) {
        }
        
        
        return true;
    }
    
    private boolean viewCusId(){
        tfCusId.setText(cusId);
        return true;
    }
    
    private boolean viewTicketId(){
        
        try {
            TicketAL al = new TicketAL();
            String ticketId = al.getNextTicketId();
            tfTicketId.setText(ticketId);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        }
        return true;
    }
    
    private boolean viewScheduleId(){
        tfScheduleId.setText(scId);
        return true;
    }
    
    private boolean viewDate(){
        Date today = new Date();
        tfPurchaseDate.setText(new java.sql.Date(today.getTime()).toString());
        Calendar now = Calendar.getInstance();
        int hours = now.get(Calendar.HOUR_OF_DAY);
        int minutes = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);
        tfPurchaseTime.setText(hours + ":" + minutes + ":" + second);
        return true;
    }
    
    private boolean getTotalAmount(){
        int seatNum =seatIds.length;
        
        tfTotalSeats.setText(seatNum+"");
        double totalAmount = seatNum*price;
        double AmountWithGST = totalAmount*1.06;
        
        tfTotalAmount.setText(totalAmount+"");
        tfAmountGST.setText(AmountWithGST+"");
        
        return true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlScreen = new javax.swing.JPanel();
        lblTicketId = new javax.swing.JLabel();
        lblScheduleId = new javax.swing.JLabel();
        tfTicketId = new javax.swing.JTextField();
        tfScheduleId = new javax.swing.JTextField();
        tfPurchaseDate = new javax.swing.JTextField();
        tfPurchaseTime = new javax.swing.JTextField();
        lblPurchaseDate = new javax.swing.JLabel();
        lblOrderTime = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTable = new javax.swing.JTable();
        tfTotalAmount = new javax.swing.JTextField();
        lblTotalAmount = new javax.swing.JLabel();
        lblMemId = new javax.swing.JLabel();
        lblPaidAmount = new javax.swing.JLabel();
        tfPaidAmount = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        lblBusId = new javax.swing.JLabel();
        lblBusType = new javax.swing.JLabel();
        tfBusType = new javax.swing.JTextField();
        tfBusId = new javax.swing.JTextField();
        tfCusId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfAmountGST = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfTotalSeats = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlScreen.setBackground(new java.awt.Color(255, 0, 255));

        lblTicketId.setForeground(new java.awt.Color(255, 255, 255));
        lblTicketId.setText("Ticker Id ");

        lblScheduleId.setForeground(new java.awt.Color(255, 255, 255));
        lblScheduleId.setText("Schedule Id");

        tfTicketId.setEditable(false);

        tfScheduleId.setEditable(false);

        tfPurchaseDate.setEditable(false);

        tfPurchaseTime.setEditable(false);

        lblPurchaseDate.setForeground(new java.awt.Color(255, 255, 255));
        lblPurchaseDate.setText("Purchase Date");

        lblOrderTime.setForeground(new java.awt.Color(255, 255, 255));
        lblOrderTime.setText("Purchase Time");

        tableTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Seat ID", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableTable);

        tfTotalAmount.setEditable(false);
        tfTotalAmount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        lblTotalAmount.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalAmount.setText("Amount(RM) :");

        lblMemId.setForeground(new java.awt.Color(255, 255, 255));
        lblMemId.setText("Customer ID:");

        lblPaidAmount.setForeground(new java.awt.Color(255, 255, 255));
        lblPaidAmount.setText("Paid Amount :");

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel24.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ok.png"))); // NOI18N
        btnOk.setText("Ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GST:");

        jTextField1.setEditable(false);
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField1.setText("6 %");

        lblBusId.setForeground(new java.awt.Color(255, 255, 255));
        lblBusId.setText("Bus ID");

        lblBusType.setForeground(new java.awt.Color(255, 255, 255));
        lblBusType.setText("Bus Type");

        tfBusType.setEditable(false);

        tfBusId.setEditable(false);

        tfCusId.setEditable(false);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Total Amount:");

        tfAmountGST.setEditable(false);
        tfAmountGST.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Total Seat(s):");

        tfTotalSeats.setEditable(false);

        javax.swing.GroupLayout pnlScreenLayout = new javax.swing.GroupLayout(pnlScreen);
        pnlScreen.setLayout(pnlScreenLayout);
        pnlScreenLayout.setHorizontalGroup(
            pnlScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlScreenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlScreenLayout.createSequentialGroup()
                        .addGroup(pnlScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlScreenLayout.createSequentialGroup()
                                .addGroup(pnlScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(lblScheduleId, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(pnlScreenLayout.createSequentialGroup()
                                .addComponent(lblTicketId)
                                .addGap(26, 26, 26)))
                        .addGroup(pnlScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfTicketId, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addGroup(pnlScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfScheduleId)
                                .addComponent(tfTotalSeats, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(pnlScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBusType, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblBusId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfBusType, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                            .addComponent(tfBusId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOrderTime, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPurchaseDate, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(pnlScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfPurchaseTime, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfPurchaseDate, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlScreenLayout.createSequentialGroup()
                        .addGroup(pnlScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlScreenLayout.createSequentialGroup()
                                .addGroup(pnlScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlScreenLayout.createSequentialGroup()
                                        .addComponent(lblMemId)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfCusId))
                                    .addGroup(pnlScreenLayout.createSequentialGroup()
                                        .addComponent(lblPaidAmount)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfPaidAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTotalAmount, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(pnlScreenLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(pnlScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfTotalAmount)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                            .addComponent(btnCancel)
                            .addComponent(tfAmountGST)))
                    .addComponent(jScrollPane1))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        pnlScreenLayout.setVerticalGroup(
            pnlScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlScreenLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(pnlScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTicketId)
                    .addComponent(tfTicketId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPurchaseDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPurchaseDate)
                    .addComponent(lblBusId)
                    .addComponent(tfBusId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblScheduleId)
                    .addComponent(tfPurchaseTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOrderTime)
                    .addComponent(lblBusType)
                    .addComponent(tfBusType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfScheduleId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnlScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfTotalSeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(lblMemId)
                        .addComponent(tfCusId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalAmount)
                    .addComponent(lblPaidAmount)
                    .addComponent(tfPaidAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(tfAmountGST, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(pnlScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk)
                    .addComponent(btnCancel))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
        new PaymentType(scId ,seatIds, price+"",busId, cusId).setVisible(true);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
     
        try {
            TicketAL al = new TicketAL();
            double changes = al.getCharge(tfPaidAmount.getText(), tfAmountGST.getText());
            
            if(changes >=0){
                PrintBill print =new PrintBill();

                print.setSeats(seatIds);
                print.setTicketId(tfTicketId.getText());
                print.setScId(scId);
                print.setBusId(busId);
                print.setBusType(tfBusType.getText());
                print.setPurchaseDate(tfPurchaseDate.getText());
                print.setPurchaseTime(tfPurchaseTime.getText());
                print.setCusId(cusId);
                print.setPaidAmount(tfPaidAmount.getText());
                print.setPrice(price+"");
                print.setAmount(tfTotalAmount.getText());
                print.setAmountWithGST(tfAmountGST.getText());
                print.setChange(changes);
                print.setTotalSeats(tfTotalSeats.getText());

                boolean success = print.printBill();

                if(success){
                    JOptionPane.showMessageDialog(this, "Receipt had been generated.");
                    this.dispose();
                    new PurchaseTicket().setVisible(true);
                }

                //insert into ticket
                String ticketId = tfTicketId.getText();
                String amountWithGST = tfAmountGST.getText();
                String paymentType="Cash";
                String cardNo ="-";
                String[] values={ticketId, scId,cusId,amountWithGST,paymentType, cardNo};
                
                TicketAL ticketAl = new TicketAL();
                boolean isAddedTicket = ticketAl.addTicket(values);
                
                if(isAddedTicket){
                    //insert into seatTicket
                    SeatTicketAL stAl = new SeatTicketAL();
                    boolean scs = stAl.addSeatTicket(seatIds, ticketId);
                }
                
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnOkActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblBusId;
    private javax.swing.JLabel lblBusType;
    private javax.swing.JLabel lblMemId;
    private javax.swing.JLabel lblOrderTime;
    private javax.swing.JLabel lblPaidAmount;
    private javax.swing.JLabel lblPurchaseDate;
    private javax.swing.JLabel lblScheduleId;
    private javax.swing.JLabel lblTicketId;
    private javax.swing.JLabel lblTotalAmount;
    private javax.swing.JPanel pnlScreen;
    private javax.swing.JTable tableTable;
    private javax.swing.JTextField tfAmountGST;
    private javax.swing.JTextField tfBusId;
    private javax.swing.JTextField tfBusType;
    private javax.swing.JTextField tfCusId;
    private javax.swing.JTextField tfPaidAmount;
    private javax.swing.JTextField tfPurchaseDate;
    private javax.swing.JTextField tfPurchaseTime;
    private javax.swing.JTextField tfScheduleId;
    private javax.swing.JTextField tfTicketId;
    private javax.swing.JTextField tfTotalAmount;
    private javax.swing.JTextField tfTotalSeats;
    // End of variables declaration//GEN-END:variables
}
