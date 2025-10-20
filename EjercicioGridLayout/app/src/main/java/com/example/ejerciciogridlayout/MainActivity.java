//paquete donde se situa la clase
package com.example.ejerciciogridlayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//main
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //variable operador, que sera +, -, /, *,
    private String operador = "";
    //variable c
    private double c = 0;

    //método onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);

        //identificación de cada botón
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
        Button botonE1 = findViewById(R.id.botonE1);
        Button botonE2 = findViewById(R.id.botonE2);
        Button botonE3 = findViewById(R.id.botonE3);
        Button botonE4 = findViewById(R.id.botonE4);
        Button botonE5 = findViewById(R.id.botonE5);
        Button botonE6 = findViewById(R.id.botonE6);
        Button botonC  = findViewById(R.id.botonC);
        Button botonAC = findViewById(R.id.botonAC);

        //vinculo de cada botón al método onClick
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

    //método onClick
    public void onClick(View view){
        //identificación del textView
        TextView texto = findViewById(R.id.texto);
        int id = view.getId();

        //variable donde escribes y luego añadirlo al textView
        String barra = texto.getText().toString();

        //si al empezar la barra es 0, cuando se pulse algo se vuelve nada
        if (barra.equals("0")) barra = "";

        //botones del 0 al 9, si les pulsas se añaden a la variable barra que esta dentro del textView
        if (id == R.id.boton1) texto.setText(barra+"1");
        if (id == R.id.boton2) texto.setText(barra+"2");
        if (id == R.id.boton3) texto.setText(barra+"3");
        if (id == R.id.boton4) texto.setText(barra+"4");
        if (id == R.id.boton5) texto.setText(barra+"5");
        if (id == R.id.boton6) texto.setText(barra+"6");
        if (id == R.id.boton7) texto.setText(barra+"7");
        if (id == R.id.boton8) texto.setText(barra+"8");
        if (id == R.id.boton9) texto.setText(barra+"9");
        if (id == R.id.boton0) texto.setText(barra+"0");

        //botón de dividir
        if (id == R.id.botonE1){
            // cambia el operador a /
            operador = "/";
            //si la barra esta vacía se pone 0, sino se convierte el texto de barra a double
            c = barra.isEmpty() ? 0 : Double.parseDouble(barra);
            //si el texto no termina con un signo, sino con un número, se añade el /. Si termina con un signo se para y se cierra el programa
            if (!barra.endsWith("/") && !barra.endsWith("*") && !barra.endsWith("+") && !barra.endsWith("-"))
                texto.setText(barra+"/");
        }
        // botón de multiplicar
        if (id == R.id.botonE2){
            // cambia el operador a *
            operador = "*";
            //si la barra esta vacía se pone 0, sino se convierte el texto de barra a double
            c = barra.isEmpty() ? 0 : Double.parseDouble(barra);
            //si el texto no termina con un signo, sino con un número, se añade el *. Si termina con un signo se para y se cierra el programa
            if (!barra.endsWith("/") && !barra.endsWith("*") && !barra.endsWith("+") && !barra.endsWith("-"))
                texto.setText(barra+"*");
        }
        // botón de restar
        if (id == R.id.botonE3){
            // cambia el operador a -
            operador = "-";
            //si la barra esta vacía se pone 0, sino se convierte el texto de barra a double
            c = barra.isEmpty() ? 0 : Double.parseDouble(barra);
            //si el texto no termina con un signo, sino con un número, se añade el -. Si termina con un signo se para y se cierra el programa
            if (!barra.endsWith("/") && !barra.endsWith("*") && !barra.endsWith("+") && !barra.endsWith("-"))
                texto.setText(barra+"-");
        }
        // botón de más
        if (id == R.id.botonE6){
            // cambia el operador a +
            operador = "+";
            //si la barra esta vacía se pone 0, sino se convierte el texto de barra a double
            c = barra.isEmpty() ? 0 : Double.parseDouble(barra);
            //si el texto no termina con un signo, sino con un número, se añade el +. Si termina con un signo se para y se cierra el programa
            if (!barra.endsWith("/") && !barra.endsWith("*") && !barra.endsWith("+") && !barra.endsWith("-"))
                texto.setText(barra+"+");
        }

        // Punto decimal
        if (id == R.id.botonE4){
            //si la barra tiene ya ., no se pone, además, si esta vacio, se pone un 0 delante, y si no tiene . ni esta vacía se pone .
            if (!barra.contains(".")) texto.setText(barra.isEmpty() ? "0." : barra+".");
        }

        // Igual
        if (id == R.id.botonE5){
            //iniciación variable b
            double b = 0;
            if (!barra.isEmpty()) {
                // array en el que se quitan los signos y se recoge lo que hay en la barra
                String[] partes = barra.split("[\\+\\-\\*/]");
                //Usa un operador ternario (? :) para asignar un valor a b. Si partes tiene más de un elemento (partes.length > 1), convierte el segundo elemento (partes[1]) a número (double) y lo guarda en b. Si no (por ejemplo, si solo hay un número antes de cualquier operador), deja b como 0
                b = partes.length > 1 ? Double.parseDouble(partes[1]) : 0;
            }// Se declara una variable para guardar el resultado de la operación
            double resultado = 0;

            // Según el operador seleccionado, se realiza la operación correspondiente
            switch (operador) {
                case "+":
                    resultado = c + b;  // Suma de c y b
                    break;
                case "-":
                    resultado = c - b;  // Resta de c y b
                    break;
                case "*":
                    resultado = c * b;  // Multiplicación de c y b
                    break;
                case "/":
                    resultado = c / b;  // División de c y b
                    break;
            }

            // Muestra el resultado en el textView
            texto.setText("" + resultado);

            // Reinicia las variables para preparar la siguiente operación
            operador = "";
            c = 0;
        }

        // C (borrar último carácter)
        if (id == R.id.botonC) {
            // Si la barra no está vacía, se borra el último carácter
            if (!barra.isEmpty()) barra = barra.substring(0, barra.length() - 1);

            // Si después de borrar queda vacía, se muestra un "0"
            if (barra.isEmpty()) barra = "0";

            // Actualiza el texto en pantalla
            texto.setText(barra);
        }

        // AC (borrar todo)
        if (id == R.id.botonAC) {
            // Reinicia el texto en el textView a "0"
            texto.setText("0");

            // Limpia el operador y la variable de cálculo
            operador = "";
            c = 0;
        }
    }
}