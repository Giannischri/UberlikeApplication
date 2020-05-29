package com.example.samosgo3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.SamosGO3.R;
import com.google.firebase.database.DatabaseReference;

public class DriverProfile extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    DatabaseReference df,df2;
    Button bb,jb,sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_profile);
        t1=findViewById(R.id.name);
        t2=findViewById(R.id.email);
        t3=findViewById(R.id.from);
        t4=findViewById(R.id.to);
        t5=findViewById(R.id.price);
        t6=findViewById(R.id.p1);
        t7=findViewById(R.id.p2);
        t8=findViewById(R.id.p3);
        t9=findViewById(R.id.p4);
        t10=findViewById(R.id.date);
        t11=findViewById(R.id.hour);
        bb=findViewById(R.id.bb2);
        jb=findViewById(R.id.jb);
        sb=findViewById(R.id.rb);

        t1.setText("mixalhs");
        t2.setText("mixalhsvaras@hotmail.com");
        t3.setText("From:vathi");
        t4.setText("To:karlovasi");
        t5.setText("price:15");
        t10.setText("Date:22/2/2020");
        t11.setText("Hour:14:00");
        t6.setText("giannis@gmail.com");
        t7.setText("");
        t8.setText("");
        t9.setText("");
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DriverProfile.this,MapsActivity.class));
            }
        });
        jb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DriverProfile.this,MapsActivity.class));
            }
        });
        sb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(DriverProfile.this,MapsActivity.class);
                i.putExtra("route",1);
                startActivity(i);
            }
        });



    }
}
