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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import lores.LOGIN;

/**
 *
 * @author Admin
 */
public class updateorder extends javax.swing.JFrame {
   private DefaultTableModel orderTableModel;
    private dbConnect dbConnection;
    /**
     * Creates new form updateorder
     */
  public updateorder() {
    initComponents();
    dbConnection = new dbConnect();
    orderTableModel = (DefaultTableModel) ordertable.getModel();
    loadMyOrders(); // Call loadMyOrders to populate the table
    displayUserImage(adminimage);
    displayUserImage(adminimage);
}


   public void loadMyOrders() {
    // Clear existing data in the table
    orderTableModel.setRowCount(0);

    // Get the logged-in user's ID from the SessionClass
    SessionClass session = SessionClass.getInstance();
    int loggedInUserId = session.getU_id();
    System.out.println("Attempting to load orders for user ID: " + loggedInUserId);

    // Get the logged-in user's role (assuming you have a method to get the role)
    String loggedInUserRole = session.getType();
    System.out.println("Logged in user role: " + loggedInUserRole);

    // Construct the SQL query based on the user's role
    String sql;
    if ("Admin".equalsIgnoreCase(loggedInUserRole)) { // Changed to "Admin"
        // Admin: Show all orders
        sql = "SELECT order_id, u_id, order_date, order_status, cash, order_change FROM orders ORDER BY order_id DESC";
    } else if ("Employee".equalsIgnoreCase(loggedInUserRole)) { // Changed to "Employee"
        // Employee: Show all orders
        sql = "SELECT order_id, u_id, order_date, order_status, cash, order_change FROM orders ORDER BY order_id DESC";
    } else {
        // Default: show only the user's orders
        sql = "SELECT order_id, u_id, order_date, order_status, cash, order_change FROM orders WHERE u_id = ? ORDER BY order_id DESC";
    }

    try {
        Connection conn = dbConnection.getConnection();
        if (conn != null) {
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                if (!"Admin".equalsIgnoreCase(loggedInUserRole) && !"Employee".equalsIgnoreCase(loggedInUserRole)) { // Changed to "Admin" and "Employee"
                    pstmt.setInt(1, loggedInUserId);
                }
                try (ResultSet rs = pstmt.executeQuery()) {
                    System.out.println("Query executed successfully.");

                    // Populate the table model with the retrieved data
                    int rowCount = 0;
                    while (rs.next()) {
                        rowCount++;
                        System.out.println("Row " + rowCount + " found - Order ID: " + rs.getInt("order_id") + ", User ID: " + rs.getInt("u_id"));

                        Object[] rowData = {
                                rs.getInt("order_id"),
                                rs.getInt("u_id"),
                                rs.getString("order_date"),
                                rs.getString("order_status"),
                                rs.getDouble("cash"),
                                rs.getDouble("order_change")
                        };
                        orderTableModel.addRow(rowData);
                    }
                    System.out.println("Total rows added to table model: " + rowCount);
                    totalorders.setText(String.valueOf(orderTableModel.getRowCount()));
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Failed to connect to the database.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error loading orders: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
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
      public void displayUserImage(JLabel admiimage) {
    SessionClass session = SessionClass.getInstance();
    String imagePath = session.getU_image();
    
    if (imagePath != null && !imagePath.isEmpty()) {
        try {
            ImageIcon icon = new ImageIcon(imagePath);
            // Resize if needed (using your existing ResizeImage method)
            adminimage.setIcon(ResizeImage(imagePath, null, adminimage));
        } catch (Exception e) {
            // Set default image if there's an error
            adminimage.setIcon(new ImageIcon(getClass().getResource("/image/default_user.png")));
        }
    } else {
        // Set default image if no image path exists
        adminimage.setIcon(new ImageIcon(getClass().getResource("/image/default_user.png")));
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        adminimage = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        admindash = new javax.swing.JLabel();
        adinfo = new javax.swing.JLabel();
        delete = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        update = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        totalorders = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ordertable = new javax.swing.JTable();

        jLabel1.setText("jLabel1");

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        adminimage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/newuserprofile.png"))); // NOI18N
        jPanel5.add(adminimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 140));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 170, 140));

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
        jPanel10.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 50, 40));

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 60, 60));

        admindash.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        admindash.setForeground(new java.awt.Color(255, 255, 255));
        admindash.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admindash.setText("ADMIN");
        admindash.setVerifyInputWhenFocusTarget(false);
        jPanel3.add(admindash, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 200, 30));

        adinfo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        adinfo.setForeground(new java.awt.Color(255, 255, 255));
        adinfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adinfo.setText("ID");
        jPanel3.add(adinfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 80, 20));

        delete.setBackground(new java.awt.Color(255, 255, 255));
        delete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteMouseExited(evt);
            }
        });
        delete.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 102, 102));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Delete Order");
        jLabel23.setVerifyInputWhenFocusTarget(false);
        delete.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 140, 30));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cancelorder.png"))); // NOI18N
        delete.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 50, 40));

        jPanel3.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 160, 70));

        update.setBackground(new java.awt.Color(255, 255, 255));
        update.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
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

        jLabel25.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 102, 102));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Update Order");
        jLabel25.setVerifyInputWhenFocusTarget(false);
        update.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 140, 30));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/updateorder.png"))); // NOI18N
        update.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 50, 40));

        jPanel3.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 160, 70));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 600));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/checkgamay.png"))); // NOI18N
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 80, 70));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        totalorders.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        totalorders.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(totalorders, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 30));

        jPanel6.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 80, 30));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 230, 120));

        jPanel7.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 230, 10));

        jLabel24.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 102, 102));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Total Order");
        jLabel24.setVerifyInputWhenFocusTarget(false);
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 230, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 600, 180));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ordertable.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        ordertable.setForeground(new java.awt.Color(0, 102, 102));
        ordertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "User ID", "Order Date", "Order Status", "Cash", "Change"
            }
        ));
        ordertable.setToolTipText("");
        ordertable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ordertableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ordertable);

        jPanel9.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 580, 400));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 600, 420));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
       orderpage or = new orderpage();
       or.setVisible(true);
       this.dispose();
        // Show a confirmation dialog

    }//GEN-LAST:event_jLabel6MouseClicked

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
      orderpage or = new orderpage();
       or.setVisible(true);
       this.dispose();

   
    }//GEN-LAST:event_jPanel10MouseClicked

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

    private void updateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseEntered
        // TODO add your handling code here:
        
        update.setBackground(logcolor);
        
    }//GEN-LAST:event_updateMouseEntered

    private void updateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseExited
        // TODO add your handling code here:
        
         update.setBackground(excolor);
        
    }//GEN-LAST:event_updateMouseExited

    private void deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseEntered
        // TODO add your handling code here:
        
         delete.setBackground(logcolor);
        
    }//GEN-LAST:event_deleteMouseEntered

    private void deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseExited
        // TODO add your handling code here:
         delete.setBackground(excolor);
        
    }//GEN-LAST:event_deleteMouseExited

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
   // Get the selected row
    int selectedRow = ordertable.getSelectedRow();

    // Check if a row is selected
    if (selectedRow < 0) {
        JOptionPane.showMessageDialog(null, "Please select an order to update.");
        return;
    }

    // Get the table model
    TableModel orderTableModel = ordertable.getModel();

    // Get the column indices.  These MUST match your table structure EXACTLY.
    final int ORDER_ID_COLUMN = 0;
    final int USER_ID_COLUMN = 1;
    final int ORDER_DATE_COLUMN = 2;
    final int ORDER_STATUS_COLUMN = 3;
    final int CASH_COLUMN = 4;
    final int CHANGE_COLUMN = 5;
    // There is no PRODUCT_ID_COLUMN in the table shown.
    // There is no ORDER_QUANTITY_COLUMN in the table shown.

    // Get the status of the selected order from the table model
    String status = (String) orderTableModel.getValueAt(selectedRow, ORDER_STATUS_COLUMN);

    // Check if the order status is "Completed" (case-insensitive)
    if ("Complete".equalsIgnoreCase(status)) {
        JOptionPane.showMessageDialog(null, "Cannot update an order that is already Completed.", "Update Not Allowed", JOptionPane.WARNING_MESSAGE);
        return; // Exit the method, preventing the update
    }

    // Get the order ID.
    int orderId = (int) orderTableModel.getValueAt(selectedRow, ORDER_ID_COLUMN);


    // Retrieve order details from the selected row.  Adjusted to match table.
    double cash = (double) orderTableModel.getValueAt(selectedRow, CASH_COLUMN);
    double change = (double) orderTableModel.getValueAt(selectedRow, CHANGE_COLUMN);
    String orderDate = (String) orderTableModel.getValueAt(selectedRow, ORDER_DATE_COLUMN);
    int userId = (int) orderTableModel.getValueAt(selectedRow, USER_ID_COLUMN);
   
    // Create an instance of your UpdateOrderFrame
    updateprocess updateFrame = new updateprocess();

    // Set the values in the UpdateOrderFrame's text fields.  Adjusted to match table.
    updateFrame.orid.setText(String.valueOf(orderId));
    updateFrame.ordate.setText(orderDate);
    updateFrame.orstat.setText(status);
    updateFrame.usercash.setText(String.valueOf(cash));
    updateFrame.userchange.setText(String.valueOf(change));
    //The update frame needs product details. You will need to query the database using orderId
    //to get the product details.

    // Retrieve product details from the database based on orderId.  You'll need to join tables.
    String productQuery = "SELECT p.p_price, p.p_stock, p.p_image, oi.quantity " +
            "FROM product p " +
            "JOIN order_items oi ON p.p_id = oi.product_id " +
            "WHERE oi.order_id = ?";

    try (Connection dbConnection = new dbConnect().getConnection();
         PreparedStatement pstmt = dbConnection.prepareStatement(productQuery)) {
        pstmt.setInt(1, orderId);
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                int productPrice = rs.getInt("p_price");
                int productStock = rs.getInt("p_stock");
                String productImagePath = rs.getString("p_image");
                int orderQuantity = rs.getInt("quantity");

                System.out.println("Product Image Path from Database (in updateorder): [" + productImagePath + "]");

                // Handle null or empty image paths
                if (productImagePath == null || productImagePath.isEmpty()) {
                    System.out.println("Product image path is NULL or EMPTY in the database for order ID: " + orderId);
                    updateFrame.prodimage.setIcon(null);
                } else {
                    try {
                        updateFrame.prodimage.setIcon(updateFrame.ResizeImage(productImagePath, null, updateFrame.prodimage));
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error loading image: " + e.getMessage(), "Image Error", JOptionPane.ERROR_MESSAGE);
                        e.printStackTrace();
                    }
                }
                // Set the values in the UpdateOrderFrame
                updateFrame.prodprice.setText(String.valueOf(productPrice));
                updateFrame.prodquan.setText(String.valueOf(productStock));
                updateFrame.orquantity.setText(String.valueOf(orderQuantity));

                // Calculate and set initial total amount in updateFrame
                double initialTotalAmount = orderQuantity * productPrice;
                updateFrame.totalam.setText(String.valueOf(initialTotalAmount));


                // Make the UpdateOrderFrame visible
                updateFrame.setVisible(true);
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(null, "Product details not found for Order ID: " + orderId, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error retrieving product details: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
    }//GEN-LAST:event_updateMouseClicked

    private void ordertableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ordertableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ordertableMouseClicked

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        // TODO add your handling code here:
        
          int rowIndex = ordertable.getSelectedRow();
    
    if (rowIndex < 0) {
        JOptionPane.showMessageDialog(null, "Please select a product to delete.");
        return;
    }
    
    // Get the product ID from the selected row
    TableModel model = ordertable.getModel();
    int productId = (int) model.getValueAt(rowIndex, 0); // Assuming p_id is in the first column
    
    // Confirmation dialog
    int confirm = JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to delete this product?",
        "Confirm Delete",
        JOptionPane.YES_NO_OPTION
    );
    
    if (confirm == JOptionPane.YES_OPTION) {
        try {
            // Connect to the database
            dbConnect dbc = new dbConnect();
            
            // Prepare the DELETE query
            String query = "DELETE FROM orders WHERE s_id = ?";
            PreparedStatement pstmt = dbc.getConnection().prepareStatement(query);
            pstmt.setInt(1, productId);
            
            // Execute the query
            int rowsDeleted = pstmt.executeUpdate();
            
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(this, "Order deleted successfully.");
                
                // Refresh the table to reflect the changes
              loadMyOrders();
                
                // Update the counts
                
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete the product.");
            }
            
            // Close the statement
            pstmt.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error deleting the product.");
        }
    }
        
    }//GEN-LAST:event_deleteMouseClicked

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
            java.util.logging.Logger.getLogger(updateorder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateorder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateorder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateorder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateorder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adinfo;
    private javax.swing.JLabel admindash;
    private javax.swing.JLabel adminimage;
    private javax.swing.JPanel delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable ordertable;
    private javax.swing.JLabel totalorders;
    private javax.swing.JPanel update;
    // End of variables declaration//GEN-END:variables
}
