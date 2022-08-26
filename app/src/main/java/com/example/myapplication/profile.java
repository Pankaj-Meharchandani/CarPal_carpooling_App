package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class profile extends AppCompatActivity {
    EditText et1,et2,et3,et4,et5,et6;
    Button b1;
    SQLiteDatabase db1;
    Cursor cr1,cr2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        db1=openOrCreateDatabase("user", Context.MODE_PRIVATE,null);
        et1=findViewById(R.id.name);
        et2=findViewById(R.id.ph);
        et3=findViewById(R.id.em);
        et4=findViewById(R.id.ag);
        et5=findViewById(R.id.co);
        b1=findViewById(R.id.save);

        //main process
        String q3="select * from user";
        cr2=db1.rawQuery(q3,null);
        cr2.moveToNext();
        et1.setText(cr2.getString(0));
        et2.setText(cr2.getString(1));
        et3.setText(cr2.getString(2));
        et4.setText(cr2.getString(3));
        et5.setText(cr2.getString(4));
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // String q= "Update user set name=('"+et2.getText().toString()+"')where name='"+et1.toString()+"'";
                String r= "Update user set phone=('"+et2.getText().toString()+"')where name='"+et1.getText().toString()+"'";
                String s= "Update user set email=('"+et3.getText().toString()+"')where name='"+et1.getText().toString()+"'";
                String t= "Update user set age=('"+et4.getText().toString()+"')where name='"+et1.getText().toString()+"'";
                String u= "Update user set country=('"+et5.getText().toString()+"')where name='"+et1.getText().toString()+"'";
                //db1.execSQL(q);
                db1.execSQL(r);db1.execSQL(s);db1.execSQL(t);db1.execSQL(u);

                Toast.makeText(getApplicationContext(),"Record Has been Updated",Toast.LENGTH_SHORT).show();
                Intent a=new Intent(getApplicationContext(), select.class);
                startActivity(a);
                finish();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.m1)
        {
            Intent a=new Intent(getApplicationContext(),select.class);
            startActivity(a);
            finish();
        }
        if (id==R.id.m2)
        {
            Intent a=new Intent(getApplicationContext(),History.class);
            startActivity(a);
            finish();
        }
        if (id==R.id.m3)
        {
            Intent a=new Intent(getApplicationContext(),profile.class);
            startActivity(a);
            finish();
        }
        if (id==R.id.m4)
        {
            Intent a=new Intent(getApplicationContext(),about.class);
            startActivity(a);
            finish();
        }
        if (id==R.id.m5)
        {
            Intent a=new Intent(getApplicationContext(),login.class);
            startActivity(a);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}