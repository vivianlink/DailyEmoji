package com.example.dailyemoji.dailyemoji;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

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

        MyTimerTask myTask = new MyTimerTask();
        Timer myTimer = new Timer();

        myTimer.schedule(myTask, 5000, 2 * 60 * 1000);
    }

    public void clickRating(View view){
        // SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        // String freq = prefs.getString("notifications_frequency", "DEFAULT");

//        DBHandler db = new DBHandler(this);
//
//        Rating rating = new Rating();
//
//        rating.setRating(ratingValue);
//        rating.setEmoji("emoji");
//        rating.setNote("my note");
//
//        db.addRating(rating);

        Intent intent = new Intent(this, EmojiActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, Integer.toString(ratingValue));

        startActivity(intent);
    }

    public void clickSettings(View view){
        Intent intent = new Intent(this, SettingsActivity.class);
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

    private class MyTimerTask extends TimerTask {
        public void run() {
            generateNotification(getApplicationContext(), "What's your mood?");
        }
    }

    private void generateNotification(Context context, String message) {

        int icon = R.drawable.emoji_1f914;
        String appname = context.getResources().getString(R.string.app_name);
        NotificationManager notificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification;
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
                new Intent(context, MainActivity.class), 0);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(
                    context);
            notification = builder.setContentIntent(contentIntent)
                    .setSmallIcon(icon).setTicker(appname).setWhen(0)
                    .setAutoCancel(true).setContentTitle(appname)
                    .setContentText(message).build();

            notificationManager.notify(0, notification);
    }
}
