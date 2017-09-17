package com.example.dailyemoji.dailyemoji;

import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GraphActivity extends AppCompatActivity {

    private LineGraphSeries<DataPoint> thingsToPlot;
    private List<Integer> listOfY;
    public String topText;
    private TextView tv;
    private GraphView gv;
    private DBHandler db;
    private String dateTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        thingsToPlot = new LineGraphSeries<DataPoint>();
        listOfY = new ArrayList<Integer>();
        topText = "";
        db = new DBHandler(this);
        dateTime = db.getDateTime();

        updateThingsToPlot(true);
        drawGraph();

        tv = (TextView) findViewById(R.id.textView1);
        tv.setText(getTopText());

    }

    private void setTopText(String nam){
        this.topText = nam;
    }

    public String getTopText(){
        return this.topText;
    }


    public void updateThingsToPlot(boolean isMonth){

        int year = Integer.parseInt(dateTime.substring(0, 3));
        int month = Integer.parseInt(dateTime.substring(5,6));
        int day = Integer.parseInt(dateTime.substring(8,9));

        if (isMonth == true){
            setTopText("This Month's Mood Ratings");
        } else
            setTopText("This Year's Mood Ratings");

        listOfY = new ArrayList<Integer>();
        thingsToPlot = new LineGraphSeries<DataPoint>();

        List<Rating> allRatingObject = db.getAllRatings();

        List<Integer> allRatingInteger = new ArrayList<Integer>();
        if (isMonth == true) {
            for (Rating r : allRatingObject) {
                if (r.getYear() == year &&
                        r.getMonth() == month) {
                    allRatingInteger.add(r.getRating());
                }
            }
        }
        if (isMonth == false) {
            for (Rating r : allRatingObject) {
                if (r.getYear() == year ) {
                    allRatingInteger.add(r.getRating());
                }
            }
        }


        Collections.reverse(allRatingInteger);
        listOfY = allRatingInteger;


    }

    public void click30(View view){

        updateThingsToPlot(true);
        setTopText("Past Month's Mood Ratings");
        tv.setText(getTopText());
        drawGraph();
    }

    public void click365(View view){
        updateThingsToPlot(false);
        setTopText("Past Year's Mood Ratings");
        tv.setText(getTopText());

        gv.getViewport().setMaxX(365);
        gv.getViewport().setXAxisBoundsManual(true);
        drawGraph();
    }


    public void drawGraph(){


        gv = (GraphView) findViewById(R.id.graph);
        gv.getViewport().setMinX(0);
        gv.getViewport().setMinY(0);
        gv.getViewport().setMaxY(10);
        gv.getViewport().setMaxX(30);
        gv.getViewport().setXAxisBoundsManual(true);
        gv.getViewport().setYAxisBoundsManual(true);

        int x=-1,y =0;

        for (int i = 0 ; i <listOfY.size() ; i++){
            x += 1;
            y = listOfY.get(i);
            thingsToPlot.appendData(new DataPoint(x,y), true, listOfY.size());
        }

        gv.addSeries(thingsToPlot);

    }


}
