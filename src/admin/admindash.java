/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.dbConnect;
import customer.userdashboard;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import lores.LOGIN;
import lores.REGISTER;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Admin
 */
public class admindash extends javax.swing.JFrame {

    /**
     * Creates new form admin
     */
    public admindash() {
        initComponents();
        displayData();
    }
    
       Color logcolor = new Color(63,195,128);
    Color excolor = new Color(255,255,255);
    
    
    
public void displayData(){
        try{
            dbConnect dbc = new dbConnect();
            ResultSet rs = dbc.getData("SELECT * FROM user");
            admintable.setModel(DbUtils.resultSetToTableModel(rs));
             rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        
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

        jPanel261 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        product = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        customerni = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        process = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jTextField9 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        employee = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        admintable = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        jPanel261.setBackground(new java.awt.Color(204, 255, 255));
        jPanel261.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Product");
        jLabel10.setVerifyInputWhenFocusTarget(false);
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 160, 50));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/boxproduct.png"))); // NOI18N
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 80, 60));

        jTextField10.setEditable(false);
        jTextField10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel7.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 70, 40));

        product.setBackground(new java.awt.Color(255, 255, 255));
        product.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                productMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                productMouseExited(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Product");
        product.add(jLabel13);

        jPanel7.add(product, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 170, -1));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 190, 170));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Product");
        jLabel12.setVerifyInputWhenFocusTarget(false);
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 160, 50));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 102));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Product");
        jLabel15.setVerifyInputWhenFocusTarget(false);
        jPanel10.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 160, 50));

        jLabel16.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 102));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Customer");
        jLabel16.setVerifyInputWhenFocusTarget(false);
        jPanel10.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 150, 50));

        jTextField5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel10.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 130, 50));

        jPanel8.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 190, 140));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/customergamay.png"))); // NOI18N
        jPanel8.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 80, 70));

        jTextField12.setEditable(false);
        jTextField12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel8.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 70, 40));

        customerni.setBackground(new java.awt.Color(255, 255, 255));
        customerni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                customerniMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                customerniMouseExited(evt);
            }
        });
        customerni.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Customer");
        customerni.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 20));

        jPanel8.add(customerni, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 170, 40));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 190, 170));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel11.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 130, 50));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/checkgamay.png"))); // NOI18N
        jPanel11.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 80, 70));

        jTextField11.setEditable(false);
        jTextField11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel11.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 70, 40));

        process.setBackground(new java.awt.Color(255, 255, 255));
        process.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                processMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                processMouseExited(evt);
            }
        });
        process.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(0, 102, 102));
        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Process");
        process.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 100, 20));

        jPanel11.add(process, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 180, 40));

        jPanel2.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 200, 170));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/staffgamay.png"))); // NOI18N
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 80, 50));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel5.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 130, 50));

        jLabel22.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 102, 102));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Employee");
        jLabel22.setVerifyInputWhenFocusTarget(false);
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 150, 50));

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/staffgamay.png"))); // NOI18N
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 80, 70));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, 190, 160));

        jTextField4.setEditable(false);
        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel3.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 70, 40));

        employee.setBackground(new java.awt.Color(255, 255, 255));
        employee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                employeeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                employeeMouseExited(evt);
            }
        });
        employee.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Employee");
        employee.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 170, 30));

        jPanel3.add(employee, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 170, 50));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, 190, 170));

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("ADMIN DASHBOARD");
        jLabel8.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 550, 50));

        jLabel18.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("OVERVIEW");
        jLabel18.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 150, 30));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 140, 10));

        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 350, 30));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/searh gamaykaayu.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 350, 50, 50));

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("USERS");
        jLabel19.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 90, 30));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/adminnisha.png"))); // NOI18N
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, 140));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, 190, 160));

        admintable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(admintable);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 800, 250));

        jPanel9.setBackground(new java.awt.Color(0, 102, 102));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
        });
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/images-removebg-preview.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel9.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 660));

        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 350, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 660));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
            REGISTER re = new REGISTER ();
            re.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_jPanel9MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
      LOGIN re = new LOGIN ();
            re.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void customerniMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerniMouseEntered
       customerni.setBackground(logcolor);
    }//GEN-LAST:event_customerniMouseEntered

    private void customerniMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerniMouseExited
       customerni.setBackground(excolor);
    }//GEN-LAST:event_customerniMouseExited

    private void processMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_processMouseEntered
      process.setBackground(logcolor);
    }//GEN-LAST:event_processMouseEntered

    private void processMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_processMouseExited
        process.setBackground(excolor);
    }//GEN-LAST:event_processMouseExited

    private void employeeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeMouseEntered
       employee.setBackground(logcolor);
    }//GEN-LAST:event_employeeMouseEntered

    private void employeeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeMouseExited
        employee.setBackground(excolor);
    }//GEN-LAST:event_employeeMouseExited

    private void productMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productMouseEntered
        product.setBackground(logcolor);
    }//GEN-LAST:event_productMouseEntered

    private void productMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productMouseExited
        product.setBackground(excolor);
    }//GEN-LAST:event_productMouseExited

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
            java.util.logging.Logger.getLogger(admindash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admindash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admindash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admindash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admindash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable admintable;
    private javax.swing.JPanel customerni;
    private javax.swing.JPanel employee;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel261;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel process;
    private javax.swing.JPanel product;
    // End of variables declaration//GEN-END:variables
}
