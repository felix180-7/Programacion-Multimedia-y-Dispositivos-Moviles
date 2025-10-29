package com.example.edittext;

import android.content.SyncStatusObserver;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        String [] opciones = {"Opción1","Opción2","Opción3","Opción4","Opción5"};
        AutoCompleteTextView texto = findViewById(R.id.comp);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,opciones);
        texto.setAdapter(adaptador);

        Spinner spinner= findViewById(R.id.spinner);

        String[] valores = {"Azul","Negro","Rojo","Verde","Amarillo"};

        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,valores));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                System.out.println("Has seleccionado el valor: "+adapterView.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                System.out.println("No has seleccionado nada");
            }
        });

        LinearLayout l = findViewById(R.id.mainLayout);

        CheckBox checkbox = findViewById(R.id.cbox);

        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    l.setBackgroundColor(Color.RED);
                }else{
                    l.setBackgroundColor(Color.BLUE);
                }
            }
        });

        RadioGroup rg = findViewById(R.id.radiogroup);


    }
}