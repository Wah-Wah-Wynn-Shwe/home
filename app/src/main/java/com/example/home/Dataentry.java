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

public class Dataentry extends AppCompatActivity {

    static EditText id,name,address;
    static Button B1,B2;
    static DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dataentry);
        mydb=new DatabaseHelper(this);
        addRecord();

    }
    public void  addRecord(){
        id=(EditText)findViewById(R.id.t1);
        name=(EditText)findViewById(R.id.t2);

        address=(EditText)findViewById(R.id.t3);
        B1=(Button)findViewById(R.id.btn);
        B2=(Button)findViewById(R.id.btn1);

        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id.getText().toString().equals("")|| name.getText().toString().equals("")|| address.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"name field or address field is black..plz fill" +
                            "up..",Toast.LENGTH_LONG).show();
                }
                else {
                    boolean insertdata=mydb.insertData(Integer.parseInt(id.getText().toString()),name.getText().toString(),address.getText().toString());

                    if(insertdata==true){
                        Toast.makeText(getApplicationContext(),"Sussessfully Inserted",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),employee.class);
                startActivity(intent);
            }
        });
    }

}



