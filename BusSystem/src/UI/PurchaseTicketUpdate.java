package UI;

import AppLogic.*;
import Domain.*;
import File.PrintUpdatedTicket;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PurchaseTicketUpdate extends javax.swing.JFrame {
    String selectedId;
    JButton[] btn;
    DefaultTableModel defaultTabletable;
    private String ticketId;
    private int noSeat;
    ArrayList<String> originalSeatIds;
    
    public PurchaseTicketUpdate(String ticketId) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        defaultTabletable = (DefaultTableModel)tableSeats.getModel();
        this.ticketId=ticketId;
        tfTicketId.setText(ticketId);
        boolean s1 = viewData();
        boolean s2 = viewSeats();
    }
    
    private boolean viewData(){
        try{
            TicketAL ticketAl = new TicketAL();
            TicketModel ticket = ticketAl.getATicket(ticketId);
            
            tfScId.setText(ticket.getScheduleId());
            tfCusId.setText(ticket.getCusId());
            ScheduleAL scAl = new ScheduleAL();
            
            ScheduleModel sc = scAl.getASchedule(ticket.getScheduleId());
            
            tfDepartDate.setText(sc.getDepartDate().toString());
            tfDepartTime.setText(sc.getDepartTime());
            tfFrom.setText(sc.getFromLocation());
            tfDestination.setText(sc.getToLocation());
            
            BusAL busAl = new BusAL();
            BusModel bus = busAl.getABusInfo(sc.getBusId());
            String busTypeName = busAl.getABusType(bus.getBusTypeId()).getBusTypeName();
            
            lblBusType.setText(busTypeName);
            
            tfBusId.setText(bus.getBusId());
            tfStatus.setText(sc.getAvailability());
            tfPrice.setText(sc.getPrice()+"");
            tfTotalSeats.setText(bus.getTotalSeats()+"");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return true;
    }

    private boolean viewSeats(){
        
        String busId = tfBusId.getText();
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

            revalidate();
            repaint();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }     
        return true;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfDepartTime = new javax.swing.JTextField();
        tfDepartDate = new javax.swing.JTextField();
        tfFrom = new javax.swing.JTextField();
        tfDestination = new javax.swing.JTextField();
        pnlBusInfo = new javax.swing.JPanel();
        lblBusId = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        lblSeats = new javax.swing.JLabel();
        tfBusId = new javax.swing.JTextField();
        tfStatus = new javax.swing.JTextField();
        tfPrice = new javax.swing.JTextField();
        tfTotalSeats = new javax.swing.JTextField();
        lblBusType = new javax.swing.JLabel();
        pnlRed = new javax.swing.JPanel();
        pnlBlue = new javax.swing.JPanel();
        pnlYellow = new javax.swing.JPanel();
        lblRed = new javax.swing.JLabel();
        lblYellow = new javax.swing.JLabel();
        lblBlue = new javax.swing.JLabel();
        lblCusId = new javax.swing.JLabel();
        tfCusId = new javax.swing.JTextField();
        pnlSeat = new javax.swing.JPanel();
        pnlShowSeat = new javax.swing.JPanel();
        pnlBtn = new javax.swing.JPanel();
        btnLogOut = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSeats = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        lblScId = new javax.swing.JLabel();
        tfScId = new javax.swing.JTextField();
        lblTicketId = new javax.swing.JLabel();
        tfTicketId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfNoSeats = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Update Ticket");

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

        jLabel2.setText("From :");

        jLabel3.setText("Destination:");

        tfDepartTime.setEditable(false);

        tfDepartDate.setEditable(false);

        tfFrom.setEditable(false);

        tfDestination.setEditable(false);

        pnlBusInfo.setBackground(new java.awt.Color(102, 255, 102));
        pnlBusInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 2, true), "Bus Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        lblBusId.setText("Bus ID :");

        lblStatus.setText("Status:");

        lblPrice.setText("Price (RM) :");

        lblSeats.setText("Total Seats:");

        tfBusId.setEditable(false);

        tfStatus.setEditable(false);

        tfPrice.setEditable(false);

        tfTotalSeats.setEditable(false);

        lblBusType.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        javax.swing.GroupLayout pnlBusInfoLayout = new javax.swing.GroupLayout(pnlBusInfo);
        pnlBusInfo.setLayout(pnlBusInfoLayout);
        pnlBusInfoLayout.setHorizontalGroup(
            pnlBusInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBusInfoLayout.createSequentialGroup()
                .addGroup(pnlBusInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBusInfoLayout.createSequentialGroup()
                        .addComponent(lblBusId)
                        .addGap(47, 47, 47)
                        .addComponent(tfBusId))
                    .addGroup(pnlBusInfoLayout.createSequentialGroup()
                        .addComponent(lblStatus)
                        .addGap(50, 50, 50)
                        .addComponent(tfStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBusInfoLayout.createSequentialGroup()
                        .addGroup(pnlBusInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSeats)
                            .addComponent(lblPrice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlBusInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(tfTotalSeats))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBusType, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlBusInfoLayout.setVerticalGroup(
            pnlBusInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBusInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBusInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlBusInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBusId)
                        .addComponent(tfBusId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblBusType, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlBusInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus)
                    .addComponent(tfStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlBusInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrice)
                    .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlBusInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSeats)
                    .addComponent(tfTotalSeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pnlRed.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout pnlRedLayout = new javax.swing.GroupLayout(pnlRed);
        pnlRed.setLayout(pnlRedLayout);
        pnlRedLayout.setHorizontalGroup(
            pnlRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        pnlRedLayout.setVerticalGroup(
            pnlRedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );

        pnlBlue.setBackground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout pnlBlueLayout = new javax.swing.GroupLayout(pnlBlue);
        pnlBlue.setLayout(pnlBlueLayout);
        pnlBlueLayout.setHorizontalGroup(
            pnlBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        pnlBlueLayout.setVerticalGroup(
            pnlBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlYellow.setBackground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout pnlYellowLayout = new javax.swing.GroupLayout(pnlYellow);
        pnlYellow.setLayout(pnlYellowLayout);
        pnlYellowLayout.setHorizontalGroup(
            pnlYellowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        pnlYellowLayout.setVerticalGroup(
            pnlYellowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );

        lblRed.setText("Available");

        lblYellow.setText("Chosen Seat");

        lblBlue.setText("Selected Seats");

        lblCusId.setText("Customer ID:");

        tfCusId.setEditable(false);

        javax.swing.GroupLayout pnlSelectionLayout = new javax.swing.GroupLayout(pnlSelection);
        pnlSelection.setLayout(pnlSelectionLayout);
        pnlSelectionLayout.setHorizontalGroup(
            pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelectionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSelectionLayout.createSequentialGroup()
                        .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlBusInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlSelectionLayout.createSequentialGroup()
                                .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlSelectionLayout.createSequentialGroup()
                                        .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(pnlBlue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(pnlYellow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlSelectionLayout.createSequentialGroup()
                                                    .addGap(37, 37, 37)
                                                    .addComponent(pnlRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblRed)
                                            .addComponent(lblYellow)
                                            .addComponent(lblBlue)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlSelectionLayout.createSequentialGroup()
                                        .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSelectionLayout.createSequentialGroup()
                                                .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblDepartDate)
                                                    .addComponent(lblDepartTime))
                                                .addGap(18, 18, 18))
                                            .addGroup(pnlSelectionLayout.createSequentialGroup()
                                                .addComponent(lblCusId)
                                                .addGap(20, 20, 20)))
                                        .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(tfCusId, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                            .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(tfDepartDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                                .addComponent(tfDepartTime, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(tfFrom, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(tfDestination, javax.swing.GroupLayout.Alignment.LEADING)))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(21, 21, 21))
                    .addGroup(pnlSelectionLayout.createSequentialGroup()
                        .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlSelectionLayout.setVerticalGroup(
            pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelectionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDepartDate)
                    .addComponent(tfDepartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDepartTime)
                    .addComponent(tfDepartTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfDestination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCusId)
                    .addComponent(tfCusId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(pnlBusInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblRed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblYellow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlYellow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlBlue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblBlue, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(pnlShowSeat, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
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

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png"))); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pay.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        lblScId.setText("Schedule ID:");

        tfScId.setEditable(false);

        lblTicketId.setText("Ticket ID:");

        tfTicketId.setEditable(false);

        jLabel1.setText("No. of Seat:");

        tfNoSeats.setEditable(false);

        javax.swing.GroupLayout pnlBtnLayout = new javax.swing.GroupLayout(pnlBtn);
        pnlBtn.setLayout(pnlBtnLayout);
        pnlBtnLayout.setHorizontalGroup(
            pnlBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLogOut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(btnBack, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(pnlBtnLayout.createSequentialGroup()
                            .addGroup(pnlBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblScId)
                                .addComponent(lblTicketId))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(pnlBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfScId, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                .addComponent(tfTicketId)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBtnLayout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tfNoSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBtnLayout.setVerticalGroup(
            pnlBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblScId)
                    .addComponent(tfScId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(pnlBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTicketId)
                    .addComponent(tfTicketId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNoSeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addGap(18, 18, 18)
                .addComponent(btnRefresh)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate)
                .addGap(52, 52, 52)
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

    
    
    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
        new PurchaseTicketModify().setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private boolean getSelectedSeats(){
        String scId =tfScId.getText();
        originalSeatIds =new ArrayList();
        try {
            TicketAL ticketAl = new TicketAL();
            ArrayList<String> ticketIdList= ticketAl.getAllTicketIdsByScId(scId);
            
            SeatTicketAL stAl = new SeatTicketAL();
            int count=0;
            for(String ticketId:ticketIdList){
                ArrayList<SeatTicketModel> seatTicketList= stAl.getAllSeatIdByTicketId(ticketId);
                
                for(int i=0;i<btn.length;i++){
                    
                    for(SeatTicketModel tsM:seatTicketList){
                        if(btn[i].getActionCommand().equals(tsM.getSeatId())){
                            if(tsM.getStatus().equals("Available")){
                                btn[i].setEnabled(false);
                                
                                if(this.ticketId.equals(ticketId)){
                                    btn[i].setBackground(Color.BLUE);  
                                    count++;
                                    originalSeatIds.add(tsM.getSeatId());
                                    String tableValue[]={tsM.getSeatId(),tsM.getStatus()};
                                    defaultTabletable.addRow(tableValue);
                                }
                                else{
                                  btn[i].setBackground(Color.yellow);    
                                }
                            }
                        }
                    }
                }
            }
            tfNoSeats.setText(count+"");
            noSeat = count;
            
            if(count<=0){
                int i=JOptionPane.showConfirmDialog(this,"Ticket ID: "+ ticketId+ " had been cancelled.",
                        "Seat Ticket",JOptionPane.CLOSED_OPTION);   
            }


        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
        return true;
    }

    
    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        pnlShowSeat.removeAll();
        pnlShowSeat.updateUI();
        pnlShowSeat.revalidate();
        defaultTabletable.setRowCount(0);
        
        viewSeats();
        
    }//GEN-LAST:event_btnRefreshActionPerformed

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

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        if(defaultTabletable.getRowCount()>0){
            ArrayList<String> newSeatIds =new ArrayList();
            
            for(int i=0;i<defaultTabletable.getRowCount();i++){ 
                newSeatIds.add(defaultTabletable.getValueAt(i, 0).toString());
            } 
            
            
            SeatTicketAL stAl;
            try {
                stAl = new SeatTicketAL();
                boolean success =stAl.updateSeatTicketIdByTicketId(ticketId, newSeatIds, originalSeatIds);
                
                if(success){
                    PrintUpdatedTicket print =new PrintUpdatedTicket();

                    print.setPurchaseDate(new java.sql.Date(new Date().getTime()).toString());

                    Date today = new Date();
                    Calendar now = Calendar.getInstance();
                    int hours = now.get(Calendar.HOUR_OF_DAY);
                    int minutes = now.get(Calendar.MINUTE);
                    int second = now.get(Calendar.SECOND);
                    print.setPurchaseTime(hours + ":" + minutes + ":" + second);
                    print.setTicketId(tfTicketId.getText());
                    print.setScId(tfScId.getText());
                    print.setBusId(tfBusId.getText());
                    print.setBusType(lblBusType.getText());

                    String[] ids =new String[newSeatIds.size()];
                    for(int i=0;i<newSeatIds.size();i++){
                        ids[i] = newSeatIds.get(i);
                    }
                    Arrays.sort(ids);
                    print.setSeats(ids);

                    ScheduleAL scAl = new ScheduleAL();
                    ScheduleModel sc = scAl.getASchedule(tfScId.getText());
                    String price = sc.getPrice()+"";
                    print.setPrice(price+"");
                    print.setTotalSeats(tfNoSeats.getText());
                    print.setCusId(tfCusId.getText());

                    boolean s = print.printBill();

                    if(s){
                        JOptionPane.showMessageDialog(this, "Updated Receipt had been generated.");
                        this.dispose();
                        new PurchaseTicketModify().setVisible(true);
                    }
                }
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            
            
        }else{
            JOptionPane.showMessageDialog(this, "No Seats are selected");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed
    int clickNo;
    public void btnAction(java.awt.event.ActionEvent evt,JButton btn){
        String seatId =evt.getActionCommand();
        SeatModel seat =null;
        try {

            int noChosenSeat =tableSeats.getRowCount();
            
            if(noSeat!=noChosenSeat){
                SeatAL al = new SeatAL();
                seat = al.getASeatBySeatId(seatId);
                btn.setEnabled(false);
                btn.setBackground(Color.YELLOW);
                String tableValue[]={seat.getSeatId(),seat.getStatus()};
                defaultTabletable.addRow(tableValue);
            }else{
                JOptionPane.showMessageDialog(this, "Customer is not able to purchase seat in process");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBlue;
    private javax.swing.JLabel lblBusId;
    private javax.swing.JLabel lblBusType;
    private javax.swing.JLabel lblCusId;
    private javax.swing.JLabel lblDepartDate;
    private javax.swing.JLabel lblDepartTime;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblRed;
    private javax.swing.JLabel lblScId;
    private javax.swing.JLabel lblSeats;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTicketId;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblYellow;
    private javax.swing.JPanel pnlBlue;
    private javax.swing.JPanel pnlBtn;
    private javax.swing.JPanel pnlBusInfo;
    private javax.swing.JPanel pnlRed;
    private javax.swing.JPanel pnlScr;
    private javax.swing.JPanel pnlSeat;
    private javax.swing.JPanel pnlSelection;
    private javax.swing.JPanel pnlShowSeat;
    private javax.swing.JPanel pnlYellow;
    private javax.swing.JTable tableSeats;
    private javax.swing.JTextField tfBusId;
    private javax.swing.JTextField tfCusId;
    private javax.swing.JTextField tfDepartDate;
    private javax.swing.JTextField tfDepartTime;
    private javax.swing.JTextField tfDestination;
    private javax.swing.JTextField tfFrom;
    private javax.swing.JTextField tfNoSeats;
    private javax.swing.JTextField tfPrice;
    private javax.swing.JTextField tfScId;
    private javax.swing.JTextField tfStatus;
    private javax.swing.JTextField tfTicketId;
    private javax.swing.JTextField tfTotalSeats;
    // End of variables declaration//GEN-END:variables
}
