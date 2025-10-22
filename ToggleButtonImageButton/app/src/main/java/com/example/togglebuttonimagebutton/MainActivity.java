package com.example.togglebuttonimagebutton;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView txtEstado;

    private ToggleButton toggleButton;

    private ImageButton imageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txtEstado = findViewById(R.id.txtEstado);
        toggleButton = findViewById(R.id.toggleButton);
        imageButton = findViewById(R.id.imageButton);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    txtEstado.setText("Estado: Pulsado");
                } else {
                    txtEstado.setText("Estado: No Pulsado");
                }
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            boolean esta = false; // Estado inicial (false = mostrar "pulsar")

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Has pulsado el ImageButton", Toast.LENGTH_SHORT).show();

                if (esta) {
                    imageButton.setImageResource(R.drawable.pulsar); // Cambia a "play"
                } else {
                    imageButton.setImageResource(R.drawable.pausar); // Cambia a "pause"
                }

                esta = !esta; // Cambia el estado
            }
        });
    }
}