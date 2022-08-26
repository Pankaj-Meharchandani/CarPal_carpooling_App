package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.*;
import android.content.Intent;
import android.os.Bundle;

//import android.app.Activity;
import android.graphics.Color;
//import android.os.Bundle;
import android.text.Editable;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class forget extends AppCompatActivity {
EditText t1,t2,t3;
Button b1;
SQLiteDatabase db1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
          db1=openOrCreateDatabase("user", Context.MODE_PRIVATE,null);
        t1=findViewById(R.id.username2);
        t2=findViewById(R.id.pass1);
        t3=findViewById(R.id.pass2);
        b1=findViewById(R.id.login2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
String i=t2.getText().toString();
                String j=t3.getText().toString();
                boolean correct = i.equals(j);
               if (correct)
               { String q= "Update user set pass=('"+t2.getText().toString()+"')where name='"+t1.getText().toString()+"'";
                   db1.execSQL(q);
                   Toast.makeText(getApplicationContext(),"password changed",Toast.LENGTH_SHORT).show();
                   Intent a=new Intent(getApplicationContext(),login.class);
                   startActivity(a);
                   finish();
               }

            }
        });
    }}