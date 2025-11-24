package com.example.tema5menu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.layout1);
        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        setSupportActionBar(toolbar);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.optionsmenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        TextView a = findViewById(R.id.textview);
        if (id == R.id.action_refrescar) {
            Toast.makeText(this, "Refresca...", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_settings) {
            a.setText("ajustes");            return true;
        } else if (id == R.id.action_info) {
            Toast.makeText(this, "Información...", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_acercade) {
            Toast.makeText(this, "Acerca de...", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}