package com.example.dailyemoji.dailyemoji;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import io.github.rockerhieu.emojiconize.Emojiconize;

public class EmojiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Emojiconize.activity(this).go();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emoji);
    }

    protected void chooseEmoji(View view){
        view.getId();
    }

    public void clickAllDone(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}