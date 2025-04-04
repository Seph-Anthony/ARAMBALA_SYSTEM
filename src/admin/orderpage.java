/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.dbConnect;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Admin
 */
public class orderpage extends javax.swing.JFrame {

    /**
     * Creates new form orderpage
     */
    public orderpage() {
        initComponents();
        displayfood();
        Allpersonal();
        Allsupplies();
        Allhousehold();
        Allbeverage();
//        displaypersonal();
//        displayhouse();
//        displaysupplies();
    }
    Color logcolorx = new Color(63,195,128);
    Color excolorx = new Color(255,255,255);
    
    public void showdata(){
        try{
            dbConnect dbc = new dbConnect();
            ResultSet rs = dbc.getData("SELECT * FROM product");
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
        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        food = new javax.swing.JTable();
        ADDORDER = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        ADDORDER3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        VIEWORDER = new javax.swing.JPanel();
        ADDORDER1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
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
        jPanel12 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jPanel10.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 600, 470));

        jPanel8.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 620, 490));

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

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("ADD ORDER");
        ADDORDER.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 20));

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

        jPanel8.add(ADDORDER, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 130, 40));

        VIEWORDER.setBackground(new java.awt.Color(0, 102, 102));
        VIEWORDER.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        VIEWORDER.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                VIEWORDERMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                VIEWORDERMouseExited(evt);
            }
        });
        VIEWORDER.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ADDORDER1.setBackground(new java.awt.Color(0, 102, 102));
        ADDORDER1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        ADDORDER1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ADDORDER1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ADDORDER1MouseExited(evt);
            }
        });
        ADDORDER1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ADD ORDER");
        ADDORDER1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 20));

        VIEWORDER.add(ADDORDER1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 560, 120, 40));

        jLabel23.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("VIEW ORDER");
        VIEWORDER.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 20));

        jPanel8.add(VIEWORDER, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 130, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PRODUCTS");
        jPanel8.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 170, 40));

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

        jPanel8.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 150, 140));

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

        jPanel8.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 150, 140));

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

        jPanel8.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 150, 140));

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

        jPanel8.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 150, 140));

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
        reset.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 20));

        jPanel8.add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 130, 40));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, -10, 650, 720));

        jPanel12.setBackground(new java.awt.Color(0, 102, 102));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(0, 102, 102));
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel14MouseClicked(evt);
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
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 80, 80));

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
  
    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked
        // TODO add your handling code here:
        admindash order = new admindash();
       order.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jPanel14MouseClicked

    private void VIEWORDERMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VIEWORDERMouseEntered
        // TODO add your handling code here:
        
        VIEWORDER.setBackground(logcolor);
        
    }//GEN-LAST:event_VIEWORDERMouseEntered

    private void VIEWORDERMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VIEWORDERMouseExited
        // TODO add your handling code here:
        
         VIEWORDER.setBackground(excolor);
        
    }//GEN-LAST:event_VIEWORDERMouseExited

    private void ADDORDER1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADDORDER1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDORDER1MouseEntered

    private void ADDORDER1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADDORDER1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ADDORDER1MouseExited

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
        // TODO add your handling code here:
        
         int rowfood =food.getSelectedRow();
      
         
                  
        if(rowfood<0){
            JOptionPane.showMessageDialog(null,"PLEASE SELECT AN ITEM");
            
        } else{
            
            try{
                dbConnect db = new dbConnect();
                TableModel fod = food.getModel();
                ResultSet rs = db.getData("SELECT * FROM product WHERE p_id = '"+fod.getValueAt(rowfood, 0)+"'");
                
                if(rs.next()){
                processpage pro = new processpage();
                
                pro.prodid.setText(""+rs.getInt("p_id"));
                pro.prodname.setText(""+rs.getString("p_name"));
                pro.prodprice.setText(""+rs.getFloat("p_price"));
                pro.prodbrand.setText(""+rs.getString("p_brand"));
                pro.prodstock.setText(""+rs.getInt("p_stock"));
                pro.prodcategory.setText(""+rs.getString("p_category"));
               pro.image.setIcon(pro.ResizeImage(rs.getString("p_image"),null,pro.image));
               pro.oldpath = rs.getString("p_image");
      pro.path = rs.getString("p_image");
      pro.destination=rs.getString("p_image");
             
               
                pro.setVisible(true);
                
                this.dispose();
                }   
            }catch(SQLException ex){
                
                System.out.println(""+ex);
            }
            
        }
        
//         int rowindex = usertable.getSelectedRow();
//        
//        if(rowindex<0){
//            JOptionPane.showMessageDialog(null,"PLEASE SELECT AN ITEM");
//            
//        } else{
//            
//        
//        try{
//        dbConnect db = new dbConnect();
//         TableModel tbl =  usertable.getModel();
//       ResultSet rs = db.getData("SELECT * FROM  user WHERE u_id = '"+tbl.getValueAt(rowindex, 0)+"'");
//      if(rs.next()){
//            updateuser up = new updateuser();
//          
//            up.uid.setText(""+rs.getInt("u_id"));
//            up.usernamere.setText(""+rs.getString("u_username"));
//       up.fname.setText(""+rs.getString("u_fname"));
//       up.lname.setText(""+rs.getString("u_lname"));
//       up.email.setText(""+rs.getString("u_email"));
//       up.contact.setText(""+rs.getString("u_contact"));
//       up.ty.setSelectedItem(""+rs.getString("u_type"));
//       up.oldpass.setText(""+rs.getString("u_password"));
//      up.status.setSelectedItem(""+rs.getString("u_stat"));
//      up.image.setIcon(up.ResizeImage(rs.getString("u_image"),null,up.image));
//      up.oldpath = rs.getString("u_image");
//      up.path = rs.getString("u_image");
//      up.destination=rs.getString("u_image");
//      up.setVisible(true);
//      
//      
//        this.dispose();
//       
//      }
//        }
//        
//        catch(SQLException ex){
//            System.out.println(""+ex);
//        } 
//        }
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
    private javax.swing.JPanel ADDORDER1;
    private javax.swing.JPanel ADDORDER3;
    private javax.swing.JPanel VIEWORDER;
    private javax.swing.JLabel beverage;
    private javax.swing.JTable food;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel personal;
    private javax.swing.JPanel personalwell;
    private javax.swing.JPanel reset;
    private javax.swing.JLabel supplies;
    private javax.swing.JPanel suppliesni;
    // End of variables declaration//GEN-END:variables
}
