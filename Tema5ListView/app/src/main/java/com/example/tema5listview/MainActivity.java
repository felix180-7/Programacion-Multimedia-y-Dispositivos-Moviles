package com.example.tema5listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TextView a = findViewById(R.id.txtEstado);

        List<String> data = Arrays.asList("Elemento 1","Elemento 2", "Elemento 3");

        ListView lista = findViewById(R.id.listav);
        ArrayAdapter<String> adapter= new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,data);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String b = (String) parent.getItemAtPosition(position);

                a.setText(b);
            }
        });
    }
}