package com.example.dailyemoji.dailyemoji;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Objects;

import io.github.rockerhieu.emojiconize.Emojiconize;

public class EmojiActivity extends AppCompatActivity {

    String emojiName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Emojiconize.activity(this).go();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emoji);


        final ImageButton[] buttons = new ImageButton[22];
        final View[] views = new View[22];
        int i ;

        views[0] = findViewById(R.id.smiley);
        views[1] = findViewById(R.id.huffing);
        views[2] = findViewById(R.id.sad);
        views[3] = findViewById(R.id.sunglasses);
        views[4] = findViewById(R.id.smirk);
        views[5] = findViewById(R.id.soso);
        views[6] = findViewById(R.id.disappointed);
        views[7] =  findViewById(R.id.redface);
        views[8] = findViewById(R.id.happy);
        views[9] = findViewById(R.id.meh);
        views[10] = findViewById(R.id.sad);
        views[11] = findViewById(R.id.forcesmile);
        views[12] = findViewById(R.id.kissyface);
        views[13] = findViewById(R.id.hearteyes);
        views[14] = findViewById(R.id.hmm);
        views[15] = findViewById(R.id.oops);
        views[16] = findViewById(R.id.toungeout);
        views[17] = findViewById(R.id.cry);
        views[18] = findViewById(R.id.whine);
        views[19] = findViewById(R.id.whistle);
        views[20] = findViewById(R.id.ohno);
        views[21] = findViewById(R.id.teardrop);

        for ( i = 0; i <= 21; i ++){

            buttons[i] = (ImageButton) views[i];
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getBaseContext(), "Your emoji is saved", Toast.LENGTH_SHORT).show();
                    emojiName = view.getTag().toString();
                   // Toast.makeText(getBaseContext(), emojiId +  "  " + ratingValue , Toast.LENGTH_SHORT).show();
                }

            });
        }
    }



    protected void chooseEmoji(View view){
        view.getId();
    }

    public void clickAllDone(View view){
        DBHandler db = new DBHandler(this);

        Rating rating = new Rating();

        Intent ratingValueIntent = getIntent();
        final String ratingValue= ratingValueIntent.getStringExtra(Intent.EXTRA_TEXT);

        rating.setRating(Integer.valueOf(ratingValue));
        if (!Objects.equals(emojiName, "")) {
            rating.setEmoji(emojiName);
        } else {
            rating.setEmoji("NO_EMOJI");
        }

        rating.setNote("my note");

        db.addRating(rating);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}