package com.example.edittext;

import android.content.SyncStatusObserver;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

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
        Button bt = findViewById(R.id.button);
        TextView t = findViewById(R.id.textview);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selec = rg.getCheckedRadioButtonId();

                if (selec!=-1){
                    RadioButton abc = findViewById(selec);
                    String opcion = abc.getText().toString();
                    t.setText(opcion);
                }else {
                    t.setText("No has seleccionado nada");
                }
            }
        });

        Switch b = findViewById(R.id.a);

        b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    texto.setText("encendido");
                }else {
                    texto.setText("apagado");
                }
            }
        });

        SeekBar sb = findViewById(R.id.b);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                texto.setText("Valor: "+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        RatingBar rat = findViewById(R.id.ratingbar);

        rat.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                texto.setText("Valoración: "+rating);
            }
        });

        ProgressBar pb = findViewById(R.id.pbcircular);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            int v=0;
            @Override
            public void run() {
                if (v<=100){
                    pb.setProgress(v+=5);
                    new Handler(Looper.getMainLooper()).postDelayed(this,200);
                }
            };
        },200);



    }
}