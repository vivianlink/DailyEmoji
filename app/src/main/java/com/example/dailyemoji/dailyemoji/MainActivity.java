package com.example.dailyemoji.dailyemoji;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity {

    private SeekBar emotionBar ;
    private TextView progressText ;
    private Button selfRateButton;
    private int ratingValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeVariables();
        selfRateButton.setVisibility(View.INVISIBLE);
        emotionBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean b) {
                ratingValue = progressValue;
                progressText.setText("Your current mood: " + Integer.toString(ratingValue) + "/" + emotionBar.getMax() );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                selfRateButton.setVisibility(View.VISIBLE);
            }
        });
    }

    public void clickRating(View view){
        DBHandler db = new DBHandler(this);

        Rating rating = new Rating();

        rating.setRating(ratingValue);
        rating.setEmoji("emoji");
        rating.setNote("my note");

        db.addRating(rating);

        Intent intent = new Intent(this, EmojiNoteActivity.class);
        startActivity(intent);
    }

    private void initializeVariables() {
        emotionBar =   findViewById(R.id.progressBar);
        progressText = findViewById(R.id.progressText);
        selfRateButton = findViewById(R.id.selfRateButton);

    }

    public void clickGraph(View view){
        Intent intent = new Intent(this, GraphActivity.class);
        startActivity(intent);
    }


    public void clickHistory(View view){
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }
}
