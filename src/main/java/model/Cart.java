/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author NGMINHAT
 */
public class Cart {

    int id;
    int proID;
    String userName;
    String image;
    String productName;
    int quantity;
    String size;
    double price;

    public Cart() {
    }
//c

    public Cart(int id, String productName, String image, int quantity, String size, double price,int proID) {
        this.id = id;
        this.productName = productName;
        this.image = image;
        this.quantity = quantity;
        this.size = size;
        this.price = price;
        this.proID=proID;
    }
    

    public Cart(int proID, String userName, int quantity, String size, double price) {
        this.proID = proID;
        this.userName = userName;
        this.quantity = quantity;
        this.size = size;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProID() {
        return proID;
    }

    public void setProID(int proID) {
        this.proID = proID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
