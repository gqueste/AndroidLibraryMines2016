package com.example.gqueste.gqueste;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Gabriel QUESTE on 22/01/2016.
 */
public class BookItemView extends LinearLayout {

    private TextView nameTextView;
    private TextView priceTextView;

    public BookItemView(Context context) {
        this(context, null);
    }

    public BookItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BookItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        nameTextView = (TextView) findViewById(R.id.nameTextView);
        priceTextView = (TextView) findViewById(R.id.priceTextView);
    }

    public void bindView(Book book) {
        nameTextView.setText(book.title);
        priceTextView.setText(String.valueOf(book.price));

    }
}

