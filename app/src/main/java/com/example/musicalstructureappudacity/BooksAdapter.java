package com.example.musicalstructureappudacity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BooksAdapter extends ArrayAdapter<Book> {
    public BooksAdapter(Context context, ArrayList<Book> books) {
        super(context, 0, books);

    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Book book=getItem(position);
        View listItem=convertView;
        if(listItem==null){
            listItem= LayoutInflater.from(getContext()).inflate(R.layout.book_item,parent,false);
        }
        // setting the title
        TextView title = (TextView) listItem.findViewById(R.id.book_title);
        title.setText(book.getBookName());

        // setting the author text
        TextView authorText = (TextView) listItem.findViewById(R.id.book_author);
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        authorText.setText(book.getBookAuthor());
        ImageView imageView = (ImageView) listItem.findViewById(R.id.book_image);
        if (book.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(book.getImgId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }
        final View finalListItem = listItem;
        listItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(finalListItem.getContext(),PlayingActivity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("book",getItem(position));
                intent.putExtras(bundle);
                finalListItem.getContext().startActivity(intent);
            }
        });
        return listItem;
    }
}
