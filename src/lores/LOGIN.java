package lores;


import admin.admindash;
import config.dbConnect;
import customer.userdashboard;
import employ.employdash;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class LOGIN extends javax.swing.JFrame {

    /** Creates new form LOGIN */
    public LOGIN() {
        initComponents();
        this.setResizable(false);
        
        
        
    }
    
     public static String  stat;
     public static String ty;
    
     public static boolean logcheck(String username, String password ){
        
        dbConnect db = new dbConnect();
         
        try{
         String que = "SELECT * FROM user WHERE u_username='"+username+"' AND u_password='"+password+"'";  
            ResultSet resultset = db.getData(que);
        
            
            if(resultset.next()){
              stat = resultset.getString("u_stat");
              ty = resultset.getString("u_type");
              
                
             
             return true;   
            }
            
            else {
                
                return false;
            }
            
            
        }catch(SQLException ex){
         
            return false;
        }
    }
    

    
    Color logcolor = new Color(63,195,128);
    Color excolor = new Color(0,102,102);

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        toregister = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        login4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        login5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        login6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        login7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        reset = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
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
        jLabel20 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Password:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Username:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, -1, -1));

        password.setBackground(new java.awt.Color(204, 204, 204));
        password.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        password.setForeground(new java.awt.Color(0, 102, 102));
        password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        password.setBorder(new javax.swing.border.MatteBorder(null));
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, 310, 50));

        username.setBackground(new java.awt.Color(204, 204, 204));
        username.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        username.setForeground(new java.awt.Color(0, 102, 102));
        username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        username.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 310, 50));

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel3AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 102, 102));
        jLabel2.setFont(new java.awt.Font("Showcard Gothic", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PROD TRACK");
        jLabel2.setToolTipText("");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 360, 430, 120));

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 360, 500));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/chekchek.png"))); // NOI18N
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 290, 320));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 630));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        toregister.setBackground(new java.awt.Color(204, 204, 204));
        toregister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toregisterMouseClicked(evt);
            }
        });
        toregister.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("You don't have an Account? REGISTER Here");
        toregister.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 20));

        jPanel5.add(toregister, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 290, 40));

        login4.setBackground(new java.awt.Color(0, 102, 102));
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

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("LOGIN");
        login4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

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

        jPanel5.add(login4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, 120, 50));

        reset.setBackground(new java.awt.Color(0, 102, 102));
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

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("RESET");
        reset.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

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

        jPanel5.add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 120, 50));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user 30_1.png"))); // NOI18N
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 40, 60));

        jLabel5.setBackground(new java.awt.Color(0, 102, 102));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("LOGIN");
        jLabel5.setToolTipText("");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 260, 70));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 350, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 619, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void resetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseExited
                reset.setBackground(excolor);
    }//GEN-LAST:event_resetMouseExited

    private void resetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseEntered
              reset.setBackground(logcolor);
    }//GEN-LAST:event_resetMouseEntered

    private void resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseClicked
        username.setText(null);
        password.setText(null);
    }//GEN-LAST:event_resetMouseClicked

    private void reset1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reset1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_reset1MouseClicked

    private void login9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_login9MouseClicked

    private void login10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_login10MouseClicked

    private void login8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_login8MouseClicked

    private void login2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_login2MouseClicked

    private void login3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_login3MouseClicked

    private void login1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_login1MouseClicked

    private void login4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login4MouseExited
               login4.setBackground(excolor);
    }//GEN-LAST:event_login4MouseExited

    private void login4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login4MouseEntered
         login4.setBackground(logcolor);
    }//GEN-LAST:event_login4MouseEntered

    private void login4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login4MouseClicked
       
        if(logcheck(username.getText(),password.getText())){
              if (!stat.equals("Active")){
         
            JOptionPane.showMessageDialog(null, "Account not Active");
            
        }
              
              
              else{ 
                       JOptionPane.showMessageDialog(null, "Login Successfully!");
                       if(ty.equals("Admin")){
                           
                           admin.admindash adminDash = new admin.admindash();
                adminDash.setVisible(true);
                this.dispose();
                       }
                       
                       else if(ty.equals("Customer")){
                           userdashboard use = new userdashboard();
                           use.setVisible(true);
                           this.dispose();
                       }
                       
                       else if (ty.equals("Employee")){
                           employdash em = new employdash();
                           em.setVisible(true);
                           this.dispose();
                       }
                       
                       
         
              }
          
              
       
            
        }
      
        
        else {
            
            JOptionPane.showMessageDialog(null,"Invalid Account!");
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

    private void login6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_login6MouseClicked

    private void login7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_login7MouseClicked

    private void login5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_login5MouseClicked

    private void toregisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toregisterMouseClicked
        REGISTER re = new REGISTER();
        re.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_toregisterMouseClicked

    private void jPanel3AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPanel3AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3AncestorAdded

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

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
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LOGIN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel login1;
    private javax.swing.JPanel login10;
    private javax.swing.JPanel login2;
    private javax.swing.JPanel login3;
    private javax.swing.JPanel login4;
    private javax.swing.JPanel login5;
    private javax.swing.JPanel login6;
    private javax.swing.JPanel login7;
    private javax.swing.JPanel login8;
    private javax.swing.JPanel login9;
    private javax.swing.JTextField password;
    private javax.swing.JPanel reset;
    private javax.swing.JPanel reset1;
    private javax.swing.JPanel toregister;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

}
