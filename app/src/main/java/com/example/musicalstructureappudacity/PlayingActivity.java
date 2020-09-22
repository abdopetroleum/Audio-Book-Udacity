package com.example.musicalstructureappudacity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayingActivity extends AppCompatActivity {
    // GUI items
    private Button mLibraryButton;
    private ImageView mBookImage;
    private TextView mBookTitle;
    private TextView mDuration;
    private ImageView playAndStop;
    //other vars
    private Book book;
    private boolean isPlaying;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);
        initViews();
        setTitle("Playing activity");
        Bundle bundle = getIntent().getExtras();
        book = (Book) bundle.getSerializable("book");
        isPlaying=bundle.getBoolean("isPlaying",true);
        mBookImage.setImageResource(book.getImgId());
        mBookTitle.setText(book.getBookName());
        mDuration.setText(book.getDuration_minutes() + ":" + book.getDuration_seconds());
        mLibraryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });
        playAndStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPlaying){
                    playAndStop.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                    isPlaying=false;
                }else{
                    playAndStop.setImageResource(R.drawable.ic_baseline_pause_24);
                    isPlaying=true;
                }
            }
        });
    }
    private void initViews() {
        mLibraryButton = findViewById(R.id.library_button);
        mBookImage =  findViewById(R.id.book_image);
        mBookTitle =  findViewById(R.id.book_title);
        mDuration =  findViewById(R.id.duration_text);
        playAndStop=findViewById(R.id.stop_play);
    }
}