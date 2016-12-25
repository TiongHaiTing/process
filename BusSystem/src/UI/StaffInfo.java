package UI;

import AppLogic.StaffAL;
import Domain.StaffModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class StaffInfo extends javax.swing.JFrame {
    private String selectedId="";
    DefaultTableModel table;
    
    public StaffInfo() {
        initComponents();
        setTitle("Staff Details");
                
        btnProfile.setIcon(new ImageIcon(getClass().getResource("../icons/profile.png")));
        btnAdd.setIcon(new ImageIcon(getClass().getResource("../icons/add.png")));
        btnModify.setIcon(new ImageIcon(getClass().getResource("../icons/edit.png")));        
        btnDel.setIcon(new ImageIcon(getClass().getResource("../icons/delete.png")));        
        btnBack.setIcon(new ImageIcon(getClass().getResource("../icons/back.png")));
        btnFilter.setIcon(new ImageIcon(getClass().getResource("../icons/filter.png")));
        btnLogOut.setIcon(new ImageIcon(getClass().getResource("../icons/logOut.png")));
        btnLogOut.setBackground(Color.red);
        staffInfoTable.setPreferredScrollableViewportSize(new Dimension(300,64));
        staffInfoTable.setFillsViewportHeight(true);
        
        viewTableContent();
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        screenPanel = new javax.swing.JPanel();
        btnProfile = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        staffInfoTable = new javax.swing.JTable();
        checkMale = new javax.swing.JCheckBox();
        checkFemale = new javax.swing.JCheckBox();
        btnFilter = new javax.swing.JButton();
        searchLbl = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        btnLogOut = new javax.swing.JButton();
        sortLbl = new javax.swing.JLabel();
        comboxSort = new javax.swing.JComboBox();
        checkManager = new javax.swing.JCheckBox();
        refreshBtn = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menuBus = new javax.swing.JMenu();
        menuCus = new javax.swing.JMenu();
        menuSc = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        screenPanel.setBackground(new java.awt.Color(0, 204, 0));
        screenPanel.setDoubleBuffered(false);
        screenPanel.setFocusTraversalPolicyProvider(true);
        screenPanel.setPreferredSize(new java.awt.Dimension(800, 550));

        btnProfile.setText("Profile");
        btnProfile.setPreferredSize(new java.awt.Dimension(80, 100));
        btnProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.setMinimumSize(new java.awt.Dimension(65, 23));
        btnAdd.setPreferredSize(new java.awt.Dimension(100, 38));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

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

        staffInfoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Staff ID", "first name", "Last Name", "Gender", "Position", "Salary", "Password"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        staffInfoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                staffInfoTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(staffInfoTable);

        checkMale.setBackground(new java.awt.Color(102, 255, 102));
        checkMale.setText("Male");

        checkFemale.setBackground(new java.awt.Color(102, 255, 102));
        checkFemale.setText("Female");

        btnFilter.setBackground(new java.awt.Color(204, 204, 204));
        btnFilter.setText("Filter");
        btnFilter.setPreferredSize(new java.awt.Dimension(100, 28));
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        searchLbl.setText("Enter Staff ID: ");

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

        comboxSort.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Staff ID", "Salary", "Position" }));
        comboxSort.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboxSortItemStateChanged(evt);
            }
        });

        checkManager.setBackground(new java.awt.Color(102, 255, 102));
        checkManager.setText("Manager");

        refreshBtn.setText("Refresh");
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout screenPanelLayout = new javax.swing.GroupLayout(screenPanel);
        screenPanel.setLayout(screenPanelLayout);
        screenPanelLayout.setHorizontalGroup(
            screenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(screenPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(screenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLogOut)
                    .addGroup(screenPanelLayout.createSequentialGroup()
                        .addGroup(screenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(screenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(screenPanelLayout.createSequentialGroup()
                                .addComponent(searchLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(refreshBtn))
                            .addGroup(screenPanelLayout.createSequentialGroup()
                                .addComponent(checkMale, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(checkFemale, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(checkManager)
                                .addGap(34, 34, 34)
                                .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sortLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboxSort, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        screenPanelLayout.setVerticalGroup(
            screenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(screenPanelLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(screenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkMale)
                    .addComponent(checkFemale)
                    .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sortLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboxSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkManager))
                .addGap(18, 18, 18)
                .addGroup(screenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(screenPanelLayout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(screenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(screenPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(screenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchLbl)))
                    .addGroup(screenPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(refreshBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(screenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, screenPanelLayout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, screenPanelLayout.createSequentialGroup()
                        .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))))
        );

        menuBus.setText("Bus Info");
        menuBus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuBusMouseClicked(evt);
            }
        });
        menuBus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBusActionPerformed(evt);
            }
        });
        menuBar.add(menuBus);

        menuCus.setText("Customer Info");
        menuCus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuCusMouseClicked(evt);
            }
        });
        menuBar.add(menuCus);

        menuSc.setText("Bus Schedule Info");
        menuSc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuScMouseClicked(evt);
            }
        });
        menuBar.add(menuSc);

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
            StaffAL al = new StaffAL();
            
            table = (DefaultTableModel)staffInfoTable.getModel();
            ArrayList<StaffModel> arrList = al.getAllInformation();
            
            for(int i=0;i< arrList.size();i++){
                StaffModel staff = arrList.get(i);
                
                String staffId   = staff.getStaffId();
                String firstName = staff.getF_name();
                String lastName  = staff.getL_name();
                String gender    = staff.getGender();
                String position  = staff.getPosition();
                String salary    = staff.getSalary()+"";
                String pass      = staff.getPassword();
                String[] tableValue = {staffId, firstName,lastName,gender,position,salary,pass};
                table.addRow(tableValue);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        new StaffRegisterForm().setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        table.setRowCount(0);//set the row start from 0
        selectedId = "";
        checkMale.setSelected(false);
        checkFemale.setSelected(false);
        checkManager.setSelected(false);
                
        viewTableContent();
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        try {
            StaffAL al = new StaffAL();
            al.delStaff(selectedId);
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(), 
                    "Staff Deletion",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void staffInfoTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_staffInfoTableMouseClicked
        int count = staffInfoTable.getSelectedRow();//get the selected row index number
        if(count >= 0)
            selectedId = table.getValueAt(count, 0).toString();//get the value in selected row and col 0(staffId)
        
    }//GEN-LAST:event_staffInfoTableMouseClicked

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileActionPerformed
        if(!selectedId.equals("")){
            StaffProfile p= new StaffProfile(this,true, selectedId);
            p.setVisible(true); 
        }
        else{
            JOptionPane.showMessageDialog(this, "Please select 'A Staff' to view",
                    "Profile",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnProfileActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        if(!selectedId.equals(""))
            new StaffUpdate(this,true,selectedId).setVisible(true);
        else
            JOptionPane.showMessageDialog(this,"Please select a staff to update",
                    "Update Staff", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnModifyActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new ManagerMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        String[] gender  = new String[2];
        String position="";

        if(checkMale.isSelected())
            gender[0] = checkMale.getText();
        
        if(checkFemale.isSelected())
            gender[1] = checkFemale.getText();
        
        if(checkManager.isSelected())
            position = checkManager.getText();
        
        try {
            StaffAL al = new StaffAL();
            ArrayList<StaffModel> staffList = al.filterStaffInfo(gender, position);
            
            displayFilterInfo(staffList);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnFilterActionPerformed

    private void comboxSortItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboxSortItemStateChanged
        table.setRowCount(0);//set the row start from 0
        if(evt.getStateChange() == ItemEvent.SELECTED){
            
            String sortBy = (String)comboxSort.getSelectedItem();
            
            if(sortBy.equals(""))//do nothing
                return ;
            
            try {
                StaffAL al = new StaffAL();
                ArrayList<StaffModel> arrList = al.sortStaffInfo(sortBy);

                for(int i=0;i< arrList.size();i++){
                    StaffModel staff = arrList.get(i);

                    String staffId   = staff.getStaffId();
                    String firstName = staff.getF_name();
                    String lastName  = staff.getL_name();
                    String gender    = staff.getGender();
                    String position  = staff.getPosition();
                    String salary    = staff.getSalary()+"";
                    String pass      = staff.getPassword();
                    String[] tableValue = {staffId, firstName,lastName,gender,position,salary,pass};
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
            StaffAL al = new StaffAL();
            StaffModel staff = al.getAStaffInform(id);
            
            if(staff.getStaffId()==null)
                throw new Exception("No Record Found");
            else{
                table.setRowCount(0);
                String staffId   = staff.getStaffId();
                String firstName = staff.getF_name();
                String lastName  = staff.getL_name();
                String gender    = staff.getGender();
                String position  = staff.getPosition();
                String salary    = staff.getSalary()+"";
                String pass      = staff.getPassword();
                String[] tableValue = {staffId, firstName,lastName,gender,position,salary,pass};
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
        new BusInfo().setVisible(true);
        this.dispose();      
    }//GEN-LAST:event_menuBusMouseClicked

    private void menuBusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBusActionPerformed

    }//GEN-LAST:event_menuBusActionPerformed

    private void menuCusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCusMouseClicked
        new CustomerInfo().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuCusMouseClicked

    private void menuScMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuScMouseClicked
        new ScheduleInfo().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuScMouseClicked
    
    public void displayFilterInfo(ArrayList<StaffModel> staffList){
        table.setRowCount(0);

        for(int i=0;i< staffList.size();i++){
            StaffModel staff = staffList.get(i);

            String staffId   = staff.getStaffId();
            String firstName = staff.getF_name();
            String lastName  = staff.getL_name();
            String gender    = staff.getGender();
            String position  = staff.getPosition();
            String salary    = staff.getSalary()+"";
            String pass      = staff.getPassword();
            String[] tableValue = {staffId, firstName,lastName,gender,position,salary,pass};
            table.addRow(tableValue);
        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnModify;
    private javax.swing.JButton btnProfile;
    private javax.swing.JCheckBox checkFemale;
    private javax.swing.JCheckBox checkMale;
    private javax.swing.JCheckBox checkManager;
    private javax.swing.JComboBox comboxSort;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuBus;
    private javax.swing.JMenu menuCus;
    private javax.swing.JMenu menuSc;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JPanel screenPanel;
    private javax.swing.JLabel searchLbl;
    private javax.swing.JLabel sortLbl;
    private javax.swing.JTable staffInfoTable;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
