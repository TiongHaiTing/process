package UI;

import AppLogic.*;
import Domain.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PurchaseTicket extends javax.swing.JFrame {
    String selectedId;
    JButton[] btn;
    DefaultTableModel defaultTabletable;
    public PurchaseTicket() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        defaultTabletable = (DefaultTableModel)tableSeats.getModel();
        viewDepartDate();
    }
    
    private void viewDepartDate(){
        try {
           ScheduleAL scAl = new ScheduleAL();
           ArrayList<Date> departDates = scAl.getAllDepartDates();
           
           comBoxDepartDate.addItem(null);
           Date today =new Date();
           String stoday = new java.sql.Date(today.getTime()).toString();
           
           for(Date d:departDates){
               String sdepartDate = new java.sql.Date(d.getTime()).toString();
               
                if(sdepartDate.compareTo(stoday)>=0){
                    comBoxDepartDate.addItem(d);
                }
                
                //temp = date; 
           }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlScr = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        pnlSelection = new javax.swing.JPanel();
        lblDepartDate = new javax.swing.JLabel();
        lblDepartTime = new javax.swing.JLabel();
        lblBusId = new javax.swing.JLabel();
        lblBusType = new javax.swing.JLabel();
        btnViewSeat = new javax.swing.JButton();
        comBoxDepartDate = new javax.swing.JComboBox();
        comBoxDepartTime = new javax.swing.JComboBox();
        lblPrice = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        btnCheck = new javax.swing.JButton();
        lblSeats = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comBoxFromLocation = new javax.swing.JComboBox();
        comBoxDestination = new javax.swing.JComboBox();
        comBoxBusId = new javax.swing.JComboBox();
        tfStatus = new javax.swing.JTextField();
        tfPrice = new javax.swing.JTextField();
        tfTotalSeats = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pnlSeat = new javax.swing.JPanel();
        pnlShowSeat = new javax.swing.JPanel();
        pnlBtn = new javax.swing.JPanel();
        btnLogOut = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSeats = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tfBusId = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        btnRemoveAll = new javax.swing.JButton();
        btnPayment = new javax.swing.JButton();
        lblScId = new javax.swing.JLabel();
        tfScId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Purchase Ticket");

        pnlScr.setBackground(new java.awt.Color(0, 204, 0));

        jPanel2.setBackground(new java.awt.Color(102, 255, 102));

        lblTitle.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Happy Journey Express Sdn Bhd");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        pnlSelection.setBackground(new java.awt.Color(102, 255, 102));

        lblDepartDate.setText("Depart Date :");

        lblDepartTime.setText("Depart Time :");

        lblBusId.setText("Bus ID :");

        lblBusType.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        btnViewSeat.setText("View Seat");
        btnViewSeat.setPreferredSize(new java.awt.Dimension(79, 25));
        btnViewSeat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewSeatActionPerformed(evt);
            }
        });

        comBoxDepartDate.setPreferredSize(new java.awt.Dimension(56, 25));

        comBoxDepartTime.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "09.45 a.m.", "11.00 a.m.", "02.00 p.m.", "05.00 p.m.", "08.30 p.m.", "10.00 p.m." }));
        comBoxDepartTime.setPreferredSize(new java.awt.Dimension(56, 25));

        lblPrice.setText("Price (RM) :");

        lblStatus.setText("Status:");

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnCheck.setText("Check");
        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });

        lblSeats.setText("Total Seats:");

        jLabel2.setText("From :");

        jLabel3.setText("Destination:");

        comBoxFromLocation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Taiping", "Kuala Lumpur", "Gen-Highlands", "Johor", "Kuantan", "Malacca", "KLIA" }));
        comBoxFromLocation.setMinimumSize(new java.awt.Dimension(56, 25));
        comBoxFromLocation.setPreferredSize(new java.awt.Dimension(56, 25));
        comBoxFromLocation.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comBoxFromLocationItemStateChanged(evt);
            }
        });

        comBoxDestination.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Kuala Lumpur", "Gen-Highlands", "Johor", "Kuantan", "Malacca", "KLIA" }));
        comBoxDestination.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comBoxDestinationItemStateChanged(evt);
            }
        });

        comBoxBusId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comBoxBusIdItemStateChanged(evt);
            }
        });

        tfStatus.setEditable(false);

        tfPrice.setEditable(false);

        tfTotalSeats.setEditable(false);

        jPanel3.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jLabel4.setText("Available");

        jLabel5.setText("Chosen Seat");

        javax.swing.GroupLayout pnlSelectionLayout = new javax.swing.GroupLayout(pnlSelection);
        pnlSelection.setLayout(pnlSelectionLayout);
        pnlSelectionLayout.setHorizontalGroup(
            pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelectionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSelectionLayout.createSequentialGroup()
                        .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlSelectionLayout.createSequentialGroup()
                                .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDepartTime)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(lblBusId))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comBoxDepartTime, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comBoxFromLocation, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comBoxDestination, 0, 101, Short.MAX_VALUE)))
                            .addGroup(pnlSelectionLayout.createSequentialGroup()
                                .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCheck)
                                    .addGroup(pnlSelectionLayout.createSequentialGroup()
                                        .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSelectionLayout.createSequentialGroup()
                                                .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblPrice)
                                                    .addComponent(lblStatus))
                                                .addGap(19, 19, 19))
                                            .addGroup(pnlSelectionLayout.createSequentialGroup()
                                                .addComponent(lblSeats)
                                                .addGap(17, 17, 17)))
                                        .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(tfTotalSeats)
                                            .addComponent(comBoxBusId, javax.swing.GroupLayout.Alignment.LEADING, 0, 100, Short.MAX_VALUE)
                                            .addComponent(tfStatus, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfPrice, javax.swing.GroupLayout.Alignment.LEADING))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnlSelectionLayout.createSequentialGroup()
                                .addComponent(lblDepartDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comBoxDepartDate, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBusType, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(pnlSelectionLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlSelectionLayout.createSequentialGroup()
                        .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlSelectionLayout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4))
                            .addComponent(btnViewSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlSelectionLayout.setVerticalGroup(
            pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelectionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDepartDate)
                    .addComponent(comBoxDepartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDepartTime)
                    .addComponent(comBoxDepartTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comBoxFromLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comBoxDestination, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(btnCheck)
                .addGap(23, 23, 23)
                .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBusId)
                        .addComponent(comBoxBusId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblBusType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus)
                    .addComponent(tfStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrice)
                    .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSeats)
                    .addComponent(tfTotalSeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRefresh)
                .addGap(18, 18, 18)
                .addComponent(btnViewSeat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlSeat.setBackground(new java.awt.Color(102, 255, 102));

        pnlShowSeat.setBackground(new java.awt.Color(102, 255, 102));
        pnlShowSeat.setPreferredSize(new java.awt.Dimension(435, 435));

        javax.swing.GroupLayout pnlShowSeatLayout = new javax.swing.GroupLayout(pnlShowSeat);
        pnlShowSeat.setLayout(pnlShowSeatLayout);
        pnlShowSeatLayout.setHorizontalGroup(
            pnlShowSeatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 529, Short.MAX_VALUE)
        );
        pnlShowSeatLayout.setVerticalGroup(
            pnlShowSeatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlSeatLayout = new javax.swing.GroupLayout(pnlSeat);
        pnlSeat.setLayout(pnlSeatLayout);
        pnlSeatLayout.setHorizontalGroup(
            pnlSeatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSeatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlShowSeat, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlSeatLayout.setVerticalGroup(
            pnlSeatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSeatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlShowSeat, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlBtn.setBackground(new java.awt.Color(102, 255, 102));

        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logOut.png"))); // NOI18N
        btnLogOut.setText("Log Out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back.png"))); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tableSeats.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Seat ID", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSeats.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSeatsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableSeats);

        jLabel1.setText("Bus ID:");

        tfBusId.setEditable(false);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnRemoveAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png"))); // NOI18N
        btnRemoveAll.setText("RemoveAll");
        btnRemoveAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveAllActionPerformed(evt);
            }
        });

        btnPayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pay.png"))); // NOI18N
        btnPayment.setText("Payment");
        btnPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentActionPerformed(evt);
            }
        });

        lblScId.setText("Schedule ID:");

        tfScId.setEditable(false);

        javax.swing.GroupLayout pnlBtnLayout = new javax.swing.GroupLayout(pnlBtn);
        pnlBtn.setLayout(pnlBtnLayout);
        pnlBtnLayout.setHorizontalGroup(
            pnlBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnPayment, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogOut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                        .addComponent(btnBack, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRemoveAll, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBtnLayout.createSequentialGroup()
                        .addGroup(pnlBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblScId)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfBusId, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addComponent(tfScId))
                        .addGap(21, 21, 21)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pnlBtnLayout.setVerticalGroup(
            pnlBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfBusId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblScId)
                    .addComponent(tfScId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addGap(18, 18, 18)
                .addComponent(btnRemoveAll)
                .addGap(18, 18, 18)
                .addComponent(btnPayment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(18, 18, 18)
                .addComponent(btnLogOut)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlScrLayout = new javax.swing.GroupLayout(pnlScr);
        pnlScr.setLayout(pnlScrLayout);
        pnlScrLayout.setHorizontalGroup(
            pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlScrLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlScrLayout.createSequentialGroup()
                        .addComponent(pnlSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlSeat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlScrLayout.setVerticalGroup(
            pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlScrLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlScrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlSelection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlSeat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

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

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        comBoxDepartDate.setEnabled(true);
        comBoxDepartTime.setEnabled(true);
        btnViewSeat.setEnabled(true);
        
        pnlShowSeat.removeAll();
        pnlShowSeat.updateUI();
        pnlShowSeat.revalidate();
        defaultTabletable.setRowCount(0);
        clearText();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void clearText(){
        comBoxBusId.removeAllItems();
        comBoxDepartDate.setSelectedItem(null);
        comBoxDepartTime.setSelectedItem("");
        comBoxBusId.setSelectedItem("");
        
        comBoxFromLocation.setSelectedItem("");
        comBoxDestination.setSelectedItem("");
        
        lblBusType.setText("");
        tfStatus.setText("");
        tfPrice.setText("");  
        tfTotalSeats.setText("");
        tfBusId.setText("");
        clickNo=0;
    }
    
    
    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
                
        try {
            ScheduleAL scAl = new ScheduleAL();
            ArrayList<ScheduleModel> scList = scAl.getAllSchedules();
            Date selectedDate = (Date)comBoxDepartDate.getSelectedItem();

            if(selectedDate==null){
                JOptionPane.showMessageDialog(this, "Please select the 'Depart Date' before select the time", 
                                                "Error", JOptionPane.ERROR_MESSAGE); 
            }
            else if(comBoxDepartTime.getSelectedItem().equals("")){
                JOptionPane.showMessageDialog(this, "Please select the 'Depart Time' to confirm the Bus depart", 
                                                "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                comBoxBusId.removeAllItems();
                comBoxBusId.addItem("");
                int busNum=0;
                for(int i=0;i<scList.size();i++){
                    ScheduleModel sc = scList.get(i);

                    if(selectedDate.compareTo(sc.getDepartDate())==0){
                        if(comBoxDepartTime.getSelectedItem().equals(sc.getDepartTime())){
                            if(comBoxFromLocation.getSelectedItem().equals(sc.getFromLocation())&&
                                    comBoxDestination.getSelectedItem().equals(sc.getToLocation()))
                                if(sc.getAvailability().equals("Available")){
                                    comBoxBusId.addItem(sc.getBusId());
                                    busNum++;
                            }
                        }
                    }      
                }

                String msg;
                if(busNum==0){
                    msg ="No Any Buses are departing during this session.";
                }else{
                    msg ="Total Bus Depart: "+ busNum;
                    comBoxDepartDate.setEnabled(false);
                    comBoxDepartTime.setEnabled(false);   
                }
                JOptionPane.showMessageDialog(this, msg);
                                           
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_btnCheckActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
        new StaffMenu().setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnViewSeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewSeatActionPerformed
        String busId = (String)comBoxBusId.getSelectedItem();
        tfBusId.setText(busId);
        
        boolean view =viewScheduleId(busId);
        
        try {
            BusAL busAl = new BusAL();
            int busTotalSeats = busAl.getABusInfo(busId).getTotalSeats();
            btn=new JButton[busTotalSeats];
            
            
            if(busTotalSeats == 42){
                pnlShowSeat.setLayout(new GridLayout(7,7,5,5));
            }
            else if(busTotalSeats == 30){
                pnlShowSeat.setLayout(new GridLayout(5,7,5,5));
            }

            SeatAL seatAl = new SeatAL();
            ArrayList<SeatModel> seatList = seatAl.getAllSeatsByBusId(busId);
            
            for(int i=0;i<busTotalSeats;i++){
                btn[i] = new JButton();

                String seatId = seatList.get(i).getSeatId();
                
                btn[i].setText(seatId);
                
                btn[i].setLayout(new GridLayout());
                btn[i].setPreferredSize(new Dimension(350,350));
                btn[i].setBackground(Color.RED);
                pnlShowSeat.add(btn[i]);

                if(i%3 ==2)
                    pnlShowSeat.add(new JLabel());  

                JButton b = btn[i];
                btn[i].addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnAction(evt,b);
                        
                    }
                });
            }
            boolean isSelected =getSelectedSeats();
            
            btnViewSeat.setEnabled(false);
            revalidate();
            repaint();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }        
    }//GEN-LAST:event_btnViewSeatActionPerformed

    private boolean getSelectedSeats(){
        String scId =tfScId.getText();
        
        try {
           
            TicketAL ticketAl = new TicketAL();
            ArrayList<String> ticketIdList= ticketAl.getAllTicketIdsByScId(scId);
            
            SeatTicketAL stAl = new SeatTicketAL();
            
            for(String ticketId:ticketIdList){
                ArrayList<SeatTicketModel> seatTicketList= stAl.getAllSeatIdByTicketId(ticketId);
                
                for(int i=0;i<btn.length;i++){
                    
                    for(SeatTicketModel tsM:seatTicketList){
                        if(btn[i].getActionCommand().equals(tsM.getSeatId())){
                            if(tsM.getStatus().equals("Available")){
                                btn[i].setEnabled(false);
                                btn[i].setBackground(Color.yellow);
                            }
                        }
                    }
                }
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
        return true;
    }
    private boolean viewScheduleId(String busId){
        //get schedule id
        try {
            ScheduleAL scAl = new ScheduleAL();
            ArrayList<ScheduleModel> scList=scAl.getAllSchedules();

            for(ScheduleModel sc :scList){
                Date d = sc.getDepartDate();
                
                if(comBoxDepartDate.getSelectedItem().equals(new java.sql.Date(d.getTime()))){
                    if(comBoxDepartTime.getSelectedItem().equals(sc.getDepartTime())){
                        if(busId.equals(sc.getBusId()) && sc.getAvailability().equals("Available")){
                            tfScId.setText(sc.getScheduleId());
                            break;
                        }
                    }
                }
                    
                
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        return true;
    }
    
    private void btnRemoveAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveAllActionPerformed
        
        for(int i=0;i<btn.length;i++){
            String btnName = btn[i].getText();//Text from btn arrays
            
            for(int j=0;j<defaultTabletable.getRowCount();j++){ 
                String seatFromTable = defaultTabletable.getValueAt(j, 0).toString();
                
                if(btnName.equals(seatFromTable)){
                    btn[i].setEnabled(true);
                    btn[i].setBackground(Color.red);
                }
            }
        }
        defaultTabletable.setRowCount(0);
        
    }//GEN-LAST:event_btnRemoveAllActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        
        if(count >= 0){
            defaultTabletable.removeRow(count);
            
            for(int i=0;i<btn.length;i++){
                String btnName = btn[i].getText();
                
                if(btnName.equals(selectedId)){
                    btn[i].setEnabled(true);
                    btn[i].setBackground(Color.red);
                }
            }
            
        }else{
            JOptionPane.showMessageDialog(this,"Please select a seat from table to delete",
                    "Error",JOptionPane.ERROR_MESSAGE);
        }
        
        count=-1;
    }//GEN-LAST:event_btnDeleteActionPerformed
    
    int count=-1;
    private void tableSeatsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSeatsMouseClicked
        count = tableSeats.getSelectedRow();//get the selected row index number
        if(count >= 0)
            selectedId = defaultTabletable.getValueAt(count, 0).toString();//get the value in selected row and col 0(seatId)
            
    }//GEN-LAST:event_tableSeatsMouseClicked

    private void btnPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentActionPerformed

        if(defaultTabletable.getRowCount()>0){
            String[] seatIds =new String[defaultTabletable.getRowCount()];
            
            for(int i=0;i<defaultTabletable.getRowCount();i++){ 
                seatIds[i] = defaultTabletable.getValueAt(i, 0).toString();

            } 
            
            new CustomerRegisterForm(tfScId.getText(),
                                     seatIds, 
                                     tfPrice.getText(),
                                     tfBusId.getText())
                                     .setVisible(true);
            this.dispose();
            /*
                String price=tfPrice.getText();
                String busId =tfBusId.getText();
                String scheduleId = tfScId.getText();
                
                new PaymentType(scheduleId,seatIds,price,busId,"CUS0000")
                        .setVisible(true);
            */    
        }else{
            JOptionPane.showMessageDialog(this, "No Seats are selected");
        }
    }//GEN-LAST:event_btnPaymentActionPerformed
    int clickNo;
    private void comBoxFromLocationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comBoxFromLocationItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            clickNo=0;
            if(!comBoxFromLocation.getSelectedItem().equals("Taiping")){
                comBoxDestination.setEnabled(false);
                
                boolean flag=true;
                for (int i = 0; i <comBoxDestination.getItemCount(); i++) {
                    if(comBoxDestination.getItemAt(i).equals("Taiping")){
                        flag =false;
                        break;
                    }
                }
                
                if(flag){
                    comBoxDestination.addItem("Taiping");
                }
                comBoxDestination.setSelectedItem("Taiping");
                
            }   
            else if(!comBoxFromLocation.getSelectedItem().equals("")){
                comBoxDestination.setEnabled(true);
                comBoxDestination.removeItem("Taiping");
            }
            
            
        }
    }//GEN-LAST:event_comBoxFromLocationItemStateChanged

    private void comBoxDestinationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comBoxDestinationItemStateChanged
        clickNo=0; 
    }//GEN-LAST:event_comBoxDestinationItemStateChanged

    private void comBoxBusIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comBoxBusIdItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            
            String busId = (String)comBoxBusId.getSelectedItem();
            try {
                BusAL busAl = new BusAL();
                BusModel bus =busAl.getABusInfo(busId);
                String busTypeId = bus.getBusTypeId();
                String busTypeName = busAl.getABusType(busTypeId).getBusTypeName();
                
                lblBusType.setText(busTypeName);
                
                ScheduleAL scAl = new ScheduleAL();
                ArrayList<ScheduleModel> scList = scAl.getSortSchedules("Depart Date");
                Date selectedDate = (Date)comBoxDepartDate.getSelectedItem();
                
                for(ScheduleModel s: scList){
                    
                    if(selectedDate.compareTo(s.getDepartDate())==0){
                        if(comBoxDepartTime.getSelectedItem().equals(s.getDepartTime())){
                            if(busId.equals(s.getBusId())){
                                tfStatus.setText(s.getAvailability());
                                tfPrice.setText(s.getPrice()+"");
                                tfTotalSeats.setText(bus.getTotalSeats()+"");
                                break;
                            }
                        }
                    }    
                }
                
                if(tfStatus.getText().equals("Unavailable")){
                    JOptionPane.showMessageDialog(this, "Bus ID : "+ busId +" is not available during this session");
                }
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            
        }
    }//GEN-LAST:event_comBoxBusIdItemStateChanged

    public void btnAction(java.awt.event.ActionEvent evt,JButton btn){
        String seatId =evt.getActionCommand();
        SeatModel seat =null;
        try {
            SeatAL al = new SeatAL();
            seat = al.getASeatBySeatId(seatId);
            btn.setEnabled(false);
            btn.setBackground(Color.YELLOW);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        String tableValue[]={seat.getSeatId(),seat.getStatus()};
        defaultTabletable.addRow(tableValue);
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCheck;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnPayment;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRemoveAll;
    private javax.swing.JButton btnViewSeat;
    private javax.swing.JComboBox comBoxBusId;
    private javax.swing.JComboBox comBoxDepartDate;
    private javax.swing.JComboBox comBoxDepartTime;
    private javax.swing.JComboBox comBoxDestination;
    private javax.swing.JComboBox comBoxFromLocation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBusId;
    private javax.swing.JLabel lblBusType;
    private javax.swing.JLabel lblDepartDate;
    private javax.swing.JLabel lblDepartTime;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblScId;
    private javax.swing.JLabel lblSeats;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlBtn;
    private javax.swing.JPanel pnlScr;
    private javax.swing.JPanel pnlSeat;
    private javax.swing.JPanel pnlSelection;
    private javax.swing.JPanel pnlShowSeat;
    private javax.swing.JTable tableSeats;
    private javax.swing.JTextField tfBusId;
    private javax.swing.JTextField tfPrice;
    private javax.swing.JTextField tfScId;
    private javax.swing.JTextField tfStatus;
    private javax.swing.JTextField tfTotalSeats;
    // End of variables declaration//GEN-END:variables
}
