/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package USER;

import admin.admindash;
import static admin.updateuser.mail;
import static admin.updateuser.usname;
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
public class updateinfor extends javax.swing.JFrame {
 

    /**
     * Creates new form updateinfor
     */
    
  
  String mail;
 
    
  public updateinfor( String email, String contact, String password) {
        initComponents(); // Initialize the form components

        // Populate the text fields with the passed values
//        idField.setText(String.valueOf(id)); // Set the idField
        emailField.setText(email);
        contactField.setText(contact);
        
        
         seepass3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Toggle password visibility
                if (confirmpassField.getEchoChar() == '\0') {
                    // Hide the password
                    confirmpassField.setEchoChar('•'); // Default echo character for passwords
                    seepass3.setText("Show Password");
                } else {
                    // Show the password
                    confirmpassField.setEchoChar('\0'); // Set echo char to null to show the password
                    seepass3.setText("Hide Password");
                }
            }
        });
        
         seepass2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Toggle password visibility
                if (newpassField.getEchoChar() == '\0') {
                    // Hide the password
                    newpassField.setEchoChar('•'); // Default echo character for passwords
                    seepass2.setText("Show Password");
                } else {
                    // Show the password
                    newpassField.setEchoChar('\0'); // Set echo char to null to show the password
                    seepass2.setText("Hide Password");
                }
            }
        });
        
        
         seepass1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Toggle password visibility
                if (passwordField.getEchoChar() == '\0') {
                    // Hide the password
                    passwordField.setEchoChar('•'); // Default echo character for passwords
                    seepass1.setText("Show Password");
                } else {
                    // Show the password
                    passwordField.setEchoChar('\0'); // Set echo char to null to show the password
                    seepass1.setText("Hide Password");
                }
            }
        });
    }

  Color logcolor = new Color(63,195,128);
    Color excolor = new Color(0,102,102);
  
  
 private void logProductAdditionAction(int userId, String Username) {
    String sql = "INSERT INTO logs (user_id, act, log_date) VALUES (?, ?, NOW())";

    dbConnect db = new dbConnect();
    try (Connection conn = db.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, userId);
        pstmt.setString(2, "Updated Information: " + Username);
        pstmt.executeUpdate();

    } catch (SQLException e) {
        System.err.println("Failed to Update Information: " + e.getMessage());
    }
}
        //Set default values, or leave them empty.
           private int getCurrentUserId() {
  
    config.SessionClass ses = config.SessionClass.getInstance();
    return ses.getU_id();
}
 
  
    updateinfor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
public void initComponentss() {
        
        
       
        
    }
public boolean dupcheck() {
    dbConnect db = new dbConnect();
    try {
        String query = "SELECT * FROM user WHERE u_email = ?";
        PreparedStatement pstmt = db.getConnection().prepareStatement(query);
        pstmt.setString(1, emailField.getText());
        ResultSet resultset = pstmt.executeQuery();

        if (resultset.next()) {
            mail = resultset.getString("u_email");
            if (mail.equals(emailField.getText())) {
                JOptionPane.showMessageDialog(null, "The email already exists",
                    "Error Registration", JOptionPane.ERROR_MESSAGE);
                emailField.setText("");
                return true;
            }
            return true;
        } else {
            return false;
        }
    } catch (SQLException ex) {
        System.out.println("" + ex);
        return false;
    }
}
  
  
    public boolean updatecheck(){
        
        dbConnect db = new dbConnect();
         
        try{
        String que = "SELECT * FROM user WHERE u_email='"+emailField.getText()+"' ";    
            ResultSet resultset = db.getData(que);
            if(resultset.next()){
                mail = resultset.getString("u_email");
            
                if(mail.equals(emailField.getText())){
                    
                    JOptionPane.showMessageDialog(null, "The email already existed",
                "Error Registration", JOptionPane.ERROR_MESSAGE);
                    emailField.setText("");
                    
                    return true;
                }
               
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
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        contactField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        seepass = new javax.swing.JLabel();
        seepass1 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        idField = new javax.swing.JLabel();
        confirmpassField = new javax.swing.JPasswordField();
        passwordField = new javax.swing.JPasswordField();
        newpassField = new javax.swing.JPasswordField();
        seepass2 = new javax.swing.JLabel();
        seepass3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        updateclick = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 192, -1, -1));

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setForeground(new java.awt.Color(0, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 430, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contactField.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        contactField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        contactField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        contactField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactFieldActionPerformed(evt);
            }
        });
        jPanel6.add(contactField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 310, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 102));
        jLabel16.setText("ID:");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 102));
        jLabel17.setText("Email:");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 102));
        jLabel18.setText("Confirm Pass:");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/backwardset.png"))); // NOI18N
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 50, 40));

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 102));
        jLabel19.setText("Contact:");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        seepass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seepass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/eyegamay.png"))); // NOI18N
        jPanel6.add(seepass, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 330, 30, 30));

        seepass1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seepass1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/eyegamay.png"))); // NOI18N
        jPanel6.add(seepass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 40, 30));

        jLabel21.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 102, 102));
        jLabel21.setText("Enter Old Pass:");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 102, 102));
        jLabel22.setText("Enter New Pass:");
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        emailField.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        emailField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        emailField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });
        jPanel6.add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 310, 30));

        idField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        idField.setForeground(new java.awt.Color(0, 102, 102));
        idField.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        idField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        idField.setEnabled(false);
        jPanel6.add(idField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 80, 30));

        confirmpassField.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        confirmpassField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel6.add(confirmpassField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 270, 30));

        passwordField.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        passwordField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel6.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 270, 30));

        newpassField.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        newpassField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        newpassField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newpassFieldActionPerformed(evt);
            }
        });
        jPanel6.add(newpassField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 270, 30));

        seepass2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seepass2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/eyegamay.png"))); // NOI18N
        jPanel6.add(seepass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 40, 30));

        seepass3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seepass3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/eyegamay.png"))); // NOI18N
        jPanel6.add(seepass3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, 40, 30));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 430, 410));

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("UPDATE");
        jLabel9.setToolTipText("");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 170, 30));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/personalinformation.png"))); // NOI18N
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 90));

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("INFORMATION");
        jLabel10.setToolTipText("");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 300, 30));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 430, 100));

        updateclick.setBackground(new java.awt.Color(0, 102, 102));
        updateclick.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        updateclick.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateclickMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateclickMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateclickMouseExited(evt);
            }
        });
        updateclick.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("UPDATE INFORMATION");
        updateclick.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 30));

        jPanel3.add(updateclick, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 550, 210, 50));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void contactFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactFieldActionPerformed

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
              SessionClass session = SessionClass.getInstance();
        String userType = session.getType();

        if (userType != null) {
           
            if(userType.equals("Admin")){
               
                    admindash adminDashboard = new admindash();
                    adminDashboard.setVisible(true);
                    
                    
            }
           if(userType.equals("Customer")){
                    customerdashboard customerDashboard = new customerdashboard(); // Replace with your actual customer dashboard class name
                    customerDashboard.setVisible(true);
                    
                    
           }
           
           if(userType.equals("Employee")){
               
                    employdash employeeDashboard = new employdash(); // Replace with your actual employee dashboard class name
                    employeeDashboard.setVisible(true);
                
                    
           }
              
                    // Handle cases where the user type is not recognized
                
                    // Optionally, you can redirect to a default dashboard or show an error message
                 
            
            this.dispose(); 
        } else {
            // Handle the case where the session doesn't have user type information
      JOptionPane.showMessageDialog(null,"No account login first");
      this.dispose();
            // Optionally, show an error message
        }
    }//GEN-LAST:event_jLabel20MouseClicked

    private void updateclickMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateclickMouseClicked
     dbConnect db = new dbConnect();
try {
    SessionClass ses = SessionClass.getInstance();

    // Validate all fields
    if (emailField.getText().isEmpty() || contactField.getText().isEmpty() || passwordField.getText().isEmpty()
            || newpassField.getText().isEmpty() || confirmpassField.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validate email format
    if (!emailField.getText().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
        JOptionPane.showMessageDialog(null, "Please enter a valid email address (e.g., example@gmail.com).",
                "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validate contact number
    if (!contactField.getText().matches("\\d+")) {
        JOptionPane.showMessageDialog(null, "Contact number must contain only digits.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (contactField.getText().length() < 11 || contactField.getText().length() > 15) {
        JOptionPane.showMessageDialog(null, "Contact number must be between 11 and 15 digits.", "Error", JOptionPane.ERROR_MESSAGE);
        contactField.setText("");
        return;
    }

    // Validate password length
    if (passwordField.getText().length() < 8) {
        JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long.", "Error", JOptionPane.ERROR_MESSAGE);
        passwordField.setText("");
        return;
    }

    // Check for duplicate entries (assuming updatecheck() and dupcheck() are defined elsewhere)
    if (updatecheck()) {
        System.out.println("Duplicated Exist!");
        return;
    }
    if (dupcheck()) {
        System.out.println("Duplication Exist!");
        return;
    }

    // Fetch the current user's password from the database
    String query = "SELECT * FROM user WHERE u_id='" + ses.getU_id() + "'";
    ResultSet resultset = db.getData(query);

    if (resultset.next()) {
        String olddbpass = resultset.getString("u_password");
        String oldhash = passwordHasher.hashPassword(passwordField.getText());

        // Validate old password
        if (!olddbpass.equals(oldhash)) {
            JOptionPane.showMessageDialog(null, "Old Password is incorrect", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate new password and confirm password
        String newpass = newpassField.getText();
        String confirmpass = confirmpassField.getText();
        if (!newpass.equals(confirmpass)) {
            JOptionPane.showMessageDialog(null, "New Password and Confirm Password do not match", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Hash the new password and update the database
        String newpassHash = passwordHasher.hashPassword(newpass);
        db.updateData("UPDATE user SET u_password = '" + newpassHash + "' WHERE u_id = '" + ses.getU_id() + "'");

        // Update email and contact if needed
        db.updateData("UPDATE user SET u_email ='" + emailField.getText() + "', u_contact='" + contactField.getText() + "' WHERE u_id ='" + idField.getText() + "'");
int currentUserId = getCurrentUserId();
            logProductAdditionAction(currentUserId, ses.getUsername());
        
        JOptionPane.showMessageDialog(null, "Profile and Password Successfully Updated");
        LOGIN log = new LOGIN();
        log.setVisible(true);
        this.dispose();
    }
} catch (SQLException | NoSuchAlgorithmException ex) {
    System.out.println("Error: " + ex);
    JOptionPane.showMessageDialog(null, "An error occurred. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
}
        
        
    }//GEN-LAST:event_updateclickMouseClicked

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        SessionClass ses = SessionClass.getInstance();
        idField.setText(""+ses.getU_id());
        
    }//GEN-LAST:event_formWindowActivated

    private void newpassFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newpassFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newpassFieldActionPerformed

    private void updateclickMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateclickMouseEntered
        // TODO add your handling code here:
        updateclick.setBackground(logcolor);
    }//GEN-LAST:event_updateclickMouseEntered

    private void updateclickMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateclickMouseExited
        // TODO add your handling code here:
        updateclick.setBackground(excolor);
    }//GEN-LAST:event_updateclickMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateinfor("", "", "").setVisible(true); // Example usage
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confirmpassField;
    public javax.swing.JTextField contactField;
    public javax.swing.JTextField emailField;
    private javax.swing.JLabel idField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPasswordField newpassField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel seepass;
    private javax.swing.JLabel seepass1;
    private javax.swing.JLabel seepass2;
    private javax.swing.JLabel seepass3;
    private javax.swing.JPanel updateclick;
    // End of variables declaration//GEN-END:variables
}
