package com.example.dailyemoji.dailyemoji;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HistoryActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ListView lv= findViewById(android.R.id.list);

        // create the grid item mapping
        String[] from = new String[] {"rowid", "col_1", "col_2", "col_3", "col_4"};
        int[] to = new int[] { R.id.item1, R.id.item2, R.id.item3, R.id.item4, R.id.item5 };

        // prepare the list of all records
        List<HashMap<String, String>> fillMaps = new ArrayList<>();


        DBHandler db = new DBHandler(this);

        List<Rating> ratingList = db.getAllRatings();
        for (int i = 0; i < ratingList.size(); i++) {
            Rating rating = ratingList.get(i);

            HashMap<String, String> map = new HashMap<>();

            map.put("rowid", "");
            map.put("col_1", Integer.toString(rating.getRating()));
            map.put("col_2", rating.getEmoji());
            map.put("col_3", rating.getNote());
            map.put("col_4", rating.getTimestamp());
            fillMaps.add(map);
        }

        // fill in the grid_item layout
        SimpleAdapter adapter = new SimpleAdapter(this, fillMaps, R.layout.grid_item, from, to);
        lv.setAdapter(adapter);
    }

    public void clearAll(View view) {
        // remove all the ratings from database
        DBHandler db = new DBHandler(this);
        db.clearAllData();

        // go back to front page
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void addRandomData(View view) {
        // add random data to database
        DBHandler db = new DBHandler(this);
        db.addRandomData();

        // go back to front page
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
