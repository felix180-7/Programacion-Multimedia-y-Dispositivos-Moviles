package com.example.ejerciciogridlayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.grid);
        Button boton1  = findViewById(R.id.boton1);
        Button boton2  = findViewById(R.id.boton2);
        Button boton3  = findViewById(R.id.boton3);
        Button boton4  = findViewById(R.id.boton4);
        Button boton5  = findViewById(R.id.boton5);
        Button boton6  = findViewById(R.id.boton6);
        Button boton7  = findViewById(R.id.boton7);
        Button boton8  = findViewById(R.id.boton8);
        Button boton9  = findViewById(R.id.boton9);
        Button boton0  = findViewById(R.id.boton0);
        Button botonE1  = findViewById(R.id.botonE1);
        Button botonE2  = findViewById(R.id.botonE2);
        Button botonE3  = findViewById(R.id.botonE3);
        Button botonE4  = findViewById(R.id.botonE4);
        Button botonE5  = findViewById(R.id.botonE5);
        Button botonE6  = findViewById(R.id.botonE6);
        Button botonC  = findViewById(R.id.botonC);
        Button botonAC  = findViewById(R.id.botonAC);

        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);
        boton3.setOnClickListener(this);
        boton3.setOnClickListener(this);
        boton4.setOnClickListener(this);
        boton5.setOnClickListener(this);
        boton6.setOnClickListener(this);
        boton7.setOnClickListener(this);
        boton8.setOnClickListener(this);
        boton9.setOnClickListener(this);
        boton0.setOnClickListener(this);
        botonE1.setOnClickListener(this);
        botonE2.setOnClickListener(this);
        botonE3.setOnClickListener(this);
        botonE4.setOnClickListener(this);
        botonE5.setOnClickListener(this);
        botonE6.setOnClickListener(this);
        botonC.setOnClickListener(this);
        botonAC.setOnClickListener(this);

    }

    public void onClick(View view){
        TextView texto = findViewById(R.id.texto);
        int id = view.getId();
        Log.i("boton1","se mete en boton 1");

        String barra = (String) texto.getText();

        if (barra.equals("0")) barra = "";

        if (id == R.id.boton1){
            Log.i("boton1","se mete en boton 1");
            texto.setText(barra+"1");

        }
        if (id == R.id.boton2){
            texto.setText(barra+"2");
        }
        if (id == R.id.boton3){
            texto.setText(barra+"3");
        }
        if (id == R.id.boton4){
            texto.setText(barra+"4");
        }
        if (id == R.id.boton5){
            texto.setText(barra+"5");
        }
        if (id == R.id.boton6){
            texto.setText(barra+"6");
        }
        if (id == R.id.boton7){
            texto.setText(barra+"7");
        }
        if (id == R.id.boton8){
            texto.setText(barra+"8");
        }
        if (id == R.id.boton9){
            texto.setText(barra+"9");
        }
        if (id == R.id.boton0){
            texto.setText(barra+"0");
        }

        // es /
        if (id == R.id.botonE1){
            texto.setText(barra+"/");
        }
        // es *
        if (id == R.id.botonE2){
            texto.setText(barra+"*");
        }
        // es -
        if (id == R.id.botonE3){
            texto.setText(barra+"-");
        }
        // es .
        if (id == R.id.botonE4){
            texto.setText(barra+".");
        }

        // es =
        if (id == R.id.botonE5){

        }

        // es +
        if (id == R.id.botonE6) {
            texto.setText(barra+"+");
        }

        // es AC
        if (id == R.id.botonC) {
            String textoActual = texto.getText().toString();

            if (textoActual.length() > 0) {
                textoActual = textoActual.substring(0, textoActual.length() - 1);
            }

            if (textoActual.isEmpty()) {
                textoActual = "0";
            }
            texto.setText(textoActual);
        }
        
        // es C
        if (id == R.id.botonAC) {
            texto.setText("0");
        }

    }
}