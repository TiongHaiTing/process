package UI;

import AppLogic.StaffAL;
import Domain.StaffModel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    public static void main(String[] args) {
        new Login().setVisible(true);
    }
    public Login() {
        initComponents();        
        loginBtn.setIcon(new ImageIcon(getClass().getResource("../icons/login.png")));
        resetBtn.setIcon(new ImageIcon(getClass().getResource("../icons/reset.png")));
        cancelBtn.setIcon(new ImageIcon(getClass().getResource("../icons/cancel.png")));
        setLocationRelativeTo(null);
        setTitle("Login");
        resetBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                userPassword.setText(null);
                username.setText("");
            }
        });
        cancelBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
            }         
        });
        
        getContentPane().setBackground(new Color(0,204,0));
        setResizable(false);
    }
    
    //receive the action from controller
    public void addLoginActionListener(ActionListener listenLogin){
        loginBtn.addActionListener(listenLogin);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        logoLbl = new javax.swing.JLabel();
        staffId = new javax.swing.JLabel();
        passLbl = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        loginBtn = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        userPassword = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblForgetPassword = new javax.swing.JLabel();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        staffId.setText("Staff ID   :");

        passLbl.setText("Password :");

        loginBtn.setText("Login");
        loginBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        loginBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        resetBtn.setText("Reset");
        resetBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        resetBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        cancelBtn.setText("Cancel");
        cancelBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Happy Journey Express");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        lblForgetPassword.setForeground(new java.awt.Color(102, 0, 102));
        lblForgetPassword.setText("Forget Password?");
        lblForgetPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblForgetPasswordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblForgetPasswordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblForgetPasswordMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(logoLbl))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(staffId)
                                    .addComponent(passLbl))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(userPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblForgetPassword)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staffId)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(logoLbl)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(lblForgetPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        
        String id = username.getText();
        char[] p = userPassword.getPassword();
        String password="" ;
        
        for(int i=0;i<p.length;i++)
            password += p[i];
        
        try {
            StaffAL al = new StaffAL();
            ArrayList<StaffModel> staffList = al.getAllInformation();
            boolean isStaff=false;
            boolean validPass = false;
            
            String position ="";
            for(StaffModel staff: staffList){
                
                if(id.equals(staff.getStaffId())){
                    isStaff = true;
                    
                    if(password.equals(staff.getPassword())){
                        validPass =true;
                        position = staff.getPosition();
                    }
                }
            }
            
            if(!isStaff || !validPass){
                JOptionPane.showMessageDialog(this,
                        "Invalid username or password!","Invalid Indentity"
                        ,JOptionPane.ERROR_MESSAGE);
            }
            else if(position.equals("Manager")){
                new ManagerMenu().setVisible(true);
                this.dispose();
            }
            else{
                new StaffMenu().setVisible(true);
                this.dispose();
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }//GEN-LAST:event_loginBtnActionPerformed

    private void lblForgetPasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgetPasswordMouseEntered
        lblForgetPassword.setForeground(Color.red);
    }//GEN-LAST:event_lblForgetPasswordMouseEntered

    private void lblForgetPasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgetPasswordMouseExited
        lblForgetPassword.setForeground(new Color(102,0,102));
    }//GEN-LAST:event_lblForgetPasswordMouseExited

    private void lblForgetPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgetPasswordMouseClicked
        if(username.getText()==null || username.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please enter your 'Staff ID'");
        }
        else{
            try {
                StaffAL staffAL = new StaffAL();
                boolean isValid = staffAL.isStaffId(username.getText());
                
                if(isValid){
                     new ForgotPasswordValidation(this, true,username.getText()).setVisible(true);
                     this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(this, "Staff ID no Found!Please re-enter!","Staff ID", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(this,e.getMessage());
            }
           
        }
    }//GEN-LAST:event_lblForgetPasswordMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblForgetPassword;
    private javax.swing.JButton loginBtn;
    private javax.swing.JLabel logoLbl;
    private javax.swing.JLabel passLbl;
    private javax.swing.JButton resetBtn;
    private javax.swing.JLabel staffId;
    private javax.swing.JPasswordField userPassword;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
