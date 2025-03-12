/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.dbConnect;
import USER.customerdashboard;
import config.SessionClass;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import lores.LOGIN;
import lores.REGISTER;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

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
        AllUsers();
        AllProd();
        AllProcess();
      
         // Add ActionListener to the search button
        SearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username =searchuser.getText().trim();
                if (!username.isEmpty()) {
                    searchUser(username);
                } else {
                    JOptionPane.showMessageDialog(admindash.this, "Please enter a username.");
                }
            }
        });
        
    }
    
   
    
       Color logcolor = new Color(63,195,128);
    Color excolor = new Color(255,255,255);
    
 private void searchUser(String username) {
        try {
            dbConnect dbc = new dbConnect();
            ResultSet rs = dbc.getData("SELECT u_id, u_username, u_fname, u_lname, u_email, u_contact, u_type, u_stat FROM user WHERE u_username = '" + username + "'");
            admintable.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error searching for user.");
        }
    }
    
public void displayData(){
        try{
            dbConnect dbc = new dbConnect();
            ResultSet rs = dbc.getData("SELECT u_id, u_username, u_fname, u_lname, u_email, u_contact, u_type, u_stat FROM user");
            admintable.setModel(DbUtils.resultSetToTableModel(rs));
             rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        
        }
        
    }

public void AllUsers() {
    try {
        // Connect to the database
        dbConnect dbc = new dbConnect();
        
        // Query to get the total number of users
        ResultSet rs = dbc.getData("SELECT COUNT(*) AS totalusers FROM user");
        
        if (rs.next()) {
            // Retrieve the total count from the query result
            int totalUsers = rs.getInt("totalusers");
            
            // Assuming you have a JLabel named lblTotalUsers to display the count
            totaluser1.setText(" " + totalUsers);
        }
        
        // Close the ResultSet
        rs.close();
        
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
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
            totalproduct.setText(" " + totalPROD);
        }
        
        // Close the ResultSet
        rs.close();
        
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
    }
}

public void AllProcess() {
    try {
        // Connect to the database
        dbConnect dbc = new dbConnect();
        
        // Query to get the total number of users
        ResultSet rs = dbc.getData("SELECT COUNT(*) AS totalpro FROM process");
        
        if (rs.next()) {
            // Retrieve the total count from the query result
            int totalPRO = rs.getInt("totalpro");
            
            // Assuming you have a JLabel named lblTotalUsers to display the count
            totalprocess.setText(" " + totalPRO);
        }
        
        // Close the ResultSet
        rs.close();
        
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
    }
}

//public void ActiveUser(){
//    
//    try{
//             dbConnect dbc = new dbConnect();
//             ResultSet rs= dbc.getData("select count(*) as acctt FROM user WHERE u_stat = 'Active' ");
//             
//             if(rs.next()){
//              
//                 int activeuserr = rs.getInt("acctt");
//                 activeuser1.setText(""+activeuserr );
//                 
//             }
//        
//    }catch(SQLException e){
//        System.out.println("Error: "+ e.getMessage());
//    }
//    
//}
//
//public void PendingUser(){
//    
//    try{
//             dbConnect dbc = new dbConnect();
//             ResultSet rs= dbc.getData("select count(*) as ppp FROM user WHERE u_stat = 'Pending' ");
//             
//             if(rs.next()){
//              
//                 int penndd = rs.getInt("ppp");
//                 pendinguser.setText(""+penndd);
//                 
//             }
//        
//    }catch(SQLException e){
//        System.out.println("Error: "+ e.getMessage());
//    }
//    
//}


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
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        product = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        totalproduct = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        process = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        totalprocess = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        admindash = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        searchuser = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        adinfo = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        customerni1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        totaluser1 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        admintable = new javax.swing.JTable();
        resetbutton = new javax.swing.JButton();
        SearchButton = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();

        jPanel261.setBackground(new java.awt.Color(204, 255, 255));
        jPanel261.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setRollover(true);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/boxproduct.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
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

        product.setBackground(new java.awt.Color(255, 255, 255));
        product.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productMouseClicked(evt);
            }
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

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        totalproduct.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        totalproduct.setForeground(new java.awt.Color(0, 102, 102));
        totalproduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalproduct.setText("0");
        jPanel5.add(totalproduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 80, -1));

        jPanel7.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 80, 40));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/boxproduct.png"))); // NOI18N
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 80, 60));

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 190, 170));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel11.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 130, 50));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/checkgamay.png"))); // NOI18N
        jPanel11.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 80, 70));

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

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        totalprocess.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        totalprocess.setForeground(new java.awt.Color(0, 102, 102));
        totalprocess.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalprocess.setText("0");
        jPanel12.add(totalprocess, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 40));

        jPanel11.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 80, 40));

        jPanel2.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, 200, 170));

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("ADMIN DASHBOARD");
        jLabel8.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 550, 50));

        admindash.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        admindash.setForeground(new java.awt.Color(255, 255, 255));
        admindash.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admindash.setText("ADMIN");
        admindash.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(admindash, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 90, 30));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 140, 10));

        searchuser.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        searchuser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchuser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        searchuser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                searchuserMouseReleased(evt);
            }
        });
        searchuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchuserActionPerformed(evt);
            }
        });
        jPanel2.add(searchuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 420, 30));

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("USERS");
        jLabel19.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 90, 30));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/greentaw.png"))); // NOI18N
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 160));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, 190, 160));

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

        jLabel24.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("OVERVIEW");
        jLabel24.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 140, 30));

        adinfo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        adinfo.setForeground(new java.awt.Color(255, 255, 255));
        adinfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adinfo.setText("ID");
        jPanel2.add(adinfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, 80, 20));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 102));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Product");
        jLabel17.setVerifyInputWhenFocusTarget(false);
        jPanel13.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 160, 50));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 102));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Product");
        jLabel18.setVerifyInputWhenFocusTarget(false);
        jPanel14.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 160, 50));

        jLabel20.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 102));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Customer");
        jLabel20.setVerifyInputWhenFocusTarget(false);
        jPanel14.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 150, 50));

        jTextField7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel14.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 130, 50));

        jPanel13.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 190, 140));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/customergamay.png"))); // NOI18N
        jPanel13.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 80, 70));

        customerni1.setBackground(new java.awt.Color(255, 255, 255));
        customerni1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerni1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                customerni1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                customerni1MouseExited(evt);
            }
        });
        customerni1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Users");
        customerni1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 20));

        jPanel13.add(customerni1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 170, 40));

        totaluser1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        totaluser1.setForeground(new java.awt.Color(0, 102, 102));
        totaluser1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totaluser1.setText("0");
        totaluser1.setFocusTraversalPolicyProvider(true);
        totaluser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                totaluser1MouseClicked(evt);
            }
        });
        jPanel13.add(totaluser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 80, 40));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel13.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 80, 40));

        jPanel2.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 190, 170));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/searh gamaykaayu.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 360, 50, 50));

        jPanel19.setBackground(new java.awt.Color(0, 102, 102));
        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        admintable.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        admintable.setForeground(new java.awt.Color(0, 102, 102));
        admintable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        admintable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admintableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(admintable);

        jPanel19.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 780, 270));

        jPanel2.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 800, 290));

        resetbutton.setBackground(new java.awt.Color(255, 255, 255));
        resetbutton.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        resetbutton.setText("RESET");
        resetbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetbuttonMouseClicked(evt);
            }
        });
        resetbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbuttonActionPerformed(evt);
            }
        });
        jPanel2.add(resetbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 370, 100, 30));

        SearchButton.setBackground(new java.awt.Color(255, 255, 255));
        SearchButton.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        SearchButton.setText("SEARCH");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });
        jPanel2.add(SearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, 100, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 720));

        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 350, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

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
       admindash.setText(""+ses.getUsername());
       adinfo.setText(""+ses.getU_id());
       
          }  
       
       
        
    }//GEN-LAST:event_formWindowActivated

    private void totaluser1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_totaluser1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_totaluser1MouseClicked

    private void customerni1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerni1MouseExited
        // TODO add your handling code here: 
          customerni1.setBackground(excolor);
    }//GEN-LAST:event_customerni1MouseExited

    private void customerni1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerni1MouseEntered
        // TODO add your handling code here:
            customerni1.setBackground(logcolor);
        
        
    }//GEN-LAST:event_customerni1MouseEntered

    private void customerni1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerni1MouseClicked
      cuspage cus = new cuspage();
      cus.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_customerni1MouseClicked

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

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        // TODO add your handling code here:

        admininfo add = new admininfo();
        add.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel6MouseClicked

    private void searchuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchuserActionPerformed

    private void processMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_processMouseExited
        process.setBackground(excolor);
    }//GEN-LAST:event_processMouseExited

    private void processMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_processMouseEntered
        process.setBackground(logcolor);
    }//GEN-LAST:event_processMouseEntered

    private void productMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productMouseExited
        product.setBackground(excolor);
    }//GEN-LAST:event_productMouseExited

    private void productMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productMouseEntered
        product.setBackground(logcolor);
    }//GEN-LAST:event_productMouseEntered

    private void productMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productMouseClicked
        // TODO add your handling code here:
        
        prodpage pro = new prodpage();
        pro.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_productMouseClicked

    private void searchuserMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchuserMouseReleased
        // TODO add your handling code here:
      
            
        
        
    }//GEN-LAST:event_searchuserMouseReleased

    private void admintableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admintableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_admintableMouseClicked

    private void resetbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resetbuttonActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void resetbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetbuttonMouseClicked
      
   try {
        // Call the displayData method to reset the table and show all data
        displayData();
        
        // Optionally, you can also reset the total user count
        dbConnect dbc = new dbConnect();
        ResultSet rs = dbc.getData("SELECT COUNT(*) AS totalusers FROM user");
        
        if (rs.next()) {
            int totalUsers = rs.getInt("totalusers");
            totaluser1.setText(" " + totalUsers); // Update the total user count label
        }
        
        rs.close();
        
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
        JOptionPane.showMessageDialog(this, "Error resetting the table.");
    }

    }//GEN-LAST:event_resetbuttonMouseClicked

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
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admindash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SearchButton;
    private javax.swing.JLabel adinfo;
    private javax.swing.JLabel admindash;
    private javax.swing.JTable admintable;
    private javax.swing.JPanel customerni1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel261;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel process;
    private javax.swing.JPanel product;
    private javax.swing.JButton resetbutton;
    private javax.swing.JTextField searchuser;
    private javax.swing.JLabel totalprocess;
    private javax.swing.JLabel totalproduct;
    public javax.swing.JLabel totaluser1;
    // End of variables declaration//GEN-END:variables
}
