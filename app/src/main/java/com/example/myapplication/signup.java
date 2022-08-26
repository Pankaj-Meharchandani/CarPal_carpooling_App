package com.example.myapplication;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

//import android.app.Activity;
import android.graphics.Color;
//import android.os.Bundle;
import android.text.Editable;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import  android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
public class signup extends AppCompatActivity {
    Button button1;
    EditText et1,et2,et3,et4,et5,et6;
    SQLiteDatabase db1;
    boolean isAllFieldsChecked = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        db1=openOrCreateDatabase("user", Context.MODE_PRIVATE,null);
        button1 = (Button)findViewById(R.id.sign);
        et1 = (EditText)findViewById(R.id.editText);
        et2 = (EditText)findViewById(R.id.phone);
        et3 = (EditText)findViewById(R.id.email);
        et4 = (EditText)findViewById(R.id.age);
        et5 = (EditText)findViewById(R.id.country);
        et6 = (EditText)findViewById(R.id.editText2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                isAllFieldsChecked = CheckAllFields();
                if (isAllFieldsChecked) {
                    String q = "Insert into user Values('" + et1.getText().toString() + "','" + et2.getText() + "','" + et3.getText().toString() + "','" + et4.getText() + "','" + et5.getText().toString() + "','" + et6.getText().toString() + "')";
                    db1.execSQL(q);
                    Toast.makeText(getApplicationContext(), "Record Has Added", Toast.LENGTH_SHORT).show();
                    Intent a = new Intent(getApplicationContext(), login.class);
                    startActivity(a);
                    finish();
                }
            }

            private boolean CheckAllFields() {

                if (et1.length() == 0) {
                    et1.setError("Name is required");
                    return false;
                }
                if ((et2.getText().toString().length() < 10)) {
                    et2.setError("Please enter your 10 digit mobile no.");
                    return false;
                }
                String emailToText = et3.getText().toString();
                if (!Patterns.EMAIL_ADDRESS.matcher(emailToText).matches()) {
                    et3.setError("Enter a valid Email");
                    return false;
                }
                if (et4.length() == 0) {
                    et4.setError("Enter you age");
                    return false;
                }
                if (et5.length() == 0) {
                    et5.setError("This field is required");
                    return false;
                }
                if (!et6.getText().toString().matches( "^(?=.*[_.()$&@]).*$") || (et6.getText().toString().length() < 8)) {
                    et6.setError("Password must be 8 characters long & have at least 1 special character");
                    return false;
                }
                return true;
            }
        });
    }
}
//                if (et1.length() != 0)
//                {Toast.makeText(getApplicationContext(),"Please fill the mandatory fields",Toast.LENGTH_SHORT).show();}
//                if ((et6.getText().toString().length() < 8))
//                {Toast.makeText(getApplicationContext(),"Minimum 8 characters",Toast.LENGTH_SHORT).show();}
//                else if (!et6.getText().toString().matches( "^(?=.*[0-9])(?=.*[a-z])(?=.*[!@#$%^&*+=?-]).{8,15}$"))
//                {Toast.makeText(getApplicationContext(),"No Special characters added",Toast.LENGTH_SHORT).show();}

//                if(et1.length() != 0 && et2.length() != 0 && et3.length() != 0 && et4.length() != 0 && et6.length() != 0)
//                {
//                String q="Insert into user Values('"+et1.getText().toString()+"','"+et2.getText()+"','"+et3.getText().toString()+"','"+et4.getText()+"','"+et5.getText().toString()+"','"+et6.getText().toString()+"')";
//                db1.execSQL(q);
//                Toast.makeText(getApplicationContext(),"Record Has Addedd",Toast.LENGTH_SHORT).show();
//                Intent a=new Intent(getApplicationContext(),login.class);
//                startActivity(a);
//                finish();
//                }
//                else
//                {Toast.makeText(getApplicationContext(),"Please fill the mandatory fields",Toast.LENGTH_SHORT).show();}
//
//                Intent i=new Intent(getApplicationContext(),login.class);
//                Intent i2=new Intent(getApplicationContext(),profile.class);
//                Intent i3=new Intent(getApplicationContext(),profile.class);
//                Intent i4=new Intent(getApplicationContext(),profile.class);
//                Intent i5=new Intent(getApplicationContext(),profile.class);
//                Intent j=new Intent(getApplicationContext(),login.class);
//                String x=et1.getText().toString();
//                String x2=et2.getText().toString();
//                String x3=et3.getText().toString();
//                String x4=et4.getText().toString();
//                String x5=et5.getText().toString();
//                Editable x6=et6.getText();
//                i.putExtra("data",x);
//                i2.putExtra("data",x2);
//                i3.putExtra("data",x3);
//                i4.putExtra("data",x4);
//                i5.putExtra("data",x5);
//                j.putExtra("data",x6);
//                startActivity(i);
//                startActivity(j);
//            }
//        });
//    }
//}