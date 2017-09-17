package com.example.dailyemoji.dailyemoji;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Objects;
import java.util.StringTokenizer;

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
        final Button allDoneButton = (Button) findViewById(R.id.button);
        allDoneButton.setVisibility(View.INVISIBLE);
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
            final ImageButton emojiButton = buttons[i];
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    emojiName += view.getTag().toString() + ", ";
                    allDoneButton.setVisibility(View.VISIBLE);
                    emojiButton.setVisibility(View.INVISIBLE);
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

        EditText notes = (EditText) findViewById(R.id.noteField);
        String noteReceived = getNotes(notes);

        Rating rating = new Rating();
        Intent ratingValueIntent = getIntent();
        String ratingValue= ratingValueIntent.getStringExtra(Intent.EXTRA_TEXT);

        rating.setRating(Integer.valueOf(ratingValue));

        if (!Objects.equals(emojiName, "")) {
            emojiName = emojiName.substring(0,emojiName.length()-2);

            rating.setEmoji(emojiName);

        } else {
            rating.setEmoji("NO_EMOJI");
        }

        rating.setNote(noteReceived);

        db.addRating(rating);
        Intent intent = new Intent(this, MainActivity.class);

        Toast.makeText(getBaseContext(), "Your emoji is saved", Toast.LENGTH_SHORT).show();

        startActivity(intent);


    }

    public String getNotes(EditText notes){
        if (notes !=null) {
            return notes.getText().toString();
        } else {
            return "";
        }

    }



}