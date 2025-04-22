/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package USER;

import admin.admindash;
import static admin.updateuser.getHeightFromWidth;
import config.SessionClass;
import config.dbConnect;
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
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import lores.LOGIN;

/**
 *
 * @author Admin
 */
public class employeeinfo extends javax.swing.JFrame {

    /**
     * Creates new form employeeinfo
     */
    public employeeinfo() {
        initComponents();
        displayUserImage(image);
    }
    
            private void logProductAdditionAction(int userId, String Username) {
    String sql = "INSERT INTO logs (user_id, act, log_date) VALUES (?, ?, NOW())";

    dbConnect db = new dbConnect();
    try (Connection conn = db.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setInt(1, userId);
        pstmt.setString(2, "User Changed Image:" + Username);
        pstmt.executeUpdate();

    } catch (SQLException e) {
        System.err.println("Failed to log user addition action: " + e.getMessage());
    }
}
         
         private int getCurrentUserId() {
  
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
    
    
public ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
    // If both image sources are null, return default image
    if (ImagePath == null && pic == null) {
        return new ImageIcon(getClass().getResource("/image/default_user.png"));
    }
    
    ImageIcon MyImage = null;
    if (ImagePath != null) {
        MyImage = new ImageIcon(ImagePath);
    } else {
        MyImage = new ImageIcon(pic);
    }
    
    // Rest of your resizing logic...
    int newHeight = label.getWidth(); // Default height if calculation fails
    
    try {
        if (ImagePath != null) {
            newHeight = getHeightFromWidth(ImagePath, label.getWidth());
        }
    } catch (Exception e) {
        // If height calculation fails, use label width as height
    }
    
    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
    return new ImageIcon(newImg);
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
public void displayUserImage(JLabel admiimage) {
    SessionClass session = SessionClass.getInstance();
    String imagePath = session.getU_image();
    
    // Always show default image if no image is set
    if (imagePath == null) {
        image.setIcon(new ImageIcon(getClass().getResource("/image/default_user.png")));
        return;
    }
    
    // Try to display the image (will fall back to default if fails)
    try {
        image.setIcon(ResizeImage(imagePath, null, image));
    } catch (Exception e) {
        image.setIcon(new ImageIcon(getClass().getResource("/image/default_user.png")));
    }
}
    
    private void initComponentss() {
        // Initialize components (auto-generated by NetBeans)
        // Ensure that updatePanel is properly initialized and linked to the MouseListener
        updatePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatePanelMouseClicked(evt);
            }
        });
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        tologin = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1026 = new javax.swing.JPanel();
        jPanel1027 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        passwordshow = new javax.swing.JLabel();
        updatePanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1030 = new javax.swing.JPanel();
        jPanel1031 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        fnameshow = new javax.swing.JLabel();
        jPanel1032 = new javax.swing.JPanel();
        jPanel1033 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        lnameshow = new javax.swing.JLabel();
        jPanel1034 = new javax.swing.JPanel();
        jPanel1035 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        idshow = new javax.swing.JLabel();
        jPanel1036 = new javax.swing.JPanel();
        jPanel1037 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        emailshow = new javax.swing.JLabel();
        jPanel1038 = new javax.swing.JPanel();
        jPanel1039 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        contactshow = new javax.swing.JLabel();
        jPanel1040 = new javax.swing.JPanel();
        jPanel1041 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        usernameshow = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        add = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        remove = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        select = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

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

        jPanel3.add(tologin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, -1, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("USER INFORMATION");
        jLabel9.setToolTipText("");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 570, 50));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/staffstandard.png"))); // NOI18N
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 780, 90));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Password");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 240, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("First Name");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Last Name");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Contact");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, -1, -1));

        jPanel1026.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1026.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1026.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1027.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1027.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel1027.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Edit Profile");
        jPanel1027.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 20));

        jPanel1026.add(jPanel1027, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 150, 40));

        passwordshow.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        passwordshow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passwordshow.setEnabled(false);
        jPanel1026.add(passwordshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 130, 40));

        jPanel2.add(jPanel1026, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, 170, 40));

        updatePanel.setBackground(new java.awt.Color(0, 102, 102));
        updatePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        updatePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatePanelMouseClicked(evt);
            }
        });
        updatePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Update Information");
        updatePanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 170, -1));

        jPanel2.add(updatePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 390, 210, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 102));
        jLabel15.setText("Email");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, -1, -1));

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/backwardset.png"))); // NOI18N
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 50, 40));

        jLabel18.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 102));
        jLabel18.setText("ID");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, -1, -1));

        panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Username");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, -1, -1));

        jPanel1030.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1030.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1030.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1031.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1031.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel1031.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 102));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Edit Profile");
        jPanel1031.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 20));

        jPanel1030.add(jPanel1031, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 150, 40));

        fnameshow.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        fnameshow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fnameshow.setEnabled(false);
        jPanel1030.add(fnameshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 130, 40));

        jPanel2.add(jPanel1030, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 170, 40));

        jPanel1032.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1032.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1032.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1033.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1033.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel1033.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 102));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Edit Profile");
        jPanel1033.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 20));

        jPanel1032.add(jPanel1033, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 150, 40));

        lnameshow.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        lnameshow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lnameshow.setEnabled(false);
        jPanel1032.add(lnameshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 130, 40));

        jPanel2.add(jPanel1032, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 170, 40));

        jPanel1034.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1034.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1034.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1035.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1035.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel1035.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 102, 102));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Edit Profile");
        jPanel1035.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 20));

        jPanel1034.add(jPanel1035, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 150, 40));

        idshow.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        idshow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        idshow.setEnabled(false);
        jPanel1034.add(idshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 50, 40));

        jPanel2.add(jPanel1034, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 90, 40));

        jPanel1036.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1036.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1036.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1037.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1037.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel1037.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 102, 102));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Edit Profile");
        jPanel1037.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 20));

        jPanel1036.add(jPanel1037, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 150, 40));

        emailshow.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        emailshow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emailshow.setEnabled(false);
        jPanel1036.add(emailshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 130, 40));

        jPanel2.add(jPanel1036, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 170, 40));

        jPanel1038.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1038.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1038.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1039.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1039.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel1039.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 102, 102));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Edit Profile");
        jPanel1039.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 20));

        jPanel1038.add(jPanel1039, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 150, 40));

        contactshow.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        contactshow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contactshow.setEnabled(false);
        jPanel1038.add(contactshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 130, 40));

        jPanel2.add(jPanel1038, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 170, 40));

        jPanel1040.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1040.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1040.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1041.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1041.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel1041.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 102, 102));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Edit Profile");
        jPanel1041.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 20));

        jPanel1040.add(jPanel1041, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 150, 40));

        usernameshow.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        usernameshow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameshow.setEnabled(false);
        jPanel1040.add(usernameshow, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 130, 40));

        jPanel2.add(jPanel1040, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 170, 40));

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Security Questions");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 170, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, 210, 40));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/newuserprofile.png"))); // NOI18N
        jPanel5.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 230, 210));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 250, 210));

        add.setBackground(new java.awt.Color(0, 102, 102));
        add.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });
        add.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("UPDATE");
        add.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 10, 70, -1));

        jPanel2.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 100, 40));

        remove.setBackground(new java.awt.Color(0, 102, 102));
        remove.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeMouseClicked(evt);
            }
        });
        remove.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("REMOVE");
        remove.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 10, 80, -1));

        jPanel2.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 100, 40));

        select.setBackground(new java.awt.Color(0, 102, 102));
        select.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        select.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectMouseClicked(evt);
            }
        });
        select.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SELECT");
        select.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel2.add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 100, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 780, 440));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tologinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tologinMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tologinMouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
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
    }//GEN-LAST:event_jLabel20MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        
        
           SessionClass ses = SessionClass.getInstance();
          
          if(ses.getU_id() == 0 ){
              JOptionPane.showMessageDialog(null,"No account, login first!");
              LOGIN log = new LOGIN();
              log.setVisible(true);
              this.dispose();
              
          }
          
          else{
              usernameshow.setText(""+ses.getUsername());
              fnameshow.setText(""+ses.getFname());
              lnameshow.setText(""+ses.getLname());
              contactshow.setText(""+ses.getContact());
              emailshow.setText(""+ses.getEmail());
              idshow.setText(""+ses.getU_id());
            passwordshow.setText(""+ses.getPass());
              
              
//       userid.setText(""+ses.getUsername());
//       userid.setText(""+ses.getU_id());


//       
          }  
                                        

        
    }//GEN-LAST:event_formWindowActivated

    private void updatePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatePanelMouseClicked
        // TODO add your handling code here:
           int id = Integer.parseInt(idshow.getText()); // Get the ID from the idshow label
    String email = emailshow.getText();
    String contact = contactshow.getText();
    String password = passwordshow.getText();
        

        // Open the updateinfor form and pass the information
        updateinfor updateForm = new updateinfor( email, contact, password);
        updateForm.setVisible(true);
        this.dispose();
       
        
    }//GEN-LAST:event_updatePanelMouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // TODO add your handling code here:
        
         SessionClass ses = SessionClass.getInstance();
    int userId = ses.getU_id(); // Get current user ID
    
    SecurityLog log = new SecurityLog(userId); // Pass the user ID
    log.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_jPanel4MouseClicked

    private void selectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectMouseClicked
        // TODO add your handling code here:
        
         JFileChooser fileChooser = new JFileChooser();
    int returnValue = fileChooser.showOpenDialog(null);
    
    if (returnValue == JFileChooser.APPROVE_OPTION) {
        try {
            selectedFile = fileChooser.getSelectedFile();
            destination = "src/userimages/" + selectedFile.getName();
            path = selectedFile.getAbsolutePath();
            
            // Directly set the image without validation
            image.setIcon(ResizeImage(path, null, image));
            
            // Update button states
            select.setEnabled(false);
            remove.setEnabled(true);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error loading image: " + ex.getMessage());
        }
    }
        
    }//GEN-LAST:event_selectMouseClicked

    private void removeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMouseClicked
      SessionClass ses = SessionClass.getInstance();
    int userId = ses.getU_id();
    String defaultImagePath = "src/userimages/default_user.png"; // Define your default image path

    dbConnect conn = new dbConnect();
    String update = "UPDATE user SET u_image = ? WHERE u_id = ?";

    try (PreparedStatement pst = conn.getConnection().prepareStatement(update)) {
        pst.setString(1, defaultImagePath); // Set u_image to the default image path
        pst.setInt(2, userId);
        pst.executeUpdate();

        // Update session
        ses.setU_image(defaultImagePath);

        // Update UI
        JOptionPane.showMessageDialog(this, "Image Reset to Default");
        remove.setEnabled(false);
        select.setEnabled(true);
        image.setIcon(new ImageIcon(defaultImagePath)); // Directly set the default image
        destination = defaultImagePath;
        path = defaultImagePath;
        displayUserImage(image); // Refresh the image display
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error updating database: " + ex.getMessage());
        ex.printStackTrace();
    }
    }//GEN-LAST:event_removeMouseClicked

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        // TODO add your handling code here:
        SessionClass ses = SessionClass.getInstance();
    int userId = ses.getU_id();
    
    try {
        // Only attempt file operations if we have a file
        if (selectedFile != null && destination != null) {
            Files.createDirectories(Paths.get("src/userimages"));
            Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
        
        // Update database (will store NULL if destination is null)
        dbConnect conn = new dbConnect();
        String update = "UPDATE user SET u_image = ? WHERE u_id = ?";
        
        try (PreparedStatement pst = conn.getConnection().prepareStatement(update)) {
            pst.setString(1, destination); // Can be null
            pst.setInt(2, userId);
            pst.executeUpdate();
        }
        
        // Update session
        ses.setU_image(destination); // Can be null
        displayUserImage(image); // Refresh display
        
        JOptionPane.showMessageDialog(this, "Image updated successfully");
        
    } catch (IOException | SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
    }
        
    }//GEN-LAST:event_addMouseClicked

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
            java.util.logging.Logger.getLogger(employeeinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(employeeinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(employeeinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(employeeinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new employeeinfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel add;
    private javax.swing.JLabel contactshow;
    private javax.swing.JLabel emailshow;
    private javax.swing.JLabel fnameshow;
    private javax.swing.JLabel idshow;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel1026;
    private javax.swing.JPanel jPanel1027;
    private javax.swing.JPanel jPanel1030;
    private javax.swing.JPanel jPanel1031;
    private javax.swing.JPanel jPanel1032;
    private javax.swing.JPanel jPanel1033;
    private javax.swing.JPanel jPanel1034;
    private javax.swing.JPanel jPanel1035;
    private javax.swing.JPanel jPanel1036;
    private javax.swing.JPanel jPanel1037;
    private javax.swing.JPanel jPanel1038;
    private javax.swing.JPanel jPanel1039;
    private javax.swing.JPanel jPanel1040;
    private javax.swing.JPanel jPanel1041;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JLabel lnameshow;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel passwordshow;
    private javax.swing.JPanel remove;
    private javax.swing.JPanel select;
    private javax.swing.JPanel tologin;
    private javax.swing.JPanel updatePanel;
    private javax.swing.JLabel usernameshow;
    // End of variables declaration//GEN-END:variables
}
