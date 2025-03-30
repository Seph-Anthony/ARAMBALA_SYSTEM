/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;


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
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class addprod extends javax.swing.JFrame {

    /**
     * Creates new form addprod
     */
    public addprod() {
        initComponents();
        
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
    
    private void logProductAdditionAction(int userId, String productName) {
    String sql = "INSERT INTO logs (user_id, act, log_date) VALUES (?, ?, NOW())";

    dbConnect db = new dbConnect();
    try (Connection conn = db.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, userId);
        pstmt.setString(2, "Product Added: " + productName);
        pstmt.executeUpdate();

    } catch (SQLException e) {
        System.err.println("Failed to log product addition action: " + e.getMessage());
    }
}
private int getCurrentUserId() {
    // Access the user ID from the SessionClass
    config.SessionClass ses = config.SessionClass.getInstance();
    return ses.getU_id();
}
  public static String productname, brand;
//    public boolean dupcheck(){
//        
//        dbConnect db = new dbConnect();
//         
//        try{
//        String que = "SELECT * FROM product WHERE p_name='"+proname.getText()+"' OR p_brand='"+probrand.getText()+"'";    
//            ResultSet resultset = db.getData(que);
//            if(resultset.next()){
//                brand = resultset.getString("p_brand");
//            
//                if(brand.equals(probrand.getText())){
//                    
//                    JOptionPane.showMessageDialog(null, "The email already existed",
//                "Error Registration", JOptionPane.ERROR_MESSAGE);
//                    probrand.setText("");
//                }
//                productname = resultset.getString("p_name");
//                 if(productname.equals(proname.getText())){
//                    
//                    JOptionPane.showMessageDialog(null, "The username already existed",
//                "Error Registration", JOptionPane.ERROR_MESSAGE);
//                    proname.setText("");
//                }
//                System.out.println(""+productname);
//             return true;   
//            }
//            
//            else {
//                
//                return false;
//            }
//        }catch(SQLException ex){
//            System.out.println(""+ex);
//            return false;
//        }
//    }
    
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

        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        prostock = new javax.swing.JTextField();
        proprice = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        probrand = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        proname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        remove = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1039 = new javax.swing.JLabel();
        prodcategory = new javax.swing.JComboBox<>();
        select = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        add = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 1, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ADD PRODUCT");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 340, 80));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dakoaddprod.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(15, 15, 15))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 90, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 760, 120));

        prostock.setBackground(new java.awt.Color(240, 240, 240));
        prostock.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        prostock.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        prostock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prostockActionPerformed(evt);
            }
        });
        jPanel1.add(prostock, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 310, 240, 50));

        proprice.setBackground(new java.awt.Color(240, 240, 240));
        proprice.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        proprice.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        proprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                propriceActionPerformed(evt);
            }
        });
        jPanel1.add(proprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 240, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Product Stock");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 290, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Product Price");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, -1, -1));

        probrand.setBackground(new java.awt.Color(240, 240, 240));
        probrand.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        probrand.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        probrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                probrandActionPerformed(evt);
            }
        });
        jPanel1.add(probrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 240, 50));

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Product Brand");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 1, true));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dakoboxproduct.png"))); // NOI18N
        jPanel6.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 170));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 180, 190));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Product Name:");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, -1, -1));

        proname.setBackground(new java.awt.Color(240, 240, 240));
        proname.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        proname.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        proname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pronameActionPerformed(evt);
            }
        });
        jPanel5.add(proname, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 240, 50));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Product Category");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, -1, -1));

        remove.setBackground(new java.awt.Color(0, 102, 102));
        remove.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeMouseClicked(evt);
            }
        });
        remove.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("REMOVE");
        remove.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 20));

        jPanel5.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 90, 40));

        jLabel1039.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1039.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/backwardset.png"))); // NOI18N
        jLabel1039.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1039MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel1039, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 50, 50));

        prodcategory.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        prodcategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category", "Food Bevarage", "Household Essentials", "Personal Wellness", "Suppliess Utilities" }));
        prodcategory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel5.add(prodcategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 240, 50));

        select.setBackground(new java.awt.Color(0, 102, 102));
        select.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        select.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectMouseClicked(evt);
            }
        });
        select.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("SELECT");
        select.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 20));

        jPanel5.add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 80, 40));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 760, 390));

        add.setBackground(new java.awt.Color(0, 102, 102));
        add.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addMouseExited(evt);
            }
        });
        add.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("ADD PRODUCT");
        add.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 160, 30));

        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 520, 200, 70));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 310, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void prostockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prostockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prostockActionPerformed

    private void pronameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pronameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pronameActionPerformed

    private void propriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_propriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_propriceActionPerformed

    private void probrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_probrandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_probrandActionPerformed

    private void jLabel1039MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1039MouseClicked
        // TODO add your handling code here:

        admindash ad = new admindash();
        ad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1039MouseClicked

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
      
 
 
    dbConnect db = new dbConnect();

    String selectedCategory = (String) prodcategory.getSelectedItem();

    if (proname.getText().isEmpty() || proprice.getText().isEmpty() || prostock.getText().isEmpty() ||
        probrand.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Invalid Registration: All fields are required.",
            "Error Registration", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (selectedCategory == null || selectedCategory.equals("Select Category")) {
        JOptionPane.showMessageDialog(null, "Please select a valid Category Type.",
            "Error Registration", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String priceText = proprice.getText();
    try {
        double price = Double.parseDouble(priceText);
        if (price < 0) {
            JOptionPane.showMessageDialog(null, "Invalid Price: Price cannot be negative.",
                "Error Registration", JOptionPane.ERROR_MESSAGE);
            return;
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Invalid Price: Please enter a valid number.",
            "Error Registration", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (!prostock.getText().matches("\\d+")) {
        JOptionPane.showMessageDialog(null, "Invalid Stock Input.",
            "Error Registration", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int stock = Integer.parseInt(prostock.getText());
    String status = (stock == 0) ? "Not Available" : "Available";

   
    String query = "INSERT INTO product (p_name, p_category, p_brand, p_price, p_stock, p_status, p_image) VALUES (?, ?, ?, ?, ?, ?, ?)";

    try (Connection conn = db.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {

        pstmt.setString(1, proname.getText());
        pstmt.setString(2, selectedCategory);
        pstmt.setString(3, probrand.getText());
        pstmt.setDouble(4, Double.parseDouble(proprice.getText()));
        pstmt.setInt(5, stock);
        pstmt.setString(6, status);
        pstmt.setString(7, destination);

        int result = pstmt.executeUpdate();

          try{
    Files.copy(selectedFile.toPath(),new File(destination).toPath(),StandardCopyOption.REPLACE_EXISTING);
    
    
    }catch(IOException ex){
        
        System.out.println("Image Insertion Error: "+ex);
    }
        
        if (result == 1) {
            JOptionPane.showMessageDialog(null, "Product added successfully.");

            // Log the product addition action
            int currentUserId = getCurrentUserId(); // Get the user ID
            logProductAdditionAction(currentUserId, proname.getText());

        } else {
            JOptionPane.showMessageDialog(null, "Error adding product. Please check your input or try again.",
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(),
            "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
    
    
    
    
 
    }//GEN-LAST:event_addMouseClicked

    private void addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseEntered
        // TODO add your handling code here:
        
        add.setBackground(logcolor);
        
    }//GEN-LAST:event_addMouseEntered

    private void addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseExited
        // TODO add your handling code here:
         add.setBackground(excolor);
    }//GEN-LAST:event_addMouseExited

    private void selectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectMouseClicked
        // TODO add your handling code here:
        
        
            
        JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    try {
                        selectedFile = fileChooser.getSelectedFile();
                        destination = "src/userimages/" + selectedFile.getName();
                        path  = selectedFile.getAbsolutePath();
                        
                        
                        if(FileExistenceChecker(path) == 1){
                          JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                            destination = "";
                            path="";
                        }else{
                            image.setIcon(ResizeImage(path, null, image));
                            JOptionPane.showMessageDialog(this,"Image Uploaded Successfully");
                            select.setEnabled(false);
                          
                            remove.setEnabled(true);
                        }
                    } catch (Exception ex) {
                        System.out.println("File Error!");
                    }
                }
        
    }//GEN-LAST:event_selectMouseClicked

    private void removeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMouseClicked
        // TODO add your handling code here:
        
         JOptionPane.showMessageDialog(this,"Image Deleted Successfully");
        remove.setEnabled(false);
        select.setEnabled(true);
        image.setIcon(null);
        destination ="";
        path = "";
        
    }//GEN-LAST:event_removeMouseClicked
    
   
    
    

    
    
    
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
            java.util.logging.Logger.getLogger(addprod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addprod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addprod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addprod.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addprod().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel add;
    private javax.swing.JLabel image;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel1039;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField probrand;
    private javax.swing.JComboBox<String> prodcategory;
    private javax.swing.JTextField proname;
    private javax.swing.JTextField proprice;
    private javax.swing.JTextField prostock;
    public javax.swing.JPanel remove;
    public javax.swing.JPanel select;
    // End of variables declaration//GEN-END:variables
}
