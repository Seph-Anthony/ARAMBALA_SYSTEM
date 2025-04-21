/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package USER;

import admin.admindash;
import config.SessionClass;
import config.dbConnect;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class SecurityLog extends javax.swing.JFrame {
private int currentUserId; //
    /**
     * Creates new form SecurityLog
     */
 public SecurityLog() {
        initComponents();
        // Get user ID from session if not provided
        SessionClass ses = SessionClass.getInstance();
        this.currentUserId = ses.getU_id();
    }
 
      Color logcolor = new Color(63,195,128);
    Color excolor = new Color(0,102,102);
    
 
       private void logProductAdditionAction(int userId, String Username) {
    String sql = "INSERT INTO logs (user_id, act, log_date) VALUES (?, ?, NOW())";

    dbConnect db = new dbConnect();
    
    try (Connection conn = db.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, userId);
        pstmt.setString(2, "User Added Security:" + Username);
        pstmt.executeUpdate();

    } catch (SQLException e) {
        System.err.println("Failed to log user addition action: " + e.getMessage());
    }
}
         
         private int getCurrentUserId() {
  
    config.SessionClass ses = config.SessionClass.getInstance();
    return ses.getU_id();
}
    
      
 
    // Constructor with user ID
    public SecurityLog(int userId) {
        initComponents();
        this.currentUserId = userId;
    }
    
       
  

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        backbutton = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        favsub = new javax.swing.JComboBox<>();
        favcolor = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        childname = new javax.swing.JTextField();
        BACK = new javax.swing.JPanel();
        back = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        addsecuritypanelbutton = new javax.swing.JPanel();
        add = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backbutton.setBackground(new java.awt.Color(255, 255, 255));
        backbutton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setFocusCycleRoot(true);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SECURITY QUESTIONS");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 220, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ADD");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 70, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/insurance-policy.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, 60));

        backbutton.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 360, 80));

        favsub.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        favsub.setForeground(new java.awt.Color(0, 102, 102));
        favsub.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "English", "Math", "Science", "History", " " }));
        favsub.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        backbutton.add(favsub, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 280, 40));

        favcolor.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        favcolor.setForeground(new java.awt.Color(0, 102, 102));
        favcolor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Brown", "Yellow", "Red", "Green", "Orange", "Black", "White", " " }));
        favcolor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        backbutton.add(favcolor, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 280, 40));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setText("What is your childhood nickname?");
        backbutton.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, -1, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setText("What is your favorite color?");
        backbutton.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setText("What is your favorite subject?");
        backbutton.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        childname.setBackground(new java.awt.Color(240, 240, 240));
        childname.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        childname.setForeground(new java.awt.Color(0, 102, 102));
        childname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        backbutton.add(childname, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 280, 40));

        BACK.setBackground(new java.awt.Color(0, 102, 102));
        BACK.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        BACK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BACKMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BACKMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BACKMouseExited(evt);
            }
        });
        BACK.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back.setText("Back");
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backMouseExited(evt);
            }
        });
        BACK.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        jPanel7.setBackground(new java.awt.Color(0, 102, 102));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("VERIFY");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 30));

        BACK.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, 140, 50));

        backbutton.add(BACK, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 110, 50));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("Make sure to input the proper details that you will remember!");
        backbutton.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 390, 10));

        addsecuritypanelbutton.setBackground(new java.awt.Color(0, 102, 102));
        addsecuritypanelbutton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        addsecuritypanelbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addsecuritypanelbuttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addsecuritypanelbuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addsecuritypanelbuttonMouseExited(evt);
            }
        });
        addsecuritypanelbutton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add.setText("Add");
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addMouseExited(evt);
            }
        });
        addsecuritypanelbutton.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 30));

        jPanel9.setBackground(new java.awt.Color(0, 102, 102));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("VERIFY");
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 30));

        addsecuritypanelbutton.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, 140, 50));

        backbutton.add(addsecuritypanelbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, 140, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backbutton, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BACKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BACKMouseClicked
        // TODO add your handling code here:
        SessionClass ses = SessionClass.getInstance();
        String usertype = ses.getType();
        
        if(usertype.equals("Admin")){
            
            admindash ad = new admindash();
           ad.setVisible(true);
           this.dispose();
            
        }
        else{
            
            
        
        
        
        employeeinfo up = new employeeinfo();
        up.setVisible(true);
    this.dispose();
    
        }
    }//GEN-LAST:event_BACKMouseClicked

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        // TODO add your handling code here:
         SessionClass ses = SessionClass.getInstance();
        String usertype = ses.getType();
        
        if(usertype.equals("Admin")){
            
            admindash ad = new admindash();
           ad.setVisible(true);
           this.dispose();
            
        }
        else{
            
            
        
        
        
        employeeinfo up = new employeeinfo();
        up.setVisible(true);
    this.dispose();
    
        }
        
    }//GEN-LAST:event_backMouseClicked

    private void addsecuritypanelbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addsecuritypanelbuttonMouseClicked
        // TODO add your handling code here:
         String colorAnswer = (String)favcolor.getSelectedItem();
    String subjectAnswer = (String)favsub.getSelectedItem();
    String nicknameAnswer = childname.getText().trim();
      SessionClass sess = SessionClass.getInstance();
    // 2. Validate inputs
    if(nicknameAnswer.isEmpty()) {
        JOptionPane.showMessageDialog(this, 
            "Please enter your childhood nickname", 
            "Missing Information", 
            JOptionPane.WARNING_MESSAGE);
        childname.requestFocus();
        return;
    }
    
    // 3. Prepare SQL update
    String sql = "UPDATE user SET " +
                 "u_ans1 = '" + colorAnswer + "', " +
                 "u_ans2 = '" + subjectAnswer + "', " +
                 "u_ans3 = '" + nicknameAnswer + "' " +
                 "WHERE u_id = " + currentUserId;
    
    // 4. Execute update
   
        dbConnect db = new dbConnect();

// First verify the user exists
try {
    ResultSet rs = db.getData("SELECT u_id FROM user WHERE u_id = " + currentUserId);
    if (!rs.next()) {
        JOptionPane.showMessageDialog(this, "User not found!");
        return;
    }
    
    // Then perform the update
    db.updateData(sql);  // Void call
    
    // Assume success if no exception was thrown
    int currentUserId = getCurrentUserId();
            logProductAdditionAction(currentUserId, sess.getUsername());
    
    JOptionPane.showMessageDialog(this, "Security questions saved!");
    
} catch (SQLException ex) {
    JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
}
    }//GEN-LAST:event_addsecuritypanelbuttonMouseClicked

    private void backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseEntered
        // TODO add your handling code here:
        
        BACK.setBackground(logcolor);
    }//GEN-LAST:event_backMouseEntered

    private void backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseExited
        // TODO add your handling code here:
        
         BACK.setBackground(excolor);
    }//GEN-LAST:event_backMouseExited

    private void BACKMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BACKMouseEntered
        // TODO add your handling code here:
        BACK.setBackground(logcolor);
    }//GEN-LAST:event_BACKMouseEntered

    private void BACKMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BACKMouseExited
        // TODO add your handling code here:
        
        BACK.setBackground(excolor);
    }//GEN-LAST:event_BACKMouseExited

    private void addsecuritypanelbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addsecuritypanelbuttonMouseEntered
        // TODO add your handling code here:
          addsecuritypanelbutton.setBackground(logcolor);
        
    }//GEN-LAST:event_addsecuritypanelbuttonMouseEntered

    private void addsecuritypanelbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addsecuritypanelbuttonMouseExited
        // TODO add your handling code here:
        
        addsecuritypanelbutton.setBackground(excolor);
    }//GEN-LAST:event_addsecuritypanelbuttonMouseExited

    private void addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseEntered
        // TODO add your handling code here:
        
         addsecuritypanelbutton.setBackground(logcolor);
    }//GEN-LAST:event_addMouseEntered

    private void addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseExited
        // TODO add your handling code here:
        
         addsecuritypanelbutton.setBackground(excolor);
    }//GEN-LAST:event_addMouseExited

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        // TODO add your handling code here:
        
          String colorAnswer = (String)favcolor.getSelectedItem();
    String subjectAnswer = (String)favsub.getSelectedItem();
    String nicknameAnswer = childname.getText().trim();
      SessionClass sess = SessionClass.getInstance();
    // 2. Validate inputs
    if(nicknameAnswer.isEmpty()) {
        JOptionPane.showMessageDialog(this, 
            "Please enter your childhood nickname", 
            "Missing Information", 
            JOptionPane.WARNING_MESSAGE);
        childname.requestFocus();
        return;
    }
    
    // 3. Prepare SQL update
    String sql = "UPDATE user SET " +
                 "u_ans1 = '" + colorAnswer + "', " +
                 "u_ans2 = '" + subjectAnswer + "', " +
                 "u_ans3 = '" + nicknameAnswer + "' " +
                 "WHERE u_id = " + currentUserId;
    
    // 4. Execute update
   
        dbConnect db = new dbConnect();

// First verify the user exists
try {
    ResultSet rs = db.getData("SELECT u_id FROM user WHERE u_id = " + currentUserId);
    if (!rs.next()) {
        JOptionPane.showMessageDialog(this, "User not found!");
        return;
    }
    
    // Then perform the update
    db.updateData(sql);  // Void call
    
    // Assume success if no exception was thrown
    int currentUserId = getCurrentUserId();
            logProductAdditionAction(currentUserId, sess.getUsername());
    
    JOptionPane.showMessageDialog(this, "Security questions saved!");
    
} catch (SQLException ex) {
    JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
}
        
    }//GEN-LAST:event_addMouseClicked

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
            java.util.logging.Logger.getLogger(SecurityLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SecurityLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SecurityLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SecurityLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SecurityLog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BACK;
    private javax.swing.JLabel add;
    private javax.swing.JPanel addsecuritypanelbutton;
    private javax.swing.JLabel back;
    private javax.swing.JPanel backbutton;
    private javax.swing.JTextField childname;
    private javax.swing.JComboBox<String> favcolor;
    private javax.swing.JComboBox<String> favsub;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}
