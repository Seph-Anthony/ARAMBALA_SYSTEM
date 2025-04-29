/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package USER;

import admin.admindash;
import admin.orderpage;
import static admin.updateuser.getHeightFromWidth;
import admin.vieworder;
import config.SessionClass;
import config.dbConnect;
import java.sql.ResultSet;
import java.sql.SQLException;
import lores.LOGIN;
import lores.REGISTER;
import net.proteanit.sql.DbUtils;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


/**
 *
 * @author Admin
 */
public class customerdashboard extends javax.swing.JFrame {
 private javax.swing.JTextField txtidd;
    private javax.swing.JTextField txtuser;
    private javax.swing.JTextField txtfname;
    private javax.swing.JTextField txtlname;
    private javax.swing.JTextField txtcontact;
    private javax.swing.JTextField txtemail;
    /**
     * Creates new form adminUser
     */
    public customerdashboard() {
        initComponents();
       displayData();
        AvailableProd();
        PendingProd();
        AllProd();
        displayUserImage(customerdash);
          searchbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username =searchproduct.getText().trim();
                if (!username.isEmpty()) {
                    searchUser(username);
                } else {
                    JOptionPane.showMessageDialog(customerdashboard.this, "Please enter a Product.");
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
    
    public void displayData(){
        try{
            dbConnect dbc = new dbConnect();
            ResultSet rs = dbc.getData("SELECT p_id AS 'Product ID', p_name AS 'Product Name', p_category AS 'Category', p_brand AS 'Brand', p_price AS 'Price',"
                    + "p_stock AS 'Stock', p_status AS 'Status' FROM product");
            tableuser.setModel(DbUtils.resultSetToTableModel(rs));
             rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        
        }
        
    }
    
    
    private void searchUser(String username) {
        try {
            dbConnect dbc = new dbConnect();
            ResultSet rs = dbc.getData("SELECT p_id, p_name, p_category, p_brand, p_price, p_stock, p_status FROM product WHERE p_category = '" + username + "'");
            tableuser.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error searching for user.");
        }
    }
    
    
    Color logcolor = new Color(63,195,128);
    Color excolor = new Color(255,255,255);

    

public void AvailableProd(){
    
    try{
             dbConnect dbc = new dbConnect();
             ResultSet rs= dbc.getData("select count(*) as acctt FROM product WHERE p_status = 'Available' ");
             
             if(rs.next()){
              
                 int activeuserr = rs.getInt("acctt");
                 cusinfo.setText(""+activeuserr );
                 
             }
        
    }catch(SQLException e){
        System.out.println("Error: "+ e.getMessage());
    }
    
}

public void PendingProd(){
    
    try{
             dbConnect dbc = new dbConnect();
             ResultSet rs= dbc.getData("select count(*) as acctt FROM product WHERE p_status = 'Not Available' ");
             
             if(rs.next()){
              
                 int activeuserr = rs.getInt("acctt");
                 cusinfo2.setText(""+activeuserr );
                 
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
        ResultSet rs = dbc.getData("SELECT COUNT(*) AS totalusers FROM product");
        
        if (rs.next()) {
            // Retrieve the total count from the query result
            int totalUsers = rs.getInt("totalusers");
            
            // Assuming you have a JLabel named lblTotalUsers to display the count
            totalprod.setText(" " + totalUsers);
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

        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        customerdash = new javax.swing.JLabel();
        cusinfo1 = new javax.swing.JLabel();
        cusdash = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        product1 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        update = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        update1 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableuser = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        searchproduct = new javax.swing.JTextField();
        resetbutton = new javax.swing.JButton();
        searchbutton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        totalprod = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        tologin3 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        cusinfo2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        tologin = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        cusinfo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        tologin2 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();

        jPanel4.setBackground(new java.awt.Color(153, 51, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 1, true));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(0, 102, 102));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, -1, 40));

        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, -20, -1, -1));

        jPanel7.setBackground(new java.awt.Color(0, 102, 102));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        customerdash.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        customerdash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/newuserprofile.png"))); // NOI18N
        jPanel5.add(customerdash, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 170));

        jPanel7.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, 170));

        cusinfo1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cusinfo1.setForeground(new java.awt.Color(255, 255, 255));
        cusinfo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cusinfo1.setText("ID");
        jPanel7.add(cusinfo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 70, 30));

        cusdash.setBackground(new java.awt.Color(63, 195, 128));
        cusdash.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        cusdash.setForeground(new java.awt.Color(255, 255, 255));
        cusdash.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cusdash.setText("Customer");
        cusdash.setVerifyInputWhenFocusTarget(false);
        jPanel7.add(cusdash, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 170, 30));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 102, 102));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Product");
        jLabel29.setVerifyInputWhenFocusTarget(false);
        jPanel18.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 160, 50));

        product1.setBackground(new java.awt.Color(255, 255, 255));
        product1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                product1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                product1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                product1MouseExited(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 102, 102));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("View");
        product1.add(jLabel33);

        jLabel34.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 102, 102));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Your");
        product1.add(jLabel34);

        jLabel35.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 102, 102));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Details");
        product1.add(jLabel35);

        jPanel18.add(product1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 120, 50));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/information35.png"))); // NOI18N
        jPanel18.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 60));

        jPanel7.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 160, -1));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
        });
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        update.setBackground(new java.awt.Color(255, 255, 255));
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateMouseExited(evt);
            }
        });
        update.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        update.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 150, 30));

        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel16.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 150, 30));

        update.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 150, 30));

        update1.setBackground(new java.awt.Color(255, 255, 255));
        update1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                update1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                update1MouseExited(evt);
            }
        });
        update1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        update1.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 150, 30));

        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel23.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 150, 30));

        update1.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 150, 30));

        jLabel26.setBackground(new java.awt.Color(63, 195, 128));
        jLabel26.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 102, 102));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("UPDATE ORDER");
        jLabel26.setVerifyInputWhenFocusTarget(false);
        update1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 180, 30));

        update.add(update1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 180, 50));

        jLabel23.setBackground(new java.awt.Color(63, 195, 128));
        jLabel23.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 102, 102));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Order");
        jLabel23.setVerifyInputWhenFocusTarget(false);
        update.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 80, 30));

        jLabel27.setBackground(new java.awt.Color(63, 195, 128));
        jLabel27.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 102, 102));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Click to Process ");
        jLabel27.setVerifyInputWhenFocusTarget(false);
        update.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 160, 30));

        jPanel9.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 140, 50));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/list35.png"))); // NOI18N
        jPanel9.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 100, 60));

        jPanel7.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 160, 120));

        jPanel10.setBackground(new java.awt.Color(0, 102, 102));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
        });
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/images-removebg-preview.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel10.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        jPanel7.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 60, 60));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 640));

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableuser.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        tableuser.setForeground(new java.awt.Color(0, 102, 102));
        tableuser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableuser);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 670, 270));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/searh gamaykaayu.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 50, 50));

        searchproduct.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        searchproduct.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        searchproduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchproductActionPerformed(evt);
            }
        });
        jPanel2.add(searchproduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 290, 30));

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
        jPanel2.add(resetbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 100, 40));

        searchbutton.setBackground(new java.awt.Color(0, 102, 102));
        searchbutton.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        searchbutton.setForeground(new java.awt.Color(255, 255, 255));
        searchbutton.setText("SEARCH");
        searchbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbuttonActionPerformed(evt);
            }
        });
        jPanel2.add(searchbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 40));

        jLabel9.setBackground(new java.awt.Color(204, 204, 204));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Search Product Category");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 260, 20));

        jPanel26.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 690, 340));

        jLabel18.setBackground(new java.awt.Color(63, 195, 128));
        jLabel18.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 102));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Available Products");
        jLabel18.setVerifyInputWhenFocusTarget(false);
        jPanel26.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 230, 30));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        totalprod.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        totalprod.setForeground(new java.awt.Color(0, 102, 102));
        totalprod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel19.add(totalprod, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 30));

        jPanel8.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 140, -1));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/boxproduct.png"))); // NOI18N
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 80, 70));

        jPanel26.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 180, 140));

        jPanel30.setBackground(new java.awt.Color(0, 102, 102));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tologin3.setBackground(new java.awt.Color(204, 204, 204));
        tologin3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tologin3MouseClicked(evt);
            }
        });
        tologin3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setBackground(new java.awt.Color(204, 204, 204));
        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Already have an account? Click Here");
        tologin3.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 20));

        jPanel30.add(tologin3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, -1, 40));

        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel30.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, -1));

        jPanel26.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 180, 10));

        jLabel22.setBackground(new java.awt.Color(63, 195, 128));
        jLabel22.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 102, 102));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Total Product");
        jLabel22.setVerifyInputWhenFocusTarget(false);
        jPanel26.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 180, 30));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cusinfo2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cusinfo2.setForeground(new java.awt.Color(0, 102, 102));
        cusinfo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel20.add(cusinfo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 80, 30));

        jPanel21.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 140, -1));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/diliabilabol.png"))); // NOI18N
        jPanel21.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 70));

        jPanel26.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, 180, 140));

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tologin.setBackground(new java.awt.Color(204, 204, 204));
        tologin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tologinMouseClicked(evt);
            }
        });
        tologin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setBackground(new java.awt.Color(204, 204, 204));
        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Already have an account? Click Here");
        tologin.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 20));

        jPanel3.add(tologin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, -1, 40));

        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, -1));

        jPanel26.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 180, 10));

        jLabel31.setBackground(new java.awt.Color(63, 195, 128));
        jLabel31.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 102, 102));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Not Available Products");
        jLabel31.setVerifyInputWhenFocusTarget(false);
        jPanel26.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 250, 30));

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cusinfo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cusinfo.setForeground(new java.awt.Color(0, 102, 102));
        cusinfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel13.add(cusinfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 30));

        jPanel25.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 140, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/abilabol.png"))); // NOI18N
        jPanel25.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 100, 80));

        jPanel26.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 180, 140));

        jPanel28.setBackground(new java.awt.Color(0, 102, 102));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tologin2.setBackground(new java.awt.Color(204, 204, 204));
        tologin2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tologin2MouseClicked(evt);
            }
        });
        tologin2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setBackground(new java.awt.Color(204, 204, 204));
        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Already have an account? Click Here");
        tologin2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 20));

        jPanel28.add(tologin2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, -1, 40));

        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel28.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, -1));

        jPanel26.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 180, 10));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("CUSTOMER DASHBOARD");
        jPanel26.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 300, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("_____________________________________________________________");
        jPanel26.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 460, -1));

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close (3)logout.png"))); // NOI18N
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });
        jPanel26.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 40, 40));

        jPanel1.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 730, 640));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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
        cusdash.setText(ses.getUsername());
        cusinfo1.setText(String.valueOf(ses.getU_id()));
        
       
        System.out.println("User ID: " + ses.getU_id());
        System.out.println("Username: " + ses.getUsername());
        System.out.println("Type: " + ses.getType());
    }
    }//GEN-LAST:event_formWindowActivated

    private void tologinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tologinMouseClicked
        // TODO add your handling code here:

        LOGIN log = new LOGIN();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_tologinMouseClicked

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
//     config.SessionClass ses = config.SessionClass.getInstance();
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

    }//GEN-LAST:event_jPanel10MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
     LOGIN ad = new LOGIN();
ad.setVisible(true);
this.dispose();
        
      
    }//GEN-LAST:event_jLabel6MouseClicked

    private void updateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseExited
        update.setBackground(excolor);
    }//GEN-LAST:event_updateMouseExited

    private void updateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseEntered
        update.setBackground(logcolor);
    }//GEN-LAST:event_updateMouseEntered

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
dbConnect db = new dbConnect();
    int newOrderId = 0;

    try {
        SessionClass session = SessionClass.getInstance();
        int userId = session.getU_id();

        // Include order_cash and order_change with initial values (0.00)
        String insertOrderSQL = "INSERT INTO orders (u_id, order_date, order_status, cash, order_change) VALUES ("
                + userId + ", NOW(), 'Processing', 0.00, 0.00)";
        int orderInsertResult = db.insertData(insertOrderSQL);

        if (orderInsertResult == 1) {
            ResultSet generatedKeys = db.getData("SELECT LAST_INSERT_ID()");
            if (generatedKeys.next()) {
                newOrderId = generatedKeys.getInt(1);
                session.setOrder_id(newOrderId);
                System.out.println("New Order ID created: " + newOrderId);

             orderpage order = new orderpage();
                order.setVisible(true);
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

    }//GEN-LAST:event_updateMouseClicked

    private void update1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_update1MouseExited

    private void update1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_update1MouseEntered

    private void product1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product1MouseExited
        product1.setBackground(excolor);
    }//GEN-LAST:event_product1MouseExited

    private void product1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product1MouseEntered
        product1.setBackground(logcolor);
    }//GEN-LAST:event_product1MouseEntered

    private void product1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product1MouseClicked
        // TODO add your handling code here:
        employeeinfo cus = new employeeinfo();
        cus.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_product1MouseClicked

    private void searchbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchbuttonActionPerformed

    private void resetbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resetbuttonActionPerformed

    private void resetbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetbuttonMouseClicked
        // TODO add your handling code here:

        try {
            // Call the displayData method to reset the table and show all data
            displayData();
            AvailableProd();
            PendingProd();
            AllProd();
            // Optionally, you can also reset the total user count
            dbConnect dbc = new dbConnect();
            ResultSet rs = dbc.getData("SELECT COUNT(*) AS totalprod FROM product");

            if (rs.next()) {
                int totalUsers = rs.getInt("totalprod");
                totalprod.setText(" " + totalUsers); // Update the total user count label
            }

            rs.close();

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error resetting the table.");
        }

    }//GEN-LAST:event_resetbuttonMouseClicked

    private void searchproductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchproductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchproductActionPerformed

    private void tologin2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tologin2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tologin2MouseClicked

    private void tologin3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tologin3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tologin3MouseClicked

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        // TODO add your handling code here:
        
   
    }//GEN-LAST:event_jPanel9MouseClicked

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

            customerdashboard dash = new customerdashboard();
            dash.setVisible(true);
            this.dispose();

        }

    }//GEN-LAST:event_jLabel28MouseClicked

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
            java.util.logging.Logger.getLogger(customerdashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(customerdashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(customerdashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(customerdashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new customerdashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cusdash;
    private javax.swing.JLabel cusinfo;
    private javax.swing.JLabel cusinfo1;
    private javax.swing.JLabel cusinfo2;
    private javax.swing.JLabel customerdash;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel product1;
    private javax.swing.JButton resetbutton;
    private javax.swing.JButton searchbutton;
    private javax.swing.JTextField searchproduct;
    private javax.swing.JTable tableuser;
    private javax.swing.JPanel tologin;
    private javax.swing.JPanel tologin2;
    private javax.swing.JPanel tologin3;
    private javax.swing.JLabel totalprod;
    private javax.swing.JPanel update;
    private javax.swing.JPanel update1;
    // End of variables declaration//GEN-END:variables
}
