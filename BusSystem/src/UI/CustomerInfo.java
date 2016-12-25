package UI;

import AppLogic.BusAL;
import AppLogic.CustomerAL;
import Domain.BusModel;
import Domain.BusTypeModel;
import Domain.CustomerModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CustomerInfo extends javax.swing.JFrame {
    private String selectedId="";
    DefaultTableModel table;
    
    public CustomerInfo() {
        initComponents();
        setTitle("Customer Details");
                
        btnModify.setIcon(new ImageIcon(getClass().getResource("../icons/edit.png")));        
        btnDel.setIcon(new ImageIcon(getClass().getResource("../icons/delete.png")));        
        btnBack.setIcon(new ImageIcon(getClass().getResource("../icons/back.png")));
        btnFilter.setIcon(new ImageIcon(getClass().getResource("../icons/filter.png")));
        btnLogOut.setIcon(new ImageIcon(getClass().getResource("../icons/logOut.png")));
        btnLogOut.setBackground(Color.red);
        CustomerInfoTable.setPreferredScrollableViewportSize(new Dimension(300,64));
        CustomerInfoTable.setFillsViewportHeight(true);
        
        viewTableContent();
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        screenPanel = new javax.swing.JPanel();
        btnModify = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        CustomerInfoTable = new javax.swing.JTable();
        btnFilter = new javax.swing.JButton();
        lblSearch = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        btnLogOut = new javax.swing.JButton();
        sortLbl = new javax.swing.JLabel();
        comboxSort = new javax.swing.JComboBox();
        checkMale = new javax.swing.JCheckBox();
        refreshBtn = new javax.swing.JButton();
        checkFermale = new javax.swing.JCheckBox();
        menuBar = new javax.swing.JMenuBar();
        menuBus = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        screenPanel.setBackground(new java.awt.Color(0, 204, 0));
        screenPanel.setDoubleBuffered(false);
        screenPanel.setFocusTraversalPolicyProvider(true);
        screenPanel.setPreferredSize(new java.awt.Dimension(800, 550));

        btnModify.setText("Modify");
        btnModify.setPreferredSize(new java.awt.Dimension(100, 38));
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });

        btnDel.setText("Delete");
        btnDel.setBorderPainted(false);
        btnDel.setPreferredSize(new java.awt.Dimension(100, 38));
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.setBorderPainted(false);
        btnBack.setPreferredSize(new java.awt.Dimension(100, 38));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        CustomerInfoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Id", "Ic No", "Name", "Gender", "Address", "email", "phone No"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        CustomerInfoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustomerInfoTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(CustomerInfoTable);

        btnFilter.setBackground(new java.awt.Color(204, 204, 204));
        btnFilter.setText("Filter");
        btnFilter.setPreferredSize(new java.awt.Dimension(100, 28));
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        lblSearch.setText("Enter Customer ID: ");

        tfSearch.setForeground(new java.awt.Color(153, 153, 153));
        tfSearch.setText("Search");
        tfSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfSearchFocusLost(evt);
            }
        });
        tfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSearchActionPerformed(evt);
            }
        });

        btnLogOut.setBackground(new java.awt.Color(204, 0, 51));
        btnLogOut.setForeground(new java.awt.Color(255, 255, 255));
        btnLogOut.setText("Log Out");
        btnLogOut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogOut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        sortLbl.setText("Sort By:");
        sortLbl.setPreferredSize(new java.awt.Dimension(59, 23));

        comboxSort.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cus Id", "IC No", "Name" }));
        comboxSort.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboxSortItemStateChanged(evt);
            }
        });

        checkMale.setBackground(new java.awt.Color(102, 255, 102));
        checkMale.setText("Male");

        refreshBtn.setText("Refresh");
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        checkFermale.setBackground(new java.awt.Color(102, 255, 102));
        checkFermale.setText("Female");
        checkFermale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkFermaleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout screenPanelLayout = new javax.swing.GroupLayout(screenPanel);
        screenPanel.setLayout(screenPanelLayout);
        screenPanelLayout.setHorizontalGroup(
            screenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(screenPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(screenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(screenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, screenPanelLayout.createSequentialGroup()
                        .addGap(576, 576, 576)
                        .addComponent(btnLogOut))
                    .addGroup(screenPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(screenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(screenPanelLayout.createSequentialGroup()
                                .addComponent(checkMale)
                                .addGap(18, 18, 18)
                                .addComponent(checkFermale)
                                .addGap(18, 18, 18)
                                .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(refreshBtn))
                            .addGroup(screenPanelLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(screenPanelLayout.createSequentialGroup()
                                .addComponent(lblSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sortLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(comboxSort, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        screenPanelLayout.setVerticalGroup(
            screenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(screenPanelLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(screenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSearch)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sortLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboxSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(screenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(screenPanelLayout.createSequentialGroup()
                        .addComponent(btnModify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(screenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(screenPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(screenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkMale)
                            .addComponent(checkFermale)
                            .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(screenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, screenPanelLayout.createSequentialGroup()
                                .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, screenPanelLayout.createSequentialGroup()
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75))))
                    .addGroup(screenPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(refreshBtn)
                        .addGap(0, 185, Short.MAX_VALUE))))
        );

        menuBus.setText("Schedule Info");
        menuBus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuBusMouseClicked(evt);
            }
        });
        menuBar.add(menuBus);

        jMenu1.setText("Bus Info");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        menuBar.add(jMenu1);

        jMenu2.setText("Staff Info");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        menuBar.add(jMenu2);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(screenPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(screenPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    private void viewTableContent(){
        try {
            CustomerAL al = new CustomerAL();
            
            table = (DefaultTableModel)CustomerInfoTable.getModel();
            ArrayList<CustomerModel> cusList = al.getAllCustomerInfo();
            
            for(int i=0;i< cusList.size();i++){
                CustomerModel cus =cusList.get(i);
                                
                String[] tableValue = { cus.getCusId() ,
                                        cus.getIcNo(),
                                        cus.getCusName(),
                                        cus.getGender(),
                                        cus.getAddress(),
                                        cus.getEmail(),
                                        cus.getPhoneNo()
                                       };
                table.addRow(tableValue);
            }
                   
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        table.setRowCount(0);//set the row start from 0
        selectedId = "";
        viewTableContent();
        clear();
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void clear(){
        checkMale.setSelected(false);
        checkFermale.setSelected(false);
    }
    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        try {
            CustomerAL al = new CustomerAL();
            al.delACustomer(selectedId);
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(), 
                    "Customer Delete",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void CustomerInfoTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomerInfoTableMouseClicked
        int count = CustomerInfoTable.getSelectedRow();//get the selected row index number
        if(count >= 0)
            selectedId = table.getValueAt(count, 0).toString();//get the value in selected row and col 0
        
    }//GEN-LAST:event_CustomerInfoTableMouseClicked

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        if(!selectedId.equals(""))
            new CustomerUpdate(selectedId).setVisible(true);
        else
            JOptionPane.showMessageDialog(this,"Please select a customer to update",
                    "Update Customer", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnModifyActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new ManagerMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void comboxSortItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboxSortItemStateChanged
        table.setRowCount(0);//set the row start from 0
        if(evt.getStateChange() == ItemEvent.SELECTED){
            
            String sortBy = (String)comboxSort.getSelectedItem();
            
            if(sortBy.equals(""))//do nothing
                return ;
            
            try {
                CustomerAL al = new CustomerAL();
                ArrayList<CustomerModel> cusList = al.sortCustomerInf(sortBy);
            
                for(int i=0;i< cusList.size();i++){
                   CustomerModel cus =cusList.get(i);

                   String[] tableValue = { cus.getCusId() ,
                                           cus.getIcNo(),
                                           cus.getCusName(),
                                           cus.getGender(),
                                           cus.getAddress(),
                                           cus.getEmail(),
                                           cus.getPhoneNo()
                                          };
                   table.addRow(tableValue);
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }  
        }
    }//GEN-LAST:event_comboxSortItemStateChanged

    private void tfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSearchActionPerformed
        String id = tfSearch.getText();
        
        try {
            CustomerAL al = new CustomerAL();
            CustomerModel cus = al.getACustomer(id);
            
            if(cus.getCusId()==null)
                throw new Exception("No Record Found");
            else{
                table.setRowCount(0);
      
                String[] tableValue = { cus.getCusId() ,
                                        cus.getIcNo(),
                                        cus.getCusName(),
                                        cus.getGender(),
                                        cus.getAddress(),
                                        cus.getEmail(),
                                        cus.getPhoneNo()
                                       };
                table.addRow(tableValue);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_tfSearchActionPerformed

    private void tfSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfSearchFocusGained
        tfSearch.setText("");
        tfSearch.setForeground(Color.BLACK);
    }//GEN-LAST:event_tfSearchFocusGained

    private void tfSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfSearchFocusLost
        tfSearch.setText("Search");
        tfSearch.setForeground(Color.GRAY);
    }//GEN-LAST:event_tfSearchFocusLost

    private void menuBusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuBusMouseClicked
        new ScheduleInfo().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuBusMouseClicked

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        String[] gender  = new String[2];
        
        //checkMale
        //checkZFermale
        
        for(int i=0;i<2;i++)
            gender[i]= new String();

        if(checkMale.isSelected())
            gender[0] = checkMale.getText();

        if(checkFermale.isSelected())
            gender[1] = checkFermale.getText();
        
        try {
            CustomerAL al = new CustomerAL();
            
            ArrayList<CustomerModel> cusList = al.getFilteredCus(gender);

            displayFilterInfo(cusList);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnFilterActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        new BusInfo().setVisible(true);
        this.dispose();  
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        new StaffInfo().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu2MouseClicked

    private void checkFermaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkFermaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkFermaleActionPerformed
    
    public void displayFilterInfo(ArrayList<CustomerModel> cusList){
        table.setRowCount(0);
        try {
            
            for(int i=0;i< cusList.size();i++){
                CustomerModel cus =cusList.get(i);
                                
                String[] tableValue = { cus.getCusId() ,
                                        cus.getIcNo(),
                                        cus.getCusName(),
                                        cus.getGender(),
                                        cus.getAddress(),
                                        cus.getEmail(),
                                        cus.getPhoneNo()
                                       };
                table.addRow(tableValue);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CustomerInfoTable;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnModify;
    private javax.swing.JCheckBox checkFermale;
    private javax.swing.JCheckBox checkMale;
    private javax.swing.JComboBox comboxSort;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuBus;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JPanel screenPanel;
    private javax.swing.JLabel sortLbl;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
