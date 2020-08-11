package com.example.home;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class edit extends AppCompatActivity {
    Button b1, b2;
    EditText T1, T2, T3;
    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        b1 = (Button) findViewById(R.id.btn);
        b2 = (Button) findViewById(R.id.btn1);
        T1 = (EditText) findViewById(R.id.t1);
        T2 = (EditText) findViewById(R.id.t2);
        T3 = (EditText) findViewById(R.id.t3);
        mydb = new DatabaseHelper(this);
       // Updatedata();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isUpdate = mydb.updateData(T1.getText().toString(),T2.getText().toString()
                        ,T3.getText().toString());
                if(isUpdate==true)
                    Toast.makeText(getApplicationContext(),"Data Updated",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(),"No Updated",Toast.LENGTH_LONG).show();
            }

        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Viewemployee.class);
                startActivity(intent);
            }
        });
    }



    }


