/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.dbConnect;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Admin
 */
public class prodpage extends javax.swing.JFrame {

    /**
     * Creates new form prodpage
     */
    public prodpage() {
        initComponents();
        AllProd();
        displayData();
        AvailableProd();
        NotAvail();
    }
    
    public void NotAvail(){
    
    try{
             dbConnect dbc = new dbConnect();
             ResultSet rs= dbc.getData("select count(*) as acctt FROM product WHERE p_status = 'Not Available' ");
             
             if(rs.next()){
              
                 int activeuserr = rs.getInt("acctt");
                 notavail.setText(""+activeuserr );
                 
             }
        
    }catch(SQLException e){
        System.out.println("Error: "+ e.getMessage());
    }
    
}

    
    Color logcolor = new Color(63,195,128);
    Color excolor = new Color(255,255,255);
    
    
        
public void displayData(){
        try{
            dbConnect dbc = new dbConnect();
            ResultSet rs = dbc.getData("SELECT p_id, p_name, p_price, p_stock, p_status FROM product");
            prodtable.setModel(DbUtils.resultSetToTableModel(rs));
             rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        
        }
        
    }

public void AvailableProd(){
    
    try{
             dbConnect dbc = new dbConnect();
             ResultSet rs= dbc.getData("select count(*) as acctt FROM product WHERE p_status = 'Available' ");
             
             if(rs.next()){
              
                 int activeuserr = rs.getInt("acctt");
                 available.setText(""+activeuserr );
                 
             }
        
    }catch(SQLException e){
        System.out.println("Error: "+ e.getMessage());
    }
    
}


    
    
    
    public void AllProd() {
    try {
        // Connect to the database
        dbConnect dbc = new dbConnect();
        
        // Query to get the total number of users
        ResultSet rs = dbc.getData("SELECT COUNT(*) AS totalproducts FROM product");
        
        if (rs.next()) {
            // Retrieve the total count from the query result
            int totalPROD = rs.getInt("totalproducts");
            
            // Assuming you have a JLabel named lblTotalUsers to display the count
            totalprod.setText(" " + totalPROD);
        }
        
        // Close the ResultSet
        rs.close();
        
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
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

        jSpinner1 = new javax.swing.JSpinner();
        jPasswordField1 = new javax.swing.JPasswordField();
        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        DELETE = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        EDIT = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        ADD = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        available = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        notavail = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        totalprod = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        prodtable = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        cusdash = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        jPasswordField1.setText("jPasswordField1");

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/boxproduct.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 80, 60));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, -1, -1));

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/deleteprod.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 60, 60));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel7.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 80, 70));

        DELETE.setBackground(new java.awt.Color(255, 255, 255));
        DELETE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        DELETE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DELETEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DELETEMouseExited(evt);
            }
        });
        DELETE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 102, 102));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("DELETE PRODUCT");
        DELETE.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 240, 20));

        jPanel7.add(DELETE, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 240, 40));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, 260, 150));

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/editprod.png"))); // NOI18N
        jLabel5.setText("jLabel3");
        jPanel8.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 60));

        jPanel6.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 80, 70));

        EDIT.setBackground(new java.awt.Color(255, 255, 255));
        EDIT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        EDIT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EDITMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EDITMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EDITMouseExited(evt);
            }
        });
        EDIT.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 102, 102));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("EDIT PRODUCT");
        EDIT.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, 20));

        jPanel6.add(EDIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 250, 40));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 270, 150));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/addprod.png"))); // NOI18N
        jLabel4.setText("jLabel3");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 60, 60));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 80, 70));

        ADD.setBackground(new java.awt.Color(255, 255, 255));
        ADD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ADD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADDMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ADDMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ADDMouseExited(evt);
            }
        });
        ADD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 102, 102));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("ADD PRODUCT");
        ADD.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, 20));

        jPanel5.add(ADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 220, 40));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 250, 150));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 136, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("AVAILABLE");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 150, 30));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        available.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        available.setForeground(new java.awt.Color(0, 102, 102));
        available.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel11.add(available, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 40));

        jPanel2.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 130, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("TOTAL PRODUCTS");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 240, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("NOT AVAILABLE");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 210, 30));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        notavail.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        notavail.setForeground(new java.awt.Color(0, 102, 102));
        notavail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel13.add(notavail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 40));

        jPanel2.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 130, 40));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        totalprod.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        totalprod.setForeground(new java.awt.Color(0, 102, 102));
        totalprod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel14.add(totalprod, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 40));

        jPanel2.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 130, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 860, 190));

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("PRODUCTS PAGE");
        jLabel8.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 360, 60));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        prodtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(prodtable);

        jPanel12.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 125, 820, 220));

        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel12.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 260, 30));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/searh gamaykaayu.png"))); // NOI18N
        jPanel12.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 50, 50));

        jLabel25.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 102, 102));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("PRODUCT");
        jPanel12.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 140, -1));

        cusdash.setBackground(new java.awt.Color(255, 255, 255));
        cusdash.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        cusdash.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cusdashMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cusdashMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cusdashMouseExited(evt);
            }
        });

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dsahdash.png"))); // NOI18N
        cusdash.add(jLabel16);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 102));
        jLabel17.setText("Dashboard");
        cusdash.add(jLabel17);

        jPanel12.add(cusdash, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 180, 50));

        jPanel1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 840, 350));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void cusdashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cusdashMouseClicked
        admindash yes = new admindash();
        yes.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cusdashMouseClicked

    private void cusdashMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cusdashMouseEntered
        cusdash.setBackground(logcolor);
    }//GEN-LAST:event_cusdashMouseEntered

    private void cusdashMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cusdashMouseExited
        cusdash.setBackground(excolor);

    }//GEN-LAST:event_cusdashMouseExited

    private void ADDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADDMouseEntered
        // TODO add your handling code here:
        
        ADD.setBackground(logcolor);
    }//GEN-LAST:event_ADDMouseEntered

    private void ADDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADDMouseExited
        // TODO add your handling code here:
        
        ADD.setBackground(excolor);
    }//GEN-LAST:event_ADDMouseExited

    private void ADDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADDMouseClicked
        // TODO add your handling code here:
        
        addprod add = new addprod();
        add.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_ADDMouseClicked

    private void EDITMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EDITMouseEntered
        // TODO add your handling code here:
        
        EDIT.setBackground(logcolor);
    }//GEN-LAST:event_EDITMouseEntered

    private void EDITMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EDITMouseExited
        // TODO add your handling code here:
        EDIT.setBackground(excolor);
    }//GEN-LAST:event_EDITMouseExited

    private void DELETEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DELETEMouseEntered
        // TODO add your handling code here:
        
        DELETE.setBackground(logcolor);
    }//GEN-LAST:event_DELETEMouseEntered

    private void DELETEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DELETEMouseExited
        // TODO add your handling code here:
        DELETE.setBackground(excolor);
    }//GEN-LAST:event_DELETEMouseExited

    private void EDITMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EDITMouseClicked
        // TODO add your handling code here:
        
        
         int rowindex = prodtable.getSelectedRow();
        
        if(rowindex<0){
            JOptionPane.showMessageDialog(null,"PLEASE SELECT AN ITEM");
            
        } else{
            
        
        try{
        dbConnect db = new dbConnect();
         TableModel tbl =  prodtable.getModel();
       ResultSet rs = db.getData("SELECT * FROM  product WHERE p_id = '"+tbl.getValueAt(rowindex, 0)+"'");
      if(rs.next()){
            updateuser up = new updateuser();
            
           up.pid.setText(""+rs.getInt("p_id"));
            up.pname.setText(""+rs.getString("p_name"));
            
            
//            up.uid.setText(""+rs.getInt("u_id"));
//            up.usernamere.setText(""+rs.getString("u_username"));
//       up.fname.setText(""+rs.getString("u_fname"));
//       up.lname.setText(""+rs.getString("u_lname"));
//       up.email.setText(""+rs.getString("u_email"));
//       up.contact.setText(""+rs.getString("u_contact"));
//       up.ty.setSelectedItem(""+rs.getString("u_type"));
//       up.pass.setText(""+rs.getString("u_password"));
//      up.status.setSelectedItem(""+rs.getString("u_stat"));
      
      up.setVisible(true);
      
        this.dispose();
       
      }
        }
        
        catch(SQLException ex){
            System.out.println(""+ex);
        } 
        }
        
//        TableModel tbl =  usertable.getModel();
        
         
        
//        updateuser up = new updateuser();
//        up.setVisible(true);
//        this.dispose();
        
    }//GEN-LAST:event_EDITMouseClicked

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
            java.util.logging.Logger.getLogger(prodpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(prodpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(prodpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(prodpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new prodpage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ADD;
    private javax.swing.JPanel DELETE;
    private javax.swing.JPanel EDIT;
    private javax.swing.JLabel available;
    private javax.swing.JPanel cusdash;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel notavail;
    private javax.swing.JTable prodtable;
    private javax.swing.JLabel totalprod;
    // End of variables declaration//GEN-END:variables
}
