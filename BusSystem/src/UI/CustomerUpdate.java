package UI;

import AppLogic.CustomerAL;
import Domain.CustomerModel;
import java.awt.Color;
import javax.swing.JOptionPane;

public class CustomerUpdate extends javax.swing.JFrame {
    private String cusId;
    
    public CustomerUpdate(String cusId) {
        initComponents();
        this.cusId=cusId;
        tfIcNo.setForeground(Color.gray);

        viewCustomer();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Customer Update");
    }
    
    public void viewCustomer(){
        try {
            CustomerAL al = new CustomerAL();
            CustomerModel cus = al.getACustomer(cusId);
            
            tfCusId.setText(cus.getCusId());
            tfIcNo.setText(cus.getIcNo());
            tfCusName.setText(cus.getCusName());
            
            if(cus.getGender().equals(radioMale.getText()))
                radioMale.setSelected(true);
            else if(cus.getGender().equals(radioFemale.getText()))
                radioFemale.setSelected(true);
            
            tfAAddress.setText(cus.getAddress());
            tfEmail.setText(cus.getEmail());
            tfPhone.setText(cus.getPhoneNo());
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        pnlScr = new javax.swing.JPanel();
        lblCusId = new javax.swing.JLabel();
        lblIc = new javax.swing.JLabel();
        lblCusName = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPhoneNo = new javax.swing.JLabel();
        tfCusName = new javax.swing.JTextField();
        tfIcNo = new javax.swing.JTextField();
        tfCusId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfAAddress = new javax.swing.JTextArea();
        tfPhone = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        radioMale = new javax.swing.JRadioButton();
        radioFemale = new javax.swing.JRadioButton();
        pnlBtn = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Customer Register");

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));

        lblTitle.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        lblTitle.setText("     ---- Update Customer ----");

        pnlScr.setBackground(new java.awt.Color(102, 204, 255));
        pnlScr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        pnlScr.setForeground(new java.awt.Color(102, 255, 102));

        lblCusId.setText("Customer ID:");

        lblIc.setText("IC No:");

        lblCusName.setText("Customer Name:");

        lblGender.setText("Gender:");

        lblAddress.setText("Address");

        lblEmail.setText("Email:");

        lblPhoneNo.setText("Phone No:");

        tfIcNo.setText("xxxxxx-xx-xx");
        tfIcNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfIcNoFocusGained(evt);
            }
        });

        tfCusId.setEditable(false);

        tfAAddress.setColumns(20);
        tfAAddress.setRows(5);
        jScrollPane1.setViewportView(tfAAddress);

        tfEmail.setPreferredSize(new java.awt.Dimension(100, 20));

        radioMale.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(radioMale);
        radioMale.setText("Male");

        radioFemale.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(radioFemale);
        radioFemale.setText("Female");

        javax.swing.GroupLayout pnlScrLayout = new javax.swing.GroupLayout(pnlScr);
        pnlScr.setLayout(pnlScrLayout);
        pnlScrLayout.setHorizontalGroup(
            pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlScrLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCusName)
                    .addComponent(lblCusId)
                    .addComponent(lblIc)
                    .addComponent(lblGender)
                    .addComponent(lblAddress))
                .addGap(18, 18, 18)
                .addGroup(pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlScrLayout.createSequentialGroup()
                        .addGroup(pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfIcNo, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(tfCusId))
                        .addGap(78, 78, 78)
                        .addGroup(pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPhoneNo)
                            .addComponent(lblEmail))
                        .addGap(18, 18, 18)
                        .addGroup(pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfPhone)))
                    .addComponent(tfCusName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlScrLayout.createSequentialGroup()
                        .addComponent(radioMale)
                        .addGap(18, 18, 18)
                        .addComponent(radioFemale)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlScrLayout.setVerticalGroup(
            pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlScrLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCusId)
                    .addComponent(lblEmail)
                    .addComponent(tfCusId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIc)
                    .addComponent(lblPhoneNo)
                    .addComponent(tfIcNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCusName)
                    .addComponent(tfCusName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGender)
                    .addComponent(radioMale)
                    .addComponent(radioFemale))
                .addGap(18, 18, 18)
                .addGroup(pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAddress)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlBtn.setBackground(new java.awt.Color(102, 204, 255));
        pnlBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel24.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.png"))); // NOI18N
        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBtnLayout = new javax.swing.GroupLayout(pnlBtn);
        pnlBtn.setLayout(pnlBtnLayout);
        pnlBtnLayout.setHorizontalGroup(
            pnlBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnLayout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addComponent(btnUpdate)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
        );
        pnlBtnLayout.setVerticalGroup(
            pnlBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnCancel)
                    .addComponent(jButton1))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(lblTitle)
                        .addGap(0, 127, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlScr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addComponent(pnlScr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        
        String gender="";
        if(radioMale.isSelected())
            gender = radioMale.getText();
        else if(radioFemale.isSelected())
            gender = radioFemale.getText();
        
        String[] values={
            tfCusId.getText(),
            tfIcNo.getText(),
            tfCusName.getText(),
            gender,
            tfAAddress.getText(),
            tfEmail.getText(),
            tfPhone.getText()
        };
        
        try {
            CustomerAL al = new CustomerAL();
            al.updateACustomer(values);//
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tfIcNoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfIcNoFocusGained
        tfIcNo.setText("");
        tfIcNo.setForeground(Color.black);
    }//GEN-LAST:event_tfIcNoFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        viewCustomer();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblCusId;
    private javax.swing.JLabel lblCusName;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblIc;
    private javax.swing.JLabel lblPhoneNo;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlBtn;
    private javax.swing.JPanel pnlScr;
    private javax.swing.JRadioButton radioFemale;
    private javax.swing.JRadioButton radioMale;
    private javax.swing.JTextArea tfAAddress;
    private javax.swing.JTextField tfCusId;
    private javax.swing.JTextField tfCusName;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfIcNo;
    private javax.swing.JTextField tfPhone;
    // End of variables declaration//GEN-END:variables
}
