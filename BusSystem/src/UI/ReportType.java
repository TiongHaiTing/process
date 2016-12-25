package UI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class ReportType extends javax.swing.JFrame {

    public ReportType() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Report Menu");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBus = new javax.swing.JButton();
        btnCus = new javax.swing.JButton();
        btnException = new javax.swing.JButton();
        btnSummary = new javax.swing.JButton();
        tfBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Report Type");

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("--- Report Type ---");

        btnBus.setText("Bus Transaction Report");
        btnBus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusActionPerformed(evt);
            }
        });

        btnCus.setText("Customer Transaction Report");
        btnCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCusActionPerformed(evt);
            }
        });

        btnException.setText("Exception Report");
        btnException.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExceptionActionPerformed(evt);
            }
        });

        btnSummary.setText("Summary Report");
        btnSummary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSummaryActionPerformed(evt);
            }
        });

        tfBack.setForeground(new java.awt.Color(204, 0, 204));
        tfBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back.png"))); // NOI18N
        tfBack.setText("Back");
        tfBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tfBack))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnSummary, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnException, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(btnBus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnException, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSummary, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(tfBack)
                .addGap(53, 53, 53))
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

    private void btnBusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusActionPerformed
        String host = "jdbc:mysql://localhost:3306/busexpressticketingsystem?zeroDateTimeBehavior=convertToNull";
        String user = "root";
        String password = "";
        Connection conn = null;

        String reportSource = "BusTransactionReport.jrxml";

        Map<String, Object> params = new HashMap<String, Object>(); 

        try    {	 
          Class.forName("com.mysql.jdbc.Driver");
          conn = DriverManager.getConnection(host, user, password);

       JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);

       JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
       JasperViewer.viewReport(jasperPrint, false); 


       } catch (JRException jrex) {
             JOptionPane.showMessageDialog(this, "error in generating report");
               jrex.printStackTrace();
       }  catch(Exception ex) {
             JOptionPane.showMessageDialog(this, "Unble to generate report~!");
               ex.printStackTrace();
       }
    }//GEN-LAST:event_btnBusActionPerformed

    private void btnCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCusActionPerformed
        String host = "jdbc:mysql://localhost:3306/busexpressticketingsystem?zeroDateTimeBehavior=convertToNull";
        String user = "root";
        String password = "";
        Connection conn = null;

        String reportSource = "CustomerPurchaseTransactionReport.jrxml";

        Map<String, Object> params = new HashMap<String, Object>(); 

        try    {	 
          Class.forName("com.mysql.jdbc.Driver");
          conn = DriverManager.getConnection(host, user, password);

       JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);

       JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
       JasperViewer.viewReport(jasperPrint, false); 


       } catch (JRException jrex) {
             JOptionPane.showMessageDialog(this, "error in generating report");
               jrex.printStackTrace();
       }  catch(Exception ex) {
             JOptionPane.showMessageDialog(this, "Unble to generate report~!");
               ex.printStackTrace();
       }             
    }//GEN-LAST:event_btnCusActionPerformed

    private void btnExceptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExceptionActionPerformed
        String host = "jdbc:mysql://localhost:3306/busexpressticketingsystem?zeroDateTimeBehavior=convertToNull";
        String user = "root";
        String password = "";
        Connection conn = null;

        String reportSource = "ExceptionReport.jrxml";

        Map<String, Object> params = new HashMap<String, Object>(); 

        try    {	 
          Class.forName("com.mysql.jdbc.Driver");
          conn = DriverManager.getConnection(host, user, password);

       JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);

       JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
       JasperViewer.viewReport(jasperPrint, false); 


       } catch (JRException jrex) {
             JOptionPane.showMessageDialog(this, "error in generating report");
               jrex.printStackTrace();
       }  catch(Exception ex) {
             JOptionPane.showMessageDialog(this, "Unble to generate report~!");
               ex.printStackTrace();
       } 
    }//GEN-LAST:event_btnExceptionActionPerformed

    private void btnSummaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSummaryActionPerformed
String host = "jdbc:mysql://localhost:3306/busexpressticketingsystem?zeroDateTimeBehavior=convertToNull";
        String user = "root";
        String password = "";
        Connection conn = null;

        String reportSource = "SummaryReport.jrxml";

        Map<String, Object> params = new HashMap<String, Object>(); 

        try    {	 
          Class.forName("com.mysql.jdbc.Driver");
          conn = DriverManager.getConnection(host, user, password);

       JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);

       JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
       JasperViewer.viewReport(jasperPrint, false); 


       } catch (JRException jrex) {
             JOptionPane.showMessageDialog(this, "error in generating report");
               jrex.printStackTrace();
       }  catch(Exception ex) {
             JOptionPane.showMessageDialog(this, "Unble to generate report~!");
               ex.printStackTrace();
       } 
    }//GEN-LAST:event_btnSummaryActionPerformed

    private void tfBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfBackActionPerformed
        this.dispose();
        new ManagerMenu().setVisible(true);        
    }//GEN-LAST:event_tfBackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReportType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportType().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBus;
    private javax.swing.JButton btnCus;
    private javax.swing.JButton btnException;
    private javax.swing.JButton btnSummary;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton tfBack;
    // End of variables declaration//GEN-END:variables
}
