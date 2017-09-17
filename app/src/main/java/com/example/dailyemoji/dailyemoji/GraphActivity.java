package com.example.dailyemoji.dailyemoji;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.List;

public class GraphActivity extends AppCompatActivity {

    private LineGraphSeries<DataPoint> thingsToPlot;
    private List<Integer> listOfY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        thingsToPlot = new LineGraphSeries<DataPoint>();
        listOfY = new ArrayList<Integer>();

        updateThingsToPlot();
        drawGraph();

    }


    public void updateThingsToPlot(){
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


    public void drawGraph(){
        GraphView gv = (GraphView) findViewById(R.id.graph);

        gv.setTitle("Mood Graph");
        int x=-1,y =0;

        for (int i = 0 ; i <listOfY.size() ; i++){
            x += 1;
            y = listOfY.get(i);
            thingsToPlot.appendData(new DataPoint(x,y), true, listOfY.size());
        }

        gv.addSeries(thingsToPlot);
    }


}
