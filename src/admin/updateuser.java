/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import static admin.adduser.mail;
import static admin.adduser.usname;
import config.SessionClass;
import config.dbConnect;
import config.passwordHasher;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
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
public class updateuser extends javax.swing.JFrame {

    /**
     * Creates new form updateuser
     */
    public updateuser() {
        initComponents();
        displayUserImage(image);
        remove.setEnabled(false);
remove.setCursor(Cursor.getDefaultCursor());

select.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            path = "src/userimages/" + selectedFile.getName();
            displayUserImage(image, path);

            // Visually enable the remove panel (adapt based on your setup)
            // Example: removeLabel.setEnabled(true);
            //          remove.setBackground(originalRemoveColor);
            remove.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            // Visually indicate selectPanel is now inactive (optional)
            // Example: selectPanel.setBackground(Color.LIGHT_GRAY);
            select.setCursor(Cursor.getDefaultCursor());
            // You might also want to prevent further clicks on selectPanel here
            select.removeMouseListener(this); // Remove this MouseListener
        }
    }
});


          seepass3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Toggle password visibility
                if (confirmpass.getEchoChar() == '\0') {
                    // Hide the password
                    confirmpass.setEchoChar('•'); // Default echo character for passwords
                    seepass3.setText("");
                } else {
                    // Show the password
                    confirmpass.setEchoChar('\0'); // Set echo char to null to show the password
                    seepass3.setText("");
                }
            }
        });
        
          seepass2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Toggle password visibility
                if (newpass.getEchoChar() == '\0') {
                    // Hide the password
                    newpass.setEchoChar('•'); // Default echo character for passwords
                    seepass2.setText("");
                } else {
                    // Show the password
                    newpass.setEchoChar('\0'); // Set echo char to null to show the password
                    seepass2.setText("");
                }
            }
        });
        
        
         seepass1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Toggle password visibility
                if (oldpass.getEchoChar() == '\0') {
                    // Hide the password
                    oldpass.setEchoChar('•'); // Default echo character for passwords
                    seepass1.setText("");
                } else {
                    // Show the password
                    oldpass.setEchoChar('\0'); // Set echo char to null to show the password
                    seepass1.setText("");
                }
            }
        });
    }
  public void displayUserImage(JLabel admiimage) {
        SessionClass session = SessionClass.getInstance();
        String imagePath = session.getU_image();
        displayUserImage(admiimage, imagePath);
    }

    public void displayUserImage(JLabel label, String imagePath) {
        if (imagePath != null && !imagePath.isEmpty()) {
            try {
                label.setIcon(ResizeImage(imagePath, null, label));
            } catch (Exception e) {
                label.setIcon(new ImageIcon(getClass().getResource("/image/default_user.png")));
            }
        } else {
            label.setIcon(new ImageIcon(getClass().getResource("/image/default_user.png")));
        }
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
     private void logUserUpdateAction(int userId, String oldUsername, String newUsername) {
        String sql = "INSERT INTO logs (user_id, act, log_date) VALUES (?, ?, NOW())";

        dbConnect db = new dbConnect();
        try (Connection conn = db.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            pstmt.setString(2, "User Updated: " + oldUsername + " to " + newUsername);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Failed to log user update action: " + e.getMessage());
        }
    }

    private int getCurrentUserId() {

        config.SessionClass ses = config.SessionClass.getInstance();
        return ses.getU_id();
    }
    
    
    
     public static String mail, usname;
    public boolean dupcheck(){
        
        dbConnect db = new dbConnect();
         
        try{
        String que = "SELECT * FROM user WHERE u_username='"+usernamere.getText()+"' OR u_email='"+email.getText()+"'";    
            ResultSet resultset = db.getData(que);
            if(resultset.next()){
                mail = resultset.getString("u_email");
            
                if(mail.equals(email.getText())){
                    
                    JOptionPane.showMessageDialog(null, "The email already existed",
                "Error Registration", JOptionPane.ERROR_MESSAGE);
                    email.setText("");
                }
                usname = resultset.getString("u_username");
                 if(usname.equals(usernamere.getText())){
                    
                    JOptionPane.showMessageDialog(null, "The username already existed",
                "Error Registration", JOptionPane.ERROR_MESSAGE);
                    usernamere.setText("");
                }
                System.out.println(""+usname);
             return true;   
            }
            
            else {
                
                return false;
            }
        }catch(SQLException ex){
            System.out.println(""+ex);
            return false;
        }
    }
    
       public boolean updatecheck(){
        
        dbConnect db = new dbConnect();
         
        try{
        String que = "SELECT * FROM user WHERE (u_username='"+usernamere.getText()+"' OR u_email='"+email.getText()+"') AND u_id != '"+uid.getText()+"' ";    
            ResultSet resultset = db.getData(que);
            if(resultset.next()){
                mail = resultset.getString("u_email");
            
                if(mail.equals(email.getText())){
                    
                    JOptionPane.showMessageDialog(null, "The email already existed",
                "Error Registration", JOptionPane.ERROR_MESSAGE);
                    email.setText("");
                }
                usname = resultset.getString("u_username");
                 if(usname.equals(usernamere.getText())){
                    
                    JOptionPane.showMessageDialog(null, "The username already existed",
                "Error Registration", JOptionPane.ERROR_MESSAGE);
                    usernamere.setText("");
                }
                System.out.println(""+usname);
             return true;   
            }
            
            else {
                
                return false;
            }
        }catch(SQLException ex){
            System.out.println(""+ex);
            return false;
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

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        email = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        lname = new javax.swing.JTextField();
        usernamere = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        jLabel270 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ty = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        uid = new javax.swing.JTextField();
        jLabel271 = new javax.swing.JLabel();
        jLabel1040 = new javax.swing.JLabel();
        oldpass = new javax.swing.JPasswordField();
        seepass3 = new javax.swing.JLabel();
        confirmpass = new javax.swing.JPasswordField();
        jLabel75 = new javax.swing.JLabel();
        newpass = new javax.swing.JPasswordField();
        jLabel76 = new javax.swing.JLabel();
        seepass1 = new javax.swing.JLabel();
        seepass2 = new javax.swing.JLabel();
        jPanel261 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        remove = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        select = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        update = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1039 = new javax.swing.JLabel();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(0, 102, 102));
        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("UPDATE USER");
        jLabel6.setToolTipText("");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 300, 70));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/editthis.png"))); // NOI18N
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 80, 70));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 700, 70));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 830, 110));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 2, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        email.setBackground(new java.awt.Color(204, 204, 204));
        email.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        email.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel2.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 200, 30));

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(0, 102, 102));
        jLabel72.setText("Email:");
        jPanel2.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, -1, -1));

        lname.setBackground(new java.awt.Color(204, 204, 204));
        lname.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lname.setBorder(new javax.swing.border.MatteBorder(null));
        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });
        jPanel2.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 200, 30));

        usernamere.setBackground(new java.awt.Color(204, 204, 204));
        usernamere.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        usernamere.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usernamere.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel2.add(usernamere, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 200, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Username:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("First Name:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, -1, -1));

        fname.setBackground(new java.awt.Color(204, 204, 204));
        fname.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        fname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fname.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel2.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 200, 30));

        contact.setBackground(new java.awt.Color(204, 204, 204));
        contact.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        contact.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        contact.setBorder(new javax.swing.border.MatteBorder(null));
        contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactActionPerformed(evt);
            }
        });
        jPanel2.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 200, 30));

        jLabel270.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel270.setForeground(new java.awt.Color(0, 102, 102));
        jLabel270.setText("Contact:");
        jPanel2.add(jLabel270, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, -1, -1));

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(0, 102, 102));
        jLabel74.setText("Confirm Password:");
        jPanel2.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 370, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("User Type:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 80, 20));

        ty.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select a Type", "Admin", "Customer", "Employee", " " }));
        ty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tyActionPerformed(evt);
            }
        });
        jPanel2.add(ty, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 210, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("User Status");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 90, 20));

        status.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Pending" }));
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        jPanel2.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, 210, 30));

        uid.setEditable(false);
        uid.setBackground(new java.awt.Color(204, 204, 204));
        uid.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        uid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        uid.setBorder(new javax.swing.border.MatteBorder(null));
        uid.setEnabled(false);
        uid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uidActionPerformed(evt);
            }
        });
        jPanel2.add(uid, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 210, 30));

        jLabel271.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel271.setForeground(new java.awt.Color(0, 102, 102));
        jLabel271.setText("ID:");
        jPanel2.add(jLabel271, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, -1, -1));

        jLabel1040.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/backwardset.png"))); // NOI18N
        jLabel1040.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1040MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1040, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 40, 40));
        jPanel2.add(oldpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 250, 210, 30));

        seepass3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seepass3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/eyegamay.png"))); // NOI18N
        jPanel2.add(seepass3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 390, 40, 30));
        jPanel2.add(confirmpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 390, 210, 30));

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(0, 102, 102));
        jLabel75.setText("Old Password:");
        jPanel2.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, -1, -1));
        jPanel2.add(newpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 320, 210, 30));

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(0, 102, 102));
        jLabel76.setText("Enter New Password:");
        jPanel2.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 300, -1, -1));

        seepass1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seepass1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/eyegamay.png"))); // NOI18N
        jPanel2.add(seepass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 250, 40, 30));

        seepass2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seepass2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/eyegamay.png"))); // NOI18N
        jPanel2.add(seepass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 320, 40, 30));

        jPanel261.setBackground(new java.awt.Color(255, 255, 255));
        jPanel261.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel261.setLayout(null);

        image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/newuserprofile.png"))); // NOI18N
        jPanel261.add(image);
        image.setBounds(10, 10, 200, 220);

        jPanel2.add(jPanel261, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 220, 240));

        remove.setBackground(new java.awt.Color(0, 102, 102));
        remove.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                removeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                removeMouseExited(evt);
            }
        });
        remove.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(0, 102, 102));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        remove.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 110, 40));

        jLabel71.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel71.setText("REMOVE");
        jLabel71.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel71MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel71MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel71MouseExited(evt);
            }
        });
        remove.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 70, 30));

        jPanel2.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 90, 50));

        select.setBackground(new java.awt.Color(0, 102, 102));
        select.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        select.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                selectMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                selectMouseExited(evt);
            }
        });
        select.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(0, 102, 102));
        jPanel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        select.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 110, 40));

        jLabel77.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel77.setText("SELECT");
        jLabel77.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel77MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel77MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel77MouseExited(evt);
            }
        });
        select.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 6, 70, 40));

        jPanel2.add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 90, 50));

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(0, 102, 102));
        jLabel73.setText("Last Name:");
        jPanel2.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 830, 440));

        update.setBackground(new java.awt.Color(0, 102, 102));
        update.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        update.setEnabled(false);
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

        jPanel6.setBackground(new java.awt.Color(0, 102, 102));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Update");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 170, 20));

        update.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 560, 170, 60));

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Update User");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });
        update.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 30));

        jPanel1.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 570, 170, 50));

        jLabel1039.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/undostan.png"))); // NOI18N
        jLabel1039.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1039MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1039, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 580, 30, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactActionPerformed

    private void tyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tyActionPerformed

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

    private void jLabel1039MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1039MouseClicked
        // TODO add your handling code here:

        usernamere.setText(null);
        fname.setText(null);
        lname.setText(null);
        email.setText(null);
        contact.setText(null);
        oldpass.setText(null);
       newpass.setText(null);
       confirmpass.setText(null);
    }//GEN-LAST:event_jLabel1039MouseClicked

    private void uidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uidActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseClicked

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
     dbConnect db = new dbConnect();
SessionClass ses = SessionClass.getInstance();
String originalUsername = "";
String updatedImagePathInDB = "";
int userIdToUpdate = -1;
String currentImagePathInDB = "";

try {
    userIdToUpdate = Integer.parseInt(uid.getText());
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Invalid User ID.", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}

try {
    String query = "SELECT u_password, u_username, u_image FROM user WHERE u_id = ?";
    try (PreparedStatement pstmt = db.getConnection().prepareStatement(query)) {
        pstmt.setInt(1, userIdToUpdate);
        ResultSet resultset = pstmt.executeQuery();

        if (resultset.next()) {
            String storedPasswordHash = resultset.getString("u_password");
            originalUsername = resultset.getString("u_username");
            currentImagePathInDB = resultset.getString("u_image");
            String enteredPassword = oldpass.getText().trim();
            String enteredPasswordHash = passwordHasher.hashPassword(enteredPassword);

            if (!storedPasswordHash.equals(enteredPasswordHash)) {
                JOptionPane.showMessageDialog(null, "Old Password Is Incorrect");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "User not found");
            return;
        }
    }

    if (!newpass.getText().equals(confirmpass.getText())) {
        JOptionPane.showMessageDialog(null, "New password and confirmation do not match", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (usernamere.getText().isEmpty() || fname.getText().isEmpty() || lname.getText().isEmpty() ||
        email.getText().isEmpty() || contact.getText().isEmpty() || oldpass.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "All fields are required", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    String selectedType = (String) ty.getSelectedItem();
    if (selectedType == null || selectedType.equals("Please Select a Type")) {
        JOptionPane.showMessageDialog(null, "Please select a valid user type", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (!email.getText().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
        JOptionPane.showMessageDialog(null, "Please enter a valid email address", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (oldpass.getText().length() < 8) {
        JOptionPane.showMessageDialog(null, "Password must be at least 8 characters", "Error", JOptionPane.ERROR_MESSAGE);
        oldpass.setText("");
        return;
    }
    if (!contact.getText().matches("\\d+") || contact.getText().length() < 11 || contact.getText().length() > 15) {
        JOptionPane.showMessageDialog(null, "Contact must be 11-15 digits", "Error", JOptionPane.ERROR_MESSAGE);
        contact.setText("");
        return;
    }
    if (updatecheck()) {
        JOptionPane.showMessageDialog(null, "Username or email already exists", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String npass = passwordHasher.hashPassword(newpass.getText());

    String updateQuery = "UPDATE user SET " +
                         "u_username = ?, " +
                         "u_fname = ?, " +
                         "u_lname = ?, " +
                         "u_email = ?, " +
                         "u_contact = ?, " +
                         "u_type = ?, " +
                         "u_password = ?, " +
                         "u_stat = ?";

    String newImagePath = currentImagePathInDB;

    if (selectedFile != null) {
        String userImagesFolder = "src/userimages";
        String originalFileName = selectedFile.getName();
        String fileExtension = "";
        int dotIndex = originalFileName.lastIndexOf('.');
        if (dotIndex > 0 && dotIndex < originalFileName.length() - 1) {
            fileExtension = originalFileName.substring(dotIndex);
        }
        String uniqueFileName = UUID.randomUUID().toString() + fileExtension;
        newImagePath = userImagesFolder + "/" + uniqueFileName;

        File destDir = new File(userImagesFolder);
        if (!destDir.exists()) {
            destDir.mkdirs();
        }

        try {
            Files.copy(selectedFile.toPath(), new File(newImagePath).toPath(), StandardCopyOption.REPLACE_EXISTING);
            updateQuery += ", u_image = ?";
            updatedImagePathInDB = newImagePath;
        } catch (IOException ex) {
            System.out.println("Image Update Error: " + ex);
            JOptionPane.showMessageDialog(null, "Error updating image", "Image Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    } else if (path.equals("src/userimages/default_user.png")) {
        updateQuery += ", u_image = ?";
        newImagePath = path;
        updatedImagePathInDB = path;
    } else if (!path.isEmpty()) {
        updateQuery += ", u_image = ?";
        newImagePath = path;
        updatedImagePathInDB = path;
    } else {
        updateQuery += ", u_image = ?";
        newImagePath = currentImagePathInDB;
        updatedImagePathInDB = currentImagePathInDB;
    }

    updateQuery += " WHERE u_id = ?";

    try (PreparedStatement pstmt = db.getConnection().prepareStatement(updateQuery)) {
        pstmt.setString(1, usernamere.getText());
        pstmt.setString(2, fname.getText());
        pstmt.setString(3, lname.getText());
        pstmt.setString(4, email.getText());
        pstmt.setString(5, contact.getText());
        pstmt.setString(6, selectedType);
        pstmt.setString(7, npass);
        pstmt.setString(8, status.getSelectedItem().toString());
        pstmt.setString(9, newImagePath);
        pstmt.setInt(10, userIdToUpdate);

        pstmt.executeUpdate();
    }

    // Handle image file operations
    if (selectedFile != null) {
        if (oldpath != null && !oldpath.isEmpty() && !oldpath.equals(path)) {
            imageUpdater(oldpath, path);
        }
    } else {
        if (oldpath != null && !oldpath.isEmpty() && !oldpath.equals("src/userimages/default_user.png") && !oldpath.equals(path)) {
            File existingFile = new File(oldpath);
            if (existingFile.exists()) {
                existingFile.delete();
            }
        }
    }

    int currentUserId = getCurrentUserId();
    logUserUpdateAction(currentUserId, originalUsername, usernamere.getText());

    JOptionPane.showMessageDialog(null, "Update Successful");

    // Check if the updated user is the logged-in admin
    if (userIdToUpdate == currentUserId) {
        ses.setU_image(newImagePath); // Update the SessionClass immediately
        // Optionally, refresh the admin's dashboard UI here if it's visible
    }

    // Refresh the UI of the updateuser panel
    displayUserImage(image, newImagePath);

    admindash ad = new admindash();
    ad.setVisible(true);
    this.dispose();

} catch (SQLException | NoSuchAlgorithmException ex) {
    System.out.println("Error: " + ex);
    JOptionPane.showMessageDialog(null, "An error occurred during update", "Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_updateMouseClicked

    private void jLabel1040MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1040MouseClicked
        // TODO add your handling code here:

        cuspage ad = new cuspage();
        ad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1040MouseClicked

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

    private void updateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseEntered
        // TODO add your handling code here:
        update.setBackground(logcolor);
        
    }//GEN-LAST:event_updateMouseEntered

    private void updateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseExited
        // TODO add your handling code here:
        update.setBackground(excolor);
    }//GEN-LAST:event_updateMouseExited

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        // TODO add your handling code here:
        
        update.setBackground(logcolor);
        
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        // TODO add your handling code here:
        
        update.setBackground(excolor);
        
    }//GEN-LAST:event_jLabel7MouseExited

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
     dbConnect db = new dbConnect();
SessionClass ses = SessionClass.getInstance();
String originalUsername = "";
String updatedImagePathInDB = "";
int userIdToUpdate = -1;
String currentImagePathInDB = "";

try {
    userIdToUpdate = Integer.parseInt(uid.getText());
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Invalid User ID.", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}

try {
    String query = "SELECT u_password, u_username, u_image FROM user WHERE u_id = ?";
    try (PreparedStatement pstmt = db.getConnection().prepareStatement(query)) {
        pstmt.setInt(1, userIdToUpdate);
        ResultSet resultset = pstmt.executeQuery();

        if (resultset.next()) {
            String storedPasswordHash = resultset.getString("u_password");
            originalUsername = resultset.getString("u_username");
            currentImagePathInDB = resultset.getString("u_image");
            String enteredPassword = oldpass.getText().trim();
            String enteredPasswordHash = passwordHasher.hashPassword(enteredPassword);

            if (!storedPasswordHash.equals(enteredPasswordHash)) {
                JOptionPane.showMessageDialog(null, "Old Password Is Incorrect");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "User not found");
            return;
        }
    }

    if (!newpass.getText().equals(confirmpass.getText())) {
        JOptionPane.showMessageDialog(null, "New password and confirmation do not match", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (usernamere.getText().isEmpty() || fname.getText().isEmpty() || lname.getText().isEmpty() ||
        email.getText().isEmpty() || contact.getText().isEmpty() || oldpass.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "All fields are required", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    String selectedType = (String) ty.getSelectedItem();
    if (selectedType == null || selectedType.equals("Please Select a Type")) {
        JOptionPane.showMessageDialog(null, "Please select a valid user type", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (!email.getText().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
        JOptionPane.showMessageDialog(null, "Please enter a valid email address", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (oldpass.getText().length() < 8) {
        JOptionPane.showMessageDialog(null, "Password must be at least 8 characters", "Error", JOptionPane.ERROR_MESSAGE);
        oldpass.setText("");
        return;
    }
    if (!contact.getText().matches("\\d+") || contact.getText().length() < 11 || contact.getText().length() > 15) {
        JOptionPane.showMessageDialog(null, "Contact must be 11-15 digits", "Error", JOptionPane.ERROR_MESSAGE);
        contact.setText("");
        return;
    }
    if (updatecheck()) {
        JOptionPane.showMessageDialog(null, "Username or email already exists", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String npass = passwordHasher.hashPassword(newpass.getText());

    String updateQuery = "UPDATE user SET " +
                         "u_username = ?, " +
                         "u_fname = ?, " +
                         "u_lname = ?, " +
                         "u_email = ?, " +
                         "u_contact = ?, " +
                         "u_type = ?, " +
                         "u_password = ?, " +
                         "u_stat = ?";

    String newImagePath = currentImagePathInDB;

    if (selectedFile != null) {
        String userImagesFolder = "src/userimages";
        String originalFileName = selectedFile.getName();
        String fileExtension = "";
        int dotIndex = originalFileName.lastIndexOf('.');
        if (dotIndex > 0 && dotIndex < originalFileName.length() - 1) {
            fileExtension = originalFileName.substring(dotIndex);
        }
        String uniqueFileName = UUID.randomUUID().toString() + fileExtension;
        newImagePath = userImagesFolder + "/" + uniqueFileName;

        File destDir = new File(userImagesFolder);
        if (!destDir.exists()) {
            destDir.mkdirs();
        }

        try {
            Files.copy(selectedFile.toPath(), new File(newImagePath).toPath(), StandardCopyOption.REPLACE_EXISTING);
            updateQuery += ", u_image = ?";
            updatedImagePathInDB = newImagePath;
        } catch (IOException ex) {
            System.out.println("Image Update Error: " + ex);
            JOptionPane.showMessageDialog(null, "Error updating image", "Image Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    } else if (path.equals("src/userimages/default_user.png")) {
        updateQuery += ", u_image = ?";
        newImagePath = path;
        updatedImagePathInDB = path;
    } else if (!path.isEmpty()) {
        updateQuery += ", u_image = ?";
        newImagePath = path;
        updatedImagePathInDB = path;
    } else {
        updateQuery += ", u_image = ?";
        newImagePath = currentImagePathInDB;
        updatedImagePathInDB = currentImagePathInDB;
    }

    updateQuery += " WHERE u_id = ?";

    try (PreparedStatement pstmt = db.getConnection().prepareStatement(updateQuery)) {
        pstmt.setString(1, usernamere.getText());
        pstmt.setString(2, fname.getText());
        pstmt.setString(3, lname.getText());
        pstmt.setString(4, email.getText());
        pstmt.setString(5, contact.getText());
        pstmt.setString(6, selectedType);
        pstmt.setString(7, npass);
        pstmt.setString(8, status.getSelectedItem().toString());
        pstmt.setString(9, newImagePath);
        pstmt.setInt(10, userIdToUpdate);

        pstmt.executeUpdate();
    }

    // Handle image file operations
    if (selectedFile != null) {
        if (oldpath != null && !oldpath.isEmpty() && !oldpath.equals(path)) {
            imageUpdater(oldpath, path);
        }
    } else {
        if (oldpath != null && !oldpath.isEmpty() && !oldpath.equals("src/userimages/default_user.png") && !oldpath.equals(path)) {
            File existingFile = new File(oldpath);
            if (existingFile.exists()) {
                existingFile.delete();
            }
        }
    }

    int currentUserId = getCurrentUserId();
    logUserUpdateAction(currentUserId, originalUsername, usernamere.getText());

    JOptionPane.showMessageDialog(null, "Update Successful");

    // Check if the updated user is the logged-in admin
    if (userIdToUpdate == currentUserId) {
        ses.setU_image(newImagePath); // Update the SessionClass immediately
        // Optionally, refresh the admin's dashboard UI here if it's visible
    }

    // Refresh the UI of the updateuser panel
    displayUserImage(image, newImagePath);

    admindash ad = new admindash();
    ad.setVisible(true);
    this.dispose();

} catch (SQLException | NoSuchAlgorithmException ex) {
    System.out.println("Error: " + ex);
    JOptionPane.showMessageDialog(null, "An error occurred during update", "Error", JOptionPane.ERROR_MESSAGE);
}

    }//GEN-LAST:event_jLabel7MouseClicked

    private void removeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMouseEntered
        // TODO add your handling code here:
        
        remove.setBackground(logcolor);
    }//GEN-LAST:event_removeMouseEntered

    private void selectMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectMouseEntered
        // TODO add your handling code here:
        select.setBackground(logcolor);
        
    }//GEN-LAST:event_selectMouseEntered

    private void selectMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectMouseExited
        // TODO add your handling code here:
           select.setBackground(excolor);
    }//GEN-LAST:event_selectMouseExited

    private void jLabel77MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel77MouseClicked
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
        
    }//GEN-LAST:event_jLabel77MouseClicked

    private void jLabel77MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel77MouseEntered
        // TODO add your handling code here:
        
           select.setBackground(logcolor);
    }//GEN-LAST:event_jLabel77MouseEntered

    private void jLabel77MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel77MouseExited
        // TODO add your handling code here:
        
           select.setBackground(excolor);
    }//GEN-LAST:event_jLabel77MouseExited

    private void removeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMouseExited
        // TODO add your handling code here:
        
         remove.setBackground(excolor);
    }//GEN-LAST:event_removeMouseExited

    private void jLabel71MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel71MouseClicked
        // TODO add your handling code here:
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
       
        
        
    }//GEN-LAST:event_jLabel71MouseClicked

    private void jLabel71MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel71MouseEntered
        // TODO add your handling code here:
        
         remove.setBackground(logcolor);
    }//GEN-LAST:event_jLabel71MouseEntered

    private void jLabel71MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel71MouseExited
        // TODO add your handling code here:
        
         remove.setBackground(excolor);
    }//GEN-LAST:event_jLabel71MouseExited

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
            java.util.logging.Logger.getLogger(updateuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateuser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateuser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confirmpass;
    public javax.swing.JTextField contact;
    public javax.swing.JTextField email;
    public javax.swing.JTextField fname;
    public javax.swing.JLabel image;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel1039;
    private javax.swing.JLabel jLabel1040;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel270;
    private javax.swing.JLabel jLabel271;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel261;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    public javax.swing.JTextField lname;
    private javax.swing.JPasswordField newpass;
    public javax.swing.JPasswordField oldpass;
    private javax.swing.JPanel remove;
    private javax.swing.JLabel seepass1;
    private javax.swing.JLabel seepass2;
    private javax.swing.JLabel seepass3;
    private javax.swing.JPanel select;
    public javax.swing.JComboBox<String> status;
    public javax.swing.JComboBox<String> ty;
    public javax.swing.JTextField uid;
    public javax.swing.JPanel update;
    public javax.swing.JTextField usernamere;
    // End of variables declaration//GEN-END:variables
}
