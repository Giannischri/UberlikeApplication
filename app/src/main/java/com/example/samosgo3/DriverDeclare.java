package com.example.samosgo3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.SamosGO3.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DriverDeclare extends AppCompatActivity {
    Button db,bb;
    EditText t1,t2,t3,t4;
    CalendarView c1;
    SimpleDateFormat sdf;
DatabaseReference databaseRoutes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_declare);
        db = findViewById(R.id.button5);
         bb=findViewById(R.id.button4);
        t1 = findViewById(R.id.start);
        t2 = findViewById(R.id.end);
         t3 = findViewById(R.id.h);
        t4=findViewById(R.id.p);
        c1 = findViewById(R.id.calendarView);
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        databaseRoutes= FirebaseDatabase.getInstance().getReference("drivers").child(getIntent().getExtras().getString("id"));
        db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=databaseRoutes.push().getKey();
                Routeob r1 = new Routeob(id,t1.getText().toString(), t2.getText().toString(), sdf.format(new Date(c1.getDate())),t3.getText().toString(), t4.getText().toString(), "", "", "", "");
                databaseRoutes.child("route").child(id).setValue(r1);
                startActivity(new Intent(DriverDeclare.this,MapsActivity.class));
            }
        });
        bb.setOnClickListener(new View.OnClickListener(){
                                  @Override
                                  public void onClick(View v) {
                                      startActivity(new Intent(DriverDeclare.this,MapsActivity.class));
                                  }
                              }

        );
    }
}
