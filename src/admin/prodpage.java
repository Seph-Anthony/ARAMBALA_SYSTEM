/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import USER.customerdashboard;
import USER.employdash;
import config.SessionClass;
import config.dbConnect;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
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
public class prodpage extends javax.swing.JFrame {
private dbConnect dbConnection;
    /**
     * Creates new form prodpage
     */
    public prodpage() {
        initComponents();
          dbConnection = new dbConnect();
        AllProd();
        displayData();
        AvailableProd();
        NotAvail();
        
        
        searchbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username =prodsearch.getText().trim();
                if (!username.isEmpty()) {
                    searchUser(username);
                } else {
                    JOptionPane.showMessageDialog(prodpage.this, "Please enter a username.");
                }
            }
        });
        
    }
private boolean hasSalesRecords(int productId, Connection conn) {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    boolean hasRecords = false;

    try {
        String query = "SELECT COUNT(*) FROM order_items WHERE product_id = ?";
        pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, productId);
        rs = pstmt.executeQuery();

        if (rs.next()) {
            int count = rs.getInt(1);
            hasRecords = (count > 0);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error checking sales records: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    } finally {
        try{
            if(rs != null){
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(this, "Error closing resources: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    return hasRecords;
}
    
 private void logProductDeletionAction(int userId, String username, String productName) {
        String sql = "INSERT INTO logs (user_id, act, log_date) VALUES (?, ?, NOW())";

        dbConnect db = new dbConnect();
        try (Connection conn = db.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            pstmt.setString(2, username + " deleted a product: " + productName);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Failed to log product deletion action: " + e.getMessage());
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
            ResultSet rs = dbc.getData("SELECT p_id, p_name, p_category, p_brand, p_price, p_stock, p_status FROM product WHERE p_category = '" + username + "'");
            protable.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error searching for user.");
        }
    }
    
    
//    by the way the name of my database table is product, and the attribute are u_id, u_username, u_fname, u_lname, u_email, u_contact, u_type and u_password. 
//    and the Jtable is prodtable. I want to add a functionality of my delete product through jpanel. what input should I do. give me the code
    
    
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
            ResultSet rs = dbc.getData("SELECT p_id AS 'Product ID', p_name AS 'Product Name', p_category AS 'Category', p_brand AS 'Brand', p_price AS 'Price',"
                    + "p_stock AS 'Stock', p_status AS 'Status' FROM product");
            protable.setModel(DbUtils.resultSetToTableModel(rs));
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
        buttonGroup1 = new javax.swing.ButtonGroup();
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
        protable = new javax.swing.JTable();
        prodsearch = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        cusdash = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        resetbutton = new javax.swing.JButton();
        searchbutton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DELETEMouseClicked(evt);
            }
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

        protable.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        protable.setForeground(new java.awt.Color(0, 102, 102));
        protable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(protable);

        jPanel12.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 125, 820, 220));

        prodsearch.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        prodsearch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prodsearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        prodsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodsearchActionPerformed(evt);
            }
        });
        jPanel12.add(prodsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 260, 30));

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

        resetbutton.setBackground(new java.awt.Color(0, 102, 102));
        resetbutton.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        resetbutton.setForeground(new java.awt.Color(255, 255, 255));
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
        jPanel12.add(resetbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 100, 40));

        searchbutton.setBackground(new java.awt.Color(0, 102, 102));
        searchbutton.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        searchbutton.setForeground(new java.awt.Color(255, 255, 255));
        searchbutton.setText("SEARCH");
        jPanel12.add(searchbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 100, 40));

        jLabel9.setBackground(new java.awt.Color(204, 204, 204));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Search Product Category");
        jPanel12.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 260, 20));

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

    private void prodsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prodsearchActionPerformed

    private void cusdashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cusdashMouseClicked
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
        
        
         int rowindex = protable.getSelectedRow();
        
        if(rowindex<0){
            JOptionPane.showMessageDialog(null,"PLEASE SELECT AN ITEM");
            
        } else{
            
        
        try{
        dbConnect db = new dbConnect();
         TableModel tbl =  protable.getModel();
       ResultSet rs = db.getData("SELECT * FROM  product WHERE p_id = '"+tbl.getValueAt(rowindex, 0)+"'");
      if(rs.next()){
            updateprod up = new updateprod();
        
            
             up.pid.setText(""+rs.getInt("p_id"));
            up.pname.setText(""+rs.getString("p_name"));
            up.pcat.setSelectedItem(""+rs.getString("p_category"));
              up.pbrand.setText(""+rs.getString("p_brand"));
              up.pprice.setText(""+rs.getString("p_price"));
              up.pname.setText(""+rs.getString("p_name"));
              up.pstatus.setText(""+rs.getString("p_status"));
              up.pstock.setText(""+rs.getInt("p_stock"));
up.image.setIcon(up.ResizeImage(rs.getString("p_image"),null,up.image));
      up.oldpath = rs.getString("p_image");
      up.path = rs.getString("p_image");
      up.destination=rs.getString("p_image");
      
     
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

    private void DELETEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DELETEMouseClicked
   Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        conn = dbConnection.getConnection();

        int rowIndex = protable.getSelectedRow();
        if (rowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a product to delete.");
            return;
        }

        TableModel model = protable.getModel();
        int productId = (int) model.getValueAt(rowIndex, 0);
        String productName = (String) model.getValueAt(rowIndex, 1);

        // Check if the product has any sales records
        if (hasSalesRecords(productId, conn)) {
            JOptionPane.showMessageDialog(this, "Cannot delete product. It has existing sales records.", "Error", JOptionPane.ERROR_MESSAGE);
            //  No return here.  We want to redirect even if there are records.
        } else { // Only proceed with deletion if no sales records
            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to delete this product?",
                    "Confirm Delete",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {

                String query = "DELETE FROM product WHERE p_id = ?";
                pstmt = conn.prepareStatement(query);
                pstmt.setInt(1, productId);

                int rowsDeleted = pstmt.executeUpdate();

                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(this, "Product deleted successfully.");

                    int currentUserId = getCurrentUserId();
                    SessionClass ses = SessionClass.getInstance();
                    String username = ses.getUsername();
                    logProductDeletionAction(currentUserId, username, productName);
                    //moved redirection
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to delete the product.");
                }
            }
        }


    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error deleting product: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    } finally {
        // Close resources in a finally block
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

    // Determine user role and redirect (Moved outside the if (rowsDeleted > 0) block)
    SessionClass ses = SessionClass.getInstance(); //moved
    if ("Admin".equals(ses.getType())) { 
        dispose();
        new admindash().setVisible(true);
    } else if ("Employee".equals(ses.getType())) {
        dispose();
        new employdash().setVisible(true);
    } else {
        dispose();
        new admindash().setVisible(true);
    }

    }//GEN-LAST:event_DELETEMouseClicked

    private void resetbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resetbuttonActionPerformed

    private void resetbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetbuttonMouseClicked
        // TODO add your handling code here:
        
         try {
        // Call the displayData method to reset the table and show all data
        displayData();
        
        // Optionally, you can also reset the total user count
        dbConnect dbc = new dbConnect();
        ResultSet rs = dbc.getData("SELECT COUNT(*) AS totalusers FROM user");
        
        if (rs.next()) {
            int totalUsers = rs.getInt("totalusers");
            totalprod.setText(" " + totalUsers); // Update the total user count label
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
    private javax.swing.ButtonGroup buttonGroup1;
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
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel notavail;
    private javax.swing.JTextField prodsearch;
    private javax.swing.JTable protable;
    private javax.swing.JButton resetbutton;
    private javax.swing.JButton searchbutton;
    private javax.swing.JLabel totalprod;
    // End of variables declaration//GEN-END:variables
}
