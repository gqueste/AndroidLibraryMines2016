package com.example.gqueste.gqueste;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Gabriel QUESTE on 22/01/2016.
 */
public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    private List<Book> mDataset;
    private BookItemClickReaction bookItemClickReaction;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public View mView;

        public Book currentBook;
        public TextView nameTextView;
        public TextView priceTextView;
        public BookItemClickReaction reaction;

        public ViewHolder(View v, BookItemClickReaction reaction) {
            super(v);
            v.setOnClickListener(this);
            mView = v;
            this.reaction = reaction;
            nameTextView = (TextView) v.findViewById(R.id.nameTextView);
            priceTextView = (TextView) v.findViewById(R.id.priceTextView);
        }

        @Override
        public void onClick(View v) {
            reaction.doAction(this.currentBook);
        }

        public void setCurrentBook(Book b){
            this.currentBook = b;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public BookAdapter(List<Book> myDataset, BookItemClickReaction reaction) {
        mDataset = myDataset;
        this.bookItemClickReaction = reaction;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public BookAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_view_item_book, parent, false);

        ViewHolder vh = new ViewHolder(v, this.bookItemClickReaction);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Book book = mDataset.get(position);
        holder.setCurrentBook(book);
        holder.nameTextView.setText(book.title);
        holder.priceTextView.setText(String.valueOf(book.price));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}