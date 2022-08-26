package com.example.myapplication;

import androidx.annotation.NonNull;
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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class login extends AppCompatActivity {
    Button button1,button2,button3;
    EditText text1,text2;
    SQLiteDatabase db1;
    TextView tx1;
    int counter = 3;
    Cursor cr1,cr2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Boolean e=false,p=false;
        setContentView(R.layout.activity_login);
        db1=openOrCreateDatabase("user", Context.MODE_PRIVATE,null);
        db1.execSQL("Create table If Not Exists user(name varchar(20),phone int,email varchar(30),age int,country varchar(20), pass varchar(20));");

        button1 = (Button)findViewById(R.id.log);
        text1 = (EditText)findViewById(R.id.loginName);
        text2 = (EditText)findViewById(R.id.loginPass);
        button3 = (Button)findViewById(R.id.button4);
        button2 = (Button)findViewById(R.id.signpage);
        tx1 = (TextView)findViewById(R.id.textView3);
        tx1.setVisibility(View.GONE);

        String q1="select * from user";
        cr1=db1.rawQuery(q1,null);
        cr1.moveToNext();

        button1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        //To show password
  //         text1.setText(cr1.getString(0));
    //       text2.setText(cr1.getString(5));
//           String u= cr1.getString(0);
//           String pa= cr1.getString(2);
//                String q1="select phone from user";
//                cr1=db1.rawQuery(q1,null);
//                cr1.moveToNext();
//                String ele[]=new String[cr1.getCount()];
//                int p=0;
//                while(cr1.moveToNext())
//                {String s1=cr1.getString(0);
//                    ele[p]=s1;
//                    p++;}
//
//                String q2="select pass from user";
//                cr2=db1.rawQuery(q2,null);
//                cr2.moveToNext();
//                String ele2[]=new String[cr2.getCount()];
//                int c=0;
//                while(cr2.moveToNext())
//                {String s2=cr2.getString(0);
//                    ele[c]=s2;
//                    c++;}
//
           if(text1.getText().toString().equals(cr1.getString(0)) &&
                   text2.getText().toString().equals(cr1.getString(5))) {
               Intent a=new Intent(getApplicationContext(),select.class);
               startActivity(a);
               finish();
//                    Toast.makeText(getApplicationContext(),
//                            "Redirecting...",Toast.LENGTH_SHORT).show();
           }else{
               Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();

               tx1.setVisibility(View.VISIBLE);
               tx1.setBackgroundColor(Color.RED);
               counter--;
               tx1.setText(Integer.toString(counter));

               if (counter == 0) {
                   button1.setEnabled(false);
               }
           }

       }}
        );
//                Intent i=getIntent();
//                Intent j=getIntent();
//                String x =i.getExtras().getString("data");
//                String x6=j.getExtras().getString("data");
//text1.setText(""+x);
//                text1.setText(""+x6);
//                String un = text1.getText().toString();
//                Editable pw = text2.getText();
//                boolean correct1 = x.equals(un);
//                boolean correct2 = x6.equals(pw);
//
//                if(correct1 && correct2) {
//                    Intent a=new Intent(getApplicationContext(),select.class);
//                    startActivity(a);
//                    finish();
////                    Toast.makeText(getApplicationContext(),
////                            "Redirecting...",Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
//
//                    tx1.setVisibility(View.VISIBLE);
//                    tx1.setBackgroundColor(Color.RED);
//                    counter--;
//                    tx1.setText(Integer.toString(counter));
//
//                    if (counter == 0) {
//                        button1.setEnabled(false);
//                    }
//                }
//
//            }}
//        );

        button2.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        Intent a=new Intent(getApplicationContext(),signup.class);
        startActivity(a);
        finish();
        }

        });
        button3.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        Intent a=new Intent(getApplicationContext(),forget.class);
        startActivity(a);
        finish();
        }

        });

        }
        }