package com.nqnghia.remoteapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Random;

public class ChartActivity extends AppCompatActivity {
    private static final String TAG = "ChartActivity";
    private GraphView graph;
    private BarGraphSeries<DataPoint> series1;
    private LineGraphSeries<DataPoint> series2;

    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        setupGraph();
    }

    public void setupGraph() {

        graph = findViewById(R.id.graph);
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setScalable(true);
        graph.getLegendRenderer().setVisible(true);
        graph.getLegendRenderer().setTextColor(Color.rgb(0, 255, 255));
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        graph.getLegendRenderer().setMargin(40);
        graph.getLegendRenderer().setPadding(10);
        graph.getViewport().setMaxY(80);
        graph.getViewport().setMinY(0);
        graph.setTitle("Field 1 & Field 2");
        graph.setTitleColor(Color.BLUE);
        graph.setBackgroundColor(Color.rgb(255, 165, 0));
        graph.getGridLabelRenderer().setHorizontalAxisTitle("X");
        graph.getGridLabelRenderer().setVerticalAxisTitle("Y");
        graph.getGridLabelRenderer().setHorizontalAxisTitleColor(Color.BLUE);
        graph.getGridLabelRenderer().setVerticalAxisTitleColor(Color.GREEN);

        series1 = new BarGraphSeries<>();
        series1.setTitle("Field 1");
        series1.setDataWidth(0.5);
        series1.setColor(Color.BLUE);
        graph.addSeries(series1);

        series2 = new LineGraphSeries<>();
        series2.setTitle("Field 2");
        series2.setDrawDataPoints(true);
        series2.setDataPointsRadius(10);
        series2.setThickness(1);
        series2.setColor(Color.GREEN);
        graph.addSeries(series2);

        setupChart();
    }

    private void setupChart() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    series1.appendData(new DataPoint(i, random.nextInt(50)), true, 80);
                    series2.appendData(new DataPoint(i, random.nextInt(50)), true, 80);
                }
            }
        });
    }
}
