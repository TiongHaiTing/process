package UI;


import AppLogic.StaffAL;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class StaffRegisterForm extends javax.swing.JFrame {
    
    public StaffRegisterForm() {
        initComponents();
        setTitle("Staff Register"); 

        registerBtn.setIcon(new ImageIcon(getClass().getResource("../icons/add.png")));
        refreshBtn.setIcon(new ImageIcon(getClass().getResource("../icons/refresh.png")));
        cancelBtn.setIcon(new ImageIcon(getClass().getResource("../icons/cancel24.png")));
        
        ComBoxPosition.addItem("");
        ComBoxPosition.addItem("Manager");
        ComBoxPosition.addItem("Operation Staff");
        
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(RadioMaried);
        bg.add(RadioSingle);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        screenPanel = new javax.swing.JPanel();
        titlePanel = new javax.swing.JPanel();
        bannerPnl = new javax.swing.JLabel();
        imgPanel = new javax.swing.JPanel();
        photoPnl = new javax.swing.JLabel();
        detailsPnl1 = new javax.swing.JPanel();
        staffIdLbl = new javax.swing.JLabel();
        firstNameLbl = new javax.swing.JLabel();
        lastNameLbl = new javax.swing.JLabel();
        genderLbl = new javax.swing.JLabel();
        dobLbl = new javax.swing.JLabel();
        generateIdBtn = new javax.swing.JButton();
        tfStaffId = new javax.swing.JTextField();
        tfFirstName = new javax.swing.JTextField();
        tfLastName = new javax.swing.JTextField();
        ComBoxGender = new javax.swing.JComboBox();
        ChooserDob = new com.toedter.calendar.JDateChooser();
        statusLbl = new javax.swing.JLabel();
        RadioMaried = new javax.swing.JRadioButton();
        RadioSingle = new javax.swing.JRadioButton();
        detailsPnl2 = new javax.swing.JPanel();
        addrLbl = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        positionLbl = new javax.swing.JLabel();
        slryLbl = new javax.swing.JLabel();
        tfAddress = new javax.swing.JTextField();
        tfSalary = new javax.swing.JTextField();
        ComBoxPosition = new javax.swing.JComboBox();
        tfEmail = new javax.swing.JTextField();
        tfPhone = new javax.swing.JTextField();
        phoneLbl = new javax.swing.JLabel();
        passwordPnl = new javax.swing.JPanel();
        passLbl = new javax.swing.JLabel();
        rePassLbl = new javax.swing.JLabel();
        tfPassword = new javax.swing.JPasswordField();
        tfRePass = new javax.swing.JPasswordField();
        registerBtn = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        pnlPass = new javax.swing.JPanel();
        lblRcQ = new javax.swing.JLabel();
        tfRecoveryQues = new javax.swing.JTextField();
        lblRcA = new javax.swing.JLabel();
        tfRecoveryAns = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        screenPanel.setBackground(new java.awt.Color(0, 204, 0));
        screenPanel.setPreferredSize(new java.awt.Dimension(915, 510));

        titlePanel.setBackground(new java.awt.Color(204, 204, 204));

        bannerPnl.setBackground(new java.awt.Color(255, 51, 51));
        bannerPnl.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        bannerPnl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bannerPnl.setText("Staff Registeration Form");

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bannerPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bannerPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        imgPanel.setBackground(new java.awt.Color(0, 204, 0));

        photoPnl.setBackground(new java.awt.Color(255, 255, 255));
        photoPnl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/l - Copy.png"))); // NOI18N
        photoPnl.setToolTipText("");
        photoPnl.setPreferredSize(new java.awt.Dimension(32, 32));

        javax.swing.GroupLayout imgPanelLayout = new javax.swing.GroupLayout(imgPanel);
        imgPanel.setLayout(imgPanelLayout);
        imgPanelLayout.setHorizontalGroup(
            imgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imgPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(photoPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        imgPanelLayout.setVerticalGroup(
            imgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imgPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(photoPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        detailsPnl1.setBackground(new java.awt.Color(102, 255, 102));
        detailsPnl1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2), "Personal Details:", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 14), new java.awt.Color(255, 0, 0))); // NOI18N

        staffIdLbl.setText("Staff ID");

        firstNameLbl.setText("First Name");

        lastNameLbl.setText("Last Name");

        genderLbl.setText("Gender");

        dobLbl.setText("DOB ");

        generateIdBtn.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        generateIdBtn.setForeground(new java.awt.Color(153, 0, 153));
        generateIdBtn.setText("Generate ID");
        generateIdBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateIdBtnActionPerformed(evt);
            }
        });

        tfStaffId.setEditable(false);

        ComBoxGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "male", "female" }));

        statusLbl.setText("Marial Status");

        RadioMaried.setBackground(new java.awt.Color(102, 255, 102));
        RadioMaried.setText("Married");

        RadioSingle.setBackground(new java.awt.Color(102, 255, 102));
        RadioSingle.setText("Single");

        javax.swing.GroupLayout detailsPnl1Layout = new javax.swing.GroupLayout(detailsPnl1);
        detailsPnl1.setLayout(detailsPnl1Layout);
        detailsPnl1Layout.setHorizontalGroup(
            detailsPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailsPnl1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(detailsPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(detailsPnl1Layout.createSequentialGroup()
                        .addComponent(statusLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RadioMaried)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RadioSingle)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(detailsPnl1Layout.createSequentialGroup()
                        .addGroup(detailsPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(detailsPnl1Layout.createSequentialGroup()
                                .addComponent(dobLbl)
                                .addGap(32, 32, 32)
                                .addComponent(ChooserDob, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detailsPnl1Layout.createSequentialGroup()
                                .addGroup(detailsPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(detailsPnl1Layout.createSequentialGroup()
                                        .addGroup(detailsPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lastNameLbl)
                                            .addComponent(genderLbl))
                                        .addGap(5, 5, 5)
                                        .addGroup(detailsPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ComBoxGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(tfLastName)))
                                    .addGroup(detailsPnl1Layout.createSequentialGroup()
                                        .addGroup(detailsPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(staffIdLbl)
                                            .addComponent(firstNameLbl))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(detailsPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfStaffId)
                                            .addComponent(tfFirstName))))
                                .addGap(18, 18, 18)
                                .addComponent(generateIdBtn)))
                        .addContainerGap())))
        );
        detailsPnl1Layout.setVerticalGroup(
            detailsPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailsPnl1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(detailsPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(generateIdBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(detailsPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(staffIdLbl)
                        .addComponent(tfStaffId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(detailsPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLbl)
                    .addComponent(tfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(detailsPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLbl)
                    .addComponent(tfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(detailsPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genderLbl)
                    .addComponent(ComBoxGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(detailsPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dobLbl)
                    .addComponent(ChooserDob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(detailsPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusLbl)
                    .addComponent(RadioMaried)
                    .addComponent(RadioSingle))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        detailsPnl2.setBackground(new java.awt.Color(102, 255, 102));
        detailsPnl2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2), "Personal Details:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 14), new java.awt.Color(255, 0, 0))); // NOI18N

        addrLbl.setText("Address");

        lblEmail.setText("Email");

        positionLbl.setText("Position");

        slryLbl.setText("Basic Salary");

        phoneLbl.setText("Phone No");

        javax.swing.GroupLayout detailsPnl2Layout = new javax.swing.GroupLayout(detailsPnl2);
        detailsPnl2.setLayout(detailsPnl2Layout);
        detailsPnl2Layout.setHorizontalGroup(
            detailsPnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailsPnl2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(detailsPnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phoneLbl)
                    .addGroup(detailsPnl2Layout.createSequentialGroup()
                        .addGroup(detailsPnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(positionLbl)
                            .addComponent(addrLbl)
                            .addComponent(lblEmail)
                            .addComponent(slryLbl))
                        .addGap(20, 20, 20)
                        .addGroup(detailsPnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfPhone)
                            .addComponent(tfAddress)
                            .addComponent(tfEmail)
                            .addComponent(ComBoxPosition, 0, 121, Short.MAX_VALUE)
                            .addComponent(tfSalary))))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        detailsPnl2Layout.setVerticalGroup(
            detailsPnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailsPnl2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(detailsPnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneLbl)
                    .addComponent(tfPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(detailsPnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addrLbl)
                    .addComponent(tfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(detailsPnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(detailsPnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(positionLbl)
                    .addComponent(ComBoxPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(detailsPnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(slryLbl)
                    .addComponent(tfSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69))
        );

        passwordPnl.setBackground(new java.awt.Color(102, 255, 102));
        passwordPnl.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2), "Password Registration:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N

        passLbl.setText("Password :");

        rePassLbl.setText("Re-enter Pasword :");

        javax.swing.GroupLayout passwordPnlLayout = new javax.swing.GroupLayout(passwordPnl);
        passwordPnl.setLayout(passwordPnlLayout);
        passwordPnlLayout.setHorizontalGroup(
            passwordPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(passLbl)
                .addGap(18, 18, 18)
                .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(rePassLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfRePass, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        passwordPnlLayout.setVerticalGroup(
            passwordPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(passwordPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passLbl)
                    .addComponent(rePassLbl)
                    .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfRePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        registerBtn.setForeground(new java.awt.Color(204, 0, 204));
        registerBtn.setText("Register");
        registerBtn.setPreferredSize(new java.awt.Dimension(100, 30));
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        refreshBtn.setForeground(new java.awt.Color(204, 0, 204));
        refreshBtn.setText("Refresh");
        refreshBtn.setPreferredSize(new java.awt.Dimension(100, 30));
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        cancelBtn.setForeground(new java.awt.Color(204, 0, 204));
        cancelBtn.setText("Cancel");
        cancelBtn.setPreferredSize(new java.awt.Dimension(100, 30));
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        pnlPass.setBackground(new java.awt.Color(102, 255, 102));

        lblRcQ.setText("Password Recovery Question: ");

        lblRcA.setText("Password Recovery Answer:");

        javax.swing.GroupLayout pnlPassLayout = new javax.swing.GroupLayout(pnlPass);
        pnlPass.setLayout(pnlPassLayout);
        pnlPassLayout.setHorizontalGroup(
            pnlPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPassLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfRecoveryQues)
                    .addGroup(pnlPassLayout.createSequentialGroup()
                        .addGroup(pnlPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRcQ)
                            .addComponent(lblRcA))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tfRecoveryAns))
                .addContainerGap())
        );
        pnlPassLayout.setVerticalGroup(
            pnlPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPassLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRcQ)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfRecoveryQues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRcA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfRecoveryAns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout screenPanelLayout = new javax.swing.GroupLayout(screenPanel);
        screenPanel.setLayout(screenPanelLayout);
        screenPanelLayout.setHorizontalGroup(
            screenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(screenPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(screenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(screenPanelLayout.createSequentialGroup()
                        .addGroup(screenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(screenPanelLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(screenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(screenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(screenPanelLayout.createSequentialGroup()
                                .addComponent(detailsPnl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(detailsPnl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(passwordPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        screenPanelLayout.setVerticalGroup(
            screenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(screenPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(screenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(detailsPnl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(detailsPnl2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(screenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(screenPanelLayout.createSequentialGroup()
                        .addComponent(passwordPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(screenPanelLayout.createSequentialGroup()
                        .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(refreshBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                        .addGap(133, 133, 133))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(screenPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(screenPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed

        try {
            StaffAL logic = new StaffAL();
            
            try {
                String staff_id = tfStaffId.getText();
                String f_name = tfFirstName.getText();
                String l_name = tfLastName.getText();
                String gender = (String)ComBoxGender.getSelectedItem();
                Date dob = ChooserDob.getDate();//date
                String phoneNo = tfPhone.getText();
                String addr = tfAddress.getText();
                String email = tfEmail.getText();
                String position = (String)ComBoxPosition.getSelectedItem();
                String salary = tfSalary.getText();
                char[] pass = tfPassword.getPassword();
                String recoveryQues = tfRecoveryQues.getText();
                String recoveryAns = tfRecoveryAns.getText();
                
                logic.passwordCheck(pass,tfRePass.getPassword());
                String password="";
                for(char p:pass)
                    password += p;
                
                String marialStatus="";
                if(RadioMaried.isSelected())
                    marialStatus += RadioMaried.getText();
                else if(RadioSingle.isSelected())
                    marialStatus += RadioSingle.getText();
                
                String[] staff = new String[]{staff_id,f_name,l_name,gender
                        ,marialStatus,phoneNo,addr,email,position,salary,
                        password,recoveryQues,recoveryAns};
                
                logic.addStaff(staff, dob);
                
            } catch (Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,ex.getMessage(),"Connection Error"
                    , JOptionPane.ERROR_MESSAGE);
            
        }
    }//GEN-LAST:event_registerBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        clearText();
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void generateIdBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateIdBtnActionPerformed
        try {
            StaffAL al = new StaffAL();
            
            tfStaffId.setText(al.generateId());//show id  
        } catch (Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage()
                    , "Staff Id error",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_generateIdBtnActionPerformed
    
    public void clearText(){
        tfStaffId.setText("");
        tfFirstName.setText("");
        tfLastName.setText("");
        ComBoxGender.setSelectedItem("");
        tfEmail.setText("");
        tfPhone.setText("");
        tfAddress.setText("");
        tfSalary.setText("");
        tfPassword.setText("");
        tfRePass.setText("");
        ChooserDob.setDate(null);
        ComBoxPosition.setSelectedItem("");
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser ChooserDob;
    private javax.swing.JComboBox ComBoxGender;
    private javax.swing.JComboBox ComBoxPosition;
    private javax.swing.JRadioButton RadioMaried;
    private javax.swing.JRadioButton RadioSingle;
    private javax.swing.JLabel addrLbl;
    private javax.swing.JLabel bannerPnl;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JPanel detailsPnl1;
    private javax.swing.JPanel detailsPnl2;
    private javax.swing.JLabel dobLbl;
    private javax.swing.JLabel firstNameLbl;
    private javax.swing.JLabel genderLbl;
    private javax.swing.JButton generateIdBtn;
    private javax.swing.JPanel imgPanel;
    private javax.swing.JLabel lastNameLbl;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblRcA;
    private javax.swing.JLabel lblRcQ;
    private javax.swing.JLabel passLbl;
    private javax.swing.JPanel passwordPnl;
    private javax.swing.JLabel phoneLbl;
    private javax.swing.JLabel photoPnl;
    private javax.swing.JPanel pnlPass;
    private javax.swing.JLabel positionLbl;
    private javax.swing.JLabel rePassLbl;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton registerBtn;
    private javax.swing.JPanel screenPanel;
    private javax.swing.JLabel slryLbl;
    private javax.swing.JLabel staffIdLbl;
    private javax.swing.JLabel statusLbl;
    private javax.swing.JTextField tfAddress;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfFirstName;
    private javax.swing.JTextField tfLastName;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfPhone;
    private javax.swing.JPasswordField tfRePass;
    private javax.swing.JTextField tfRecoveryAns;
    private javax.swing.JTextField tfRecoveryQues;
    private javax.swing.JTextField tfSalary;
    private javax.swing.JTextField tfStaffId;
    private javax.swing.JPanel titlePanel;
    // End of variables declaration//GEN-END:variables


}
