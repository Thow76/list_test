package com.example.list_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    private TextView detsName;
    private TextView detsExpiry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        detsName = findViewById(R.id.dets_name);
        detsExpiry = findViewById(R.id.dets_expiry);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {

            String name = bundle.getString("name");
            String expiry = bundle.getString("expiry");

            detsName.setText(name);
            detsExpiry.setText(expiry);

        }

    }


}