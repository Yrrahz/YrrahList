package com.yrrahpackage.yrrahlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ListWriting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_writing);

        setUp();
    }

    private void setUp(){
        final TextView ListCounterView = findViewById(R.id.ListCounterView);
        //ListCounterView.setText(String.format("%s","1.\n2.\n3.\n4.\n5."));

        final EditText EditTextView = findViewById(R.id.EditTextView);

        // add a keylistener to keep track user input
        EditTextView.setOnKeyListener(new View.OnKeyListener(){
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER))
                {
                    Toast.makeText(getApplicationContext(),"Enter is pushed!", Toast.LENGTH_SHORT).show();

                    String numericCounter = ListCounterView.getText().toString();
                    String lineCounterString = EditTextView.getText().toString();
                    int lineCounter = countLines(lineCounterString);

                    ListCounterView.setText(String.format("%s",numericCounter+ Integer.toString(lineCounter) +"\n"));

                    //for(int n = 0 ; n <= lineCounter ; n++){}
                    //return true; // If true, then "Enter" wont make new row.
                }
                return false;
            }
        });

        ((EditText)findViewById(R.id.EditTextView)).setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                // When focus is lost check that the text field has valid values.

                if (!hasFocus) {
                    // Validate youredittext
                    String numericCounter = ListCounterView.getText().toString();
                    String lineCounterString = EditTextView.getText().toString();
                    int lineCounter = countLines(lineCounterString);

                    ListCounterView.setText(String.format("%s",numericCounter+ Integer.toString(lineCounter) +"\n"));
                }
            }
            });
        }

    private int countLines(String s){

        if(s.isEmpty()){
            return 0;
        }
        String[] lines = s.split("\r\n|\r|\n");

        return lines.length;
    }
}
