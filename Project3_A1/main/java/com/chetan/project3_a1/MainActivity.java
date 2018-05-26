package com.chetan.project3_a1;

import android.Manifest;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission_group.CAMERA;

public class MainActivity extends AppCompatActivity {
    public static final String TOAST_INTENT = "edu_uic_cs478_sp18_Attraction";
    public static final String CHETANS_PERMISSION = "edu.uic.cs478.ChetansPermission";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermissionandBroadcast();
        Button Attraction_Btn = (Button)findViewById(R.id.btn_attractions);
        Button Restaurant_Btn = (Button)findViewById(R.id.btn_restaurants);

        Attraction_Btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int result = ContextCompat.checkSelfPermission(MainActivity.this, CHETANS_PERMISSION);
                if (result == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getBaseContext(), "PERMISSION GRANTED", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName("com.chetan.project3_a2", "com.chetan.project3_a2.MainActivity"));
                    startActivity(intent);
                }
                else{
                    checkPermissionandBroadcast();
                }
            }
        });
        Restaurant_Btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int result = ContextCompat.checkSelfPermission(MainActivity.this, CHETANS_PERMISSION);
                if (result == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getBaseContext(), "PERMISSION GRANTED", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName("com.chetan.project3_a2", "com.chetan.project3_a2.MainActivity"));
                    startActivity(intent);
                }
                else{
                    checkPermissionandBroadcast();
                }
            }
        });
    }

    private void checkPermissionandBroadcast(){
        if(ContextCompat.checkSelfPermission(this, CHETANS_PERMISSION) == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(getBaseContext(), "PERMISSION GRANTED", Toast.LENGTH_LONG).show();
        }
        else{
            ActivityCompat.requestPermissions(this,new String[]{CHETANS_PERMISSION},0);
        }

    }


}





