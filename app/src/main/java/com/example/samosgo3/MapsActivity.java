package com.example.samosgo3;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.example.SamosGO3.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.HashMap;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private LocationListener locationListener;
    private LocationManager locationManager;
    private final long MIN_TIME = 1000; // 1 second
    private final long MIN_DIST = 5; // 5 Meters
    private LatLng latLng;
    private static final LatLng l1= new LatLng(34.900349, -118.760803);
    private Marker m1,m2;
private Button plus;
DatabaseReference df;
Polyline cpol;


    public MapsActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, PackageManager.PERMISSION_GRANTED);
        plus= findViewById(R.id.b1);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(MapsActivity.this,DriverDeclare.class);
                i2.putExtra("id",getIntent().getExtras().getString("id"));
                startActivity(i2);
            }
        });
        Button change=findViewById(R.id.b2);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(getIntent().getExtras().getInt("r")==1)
               {
                   plus.setVisibility(View.VISIBLE);
                   getIntent().putExtra("r",0);
               }
            }
        });



    }
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //loadmarkers();


        m1 = mMap.addMarker(new MarkerOptions()
                .position(l1)
                .title("Perth"));
        m1.setTag(0);

        mMap.setOnMarkerClickListener(this);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                try {
                    latLng = new LatLng(location.getLatitude(), location.getLongitude());
                    m2=mMap.addMarker(new MarkerOptions().position(latLng).title("My Position"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                }
                catch (SecurityException e){
                    e.printStackTrace();
                }

            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        try {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME, MIN_DIST, locationListener);
        }
        catch (SecurityException e){
            e.printStackTrace();
        }



    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        if (marker.equals(m1)){
        Intent i1=new Intent(MapsActivity.this,DriverProfile.class);
        startActivity(i1);
        }


        return false;
    }
    public void loadmarkers()
    {
        final HashMap<String,Marker> h=new HashMap<String,Marker>();
         df= FirebaseDatabase.getInstance().getReference("drivers").push();
        df.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data: dataSnapshot.getChildren()){

                    LatLng l =new LatLng(Double.valueOf(data.child("x").getValue().toString()),Double.valueOf(data.child("y").getValue().toString()));
                    m2=mMap.addMarker(new MarkerOptions().position(l));
                    h.put(df.toString(),m2);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }



}