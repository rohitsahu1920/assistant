package com.example.rohit.assistent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class parent_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_activity);

        CardView im = findViewById(R.id.profile);
        CardView im2 = findViewById(R.id.notes);
        CardView im3 = findViewById(R.id.browser);
        CardView im4 = findViewById(R.id.scheduler);
        CardView im5 = findViewById(R.id.cgpi);

        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(parent_activity.this, profile_activity.class));
            }
        });

        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(parent_activity.this, noteCreate.class));
            }
        });
        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(parent_activity.this, Browser.class));
            }
        });
        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(parent_activity.this, make_schedule.class));
            }
        });

        im5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(parent_activity.this, cgpa_activity.class));
            }
        });
    }
}
