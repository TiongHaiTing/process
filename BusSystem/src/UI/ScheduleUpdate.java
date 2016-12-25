package UI;

import AppLogic.BusAL;
import AppLogic.ScheduleAL;
import Domain.BusModel;
import Domain.BusTypeModel;
import Domain.ScheduleModel;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class ScheduleUpdate extends javax.swing.JFrame {
    
    private String selectedId;
    
    public ScheduleUpdate(String selectedId) {
        initComponents();
        setTitle("Schedule Update");
        this.selectedId = selectedId;
        viewScheduleDetails();
        setLocationRelativeTo(null);
    }

    private void viewScheduleDetails(){
        try {
            ScheduleAL al = new ScheduleAL();
            ScheduleModel sc = al.getASchedule(selectedId);
            
            tfStaffId.setText(sc.getStaffId());
            tfScheduleId.setText(sc.getScheduleId());
            
            BusAL busAl = new BusAL();
            BusModel bus =busAl.getABusInfo(sc.getBusId());
            String busTypeName = busAl.getABusType(bus.getBusTypeId()).getBusTypeName();
            
            if(busTypeName.equals(radioVip.getActionCommand())){
                radioVip.setSelected(true);
                radioZClub.setSelected(false);
                radioPremium.setSelected(false);
                radioFirstClass.setSelected(false);
            }
            else if(busTypeName.equals(radioZClub.getActionCommand())){
                radioVip.setSelected(false);
                radioZClub.setSelected(true);
                radioPremium.setSelected(false);
                radioFirstClass.setSelected(false);
            }
            else if(busTypeName.equals(radioPremium.getActionCommand())){
                radioVip.setSelected(false);
                radioZClub.setSelected(false);
                radioPremium.setSelected(true);
                radioFirstClass.setSelected(false);
            }
            else if(busTypeName.equals(radioFirstClass.getActionCommand())){
                radioVip.setSelected(false);
                radioZClub.setSelected(false);
                radioPremium.setSelected(false);
                radioFirstClass.setSelected(true);
            }
            
            
            comboxBusId.setSelectedItem(sc.getBusId());
            chooserDepartDate.setDate(sc.getDepartDate());
            comboxDepartTime.setSelectedItem(sc.getDepartTime());
            comboxFromLocation.setSelectedItem(sc.getFromLocation());
            comboxToLocation.setSelectedItem(sc.getToLocation());
            tfPrice.setText(sc.getPrice()+"");
            comBoxAvailability.setSelectedItem(sc.getAvailability());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Unable to view Schedule Details.",
                                        JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        pnlScreen = new javax.swing.JPanel();
        pnlTitle = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblStaffId = new javax.swing.JLabel();
        lblScheduleId = new javax.swing.JLabel();
        tfStaffId = new javax.swing.JTextField();
        tfScheduleId = new javax.swing.JTextField();
        pnlSc = new javax.swing.JPanel();
        lblBusId = new javax.swing.JLabel();
        lblDepartDate = new javax.swing.JLabel();
        chooserDepartDate = new com.toedter.calendar.JDateChooser();
        lblDepartTime = new javax.swing.JLabel();
        comboxDepartTime = new javax.swing.JComboBox();
        lblFromLocation = new javax.swing.JLabel();
        comboxFromLocation = new javax.swing.JComboBox();
        lblToLocation = new javax.swing.JLabel();
        comboxToLocation = new javax.swing.JComboBox();
        lblPrice = new javax.swing.JLabel();
        tfPrice = new javax.swing.JTextField();
        radioVip = new javax.swing.JRadioButton();
        radioZClub = new javax.swing.JRadioButton();
        radioPremium = new javax.swing.JRadioButton();
        radioFirstClass = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        comboxBusId = new javax.swing.JComboBox();
        btnCheckPrice = new javax.swing.JButton();
        lblAvailability = new javax.swing.JLabel();
        comBoxAvailability = new javax.swing.JComboBox();
        btnUpdate = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlScreen.setBackground(new java.awt.Color(102, 204, 255));

        pnlTitle.setBackground(new java.awt.Color(153, 153, 153));

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Update Schedule ");

        javax.swing.GroupLayout pnlTitleLayout = new javax.swing.GroupLayout(pnlTitle);
        pnlTitle.setLayout(pnlTitleLayout);
        pnlTitleLayout.setHorizontalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlTitleLayout.setVerticalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
        );

        lblStaffId.setText("Staff ID :");

        lblScheduleId.setText("Schedule ID:");

        tfStaffId.setEditable(false);
        tfStaffId.setPreferredSize(new java.awt.Dimension(100, 25));

        tfScheduleId.setEditable(false);
        tfScheduleId.setPreferredSize(new java.awt.Dimension(100, 25));

        pnlSc.setBackground(new java.awt.Color(102, 255, 102));

        lblBusId.setText("Bus ID :");

        lblDepartDate.setText("Depart Date: ");

        chooserDepartDate.setPreferredSize(new java.awt.Dimension(113, 20));

        lblDepartTime.setText("Depart Time:");

        comboxDepartTime.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "09.45 a.m.", "11.00 a.m.", "02.00 p.m.", "05.00 p.m.", "08.30 p.m.", "10.00 p.m." }));
        comboxDepartTime.setPreferredSize(new java.awt.Dimension(100, 25));

        lblFromLocation.setText("From Location:");

        comboxFromLocation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Taiping", "Kuala Lumpur", "Gen-Highlands", "Johor", "Kuantan", "Malacca", "KLIA" }));
        comboxFromLocation.setPreferredSize(new java.awt.Dimension(100, 25));
        comboxFromLocation.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboxFromLocationItemStateChanged(evt);
            }
        });

        lblToLocation.setText("To Location:");

        comboxToLocation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Kuala Lumpur", "Gen-Highlands", "Johor", "Kuantan", "Malacca", "KLIA" }));
        comboxToLocation.setEditor(null);
        comboxToLocation.setPreferredSize(new java.awt.Dimension(100, 25));
        comboxToLocation.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboxToLocationItemStateChanged(evt);
            }
        });

        lblPrice.setText("Price(RM):");

        tfPrice.setEditable(false);
        tfPrice.setPreferredSize(new java.awt.Dimension(100, 25));

        radioVip.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(radioVip);
        radioVip.setText("VIP");
        radioVip.setPreferredSize(new java.awt.Dimension(75, 23));
        radioVip.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioVipItemStateChanged(evt);
            }
        });

        radioZClub.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(radioZClub);
        radioZClub.setText("Z-Club");
        radioZClub.setPreferredSize(new java.awt.Dimension(75, 23));
        radioZClub.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioZClubItemStateChanged(evt);
            }
        });

        radioPremium.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(radioPremium);
        radioPremium.setText("Premium");
        radioPremium.setPreferredSize(new java.awt.Dimension(75, 23));
        radioPremium.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioPremiumItemStateChanged(evt);
            }
        });

        radioFirstClass.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(radioFirstClass);
        radioFirstClass.setText("First Class");
        radioFirstClass.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radioFirstClassItemStateChanged(evt);
            }
        });

        jLabel1.setText("Bus Type:");

        comboxBusId.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        comboxBusId.setMinimumSize(new java.awt.Dimension(100, 25));

        btnCheckPrice.setText("Check Price");
        btnCheckPrice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCheckPriceMouseClicked(evt);
            }
        });
        btnCheckPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckPriceActionPerformed(evt);
            }
        });

        lblAvailability.setText("Availability:");

        comBoxAvailability.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Available", "Unavailable" }));

        javax.swing.GroupLayout pnlScLayout = new javax.swing.GroupLayout(pnlSc);
        pnlSc.setLayout(pnlScLayout);
        pnlScLayout.setHorizontalGroup(
            pnlScLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlScLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlScLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlScLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(22, 22, 22)
                        .addComponent(radioVip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(radioZClub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(radioPremium, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(radioFirstClass, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblBusId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboxBusId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlScLayout.createSequentialGroup()
                        .addGroup(pnlScLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlScLayout.createSequentialGroup()
                                .addComponent(lblDepartDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chooserDepartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblDepartTime))
                            .addGroup(pnlScLayout.createSequentialGroup()
                                .addComponent(lblPrice)
                                .addGap(18, 18, 18)
                                .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCheckPrice)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlScLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlScLayout.createSequentialGroup()
                                .addComponent(lblAvailability)
                                .addGap(18, 18, 18)
                                .addComponent(comBoxAvailability, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlScLayout.createSequentialGroup()
                                .addComponent(comboxDepartTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblFromLocation)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboxFromLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblToLocation)
                                .addGap(18, 18, 18)
                                .addComponent(comboxToLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        pnlScLayout.setVerticalGroup(
            pnlScLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlScLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlScLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioVip, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioZClub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioPremium, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioFirstClass)
                    .addComponent(jLabel1)
                    .addComponent(lblBusId)
                    .addComponent(comboxBusId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlScLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chooserDepartDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDepartDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlScLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDepartTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboxDepartTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFromLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboxFromLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblToLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboxToLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlScLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlScLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPrice)
                        .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCheckPrice))
                    .addComponent(lblAvailability, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comBoxAvailability))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        btnUpdate.setForeground(new java.awt.Color(255, 0, 255));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setPreferredSize(new java.awt.Dimension(100, 33));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnRefresh.setForeground(new java.awt.Color(255, 0, 255));
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png"))); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.setPreferredSize(new java.awt.Dimension(100, 33));
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnCancel.setForeground(new java.awt.Color(255, 0, 255));
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel24.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setPreferredSize(new java.awt.Dimension(100, 33));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlScreenLayout = new javax.swing.GroupLayout(pnlScreen);
        pnlScreen.setLayout(pnlScreenLayout);
        pnlScreenLayout.setHorizontalGroup(
            pnlScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlScreenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlScreenLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lblStaffId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfStaffId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblScheduleId)
                        .addGap(18, 18, 18)
                        .addComponent(tfScheduleId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pnlSc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(pnlScreenLayout.createSequentialGroup()
                .addGap(264, 264, 264)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlScreenLayout.setVerticalGroup(
            pnlScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlScreenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(pnlScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStaffId)
                    .addComponent(lblScheduleId)
                    .addComponent(tfStaffId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfScheduleId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnlSc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed

        viewScheduleDetails();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void comboxFromLocationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboxFromLocationItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            clickNo=0;
            if(!comboxFromLocation.getSelectedItem().equals("Taiping")){
                comboxToLocation.setEnabled(false);
                
                boolean flag=true;
                for (int i = 0; i <comboxToLocation.getItemCount(); i++) {
                    if(comboxToLocation.getItemAt(i).equals("Taiping")){
                        flag =false;
                        break;
                    }
                }
                
                if(flag){
                    comboxToLocation.addItem("Taiping");
                }   comboxToLocation.setSelectedItem("Taiping");
            }   
            else{
                comboxToLocation.setEnabled(true);
                comboxToLocation.removeItem("Taiping");
            }
            
            
        }
    }//GEN-LAST:event_comboxFromLocationItemStateChanged

    private void comboxToLocationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboxToLocationItemStateChanged
        clickNo=0;
    }//GEN-LAST:event_comboxToLocationItemStateChanged

    private void radioVipItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioVipItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            try {
                getDifferentiatedBusId(radioVip.getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"This page will be exited as keeping changing of 'Bus Type' ",
                        "Error", JOptionPane.ERROR_MESSAGE);
                this.dispose();
            }
        }
    }//GEN-LAST:event_radioVipItemStateChanged

    private void radioZClubItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioZClubItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            try {
                getDifferentiatedBusId(radioZClub.getText());
            } catch (Exception ex){
                JOptionPane.showMessageDialog(this,"This page will be exited as keeping changing of 'Bus Type' ",
                        "Error", JOptionPane.ERROR_MESSAGE);
                this.dispose();
            }
        }
    }//GEN-LAST:event_radioZClubItemStateChanged

    private void radioPremiumItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioPremiumItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            try {
                getDifferentiatedBusId(radioPremium.getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"This page will be exited as keeping changing of 'Bus Type' ",
                        "Error", JOptionPane.ERROR_MESSAGE);
                          this.dispose();
            }
        }
    }//GEN-LAST:event_radioPremiumItemStateChanged

    private void radioFirstClassItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radioFirstClassItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            try {
                getDifferentiatedBusId(radioFirstClass.getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"This page will be exited as keeping changing of 'Bus Type' ",
                        "Error", JOptionPane.ERROR_MESSAGE);
                this.dispose();
            }
        }
    }//GEN-LAST:event_radioFirstClassItemStateChanged

    private void btnCheckPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckPriceActionPerformed
        try {
            ScheduleAL al = new ScheduleAL();
            String busId = (String)comboxBusId.getSelectedItem();
            
            double price = al.getPrice((String)comboxFromLocation.getSelectedItem(),
                                        (String)comboxToLocation.getSelectedItem(), busId);
            
            tfPrice.setText(price+"");
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Pricing Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCheckPriceActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String values[] ={tfStaffId.getText(),tfScheduleId.getText(), (String)comboxBusId.getSelectedItem(),
                          (String)comboxDepartTime.getSelectedItem(), (String)comboxFromLocation.getSelectedItem(),
                          (String)comboxToLocation.getSelectedItem(), tfPrice.getText(),
                          (String)comBoxAvailability.getSelectedItem()
                         };
        
        Date departDate = chooserDepartDate.getDate();
        
        try {
            if(clickNo !=1)
                JOptionPane.showMessageDialog(this,
                        "Please click 'check Price' to get the latest price.",
                        "Pricing",JOptionPane.ERROR_MESSAGE);
            else{
                ScheduleAL al = new ScheduleAL();
                al.changeASchedule(values, departDate);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    int clickNo=0;
    private void btnCheckPriceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCheckPriceMouseClicked
        clickNo=1;
    }//GEN-LAST:event_btnCheckPriceMouseClicked

    private boolean getDifferentiatedBusId(String busType)throws Exception{
        comboxBusId.removeAllItems();
        try {
          BusAL al = new BusAL();
          ArrayList<BusModel> busList = al.getAllBusInfo();
          comboxBusId.addItem("");
          for(int i=0;i<busList.size();i++){
              BusModel bus = busList.get(i);
              BusAL busTypeAl = new BusAL();
              
              BusTypeModel busTypeModel = busTypeAl.getABusType(bus.getBusTypeId());
              String busTypeName = busTypeModel.getBusTypeName();
              
              if(busTypeName.equals(busType))
                comboxBusId.addItem(bus.getBusId());
              
          }
          
        } catch (Exception e) {
              JOptionPane.showMessageDialog(this, e.getMessage(),
                                            "Bus ID Erro",JOptionPane.ERROR);
        }
        return true;
    }
    
    private void clearText(){
        comboxBusId.setSelectedItem("");
        chooserDepartDate.setDate(null);
        comboxDepartTime.setSelectedItem("");
        comboxFromLocation.setSelectedItem("");
        comboxToLocation.setSelectedItem("");
        tfPrice.setText("");
        tfPrice.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCheckPrice;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser chooserDepartDate;
    private javax.swing.JComboBox comBoxAvailability;
    private javax.swing.JComboBox comboxBusId;
    private javax.swing.JComboBox comboxDepartTime;
    private javax.swing.JComboBox comboxFromLocation;
    private javax.swing.JComboBox comboxToLocation;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAvailability;
    private javax.swing.JLabel lblBusId;
    private javax.swing.JLabel lblDepartDate;
    private javax.swing.JLabel lblDepartTime;
    private javax.swing.JLabel lblFromLocation;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblScheduleId;
    private javax.swing.JLabel lblStaffId;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblToLocation;
    private javax.swing.JPanel pnlSc;
    private javax.swing.JPanel pnlScreen;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JRadioButton radioFirstClass;
    private javax.swing.JRadioButton radioPremium;
    private javax.swing.JRadioButton radioVip;
    private javax.swing.JRadioButton radioZClub;
    private javax.swing.JTextField tfPrice;
    private javax.swing.JTextField tfScheduleId;
    private javax.swing.JTextField tfStaffId;
    // End of variables declaration//GEN-END:variables
}
