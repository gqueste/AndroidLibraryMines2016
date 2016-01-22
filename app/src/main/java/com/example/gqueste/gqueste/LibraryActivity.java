package com.example.gqueste.gqueste;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LibraryActivity extends AppCompatActivity {


    private static final Random RANDOM = new Random(); //TODO remove


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);


        //TODO Fragments : create Library Fragment


        List<Book> books = getBooks();

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.library_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        RecyclerView.Adapter mAdapter = new BookAdapter(books);
        mRecyclerView.setAdapter(mAdapter);

    }

    private List<Book> getBooks() {
        ArrayList<Book> books = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            books.add(new Book("eyubzeuvzeyvzyeuvyvytvuzeu", String.format("Garry Potier Tome %d", i), RANDOM.nextInt(30), "http://google.com"));
        }
        return books;
    }
}

