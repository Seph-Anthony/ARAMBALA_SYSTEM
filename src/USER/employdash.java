/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package USER;

import admin.admindash;
import admin.prodpage;
import static admin.updateuser.getHeightFromWidth;
import admin.vieworder;
import config.SessionClass;
import config.dbConnect;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import lores.LOGIN;
import lores.REGISTER;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Admin
 */
public class employdash extends javax.swing.JFrame {

    /**
     * Creates new form employdash
     */
    public employdash() {
        initComponents();
        displayData();
        CompleteProd();
        PendingProd();
        AllPProcess();
        displayUserImage(customerdash);
        
          searchbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username =searchorder.getText().trim();
                if (!username.isEmpty()) {
                    searchUser(username);
                } else {
                    JOptionPane.showMessageDialog(employdash.this, "Please enter a Product.");
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
    
    public void displayUserImage(JLabel admiimage) {
    SessionClass session = SessionClass.getInstance();
    String imagePath = session.getU_image();
    
    if (imagePath != null && !imagePath.isEmpty()) {
        try {
            ImageIcon icon = new ImageIcon(imagePath);
            // Resize if needed (using your existing ResizeImage method)
            customerdash.setIcon(ResizeImage(imagePath, null, customerdash));
        } catch (Exception e) {
            // Set default image if there's an error
            customerdash.setIcon(new ImageIcon(getClass().getResource("/image/default_user.png")));
        }
    } else {
        // Set default image if no image path exists
        customerdash.setIcon(new ImageIcon(getClass().getResource("/image/default_user.png")));
    }
}
    
    
     private void searchUser(String username) {
        try {
            dbConnect dbc = new dbConnect();
            ResultSet rs = dbc.getData("SELECT s_id, u_id, p_id, s_quantity, s_totalam, s_cash, s_change, s_status, s_date FROM process WHERE u_id = '" + username + "'");
            tableorder.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error searching for order.");
        }
    }
    
    
    
        
public void displayData(){
        try{
            dbConnect dbc = new dbConnect();
            ResultSet rs = dbc.getData("SELECT * FROM process");
            tableorder.setModel(DbUtils.resultSetToTableModel(rs));
             rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        
        }
        
    }


public void CompleteProd(){
    
    try{
             dbConnect dbc = new dbConnect();
             ResultSet rs= dbc.getData("select count(*) as acctt FROM process WHERE s_status = 'Complete' ");
             
             if(rs.next()){
              
                 int activeuserr = rs.getInt("acctt");
                 complete.setText(""+activeuserr );
                 
             }
        
    }catch(SQLException e){
        System.out.println("Error: "+ e.getMessage());
    }
    
}
public void AllPProcess() {
    try {
        // Connect to the database
        dbConnect dbc = new dbConnect();
        
        // Query to get the total number of users
        ResultSet rs = dbc.getData("SELECT COUNT(*) AS totalusers FROM process");
        
        if (rs.next()) {
            // Retrieve the total count from the query result
            int totalUsers = rs.getInt("totalusers");
            
            // Assuming you have a JLabel named lblTotalUsers to display the count
            total.setText(" " + totalUsers);
        }
        
        // Close the ResultSet
        rs.close();
        
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
    }
}
public void PendingProd(){
    
    try{
             dbConnect dbc = new dbConnect();
             ResultSet rs= dbc.getData("select count(*) as acctt FROM process WHERE s_status = 'Pending' ");
             
             if(rs.next()){
              
                 int activeuserr = rs.getInt("acctt");
                 pending.setText(""+activeuserr );
                 
             }
        
    }catch(SQLException e){
        System.out.println("Error: "+ e.getMessage());
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

        jLabel272 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableorder = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        searchorder = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        resetbuton = new javax.swing.JButton();
        searchbutton = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        customerdash = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        product2 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        colorni = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        emuser = new javax.swing.JLabel();
        employeeinfo = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        viewni = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        tologin = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        viewni3 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        complete = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        viewni2 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        pending = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        viewni4 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        total = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        tologin1 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        tologin2 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();

        jLabel272.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel272.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/greentaw.png"))); // NOI18N

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableorder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableorder);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 590, 270));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 0, 190));

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Users Order Overview:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 180, 30));

        searchorder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        searchorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchorderActionPerformed(evt);
            }
        });
        jPanel3.add(searchorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 290, 30));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/searh gamaykaayu.png"))); // NOI18N
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 50, 50));

        resetbuton.setBackground(new java.awt.Color(0, 102, 102));
        resetbuton.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        resetbuton.setForeground(new java.awt.Color(255, 255, 255));
        resetbuton.setText("RESET");
        resetbuton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetbutonMouseClicked(evt);
            }
        });
        jPanel3.add(resetbuton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 100, 40));

        searchbutton.setBackground(new java.awt.Color(0, 102, 102));
        searchbutton.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        searchbutton.setForeground(new java.awt.Color(255, 255, 255));
        searchbutton.setText("SEARCH");
        jPanel3.add(searchbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 620, 360));

        jPanel7.setBackground(new java.awt.Color(0, 102, 102));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        customerdash.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        customerdash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/newuserprofile.png"))); // NOI18N
        jPanel5.add(customerdash, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 130));

        jPanel7.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, 150));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel7.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 130, -1));

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel7.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 130, -1));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 102, 102));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Product");
        jLabel26.setVerifyInputWhenFocusTarget(false);
        jPanel15.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 160, 50));

        product2.setBackground(new java.awt.Color(255, 255, 255));
        product2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                product2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                product2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                product2MouseExited(evt);
            }
        });
        product2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 102, 102));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Details");
        product2.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 80, -1));

        jLabel38.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 102, 102));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("View Process ");
        product2.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel15.add(product2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 150, 50));

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/list35.png"))); // NOI18N
        jPanel15.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 50, 50));

        jPanel7.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 170, 110));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 102, 102));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Product");
        jLabel27.setVerifyInputWhenFocusTarget(false);
        jPanel17.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 160, 50));

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/box35.png"))); // NOI18N
        jPanel17.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 50));

        colorni.setBackground(new java.awt.Color(255, 255, 255));
        colorni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                colorniMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                colorniMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                colorniMouseExited(evt);
            }
        });
        colorni.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 102, 102));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("View Product");
        colorni.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel42.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 102, 102));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Details");
        colorni.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jPanel17.add(colorni, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 150, 50));

        jPanel7.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 170, 110));

        emuser.setBackground(new java.awt.Color(63, 195, 128));
        emuser.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        emuser.setForeground(new java.awt.Color(255, 255, 255));
        emuser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emuser.setText("USER");
        emuser.setVerifyInputWhenFocusTarget(false);
        jPanel7.add(emuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 100, 30));

        employeeinfo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        employeeinfo.setForeground(new java.awt.Color(255, 255, 255));
        employeeinfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        employeeinfo.setText("ID");
        jPanel7.add(employeeinfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 90, 30));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 102, 102));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Product");
        jLabel29.setVerifyInputWhenFocusTarget(false);
        jPanel16.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 160, 50));

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/information35.png"))); // NOI18N
        jPanel16.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 50, 50));

        viewni.setBackground(new java.awt.Color(255, 255, 255));
        viewni.setFocusable(false);
        viewni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewniMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewniMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewniMouseExited(evt);
            }
        });
        viewni.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 102, 102));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("View Employee");
        viewni.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel34.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 102, 102));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewni.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 50, 100, -1));

        jLabel35.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 102, 102));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Details");
        viewni.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jPanel16.add(viewni, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 150, 50));

        jPanel7.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 170, 110));

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

        jPanel7.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 60, 60));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 690));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/box35.png"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 80, 40));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/list35.png"))); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 80, 40));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(0, 102, 102));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel9.add(tologin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, -1, 40));

        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel9.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, -1));

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 180, 10));

        viewni3.setBackground(new java.awt.Color(255, 255, 255));
        viewni3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        viewni3.setFocusable(false);
        viewni3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewni3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewni3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewni3MouseExited(evt);
            }
        });
        viewni3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel51.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 102, 102));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewni3.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        complete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        complete.setForeground(new java.awt.Color(0, 102, 102));
        complete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel22.add(complete, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, 30));

        viewni3.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 160, 30));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/completeorder.png"))); // NOI18N
        viewni3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 120, 80));

        jPanel8.add(viewni3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 180, 150));

        viewni2.setBackground(new java.awt.Color(255, 255, 255));
        viewni2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        viewni2.setFocusable(false);
        viewni2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewni2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewni2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewni2MouseExited(evt);
            }
        });
        viewni2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel48.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 102, 102));
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewni2.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pending.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pending.setForeground(new java.awt.Color(0, 102, 102));
        pending.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel20.add(pending, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, 30));

        viewni2.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 160, 30));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pendingprocess.png"))); // NOI18N
        viewni2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 120, 80));

        jPanel8.add(viewni2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 180, 150));

        viewni4.setBackground(new java.awt.Color(255, 255, 255));
        viewni4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        viewni4.setFocusable(false);
        viewni4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewni4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewni4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewni4MouseExited(evt);
            }
        });
        viewni4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel54.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(0, 102, 102));
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewni4.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        total.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        total.setForeground(new java.awt.Color(0, 102, 102));
        total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel23.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, 30));

        viewni4.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 160, 30));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/totalorder.png"))); // NOI18N
        viewni4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 120, 80));

        jPanel8.add(viewni4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 180, 150));

        jLabel49.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(0, 102, 102));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("Complete Process");
        jPanel8.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jPanel12.setBackground(new java.awt.Color(0, 102, 102));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tologin1.setBackground(new java.awt.Color(204, 204, 204));
        tologin1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tologin1MouseClicked(evt);
            }
        });
        tologin1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setBackground(new java.awt.Color(204, 204, 204));
        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Already have an account? Click Here");
        tologin1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 20));

        jPanel12.add(tologin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, -1, 40));

        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel12.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, -1));

        jPanel8.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 180, 10));

        jLabel52.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 102, 102));
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("Total Process");
        jPanel8.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        jLabel46.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 102, 102));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Pending Process");
        jPanel8.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, -1, -1));

        jPanel14.setBackground(new java.awt.Color(0, 102, 102));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tologin2.setBackground(new java.awt.Color(204, 204, 204));
        tologin2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tologin2MouseClicked(evt);
            }
        });
        tologin2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setBackground(new java.awt.Color(204, 204, 204));
        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Already have an account? Click Here");
        tologin2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 20));

        jPanel14.add(tologin2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, -1, 40));

        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel14.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, -1));

        jPanel8.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 180, 10));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("EMPLOYEE DASHBOARD");
        jPanel8.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 300, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("_____________________________________________________________");
        jPanel8.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 460, -1));

        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/closesmall.png"))); // NOI18N
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });
        jPanel8.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 30, 30));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 640, 690));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchorderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchorderActionPerformed

    private void viewniMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewniMouseEntered
        // TODO add your handling code here:
          viewni.setBackground(logcolor);
    }//GEN-LAST:event_viewniMouseEntered

    private void viewniMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewniMouseExited
        // TODO add your handling code here:
          viewni.setBackground(excolor);
    }//GEN-LAST:event_viewniMouseExited

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
        emuser.setText(ses.getUsername());
        employeeinfo.setText(String.valueOf(ses.getU_id()));
        
        // Add debug output to verify session data
        System.out.println("User ID: " + ses.getU_id());
        System.out.println("Username: " + ses.getUsername());
        System.out.println("Type: " + ses.getType());
    }
        
    }//GEN-LAST:event_formWindowActivated

    private void product2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product2MouseEntered
        // TODO add your handling code here:
        
          product2.setBackground(logcolor);
    }//GEN-LAST:event_product2MouseEntered

    private void product2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product2MouseExited
        // TODO add your handling code here:
          product2.setBackground(excolor);
    }//GEN-LAST:event_product2MouseExited

    private void product2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product2MouseClicked
        // TODO add your handling code here:
        
        vieworder view = new vieworder();
        view.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_product2MouseClicked

    private void viewniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewniMouseClicked
        // TODO add your handling code here:
        
        employeeinfo em = new employeeinfo();
        em.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_viewniMouseClicked

    private void colorniMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_colorniMouseEntered
        // TODO add your handling code here:
        
        colorni.setBackground(logcolor);
        
    }//GEN-LAST:event_colorniMouseEntered

    private void colorniMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_colorniMouseExited
        // TODO add your handling code here:
        colorni.setBackground(excolor);
    }//GEN-LAST:event_colorniMouseExited

    private void viewni2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewni2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_viewni2MouseClicked

    private void viewni2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewni2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_viewni2MouseEntered

    private void viewni2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewni2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_viewni2MouseExited

    private void viewni3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewni3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_viewni3MouseClicked

    private void viewni3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewni3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_viewni3MouseEntered

    private void viewni3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewni3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_viewni3MouseExited

    private void viewni4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewni4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_viewni4MouseClicked

    private void viewni4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewni4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_viewni4MouseEntered

    private void viewni4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewni4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_viewni4MouseExited

    private void resetbutonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetbutonMouseClicked
        // TODO add your handling code here:
        
        try {
        // Call the displayData method to reset the table and show all data
        displayData();
        CompleteProd();
        PendingProd();
        AllPProcess();;
        // Optionally, you can also reset the total user count
        dbConnect dbc = new dbConnect();
        ResultSet rs = dbc.getData("SELECT COUNT(*) AS totalusers FROM process");
        
        if (rs.next()) {
            int totalUsers = rs.getInt("totalusers");
            total.setText(" " + totalUsers); // Update the total user count label
        }
        
        rs.close();
        
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
        JOptionPane.showMessageDialog(this, "Error resetting the table.");
    }
        
    }//GEN-LAST:event_resetbutonMouseClicked

    private void colorniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_colorniMouseClicked
        // TODO add your handling code here:
        
        prodpage prod = new prodpage();
        prod.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_colorniMouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        LOGIN re = new LOGIN ();
        re.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        REGISTER re = new REGISTER ();
        re.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jPanel10MouseClicked

    private void tologinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tologinMouseClicked
        // TODO add your handling code here:

        LOGIN log = new LOGIN();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_tologinMouseClicked

    private void tologin1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tologin1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tologin1MouseClicked

    private void tologin2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tologin2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tologin2MouseClicked

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
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

            admindash ad = new admindash();
            ad.setVisible(true);
            this.dispose();

        }
    }//GEN-LAST:event_logoutMouseClicked

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
            java.util.logging.Logger.getLogger(employdash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(employdash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(employdash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(employdash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new employdash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel colorni;
    private javax.swing.JLabel complete;
    private javax.swing.JLabel customerdash;
    private javax.swing.JLabel employeeinfo;
    private javax.swing.JLabel emuser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel272;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel54;
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
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel pending;
    private javax.swing.JPanel product2;
    private javax.swing.JButton resetbuton;
    private javax.swing.JButton searchbutton;
    private javax.swing.JTextField searchorder;
    private javax.swing.JTable tableorder;
    private javax.swing.JPanel tologin;
    private javax.swing.JPanel tologin1;
    private javax.swing.JPanel tologin2;
    private javax.swing.JLabel total;
    private javax.swing.JPanel viewni;
    private javax.swing.JPanel viewni2;
    private javax.swing.JPanel viewni3;
    private javax.swing.JPanel viewni4;
    // End of variables declaration//GEN-END:variables
}
