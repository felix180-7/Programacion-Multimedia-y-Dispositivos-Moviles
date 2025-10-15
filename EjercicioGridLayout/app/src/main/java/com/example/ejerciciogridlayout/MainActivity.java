package com.example.ejerciciogridlayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String operador = "";
    private double c = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        String barra = texto.getText().toString();

        if (barra.equals("0")) barra = "";

        if (id == R.id.boton1){
            if (barra.equals("Infinity")) barra = "";
            if (barra.equals("NaN")) barra = "";
            texto.setText(barra+"1");
        }
        if (id == R.id.boton2){
            if (barra.equals("Infinity")) barra = "";
            if (barra.equals("NaN")) barra = "";
            texto.setText(barra+"2");
        }
        if (id == R.id.boton3){
            if (barra.equals("Infinity")) barra = "";
            if (barra.equals("NaN")) barra = "";
            texto.setText(barra+"3");
        }
        if (id == R.id.boton4){
            if (barra.equals("Infinity")) barra = "";
            if (barra.equals("NaN")) barra = "";
            texto.setText(barra+"4");
        }
        if (id == R.id.boton5){
            if (barra.equals("Infinity")) barra = "";
            if (barra.equals("NaN")) barra = "";
            texto.setText(barra+"5");
        }
        if (id == R.id.boton6){
            if (barra.equals("Infinity")) barra = "";
            if (barra.equals("NaN")) barra = "";
            texto.setText(barra+"6");
        }
        if (id == R.id.boton7){
            if (barra.equals("Infinity")) barra = "";
            if (barra.equals("NaN")) barra = "";
            texto.setText(barra+"7");
        }
        if (id == R.id.boton8){
            if (barra.equals("Infinity")) barra = "";
            if (barra.equals("NaN")) barra = "";
            texto.setText(barra+"8");
        }
        if (id == R.id.boton9){
            if (barra.equals("Infinity")) barra = "";
            if (barra.equals("NaN")) barra = "";
            texto.setText(barra+"9");
        }
        if (id == R.id.boton0){
            if (barra.equals("Infinity")) barra = "";
            if (barra.equals("NaN")) barra = "";
            texto.setText(barra+"0");
        }

        // es /
        if (id == R.id.botonE1){
            if (barra.equals("Infinity")) barra = "";
            if (barra.equals("NaN")) barra = "";
            operador = "/";
            c = barra.isEmpty() ? 0 : Double.parseDouble(barra);
            texto.setText("0");
        }
        // es *
        if (id == R.id.botonE2){
            if (barra.equals("Infinity")) barra = "";
            if (barra.equals("NaN")) barra = "";
            operador = "*";
            c = barra.isEmpty() ? 0 : Double.parseDouble(barra);
            texto.setText("0");
        }
        // es -
        if (id == R.id.botonE3){
            if (barra.equals("Infinity")) barra = "";
            if (barra.equals("NaN")) barra = "";
            operador = "-";
            c = barra.isEmpty() ? 0 : Double.parseDouble(barra);
            texto.setText("0");
        }
        // es +
        if (id == R.id.botonE6) {
            if (barra.equals("Infinity")) barra = "";
            if (barra.equals("NaN")) barra = "";
            operador = "+";
            c = barra.isEmpty() ? 0 : Double.parseDouble(barra);
            texto.setText("0");
        }
        // es .
        if (id == R.id.botonE4){
            if (barra.equals("Infinity")) barra = "";
            if (barra.equals("NaN")) barra = "";
            if (!barra.contains(".")) {
                texto.setText(barra.isEmpty() ? "0." : barra+".");
            }
        }

        // es =
        if (id == R.id.botonE5){
            if (barra.equals("Infinity")) barra = "";
            if (barra.equals("NaN")) barra = "";
            double b = barra.isEmpty() ? 0 : Double.parseDouble(barra);
            double resultado = 0;
            switch (operador){
                case "+": resultado = c + b; break;
                case "-": resultado = c - b; break;
                case "*": resultado = c * b; break;
                case "/": resultado = c / b; break;
            }
            texto.setText(""+resultado);
            operador = "";
            c = 0;
        }

        // es C (borrar último)
        if (id == R.id.botonC) {
            if (barra.equals("Infinity")) barra = "";
            if (barra.equals("NaN")) barra = "";
            if (!barra.isEmpty()) barra = barra.substring(0, barra.length() - 1);
            if (barra.isEmpty()) barra = "0";
            texto.setText(barra);
        }

        // es AC (borrar todo)
        if (id == R.id.botonAC) {
            texto.setText("0");
            operador = "";
            c = 0;
        }
    }
}