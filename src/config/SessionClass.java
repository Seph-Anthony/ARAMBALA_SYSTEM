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
    private double p_price; // Changed to double to match new database type
    private int p_stock;
    private String p_status;
    private int order_id; // Added order_id
    private double order_cash; // Added order_cash
    private double order_change; // Added order_change

    public SessionClass() {

    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public static synchronized SessionClass getInstance() {
        if (instance == null) {
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

    public double getP_price() { // Changed return type to double
        return p_price;
    }

    public void setP_price(double p_price) { // Changed parameter type to double
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

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public double getOrder_cash() {
        return order_cash;
    }

    public void setOrder_cash(double order_cash) {
        this.order_cash = order_cash;
    }

    public double getOrder_change() {
        return order_change;
    }

    public void setOrder_change(double order_change) {
        this.order_change = order_change;
    }
}
