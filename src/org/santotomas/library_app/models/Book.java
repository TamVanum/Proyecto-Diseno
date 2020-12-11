package org.santotomas.library_app.models;

import java.util.Date;

public class Book {
    private int id;
    private String isbn; // estandaraized
    private String title;
    private String description;
    private int price;
    private String author;
    private int stock;
    private Date release_date;

    public Book() {
    }

    public Book(int id, String isbn, String title, String description, int price, String author, int stock, Date release_date) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.price = price;
        this.author = author;
        this.stock = stock;
        this.release_date = release_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }
}
