/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import USER.updateinfor;
import config.SessionClass;
import config.dbConnect;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import java.sql.Connection;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class cuspage extends javax.swing.JFrame {
private dbConnect dbConnection;
    /**
     * Creates new form addcus
     */
    public cuspage() {
        initComponents();
            dbConnection = new dbConnect();
        
        showdata();
        AllUsers();
        ActiveUser();
        PendingUser();
        
        
         searchpanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username =searchuser.getText().trim();
                if (!username.isEmpty()) {
                    searchUser(username);
                } else {
                    JOptionPane.showMessageDialog(cuspage.this, "Please enter a username.");
                }
            }
        });
    }
    
    
    
    private boolean hasOrderRecords(int userId, Connection conn) {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    boolean hasRecords = false;

    try {
        String query = "SELECT COUNT(*) FROM orders WHERE u_id = ?";  // Corrected table name to "orders"
        pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, userId);
        rs = pstmt.executeQuery();

        if (rs.next()) {
            int count = rs.getInt(1);
            hasRecords = (count > 0);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error checking order records: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error closing resources: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    return hasRecords;
}

    
     private void logUserDeletionAction(int loggedInUserId, String loggedInUsername, String deletedUsername) {
        String sql = "INSERT INTO logs (user_id, act, log_date) VALUES (?, ?, NOW())";

        dbConnect db = new dbConnect();
        try (Connection conn = db.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, loggedInUserId);
            pstmt.setString(2, loggedInUsername + " deleted a user: " + deletedUsername);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Failed to log user deletion action: " + e.getMessage());
        }
    }

    private int getCurrentUserId() {
        // Access the user ID from the SessionClass
        config.SessionClass ses = config.SessionClass.getInstance();
        return ses.getU_id();
    }
       
 private void searchUser(String username) {
        try {
            dbConnect dbc = new dbConnect();
            ResultSet rs = dbc.getData("SELECT u_id, u_username, u_fname, u_lname, u_email, u_contact, u_type, u_stat FROM user WHERE u_username = '" + username + "'");
            usertable.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error searching for user.");
        }
    }
    
    
public void PendingUser(){
    
    try{
             dbConnect dbc = new dbConnect();
             ResultSet rs= dbc.getData("select count(*) as ppp FROM user WHERE u_stat = 'Pending' ");
             
             if(rs.next()){
              
                 int penndd = rs.getInt("ppp");
                 pending.setText(""+penndd);
                 
             }
        
    }catch(SQLException e){
        System.out.println("Error: "+ e.getMessage());
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
            totaluser.setText(" " + totalUsers);
        }
        
        // Close the ResultSet
        rs.close();
        
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
    }
}
    
    
public void ActiveUser(){
    
    try{
             dbConnect dbc = new dbConnect();
             ResultSet rs= dbc.getData("select count(*) as acctt FROM user WHERE u_stat = 'Active' ");
             
             if(rs.next()){
              
                 int activeuserr = rs.getInt("acctt");
                 act.setText(""+activeuserr );
                 
             }
        
    }catch(SQLException e){
        System.out.println("Error: "+ e.getMessage());
    }
    
}
    
public void showdata(){
        try{
            dbConnect dbc = new dbConnect();
            ResultSet rs = dbc.getData("SELECT u_id AS 'ID', u_username AS 'Username', u_fname AS 'First Name', u_lname AS 'Last Name', u_email AS 'Email', u_contact AS 'Contact',"
                    + "u_type AS 'Type', u_stat AS 'Status' FROM user");
            usertable.setModel(DbUtils.resultSetToTableModel(rs));
             rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        addem = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        delem = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        editem = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        pending = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        act = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        totaluser = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usertable = new javax.swing.JTable();
        searchuser = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        cusdash = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        searchpanel = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        jScrollPane2.setViewportView(jTree1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 11, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(721, 50, -1, -1));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(527, 27, -1, -1));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 782, -1, -1));

        jPanel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 102, 102));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Product");
        jLabel27.setVerifyInputWhenFocusTarget(false);
        jPanel21.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 160, 50));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/addthis.png"))); // NOI18N
        jPanel9.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 70));

        jPanel21.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 90, 70));

        addem.setBackground(new java.awt.Color(255, 255, 255));
        addem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        addem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addemMouseExited(evt);
            }
        });
        addem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 102, 102));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Add User");
        addem.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, -1));

        jPanel21.add(addem, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 180, 50));

        jPanel5.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 260, 150));

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("USERS PAGE");
        jLabel8.setVerifyInputWhenFocusTarget(false);
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 300, -1));

        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 102, 102));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Product");
        jLabel26.setVerifyInputWhenFocusTarget(false);
        jPanel20.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 160, 50));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/removethis.png"))); // NOI18N
        jPanel12.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 70));

        jPanel20.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 90, 70));

        delem.setBackground(new java.awt.Color(255, 255, 255));
        delem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        delem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                delemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                delemMouseExited(evt);
            }
        });
        delem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Delete User");
        delem.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 30));

        jPanel20.add(delem, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 180, 50));

        jPanel5.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, 260, 150));

        jPanel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 102, 102));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Product");
        jLabel28.setVerifyInputWhenFocusTarget(false);
        jPanel23.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 160, 50));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/editthis.png"))); // NOI18N
        jPanel11.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 70));

        jPanel23.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 90, 70));

        editem.setBackground(new java.awt.Color(255, 255, 255));
        editem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        editem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editemMouseExited(evt);
            }
        });
        editem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Edit User");
        editem.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, -1));

        jPanel23.add(editem, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 180, 50));

        jPanel5.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 260, 150));

        jPanel6.setBackground(new java.awt.Color(0, 102, 102));
        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel6.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 80, 600, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("ACTIVE USER");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 180, 30));

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("TOTAL USER");
        jLabel19.setVerifyInputWhenFocusTarget(false);
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 160, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("PENDING USER");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 210, 20));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel6.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 80, -1));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel6.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 80, -1));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel6.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, 80, -1));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pending.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        pending.setForeground(new java.awt.Color(0, 102, 102));
        pending.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pending.setFocusTraversalPolicyProvider(true);
        pending.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pendingMouseClicked(evt);
            }
        });
        jPanel13.add(pending, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 60, 40));

        jPanel6.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 100, 40));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        act.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        act.setForeground(new java.awt.Color(0, 102, 102));
        act.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        act.setFocusTraversalPolicyProvider(true);
        act.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actMouseClicked(evt);
            }
        });
        jPanel14.add(act, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 60, 40));

        jPanel6.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 100, 40));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        totaluser.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        totaluser.setForeground(new java.awt.Color(0, 102, 102));
        totaluser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel15.add(totaluser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 60, 40));

        jPanel6.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 100, 40));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 820, 220));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/group.png"))); // NOI18N
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, -1));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usertable.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        usertable.setForeground(new java.awt.Color(0, 102, 102));
        usertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(usertable);

        jPanel8.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 780, 220));

        searchuser.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        searchuser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchuser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        searchuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchuserActionPerformed(evt);
            }
        });
        jPanel8.add(searchuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 270, 30));

        jLabel20.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 102));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Users ");
        jLabel20.setVerifyInputWhenFocusTarget(false);
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 90, 30));

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

        jPanel8.add(cusdash, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 180, 50));

        searchpanel.setBackground(new java.awt.Color(0, 102, 102));
        searchpanel.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        searchpanel.setForeground(new java.awt.Color(255, 255, 255));
        searchpanel.setText("SEARCH");
        searchpanel.setBorder(null);
        jPanel8.add(searchpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 100, 40));

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("RESET");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 100, 40));

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Search Username");
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 250, 20));

        jPanel5.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 800, 350));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 660));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchuserActionPerformed

    private void cusdashMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cusdashMouseEntered
cusdash.setBackground(logcolor);       
    }//GEN-LAST:event_cusdashMouseEntered

    private void cusdashMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cusdashMouseExited
       cusdash.setBackground(excolor);
               
    }//GEN-LAST:event_cusdashMouseExited

    private void cusdashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cusdashMouseClicked
       admindash yes = new admindash();
       yes.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_cusdashMouseClicked

    private void addemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addemMouseEntered
        addem.setBackground(logcolor);
    }//GEN-LAST:event_addemMouseEntered

    private void addemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addemMouseExited
        // TODO add your handling code here:

        addem.setBackground(excolor);
    }//GEN-LAST:event_addemMouseExited

    private void editemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editemMouseEntered
        // TODO add your handling code here:

        editem.setBackground(logcolor);
    }//GEN-LAST:event_editemMouseEntered

    private void editemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editemMouseExited
        // TODO add your handling code here:

        editem.setBackground(excolor);
    }//GEN-LAST:event_editemMouseExited

    private void delemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delemMouseEntered
        // TODO add your handling code here:
        delem.setBackground(logcolor);

    }//GEN-LAST:event_delemMouseEntered

    private void delemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delemMouseExited
        // TODO add your handling code here:
        delem.setBackground(excolor);

    }//GEN-LAST:event_delemMouseExited

    private void addemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addemMouseClicked
        // TODO add your handling code here:
       
       adduser cus = new adduser();
      cus.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_addemMouseClicked

    private void editemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editemMouseClicked
        // TODO add your handling code here:
        
        int rowindex = usertable.getSelectedRow();
        
        if(rowindex<0){
            JOptionPane.showMessageDialog(null,"PLEASE SELECT AN ITEM");
            
        } else{
            
        
        try{
        dbConnect db = new dbConnect();
         TableModel tbl =  usertable.getModel();
       ResultSet rs = db.getData("SELECT * FROM  user WHERE u_id = '"+tbl.getValueAt(rowindex, 0)+"'");
      if(rs.next()){
            updateuser up = new updateuser();
           
            
            
            
            up.uid.setText(""+rs.getInt("u_id"));
            up.usernamere.setText(""+rs.getString("u_username"));
       up.fname.setText(""+rs.getString("u_fname"));
       up.lname.setText(""+rs.getString("u_lname"));
       up.email.setText(""+rs.getString("u_email"));
       up.contact.setText(""+rs.getString("u_contact"));
       up.ty.setSelectedItem(""+rs.getString("u_type"));
       up.oldpass.setText(""+rs.getString("u_password"));
      up.status.setSelectedItem(""+rs.getString("u_stat"));
      up.image.setIcon(up.ResizeImage(rs.getString("u_image"),null,up.image));
      up.oldpath = rs.getString("u_image");
      up.path = rs.getString("u_image");
      up.destination=rs.getString("u_image");
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
    }//GEN-LAST:event_editemMouseClicked

    private void pendingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pendingMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pendingMouseClicked

    private void actMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_actMouseClicked

    private void delemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delemMouseClicked
   Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        conn = dbConnection.getConnection();

        int rowIndex = usertable.getSelectedRow();
        if (rowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a user to delete.");
            return;
        }

        TableModel model = usertable.getModel();
        int userIdToDelete = (int) model.getValueAt(rowIndex, 0);
        String usernameToDelete = (String) model.getValueAt(rowIndex, 1);

        // Check if the user has any order records
        if (hasOrderRecords(userIdToDelete, conn)) {
            JOptionPane.showMessageDialog(this, "Cannot delete user.  User has existing order records.", "Error", JOptionPane.ERROR_MESSAGE);
            //  No return here.  We want to redirect even if there are records.
        } else {
            // Confirmation dialog
            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to delete this user?",
                    "Confirm Delete",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                String query = "DELETE FROM user WHERE u_id = ?";
                pstmt = conn.prepareStatement(query);
                pstmt.setInt(1, userIdToDelete);

                int rowsDeleted = pstmt.executeUpdate();

                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(this, "User deleted successfully.");

                    // Log the user deletion action
                    SessionClass ses = SessionClass.getInstance();
                    int currentUserId = getCurrentUserId();
                    String currentUsername = ses.getUsername();
                    logUserDeletionAction(currentUserId, currentUsername, usernameToDelete);

                    // Refresh the table
                    showdata();
                    AllUsers();
                    PendingUser();
                    ActiveUser();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to delete the user.");
                }
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error deleting user: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    } finally {
        // Close resources
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error closing resources: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    // outside the try-catch-finally
    dispose();
    new admindash().setVisible(true);
    }//GEN-LAST:event_delemMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        
        try {
        // Call the displayData method to reset the table and show all data
        showdata();
        
        // Optionally, you can also reset the total user count
        dbConnect dbc = new dbConnect();
        ResultSet rs = dbc.getData("SELECT COUNT(*) AS totalusers FROM user");
        
        if (rs.next()) {
            int totalUsers = rs.getInt("totalusers");
            totaluser.setText(" " + totalUsers); // Update the total user count label
        }
        
        rs.close();
        
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
        JOptionPane.showMessageDialog(this, "Error resetting the table.");
    }
    }//GEN-LAST:event_jButton1MouseClicked
    
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
            java.util.logging.Logger.getLogger(cuspage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cuspage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cuspage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cuspage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cuspage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel act;
    private javax.swing.JPanel addem;
    private javax.swing.JPanel cusdash;
    private javax.swing.JPanel delem;
    private javax.swing.JPanel editem;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree1;
    public javax.swing.JLabel pending;
    private javax.swing.JButton searchpanel;
    private javax.swing.JTextField searchuser;
    private javax.swing.JLabel totaluser;
    private javax.swing.JTable usertable;
    // End of variables declaration//GEN-END:variables
}
