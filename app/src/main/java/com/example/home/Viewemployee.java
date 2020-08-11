package com.example.home;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Viewemployee extends AppCompatActivity {
    ListView lv;
    Button B1,B2;
    DatabaseHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        mydb = new DatabaseHelper(this);
        lv = (ListView) findViewById(R.id.mylist);
        B1 = (Button) findViewById(R.id.btn1);
        B2=(Button)findViewById(R.id.btn2);

        Cursor res = mydb.getAllData();

        if (res.getCount() == 0) {
            Toast.makeText(getApplicationContext(), "Sorry..No data found..", Toast.LENGTH_LONG).show();
        } else {
            String record;
            int len = res.getCount();
            String[] data = new String[len];

            int recordCount = 0;

            while (res.moveToNext()) {
                record = "ID:" + res.getString(0) + "\n Name:" + res.getString(1) + "\n Address:" + res.getString(2);
                data[recordCount] = record;
                recordCount++;

            }
            ArrayAdapter<String> arr = new ArrayAdapter<String>(this, R.layout.viewlist, data);
            lv.setAdapter(arr);
        }


        B1.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Intent intent = new Intent(getApplicationContext(), edit.class);
                startActivity(intent);
            }

        });
        B2.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Intent intent = new Intent(getApplicationContext(), delete.class);
                startActivity(intent);
            }

        });
    }
}



