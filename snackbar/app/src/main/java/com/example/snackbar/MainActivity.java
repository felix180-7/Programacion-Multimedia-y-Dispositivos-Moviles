package com.example.snackbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.layout);

        Button showSnackbarButton = findViewById(R.id.showSnackbarButton);

        showSnackbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"This is a Snackbar!",Snackbar.LENGTH_LONG)
                        .setAction("UNDO", new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                Snackbar.make(v,"Action undone", Snackbar.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
    }
}