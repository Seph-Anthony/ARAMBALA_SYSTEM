/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

/**
 *
 * @author Admin
 */
public class SessionClass {

    private static SessionClass instance;
    private int u_id;
    private String username;
     private String fname;
      private String lname;
         private String email;
          private String contact;
           private String type;
            private String stat;
             private String pass;
             private String u_image;
             private int p_id;
              private String p_name;
               private String p_category;
                private String p_brand;
                 private int p_price;
                  private int p_stock;
                   private String p_status ;

    // Attributes from the 'process' table
    private int s_id;
    private int s_quantity;
    private double s_totalam;
    private double s_cash;
    private double s_change;
    private String s_status;
    private String s_date;

    public SessionClass() {

    }


    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public static synchronized SessionClass getInstance() {
       if(instance == null){
           instance = new SessionClass();

       }
       return instance;
    }

    public static boolean isInstanceEmpty() {
    return instance == null;
    }

     public int getU_id() {
         return u_id;
     }

     public void setU_id(int u_id) {
         this.u_id = u_id;
     }

     public String getUsername() {
         return username;
     }

     public void setUsername(String username) {
         this.username = username;
     }

     public String getFname() {
         return fname;
     }

     public void setFname(String fname) {
         this.fname = fname;
     }

     public String getLname() {
         return lname;
     }

     public void setLname(String lname) {
         this.lname = lname;
     }

     public String getEmail() {
         return email;
     }

     public void setEmail(String email) {
         this.email = email;
     }

     public String getContact() {
         return contact;
     }

     public void setContact(String contact) {
         this.contact = contact;
     }

     public String getType() {
         return type;
     }

     public void setType(String type) {
         this.type = type;
     }


     public String getStat() {
         return stat;
     }

     public void setStat(String stat) {
         this.stat = stat;
     }

     public String getU_image() {
         return u_image;
     }

     public void setU_image(String u_image) {
         this.u_image = u_image;
     }


     public int getP_id() {
         return p_id;
     }

     public void setP_id(int p_id) {
         this.p_id = p_id;
     }

     public String getP_name() {
         return p_name;
     }

     public void setP_name(String p_name) {
         this.p_name = p_name;
     }

     public String getP_category() {
         return p_category;
     }

     public void setP_category(String p_category) {
         this.p_category = p_category;
     }

     public String getP_brand() {
         return p_brand;
     }

     public void setP_brand(String p_brand) {
         this.p_brand = p_brand;
     }

     public int getP_price() {
         return p_price;
     }

     public void setP_price(int p_price) {
         this.p_price = p_price;
     }

     public int getP_stock() {
         return p_stock;
     }

     public void setP_stock(int p_stock) {
         this.p_stock = p_stock;
     }

     public String getP_status() {
         return p_status;
     }

     public void setP_status(String p_status) {
         this.p_status = p_status;
     }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public int getS_quantity() {
        return s_quantity;
    }

    public void setS_quantity(int s_quantity) {
        this.s_quantity = s_quantity;
    }

    public double getS_totalam() {
        return s_totalam;
    }

    public void setS_totalam(double s_totalam) {
        this.s_totalam = s_totalam;
    }

    public double getS_cash() {
        return s_cash;
    }

    public void setS_cash(double s_cash) {
        this.s_cash = s_cash;
    }

    public double getS_change() {
        return s_change;
    }

    public void setS_change(double s_change) {
        this.s_change = s_change;
    }

    public String getS_status() {
        return s_status;
    }

    public void setS_status(String s_status) {
        this.s_status = s_status;
    }

    public String getS_date() {
        return s_date;
    }

    public void setS_date(String s_date) {
        this.s_date = s_date;
    }
}