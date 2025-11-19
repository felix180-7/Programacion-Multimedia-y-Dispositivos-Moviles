package com.example.adapatdorespersonalizados;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.principal);

        View micabecera = getLayoutInflater().inflate(R.layout.cabecera,null);

        Datos [] datos = new Datos [] {
                new Datos("Linea principal 1 ","Linea inferior 1"),
                new Datos("Linea principal 2 ","Linea inferior 2"),
                new Datos("Linea principal 3 ","Linea inferior 3"),
                new Datos("Linea principal 4 ","Linea inferior 4")
        };

        ListView a = findViewById(R.id.list);

        a.addHeaderView(micabecera);

        Adaptador adaptador = new Adaptador(this,datos);

        a.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selectedItem = ((Datos)parent.getItemAtPosition(position)).getTexto1();

                Toast.makeText(MainActivity.this,"Elemento pulsado: "+ selectedItem, Toast.LENGTH_SHORT).show();
            }
        });

        a.setAdapter(adaptador);
    }

}