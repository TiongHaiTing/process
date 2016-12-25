package UI;

import AppLogic.StaffAL;
import Domain.StaffModel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class StaffUpdate extends javax.swing.JDialog {
    
    public StaffUpdate(java.awt.Frame parent, boolean modal,String staffId){
        super(parent, modal);
        initComponents();
        setTitle("Staff Update");
        btnUpdate.setIcon(new ImageIcon(getClass().getResource("../icons/refresh.png")));
        btnCancel.setIcon(new ImageIcon(getClass().getResource("../icons/cancel24.png")));

        ButtonGroup bg = new ButtonGroup();
        bg.add(RadioMaried);
        bg.add(RadioSingle);
        
        viewStaffProfile(staffId);
        setLocationRelativeTo(null);
    }
    
    public void viewStaffProfile(String staffId){
        try {
            StaffAL al = new StaffAL();
            StaffModel staff = al.getAStaffInform(staffId);
            
            tfStaffId.setText(staff.getStaffId()); 
            tfFirstName.setText(staff.getF_name());
            tfLastaName.setText(staff.getL_name());
            tfGender.setText(staff.getGender());
            chooserDob.setDate(staff.getDob());
            tfPhoneNo.setText(staff.getPhoneNo());
            tfEmail.setText(staff.getEmail());
            tfBasicSalary.setText(staff.getSalary()+"");
            tfPassword.setText(staff.getPassword());
            tfArAddress.setText(staff.getAddress());
            
            comBoxPosition.setSelectedItem(staff.getPosition());
            if(staff.getMarialStatus().equals(RadioMaried.getActionCommand())){
                RadioMaried.setSelected(true);
                RadioSingle.setSelected(false);
            }
            else{
                RadioMaried.setSelected(false);
                RadioSingle.setSelected(true);
            }
            
        } catch (Exception ex){
            JOptionPane.showMessageDialog(this, ex.getMessage(), 
                    "Profile Not Found", JOptionPane.ERROR_MESSAGE);
        } 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblPic = new javax.swing.JLabel();
        lbStafflId = new javax.swing.JLabel();
        lblFName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblDob = new javax.swing.JLabel();
        lblPhoneNo = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblHiredDate = new javax.swing.JLabel();
        lblPosition = new javax.swing.JLabel();
        lblSalary = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        tfLastaName = new javax.swing.JTextField();
        tfFirstName = new javax.swing.JTextField();
        tfStaffId = new javax.swing.JTextField();
        tfPhoneNo = new javax.swing.JTextField();
        tfPassword = new javax.swing.JTextField();
        tfBasicSalary = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfArAddress = new javax.swing.JTextArea();
        btnCancel = new javax.swing.JButton();
        chooserDob = new com.toedter.calendar.JDateChooser();
        comBoxPosition = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        RadioSingle = new javax.swing.JRadioButton();
        RadioMaried = new javax.swing.JRadioButton();
        tfGender = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 300));

        lblPic.setBackground(new java.awt.Color(255, 255, 255));
        lblPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/l - Copy.png"))); // NOI18N
        lblPic.setText("Pic");

        lbStafflId.setBackground(new java.awt.Color(255, 255, 255));
        lbStafflId.setText("Staff ID");

        lblFName.setText("First Name");

        lblLastName.setText("Last Name");

        lblGender.setText("Gender");

        lblDob.setText("Date Of Birth");

        lblPhoneNo.setText("Phone No");

        lblAddress.setText("Address");

        lblHiredDate.setText("Email");

        lblPosition.setText("Position");

        lblSalary.setText("Basic Salary");

        lblStatus.setText("Marial Status");

        lblPassword.setText("Password");

        btnUpdate.setText("Update");
        btnUpdate.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnUpdate.setPreferredSize(new java.awt.Dimension(100, 35));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        tfLastaName.setPreferredSize(new java.awt.Dimension(100, 20));

        tfFirstName.setPreferredSize(new java.awt.Dimension(100, 20));

        tfStaffId.setEditable(false);
        tfStaffId.setPreferredSize(new java.awt.Dimension(100, 20));

        tfPhoneNo.setPreferredSize(new java.awt.Dimension(100, 20));

        tfPassword.setPreferredSize(new java.awt.Dimension(100, 20));

        tfBasicSalary.setPreferredSize(new java.awt.Dimension(100, 20));

        tfArAddress.setColumns(20);
        tfArAddress.setRows(5);
        jScrollPane1.setViewportView(tfArAddress);

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        comBoxPosition.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Manager", "Operation Staff" }));

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));

        RadioSingle.setBackground(new java.awt.Color(102, 204, 255));
        RadioSingle.setText("Single");
        RadioSingle.setPreferredSize(new java.awt.Dimension(55, 15));

        RadioMaried.setBackground(new java.awt.Color(102, 204, 255));
        RadioMaried.setText("Married");
        RadioMaried.setPreferredSize(new java.awt.Dimension(65, 15));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(RadioSingle, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RadioMaried, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RadioSingle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RadioMaried, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        tfGender.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPic, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbStafflId)
                            .addComponent(lblPhoneNo)
                            .addComponent(lblDob, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFName)
                            .addComponent(lblLastName)
                            .addComponent(lblGender)
                            .addComponent(lblAddress))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfLastaName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfStaffId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfPhoneNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(chooserDob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfGender))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblPosition)
                                                    .addComponent(lblHiredDate)
                                                    .addComponent(lblSalary))
                                                .addGap(23, 23, 23)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(tfBasicSalary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(comBoxPosition, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(tfEmail)))
                                            .addComponent(tfPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(93, 93, 93))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblPassword)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblStatus)
                                                .addGap(18, 18, 18)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbStafflId)
                            .addComponent(tfStaffId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblHiredDate)
                            .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFName)
                            .addComponent(tfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPosition)
                            .addComponent(comBoxPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLastName)
                            .addComponent(tfLastaName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfBasicSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSalary))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblGender)
                                        .addComponent(lblStatus))
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(tfGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblDob)
                                .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPassword))
                            .addComponent(chooserDob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPhoneNo)
                            .addComponent(tfPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblPic, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(62, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblAddress)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            StaffModel staff = new StaffModel();
            
            staff.setStaffId(tfStaffId.getText());
            staff.setF_name(tfFirstName.getText());
            staff.setL_name(tfLastaName.getText());
            staff.setGender(tfGender.getText());
            staff.setDob(chooserDob.getDate());
            staff.setPhoneNo(tfPhoneNo.getText());
            staff.setEmail(tfEmail.getText());
            staff.setAddress(tfArAddress.getText());
            staff.setPosition((String)comBoxPosition.getSelectedItem());
            
            try {
                double salary = Double.parseDouble(tfBasicSalary.getText());
                staff.setSalary(salary);
            } catch (Exception e){
                JOptionPane.showMessageDialog(this, "Only Enter 'Decimal Number' in 'Salary' ",
                        "Error in Salaray Field", JOptionPane.ERROR_MESSAGE);
                return ;
            }
            
            if(RadioMaried.isSelected())
                staff.setMarialStatus(RadioMaried.getText());
            else if(RadioSingle.isSelected())
                staff.setMarialStatus(RadioSingle.getText());
            
            staff.setPassword(tfPassword.getText());
               
            StaffAL al = new StaffAL();  
            
            al.updateStaff(staff);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RadioMaried;
    private javax.swing.JRadioButton RadioSingle;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnUpdate;
    private com.toedter.calendar.JDateChooser chooserDob;
    private javax.swing.JComboBox comBoxPosition;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbStafflId;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblDob;
    private javax.swing.JLabel lblFName;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblHiredDate;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPhoneNo;
    private javax.swing.JLabel lblPic;
    private javax.swing.JLabel lblPosition;
    private javax.swing.JLabel lblSalary;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTextArea tfArAddress;
    private javax.swing.JTextField tfBasicSalary;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfFirstName;
    private javax.swing.JTextField tfGender;
    private javax.swing.JTextField tfLastaName;
    private javax.swing.JTextField tfPassword;
    private javax.swing.JTextField tfPhoneNo;
    private javax.swing.JTextField tfStaffId;
    // End of variables declaration//GEN-END:variables
}
