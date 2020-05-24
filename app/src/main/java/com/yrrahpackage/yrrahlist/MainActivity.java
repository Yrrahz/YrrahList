package com.yrrahpackage.yrrahlist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main_menu_new:
                Toast.makeText(getApplicationContext(),"New List!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.main_menu_open:
                Toast.makeText(getApplicationContext(),"Open List!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.main_menu_settings:
                Toast.makeText(getApplicationContext(),"Settings!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.main_menu_about:
                Toast.makeText(getApplicationContext(),"About!", Toast.LENGTH_SHORT).show();

                AlertDialog.Builder aboutBuilder = new AlertDialog.Builder(this);
                aboutBuilder.setTitle("About");
                aboutBuilder.setMessage("Hello!\nThis is my first proper Android application.\nThank you to my loving wife who is encouraging me to continue developing.\nWithout her, this app would not exist.");
                aboutBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                aboutBuilder.show();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void buttonPressed(View view){
        Toast.makeText(getApplicationContext(),"Button is pressed!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, ListWriting.class);
        startActivity(intent);
    }
}
