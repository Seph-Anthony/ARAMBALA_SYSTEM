/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import static admin.adduser.mail;
import static admin.adduser.usname;
import config.SessionClass;
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
public class updateuser extends javax.swing.JFrame {

    /**
     * Creates new form updateuser
     */
    public updateuser() {
        initComponents();
        
        
          seepass3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Toggle password visibility
                if (confirmpass.getEchoChar() == '\0') {
                    // Hide the password
                    confirmpass.setEchoChar('•'); // Default echo character for passwords
                    seepass3.setText("Show Password");
                } else {
                    // Show the password
                    confirmpass.setEchoChar('\0'); // Set echo char to null to show the password
                    seepass3.setText("Hide Password");
                }
            }
        });
        
          seepass2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Toggle password visibility
                if (newpass.getEchoChar() == '\0') {
                    // Hide the password
                    newpass.setEchoChar('•'); // Default echo character for passwords
                    seepass2.setText("Show Password");
                } else {
                    // Show the password
                    newpass.setEchoChar('\0'); // Set echo char to null to show the password
                    seepass2.setText("Hide Password");
                }
            }
        });
        
        
         seepass1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Toggle password visibility
                if (oldpass.getEchoChar() == '\0') {
                    // Hide the password
                    oldpass.setEchoChar('•'); // Default echo character for passwords
                    seepass1.setText("Show Password");
                } else {
                    // Show the password
                    oldpass.setEchoChar('\0'); // Set echo char to null to show the password
                    seepass1.setText("Hide Password");
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
        pstmt.setString(2, "User Updated: " + Username);
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

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
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
        jLabel74 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ty = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        uid = new javax.swing.JTextField();
        jLabel271 = new javax.swing.JLabel();
        jLabel1040 = new javax.swing.JLabel();
        oldpass = new javax.swing.JPasswordField();
        seepass3 = new javax.swing.JLabel();
        confirmpass = new javax.swing.JPasswordField();
        jLabel75 = new javax.swing.JLabel();
        newpass = new javax.swing.JPasswordField();
        jLabel76 = new javax.swing.JLabel();
        seepass1 = new javax.swing.JLabel();
        seepass2 = new javax.swing.JLabel();
        update = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1039 = new javax.swing.JLabel();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

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
        jLabel6.setText("UPDATE USER");
        jLabel6.setToolTipText("");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 300, 70));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/editthis.png"))); // NOI18N
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 80, 70));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 700, 70));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 830, 110));

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
        email.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel2.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 200, 30));

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(0, 102, 102));
        jLabel72.setText("Email:");
        jPanel2.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, -1, -1));

        lname.setBackground(new java.awt.Color(204, 204, 204));
        lname.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lname.setBorder(new javax.swing.border.MatteBorder(null));
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
        usernamere.setBorder(new javax.swing.border.MatteBorder(null));
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
        fname.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel2.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 200, 30));

        contact.setBackground(new java.awt.Color(204, 204, 204));
        contact.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        contact.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        contact.setBorder(new javax.swing.border.MatteBorder(null));
        contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactActionPerformed(evt);
            }
        });
        jPanel2.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 200, 30));

        jLabel270.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel270.setForeground(new java.awt.Color(0, 102, 102));
        jLabel270.setText("Contact:");
        jPanel2.add(jLabel270, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, -1, -1));

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(0, 102, 102));
        jLabel74.setText("Confirm Password:");
        jPanel2.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 370, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("User Type:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 80, 20));

        ty.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select a Type", "Admin", "Customer", "Employee", " " }));
        ty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tyActionPerformed(evt);
            }
        });
        jPanel2.add(ty, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 210, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("User Status");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 90, 20));

        status.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active" }));
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        jPanel2.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, 210, 30));

        uid.setEditable(false);
        uid.setBackground(new java.awt.Color(204, 204, 204));
        uid.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        uid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        uid.setBorder(new javax.swing.border.MatteBorder(null));
        uid.setEnabled(false);
        uid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uidActionPerformed(evt);
            }
        });
        jPanel2.add(uid, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 210, 30));

        jLabel271.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel271.setForeground(new java.awt.Color(0, 102, 102));
        jLabel271.setText("ID:");
        jPanel2.add(jLabel271, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, -1, -1));

        jLabel1040.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/backwardset.png"))); // NOI18N
        jLabel1040.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1040MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1040, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 40, 40));
        jPanel2.add(oldpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 250, 210, 30));

        seepass3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seepass3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/eyegamay.png"))); // NOI18N
        jPanel2.add(seepass3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 390, 40, 30));
        jPanel2.add(confirmpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 390, 210, 30));

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(0, 102, 102));
        jLabel75.setText("Old Password:");
        jPanel2.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, -1, -1));
        jPanel2.add(newpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 320, 210, 30));

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(0, 102, 102));
        jLabel76.setText("Enter New Password:");
        jPanel2.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 300, -1, -1));

        seepass1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seepass1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/eyegamay.png"))); // NOI18N
        jPanel2.add(seepass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 250, 40, 30));

        seepass2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seepass2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/eyegamay.png"))); // NOI18N
        jPanel2.add(seepass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 320, 40, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 830, 440));

        update.setBackground(new java.awt.Color(0, 102, 102));
        update.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        update.setEnabled(false);
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });
        update.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(0, 102, 102));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Update");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 170, 20));

        update.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 560, 170, 60));

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Update");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        update.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 170, 20));

        jPanel1.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 570, 170, 60));

        jLabel1039.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/undostan.png"))); // NOI18N
        jLabel1039.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1039MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1039, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 580, 30, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactActionPerformed

    private void tyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tyActionPerformed

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

    private void jLabel1039MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1039MouseClicked
        // TODO add your handling code here:

        usernamere.setText(null);
        fname.setText(null);
        lname.setText(null);
        email.setText(null);
        contact.setText(null);
        oldpass.setText(null);
       newpass.setText(null);
       confirmpass.setText(null);
    }//GEN-LAST:event_jLabel1039MouseClicked

    private void uidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uidActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseClicked

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
        // TODO add your handling code here:

      


     
    dbConnect db = new dbConnect();

    try {
        SessionClass ses = SessionClass.getInstance();

        String query = "SELECT u_password FROM user WHERE u_id = '" + ses.getU_id() + "'";
        ResultSet resultset = db.getData(query);
        if (resultset.next()) {
            String storedPasswordHash = resultset.getString("u_password");
            String enteredPasswordHash = passwordHasher.hashPassword(oldpass.getText());

            if (storedPasswordHash.equals(enteredPasswordHash)) {
               
                String npass = passwordHasher.hashPassword(newpass.getText());
                String selectedType = (String) ty.getSelectedItem();
                String selectType = (String) status.getSelectedItem();

                if (usernamere.getText().isEmpty() || fname.getText().isEmpty() || lname.getText().isEmpty() ||
                        email.getText().isEmpty() || contact.getText().isEmpty() || oldpass.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(null, "Invalid Registration: All fields are required.",
                            "Error Registration", JOptionPane.ERROR_MESSAGE);
                    return;
                } else if (selectedType == null || selectedType.equals("Please Select a Type")) {
                    JOptionPane.showMessageDialog(null, "Please select a valid user type (Admin, Customer, or Employee).",
                            "Error Registration", JOptionPane.ERROR_MESSAGE);
                    return;
                } else if (selectType == null || selectType.equals("Please Select a Type")) {
                    JOptionPane.showMessageDialog(null, "Please select a valid status type (Active or Pending).",
                            "Error Registration", JOptionPane.ERROR_MESSAGE);
                    return;
                } else if (!email.getText().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid email address (e.g., example@gmail.com).",
                            "Error Registration", JOptionPane.ERROR_MESSAGE);
                    return;

                } else if (oldpass.getText().length() < 8) {

                    JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long.",
                            "Error Registration", JOptionPane.ERROR_MESSAGE);
                    oldpass.setText("");
                    return;
                } else if (!contact.getText().matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Contact number must contain only digits.",
                            "Error Registration", JOptionPane.ERROR_MESSAGE);
                    return;
                } else if (contact.getText().length() < 11 || contact.getText().length() > 15) {
                    JOptionPane.showMessageDialog(null, "Contact number must be between 11 and 15 digits.",
                            "Error Registration", JOptionPane.ERROR_MESSAGE);
                    contact.setText("");
                    return;
                } else if (updatecheck()) {
                    System.out.println("Duplicated Exist!");
                } else {
                    // All validations passed, proceed with the full update.
                    db.updateData("UPDATE user SET u_username ='" + usernamere.getText() + "',u_fname='" + fname.getText() + "',u_lname ='" + lname.getText() + "',u_email='" + email.getText() + "'"
                            + ",u_contact='" + contact.getText() + "',u_type='" + ty.getSelectedItem() + "',u_password='" + npass + "',u_stat='" + status.getSelectedItem() + "' WHERE u_id ='" + uid.getText() + "' ");

                    int currentUserId = getCurrentUserId();
                    logProductAdditionAction(currentUserId, usernamere.getText());
                    JOptionPane.showMessageDialog(null, "Submitted Successfully");
                    LOGIN log = new LOGIN();
                    log.setVisible(true);
                    this.dispose();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Old Password Is Incorrect");
            }
        }
    } catch (SQLException | NoSuchAlgorithmException ex) {
        System.out.println("" + ex);
    }

    }//GEN-LAST:event_updateMouseClicked

    private void jLabel1040MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1040MouseClicked
        // TODO add your handling code here:

        admindash ad = new admindash();
        ad.setVisible(true);
        this.dispose();
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
            java.util.logging.Logger.getLogger(updateuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateuser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confirmpass;
    public javax.swing.JTextField contact;
    public javax.swing.JTextField email;
    public javax.swing.JTextField fname;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel1039;
    private javax.swing.JLabel jLabel1040;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel1026;
    private javax.swing.JPanel jPanel1027;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel260;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    public javax.swing.JTextField lname;
    private javax.swing.JPasswordField newpass;
    public javax.swing.JPasswordField oldpass;
    private javax.swing.JLabel seepass1;
    private javax.swing.JLabel seepass2;
    private javax.swing.JLabel seepass3;
    public javax.swing.JComboBox<String> status;
    public javax.swing.JComboBox<String> ty;
    public javax.swing.JTextField uid;
    public javax.swing.JPanel update;
    public javax.swing.JTextField usernamere;
    // End of variables declaration//GEN-END:variables
}
