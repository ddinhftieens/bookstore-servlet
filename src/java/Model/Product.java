/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Dell
 */
public class Product {
    private int ID,numberpage,quantity,IDcatalog;
    private String nameBook,author,IDcode,datecreated,description,dateofissue,NXB;
    private float price,sale;
    private Catalog catalog;
    private String status;

    public Product() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNumberpage() {
        return numberpage;
    }

    public void setNumberpage(int numberpage) {
        this.numberpage = numberpage;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIDcode() {
        return IDcode;
    }

    public void setIDcode(String IDcode) {
        this.IDcode = IDcode;
    }

    public String getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(String datecreated) {
        this.datecreated = datecreated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateofissue() {
        return dateofissue;
    }

    public void setDateofissue(String dateofissue) {
        this.dateofissue = dateofissue;
    }

    public String getNXB() {
        return NXB;
    }

    public void setNXB(String NXB) {
        this.NXB = NXB;
    }

    public int getIDcatalog() {
        return IDcatalog;
    }

    public void setIDcatalog(int IDcatalog) {
        this.IDcatalog = IDcatalog;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getSale() {
        return sale;
    }

    public void setSale(float sale) {
        this.sale = sale;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" + "ID=" + ID + ", numberpage=" + numberpage + ", quantity=" + quantity + ", nameBook=" + nameBook + ", author=" + author + ", IDcode=" + IDcode + ", datecreated=" + datecreated + ", description=" + description + ", dateofissue=" + dateofissue + ", NXB=" + NXB + ", price=" + price + ", sale=" + sale + '}';
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
