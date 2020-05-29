package com.example.samosgo3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.SamosGO3.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RoleSelection2 extends AppCompatActivity {
    DatabaseReference ref2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_selection2);
        Button brd=findViewById(R.id.brd);
        Button brp=findViewById(R.id.brp);
        ref2=FirebaseDatabase.getInstance().getReference("passenger");
       brd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(RoleSelection2.this,DriverInfo.class);
                startActivity(i);

            }
        });
        brp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id2=ref2.push().getKey();
                Passengerob p1=new Passengerob(id2,"staras","https://facebook","koufalis123",-33.855819,151.278834);
                ref2.child(id2).setValue(p1);
Intent i=new Intent(RoleSelection2.this,MapsActivity.class);
i.putExtra("r",1);
i.putExtra("pid",id2);
                startActivity(i);

            }
        });

    }
}
