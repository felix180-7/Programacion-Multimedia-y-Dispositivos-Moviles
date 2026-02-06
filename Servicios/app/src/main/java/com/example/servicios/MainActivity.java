package com.example.servicios;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Intent serviceIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btnStartService = findViewById(R.id.btnStartService);
        Button btnStopService = findViewById(R.id.btnStopService);

        serviceIntent = new Intent(this,MyStartedService.class);
        btnStartService.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startService(serviceIntent);
            }
        });
        btnStopService.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                stopService(serviceIntent);
            }
        });
    }
}