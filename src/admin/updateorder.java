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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import lores.LOGIN;

/**
 *
 * @author Admin
 */
public class updateorder extends javax.swing.JFrame {
  

 
    /**
     * Creates new form updateorder
     */
public updateorder() {
    initComponents();
        dbConnection = new dbConnect(); 
        orderItemsTableModel = (DefaultTableModel) ordertable.getModel();
        loadMyOrders(ordertable, orderItemsTableModel);
        displayUserImage(adminimage);
//        displayTotalOrders(); 
    
}


   private DefaultTableModel orderItemsTableModel;
    private dbConnect dbConnection;
  private void deleteOrder(int orderId) {
        String sql = "UPDATE orders SET order_status = 'Archived' WHERE order_id = ?";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, orderId);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Order archived successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadMyOrders(ordertable, (DefaultTableModel) ordertable.getModel()); // Refresh the table

            } else {
                JOptionPane.showMessageDialog(this, "Failed to archive the order.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            System.err.println("Error archiving order: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Database error during order archiving.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

//private void displayTotalOrders() {
//        SessionClass session = SessionClass.getInstance();
//        int loggedInUserId = session.getU_id();
//
//        String sql = "SELECT COUNT(*) AS total_orders FROM orders WHERE u_id = ?";
//        try (Connection conn = dbConnection.getConnection(); // Use the class-level dbConnection
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//
//            pstmt.setInt(1, loggedInUserId);
//            ResultSet rs = pstmt.executeQuery();
//
//            if (rs.next()) {
//                int totalOrdersCount = rs.getInt("total_orders");
//                totalorder.setText(String.valueOf(totalOrdersCount));
//            } else {
//                totalorder.setText("0");
//            }
//            rs.close();
//
//        } catch (SQLException ex) {
//            System.err.println("Error getting total orders: " + ex.getMessage());
//            JOptionPane.showMessageDialog(this, "Error retrieving total orders.", "Database Error", JOptionPane.ERROR_MESSAGE);
//            totalorder.setText("Error");
//        } 
//    }

// public void displayTotalOrderAmount() {
//    dbConnect dbc = new dbConnect();
//    double totalAmount = 0.0;
//
//    SessionClass session = SessionClass.getInstance(); // Assuming order_id is in the session
//    int currentOrderId = session.getOrder_id(); // Get the current order ID
//
//    try {
//        String query = "SELECT SUM(item_total) AS total FROM order_items WHERE order_id = " + currentOrderId;
//        ResultSet rs = dbc.getData(query);
//
//        if (rs.next()) {
//            totalAmount = rs.getDouble("total");
//        }
//        rs.close();
//
//   totalam.setText(String.format("%.2f", totalAmount)); // Assuming 'totalAmountField' is your JTextField
//
//    } catch (SQLException ex) {
//        System.out.println("Error calculating total order amount: " + ex.getMessage());
//        ex.printStackTrace();
//    } finally {
//        try {
//            if (dbc.getConnection() != null) {
//                dbc.getConnection().close();
//            }
//        } catch (SQLException ex) {
//            System.err.println("Error closing database connection: " + ex.getMessage());
//        }
//    }
//}
    
    
    public void loadOrderItems() {
    dbConnect dbc = new dbConnect();
    DefaultTableModel model = (DefaultTableModel) ordertable.getModel(); // Assuming 'ordertable' is your JTable 
    model.setRowCount(0); // Clear existing rows

    SessionClass session = SessionClass.getInstance(); // Assuming order_id is in the session
    int currentOrderId = session.getOrder_id(); // Get the current order ID

    try {
        String query = "SELECT oi.order_item_id, p.p_name, oi.quantity, oi.price, oi.item_total " +
                       "FROM order_items oi " +
                       "JOIN product p ON oi.product_id = p.p_id " +
                       "WHERE oi.order_id = " + currentOrderId;

        ResultSet rs = dbc.getData(query);

        while (rs.next()) {
            int orderItemId = rs.getInt("order_item_id");
            String productName = rs.getString("p_name");
            int quantity = rs.getInt("quantity");
            double price = rs.getDouble("price");
            double itemTotal = rs.getDouble("item_total");
            model.addRow(new Object[]{orderItemId, productName, quantity, price, itemTotal});
        }
        rs.close();

    } catch (SQLException ex) {
        System.out.println("Error loading ordered items: " + ex.getMessage());
        JOptionPane.showMessageDialog(this, "Error loading ordered items.", "Database Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    } finally {
        try {
            if (dbc.getConnection() != null) {
                dbc.getConnection().close();
            }
        } catch (SQLException ex) {
            System.err.println("Error closing database connection: " + ex.getMessage());
        }
    }
}

   public void loadMyOrders(JTable ordersTable, DefaultTableModel ordersTableModel) {
        // Clear existing data in the table
        ordersTableModel.setRowCount(0);

        // Get the logged-in user's ID from the SessionClass
        SessionClass session = SessionClass.getInstance();
        int loggedInUserId = session.getU_id();
        System.out.println("Attempting to load orders for user ID: " + loggedInUserId);

        // Construct the SQL query to get all non-archived orders for the logged-in user
        String sql = "SELECT order_id, order_date, order_status, cash, order_change " +
                "FROM orders " +
                "WHERE u_id = ? AND order_status != 'Archived' " + // Exclude archived orders
                "ORDER BY order_date DESC";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, loggedInUserId);

            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("Query executed successfully.");

                // Populate the table model with the retrieved data
                int rowCount = 0;
                while (rs.next()) {
                    rowCount++;
                    System.out.println("Row " + rowCount + " found - Order ID: " + rs.getInt("order_id") + ", Order Date: " + rs.getTimestamp("order_date"));

                    Object[] rowData = {
                            rs.getInt("order_id"),
                            rs.getTimestamp("order_date"),
                            rs.getString("order_status"),
                            rs.getDouble("cash"),
                            rs.getDouble("order_change")
                    };
                    ordersTableModel.addRow(rowData);
                }
                System.out.println("Total orders loaded: " + rowCount);

                // Set the table model for the JTable
                ordersTable.setModel(ordersTableModel);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error loading orders: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ordertable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        orderitem = new javax.swing.JTable();

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
        jLabel25.setText("View Order");
        jLabel25.setVerifyInputWhenFocusTarget(false);
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });
        update.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 140, 30));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/updateorder.png"))); // NOI18N
        update.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 50, 40));

        jPanel3.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 160, 70));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 600));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Segoe UI Black", 1, 48)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("TOTAL ORDERS");
        jLabel24.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 460, 70));

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 540, 90));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 600, 180));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ordertable.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        ordertable.setForeground(new java.awt.Color(0, 102, 102));
        ordertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Order Date", "Order Status", "Cash", "Change"
            }
        ));
        ordertable.setToolTipText("");
        ordertable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ordertableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ordertable);

        jPanel9.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 580, 180));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ORDERED ITEMS");
        jPanel9.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("PRODUCTS");
        jPanel9.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        orderitem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Order Item ID", "Product Name", "Quantity", "Price", "Total Amount"
            }
        ));
        jScrollPane3.setViewportView(orderitem);

        jPanel9.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 580, 170));

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
     // TODO add your handling code here:
        
         // Get the selected row from the orders table (ordertable)
    int selectedRow = ordertable.getSelectedRow();

    // Check if a row is selected
    if (selectedRow < 0) {
        JOptionPane.showMessageDialog(this, "Please select an order to view items.", "Information", JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    // Get the order_id from the selected row (assuming it's in the first column)
    int selectedOrderId = (int) ordertable.getValueAt(selectedRow, 0);

    // Load the items for the selected order into the orderitem table
    loadOrderItemsForSelectedOrder(selectedOrderId, orderitem);
}

public void loadOrderItemsForSelectedOrder(int orderId, JTable orderItemsTable) {
    // Clear existing data in the order items table
    DefaultTableModel model = (DefaultTableModel) orderItemsTable.getModel();
    model.setRowCount(0);

    dbConnect dbConnection = new dbConnect();

    try (Connection conn = dbConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(
                 "SELECT oi.order_item_id, p.p_name, oi.quantity, oi.price, oi.item_total " +
                 "FROM order_items oi " +
                 "JOIN product p ON oi.product_id = p.p_id " +
                 "WHERE oi.order_id = ?"
         )) {

        pstmt.setInt(1, orderId);

        try (ResultSet rs = pstmt.executeQuery()) {
            System.out.println("Successfully retrieved order items for Order ID: " + orderId);

            while (rs.next()) {
                Object[] rowData = {
                        rs.getInt("order_item_id"),
                        rs.getString("p_name"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"),
                        rs.getDouble("item_total")
                };
                model.addRow(rowData);
            }
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error loading order items: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
    }//GEN-LAST:event_updateMouseClicked

    private void ordertableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ordertableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ordertableMouseClicked

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
      
      int selectedRow = ordertable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an order to delete.", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int orderIdToDelete = (int) ordertable.getValueAt(selectedRow, 0);
        String orderStatus = (String) ordertable.getValueAt(selectedRow, 2); // Get the order status (assuming it's the 3rd column)

        if ("Pending".equalsIgnoreCase(orderStatus)) {
            JOptionPane.showMessageDialog(this, "Cannot delete orders with Pending status.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Stop the deletion process
        }
        deleteOrder(orderIdToDelete);

    
    }//GEN-LAST:event_deleteMouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
    
    }//GEN-LAST:event_jLabel25MouseClicked

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
    public javax.swing.JPanel delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable orderitem;
    public javax.swing.JTable ordertable;
    public javax.swing.JPanel update;
    // End of variables declaration//GEN-END:variables
}
