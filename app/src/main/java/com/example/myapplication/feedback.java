package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
public class feedback extends AppCompatActivity {
    TextView tv1,sug;
    SeekBar sb1;
    Button b;
    SQLiteDatabase db1;
    int p=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        db1=openOrCreateDatabase("user", Context.MODE_PRIVATE,null);
        db1.execSQL("Create table If Not Exists Feedback(rating int,suggestions varchar(50));");
        tv1=findViewById(R.id.rating);
        sb1=findViewById(R.id.sb);
        b=findViewById(R.id.feed);
        sug=findViewById(R.id.suggestions);
        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tv1.setText(""+sb1.getProgress());
               // p=Integer.parseInt(tv1.getText()+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String q="Insert into Feedback Values('"+tv1.getText().toString()+"','"+sug.getText()+"')";
                db1.execSQL(q);
                Toast.makeText(feedback.this, "ThankYou for your valuable feedback", Toast.LENGTH_SHORT).show();
                Intent a=new Intent(getApplicationContext(),about.class);
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