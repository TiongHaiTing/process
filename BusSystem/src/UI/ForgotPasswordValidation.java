package UI;

import AppLogic.StaffAL;
import Domain.StaffModel;
import java.awt.Color;
import java.io.File;
import javax.swing.JOptionPane;

public class ForgotPasswordValidation extends javax.swing.JDialog {

    private String staffId;
    
    public ForgotPasswordValidation(java.awt.Frame parent, boolean modal, String staffId) throws Exception {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Forget Password");
        this.staffId =staffId;
        tfStaffId.setText(staffId);
        showQuestion();
    }
    private void showQuestion(){
        try {
            StaffAL al = new StaffAL();
            StaffModel staff = al.getAStaffInform(staffId);
            tfAQuestion.setText(staff.getRecoveryQuestion());
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlScr = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblQues = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfAQuestion = new javax.swing.JTextArea();
        lblAns = new javax.swing.JLabel();
        tfAnswer = new javax.swing.JTextField();
        btnOk = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblStaffId = new javax.swing.JLabel();
        tfStaffId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlScr.setBackground(new java.awt.Color(204, 204, 204));

        lblTitle.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 0, 51));
        lblTitle.setText("Recovery Password Processing");

        lblQues.setText("Question :");

        tfAQuestion.setEditable(false);
        tfAQuestion.setColumns(20);
        tfAQuestion.setRows(5);
        jScrollPane1.setViewportView(tfAQuestion);

        lblAns.setText("Answer :");

        tfAnswer.setForeground(new java.awt.Color(102, 102, 102));
        tfAnswer.setText("Write down the answer that you had set in the system");
        tfAnswer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfAnswerMouseClicked(evt);
            }
        });

        btnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ok.png"))); // NOI18N
        btnOk.setText("Ok ");
        btnOk.setPreferredSize(new java.awt.Dimension(100, 33));
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png"))); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.setPreferredSize(new java.awt.Dimension(100, 33));
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back.png"))); // NOI18N
        btnBack.setText("Back");
        btnBack.setAutoscrolls(true);
        btnBack.setPreferredSize(new java.awt.Dimension(100, 33));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblStaffId.setText("Staff ID :");

        tfStaffId.setEditable(false);

        javax.swing.GroupLayout pnlScrLayout = new javax.swing.GroupLayout(pnlScr);
        pnlScr.setLayout(pnlScrLayout);
        pnlScrLayout.setHorizontalGroup(
            pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlScrLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlScrLayout.createSequentialGroup()
                        .addGroup(pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(tfAnswer)
                            .addGroup(pnlScrLayout.createSequentialGroup()
                                .addGroup(pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTitle)
                                    .addComponent(lblQues)
                                    .addComponent(lblAns))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(pnlScrLayout.createSequentialGroup()
                        .addGroup(pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlScrLayout.createSequentialGroup()
                                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlScrLayout.createSequentialGroup()
                                .addComponent(lblStaffId)
                                .addGap(18, 18, 18)
                                .addComponent(tfStaffId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 50, Short.MAX_VALUE))))
        );
        pnlScrLayout.setVerticalGroup(
            pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlScrLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStaffId)
                    .addComponent(tfStaffId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(lblQues)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblAns, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlScr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlScr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        tfAnswer.setText("");
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tfAnswerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfAnswerMouseClicked
        tfAnswer.setText("");
        tfAnswer.setForeground(Color.black);
    }//GEN-LAST:event_tfAnswerMouseClicked

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        try {
            StaffAL al = new StaffAL();
            boolean isMatch = al.matchAnswer(staffId, tfAnswer.getText());
            StaffModel staff = al.getAStaffInform(staffId);
            
            if(isMatch){
                int no = JOptionPane.showConfirmDialog(null,"Please prepare your any QR-Code Scanner to retrieve your password\n"
                                                          + " before you retrieve your password ","Confirmation",JOptionPane.CLOSED_OPTION);
                                                          
                
                if(no ==0){
                    System.out.println(staff.getStaffId());
                    System.out.println(staff.getPassword());
                    //generate qr code
                    try {
                        String pass = staff.getPassword();

                        QRCodeGenerator q=new QRCodeGenerator(null, true,staffId,pass);

                        boolean  s =q.qrGenerate();
                        q.setVisible(true);

                    }catch(Exception e){
                        JOptionPane.showMessageDialog(this,e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                //determine staff's position
                if(staff.getPosition().equals("Manager")){
                    new ManagerMenu().setVisible(true);
                    this.dispose();
                }
                else{
                    new StaffMenu().setVisible(true);
                    this.dispose();
                }
            }else{
                JOptionPane.showMessageDialog(this, "Answer is not match.Please try again. ", "Matching Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Matching Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnOkActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAns;
    private javax.swing.JLabel lblQues;
    private javax.swing.JLabel lblStaffId;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlScr;
    private javax.swing.JTextArea tfAQuestion;
    private javax.swing.JTextField tfAnswer;
    private javax.swing.JTextField tfStaffId;
    // End of variables declaration//GEN-END:variables
}
