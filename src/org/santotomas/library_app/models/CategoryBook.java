package org.santotomas.library_app.models;

public class CategoryBook {

    private int id;
    private int category_id_fk;
    private int book_id_fk;

    public CategoryBook() {
    }

    public CategoryBook(int id, int category_id_fk, int book_id_fk) {
        this.id = id;
        this.category_id_fk = category_id_fk;
        this.book_id_fk = book_id_fk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_id_fk() {
        return category_id_fk;
    }

    public void setCategory_id_fk(int category_id_fk) {
        this.category_id_fk = category_id_fk;
    }

    public int getBook_id_fk() {
        return book_id_fk;
    }

    public void setBook_id_fk(int book_id_fk) {
        this.book_id_fk = book_id_fk;
    }

    @Override
    public String toString() {
        return "CategoryBook{" +
                "id=" + id +
                ", category_id_fk=" + category_id_fk +
                ", book_id_fk=" + book_id_fk +
                '}';
    }

}
