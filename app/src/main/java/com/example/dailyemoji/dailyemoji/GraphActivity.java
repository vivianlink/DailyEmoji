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
import java.util.List;

public class GraphActivity extends AppCompatActivity {

    private LineGraphSeries<DataPoint> thingsToPlot;
    private List<Integer> listOfY;
    public String topText;
    private TextView tv;
    private GraphView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        thingsToPlot = new LineGraphSeries<DataPoint>();
        listOfY = new ArrayList<Integer>();
        topText = "";

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

        if (isMonth == true){
            setTopText("Past Month's Mood Ratings");
        } else
            setTopText("Past Year's Mood Ratings");

        listOfY = new ArrayList<Integer>();
        thingsToPlot = new LineGraphSeries<DataPoint>();

        listOfY.add(1);
        listOfY.add(2);
        listOfY.add(3);
        listOfY.add(10);
        listOfY.add(4);
        listOfY.add(1);
        listOfY.add(2);
        listOfY.add(3);
        listOfY.add(10);
        listOfY.add(4);
        listOfY.add(1);
        listOfY.add(2);
        listOfY.add(3);
        listOfY.add(10);
        listOfY.add(4);
        listOfY.add(1);
        listOfY.add(2);
        listOfY.add(3);
        listOfY.add(10);
        listOfY.add(4);
        listOfY.add(1);
        listOfY.add(2);
        listOfY.add(3);
        listOfY.add(10);
        listOfY.add(4);

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
        drawGraph();
    }


    public void drawGraph(){


        gv = (GraphView) findViewById(R.id.graph);

        int x=-1,y =0;

        for (int i = 0 ; i <listOfY.size() ; i++){
            x += 1;
            y = listOfY.get(i);
            thingsToPlot.appendData(new DataPoint(x,y), true, listOfY.size());
        }

        gv.addSeries(thingsToPlot);

    }


}
