/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package USER;

import config.SessionClass;
import javax.swing.JOptionPane;
import lores.LOGIN;

/**
 *
 * @author Admin
 */
public class employeeinfo extends javax.swing.JFrame {

    /**
     * Creates new form employeeinfo
     */
    public employeeinfo() {
        initComponents();
    }
    
    private void initComponentss() {
        // Initialize components (auto-generated by NetBeans)
        // Ensure that updatePanel is properly initialized and linked to the MouseListener
        updatePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatePanelMouseClicked(evt);
            }
        });
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        tologin = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1026 = new javax.swing.JPanel();
        jPanel1027 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        passwordshow = new javax.swing.JLabel();
        updatePanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        jPanel1028 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel1029 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1030 = new javax.swing.JPanel();
        jPanel1031 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        fnameshow = new javax.swing.JLabel();
        jPanel1032 = new javax.swing.JPanel();
        jPanel1033 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        lnameshow = new javax.swing.JLabel();
        jPanel1034 = new javax.swing.JPanel();
        jPanel1035 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        idshow = new javax.swing.JLabel();
        jPanel1036 = new javax.swing.JPanel();
        jPanel1037 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        emailshow = new javax.swing.JLabel();
        jPanel1038 = new javax.swing.JPanel();
        jPanel1039 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        contactshow = new javax.swing.JLabel();
        jPanel1040 = new javax.swing.JPanel();
        jPanel1041 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        usernameshow = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tologin.setBackground(new java.awt.Color(204, 204, 204));
        tologin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tologinMouseClicked(evt);
            }
        });
        tologin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setBackground(new java.awt.Color(204, 204, 204));
        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Already have an account? Click Here");
        tologin.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 20));

        jPanel3.add(tologin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, -1, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("EMPLOYEE INFORMATION");
        jLabel9.setToolTipText("");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 520, 30));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/staffstandard.png"))); // NOI18N
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 780, 90));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/newuserprofile.png"))); // NOI18N
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 160));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 170, 170));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Password");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 210, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("First Name");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Last Name");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Contact");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, -1, -1));

        jPanel1026.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1026.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1026.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1027.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1027.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel1027.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Edit Profile");
        jPanel1027.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 20));

        jPanel1026.add(jPanel1027, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 150, 40));

        passwordshow.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        passwordshow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passwordshow.setEnabled(false);
        jPanel1026.add(passwordshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 130, 40));

        jPanel2.add(jPanel1026, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 230, 170, 40));

        updatePanel.setBackground(new java.awt.Color(0, 102, 102));
        updatePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatePanelMouseClicked(evt);
            }
        });
        updatePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Update Information");
        updatePanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 170, -1));

        jPanel2.add(updatePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 350, 210, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 102));
        jLabel15.setText("Email");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, -1));

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/backwardset.png"))); // NOI18N
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 50, 40));

        jLabel18.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 102));
        jLabel18.setText("ID");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, -1, -1));

        jPanel1028.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1028.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel1028.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Edit Profile");
        jPanel1028.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 20));

        jPanel1029.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1029.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel1029.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 102));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Edit Profile");
        jPanel1029.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 20));

        jPanel1028.add(jPanel1029, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 150, 40));

        jPanel2.add(jPanel1028, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 170, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Username");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, -1, -1));

        jPanel1030.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1030.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1030.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1031.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1031.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel1031.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 102));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Edit Profile");
        jPanel1031.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 20));

        jPanel1030.add(jPanel1031, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 150, 40));

        fnameshow.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        fnameshow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fnameshow.setEnabled(false);
        jPanel1030.add(fnameshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 130, 40));

        jPanel2.add(jPanel1030, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 170, 40));

        jPanel1032.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1032.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1032.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1033.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1033.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel1033.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 102));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Edit Profile");
        jPanel1033.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 20));

        jPanel1032.add(jPanel1033, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 150, 40));

        lnameshow.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        lnameshow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lnameshow.setEnabled(false);
        jPanel1032.add(lnameshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 130, 40));

        jPanel2.add(jPanel1032, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 170, 40));

        jPanel1034.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1034.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1034.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1035.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1035.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel1035.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 102, 102));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Edit Profile");
        jPanel1035.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 20));

        jPanel1034.add(jPanel1035, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 150, 40));

        idshow.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        idshow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        idshow.setEnabled(false);
        jPanel1034.add(idshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 50, 40));

        jPanel2.add(jPanel1034, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 90, 40));

        jPanel1036.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1036.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1036.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1037.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1037.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel1037.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 102, 102));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Edit Profile");
        jPanel1037.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 20));

        jPanel1036.add(jPanel1037, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 150, 40));

        emailshow.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        emailshow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emailshow.setEnabled(false);
        jPanel1036.add(emailshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 130, 40));

        jPanel2.add(jPanel1036, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 170, 40));

        jPanel1038.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1038.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1038.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1039.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1039.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel1039.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 102, 102));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Edit Profile");
        jPanel1039.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 20));

        jPanel1038.add(jPanel1039, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 150, 40));

        contactshow.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        contactshow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contactshow.setEnabled(false);
        jPanel1038.add(contactshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 130, 40));

        jPanel2.add(jPanel1038, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, 170, 40));

        jPanel1040.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1040.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1040.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1041.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1041.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel1041.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 102, 102));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Edit Profile");
        jPanel1041.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 20));

        jPanel1040.add(jPanel1041, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 150, 40));

        usernameshow.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        usernameshow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameshow.setEnabled(false);
        jPanel1040.add(usernameshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 130, 40));

        jPanel2.add(jPanel1040, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 170, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 780, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tologinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tologinMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tologinMouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
     employdash em = new employdash();
     em.setVisible(true);
     this.dispose();
    }//GEN-LAST:event_jLabel20MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        
        
           SessionClass ses = SessionClass.getInstance();
          
          if(ses.getU_id() == 0 ){
              JOptionPane.showMessageDialog(null,"No account, login first!");
              LOGIN log = new LOGIN();
              log.setVisible(true);
              this.dispose();
              
          }
          
          else{
              usernameshow.setText(""+ses.getUsername());
              fnameshow.setText(""+ses.getFname());
              lnameshow.setText(""+ses.getLname());
              contactshow.setText(""+ses.getContact());
              emailshow.setText(""+ses.getEmail());
              idshow.setText(""+ses.getU_id());
            passwordshow.setText(""+ses.getPass());
              
              
//       userid.setText(""+ses.getUsername());
//       userid.setText(""+ses.getU_id());
//       
          }  
                                        

        
    }//GEN-LAST:event_formWindowActivated

    private void updatePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatePanelMouseClicked
        // TODO add your handling code here:
           int id = Integer.parseInt(idshow.getText()); // Get the ID from the idshow label
    String email = emailshow.getText();
    String contact = contactshow.getText();
    String password = passwordshow.getText();
        

        // Open the updateinfor form and pass the information
        updateinfor updateForm = new updateinfor( email, contact, password);
        updateForm.setVisible(true);
        this.dispose();
       
        
    }//GEN-LAST:event_updatePanelMouseClicked

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
            java.util.logging.Logger.getLogger(employeeinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(employeeinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(employeeinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(employeeinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new employeeinfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel contactshow;
    private javax.swing.JLabel emailshow;
    private javax.swing.JLabel fnameshow;
    private javax.swing.JLabel idshow;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel1026;
    private javax.swing.JPanel jPanel1027;
    private javax.swing.JPanel jPanel1028;
    private javax.swing.JPanel jPanel1029;
    private javax.swing.JPanel jPanel1030;
    private javax.swing.JPanel jPanel1031;
    private javax.swing.JPanel jPanel1032;
    private javax.swing.JPanel jPanel1033;
    private javax.swing.JPanel jPanel1034;
    private javax.swing.JPanel jPanel1035;
    private javax.swing.JPanel jPanel1036;
    private javax.swing.JPanel jPanel1037;
    private javax.swing.JPanel jPanel1038;
    private javax.swing.JPanel jPanel1039;
    private javax.swing.JPanel jPanel1040;
    private javax.swing.JPanel jPanel1041;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lnameshow;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel passwordshow;
    private javax.swing.JPanel tologin;
    private javax.swing.JPanel updatePanel;
    private javax.swing.JLabel usernameshow;
    // End of variables declaration//GEN-END:variables
}
