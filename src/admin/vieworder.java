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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import java.lang.String;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class vieworder extends javax.swing.JFrame {
  private DefaultTableModel orderItemsTableModel;
    private dbConnect dbConnection;
    /**
     * Creates new form vieworder
     */
public vieworder() {
        initComponents();
     dbConnection = new dbConnect();
        displayAllOrders(); // Call the method to display only pending orders
        
          SearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = searchuser.getText().trim();
                if (!username.isEmpty()) {
                    searchUser(username);
                } else {
                    JOptionPane.showMessageDialog(vieworder.this, "Please enter a user ID.");
                }
            }
        });
        
    }


private void populateProductList(Connection conn, int orderId, JList<String> productList) throws SQLException {
    DefaultListModel<String> listModel = new DefaultListModel<>();
    // 2. Query the "order_items" and "product" tables to get the product details for the order
    String productQuery = "SELECT p.p_name, oi.quantity, oi.price "
            + "FROM order_items oi "
            + "JOIN product p ON oi.product_id = p.p_id "
            + "WHERE oi.order_id = ?";
    try (PreparedStatement productPstmt = conn.prepareStatement(productQuery)) {
        productPstmt.setInt(1, orderId);
        try (ResultSet productRs = productPstmt.executeQuery()) {
            while (productRs.next()) {
                String productName = productRs.getString("p_name");
                int quantity = productRs.getInt("quantity");
                double price = productRs.getDouble("price");

                
                String formattedString = String.format("%-30s %-25d %-25.2f %-25.2f", productName, quantity, price, (quantity * price));
                listModel.addElement(formattedString);
            }
        }
    }
    productList.setModel(listModel); // set the model for the JList
}

//private void populateProductList(Connection conn, int orderId, JList<String> productList) throws SQLException {
//    DefaultListModel<String> listModel = new DefaultListModel<>();
//    // 2. Query the "order_items" and "product" tables to get the product details for the order
//    String productQuery = "SELECT p.p_name, oi.quantity, oi.price "
//            + "FROM order_items oi "
//            + "JOIN product p ON oi.product_id = p.p_id "
//            + "WHERE oi.order_id = ?";
//    try (PreparedStatement productPstmt = conn.prepareStatement(productQuery)) {
//        productPstmt.setInt(1, orderId);
//        try (ResultSet productRs = productPstmt.executeQuery()) {
//            while (productRs.next()) {
//                String productName = productRs.getString("p_name");
//                int quantity = productRs.getInt("quantity");
//                double price = productRs.getDouble("price");
//
//                // Use String.format for better alignment
//                String formattedString = String.format("%-20s %8d %10.2f", productName, quantity, price);
//                listModel.addElement(formattedString);
//            }
//        }
//    }
//    productList.setModel(listModel); // set the model for the JList
//}



public void loadMyOrders(JTable ordersTable, DefaultTableModel ordersTableModel) {
        // Clear existing data in the table
        ordersTableModel.setRowCount(0);

        // Get the logged-in user's ID from the SessionClass
        SessionClass session = SessionClass.getInstance();
        int loggedInUserId = session.getU_id();
        System.out.println("Attempting to load orders for user ID: " + loggedInUserId);

        // Construct the SQL query to get all non-archived orders for the logged-in user
        String sql = "SELECT order_id, order_date, order_status, cash, order_change "
                + "FROM orders "
                + "WHERE u_id = ? AND order_status != 'Archived' " // Exclude archived orders
                + "ORDER BY order_date DESC";

        Connection conn = null; // Declare connection outside the try block
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = dbConnection.getConnection(); // Get connection here
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, loggedInUserId);
            rs = pstmt.executeQuery();
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
            ordersTable.setModel(ordersTableModel);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error loading orders: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            // Close resources in a finally block to ensure they are closed even if an exception occurs
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close(); // Close the connection here
                }
            } catch (SQLException ex) {
                System.err.println("Error closing resources: " + ex.getMessage());
                ex.printStackTrace(); // Log the error, but don't throw an exception here
            }
        }
    }



 // Make sure vieworder is accessible here

    public vieworder(JTable vieworder) {
        this.viewprocess = vieworder;
        vieworder = new JTable(); // Initialize the JTable
vieworder orderDataTransfer = new vieworder(vieworder); // Create OrderDataTransfer instance
    }




 private void logOrderUpdateAction(int userId, String username, int orderId) {
    String sql = "INSERT INTO logs (user_id, act, log_date) VALUES (?, ?, NOW())";

    dbConnect db = new dbConnect();
    try (Connection conn = db.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, userId);
        pstmt.setString(2, "User (" + username + ") updated Order ID: " + orderId);
        pstmt.executeUpdate();

    } catch (SQLException e) {
        System.err.println("Failed to log order update action: " + e.getMessage());
    }
}

private int getCurrentUserId() {
    config.SessionClass ses = config.SessionClass.getInstance();
    return ses.getU_id();
}

private String getCurrentUsername() {
    config.SessionClass ses = config.SessionClass.getInstance();
    return ses.getUsername();
}



private void searchUser(String username) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = dbConnection.getConnection();
            String sql = "SELECT order_id, order_date, order_status, cash, order_change, u_id FROM orders WHERE u_id = ?"; //select from orders
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username); // Use setString to prevent SQL injection
            rs = pstmt.executeQuery();
            viewprocess.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error searching for user: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
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
                JOptionPane.showMessageDialog(this, "Error closing resources: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

  public void displayAllOrders() {
        try {
            dbConnect dbc = new dbConnect();
//            ResultSet rs = dbc.getData("SELECT s_id AS 'Order ID', u_id AS 'User ID', p_id AS 'Product ID', s_quantity AS 'Quantity', s_totalam AS 'Total Amount', s_cash AS 'Cash Given', s_change AS 'Change Amount', s_status AS 'Order Status', s_date AS 'Order Date' FROM process ");
            ResultSet rs = dbc.getData("SELECT order_id AS 'Order ID', u_id AS 'User ID', order_date AS 'Order Date', order_status AS 'Status', cash AS 'Cash', order_change AS 'Change' FROM orders ORDER BY order_id DESC");
            viewprocess.setModel(DbUtils.resultSetToTableModel(rs)); // Assuming your JTable is named 'vieworder'
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Errors: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error displaying data: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
Color logcolor = new Color(63,195,128);
    Color excolor = new Color(0,102,102);
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        viewprocess = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        update = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        print = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        searchuser = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        reset1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("__________________________________________________________");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel2.setForeground(new java.awt.Color(0, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewprocess.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        viewprocess.setForeground(new java.awt.Color(0, 102, 102));
        viewprocess.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(viewprocess);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 680, 380));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 700, 400));

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 150, 10));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jPanel14.setBackground(new java.awt.Color(0, 102, 102));
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel14MouseEntered(evt);
            }
        });
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/images-removebg-preview.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel14.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        jPanel3.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, -1, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("ORDERS OVERVIEW");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 390, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 720, 100));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("RECORDS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 240, 40));

        update.setBackground(new java.awt.Color(0, 102, 102));
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

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("UPDATE STATUS ");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });
        update.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 150, 30));

        jPanel1.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 190, 50));

        print.setBackground(new java.awt.Color(0, 102, 102));
        print.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                printMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                printMouseExited(evt);
            }
        });
        print.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("RECEIPT");
        print.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 20));

        jPanel1.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, 110, 40));

        jLabel21.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 102, 102));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("ORDERS");
        jLabel21.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 140, 30));

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
        jPanel1.add(searchuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 250, 30));

        SearchButton.setBackground(new java.awt.Color(255, 255, 255));
        SearchButton.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        SearchButton.setText("SEARCH");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });
        jPanel1.add(SearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 100, 40));

        reset1.setBackground(new java.awt.Color(0, 102, 102));
        reset1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        reset1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reset1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reset1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reset1MouseExited(evt);
            }
        });
        reset1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("RESET");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });
        reset1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        jPanel1.add(reset1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 110, 50));

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

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:

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

    }//GEN-LAST:event_jLabel9MouseClicked

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked
        // TODO add your handling code here:
        //        admindash order = new admindash();
        //       order.setVisible(true);
        //        this.dispose();

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

    }//GEN-LAST:event_jPanel14MouseClicked

    private void jPanel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel14MouseEntered

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
       
         int selectedRow = viewprocess.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an order to update.", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int orderIdToUpdate = (int) viewprocess.getValueAt(selectedRow, 0);
        String currentOrderStatus = (String) viewprocess.getValueAt(selectedRow, 2); //get order status

        if("Complete".equalsIgnoreCase(currentOrderStatus)){
             JOptionPane.showMessageDialog(this, "Order is already Completed.", "Error", JOptionPane.ERROR_MESSAGE);
             return;
        }

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = dbConnection.getConnection();
            String sql = "UPDATE orders SET order_status = 'Completed' WHERE order_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, orderIdToUpdate);
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Order status updated to Completed.", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadMyOrders(viewprocess, (DefaultTableModel) viewprocess.getModel()); // Refresh the table
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update order status.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error during order status update: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            try {
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
    
    }//GEN-LAST:event_updateMouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        // TODO add your handling code here:
        
        update.setBackground(logcolor);
        
    }//GEN-LAST:event_jLabel4MouseEntered

    private void updateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseEntered
        // TODO add your handling code here:
        
            update.setBackground(logcolor);
    }//GEN-LAST:event_updateMouseEntered

    private void updateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseExited
        // TODO add your handling code here:
        
            update.setBackground(excolor);
        
    }//GEN-LAST:event_updateMouseExited

    private void printMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printMouseEntered
        // TODO add your handling code here:
         print.setBackground(logcolor);
        
    }//GEN-LAST:event_printMouseEntered

    private void printMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printMouseExited
        // TODO add your handling code here:
        
          print.setBackground(excolor);
        
    }//GEN-LAST:event_printMouseExited

    private void printMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printMouseClicked
       int row = viewprocess.getSelectedRow();
    if (row < 0) {
        JOptionPane.showMessageDialog(null, "Please select an order!");
        return;
    }

    Connection conn = null; // Declare connection outside the try block
    try {
        TableModel tbl = viewprocess.getModel();
        int orderId = (int) tbl.getValueAt(row, 0);
        System.out.println("Selected orderId: " + orderId);

        dbConnect dbConnection = new dbConnect(); // Use your dbConnect class
        conn = dbConnection.getConnection();  // Get the connection

        String orderQuery = "SELECT o.order_id, o.order_date, o.cash, o.order_change, o.order_status, u.u_id, u.u_fname, u.u_lname, u.u_contact, u.u_email, u.u_username, u.u_type, u.u_stat "
                + "FROM orders o "
                + "JOIN user u ON o.u_id = u.u_id "
                + "WHERE o.order_id = ?";
        try (PreparedStatement orderPstmt = conn.prepareStatement(orderQuery)) {
            orderPstmt.setInt(1, orderId);
            try (ResultSet orderRs = orderPstmt.executeQuery()) {
                orderprint orderPrintForm = new orderprint(); // Initialize here!

                if (orderRs.next()) {
                    String orderStatus = orderRs.getString("order_status"); // Get the order status
                    if (!"Completed".equalsIgnoreCase(orderStatus)) { // Check if it's "Completed"
                        JOptionPane.showMessageDialog(null, "Cannot print receipt for an order that is not completed.  Order Status: " + orderStatus);
                        return; // Stop processing if not completed
                    }

                    // Populate the orderPrintForm with data from the "orders" and "user" tables
                    orderPrintForm.orid.setText(String.valueOf(orderRs.getInt("order_id")));
                    orderPrintForm.ordate.setText(orderRs.getTimestamp("order_date").toString());
                    orderPrintForm.totalam.setText(String.valueOf(orderRs.getDouble("cash") - orderRs.getDouble("order_change")));
                    orderPrintForm.cash.setText(String.valueOf(orderRs.getDouble("cash")));
                    orderPrintForm.change.setText(String.valueOf(orderRs.getDouble("order_change")));

                    orderPrintForm.cusid.setText(String.valueOf(orderRs.getInt("u_id")));
                    orderPrintForm.fname.setText(orderRs.getString("u_fname"));
                    orderPrintForm.lname.setText(orderRs.getString("u_lname"));
                    orderPrintForm.cuscontact.setText(orderRs.getString("u_contact"));
                    orderPrintForm.cusemail.setText(orderRs.getString("u_email"));
                    orderPrintForm.cususername.setText(orderRs.getString("u_username")); // Corrected variable name.
                    orderPrintForm.custype.setText(orderRs.getString("u_type"));
                    orderPrintForm.cusstatus.setText(orderRs.getString("u_stat"));

                    // Populate the JList in orderPrintForm with product details
                    populateProductList(conn, orderId, orderPrintForm.productlist); // Corrected variable name

                    orderPrintForm.setVisible(true); // Show the orderPrintForm
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Error: Order data not found!");
                    return;
                }
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        ex.printStackTrace();
    } finally {
        // Ensure the connection is closed in the finally block
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Log the error, but don't throw an exception here
            }
        }
    }

    
    }//GEN-LAST:event_printMouseClicked


    
             
    
    
    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        // TODO add your handling code here:
            update.setBackground(excolor);
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        int rowIndex = viewprocess.getSelectedRow();
    if (rowIndex < 0) {
        JOptionPane.showMessageDialog(null, "Please select an order.");
        return;
    }

    // Assuming the order_id is in the first column (index 0) of your viewprocess table
    int orderIdColumnIndex = 0;
    int selectedOrderId = (int) viewprocess.getModel().getValueAt(rowIndex, orderIdColumnIndex);

    // Assuming the 'Status' is in the fourth column (index 3). Adjust if it's different.
    int orderStatusColumnIndex = 3;
    String currentStatusInTable = (String) viewprocess.getModel().getValueAt(rowIndex, orderStatusColumnIndex);

    if (!"Pending".equals(currentStatusInTable)) {
        JOptionPane.showMessageDialog(null, "Only pending orders can be updated to Complete.");
        return;
    }

    try {
        dbConnect db = new dbConnect();
        Connection con = db.getConnection();
        String currentStatusFromDB;

        // Use try-with-resources to ensure resources are closed automatically
        try (PreparedStatement pstmt = con.prepareStatement("SELECT order_status FROM orders WHERE order_id = ?")) {
            pstmt.setInt(1, selectedOrderId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    currentStatusFromDB = rs.getString("order_status");

                    if ("Pending".equals(currentStatusFromDB)) {
                        // Update the status in the database to "Complete"
                        try (PreparedStatement updatePstmt = con.prepareStatement("UPDATE orders SET order_status = 'Completed' WHERE order_id = ?")) {
                            updatePstmt.setInt(1, selectedOrderId);
                            int rowsAffected = updatePstmt.executeUpdate();

                            if (rowsAffected > 0) {
                                // Optionally, update the table model to reflect the change immediately
                                if (orderStatusColumnIndex < viewprocess.getColumnCount()) {
                                    viewprocess.getModel().setValueAt("Completed", rowIndex, orderStatusColumnIndex);
                                }
                                JOptionPane.showMessageDialog(null, "Order status updated to Completed.");
                            } else {
                                JOptionPane.showMessageDialog(null, "Failed to update order status.");
                            }
                        }
                    } else if ("Complete".equals(currentStatusFromDB)) {
                        JOptionPane.showMessageDialog(null, "Order status is already Completed.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Order status is not Pending and cannot be updated.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Could not find order with ID: " + selectedOrderId);
                }
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
    }//GEN-LAST:event_jLabel4MouseClicked

    private void searchuserMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchuserMouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_searchuserMouseReleased

    private void searchuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchuserActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseExited

    private void reset1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reset1MouseClicked
        // TODO add your handling code here:
         loadMyOrders(viewprocess, (DefaultTableModel) viewprocess.getModel());
        
        
    }//GEN-LAST:event_reset1MouseClicked

    private void reset1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reset1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_reset1MouseEntered

    private void reset1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reset1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_reset1MouseExited

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
            java.util.logging.Logger.getLogger(vieworder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vieworder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vieworder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vieworder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vieworder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SearchButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel print;
    private javax.swing.JPanel reset1;
    private javax.swing.JTextField searchuser;
    private javax.swing.JPanel update;
    private javax.swing.JTable viewprocess;
    // End of variables declaration//GEN-END:variables
}
