/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package USER;

import static admin.updateuser.getHeightFromWidth;
import config.SessionClass;
import config.dbConnect;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import lores.LOGIN;
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
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableorder = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        searchorder = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        resetbuton = new javax.swing.JButton();
        searchbutton = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        product2 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        viewni = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        colorni = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        employeeinfo = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        customerdash = new javax.swing.JLabel();
        viewni2 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        pending = new javax.swing.JLabel();
        viewni3 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        complete = new javax.swing.JLabel();
        viewni4 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        total = new javax.swing.JLabel();
        emdash = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        emuser = new javax.swing.JLabel();
        emdash1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jLabel272.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel272.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/greentaw.png"))); // NOI18N

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

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("EMPLOYEE DASHBOARD");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 490, 30));

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

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 740, 190));

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
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 180, 30));

        searchorder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        searchorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchorderActionPerformed(evt);
            }
        });
        jPanel3.add(searchorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 290, 30));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/searh gamaykaayu.png"))); // NOI18N
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 50, 50));

        resetbuton.setBackground(new java.awt.Color(0, 102, 102));
        resetbuton.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        resetbuton.setForeground(new java.awt.Color(255, 255, 255));
        resetbuton.setText("RESET");
        resetbuton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetbutonMouseClicked(evt);
            }
        });
        jPanel3.add(resetbuton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 100, 40));

        searchbutton.setBackground(new java.awt.Color(0, 102, 102));
        searchbutton.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        searchbutton.setForeground(new java.awt.Color(255, 255, 255));
        searchbutton.setText("SEARCH");
        jPanel3.add(searchbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 100, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 770, 270));

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/backwardset.png"))); // NOI18N
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, 50, 40));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 102, 102));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Product");
        jLabel26.setVerifyInputWhenFocusTarget(false);
        jPanel15.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 160, 50));

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/shopping-cartgamay.png"))); // NOI18N
        jPanel15.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 60, 70));

        product2.setBackground(new java.awt.Color(255, 255, 255));
        product2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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

        jLabel36.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 102, 102));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("View");
        product2.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 6, -1, -1));

        jLabel37.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 102, 102));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Process");
        product2.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 50, 80, -1));

        jLabel38.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 102, 102));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Details");
        product2.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jPanel15.add(product2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 110, 120));

        jPanel1.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 210, 150));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 102, 102));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Product");
        jLabel29.setVerifyInputWhenFocusTarget(false);
        jPanel16.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 160, 50));

        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/staffgamay.png"))); // NOI18N
        jPanel16.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 70, 60));

        viewni.setBackground(new java.awt.Color(255, 255, 255));
        viewni.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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

        jLabel33.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 102, 102));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("View");
        viewni.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel34.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 102, 102));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Employee");
        viewni.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 50, 100, -1));

        jLabel35.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 102, 102));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Details");
        viewni.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jPanel16.add(viewni, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 110, 120));

        jPanel1.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 230, 210, 150));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 102, 102));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Product");
        jLabel27.setVerifyInputWhenFocusTarget(false);
        jPanel17.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 160, 50));

        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/boxproduct.png"))); // NOI18N
        jPanel17.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 70, 60));

        colorni.setBackground(new java.awt.Color(255, 255, 255));
        colorni.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        colorni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                colorniMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                colorniMouseExited(evt);
            }
        });
        colorni.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 102, 102));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("View");
        colorni.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel41.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 102, 102));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Product");
        colorni.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 50, 90, -1));

        jLabel42.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 102, 102));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Details");
        colorni.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jPanel17.add(colorni, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 110, 120));

        jPanel1.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 210, 150));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(63, 195, 128));
        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Total Pending:");
        jLabel13.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 150, 30));

        jLabel22.setBackground(new java.awt.Color(63, 195, 128));
        jLabel22.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("USER ID");
        jLabel22.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, -40, 130, 30));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        employeeinfo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        employeeinfo.setForeground(new java.awt.Color(0, 102, 102));
        employeeinfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel21.add(employeeinfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 30));

        jPanel2.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 130, 30));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        customerdash.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        customerdash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/newuserprofile.png"))); // NOI18N
        jPanel5.add(customerdash, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 130));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 170, 150));

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

        jLabel46.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 102, 102));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Pending");
        viewni2.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel47.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 102, 102));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("Process");
        viewni2.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 110, -1));

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
        jPanel20.add(pending, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 70, 30));

        viewni2.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jPanel2.add(viewni2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, 110, 120));

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

        jLabel49.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(0, 102, 102));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("Complete");
        viewni3.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel50.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(0, 102, 102));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("Process");
        viewni3.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 110, -1));

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
        jPanel22.add(complete, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 70, 30));

        viewni3.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jPanel2.add(viewni3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 110, 120));

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

        jLabel52.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 102, 102));
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("Total");
        viewni4.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel53.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(0, 102, 102));
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("Process");
        viewni4.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 110, -1));

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
        jPanel23.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 70, 30));

        viewni4.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 30));

        jPanel2.add(viewni4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 110, 120));

        emdash.setBackground(new java.awt.Color(63, 195, 128));
        emdash.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        emdash.setForeground(new java.awt.Color(255, 255, 255));
        emdash.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emdash.setText("USER");
        emdash.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(emdash, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 90, 30));

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        emuser.setBackground(new java.awt.Color(63, 195, 128));
        emuser.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        emuser.setForeground(new java.awt.Color(0, 102, 102));
        emuser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emuser.setVerifyInputWhenFocusTarget(false);
        jPanel24.add(emuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 30));

        jPanel2.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 130, 30));

        emdash1.setBackground(new java.awt.Color(63, 195, 128));
        emdash1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        emdash1.setForeground(new java.awt.Color(255, 255, 255));
        emdash1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emdash1.setText("USER ID");
        emdash1.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(emdash1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 90, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 790, 190));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/staffstandard.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchorderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchorderActionPerformed

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        LOGIN re = new LOGIN ();
        re.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel20MouseClicked

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
    private javax.swing.JLabel emdash;
    private javax.swing.JLabel emdash1;
    private javax.swing.JLabel employeeinfo;
    private javax.swing.JLabel emuser;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel272;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel pending;
    private javax.swing.JPanel product2;
    private javax.swing.JButton resetbuton;
    private javax.swing.JButton searchbutton;
    private javax.swing.JTextField searchorder;
    private javax.swing.JTable tableorder;
    private javax.swing.JLabel total;
    private javax.swing.JPanel viewni;
    private javax.swing.JPanel viewni2;
    private javax.swing.JPanel viewni3;
    private javax.swing.JPanel viewni4;
    // End of variables declaration//GEN-END:variables
}
