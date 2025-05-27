/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import USER.customerdashboard;
import USER.employdash;
import static admin.updateuser.getHeightFromWidth;
import config.SessionClass;
import config.dbConnect;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
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
  
 private DefaultTableModel orderItemsTableModel;
    private dbConnect dbConnection; // This instance will hold the single database connection.
 
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

delete.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        deleteMouseClicked(evt);
    }
});
    
}

  public void loadOrderItemsForSelectedOrder(int orderId, JList<String> orderItemsList) {
        DefaultListModel<String> listModel = new DefaultListModel<>();

        // IMPORTANT CHANGE: DO NOT create a new dbConnect instance here.
        // Use the class-level 'dbConnection' instance.
        Connection conn = null; // Declare resources outside try-finally
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = dbConnection.getConnection(); // Get the shared connection from the class-level instance
            
            // Check if connection is null or closed (defensive programming)
            if (conn == null || conn.isClosed()) {
                JOptionPane.showMessageDialog(this, "Database connection is not available for loading order items.", "Connection Error", JOptionPane.ERROR_MESSAGE);
                return; // Exit the method if connection is not usable
            }

            pstmt = conn.prepareStatement(
                    "SELECT oi.order_item_id, p.p_name, oi.quantity, oi.price, oi.item_total "
                    + "FROM order_items oi "
                    + "JOIN product p ON oi.product_id = p.p_id "
                    + "WHERE oi.order_id = ?"
            );
            pstmt.setInt(1, orderId);

            rs = pstmt.executeQuery();
            System.out.println("Successfully retrieved order items for Order ID: " + orderId);

            while (rs.next()) {
                String productName = rs.getString("p_name");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                double itemTotal = rs.getDouble("item_total"); 

                String itemDetails = String.format("Item:%-20s Qty:%-4d Price:%-10.2f Total:%.2f", 
                                                   productName, quantity, price, itemTotal);
                listModel.addElement(itemDetails);
            }
            orderItemsList.setModel(listModel);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading order items: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            // CRITICAL: Close ResultSet and PreparedStatement manually
            // DO NOT close 'conn' here, as it's the shared connection from dbConnection
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing ResultSet in loadOrderItemsForSelectedOrder: " + e.getMessage());
                e.printStackTrace();
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing PreparedStatement in loadOrderItemsForSelectedOrder: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }




    private void deleteOrder(int orderId) {
        // Use the class-level dbConnection instance to get a connection
        Connection con = null; // Declare outside try-finally
        PreparedStatement pstmt = null;

        try {
            con = dbConnection.getConnection(); // Get the shared connection
            // Check if connection is null or closed
            if (con == null || con.isClosed()) {
                JOptionPane.showMessageDialog(this, "Database connection is not available for deleting order.", "Connection Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String sql = "UPDATE orders SET order_status = 'Archived' WHERE order_id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, orderId);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                // REMOVED: JOptionPane.showMessageDialog(this, "Order archived successfully.");
                loadMyOrders(ordertable, (DefaultTableModel) ordertable.getModel());
            } else {
                JOptionPane.showMessageDialog(this, "Failed to archive the order.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error archiving order: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(this, "An unexpected error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            // CRITICAL: Manually close PreparedStatement
            // DO NOT close 'con' here
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing PreparedStatement in deleteOrder: " + e.getMessage());
                e.printStackTrace();
            }
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
        ordersTableModel.setRowCount(0); // Clear existing data in the table

        SessionClass session = SessionClass.getInstance();
        int loggedInUserId = session.getU_id();
        System.out.println("Attempting to load orders for user ID: " + loggedInUserId);

        String sql = "SELECT order_id, order_date, order_status, cash, order_change " +
                "FROM orders " +
                "WHERE u_id = ? AND order_status != 'Archived' " + 
                "ORDER BY order_date DESC";

        Connection conn = null; // Declare resources outside try-finally
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = dbConnection.getConnection(); // Get the shared class-level connection
            if (conn == null || conn.isClosed()) {
                JOptionPane.showMessageDialog(this, "Database connection is not available for loading orders.", "Connection Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, loggedInUserId);

            rs = pstmt.executeQuery();
            System.out.println("Query executed successfully for loadMyOrders.");

            int rowCount = 0;
            while (rs.next()) {
                rowCount++;
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

            ordersTable.setModel(ordersTableModel);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error loading orders: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            // CRITICAL: Manually close ResultSet and PreparedStatement
            // DO NOT close 'conn' here
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing ResultSet in loadMyOrders: " + e.getMessage());
                e.printStackTrace();
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing PreparedStatement in loadMyOrders: " + e.getMessage());
                e.printStackTrace();
            }
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
        backtoorderpage = new javax.swing.JPanel();
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
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        totallist = new javax.swing.JList<>();

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

        backtoorderpage.setBackground(new java.awt.Color(0, 102, 102));
        backtoorderpage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backtoorderpageMouseClicked(evt);
            }
        });
        backtoorderpage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/images-removebg-preview.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        backtoorderpage.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 50, 40));

        jPanel3.add(backtoorderpage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 60, 60));

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

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 640));

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

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 540, 90));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 840, 140));

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

        jPanel9.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 420, 460));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Orders");
        jPanel9.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        jPanel6.setBackground(new java.awt.Color(0, 102, 102));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        totallist.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Order Item ID", "Product name", "Quantity", "Price", "Total Amount" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(totallist);

        jPanel7.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 350, 440));

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 370, 460));

        jPanel9.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 390, 480));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 840, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1061, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
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

    }//GEN-LAST:event_jLabel6MouseClicked

    private void backtoorderpageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backtoorderpageMouseClicked
    
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
   
    }//GEN-LAST:event_backtoorderpageMouseClicked

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
 // Get the selected row from the orders table (ordertable)
    int selectedRow = ordertable.getSelectedRow();

    // Check if a row is selected
    if (selectedRow < 0) {
        JOptionPane.showMessageDialog(this, "Please select an order to view items.", "Information", JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    // Get the order_id from the selected row (assuming it's in the first column)
    int selectedOrderId = (int) ordertable.getValueAt(selectedRow, 0);

    // Load the items for the selected order into the JList (totallist)
    loadOrderItemsForSelectedOrder(selectedOrderId, totallist); // Changed to totallist
    }//GEN-LAST:event_updateMouseClicked

    private void ordertableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ordertableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ordertableMouseClicked

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
      
   int selectedRow = ordertable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Deleted.", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int orderIdToDelete = (int) ordertable.getValueAt(selectedRow, 0);
        String orderStatus = (String) ordertable.getValueAt(selectedRow, 2);

        if ("Pending".equalsIgnoreCase(orderStatus)) {
            JOptionPane.showMessageDialog(this, "Cannot delete orders with Pending status.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
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
    private javax.swing.JPanel backtoorderpage;
    public javax.swing.JPanel delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JToolBar jToolBar1;
    public javax.swing.JTable ordertable;
    private javax.swing.JList<String> totallist;
    public javax.swing.JPanel update;
    // End of variables declaration//GEN-END:variables
}
