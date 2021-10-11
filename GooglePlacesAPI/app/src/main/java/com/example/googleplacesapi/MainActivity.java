package com.example.googleplacesapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LocationListener {


    private EditText editTextEnlem,editTextBoylam;
    private Button buttonGit,buttonKonumAl;
    private String konumSaglayici = "gps";
    private int izinKontrol;
    private LocationManager locationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextBoylam = findViewById(R.id.editTextBoylam);
        editTextEnlem = findViewById(R.id.editTextEnlem);
        buttonGit = findViewById(R.id.buttonGit);
        buttonKonumAl = findViewById(R.id.buttonKonumAl);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        buttonGit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String enlem = editTextEnlem.getText().toString().trim();
                String boylam = editTextBoylam.getText().toString().trim();

                Intent ıntent = new Intent(MainActivity.this,Places.class);
                ıntent.putExtra("enlem",enlem);
                ıntent.putExtra("boylam",boylam);
                startActivity(ıntent);

            }
        });

        buttonKonumAl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                izinKontrol = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION);

                if(izinKontrol != PackageManager.PERMISSION_GRANTED){

                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},100);

                }else{

                    Location konum = locationManager.getLastKnownLocation(konumSaglayici);

                    if(konum != null){
                        onLocationChanged(konum);
                    }else{
                        Toast.makeText(getApplicationContext(),"hata",Toast.LENGTH_SHORT).show();
                    }

                }



            }
        });
    }

    @Override
    public void onLocationChanged(Location location) {
        Double enlem = location.getLatitude();
        Double boylam = location.getLongitude();

        Intent ıntent = new Intent(MainActivity.this,Places.class);
        ıntent.putExtra("enlem",String.valueOf(enlem));
        ıntent.putExtra("boylam",String.valueOf(boylam));
        startActivity(ıntent);

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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {


        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100) {

            izinKontrol = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION);

            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getApplicationContext(), "İzin verildi", Toast.LENGTH_SHORT).show();

                Location konum = locationManager.getLastKnownLocation(konumSaglayici);

                if (konum != null) {
                    onLocationChanged(konum);
                } else {
                    Toast.makeText(getApplicationContext(), "hata", Toast.LENGTH_SHORT).show();
                }


            } else {
                Toast.makeText(getApplicationContext(), "İzin verilmedi", Toast.LENGTH_SHORT).show();
            }

        }
    }
}