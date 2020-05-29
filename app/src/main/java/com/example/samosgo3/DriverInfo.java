package com.example.samosgo3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.SamosGO3.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DriverInfo extends AppCompatActivity {
  DatabaseReference df;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_info);
        Button dib=findViewById(R.id.button7);
        df= FirebaseDatabase.getInstance().getReference("drivers");
        final EditText t1=findViewById(R.id.t1);
       final  EditText t2=findViewById(R.id.editText4);

        dib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id1=df.push().getKey();
                Driverob d1=new Driverob(id1,"giannis","https://...","giannis199",-33.798778,151.174375,t1.getText().toString(),t2.getText().toString(),0);
                df.child(id1).setValue(d1);
                Intent i3=new Intent(DriverInfo.this,MapsActivity.class);
                i3.putExtra("id",id1);
                startActivity(i3);
            }
        });


    }
}
