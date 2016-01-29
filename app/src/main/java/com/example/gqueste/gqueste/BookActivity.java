package com.example.gqueste.gqueste;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * Created by Gabriel QUESTE on 27/01/2016.
 */
public class BookActivity extends AppCompatActivity {

    public static final String BOOK = "BOOK";
    public static final String AMAZON_ENDPOINT = "http://www.amazon.fr/s/field-keywords=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        Intent intent = getIntent();
        Book book = intent.getParcelableExtra(BOOK);

        TextView titleTextView = (TextView) findViewById(R.id.bookTitleTextView);
        ImageView coverImageView = (ImageView) findViewById(R.id.bookCoverImageView);
        TextView isbnTextView = (TextView) findViewById(R.id.bookIsbnTextView);
        TextView priceTextView = (TextView) findViewById(R.id.bookPriceTextView);
        Button buyButton = (Button) findViewById(R.id.button_buy_amazon);

        titleTextView.setText(book.title);
        Picasso.with(this)
                .load(book.cover)
                .fit()
                .centerCrop()
                .into(coverImageView);
        isbnTextView.setText("ISBN : " + book.isbn);
        priceTextView.setText(String.valueOf(book.price) + " €");

        final String uri = AMAZON_ENDPOINT + book.title;


        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(uri));
                startActivity(intent);
            }
        });
    }
}
