/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.dbConnect;
import USER.customerdashboard;
import USER.employdash;
import static admin.updateuser.getHeightFromWidth;
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
        displayUserImage(adminimage);
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
    public void displayUserImage(JLabel adminImageLabel) {
    SessionClass session = SessionClass.getInstance();
    String imagePath = session.getU_image();

    if (adminImageLabel != null) { // Ensure the JLabel is not null
        if (imagePath != null && !imagePath.isEmpty()) {
            try {
                ImageIcon icon = new ImageIcon(imagePath);
                adminImageLabel.setIcon(ResizeImage(imagePath, null, adminImageLabel));
            } catch (Exception e) {
                adminImageLabel.setIcon(new ImageIcon(getClass().getResource("/image/default_user.png")));
            }
        } else {
            adminImageLabel.setIcon(new ImageIcon(getClass().getResource("/image/default_user.png")));
        }
    }
}
        private void logProductAdditionAction(int userId, String Username) {
    String sql = "INSERT INTO logs (user_id, act, log_date) VALUES (?, ?, NOW())";

    dbConnect db = new dbConnect();
    try (Connection conn = db.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, userId);
        pstmt.setString(2, "User Logout: " + Username);
        pstmt.executeUpdate();

    } catch (SQLException e) {
        System.err.println("Failed to log user addition action: " + e.getMessage());
    }
}
private int getCurrentUserId() {
  
    config.SessionClass ses = config.SessionClass.getInstance();
    return ses.getU_id();
} 
    
    
   
    
       Color logcolor = new Color(63,195,128);
    Color excolor = new Color(255,255,255);
        
public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
    ImageIcon MyImage = null;
        if(ImagePath !=null){
            MyImage = new ImageIcon(ImagePath);
        }else{
            MyImage = new ImageIcon(pic);
        }
        
    int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
}
    

    
    
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
        ResultSet rs = dbc.getData("SELECT COUNT(*) AS totalpro FROM orders");
        
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
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        product = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        process = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        customerni1 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        admindash = new javax.swing.JLabel();
        adinfo = new javax.swing.JLabel();
        records = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        adminimage = new javax.swing.JLabel();
        vieworder = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        order = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        totalproduct = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        totalprocess = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        totaluser1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        admintable = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        searchuser = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        SearchButton = new javax.swing.JButton();
        resetbutton = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();

        jPanel261.setBackground(new java.awt.Color(204, 255, 255));
        jPanel261.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setRollover(true);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/boxproduct.png"))); // NOI18N

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, -1));

        product.setBackground(new java.awt.Color(255, 255, 255));
        product.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
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
        product.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/box35.png"))); // NOI18N
        product.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 80, 40));

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 102));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Product");
        product.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 150, 20));

        jPanel2.add(product, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 180, 70));

        process.setBackground(new java.awt.Color(255, 255, 255));
        process.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        process.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                processMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                processMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                processMouseExited(evt);
            }
        });
        process.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(0, 102, 102));
        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Order Process");
        process.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 140, 20));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/list35.png"))); // NOI18N
        process.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 80, 40));

        jPanel2.add(process, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 180, 70));

        customerni1.setBackground(new java.awt.Color(255, 255, 255));
        customerni1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
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

        jLabel31.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 102, 102));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Users");
        customerni1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 140, 20));

        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/users35.png"))); // NOI18N
        customerni1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 80, 40));

        jPanel2.add(customerni1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 180, 70));

        admindash.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        admindash.setForeground(new java.awt.Color(255, 255, 255));
        admindash.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admindash.setText("ADMIN");
        admindash.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(admindash, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 200, 30));

        adinfo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        adinfo.setForeground(new java.awt.Color(255, 255, 255));
        adinfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adinfo.setText("ID");
        jPanel2.add(adinfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 70, 20));

        records.setBackground(new java.awt.Color(255, 255, 255));
        records.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        records.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recordsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                recordsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                recordsMouseExited(evt);
            }
        });
        records.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Records");
        records.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 140, 20));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/record35.png"))); // NOI18N
        records.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 80, 40));

        jPanel2.add(records, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 670, 180, 70));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel17MouseClicked(evt);
            }
        });
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        adminimage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/newuserprofile.png"))); // NOI18N
        jPanel17.add(adminimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 140));

        jPanel2.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, 160));

        vieworder.setBackground(new java.awt.Color(255, 255, 255));
        vieworder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        vieworder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vieworderMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vieworderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vieworderMouseExited(evt);
            }
        });
        vieworder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/vieworders35.png"))); // NOI18N
        vieworder.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 80, 40));

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("View Orders");
        vieworder.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 150, 20));

        jPanel2.add(vieworder, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 180, 70));

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

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 740, 60, 60));

        order.setBackground(new java.awt.Color(255, 255, 255));
        order.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        order.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                orderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                orderMouseExited(evt);
            }
        });
        order.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 102, 102));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("View Your Orders");
        order.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 140, 20));

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/receipt.png"))); // NOI18N
        order.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 80, 40));

        jPanel2.add(order, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, 180, 70));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 200, 800));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Product");
        jLabel10.setVerifyInputWhenFocusTarget(false);
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 160, 50));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        totalproduct.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        totalproduct.setForeground(new java.awt.Color(0, 102, 102));
        totalproduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalproduct.setText("0");
        jPanel5.add(totalproduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 40, -1));

        jPanel7.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 80, -1));

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/boxproduct.png"))); // NOI18N
        jPanel7.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 80, 70));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 190, 120));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel11.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 130, 50));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/checkgamay.png"))); // NOI18N
        jPanel11.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 80, 70));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        totalprocess.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        totalprocess.setForeground(new java.awt.Color(0, 102, 102));
        totalprocess.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalprocess.setText("0");
        jPanel12.add(totalprocess, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 40, 30));

        jPanel11.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 80, 30));

        jPanel3.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 190, 120));

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
        jPanel13.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 80, 70));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel15.add(totaluser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 40, 30));

        jPanel13.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 80, -1));

        jPanel3.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 200, 120));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 580, 430));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 600, 450));

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 102));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Total Process");
        jLabel19.setVerifyInputWhenFocusTarget(false);
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 170, 30));

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
        jPanel3.add(searchuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 250, 30));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/searh gamaykaayu.png"))); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, 50, 50));

        SearchButton.setBackground(new java.awt.Color(255, 255, 255));
        SearchButton.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        SearchButton.setText("SEARCH");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });
        jPanel3.add(SearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, 100, 30));

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
        jPanel3.add(resetbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, 80, 30));

        jPanel8.setBackground(new java.awt.Color(0, 102, 102));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 200, 10));

        jPanel10.setBackground(new java.awt.Color(0, 102, 102));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 190, 10));

        jPanel16.setBackground(new java.awt.Color(0, 102, 102));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 190, 10));

        jLabel21.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 102, 102));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("USERS");
        jLabel21.setVerifyInputWhenFocusTarget(false);
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 90, 30));

        jLabel22.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 102, 102));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Total Product");
        jLabel22.setVerifyInputWhenFocusTarget(false);
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 170, 30));

        jLabel23.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 102, 102));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Total Users");
        jLabel23.setVerifyInputWhenFocusTarget(false);
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 170, 30));

        jLabel25.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 102, 102));
        jLabel25.setText("ADMIN DASHBOARD");
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 300, 30));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("_____________________________________________________________");
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 440, -1));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/businessman.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 70));

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close (3)logout.png"))); // NOI18N
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 40, 40));

        jLabel29.setBackground(new java.awt.Color(204, 204, 204));
        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 102, 102));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Search Username");
        jPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 250, 20));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 620, 800));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 820, 820));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
      // TODO add your handling code here:
             
         SessionClass ses = SessionClass.getInstance();
    
    // More comprehensive check for logged in user
    if(ses == null || ses.getU_id() == 0 || ses.getUsername() == null) {
        JOptionPane.showMessageDialog(null,"No account, login first!");
        LOGIN log = new LOGIN();
        log.setVisible(true);
        this.dispose();
    } else {
        admindash.setText(ses.getUsername());
        adinfo.setText(String.valueOf(ses.getU_id()));
        adminimage.setText(ses.getU_image());
//        
//         Add debug output to verify session data
        System.out.println("User ID: " + ses.getU_id());
        System.out.println("Username: " + ses.getUsername());
        System.out.println("Type: " + ses.getType());
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
//    config.SessionClass ses = config.SessionClass.getInstance();
//         
//        // Show a confirmation dialog
//        int choice = JOptionPane.showConfirmDialog(this,
//                "Do you really wish to logout the program?",
//                "Logout Confirmation",
//                JOptionPane.YES_NO_OPTION);
//int id = getCurrentUserId();
//        String username = ses.getUsername();
//        logProductAdditionAction(id, username);
//        
//        // Check if the user clicked "Yes"
//        if (choice == JOptionPane.YES_OPTION) {
//            // Perform logout actions here
//
//            // 1. Optionally, log the logout action (without relying on session for user info)
//            // You might need to get user info from somewhere else if you want to log.
//            // Example (if you have a currently displayed username):
//            // logLogoutAction(getCurrentLoggedInUserId(), currentUsernameLabel.getText());
//
//            // 2. Dispose of the current form
//            this.dispose();
//
//            // 3. Optionally, exit the entire application
//            // System.exit(0);
//        }
//        
//        else {
//            
//            LOGIN ad = new LOGIN();
//            ad.setVisible(true);
//            this.dispose();
//            
//        }

            LOGIN ad = new LOGIN();
            ad.setVisible(true);
            this.dispose();

    }//GEN-LAST:event_jPanel9MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
//          config.SessionClass ses = config.SessionClass.getInstance();
//         
//        // Show a confirmation dialog
//        int choice = JOptionPane.showConfirmDialog(this,
//                "Do you really wish to logout the program?",
//                "Logout Confirmation",
//                JOptionPane.YES_NO_OPTION);
//int id = getCurrentUserId();
//        String username = ses.getUsername();
//        logProductAdditionAction(id, username);
//        
//        // Check if the user clicked "Yes"
//        if (choice == JOptionPane.YES_OPTION) {
//            // Perform logout actions here
//
//            // 1. Optionally, log the logout action (without relying on session for user info)
//            // You might need to get user info from somewhere else if you want to log.
//            // Example (if you have a currently displayed username):
//            // logLogoutAction(getCurrentLoggedInUserId(), currentUsernameLabel.getText());
//
//            // 2. Dispose of the current form
//            this.dispose();
//
//            // 3. Optionally, exit the entire application
//            // System.exit(0);
//        }
//        
//        else {
//            
//            LOGIN ad = new LOGIN();
//            ad.setVisible(true);
//            this.dispose();
//            
//        }


            LOGIN ad = new LOGIN();
            ad.setVisible(true);
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

    private void recordsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recordsMouseEntered
        // TODO add your handling code here:
            records.setBackground(logcolor);
        
    }//GEN-LAST:event_recordsMouseEntered

    private void recordsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recordsMouseExited
        // TODO add your handling code here:
        
            records.setBackground(excolor);
        
    }//GEN-LAST:event_recordsMouseExited

    private void recordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recordsMouseClicked
        // TODO add your handling code here:
     SessionClass ses = SessionClass.getInstance();
        logs logFrame = new logs();
        logFrame.setVisible(true);
        logFrame.setUserId(ses.getU_id()); // Set the user ID in the logs frame
        this.dispose();
    }//GEN-LAST:event_recordsMouseClicked

    private void jPanel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseClicked
        // TODO add your handling code here:
        
       
        
    }//GEN-LAST:event_jPanel17MouseClicked

    private void processMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_processMouseClicked
 dbConnect db = new dbConnect();
    int newOrderId = 0;
    SessionClass session = SessionClass.getInstance();
    int currentOrderId = session.getOrder_id();

    try {
        // Discard existing ordered items for the previous order (if any)
        if (currentOrderId != 0) {
            String deletePreviousItemsSQL = "DELETE FROM order_items WHERE order_id = " + currentOrderId;
            int deletedRows = db.insertData(deletePreviousItemsSQL);
            System.out.println(deletedRows + " ordered items discarded for previous Order ID: " + currentOrderId);
        }

        // Create a new order in the orders table
        int userId = session.getU_id();
        String insertOrderSQL = "INSERT INTO orders (u_id, order_date, order_status, cash, order_change) VALUES ("
                + userId + ", NOW(), 'Processing', 0.00, 0.00)";
        int orderInsertResult = db.insertData(insertOrderSQL);

        if (orderInsertResult == 1) {
            // Retrieve the newly generated order ID
            ResultSet generatedKeys = db.getData("SELECT LAST_INSERT_ID()");
            if (generatedKeys.next()) {
                newOrderId = generatedKeys.getInt(1);
                // Set the new order ID in the session
                session.setOrder_id(newOrderId);
                System.out.println("New Order ID created: " + newOrderId);

             orderpage orderPage = new orderpage();
orderPage.setCurrentOrderId(newOrderId);
orderPage.loadOrderedItems(newOrderId, orderPage.orderitem);
orderPage.setVisible(true);
this.dispose();

            } else {
                JOptionPane.showMessageDialog(this, "Failed to retrieve new order ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            generatedKeys.close();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to create a new order.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (SQLException ex) {
        System.err.println("Error creating new order: " + ex.getMessage());
        JOptionPane.showMessageDialog(this, "Error during order creation.", "Database Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (db.getConnection() != null) {
                db.getConnection().close();
            }
        } catch (SQLException ex) {
            System.err.println("Error closing database connection: " + ex.getMessage());
        }
    }

    }//GEN-LAST:event_processMouseClicked

    private void vieworderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vieworderMouseClicked
        // TODO add your handling code here:
        
        vieworder view = new vieworder();
        view.setVisible(true);
        this.dispose();
        
        
    }//GEN-LAST:event_vieworderMouseClicked

    private void vieworderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vieworderMouseEntered
        // TODO add your handling code here:
        
                vieworder.setBackground(logcolor);
    }//GEN-LAST:event_vieworderMouseEntered

    private void vieworderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vieworderMouseExited
        // TODO add your handling code here:
                vieworder.setBackground(excolor);
        
        
    }//GEN-LAST:event_vieworderMouseExited

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        
        admininfo info = new admininfo();
        info.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        // TODO add your handling code here:
        
          config.SessionClass ses = config.SessionClass.getInstance();
         
        // Show a confirmation dialog
        int choice = JOptionPane.showConfirmDialog(this,
                "Do you really wish to logout the program?",
                "Logout Confirmation",
                JOptionPane.YES_NO_OPTION);
int id = getCurrentUserId();
        String username = ses.getUsername();
        logProductAdditionAction(id, username);
        
        // Check if the user clicked "Yes"
        if (choice == JOptionPane.YES_OPTION) {
            // Perform logout actions here

            // 1. Optionally, log the logout action (without relying on session for user info)
            // You might need to get user info from somewhere else if you want to log.
            // Example (if you have a currently displayed username):
            // logLogoutAction(getCurrentLoggedInUserId(), currentUsernameLabel.getText());

            // 2. Dispose of the current form
            this.dispose();

            // 3. Optionally, exit the entire application
            // System.exit(0);
        }
        
        else {
            
           admindash dash = new admindash();
           dash.setVisible(true);
           this.dispose();
            
        }
        
    }//GEN-LAST:event_jLabel28MouseClicked

    private void orderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderMouseEntered
        // TODO add your handling code here:
        
        order.setBackground(logcolor);
    }//GEN-LAST:event_orderMouseEntered

    private void orderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderMouseExited
        // TODO add your handling code here:
        
        
        order.setBackground(excolor);
    }//GEN-LAST:event_orderMouseExited

    private void orderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderMouseClicked
        // TODO add your handling code here:
        
        updateorder update = new updateorder();
        update.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_orderMouseClicked

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
    private javax.swing.JLabel adminimage;
    private javax.swing.JTable admintable;
    private javax.swing.JPanel customerni1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
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
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel order;
    private javax.swing.JPanel process;
    private javax.swing.JPanel product;
    private javax.swing.JPanel records;
    private javax.swing.JButton resetbutton;
    private javax.swing.JTextField searchuser;
    private javax.swing.JLabel totalprocess;
    private javax.swing.JLabel totalproduct;
    public javax.swing.JLabel totaluser1;
    private javax.swing.JPanel vieworder;
    // End of variables declaration//GEN-END:variables
}
