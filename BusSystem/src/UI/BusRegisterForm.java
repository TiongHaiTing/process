package UI;

import AppLogic.BusAL;
import AppLogic.SeatAL;
import Domain.BusTypeModel;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class BusRegisterForm extends javax.swing.JFrame {
    private BusAL al;
   
    public BusRegisterForm() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Bus Register");
        viewBusTypes();
    }
    
    public void viewBusTypes(){
        try {
            al = new BusAL();
            ArrayList<BusTypeModel> busTypeList = al.getAllBusTypes();  
            
            comboxBusTypeId.addItem("");
            for(int i=0;i< busTypeList.size();i++){
                BusTypeModel busType = busTypeList.get(i);
                
                comboxBusTypeId.addItem(busType.getBusTypeId());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        pnlScr = new javax.swing.JPanel();
        pnlLeft = new javax.swing.JPanel();
        lblBusId = new javax.swing.JLabel();
        tfBusId = new javax.swing.JTextField();
        btnGenerateId = new javax.swing.JButton();
        lblBusType = new javax.swing.JLabel();
        comboxBusTypeId = new javax.swing.JComboBox();
        lblBusTypeName = new javax.swing.JLabel();
        pnlRight = new javax.swing.JPanel();
        lblPlateNo = new javax.swing.JLabel();
        lblModel = new javax.swing.JLabel();
        tfPlateNo = new javax.swing.JTextField();
        tfModel = new javax.swing.JTextField();
        pnlSeat = new javax.swing.JPanel();
        lblTotalSeat = new javax.swing.JLabel();
        comboxTotalSeats = new javax.swing.JComboBox();
        btnRegister = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        pnlTitle = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 0));

        pnlScr.setBackground(new java.awt.Color(0, 204, 0));

        pnlLeft.setBackground(new java.awt.Color(102, 255, 102));
        pnlLeft.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true), "Bus Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N
        pnlLeft.setForeground(new java.awt.Color(255, 255, 255));

        lblBusId.setText("Bus Id");

        tfBusId.setEditable(false);
        tfBusId.setPreferredSize(new java.awt.Dimension(100, 25));

        btnGenerateId.setForeground(new java.awt.Color(255, 0, 255));
        btnGenerateId.setText("Generate Id");
        btnGenerateId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateIdActionPerformed(evt);
            }
        });

        lblBusType.setText("Bus Type");

        comboxBusTypeId.setPreferredSize(new java.awt.Dimension(100, 25));
        comboxBusTypeId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboxBusTypeIdItemStateChanged(evt);
            }
        });

        lblBusTypeName.setBackground(new java.awt.Color(204, 204, 204));
        lblBusTypeName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        lblBusTypeName.setPreferredSize(new java.awt.Dimension(100, 25));

        javax.swing.GroupLayout pnlLeftLayout = new javax.swing.GroupLayout(pnlLeft);
        pnlLeft.setLayout(pnlLeftLayout);
        pnlLeftLayout.setHorizontalGroup(
            pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLeftLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlLeftLayout.createSequentialGroup()
                        .addComponent(lblBusId)
                        .addGap(18, 18, 18)
                        .addComponent(tfBusId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlLeftLayout.createSequentialGroup()
                        .addComponent(lblBusType)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboxBusTypeId, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGenerateId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblBusTypeName, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );
        pnlLeftLayout.setVerticalGroup(
            pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLeftLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBusId)
                    .addComponent(tfBusId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerateId))
                .addGap(18, 18, 18)
                .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBusType)
                    .addComponent(comboxBusTypeId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBusTypeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlRight.setBackground(new java.awt.Color(102, 255, 102));
        pnlRight.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)), "Bus Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N

        lblPlateNo.setText("Plate No.");

        lblModel.setText("Bus Model ");

        tfPlateNo.setPreferredSize(new java.awt.Dimension(100, 25));

        tfModel.setPreferredSize(new java.awt.Dimension(100, 25));

        javax.swing.GroupLayout pnlRightLayout = new javax.swing.GroupLayout(pnlRight);
        pnlRight.setLayout(pnlRightLayout);
        pnlRightLayout.setHorizontalGroup(
            pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPlateNo)
                    .addComponent(lblModel))
                .addGap(18, 18, 18)
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPlateNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        pnlRightLayout.setVerticalGroup(
            pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlateNo)
                    .addComponent(tfPlateNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModel)
                    .addComponent(tfModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlSeat.setBackground(new java.awt.Color(102, 255, 102));

        lblTotalSeat.setText("Total Bus Seats :");

        comboxTotalSeats.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "30", "42" }));
        comboxTotalSeats.setPreferredSize(new java.awt.Dimension(100, 25));

        javax.swing.GroupLayout pnlSeatLayout = new javax.swing.GroupLayout(pnlSeat);
        pnlSeat.setLayout(pnlSeatLayout);
        pnlSeatLayout.setHorizontalGroup(
            pnlSeatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSeatLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblTotalSeat)
                .addGap(18, 18, 18)
                .addComponent(comboxTotalSeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSeatLayout.setVerticalGroup(
            pnlSeatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSeatLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlSeatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalSeat)
                    .addComponent(comboxTotalSeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        btnRegister.setForeground(new java.awt.Color(255, 0, 255));
        btnRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/register.png"))); // NOI18N
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnRefresh.setForeground(new java.awt.Color(255, 0, 255));
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png"))); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnCancel.setForeground(new java.awt.Color(255, 0, 255));
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel24.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        pnlTitle.setBackground(new java.awt.Color(204, 204, 204));

        lblTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("New Bus Details");

        javax.swing.GroupLayout pnlTitleLayout = new javax.swing.GroupLayout(pnlTitle);
        pnlTitle.setLayout(pnlTitleLayout);
        pnlTitleLayout.setHorizontalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTitleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlTitleLayout.setVerticalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlScrLayout = new javax.swing.GroupLayout(pnlScr);
        pnlScr.setLayout(pnlScrLayout);
        pnlScrLayout.setHorizontalGroup(
            pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlScrLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 623, Short.MAX_VALUE)
                    .addGroup(pnlScrLayout.createSequentialGroup()
                        .addComponent(pnlLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(pnlRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pnlSeat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(pnlScrLayout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(btnRegister)
                .addGap(30, 30, 30)
                .addComponent(btnRefresh)
                .addGap(32, 32, 32)
                .addComponent(btnCancel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlScrLayout.setVerticalGroup(
            pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlScrLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnlSeat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegister)
                    .addComponent(btnRefresh)
                    .addComponent(btnCancel))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlScr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlScr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void comboxBusTypeIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboxBusTypeIdItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED){
            try {
                al = new BusAL();

                BusTypeModel busType = al.getABusType((String)comboxBusTypeId.getSelectedItem());

                lblBusTypeName.setText(busType.getBusTypeName());

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_comboxBusTypeIdItemStateChanged

    private void btnGenerateIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateIdActionPerformed
        try {
            al = new BusAL();
            
            tfBusId.setText(al.getBusId());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
    }//GEN-LAST:event_btnGenerateIdActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        clearText();
    }//GEN-LAST:event_btnRefreshActionPerformed
    
    public void clearText(){
        tfBusId.setText("");
        comboxBusTypeId.setSelectedItem("");
        lblBusTypeName.setText("");
        tfPlateNo.setText("");
        tfModel.setText("");
        comboxTotalSeats.setSelectedItem("");
        
    }
    
    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        boolean isAdded=true;
        try {
            al = new BusAL();
            
            String busId = tfBusId.getText();
            String busType = (String)comboxBusTypeId.getSelectedItem();
            String plateNo = tfPlateNo.getText();
            String model = tfModel.getText();
            String totalSeat = (String)comboxTotalSeats.getSelectedItem();
            
            String[] values=new String[]{
                            busId
                            ,busType 
                            ,plateNo
                            ,model
                            ,totalSeat
                            };
            
            al.addNewBus(values);
        } catch (Exception e) {
            isAdded=false;
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
        if(isAdded){
            try {
                SeatAL seatAl = new SeatAL();
                seatAl.addAllSeats(tfBusId.getText(),(String)comboxTotalSeats.getSelectedItem());

            } catch (Exception e){
                JOptionPane.showMessageDialog(this,e.getMessage());
            }
        }
    }//GEN-LAST:event_btnRegisterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnGenerateId;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRegister;
    private javax.swing.JComboBox comboxBusTypeId;
    private javax.swing.JComboBox comboxTotalSeats;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBusId;
    private javax.swing.JLabel lblBusType;
    private javax.swing.JLabel lblBusTypeName;
    private javax.swing.JLabel lblModel;
    private javax.swing.JLabel lblPlateNo;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotalSeat;
    private javax.swing.JPanel pnlLeft;
    private javax.swing.JPanel pnlRight;
    private javax.swing.JPanel pnlScr;
    private javax.swing.JPanel pnlSeat;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JTextField tfBusId;
    private javax.swing.JTextField tfModel;
    private javax.swing.JTextField tfPlateNo;
    // End of variables declaration//GEN-END:variables
}
