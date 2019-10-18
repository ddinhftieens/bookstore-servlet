/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author Dell
 */
public class Cart implements Serializable{
    private int quantity;
    private float totalPrice,price;
    private String IDcode,name;
    private int IDproduct;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getIDproduct() {
        return IDproduct;
    }

    public void setIDproduct(int IDproduct) {
        this.IDproduct = IDproduct;
    }

    

    public String getIDcode() {
        return IDcode;
    }

    public void setIDcode(String IDcode) {
        this.IDcode = IDcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
