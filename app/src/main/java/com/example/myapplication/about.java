package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class about extends AppCompatActivity {
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        b1=findViewById(R.id.rate);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(getApplicationContext(),feedback.class);
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