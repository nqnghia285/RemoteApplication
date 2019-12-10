package com.nqnghia.remoteapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MachineInfoActivity extends AppCompatActivity {

    private Button chartButton1;
    private Button chartButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine_info);

        chartButton1 = findViewById(R.id.chart_button);
        chartButton2 = findViewById(R.id.chart_button_2);

        chartButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        startActivities(new Intent[]{
                                new Intent(MachineInfoActivity.this, ChartActivity.class)});
                    }
                });
            }
        });

        chartButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        startActivities(new Intent[]{
                                new Intent(MachineInfoActivity.this, ChartActivity.class)});
                    }
                });
            }
        });
    }
}
