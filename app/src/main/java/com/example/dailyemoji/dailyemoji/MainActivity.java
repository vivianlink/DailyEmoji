package com.example.dailyemoji.dailyemoji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickRating(View view){
        Intent intent = new Intent(this, EmojiNoteActivity.class);
        startActivity(intent);
    }
}
