/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.SessionClass;
import java.awt.Color;
import config.dbConnect;
import config.passwordHasher;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import lores.LOGIN;
/**
 *
 * @author Admin
 */
public class adduser extends javax.swing.JFrame {

    /**
     * Creates new form updateuser
     */
    public adduser() {
        initComponents();
        
           see1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Toggle password visibility
                if (confirmpass.getEchoChar() == '\0') {
                    // Hide the password
                    confirmpass.setEchoChar('•'); // Default echo character for passwords
                    see1.setText("Show Password");
                } else {
                    // Show the password
                    confirmpass.setEchoChar('\0'); // Set echo char to null to show the password
                    see1.setText("Hide Password");
                }
            }
        });
        
        
           see.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Toggle password visibility
                if (newpass.getEchoChar() == '\0') {
                    // Hide the password
                    newpass.setEchoChar('•'); // Default echo character for passwords
                    see.setText("Show Password");
                } else {
                    // Show the password
                    newpass.setEchoChar('\0'); // Set echo char to null to show the password
                    see.setText("Hide Password");
                }
            }
        });
    }
     private void logProductAdditionAction(int userId, String Username) {
    String sql = "INSERT INTO logs (user_id, act, log_date) VALUES (?, ?, NOW())";

    dbConnect db = new dbConnect();
    try (Connection conn = db.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, userId);
        pstmt.setString(2, "User Added: " + Username);
        pstmt.executeUpdate();

    } catch (SQLException e) {
        System.err.println("Failed to log product addition action: " + e.getMessage());
    }
}
private int getCurrentUserId() {
  
    config.SessionClass ses = config.SessionClass.getInstance();
    return ses.getU_id();
}
     public static String mail, usname;
    public boolean dupcheck(){
        
        dbConnect db = new dbConnect();
         
        try{
        String que = "SELECT * FROM user WHERE u_username='"+usernamere.getText()+"' OR u_email='"+email.getText()+"'";    
            ResultSet resultset = db.getData(que);
            if(resultset.next()){
                mail = resultset.getString("u_email");
            
                if(mail.equals(email.getText())){
                    
                    JOptionPane.showMessageDialog(null, "The email already existed",
                "Error Registration", JOptionPane.ERROR_MESSAGE);
                    email.setText("");
                }
                usname = resultset.getString("u_username");
                 if(usname.equals(usernamere.getText())){
                    
                    JOptionPane.showMessageDialog(null, "The username already existed",
                "Error Registration", JOptionPane.ERROR_MESSAGE);
                    usernamere.setText("");
                }
                System.out.println(""+usname);
             return true;   
            }
            
            else {
                
                return false;
            }
        }catch(SQLException ex){
            System.out.println(""+ex);
            return false;
        }
    }
    
    public boolean updatecheck(){
        
        dbConnect db = new dbConnect();
         
        try{
        String que = "SELECT * FROM user WHERE (u_username='"+usernamere.getText()+"' OR u_email='"+email.getText()+"') AND u_id != '"+uid.getText()+"' ";    
            ResultSet resultset = db.getData(que);
            if(resultset.next()){
                mail = resultset.getString("u_email");
            
                if(mail.equals(email.getText())){
                    
                    JOptionPane.showMessageDialog(null, "The email already existed",
                "Error Registration", JOptionPane.ERROR_MESSAGE);
                    email.setText("");
                }
                usname = resultset.getString("u_username");
                 if(usname.equals(usernamere.getText())){
                    
                    JOptionPane.showMessageDialog(null, "The username already existed",
                "Error Registration", JOptionPane.ERROR_MESSAGE);
                    usernamere.setText("");
                }
                System.out.println(""+usname);
             return true;   
            }
            
            else {
                
                return false;
            }
        }catch(SQLException ex){
            System.out.println(""+ex);
            return false;
        }
    }
    
    
    
Color logcolor = new Color(63,195,128);
    Color excolor = new Color(255,255,255);
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
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1026 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1027 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel260 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        lname = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        usernamere = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        jLabel270 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ty = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        jLabel1039 = new javax.swing.JLabel();
        uid = new javax.swing.JTextField();
        jLabel271 = new javax.swing.JLabel();
        jLabel1040 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        confirmpass = new javax.swing.JPasswordField();
        newpass = new javax.swing.JPasswordField();
        jLabel76 = new javax.swing.JLabel();
        see = new javax.swing.JLabel();
        see1 = new javax.swing.JLabel();
        add = new javax.swing.JPanel();
        jPanel1030 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(0, 102, 102));
        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("ADD USER");
        jLabel6.setToolTipText("");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 240, 70));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/addthis.png"))); // NOI18N
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 70, 70));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 700, 70));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 820, 110));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1026.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1026.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel1026.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Edit Profile");
        jPanel1026.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 170, 20));

        jPanel1027.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1027.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel1027.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Edit Profile");
        jPanel1027.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 170, 20));

        jPanel1026.add(jPanel1027, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 170, 40));

        jPanel2.add(jPanel1026, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 170, 40));

        jPanel260.setBackground(new java.awt.Color(255, 255, 255));
        jPanel260.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel260.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/newuserprofile.png"))); // NOI18N
        jPanel260.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 190));

        jPanel2.add(jPanel260, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 170, 210));

        email.setBackground(new java.awt.Color(204, 204, 204));
        email.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 200, 30));

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(0, 102, 102));
        jLabel72.setText("Email:");
        jPanel2.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, -1, -1));

        lname.setBackground(new java.awt.Color(204, 204, 204));
        lname.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });
        jPanel2.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 200, 30));

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(0, 102, 102));
        jLabel71.setText("Last Name:");
        jPanel2.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, -1, -1));

        usernamere.setBackground(new java.awt.Color(204, 204, 204));
        usernamere.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        usernamere.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usernamere.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(usernamere, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 200, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Username:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("First Name:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, -1, -1));

        fname.setBackground(new java.awt.Color(204, 204, 204));
        fname.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        fname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 200, 30));

        contact.setBackground(new java.awt.Color(204, 204, 204));
        contact.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        contact.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        contact.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactActionPerformed(evt);
            }
        });
        jPanel2.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 200, 30));

        jLabel270.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel270.setForeground(new java.awt.Color(0, 102, 102));
        jLabel270.setText("Contact");
        jPanel2.add(jLabel270, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("User Type:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, 80, 20));

        ty.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select a Type", "Admin", "Customer", "Employee", " " }));
        ty.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tyActionPerformed(evt);
            }
        });
        jPanel2.add(ty, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, 210, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("User Status");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 190, 90, 20));

        status.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select a Type", "Active", "Pending", " ", " " }));
        status.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        jPanel2.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, 210, 30));

        jLabel1039.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/backwardset.png"))); // NOI18N
        jLabel1039.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1039MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1039, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 40, 40));

        uid.setEditable(false);
        uid.setBackground(new java.awt.Color(204, 204, 204));
        uid.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        uid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        uid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        uid.setEnabled(false);
        uid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uidActionPerformed(evt);
            }
        });
        jPanel2.add(uid, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, 210, 30));

        jLabel271.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel271.setForeground(new java.awt.Color(0, 102, 102));
        jLabel271.setText("ID");
        jPanel2.add(jLabel271, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, -1, -1));

        jLabel1040.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/undostan.png"))); // NOI18N
        jLabel1040.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1040MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1040, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 390, 30, 40));

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(0, 102, 102));
        jLabel75.setText("Confirm Password:");
        jPanel2.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 320, -1, -1));
        jPanel2.add(confirmpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 340, 210, 30));
        jPanel2.add(newpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 210, 30));

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(0, 102, 102));
        jLabel76.setText("Enter Password:");
        jPanel2.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, -1, -1));

        see.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        see.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/eyegamay.png"))); // NOI18N
        jPanel2.add(see, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 280, 40, 30));

        see1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        see1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/eyegamay.png"))); // NOI18N
        jPanel2.add(see1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 340, 40, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 820, 430));

        add.setBackground(new java.awt.Color(0, 102, 102));
        add.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });
        add.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1030.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1030.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1030MouseClicked(evt);
            }
        });
        jPanel1030.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Add");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel1030.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 170, 20));

        add.add(jPanel1030, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 560, 170, 60));

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Add");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        add.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 170, 20));

        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 560, 170, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tyActionPerformed

    private void jLabel1039MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1039MouseClicked
        // TODO add your handling code here:
        
      admindash ad = new admindash();
      ad.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_jLabel1039MouseClicked

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        // TODO add your handling code here:

     dbConnect db = new dbConnect();
try {
    // Validate all fields
    if (usernamere.getText().isEmpty() || fname.getText().isEmpty() || lname.getText().isEmpty() ||
        email.getText().isEmpty() || contact.getText().isEmpty() || newpass.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validate user type selection
    String selectedType = (String) ty.getSelectedItem();
    if (selectedType == null || selectedType.equals("Please Select a Type")) {
        JOptionPane.showMessageDialog(null, "Please select a valid user type (Admin, Customer, or Employee).",
            "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validate status selection
    String selectType = (String) status.getSelectedItem();
    if (selectType == null || selectType.equals("Please Select a Type")) {
        JOptionPane.showMessageDialog(null, "Please select a valid status type (Active or Pending).",
            "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validate email format
    if (!email.getText().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
        JOptionPane.showMessageDialog(null, "Please enter a valid email address (e.g., example@gmail.com).",
            "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validate password length
    if (newpass.getText().length() < 8) {
        JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long.",
            "Error", JOptionPane.ERROR_MESSAGE);
        newpass.setText("");
        return;
    }

    // Validate contact number
    if (!contact.getText().matches("\\d+")) {
        JOptionPane.showMessageDialog(null, "Contact number must contain only digits.",
            "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (contact.getText().length() < 11 || contact.getText().length() > 15) {
        JOptionPane.showMessageDialog(null, "Contact number must be between 11 and 15 digits.",
            "Error", JOptionPane.ERROR_MESSAGE);
        contact.setText("");
        return;
    }

    // Check for duplicate entries (assuming dupcheck() is defined elsewhere)
    if (dupcheck()) {
        System.out.println("Duplicated Exist!");
        return;
    }

    // Hash the new password
    String hashedPassword = passwordHasher.hashPassword(newpass.getText());

    // Insert new user into the database
    String query = "INSERT INTO user (u_username, u_fname, u_lname, u_email, u_contact, u_type, u_password, u_stat) " +
                   "VALUES ('" + usernamere.getText() + "', '" + fname.getText() + "', '" + lname.getText() + "', " +
                   "'" + email.getText() + "', '" + contact.getText() + "', '" + selectedType + "', '" + hashedPassword + "', '" + selectType + "')";

    if (db.insertData(query) == 1) {
        JOptionPane.showMessageDialog(null, "User Successfully Added");
   // Log the product addition action
            int currentUserId = getCurrentUserId(); // Get the user ID
            logProductAdditionAction(currentUserId, usernamere.getText());
        // Redirect based on user type or status
        if ("Admin".equals(selectedType) || "Customer".equals(selectedType) || "Employee".equals(selectedType) ||
            "Active".equals(selectType) || "Pending".equals(selectType)) {
            admin.admindash adminDash = new admin.admindash();
            adminDash.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Error during registration. Please check your input or try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        this.dispose(); // Close the current window
    } else {
        JOptionPane.showMessageDialog(null, "Error during registration. Please check your input or try again.", "Error", JOptionPane.ERROR_MESSAGE);
    }
} catch (NoSuchAlgorithmException ex) {
    System.out.println("Error: " + ex);
    JOptionPane.showMessageDialog(null, "An error occurred. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_addMouseClicked

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jPanel1030MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1030MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1030MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    private void uidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uidActionPerformed

    private void jLabel1040MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1040MouseClicked
        // TODO add your handling code here:
        
         usernamere.setText(null);
     fname.setText(null);
      lname.setText(null);
      email.setText(null);
     contact.setText(null);
      
    
    }//GEN-LAST:event_jLabel1040MouseClicked

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
            java.util.logging.Logger.getLogger(adduser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adduser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adduser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adduser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adduser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel add;
    private javax.swing.JPasswordField confirmpass;
    public javax.swing.JTextField contact;
    public javax.swing.JTextField email;
    public javax.swing.JTextField fname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel1039;
    private javax.swing.JLabel jLabel1040;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel270;
    private javax.swing.JLabel jLabel271;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel1026;
    private javax.swing.JPanel jPanel1027;
    private javax.swing.JPanel jPanel1030;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel260;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    public javax.swing.JTextField lname;
    private javax.swing.JPasswordField newpass;
    private javax.swing.JLabel see;
    private javax.swing.JLabel see1;
    public javax.swing.JComboBox<String> status;
    public javax.swing.JComboBox<String> ty;
    public javax.swing.JTextField uid;
    public javax.swing.JTextField usernamere;
    // End of variables declaration//GEN-END:variables
}
