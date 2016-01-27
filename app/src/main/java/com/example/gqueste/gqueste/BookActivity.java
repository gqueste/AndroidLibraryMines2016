package com.example.gqueste.gqueste;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by Gabriel QUESTE on 27/01/2016.
 */
public class BookActivity extends AppCompatActivity {

    public static final String BOOK = "BOOK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        Intent intent = getIntent();
        Book book = intent.getParcelableExtra(BOOK);

        Toast.makeText(this, book.title, Toast.LENGTH_SHORT).show();

    }
}
