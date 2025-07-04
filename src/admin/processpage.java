/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import static admin.updateuser.getHeightFromWidth;
import config.SessionClass;
import config.dbConnect;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class processpage extends javax.swing.JFrame {

 private int p_id;
private int order_id = 0;

public processpage(int p_id, int order_id) {
    initComponents();
    this.p_id = p_id;
    this.order_id = order_id;

    System.out.println("Selected Product ID: " + p_id);
    System.out.println("Current Order ID: " + order_id);
}
  Color logcolor = new Color(63,195,128);
    Color excolor = new Color(0,102,102
    );
    
private orderpage parentOrderPage;

public void setParentOrderPage(orderpage parent) {
    this.parentOrderPage = parent;
}

public int generateNewOrderId(int userId, Connection conn) {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    int orderId = 0;

    try {
        // Query to get the latest order_id for the given user_id
        String sql = "SELECT order_id FROM orders WHERE u_id = ? ORDER BY order_id DESC LIMIT 1";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, userId);  // Using userId to check the user's order history
        rs = pstmt.executeQuery();

        if (rs.next()) {
            // If the user has previous orders, return the most recent order_id
            orderId = rs.getInt("order_id");
            System.out.println("Existing Order ID found: " + orderId);
        } else {
            // If the user has no previous orders, create a new order_id (start from 1 or adjust logic)
            orderId = 1;  // You can choose to auto-increment based on your logic
            System.out.println("No previous orders found. Creating new Order ID: " + orderId);
        }
    } catch (SQLException ex) {
        System.err.println("Error while generating new order ID: " + ex.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
        } catch (SQLException ex) {
            System.err.println("Error closing resources: " + ex.getMessage());
        }
    }

    return orderId;
}


    private void logOrderAction(int userId, String username, String productName) {
        String sql = "INSERT INTO logs (user_id, act, log_date) VALUES (?, ?, NOW())";

        dbConnect db = new dbConnect();
        try (Connection conn = db.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set parameters
            pstmt.setInt(1, userId);
            pstmt.setString(2, "User added order for product: " + productName + " (" + username + ")");
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Failed to log order action: " + e.getMessage());
        }
    }
    
    private String getCurrentUsername() {
    config.SessionClass ses = config.SessionClass.getInstance();
    return ses.getUsername(); // Assuming getU_uname() returns the username from your SessionClass
}
    
//       private void logLoginAction(int userId, String username, String productname) {
//    String sql = "INSERT INTO logs (user_id, act, log_date) VALUES (?, ?, NOW())";
//    config.SessionClass ses = config.SessionClass.getInstance();
//    ses.getP_name();
//   dbConnect db = new dbConnect();
//try (Connection conn = db.getConnection();
//         PreparedStatement pstmt = conn.prepareStatement(sql)) {
//        
//        // Set parameters
//        pstmt.setInt(1, userId);
//        pstmt.setString(2, "User added order: "+username+""+ses.getP_name());  
//        pstmt.executeUpdate();
//        
//    } catch (SQLException e) {
//        System.err.println("Failed to log login action: " + e.getMessage());
//    }
//}
       
       private int getCurrentUserId() {
    // Access the user ID from the SessionClass
    config.SessionClass ses = config.SessionClass.getInstance();
    return ses.getU_id();
}
   
            
 public String destination = "";
    
    File selectedFile;
    public String oldpath;
    public String path;
    
    public int FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();
        
        Path filePath = Paths.get("src/userimages", fileName);
        boolean fileExists = Files.exists(filePath);
        
        if (fileExists) {
            return 1;
        } else {
            return 0;
        }
    
    }
    public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
            // Read the image file
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            
            // Get the original width and height of the image
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            
            // Calculate the new height based on the desired width and the aspect ratio
            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
            
            return newHeight;
        } catch (IOException ex) {
            System.out.println("No image found!");
        }
        
        return -1;
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
    
    public void imageUpdater(String existingFilePath, String newFilePath){
        File existingFile = new File(existingFilePath);
        if (existingFile.exists()) {
            String parentDirectory = existingFile.getParent();
            File newFile = new File(newFilePath);
            String newFileName = newFile.getName();
            File updatedFile = new File(parentDirectory, newFileName);
            existingFile.delete();
            try {
                Files.copy(newFile.toPath(), updatedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Image updated successfully.");
            } catch (IOException e) {
                System.out.println("Error occurred while updating the image: "+e);
            }
        } else {
            try{
                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }catch(IOException e){
                System.out.println("Error on update!");
            }
        }
   }
    
     private void logOrderUpdateAction(int userId, String username) {
    String sql = "INSERT INTO logs (user_id, act, log_date) VALUES (?, ?, NOW())";

    dbConnect db = new dbConnect();
    try (Connection conn = db.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, userId);
        pstmt.setString(2, "User (" + username + ") Added Order ID");
        pstmt.executeUpdate();

    } catch (SQLException e) {
        System.err.println("Failed to log order update action: " + e.getMessage());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        prodbrand = new javax.swing.JTextField();
        prodname = new javax.swing.JTextField();
        prodprice = new javax.swing.JTextField();
        prodid = new javax.swing.JTextField();
        prodstock = new javax.swing.JTextField();
        prodcategory = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        addditem = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/boxproduct.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 220, 230));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setText("Product Name:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, 20));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 102));
        jLabel12.setText("Stock:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, -1, 20));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 102));
        jLabel14.setText("Category:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, -1, 30));

        prodbrand.setEditable(false);
        prodbrand.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        prodbrand.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        prodbrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodbrandActionPerformed(evt);
            }
        });
        jPanel2.add(prodbrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 190, 40));

        prodname.setEditable(false);
        prodname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        prodname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(prodname, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 190, 40));

        prodprice.setEditable(false);
        prodprice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        prodprice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(prodprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 190, 40));

        prodid.setEditable(false);
        prodid.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        prodid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        prodid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodidActionPerformed(evt);
            }
        });
        jPanel2.add(prodid, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 120, 30));

        prodstock.setEditable(false);
        prodstock.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        prodstock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        prodstock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodstockActionPerformed(evt);
            }
        });
        jPanel2.add(prodstock, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 190, 40));

        prodcategory.setEditable(false);
        prodcategory.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        prodcategory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        prodcategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodcategoryActionPerformed(evt);
            }
        });
        jPanel2.add(prodcategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 190, 40));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 102));
        jLabel16.setText("Price:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, -1, 20));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/abrand.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 60, 60));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/astock.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 70, 60));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/apricing.png"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 60, 60));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/aname.png"))); // NOI18N
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 60, 70));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/finalcategory.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 70, 60));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 102));
        jLabel20.setText("Brand:");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, -1, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 700, 370));

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("VIEW PRODUCT");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 440, -1));

        jPanel17.setBackground(new java.awt.Color(0, 102, 102));
        jPanel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel17MouseClicked(evt);
            }
        });
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/images-removebg-preview.png"))); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel17.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        jPanel3.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, 60));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 700, 100));

        quantity.setBackground(new java.awt.Color(240, 240, 240));
        quantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        quantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quantity.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityActionPerformed(evt);
            }
        });
        jPanel1.add(quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, 180, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("Enter Quantity:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 480, -1, 20));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 102));
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 500, -1, 20));

        addditem.setBackground(new java.awt.Color(0, 102, 102));
        addditem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        addditem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addditemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addditemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addditemMouseExited(evt);
            }
        });
        addditem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Order Item");
        addditem.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 20));

        jPanel1.add(addditem, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 520, 150, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/aquantity.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, 50, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
        
        orderpage order = new orderpage();
        order.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jPanel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseClicked
        // TODO add your handling code here:
        
        orderpage order = new orderpage();
        order.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jPanel17MouseClicked

    private void prodbrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodbrandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prodbrandActionPerformed

    private void prodidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prodidActionPerformed

    private void prodstockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodstockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prodstockActionPerformed

    private void prodcategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodcategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prodcategoryActionPerformed

    private void addditemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addditemMouseClicked
String quantityText = quantity.getText();

    if (quantityText.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter the quantity.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int quantityToAdd;
    try {
        quantityToAdd = Integer.parseInt(quantityText);
        if (quantityToAdd <= 0) {
            JOptionPane.showMessageDialog(this, "Quantity must be a positive number.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        SessionClass session = SessionClass.getInstance();
        int currentOrderId = session.getOrder_id();

        int productId = Integer.parseInt(prodid.getText());
        double productPrice = Double.parseDouble(prodprice.getText());
        double totalAmount = quantityToAdd * productPrice;

        dbConnect db = new dbConnect();

        // Check for sufficient stock
        int currentStock = 0;
        try {
            String getStockQuery = "SELECT p_stock FROM product WHERE p_id = " + productId;
            ResultSet stockResult = db.getData(getStockQuery);
            if (stockResult.next()) {
                currentStock = stockResult.getInt("p_stock");
            }
            stockResult.close();
        } catch (SQLException ex) {
            System.err.println("Error getting product stock: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error checking product stock.", "Database Error", JOptionPane.ERROR_MESSAGE);
            return; // Stop the process if there's an error fetching stock
        }

        if (quantityToAdd > currentStock) {
            JOptionPane.showMessageDialog(this, "Insufficient stock. Only " + currentStock + " available.", "Stock Limit Exceeded", JOptionPane.ERROR_MESSAGE);
            return; // Stop adding item if quantity exceeds stock
        }
        //end check

        String insertOrderItemSQL = "INSERT INTO order_items (order_id, product_id, quantity, price, item_total) VALUES ("
                + currentOrderId + ", "
                + productId + ", "
                + quantityToAdd + ", "
                + productPrice + ", "
                + totalAmount + ")";

        int result = db.insertData(insertOrderItemSQL);

        if (result == 1) {
            JOptionPane.showMessageDialog(this, "Item added to order successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

            // Refresh the parent orderpage if it exists
            if (parentOrderPage != null) {
                parentOrderPage.setCurrentOrderId(currentOrderId);
                parentOrderPage.loadOrderedItems(currentOrderId, parentOrderPage.orderitem);
                parentOrderPage.displayOrderTotal();
                parentOrderPage.setVisible(true);
                this.dispose(); // Close the current "View Product" frame
            } else {
                // Fallback: Create a new orderpage (less ideal but handles cases where parent is not set)
                orderpage orderPage = new orderpage();
                orderPage.setCurrentOrderId(currentOrderId);
                orderPage.loadOrderedItems(currentOrderId, orderPage.orderitem);
                orderPage.displayOrderTotal();
                orderPage.setVisible(true);
                this.dispose();
            }

        } else {
            JOptionPane.showMessageDialog(this, "Failed to add item to order.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        try {
            db.getConnection().close();
        } catch (SQLException ex) {
            System.err.println("Error closing database connection: " + ex.getMessage());
        }

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid quantity. Please enter a valid number.", "Validation Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_addditemMouseClicked

    private void quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityActionPerformed
        // TODO add your handling code here:

        try {
            if(!quantity.getText().trim().isEmpty() && !prodprice.getText().trim().isEmpty()) {
                int qty = Integer.parseInt(quantity.getText().trim());
                double price = Double.parseDouble(prodprice.getText().trim());
                double total = qty * price;

                // You can display this in a label or message
                JOptionPane.showMessageDialog(this,
                    "Total Amount: ₱" + String.format("%.2f", total),
                    "Order Summary", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid quantity", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_quantityActionPerformed

    private void addditemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addditemMouseEntered
addditem.setBackground(logcolor); 
    }//GEN-LAST:event_addditemMouseEntered

    private void addditemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addditemMouseExited
        addditem.setBackground(excolor);
    }//GEN-LAST:event_addditemMouseExited

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(processpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(processpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(processpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(processpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new processpage().setVisible(int p_id, int order_id);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addditem;
    public javax.swing.JLabel image;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    public javax.swing.JTextField prodbrand;
    public javax.swing.JTextField prodcategory;
    public javax.swing.JTextField prodid;
    public javax.swing.JTextField prodname;
    public javax.swing.JTextField prodprice;
    public javax.swing.JTextField prodstock;
    private javax.swing.JTextField quantity;
    // End of variables declaration//GEN-END:variables
}
