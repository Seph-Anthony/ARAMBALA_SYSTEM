/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lores;
import USER.customerdashboard;
import USER.employdash;
import admin.admindash;
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
/**
 *
 * @author Admin
 */
public class newpass extends javax.swing.JFrame {

    /**
     * Creates new form newpass
     */
    public newpass() {
        initComponents();
        
            seepass1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Toggle password visibility
                if (enterpass.getEchoChar() == '\0') {
                    // Hide the password
                    enterpass.setEchoChar('•'); // Default echo character for passwords
                    seepass1.setText("");
                } else {
                    // Show the password
                    enterpass.setEchoChar('\0'); // Set echo char to null to show the password
                    seepass1.setText("");
                }
            }
        });
            
            
             seepass2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Toggle password visibility
                if (confirmpass.getEchoChar() == '\0') {
                    // Hide the password
                    confirmpass.setEchoChar('•'); // Default echo character for passwords
                    seepass2.setText("");
                } else {
                    // Show the password
                    confirmpass.setEchoChar('\0'); // Set echo char to null to show the password
                    seepass2.setText("");
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
        pstmt.setString(2, "Changed Pass:" + Username);
        pstmt.executeUpdate();

    } catch (SQLException e) {
        System.err.println("Failed to log user addition action: " + e.getMessage());
    }
}
         
         private int getCurrentUserId() {
  
    config.SessionClass ses = config.SessionClass.getInstance();
    return ses.getU_id();
}
//        public void getUsername(){
//             
//             config.SessionClass ses = config.SessionClass.getInstance();
//            ses.getUsername();
//         }
//    
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

        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        enterpass = new javax.swing.JPasswordField();
        jLabel273 = new javax.swing.JLabel();
        confirmpass = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        seepass1 = new javax.swing.JLabel();
        seepass2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        login4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        login5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        login6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        login7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        reset = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        login1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        login2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        login3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        reset1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        login8 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        login9 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        login10 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(0, 102, 102));
        jLabel74.setText("Enter Password");
        jPanel2.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        enterpass.setBackground(new java.awt.Color(240, 240, 240));
        enterpass.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        enterpass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(enterpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 400, 50));

        jLabel273.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel273.setForeground(new java.awt.Color(0, 102, 102));
        jLabel273.setText("Confirm Password:");
        jPanel2.add(jLabel273, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        confirmpass.setBackground(new java.awt.Color(240, 240, 240));
        confirmpass.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        confirmpass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(confirmpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 400, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText("Make sure your password is strong but also simple enough for you to remember!");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        seepass1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seepass1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/eyegamay.png"))); // NOI18N
        jPanel2.add(seepass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 40, 30));

        seepass2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seepass2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/eyegamay.png"))); // NOI18N
        jPanel2.add(seepass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 40, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 490, 280));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/unlock.png"))); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 50, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Reset Password");
        jLabel2.setToolTipText("");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 360, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 380, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 140, 140));

        login4.setBackground(new java.awt.Color(255, 255, 255));
        login4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        login4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                login4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                login4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                login4MouseExited(evt);
            }
        });
        login4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("SAVE");
        login4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 7, 100, 40));

        login5.setBackground(new java.awt.Color(0, 102, 102));
        login5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                login5MouseClicked(evt);
            }
        });
        login5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("LOGIN");
        login5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        login4.add(login5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, 120, 50));

        login6.setBackground(new java.awt.Color(0, 102, 102));
        login6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                login6MouseClicked(evt);
            }
        });
        login6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("LOGIN");
        login6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        login7.setBackground(new java.awt.Color(0, 102, 102));
        login7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                login7MouseClicked(evt);
            }
        });
        login7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("LOGIN");
        login7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        login6.add(login7, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, 120, 50));

        login4.add(login6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, 120, 50));

        jPanel1.add(login4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, 120, 50));

        reset.setBackground(new java.awt.Color(255, 255, 255));
        reset.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                resetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                resetMouseExited(evt);
            }
        });
        reset.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("BACK");
        reset.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 7, 100, 40));

        login1.setBackground(new java.awt.Color(0, 102, 102));
        login1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                login1MouseClicked(evt);
            }
        });
        login1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("LOGIN");
        login1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        reset.add(login1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, 120, 50));

        login2.setBackground(new java.awt.Color(0, 102, 102));
        login2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                login2MouseClicked(evt);
            }
        });
        login2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("LOGIN");
        login2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        login3.setBackground(new java.awt.Color(0, 102, 102));
        login3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                login3MouseClicked(evt);
            }
        });
        login3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("LOGIN");
        login3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        login2.add(login3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, 120, 50));

        reset.add(login2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, 120, 50));

        reset1.setBackground(new java.awt.Color(0, 102, 102));
        reset1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reset1MouseClicked(evt);
            }
        });
        reset1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("RESET");
        reset1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        login8.setBackground(new java.awt.Color(0, 102, 102));
        login8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                login8MouseClicked(evt);
            }
        });
        login8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("LOGIN");
        login8.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        reset1.add(login8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, 120, 50));

        login9.setBackground(new java.awt.Color(0, 102, 102));
        login9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                login9MouseClicked(evt);
            }
        });
        login9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("LOGIN");
        login9.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        login10.setBackground(new java.awt.Color(0, 102, 102));
        login10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                login10MouseClicked(evt);
            }
        });
        login10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("LOGIN");
        login10.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        login9.add(login10, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, 120, 50));

        reset1.add(login9, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, 120, 50));

        reset.add(reset1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 390, 120, 50));

        jPanel1.add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 120, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void login5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_login5MouseClicked

    private void login7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_login7MouseClicked

    private void login6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_login6MouseClicked

    private void login4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login4MouseClicked
     
       dbConnect db = new dbConnect();
    SessionClass sess = SessionClass.getInstance();

    if (enterpass.getText().isEmpty() || confirmpass.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "No Password Input Detected", "Text Field should not be empty", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (enterpass.getText().length() < 8) {
        JOptionPane.showMessageDialog(null, "Password Must be At least 8 Character", "Error Input", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (!enterpass.getText().equals(confirmpass.getText())) {
        JOptionPane.showMessageDialog(null, "Password did not Match", "Error Input", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        String passhash = passwordHasher.hashPassword(enterpass.getText());
        int userId = sess.getU_id(); // Use the getter from your SessionClass

        if (userId == 0) { // Assuming 0 or some other value indicates an invalid user ID
            JOptionPane.showMessageDialog(null, "User ID not found in session. Please log in again.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String que = "UPDATE user SET u_password = ? WHERE u_id = ?";
        try (java.sql.PreparedStatement pst = db.getConnection().prepareStatement(que)) {
            pst.setString(1, passhash);
            pst.setInt(2, userId);

            int rowsAffected = pst.executeUpdate();
int currentUserId = getCurrentUserId();

            if (rowsAffected > 0) {
                
                
                
                  logProductAdditionAction(currentUserId, sess.getUsername());
                JOptionPane.showMessageDialog(null, "User Password Changed Successfully");
                LOGIN log = new LOGIN();
                log.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to change password. User not found or an error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    } catch (NoSuchAlgorithmException ex) {
        System.out.println("Error: " + ex);
        JOptionPane.showMessageDialog(null, "An error occurred. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException ex) {
        System.out.println("SQL Error: " + ex);
        JOptionPane.showMessageDialog(null, "Database error occurred. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
    }

        //        if(username.getText().isEmpty() || password.getText().isEmpty() ){
            //
            //            JOptionPane.showMessageDialog(null,"Invalid Registration","Error Registration",JOptionPane.ERROR_MESSAGE);
            //            username.getText();
            //            password.getText();
            //        }
        //
        //        else if(password.getText().length()<8){
            //
            //            JOptionPane.showMessageDialog(null,"Password must be atleast 8 characters long","Error Password",JOptionPane.ERROR_MESSAGE);
            //
            //        }
        //
        //        else if (!(username.getText().isEmpty() || password.getText().isEmpty())){
            //
            //
            //            REGISTER re = new REGISTER();
            //            re.setVisible(true);
            //            this.dispose();
            //
            //        }
        //
        //        else if (dupcheck()){
            //
            //
            //
            //        }

        //   if(usernamere.getText().isEmpty() || fname.getText().isEmpty() || lname.getText().isEmpty() ||
            //   email.getText().isEmpty() || contact.getText().isEmpty() || pass.getText().isEmpty() ||
            //   conpass.getText().isEmpty()) {
            //
            //    JOptionPane.showMessageDialog(null, "Invalid Registration: All fields are required.",
                //                                  "Error Registration", JOptionPane.ERROR_MESSAGE);
            //}
        //else if (pass.getText().length() < 8) {
            //    JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long.",
                //                                  "Error Registration", JOptionPane.ERROR_MESSAGE);
            //}
        //else if (!contact.getText().matches("\\d+")) { // Ensures only numbers in contact
            //    JOptionPane.showMessageDialog(null, "Contact number must contain only digits.",
                //                                  "Error Registration", JOptionPane.ERROR_MESSAGE);
            //}
        //else if (!pass.getText().equals(conpass.getText())) {
            //    JOptionPane.showMessageDialog(null, "Passwords do not match.",
                //                                  "Error Registration", JOptionPane.ERROR_MESSAGE);
            //}
        //else {
            //    JOptionPane.showMessageDialog(null, "Registration Successful!",
                //                                  "Success", JOptionPane.INFORMATION_MESSAGE);
            //}
    }//GEN-LAST:event_login4MouseClicked

    private void login4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login4MouseEntered
        login4.setBackground(logcolor);
    }//GEN-LAST:event_login4MouseEntered

    private void login4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login4MouseExited
        login4.setBackground(excolor);
    }//GEN-LAST:event_login4MouseExited

    private void login1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_login1MouseClicked

    private void login3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_login3MouseClicked

    private void login2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_login2MouseClicked

    private void login8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_login8MouseClicked

    private void login10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_login10MouseClicked

    private void login9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_login9MouseClicked

    private void reset1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reset1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_reset1MouseClicked

    private void resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseClicked
        LOGIN log = new LOGIN();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_resetMouseClicked

    private void resetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseEntered
        reset.setBackground(logcolor);
    }//GEN-LAST:event_resetMouseEntered

    private void resetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseExited
        reset.setBackground(excolor);
    }//GEN-LAST:event_resetMouseExited

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
            java.util.logging.Logger.getLogger(newpass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newpass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newpass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newpass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new newpass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confirmpass;
    public javax.swing.JPasswordField enterpass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel273;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JPanel login1;
    private javax.swing.JPanel login10;
    private javax.swing.JPanel login2;
    private javax.swing.JPanel login3;
    public javax.swing.JPanel login4;
    private javax.swing.JPanel login5;
    private javax.swing.JPanel login6;
    private javax.swing.JPanel login7;
    private javax.swing.JPanel login8;
    private javax.swing.JPanel login9;
    private javax.swing.JPanel reset;
    private javax.swing.JPanel reset1;
    private javax.swing.JLabel seepass1;
    private javax.swing.JLabel seepass2;
    // End of variables declaration//GEN-END:variables
}
