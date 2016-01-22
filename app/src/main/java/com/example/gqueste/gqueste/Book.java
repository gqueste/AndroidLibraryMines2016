package com.example.gqueste.gqueste;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Gabriel QUESTE on 22/01/2016.
 */
public class Book implements Parcelable{

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

    protected Book(Parcel in) {
        isbn = in.readString();
        title = in.readString();
        price = in.readFloat();
        cover = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(isbn);
        dest.writeString(title);
        dest.writeFloat(price);
        dest.writeString(cover);
    }
}
