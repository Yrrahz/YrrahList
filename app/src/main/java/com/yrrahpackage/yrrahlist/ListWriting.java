package com.yrrahpackage.yrrahlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ListWriting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_writing);

        setUp();
    }

    private void setUp(){
        TextView ListCounterView = findViewById(R.id.ListCounterView);
        ListCounterView.setText(String.format("%s","1.\n2.\n3.\n4.\n5."));
    }
}
