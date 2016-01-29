package com.example.gqueste.gqueste;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class LibraryActivity extends AppCompatActivity {


    private static final Random RANDOM = new Random(); //TODO remove
    private List<Book> books;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        final LibraryActivity activity = this;

        final RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.library_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://henri-potier.xebia.fr/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HenriPotierService service = retrofit.create(HenriPotierService.class);
        Call<List<Book>> call = service.listBooks();
        if(books == null){
            Toast.makeText(this, "Retrieving data", Toast.LENGTH_SHORT).show();
        }
        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Response<List<Book>> response, Retrofit retrofit) {
                // success
                activity.books = new ArrayList<>();
                for (Book b : response.body()) {
                    books.add(b);
                }
                RecyclerView.Adapter mAdapter = new BookAdapter(activity.books, new BookItemClickReaction() {
                    @Override
                    public void doAction(Book b) {
                        Intent intent = new Intent(LibraryActivity.this, BookActivity.class);
                        intent.putExtra(BookActivity.BOOK, b);
                        activity.startActivity(intent);
                    }
                });
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Throwable t) {
                // error occurred
                Toast.makeText(activity, "Can not connect to THE INTERNET.", Toast.LENGTH_LONG).show();
            }
        });

    }
}

