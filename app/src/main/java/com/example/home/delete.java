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

public class delete extends AppCompatActivity {
    Button b1,b2;
    EditText t1;
    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        mydb=new DatabaseHelper(this);
        t1=(EditText)findViewById(R.id.T1);
        b1=(Button)findViewById(R.id.btn1);
        b2=(Button)findViewById(R.id.btn);

        b1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      boolean isDeleted=mydb.deleteRecord(t1.getText().toString());
                                      if(isDeleted==true){
                                          Toast.makeText(getApplicationContext(),"Successfully Deleted..",Toast.LENGTH_LONG).show();
                                          Intent intent=new Intent(getApplicationContext(),employee.class);
                                          startActivity(intent)
                                          ;

                                      }
                                      else {
                                          Toast.makeText(getApplicationContext(),"Sorry..Could not delete",Toast.LENGTH_LONG).show();
                                      }

                                  }
                              });

                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), employee.class);
                        startActivity(intent);
                    }
                });

            }

        }
