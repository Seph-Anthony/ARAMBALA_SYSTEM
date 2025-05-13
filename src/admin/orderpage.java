/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import USER.customerdashboard;
import USER.employdash;
import config.dbConnect;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import config.SessionClass;
import java.awt.Window;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Admin
 */
public class orderpage extends javax.swing.JFrame {
 private int p_id;
private int order_id;
     private Integer currentOrderId = null;
private dbConnect dbConnection;
    
    /**
     * Creates new form orderpage
     */
    public orderpage() {
        initComponents();
        dbConnection = new dbConnect();
        displayfood();
        Allpersonal();
        Allsupplies();
        Allhousehold();
        Allbeverage();
 showdata();
         displayOrderTotal();
        
//        displaypersonal();
//        displayhouse();
//        displaysupplies();
    }
    Color logcolorx = new Color(63,195,128);
    Color excolorx = new Color(255,255,255);
     dbConnect db = new dbConnect();
     
      public void reloadOrderPageData(int orderId) {
        if (orderId != currentOrderId) {
            currentOrderId = orderId; //update the order id
        }
        loadOrderedItems(orderId, orderitem);  // Load data based on orderId
        displayOrderTotal();
    }
      
       public void setCurrentOrderId(int orderId) {
        this.currentOrderId = orderId;
    }
     
 private void logOrderAction(int orderId, double cashAmount, double changeAmount) {
    Connection conn = null;
    PreparedStatement pstmt = null;
    SessionClass session = SessionClass.getInstance();
    int userId = session.getU_id(); // Get the user ID
    String username = session.getUsername();

    try {
        conn = db.getConnection(); // Use the instance db to get the connection
        String sql = "INSERT INTO logs (user_id, act, log_date) VALUES (?, ?, NOW())";
        pstmt = conn.prepareStatement(sql);

        // Shorten the activity string
        String activity = username + " completed order #" + orderId;
        pstmt.setInt(1, userId);
        pstmt.setString(2, activity);
        pstmt.executeUpdate();

    } catch (SQLException e) {
        System.err.println("Failed to log order action: " + e.getMessage());
    } finally {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.err.println("Error closing resources: " + e.getMessage());
        }
    }
} 
    
   
  public void loadOrderedItems(int orderId, JTable orderitem) {
    dbConnect dbc = new dbConnect();
    DefaultTableModel model = (DefaultTableModel) orderitem.getModel();
    model.setRowCount(0); // Clear existing rows

    try {
        String query = "SELECT oi.order_item_id, p.p_name, oi.quantity, oi.price, oi.item_total " + // Added oi.order_item_id
                       "FROM order_items oi " +
                       "JOIN product p ON oi.product_id = p.p_id " +
                       "WHERE oi.order_id = " + orderId;

        ResultSet rs = dbc.getData(query);

        while (rs.next()) {
            int orderItemId = rs.getInt("order_item_id"); // Retrieve order_item_id
            String productName = rs.getString("p_name");
            int quantity = rs.getInt("quantity");
            double price = rs.getDouble("price");
            double itemTotal = rs.getDouble("item_total");
            model.addRow(new Object[]{orderItemId, productName, quantity, price, itemTotal}); // Add it to the row
        }
        rs.close();

    } catch (SQLException ex) {
        System.out.println("Errors loading ordered items: " + ex.getMessage());
        JOptionPane.showMessageDialog(this, "Error loading ordered items.", "Database Error", JOptionPane.ERROR_MESSAGE);
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
    
public void displayOrderTotal() {
    dbConnect db = new dbConnect();
    double total = 0.0;
    SessionClass session = SessionClass.getInstance();
    int currentOrderId = session.getOrder_id();

    try {
        String query = "SELECT SUM(item_total) AS item_total FROM order_items WHERE order_id = " + currentOrderId;
        ResultSet rs = db.getData(query);

        if (rs.next()) {
            total = rs.getDouble("item_total");
        }
        rs.close();

    } catch (SQLException ex) {
        System.err.println("Error calculating order total: " + ex.getMessage());
        JOptionPane.showMessageDialog(this, "Error calculating order total.", "Database Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (db.getConnection() != null) {
                db.getConnection().close();
            }
        } catch (SQLException ex) {
            System.err.println("Error closing database connection: " + ex.getMessage());
        }
    }

    totalamount.setText(String.format("%.2f", total));
}

    
private int generateNewOrderId() {
    int newId = 1; // Default value
    dbConnect db = new dbConnect(); // Use your existing dbConnect class
    ResultSet rs = null;
    
    try {
        String sql = "SELECT MAX(order_id) FROM orders"; // Make sure 'orders' is your actual table name
        rs = db.getData(sql);
        
        if (rs.next()) {
            newId = rs.getInt(1) + 1; // Get max ID and add 1
        }
    } catch (SQLException e) {
        System.out.println("Error generating new Order ID: " + e.getMessage());
    } finally {
        try { 
            if (rs != null) rs.close(); 
        } catch (SQLException e) {
            System.out.println("Error closing ResultSet: " + e.getMessage());
        }
    }
    
    return newId;
}
   
    public void showdata(){
        try{
            dbConnect dbc = new dbConnect();
            ResultSet rs = dbc.getData("SELECT p_id AS 'Product ID', " +
                       "p_name AS 'Product Name', " +
                       "p_category AS 'Category', " +
                       "p_brand AS 'Brand', " +
                       "p_price AS 'Price', " +
                       "p_stock AS 'Stock', " +
                       "p_status AS 'Status' " +
                       "FROM product");
            food.setModel(DbUtils.resultSetToTableModel(rs));
             rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        
        }
        
    }
    
    public void Allpersonal() {
    try {
        // Connect to the database
        dbConnect dbc = new dbConnect();
        
        // Query to get the total number of users
        ResultSet rs = dbc.getData("SELECT COUNT(*) AS totalprod FROM product WHERE p_category = 'Personal Wellness' ");
        
        if (rs.next()) {
            // Retrieve the total count from the query result
            int totalUsers = rs.getInt("totalprod");
            
            // Assuming you have a JLabel named lblTotalUsers to display the count
            personal.setText(" " + totalUsers);
        }
        
        // Close the ResultSet
        rs.close();
        
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
    }
}
      
    public void Allsupplies() {
    try {
        // Connect to the database
        dbConnect dbc = new dbConnect();
        
        // Query to get the total number of users
        ResultSet rs = dbc.getData("SELECT COUNT(*) AS totalprod FROM product WHERE p_category = 'Supplies Utilities' ");
        
        if (rs.next()) {
            // Retrieve the total count from the query result
            int totalUsers = rs.getInt("totalprod");
            
            // Assuming you have a JLabel named lblTotalUsers to display the count
            supplies.setText(" " + totalUsers);
        }
        
        // Close the ResultSet
        rs.close();
        
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
    }
}
    
      
    public void Allhousehold() {
    try {
        // Connect to the database
        dbConnect dbc = new dbConnect();
        
        // Query to get the total number of users
        ResultSet rs = dbc.getData("SELECT COUNT(*) AS totalprod FROM product WHERE p_category = 'Household Essentials' ");
        
        if (rs.next()) {
            // Retrieve the total count from the query result
            int totalUsers = rs.getInt("totalprod");
            
            // Assuming you have a JLabel named lblTotalUsers to display the count
            household.setText(" " + totalUsers);
        }
        
        // Close the ResultSet
        rs.close();
        
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
    }
}
    
      
    public void Allbeverage() {
    try {
        // Connect to the database
        dbConnect dbc = new dbConnect();
        
        // Query to get the total number of users
        ResultSet rs = dbc.getData("SELECT COUNT(*) AS totalprod FROM product WHERE p_category = 'Food and Beverage' ");
        
        if (rs.next()) {
            // Retrieve the total count from the query result
            int totalUsers = rs.getInt("totalprod");
            
            // Assuming you have a JLabel named lblTotalUsers to display the count
            beverage.setText(" " + totalUsers);
        }
        
        // Close the ResultSet
        rs.close();
        
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
    }
}
    
     Color logcolor = new Color(63,195,128);
    Color excolor = new Color(0,102,102);
//    private void customizeTableColumns(JTable food) {
//    food.getColumnModel().getColumn(0).setHeaderValue("Product Name");
//    food.getColumnModel().getColumn(1).setHeaderValue("Category");
//    food.getColumnModel().getColumn(2).setHeaderValue("Brand");
//    food.getColumnModel().getColumn(3).setHeaderValue("Price");
//    food.getColumnModel().getColumn(4).setHeaderValue("Stock");
//    food.getTableHeader().repaint(); // Refresh the header to show changes
//  
//}
            

    
    
    
    public void displayfood(){
    try{
        dbConnect dbc = new dbConnect();
        ResultSet rs = dbc.getData("SELECT p_id AS 'Product ID', p_name AS 'Product Name', p_brand AS 'Brand', p_price AS 'Price', p_stock AS 'Stock', p_category, p_image AS 'Image' FROM product WHERE p_status = 'Available'");
        food.setModel(DbUtils.resultSetToTableModel(rs));
        rs.close();
    } catch(SQLException ex) {
        System.out.println("Errors: "+ex.getMessage());
    }
}
    
//     public void displaypersonal(){
//        try{
//            dbConnect dbc = new dbConnect();
//             ResultSet rs = dbc.getData("SELECT p_name AS 'Product Name', p_brand AS 'Brand', p_price AS 'Price', p_stock AS 'Stock' FROM product WHERE p_category = 'Personal Wellness' AND p_status = 'Available'");
//            personal.setModel(DbUtils.resultSetToTableModel(rs));
//             rs.close();
//        }catch(SQLException ex){
//            System.out.println("Errors: "+ex.getMessage());
//        
//        }
//        
//    }
//
//      public void displayhouse(){
//        try{
//            dbConnect dbc = new dbConnect();
//   ResultSet rs = dbc.getData("SELECT p_name AS 'Product Name', p_brand AS 'Brand', p_price AS 'Price', p_stock AS 'Stock' FROM product WHERE p_category = 'Household Essentials' AND p_status = 'Available'");
//            house.setModel(DbUtils.resultSetToTableModel(rs));
//             rs.close();
//        }catch(SQLException ex){
//            System.out.println("Errors: "+ex.getMessage());
//        
//        }
//        
//    }
//      
//       public void displaysupplies(){
//        try{
//            dbConnect dbc = new dbConnect();
//    ResultSet rs = dbc.getData("SELECT p_name AS 'Product Name', p_brand AS 'Brand', p_price AS 'Price', p_stock AS 'Stock' FROM product WHERE p_category = 'Supplies Utilities' AND p_status = 'Available'");
//            supplies.setModel(DbUtils.resultSetToTableModel(rs));
//             rs.close();
//        }catch(SQLException ex){
//            System.out.println("Errors: "+ex.getMessage());
//        
//        }
//        
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        food = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderitem = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        addorder = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        entercash = new javax.swing.JTextField();
        totalamount = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        ADDORDER = new javax.swing.JPanel();
        ADDORDER3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        personal = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        household = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        beverage = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        supplies = new javax.swing.JLabel();
        reset = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        edit = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        backbutton = new javax.swing.JLabel();
        foodand = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        householdni = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        suppliesni = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        personalwell = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jLabel6.setText("jLabel6");

        jToggleButton1.setText("jToggleButton1");

        jLabel4.setText("jLabel4");

        jRadioButton1.setText("jRadioButton1");

        jButton1.setText("jButton1");

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        food.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        food.setForeground(new java.awt.Color(0, 102, 102));
        food.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(food);

        jPanel10.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 510, 450));

        orderitem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Product Name", "Product Name", "Quantity", "Price", "Total Amount"
            }
        ));
        jScrollPane1.setViewportView(orderitem);

        jPanel10.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 380, 320));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("PRODUCTS");
        jPanel10.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, -1));

        jLabel27.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 102, 102));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Total Amount");
        jPanel10.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 350, 110, -1));

        jLabel28.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 102, 102));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("ORDERED ITEMS");
        jPanel10.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 120, -1));

        addorder.setBackground(new java.awt.Color(0, 102, 102));
        addorder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        addorder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addorderMouseClicked(evt);
            }
        });
        addorder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("ADD ORDER");
        addorder.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, -1));

        jPanel10.add(addorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 430, 140, 40));

        entercash.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        entercash.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        entercash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entercashActionPerformed(evt);
            }
        });
        jPanel10.add(entercash, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, 120, 40));

        totalamount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totalamount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalamount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        totalamount.setEnabled(false);
        jPanel10.add(totalamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 370, 110, 40));

        jLabel29.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 102, 102));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Enter cash");
        jPanel10.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 350, 120, -1));

        jPanel8.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 920, 490));

        ADDORDER.setBackground(new java.awt.Color(0, 102, 102));
        ADDORDER.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        ADDORDER.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADDORDERMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ADDORDERMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ADDORDERMouseExited(evt);
            }
        });
        ADDORDER.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ADDORDER3.setBackground(new java.awt.Color(0, 102, 102));
        ADDORDER3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        ADDORDER3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ADDORDER3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ADDORDER3MouseExited(evt);
            }
        });
        ADDORDER3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ADD ORDER");
        ADDORDER3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 20));

        ADDORDER.add(ADDORDER3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 560, 120, 40));

        jLabel24.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("ADD ITEM");
        ADDORDER.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 20));

        jPanel8.add(ADDORDER, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 150, 40));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/medicinegamay.png"))); // NOI18N
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 70));

        personal.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        personal.setForeground(new java.awt.Color(0, 102, 102));
        personal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        personal.setToolTipText("");
        personal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel2.add(personal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 90, 50));

        jPanel8.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 150, 140));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cleaninggamay.png"))); // NOI18N
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 70));

        household.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        household.setForeground(new java.awt.Color(0, 102, 102));
        household.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        household.setToolTipText("");
        household.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel6.add(household, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 90, 50));

        jPanel8.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 150, 140));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/foodgamay.png"))); // NOI18N
        jPanel11.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 70));

        beverage.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        beverage.setForeground(new java.awt.Color(0, 102, 102));
        beverage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        beverage.setToolTipText("");
        beverage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel11.add(beverage, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 90, 50));

        jPanel8.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 150, 140));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/suppliesgamay.png"))); // NOI18N
        jPanel13.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 70));

        supplies.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        supplies.setForeground(new java.awt.Color(0, 102, 102));
        supplies.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        supplies.setToolTipText("");
        supplies.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel13.add(supplies, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 90, 50));

        jPanel8.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 150, 140));

        reset.setBackground(new java.awt.Color(0, 102, 102));
        reset.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                resetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                resetMouseExited(evt);
            }
        });
        reset.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RESET");
        reset.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 20));

        jPanel8.add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 150, 40));

        edit.setBackground(new java.awt.Color(0, 102, 102));
        edit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editMouseClicked(evt);
            }
        });
        edit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("EDIT QUANTITY");
        edit.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel8.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, 150, 40));

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DELETE ORDER");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        jPanel8.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(754, 170, 170, 40));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, -10, 940, 720));

        jPanel12.setBackground(new java.awt.Color(0, 102, 102));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(0, 102, 102));
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel14MouseClicked(evt);
            }
        });
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backbutton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/images-removebg-preview.png"))); // NOI18N
        backbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backbuttonMouseClicked(evt);
            }
        });
        jPanel14.add(backbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 40));

        jPanel12.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, 60, 60));

        foodand.setBackground(new java.awt.Color(255, 255, 255));
        foodand.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        foodand.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                foodandMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                foodandMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                foodandMouseExited(evt);
            }
        });
        foodand.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 102));
        jLabel14.setText("Food and Beverage");
        jLabel14.setFocusTraversalPolicyProvider(true);
        foodand.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 150, -1));

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/food35.png"))); // NOI18N
        foodand.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 110, 40));

        jPanel12.add(foodand, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 170, 70));

        householdni.setBackground(new java.awt.Color(255, 255, 255));
        householdni.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        householdni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                householdniMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                householdniMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                householdniMouseExited(evt);
            }
        });
        householdni.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 102));
        jLabel15.setText("Household Essentials");
        jLabel15.setFocusTraversalPolicyProvider(true);
        householdni.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 150, -1));

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/clean35.png"))); // NOI18N
        householdni.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 110, 40));

        jPanel12.add(householdni, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 170, 70));

        suppliesni.setBackground(new java.awt.Color(255, 255, 255));
        suppliesni.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        suppliesni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                suppliesniMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                suppliesniMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                suppliesniMouseExited(evt);
            }
        });
        suppliesni.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Supplies Utilities");
        jLabel13.setFocusTraversalPolicyProvider(true);
        suppliesni.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 150, -1));

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/supplies35.png"))); // NOI18N
        suppliesni.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 100, 40));

        jPanel12.add(suppliesni, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 170, 70));

        personalwell.setBackground(new java.awt.Color(255, 255, 255));
        personalwell.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        personalwell.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                personalwellMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                personalwellMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                personalwellMouseExited(evt);
            }
        });
        personalwell.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 102));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Personal Wellness");
        jLabel16.setFocusTraversalPolicyProvider(true);
        personalwell.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 150, -1));

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/medicine35.png"))); // NOI18N
        personalwell.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 100, 40));

        jPanel12.add(personalwell, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 170, 70));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/checkgamay.png"))); // NOI18N
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 80, 80));

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Order Page");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 170, 40));

        jPanel12.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, 170));

        jPanel1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 710));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
  
    private void backbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backbuttonMouseClicked
     SessionClass session = SessionClass.getInstance();
    String userType = session.getType();
    int currentOrderId = session.getOrder_id();

    if (userType != null) {
        dbConnect db = new dbConnect();

        // Check if there's a current order ID
        if (currentOrderId != 0) {
            // First, delete any associated items in order_items
            String deleteOrderItemsSQL = "DELETE FROM order_items WHERE order_id = " + currentOrderId;
            try {
                int itemsDeleted = db.insertData(deleteOrderItemsSQL);
                System.out.println(itemsDeleted + " order items deleted for Order ID: " + currentOrderId);
            } catch (Exception ex) {
                System.err.println("Error deleting order items: " + ex.getMessage());
                JOptionPane.showMessageDialog(this, "Error deleting added items.", "Database Error", JOptionPane.ERROR_MESSAGE);
                return; // Stop further processing if deleting items fails
            }

            // Now, check the orders table for the current order_id and conditions to delete
            String checkOrderSQL = "SELECT cash, order_change FROM orders WHERE order_id = " + currentOrderId;
            try (java.sql.ResultSet rs = db.getData(checkOrderSQL)) {
                if (rs.next()) {
                    double cash = rs.getDouble("cash");
                    double change = rs.getDouble("order_change");

                    // If cash and change are both 0.00, or if cash is 0.00 (meaning likely no payment processed)
                    if ((cash == 0.00 && change == 0.00) || cash == 0.00) {
                        String deleteOrderSQL = "DELETE FROM orders WHERE order_id = " + currentOrderId;
                        int orderDeleted = db.insertData(deleteOrderSQL);
                        if (orderDeleted > 0) {
                            System.out.println("Order ID " + currentOrderId + " deleted due to no value.");
                        } else {
                            System.out.println("Order ID " + currentOrderId + " not deleted (condition not met or error).");
                        }
                    } else {
                        System.out.println("Order ID " + currentOrderId + " not deleted as cash or change has a value.");
                    }
                } else {
                    System.out.println("Order ID " + currentOrderId + " not found in orders table.");
                }
            } catch (SQLException ex) {
                System.err.println("Error checking order details: " + ex.getMessage());
                JOptionPane.showMessageDialog(this, "Error checking order details.", "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.out.println("No active Order ID to check for deletion.");
        }

        // Reset the order_id in the session
        session.setOrder_id(0);
        System.out.println("Order ID reset.");

        try {
            if (db.getConnection() != null) {
                db.getConnection().close();
            }
        } catch (SQLException ex) {
            System.err.println("Error closing database connection: " + ex.getMessage());
        }

        switch (userType) {
            case "Admin":
                new admindash().setVisible(true);
                break;
            case "Customer":
                new customerdashboard().setVisible(true);
                break;
            case "Employee":
                new employdash().setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Unrecognized user type");
        }

        this.dispose();
    } else {
        JOptionPane.showMessageDialog(null, "No account login first");
        this.dispose();
    }
    }//GEN-LAST:event_backbuttonMouseClicked

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked
       SessionClass session = SessionClass.getInstance();
    String userType = session.getType();
    int currentOrderId = session.getOrder_id();

    if (userType != null) {
        dbConnect db = new dbConnect();

        // Check if there's a current order ID
        if (currentOrderId != 0) {
            // First, delete any associated items in order_items
            String deleteOrderItemsSQL = "DELETE FROM order_items WHERE order_id = " + currentOrderId;
            try {
                int itemsDeleted = db.insertData(deleteOrderItemsSQL);
                System.out.println(itemsDeleted + " order items deleted for Order ID: " + currentOrderId);
            } catch (Exception ex) {
                System.err.println("Error deleting order items: " + ex.getMessage());
                JOptionPane.showMessageDialog(this, "Error deleting added items.", "Database Error", JOptionPane.ERROR_MESSAGE);
                return; // Stop further processing if deleting items fails
            }

            // Now, check the orders table for the current order_id and conditions to delete
            String checkOrderSQL = "SELECT cash, order_change FROM orders WHERE order_id = " + currentOrderId;
            try (java.sql.ResultSet rs = db.getData(checkOrderSQL)) {
                if (rs.next()) {
                    double cash = rs.getDouble("cash");
                    double change = rs.getDouble("order_change");

                    // If cash and change are both 0.00, or if cash is 0.00 (meaning likely no payment processed)
                    if ((cash == 0.00 && change == 0.00) || cash == 0.00) {
                        String deleteOrderSQL = "DELETE FROM orders WHERE order_id = " + currentOrderId;
                        int orderDeleted = db.insertData(deleteOrderSQL);
                        if (orderDeleted > 0) {
                            System.out.println("Order ID " + currentOrderId + " deleted due to no value.");
                        } else {
                            System.out.println("Order ID " + currentOrderId + " not deleted (condition not met or error).");
                        }
                    } else {
                        System.out.println("Order ID " + currentOrderId + " not deleted as cash or change has a value.");
                    }
                } else {
                    System.out.println("Order ID " + currentOrderId + " not found in orders table.");
                }
            } catch (SQLException ex) {
                System.err.println("Error checking order details: " + ex.getMessage());
                JOptionPane.showMessageDialog(this, "Error checking order details.", "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.out.println("No active Order ID to check for deletion.");
        }

        // Reset the order_id in the session
        session.setOrder_id(0);
        System.out.println("Order ID reset.");

        try {
            if (db.getConnection() != null) {
                db.getConnection().close();
            }
        } catch (SQLException ex) {
            System.err.println("Error closing database connection: " + ex.getMessage());
        }

        switch (userType) {
            case "Admin":
                new admindash().setVisible(true);
                break;
            case "Customer":
                new customerdashboard().setVisible(true);
                break;
            case "Employee":
                new employdash().setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Unrecognized user type");
        }

        this.dispose();
    } else {
        JOptionPane.showMessageDialog(null, "No account login first");
        this.dispose();
    }


    }//GEN-LAST:event_jPanel14MouseClicked

    private void ADDORDER3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADDORDER3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDORDER3MouseEntered

    private void ADDORDER3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADDORDER3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDORDER3MouseExited

    private void ADDORDERMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADDORDERMouseEntered
        // TODO add your handling code here:
        
           
       ADDORDER.setBackground(logcolor);
    }//GEN-LAST:event_ADDORDERMouseEntered

    private void ADDORDERMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADDORDERMouseExited
        // TODO add your handling code here:
        
           
        ADDORDER.setBackground(excolor);
    }//GEN-LAST:event_ADDORDERMouseExited

    private void ADDORDERMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADDORDERMouseClicked
   Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        int selectedRow = food.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "PLEASE SELECT AN ITEM");
            return;
        }

        SessionClass session = SessionClass.getInstance();
        if (session == null) {
            System.err.println("Session is null!");
            JOptionPane.showMessageDialog(null, "Session is null, cannot proceed with the order.");
            return;
        }

        int order_id = session.getOrder_id();
        System.out.println("Current Order ID: " + order_id);

        if (order_id == 0) {
            order_id = generateNewOrderId();
            session.setOrder_id(order_id);
            System.out.println("New Order ID created: " + order_id);
        } else {
            System.out.println("Using existing Order ID: " + order_id);
        }

        TableModel model = food.getModel();
        String productId = String.valueOf(model.getValueAt(selectedRow, 0));
        System.out.println("Selected Product ID: " + productId);

        dbConnect db = new dbConnect();
        conn = db.getConnection();

        String query = "SELECT * FROM product WHERE p_id = ?";
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, productId);
        rs = pstmt.executeQuery();

        if (rs.next()) {
            int p_id = rs.getInt("p_id");
            String p_name = rs.getString("p_name");
            float p_price = rs.getFloat("p_price");
            String p_brand = rs.getString("p_brand");
            int p_stock = rs.getInt("p_stock");
            String p_category = rs.getString("p_category");
            String imagePath = rs.getString("p_image");

            System.out.println("Product Details: " + p_id + ", " + p_name + ", " + p_price + ", " + p_brand + ", " + p_stock + ", " + p_category + ", " + imagePath);

            if (p_name == null || p_brand == null || imagePath == null) {
                System.err.println("Error: Product details are incomplete or missing.");
                JOptionPane.showMessageDialog(this, "Product details are incomplete. Cannot proceed.");
                return;
            }

            // Now pass the p_id and order_id to processpage constructor
            processpage pro = new processpage(p_id, order_id);

            // Set the parent (current orderpage instance) for the processpage
            pro.setParentOrderPage(this); // Pass 'this' (the current orderpage instance)

            pro.prodid.setText(String.valueOf(p_id));
            pro.prodname.setText(p_name);
            pro.prodprice.setText(String.valueOf(p_price));
            pro.prodbrand.setText(p_brand);
            pro.prodstock.setText(String.valueOf(p_stock));
            pro.prodcategory.setText(p_category);

            if (imagePath != null && !imagePath.isEmpty()) {
                pro.image.setIcon(pro.ResizeImage(imagePath, null, pro.image));
                pro.oldpath = imagePath;
                pro.path = imagePath;
                pro.destination = imagePath;
            } else {
                System.out.println("No image found!");
            }

            pro.setVisible(true);
            // You might want to keep the orderpage visible or handle its state as needed
            // this.dispose();
        } else {
            System.err.println("Error: Product not found.");
            JOptionPane.showMessageDialog(this, "Error: Product not found in database.");
        }
    } catch (SQLException ex) {
        System.err.println("SQL Error: " + ex.getMessage());
        JOptionPane.showMessageDialog(this, "Error retrieving product details: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    } catch (NullPointerException ex) {
        System.err.println("NullPointerException: " + ex.getMessage());
        JOptionPane.showMessageDialog(this, "NullPointerException: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            System.err.println("Error closing resources: " + ex.getMessage());
        }
    }
    }//GEN-LAST:event_ADDORDERMouseClicked

    private void foodandMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_foodandMouseClicked
        // TODO add your handling code here:
        
         try {
        dbConnect dbc = new dbConnect();
        ResultSet rs = dbc.getData("SELECT p_id AS 'Product ID', p_name AS 'Product Name', p_brand AS 'Brand', p_price AS 'Price', p_stock AS 'Stock', p_category, p_image AS 'Image' FROM product WHERE p_status = 'Available' AND p_category = 'Food and Beverage'");
        
        
//        
//Full texts
//p_id
//p_name
//p_category
//p_brand
//p_price
//p_stock
//p_status
//p_image

        food.setModel(DbUtils.resultSetToTableModel(rs));
        rs.close();
    } catch (SQLException ex) {
        System.out.println("Errors: " + ex.getMessage());
    }

        
        
        
    }//GEN-LAST:event_foodandMouseClicked

    private void householdniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_householdniMouseClicked
        // TODO add your handling code here:
        
          
         try {
        dbConnect dbc = new dbConnect();
        ResultSet rs = dbc.getData("SELECT p_id AS 'Product ID', p_name AS 'Product Name', p_brand AS 'Brand', p_price AS 'Price', p_stock AS 'Stock', p_category, p_image AS 'Image' FROM product WHERE p_status = 'Available' AND p_category = 'Household Essentials'");
        
        
//        
//Full texts
//p_id
//p_name
//p_category
//p_brand
//p_price
//p_stock
//p_status
//p_image

        food.setModel(DbUtils.resultSetToTableModel(rs));
        rs.close();
    } catch (SQLException ex) {
        System.out.println("Errors: " + ex.getMessage());
    }
        
    }//GEN-LAST:event_householdniMouseClicked

    private void personalwellMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_personalwellMouseClicked
        // TODO add your handling code here:
        
        
         try {
        dbConnect dbc = new dbConnect();
        ResultSet rs = dbc.getData("SELECT p_id AS 'Product ID', p_name AS 'Product Name', p_brand AS 'Brand', p_price AS 'Price', p_stock AS 'Stock', p_category, p_image AS 'Image' FROM product WHERE p_status = 'Available' AND p_category = 'Personal Wellness'");
        
        
//        
//Full texts
//p_id
//p_name
//p_category
//p_brand
//p_price
//p_stock
//p_status
//p_image

        food.setModel(DbUtils.resultSetToTableModel(rs));
        rs.close();
    } catch (SQLException ex) {
        System.out.println("Errors: " + ex.getMessage());
    }
        
    }//GEN-LAST:event_personalwellMouseClicked

    private void suppliesniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suppliesniMouseClicked
        // TODO add your handling code here:
        try {
        dbConnect dbc = new dbConnect();
        ResultSet rs = dbc.getData("SELECT p_id AS 'Product ID', p_name AS 'Product Name', p_brand AS 'Brand', p_price AS 'Price', p_stock AS 'Stock', p_category, p_image AS 'Image' FROM product WHERE p_status = 'Available' AND p_category = 'Supplies Utilities'");
        
        
//        
//Full texts
//p_id
//p_name
//p_category
//p_brand
//p_price
//p_stock
//p_status
//p_image

        food.setModel(DbUtils.resultSetToTableModel(rs));
        rs.close();
    } catch (SQLException ex) {
        System.out.println("Errors: " + ex.getMessage());
    }
        
        
    }//GEN-LAST:event_suppliesniMouseClicked

    private void resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseClicked
        // TODO add your handling code here:
        
        showdata();
        
    }//GEN-LAST:event_resetMouseClicked

    private void resetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseEntered
        // TODO add your handling code here:
        
        reset.setBackground(logcolor);
    }//GEN-LAST:event_resetMouseEntered

    private void resetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseExited
        // TODO add your handling code here:
        
                reset.setBackground(excolor);

    }//GEN-LAST:event_resetMouseExited

    private void personalwellMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_personalwellMouseEntered
        // TODO add your handling code here:
        personalwell.setBackground(logcolorx);
    }//GEN-LAST:event_personalwellMouseEntered

    private void personalwellMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_personalwellMouseExited
        // TODO add your handling code here:
        
              personalwell.setBackground(excolorx);
        
    }//GEN-LAST:event_personalwellMouseExited

    private void suppliesniMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suppliesniMouseEntered
        // TODO add your handling code here:\
        
              suppliesni.setBackground(logcolorx);
        
    }//GEN-LAST:event_suppliesniMouseEntered

    private void suppliesniMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suppliesniMouseExited
        // TODO add your handling code here:
        
              suppliesni.setBackground(excolorx);
        
    }//GEN-LAST:event_suppliesniMouseExited

    private void householdniMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_householdniMouseEntered
        // TODO add your handling code here:
        
              householdni.setBackground(logcolorx);
        
    }//GEN-LAST:event_householdniMouseEntered

    private void householdniMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_householdniMouseExited
        // TODO add your handling code here:
        
             householdni.setBackground(excolorx);
    }//GEN-LAST:event_householdniMouseExited

    private void foodandMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_foodandMouseEntered
        // TODO add your handling code here:
        
              foodand.setBackground(logcolorx);
        
    }//GEN-LAST:event_foodandMouseEntered

    private void foodandMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_foodandMouseExited
        // TODO add your handling code here:
        
              foodand.setBackground(excolorx);
        
    }//GEN-LAST:event_foodandMouseExited

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
        SessionClass session = SessionClass.getInstance();
if (session.getOrder_id() == 0) { 
    // Generate a new Order ID
    int newOrderId = generateNewOrderId(); // <- you need to create this method
    session.setOrder_id(newOrderId);
    System.out.println("New Order ID created: " + newOrderId);
}
    }//GEN-LAST:event_formWindowOpened

    private void entercashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entercashActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entercashActionPerformed

    private void addorderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addorderMouseClicked
        String cashText = entercash.getText();
    SessionClass session = SessionClass.getInstance();
    int currentOrderId = session.getOrder_id();
    dbConnect db = new dbConnect(); // Initialize dbConnect here

    if (currentOrderId == 0) {
        JOptionPane.showMessageDialog(this, "No active order to save.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (cashText.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter the cash amount.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    double cashAmount;
    try {
        cashAmount = Double.parseDouble(cashText);
        if (cashAmount < 0) {
            JOptionPane.showMessageDialog(this, "Cash amount cannot be negative.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Calculate the total amount of the order
        double totalAmount = 0.0;
        try {
            String getTotalQuery = "SELECT SUM(item_total) AS order_total FROM order_items WHERE order_id = " + currentOrderId;
            java.sql.ResultSet rs = db.getData(getTotalQuery);
            if (rs.next()) {
                totalAmount = rs.getDouble("order_total");
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error getting total amount: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error calculating total amount.", "Database Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cashAmount < totalAmount) {
            JOptionPane.showMessageDialog(this, "Cash amount is less than the total order amount.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double changeAmount = cashAmount - totalAmount;

        Connection conn = null;
        PreparedStatement pstmtUpdateOrder = null;
        PreparedStatement pstmtUpdateProduct = null;

        try {
            conn = db.getConnection();
            conn.setAutoCommit(false); // Start transaction

            // Update the orders table
            String updateOrderSQL = "UPDATE orders SET cash = ?, order_change = ?, order_status = 'Pending' WHERE order_id = ?";
            pstmtUpdateOrder = conn.prepareStatement(updateOrderSQL);
            pstmtUpdateOrder.setDouble(1, cashAmount);
            pstmtUpdateOrder.setDouble(2, changeAmount);
            pstmtUpdateOrder.setInt(3, currentOrderId);
            int rowsUpdated = pstmtUpdateOrder.executeUpdate();

            if (rowsUpdated > 0) {
                // Update product quantities
                String updateProductSQL = "UPDATE product SET p_stock = p_stock - ? WHERE p_id = (SELECT product_id FROM order_items WHERE order_item_id = ?)";
                pstmtUpdateProduct = conn.prepareStatement(updateProductSQL);

                String getOrderItemsQuery = "SELECT order_item_id, quantity FROM order_items WHERE order_id = ?";
                ResultSet rsOrderItems = db.getData(getOrderItemsQuery, currentOrderId);

                while (rsOrderItems.next()) {
                    int orderItemId = rsOrderItems.getInt("order_item_id");
                    int orderedQuantity = rsOrderItems.getInt("quantity");
                    pstmtUpdateProduct.setInt(1, orderedQuantity);
                    pstmtUpdateProduct.setInt(2, orderItemId);
                    pstmtUpdateProduct.executeUpdate();
                }
                rsOrderItems.close();

                conn.commit(); // Commit transaction
                JOptionPane.showMessageDialog(this, "Order completed successfully! Change: " + String.format("%.2f", changeAmount), "Success", JOptionPane.INFORMATION_MESSAGE);
                session.setOrder_id(0);
                loadOrderedItems(0, orderitem);
                displayOrderTotal();
                entercash.setText("");

                // Log the order completion
                logOrderAction(currentOrderId, cashAmount, changeAmount); //calling the logOrderAction

                // Redirect to dashboard
                Window window = SwingUtilities.getWindowAncestor(this); // Get the current window
                if (session.getType().equalsIgnoreCase("Admin")) {
                    admindash ad = new admindash();
                    ad.setVisible(true);
                    this.dispose(); // Close the current order page
                } else {
                    customerdashboard cd = new customerdashboard();
                    cd.setVisible(true);
                    this.dispose(); // Close the current order page
                }
            } else {
                conn.rollback(); // Rollback if order update failed
                JOptionPane.showMessageDialog(this, "Failed to complete the order.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            if (conn != null) {
                try {
                    conn.rollback(); // Rollback on error
                } catch (SQLException rollbackEx) {
                    System.err.println("Error during rollback: " + rollbackEx.getMessage());
                }
            }
            System.err.println("Error processing order: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Database error during order processing.", "Database Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (pstmtUpdateOrder != null) pstmtUpdateOrder.close();
                if (pstmtUpdateProduct != null) pstmtUpdateProduct.close();
                if (conn != null) conn.setAutoCommit(true); // Reset auto-commit
                if (db.getConnection() != null) db.getConnection().close();
            } catch (SQLException ex) {
                System.err.println("Error closing resources: " + ex.getMessage());
            }
        }

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid cash amount. Please enter a valid number.", "Validation Error", JOptionPane.ERROR_MESSAGE);
    }
  
    }//GEN-LAST:event_addorderMouseClicked

    private void editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseClicked
        // TODO add your handling code here:
        
       
    int selectedRow = orderitem.getSelectedRow();

    // Check if a row is selected
    if (selectedRow < 0) {
        JOptionPane.showMessageDialog(this, "Please select an item to edit.", "Information", JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    // Get the order_item_id from the selected row (assuming it's in the first column)
    int orderItemId = (int) orderitem.getValueAt(selectedRow, 0);

    // Create and display the Edit Quantity dialog
    editquan editDialog = new editquan();

    // Pass the order_item_id to the dialog
    editDialog.setOrderItemIdToEdit(orderItemId);

    // Pass a reference to the current orderpage instance to the dialog
    editDialog.setParentOrderPage(this);

    // Make the dialog modal
    editDialog.setModal(true);
    editDialog.setVisible(true);

    // After the dialog is closed, refresh the order items table and total
    if (currentOrderId != null) { // Ensure currentOrderId is initialized
        loadOrderedItems(currentOrderId, orderitem);
        displayOrderTotal();
    } else {
        System.err.println("Error: currentOrderId is null, cannot refresh table.");
    }
        
    }//GEN-LAST:event_editMouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
   
    int selectedRow = orderitem.getSelectedRow();

   
    if (selectedRow < 0) {
        JOptionPane.showMessageDialog(this, "Please select an item to delete.", "Information", JOptionPane.INFORMATION_MESSAGE);
        return;
    }

   
    int orderItemIdToDelete = (int) orderitem.getValueAt(selectedRow, 0);

    
    int confirmation = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this item?", "Confirm Delete", JOptionPane.YES_NO_OPTION);

    if (confirmation == JOptionPane.YES_OPTION) {
        dbConnect db = new dbConnect();
        String deleteSQL = "DELETE FROM order_items WHERE order_item_id = ?";

        try (Connection conn = db.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {

            pstmt.setInt(1, orderItemIdToDelete);
            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(this, "Item deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                // Refresh the ordered items table and total
                SessionClass session = SessionClass.getInstance();
                loadOrderedItems(session.getOrder_id(), orderitem);
                displayOrderTotal();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete the item.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            System.err.println("Error deleting item: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Database error during item deletion.", "Database Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (db.getConnection() != null) {
                    db.getConnection().close();
                }
            } catch (SQLException ex) {
                System.err.println("Error closing database connection: " + ex.getMessage());
            }
        }
    }
        
        
    }//GEN-LAST:event_jPanel5MouseClicked

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
            java.util.logging.Logger.getLogger(orderpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(orderpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(orderpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(orderpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new orderpage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ADDORDER;
    private javax.swing.JPanel ADDORDER3;
    private javax.swing.JPanel addorder;
    private javax.swing.JLabel backbutton;
    private javax.swing.JLabel beverage;
    private javax.swing.JPanel edit;
    private javax.swing.JTextField entercash;
    public javax.swing.JTable food;
    private javax.swing.JPanel foodand;
    private javax.swing.JLabel household;
    private javax.swing.JPanel householdni;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jToggleButton1;
    public javax.swing.JTable orderitem;
    private javax.swing.JLabel personal;
    private javax.swing.JPanel personalwell;
    private javax.swing.JPanel reset;
    private javax.swing.JLabel supplies;
    private javax.swing.JPanel suppliesni;
    public javax.swing.JLabel totalamount;
    // End of variables declaration//GEN-END:variables
}
