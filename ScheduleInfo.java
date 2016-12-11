package UI;

import AppLogic.ScheduleAL;
import Domain.ScheduleModel;
import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ScheduleInfo extends javax.swing.JFrame {
    private String selectedId="";
    DefaultTableModel tableModel;
    
    public ScheduleInfo() {
        initComponents();
        setTitle("Schedule Management");
        setLocationRelativeTo(null);
        setResizable(false);
        viewTableContent();
    }

    private void viewTableContent(){
        try {
            ScheduleAL al = new ScheduleAL();
            
            tableModel = (DefaultTableModel)tableSchedule.getModel();
            ArrayList<ScheduleModel> scheduleList =al.getAllSchedules();
            
            for(int i=0;i< scheduleList.size();i++){
                ScheduleModel sc = scheduleList.get(i);
                
                String scId = sc.getScheduleId();
                String departDate = new java.sql.Date(sc.getDepartDate().getTime())+"";
                String departTime = sc.getDepartTime();
                String fromLocation = sc.getFromLocation();
                String toLocation = sc.getToLocation();
                String price = sc.getPrice()+"";
                String availability = sc.getAvailability();
                String busId = sc.getBusId();
                String staffId = sc.getStaffId();

                String[] tableValue = {scId,
                                       departDate,
                                       departTime,
                                       fromLocation,
                                       toLocation,
                                       price,
                                       availability,
                                       busId,
                                       staffId
                                      };

                tableModel.addRow(tableValue);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlScr = new javax.swing.JPanel();
        lblSearchLocation = new javax.swing.JLabel();
        lblSortBy = new javax.swing.JLabel();
        comBoxSortBy = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        comBoxFromLocation = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSchedule = new javax.swing.JTable();
        lblSearchDate = new javax.swing.JLabel();
        chooserDate = new com.toedter.calendar.JDateChooser();
        btnSearch = new javax.swing.JButton();
        checkUnavailable = new javax.swing.JCheckBox();
        btnFilter = new javax.swing.JButton();
        checkAvailable = new javax.swing.JCheckBox();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnUnactive = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menuBus = new javax.swing.JMenu();
        menuCus = new javax.swing.JMenu();
        menuStaff = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlScr.setBackground(new java.awt.Color(0, 204, 0));

        lblSearchLocation.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblSearchLocation.setText("Search From Location : ");

        lblSortBy.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblSortBy.setText("Sort By ");

        comBoxSortBy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Schedule ID", "Depart Date", "Price" }));
        comBoxSortBy.setPreferredSize(new java.awt.Dimension(100, 25));
        comBoxSortBy.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comBoxSortByItemStateChanged(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        lblTitle.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Bus Schedule Management");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
        );

        comBoxFromLocation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Taiping", "Kuala Lumpur", "Gen-Highlands", "Johor", "Kuantan", "Malacca", "KLIA" }));
        comBoxFromLocation.setPreferredSize(new java.awt.Dimension(100, 25));
        comBoxFromLocation.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comBoxFromLocationItemStateChanged(evt);
            }
        });

        tableSchedule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Schedule ID", "Depart Date", "Depart Time", "From Location", "Destination", "Price", "Availability", "Bus ID", "Staff ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSchedule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableScheduleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableSchedule);

        lblSearchDate.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblSearchDate.setText("Search By Depart Date :");

        chooserDate.setBackground(new java.awt.Color(0, 204, 0));
        chooserDate.setPreferredSize(new java.awt.Dimension(100, 25));

        btnSearch.setForeground(new java.awt.Color(255, 0, 255));
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        checkUnavailable.setBackground(new java.awt.Color(102, 255, 102));
        checkUnavailable.setText("Unavailable");

        btnFilter.setForeground(new java.awt.Color(204, 0, 204));
        btnFilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/filter.png"))); // NOI18N
        btnFilter.setText("Filter");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        checkAvailable.setBackground(new java.awt.Color(102, 255, 102));
        checkAvailable.setText("Available");

        btnAdd.setForeground(new java.awt.Color(255, 0, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAdd.setMaximumSize(new java.awt.Dimension(100, 33));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setForeground(new java.awt.Color(255, 0, 255));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setPreferredSize(new java.awt.Dimension(100, 33));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnUnactive.setForeground(new java.awt.Color(255, 0, 255));
        btnUnactive.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel24.png"))); // NOI18N
        btnUnactive.setText("Unactive");
        btnUnactive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnactiveActionPerformed(evt);
            }
        });

        btnLogOut.setForeground(new java.awt.Color(255, 0, 0));
        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logOut.png"))); // NOI18N
        btnLogOut.setText("Log Out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        btnBack.setForeground(new java.awt.Color(255, 0, 51));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back.png"))); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
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

        javax.swing.GroupLayout pnlScrLayout = new javax.swing.GroupLayout(pnlScr);
        pnlScr.setLayout(pnlScrLayout);
        pnlScrLayout.setHorizontalGroup(
            pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlScrLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlScrLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pnlScrLayout.createSequentialGroup()
                        .addComponent(lblSearchLocation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comBoxFromLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSortBy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comBoxSortBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))
                    .addGroup(pnlScrLayout.createSequentialGroup()
                        .addComponent(lblSearchDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlScrLayout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnUnactive)
                                .addGap(18, 18, 18)
                                .addComponent(btnRefresh)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlScrLayout.createSequentialGroup()
                                .addGroup(pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlScrLayout.createSequentialGroup()
                                        .addComponent(btnSearch)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlScrLayout.createSequentialGroup()
                                        .addComponent(chooserDate, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 289, Short.MAX_VALUE)
                                        .addComponent(checkAvailable)
                                        .addGap(18, 18, 18)
                                        .addComponent(checkUnavailable)
                                        .addGap(8, 8, 8)
                                        .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())))
                    .addGroup(pnlScrLayout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLogOut)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlScrLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        pnlScrLayout.setVerticalGroup(
            pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlScrLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSearchLocation)
                    .addComponent(comBoxFromLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSortBy)
                    .addComponent(comBoxSortBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSearchDate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(checkUnavailable)
                        .addComponent(btnFilter)
                        .addComponent(checkAvailable))
                    .addComponent(chooserDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlScrLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUnactive)
                            .addComponent(btnRefresh))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlScrLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addGroup(pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))))
        );

        menuBus.setText("Bus Info");
        menuBus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuBusMouseClicked(evt);
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

        menuStaff.setText("Staff Info");
        menuStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuStaffMouseClicked(evt);
            }
        });
        menuBar.add(menuStaff);

        setJMenuBar(menuBar);

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

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new ManagerMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        new ScheduleRegisterForm().setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        tableModel.setRowCount(0);//set the row start from 0
        selectedId = "";
        comBoxFromLocation.setSelectedIndex(0);
        chooserDate.setDate(null);
        checkAvailable.setSelected(false);
        checkUnavailable.setSelected(false);
        viewTableContent();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void comBoxFromLocationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comBoxFromLocationItemStateChanged
        tableModel.setRowCount(0);//set the row start from 0
        
        if(evt.getStateChange() == ItemEvent.SELECTED){
            String fromLcl = (String)comBoxFromLocation.getSelectedItem();
            
            if(fromLcl.equals("") || fromLcl ==null)
                return ;
            
            try {
                ScheduleAL al = new ScheduleAL();

                 tableModel = (DefaultTableModel)tableSchedule.getModel();
                 ArrayList<ScheduleModel> scheduleList =al.getSearchedByFromLocationSchedules(fromLcl);

                 for(int i=0;i< scheduleList.size();i++){
                    ScheduleModel sc = scheduleList.get(i);

                    String scId = sc.getScheduleId();
                    String departDate = new java.sql.Date(sc.getDepartDate().getTime())+"";
                    String departTime = sc.getDepartTime();
                    String fromLocation = sc.getFromLocation();
                    String toLocation = sc.getToLocation();
                    String price = sc.getPrice()+"";
                    String availability = sc.getAvailability();
                    String busId = sc.getBusId();
                    String staffId = sc.getStaffId();

                    String[] tableValue = {scId,
                                           departDate,
                                           departTime,
                                           fromLocation,
                                           toLocation,
                                           price,
                                           availability,
                                           busId,
                                           staffId
                                          };

                    tableModel.addRow(tableValue);  
                 }
                 
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            
        }
    }//GEN-LAST:event_comBoxFromLocationItemStateChanged

    private void comBoxSortByItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comBoxSortByItemStateChanged
        tableModel.setRowCount(0);//set the row start from 0
        if(evt.getStateChange() == ItemEvent.SELECTED){
            
            String sortBy = (String)comBoxSortBy.getSelectedItem();
            
            if(sortBy.equals("") || sortBy==null)//do nothing
                return ;
            
            try {
                ScheduleAL al = new ScheduleAL();

                 tableModel = (DefaultTableModel)tableSchedule.getModel();
                 ArrayList<ScheduleModel> scheduleList =al.getSortSchedules(sortBy);

                 for(int i=0;i< scheduleList.size();i++){
                    ScheduleModel sc = scheduleList.get(i);

                    String scId = sc.getScheduleId();
                    String departDate = new java.sql.Date(sc.getDepartDate().getTime())+"";
                    String departTime = sc.getDepartTime();
                    String fromLocation = sc.getFromLocation();
                    String toLocation = sc.getToLocation();
                    String price = sc.getPrice()+"";
                    String availability = sc.getAvailability();
                    String busId = sc.getBusId();
                    String staffId = sc.getStaffId();

                    String[] tableValue = {scId,
                                           departDate,
                                           departTime,
                                           fromLocation,
                                           toLocation,
                                           price,
                                           availability,
                                           busId,
                                           staffId
                                          };

                    tableModel.addRow(tableValue);  
                 }
                 
            } catch (Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }  
        }        
    }//GEN-LAST:event_comBoxSortByItemStateChanged

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        
        tableModel.setRowCount(0);//set the row start from 0
        String[] av  = new String[2];
        String position="";

        if(checkAvailable.isSelected())
            av[0] = checkAvailable.getText();
        
        if(checkUnavailable.isSelected())
            av[1] = checkUnavailable.getText();
        
        
        try {
            ScheduleAL al = new ScheduleAL();

            tableModel = (DefaultTableModel)tableSchedule.getModel();
            ArrayList<ScheduleModel> scheduleList =al.getFilterSchedules(av);
            
            for(int i=0;i< scheduleList.size();i++){
                    ScheduleModel sc = scheduleList.get(i);

                    String scId = sc.getScheduleId();
                    String departDate = new java.sql.Date(sc.getDepartDate().getTime())+"";
                    String departTime = sc.getDepartTime();
                    String fromLocation = sc.getFromLocation();
                    String toLocation = sc.getToLocation();
                    String price = sc.getPrice()+"";
                    String availability = sc.getAvailability();
                    String busId = sc.getBusId();
                    String staffId = sc.getStaffId();

                    String[] tableValue = {scId,
                                           departDate,
                                           departTime,
                                           fromLocation,
                                           toLocation,
                                           price,
                                           availability,
                                           busId,
                                           staffId
                                          };

                    tableModel.addRow(tableValue);  
                 }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnFilterActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        Date dDate = chooserDate.getDate();
        
        try {
            ScheduleAL al = new ScheduleAL();

            tableModel = (DefaultTableModel)tableSchedule.getModel();
            tableModel.setRowCount(0);
            ArrayList<ScheduleModel> scheduleList =al.getSelectedDateSchedules(dDate);
            
            for(int i=0;i< scheduleList.size();i++){
                    ScheduleModel sc = scheduleList.get(i);

                    String scId = sc.getScheduleId();
                    String departDate = new java.sql.Date(sc.getDepartDate().getTime())+"";
                    String departTime = sc.getDepartTime();
                    String fromLocation = sc.getFromLocation();
                    String toLocation = sc.getToLocation();
                    String price = sc.getPrice()+"";
                    String availability = sc.getAvailability();
                    String busId = sc.getBusId();
                    String staffId = sc.getStaffId();

                    String[] tableValue = {scId,
                                           departDate,
                                           departTime,
                                           fromLocation,
                                           toLocation,
                                           price,
                                           availability,
                                           busId,
                                           staffId
                                          };

                    tableModel.addRow(tableValue);  
                 }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Calendar Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnUnactiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnactiveActionPerformed
        if(selectedId.equals("")||selectedId==null){
            JOptionPane.showMessageDialog(this,"Please select a schedule from the table"
                    , "Selection Error",JOptionPane.ERROR_MESSAGE);
            return ;
        }
        
        try {
            int n = JOptionPane.showConfirmDialog(this, "Are you sure want unactive schedule ID: "+ selectedId);
            
            if(n==0){
                ScheduleAL al = new ScheduleAL();
                al.setAvailability(selectedId);
            }
            else
                return;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnUnactiveActionPerformed

    private void tableScheduleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableScheduleMouseClicked
        int count = tableSchedule.getSelectedRow();//get the selected row index number
        if(count >= 0)
            selectedId = tableSchedule.getValueAt(count, 0).toString();//get the value in selected row and col 0(staffId)
        
    }//GEN-LAST:event_tableScheduleMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if(selectedId.equals("")||selectedId==null){
            JOptionPane.showMessageDialog(this,"Please select a schedule from the table"
                    , "Selection Error",JOptionPane.ERROR_MESSAGE);
        }
        else
            new ScheduleUpdate(selectedId).setVisible(true);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
      new Login().setVisible(true);
      this.dispose();
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void menuBusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuBusMouseClicked
        new BusInfo().setVisible(true);
        this.dispose();   
    }//GEN-LAST:event_menuBusMouseClicked

    private void menuCusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCusMouseClicked
        new CustomerInfo().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuCusMouseClicked

    private void menuStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuStaffMouseClicked
        new StaffInfo().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuStaffMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUnactive;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JCheckBox checkAvailable;
    private javax.swing.JCheckBox checkUnavailable;
    private com.toedter.calendar.JDateChooser chooserDate;
    private javax.swing.JComboBox comBoxFromLocation;
    private javax.swing.JComboBox comBoxSortBy;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSearchDate;
    private javax.swing.JLabel lblSearchLocation;
    private javax.swing.JLabel lblSortBy;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuBus;
    private javax.swing.JMenu menuCus;
    private javax.swing.JMenu menuStaff;
    private javax.swing.JPanel pnlScr;
    private javax.swing.JTable tableSchedule;
    // End of variables declaration//GEN-END:variables
}
