package com.example.gqueste.gqueste;

/**
 * Created by Gabriel QUESTE on 22/01/2016.
 */
public class Book {

    public final String isbn;
    public final String title;
    public final float price;
    public final String cover;

    public Book(String isbn, String title, float price, String cover){
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.cover = cover;
    }

}
