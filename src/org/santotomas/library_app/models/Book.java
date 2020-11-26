package org.santotomas.library_app.models;

import java.util.Date;

public class Book {
    private String isbn; // uuid
    private String title;
    private String description;
    private int price;
    private int category_id;
    private String author;
    private int stock;
    private Date release_date;

    public Book() {
    }

    public Book(String isbn, String title, String description, int price, int category_id, String author,
                int stock, Date release_date) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.price = price;
        this.category_id = category_id;
        this.author = author;
        this.stock = stock;
        this.release_date = release_date;
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

    public int getCategoryId() {
        return category_id;
    }

    public void setCategoryId(int category_id) {
        this.category_id = category_id;
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

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category=" + category_id +
                ", author='" + author + '\'' +
                ", stock=" + stock +
                ", release_date=" + release_date +
                '}';
    }
}
