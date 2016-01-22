package com.example.gqueste.gqueste;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Gabriel QUESTE on 22/01/2016.
 */
public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    private List<Book> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public View mView;

        public TextView nameTextView;
        public TextView priceTextView;

        public ViewHolder(View v) {
            super(v);
            mView = v;
            nameTextView = (TextView) v.findViewById(R.id.nameTextView);
            priceTextView = (TextView) v.findViewById(R.id.priceTextView);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public BookAdapter(List<Book> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public BookAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_view_item_book, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Book book = mDataset.get(position);
        holder.nameTextView.setText(book.title);
        holder.priceTextView.setText(String.valueOf(book.price));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}