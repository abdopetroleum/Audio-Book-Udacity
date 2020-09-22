package com.example.musicalstructureappudacity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<Book> books=new ArrayList<>(5);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        books.add(new Book("Oliver Twist","Charles Dickens",R.drawable.oliver_teist,50,15));
        books.add(new Book("David Copper Field","Charles Dickens",R.drawable.david_coper_field,40,15));
        books.add(new Book("Tale of two cities","Charles Dickens",R.drawable.tale_of_two_cities,30,15));
        books.add(new Book("Hamlet","Shakespeare",R.drawable.hamlet,30,15));
        books.add(new Book("Romeo and Juliet","Shakespeare",R.drawable.romeoandjuiletjpg,30,15));
        ListView listView=findViewById(R.id.list);
        listView.setAdapter(new BooksAdapter(this,books));
        Button playing
                =findViewById(R.id.now_playing);
        playing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,PlayingActivity.class);
                Bundle bundle=new Bundle();
                Collections.shuffle(books);
                bundle.putSerializable("book",books.get(0));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}