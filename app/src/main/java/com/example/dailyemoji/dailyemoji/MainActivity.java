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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeVariables();
        selfRateButton.setVisibility(View.INVISIBLE);
        emotionBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           String progress = "";

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean b) {
                progress = Integer.toString(progressValue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                selfRateButton.setVisibility(View.VISIBLE);
                progressText.setText("Your current mood: " + progress + "/" + emotionBar.getMax() );
            }
        });
    }

    public void clickRating(View view){
        Intent intent = new Intent(this, EmojiNoteActivity.class);
        startActivity(intent);
    }

    private void initializeVariables() {
        emotionBar =   findViewById(R.id.progressBar);
        progressText = findViewById(R.id.progressText);
        selfRateButton = findViewById(R.id.selfRateButton);

    }

}
