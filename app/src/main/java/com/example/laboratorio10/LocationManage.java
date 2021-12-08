package com.example.laboratorio10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class LocationManage extends AppCompatActivity implements LocationListener {

    protected  double latitude, longitude;
    TextView txtLat, txtLong;
    LocationManager locationManager;
    @SuppressLint("ServiceCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_manager);
        txtLat=(TextView) findViewById(R.id.Lat);
        txtLong=(TextView) findViewById(R.id.Long);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 100.0f, this);




    }


    @Override
    public void onLocationChanged(@NonNull Location location) {

        latitude= location.getLatitude();
        longitude= location.getLongitude();
        txtLat.setText(String.valueOf(latitude));
        txtLong.setText(String.valueOf(longitude));

        locationManager.removeUpdates(this);



    }
}