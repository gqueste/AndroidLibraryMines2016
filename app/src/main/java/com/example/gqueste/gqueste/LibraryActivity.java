package com.example.gqueste.gqueste;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

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


        final List<Book> books = getBooks();

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.library_recycler_view);
        mRecyclerView.addOnItemTouchListener(new BookItemClickListener(this,
                new BookItemClickListener.SimpleOnItemClickListener(){
                    @Override
                    public void onItemClick(View childView, int position) {
                        Toast.makeText(childView.getContext(), books.get(position).title, Toast.LENGTH_SHORT).show();
                    }
                }));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new

    LinearLayoutManager(this));

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

