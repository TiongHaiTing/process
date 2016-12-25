package UI;

import AppLogic.BusAL;
import AppLogic.StaffAL;
import Domain.BusModel;
import Domain.BusTypeModel;
import Domain.StaffModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BusInfo extends javax.swing.JFrame {
    private String selectedId="";
    DefaultTableModel table;
    
    public BusInfo() {
        initComponents();
        setTitle("Bus Details");
                
        btnAdd.setIcon(new ImageIcon(getClass().getResource("../icons/add.png")));
        btnModify.setIcon(new ImageIcon(getClass().getResource("../icons/edit.png")));        
        btnDel.setIcon(new ImageIcon(getClass().getResource("../icons/delete.png")));        
        btnBack.setIcon(new ImageIcon(getClass().getResource("../icons/back.png")));
        btnFilter.setIcon(new ImageIcon(getClass().getResource("../icons/filter.png")));
        btnLogOut.setIcon(new ImageIcon(getClass().getResource("../icons/logOut.png")));
        btnLogOut.setBackground(Color.red);
        BusfInfoTable.setPreferredScrollableViewportSize(new Dimension(300,64));
        BusfInfoTable.setFillsViewportHeight(true);
        
        viewTableContent();
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        screenPanel = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        BusfInfoTable = new javax.swing.JTable();
        checkVIP = new javax.swing.JCheckBox();
        checkZClub = new javax.swing.JCheckBox();
        btnFilter = new javax.swing.JButton();
        lblSearch = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        btnLogOut = new javax.swing.JButton();
        sortLbl = new javax.swing.JLabel();
        comboxSort = new javax.swing.JComboBox();
        checkPremium = new javax.swing.JCheckBox();
        refreshBtn = new javax.swing.JButton();
        checkFirstClass = new javax.swing.JCheckBox();
        menuBar = new javax.swing.JMenuBar();
        menuSc = new javax.swing.JMenu();
        menuCus = new javax.swing.JMenu();
        menuStaff = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        screenPanel.setBackground(new java.awt.Color(0, 204, 0));
        screenPanel.setDoubleBuffered(false);
        screenPanel.setFocusTraversalPolicyProvider(true);
        screenPanel.setPreferredSize(new java.awt.Dimension(800, 550));

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

        BusfInfoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bus Id", "Bus Type ID", "Bus Type", "Plate No.", "Model", "Total Seats"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        BusfInfoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BusfInfoTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(BusfInfoTable);

        checkVIP.setBackground(new java.awt.Color(102, 255, 102));
        checkVIP.setText("VIP");

        checkZClub.setBackground(new java.awt.Color(102, 255, 102));
        checkZClub.setText("Z-Club");

        btnFilter.setBackground(new java.awt.Color(204, 204, 204));
        btnFilter.setText("Filter");
        btnFilter.setPreferredSize(new java.awt.Dimension(100, 28));
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        lblSearch.setText("Enter Bus ID: ");

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

        comboxSort.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bus Id", "Bus Type Id", "Total Seats" }));
        comboxSort.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboxSortItemStateChanged(evt);
            }
        });

        checkPremium.setBackground(new java.awt.Color(102, 255, 102));
        checkPremium.setText("Premium");

        refreshBtn.setText("Refresh");
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        checkFirstClass.setBackground(new java.awt.Color(102, 255, 102));
        checkFirstClass.setText("First Class");

        javax.swing.GroupLayout screenPanelLayout = new javax.swing.GroupLayout(screenPanel);
        screenPanel.setLayout(screenPanelLayout);
        screenPanelLayout.setHorizontalGroup(
            screenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(screenPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(screenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                .addComponent(checkVIP, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(checkZClub, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(checkPremium)
                                .addGap(18, 18, 18)
                                .addComponent(checkFirstClass)
                                .addGap(18, 18, 18)
                                .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(refreshBtn))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(screenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(screenPanelLayout.createSequentialGroup()
                        .addGap(0, 97, Short.MAX_VALUE)
                        .addGroup(screenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, screenPanelLayout.createSequentialGroup()
                                .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, screenPanelLayout.createSequentialGroup()
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75))))
                    .addGroup(screenPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(screenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkVIP)
                            .addComponent(checkZClub)
                            .addComponent(checkPremium)
                            .addComponent(checkFirstClass)
                            .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(refreshBtn))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        menuSc.setText("Schedule Info");
        menuSc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuScMouseClicked(evt);
            }
        });
        menuBar.add(menuSc);

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
            BusAL al = new BusAL();
            
            table = (DefaultTableModel)BusfInfoTable.getModel();
            ArrayList<BusModel> BusList = al.getAllBusInfo();
            
            for(int i=0;i< BusList.size();i++){
                BusModel bus =BusList.get(i);
                
                String busId   =bus.getBusId();
                String busTypeId = bus.getBusTypeId();
                BusTypeModel B = al.getABusType(busTypeId);
                String busTypeName = B.getBusTypeName();
                
                String plateNo  = bus.getPlateNo();
                String model    = bus.getModel();
                String totalSeats = bus.getTotalSeats()+"";
                
                
                String[] tableValue = { busId , busTypeId,busTypeName,plateNo, model,totalSeats};
                table.addRow(tableValue);
            }
                   
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        new BusRegisterForm().setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

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
        checkVIP.setSelected(false);
        checkZClub.setSelected(false);
        checkPremium.setSelected(false);
        checkFirstClass.setSelected(false);
    }
    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        try {
            BusAL al = new BusAL();
            al.delBusInfo(selectedId);
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(), 
                    "Bus Delete",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void BusfInfoTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BusfInfoTableMouseClicked
        int count = BusfInfoTable.getSelectedRow();//get the selected row index number
        if(count >= 0)
            selectedId = table.getValueAt(count, 0).toString();//get the value in selected row and col 0(busId)
        
    }//GEN-LAST:event_BusfInfoTableMouseClicked

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        if(!selectedId.equals(""))
            new BusUpdate(selectedId).setVisible(true);
        else
            JOptionPane.showMessageDialog(this,"Please select a bus to update",
                    "Update Staff", JOptionPane.ERROR_MESSAGE);
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
                BusAL al = new BusAL();
                ArrayList<BusModel> busList = al.sortBusInfo(sortBy);
            
                for(int i=0;i< busList.size();i++){
                    BusModel bus =busList.get(i);

                    String busId   =bus.getBusId();
                    String busTypeId = bus.getBusTypeId();
                    BusTypeModel B = al.getABusType(busTypeId);
                    String busTypeName = B.getBusTypeName();

                    String plateNo  = bus.getPlateNo();
                    String model    = bus.getModel();
                    String totalSeats = bus.getTotalSeats()+"";


                    String[] tableValue = { busId , busTypeId,busTypeName,plateNo, model,totalSeats};
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
            BusAL al = new BusAL();
            BusModel bus = al.getABusInfo(id);
            
            if(bus.getBusId()==null)
                throw new Exception("No Record Found");
            else{
                table.setRowCount(0);
      
                String busId   =bus.getBusId();
                String busTypeId = bus.getBusTypeId();
                BusTypeModel B = al.getABusType(busTypeId);
                String busTypeName = B.getBusTypeName();

                String plateNo  = bus.getPlateNo();
                String model    = bus.getModel();
                String totalSeats = bus.getTotalSeats()+"";


                String[] tableValue = { busId , busTypeId,busTypeName,plateNo, model,totalSeats};
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

    private void menuScMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuScMouseClicked
        new ScheduleInfo().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuScMouseClicked

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        String[] busTypes  = new String[4];
        
        //checkVIP
        //checkZClub
        //checkPremium
        //checkFirstClass
        
        for(int i=0;i<4;i++)
            busTypes[i]= new String();
        
        if(checkVIP.isSelected())
            busTypes[0] = checkVIP.getText();

        if(checkZClub.isSelected())
            busTypes[1] = checkZClub.getText();

        if(checkPremium.isSelected())
            busTypes[2] = checkPremium.getText();

        if(checkFirstClass.isSelected())
            busTypes[3] = checkFirstClass.getText();
        
        try {
            BusAL busAl = new BusAL();
            
            ArrayList<BusModel> busList = busAl.filterBusInfo(busTypes);

            displayFilterInfo(busList);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnFilterActionPerformed

    private void menuCusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCusMouseClicked
        new CustomerInfo().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuCusMouseClicked

    private void menuStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuStaffMouseClicked
        new StaffInfo().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuStaffMouseClicked
    
    public void displayFilterInfo(ArrayList<BusModel> busList){
        table.setRowCount(0);
        try {
            BusAL al = new BusAL();
            for(int i=0;i< busList.size();i++){
                BusModel bus =busList.get(i);

                String busId   =bus.getBusId();
                String busTypeId = bus.getBusTypeId();
                BusTypeModel B = al.getABusType(busTypeId);
                String busTypeName = B.getBusTypeName();

                String plateNo  = bus.getPlateNo();
                String model    = bus.getModel();
                String totalSeats = bus.getTotalSeats()+"";

                String[] tableValue = { busId , busTypeId,busTypeName,plateNo, model,totalSeats};
                table.addRow(tableValue);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BusfInfoTable;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnModify;
    private javax.swing.JCheckBox checkFirstClass;
    private javax.swing.JCheckBox checkPremium;
    private javax.swing.JCheckBox checkVIP;
    private javax.swing.JCheckBox checkZClub;
    private javax.swing.JComboBox comboxSort;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuCus;
    private javax.swing.JMenu menuSc;
    private javax.swing.JMenu menuStaff;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JPanel screenPanel;
    private javax.swing.JLabel sortLbl;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
