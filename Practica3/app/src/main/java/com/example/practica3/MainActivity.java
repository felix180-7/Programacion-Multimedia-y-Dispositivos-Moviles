package com.example.practica3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerArticulos;
    private EditText etNombre, etCantidad;
    private ListView listView;

    private ArrayList<Item> listaItems;
    private ShoppingListAdapter adapter;

    // Datos base para el Spinner (nombres + imágenes)
    private String[] nombresSpinner = {"Leche", "Pan", "Huevos"};
    private int[] imagenesSpinner = {
            R.drawable.ic_leche,
            R.drawable.ic_pan,
            R.drawable.ic_huevos
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerArticulos = findViewById(R.id.spinnerArticulos);
        etNombre = findViewById(R.id.etNombre);
        etCantidad = findViewById(R.id.etCantidad);
        listView = findViewById(R.id.listView);

        // Lista de la compra
        listaItems = new ArrayList<>();
        adapter = new ShoppingListAdapter(this, listaItems);
        listView.setAdapter(adapter);

        // Registro para menú contextual
        registerForContextMenu(listView);

        configurarSpinner();
        configurarBotonAgregar();
    }

    private void configurarSpinner() {
        // Adaptador para el Spinner
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                nombresSpinner
        ) {
            @Override
            public View getView(int position, View convertView, android.view.ViewGroup parent) {
                return crearVistaSpinner(position, convertView, parent, false);
            }

            @Override
            public View getDropDownView(int position, View convertView, android.view.ViewGroup parent) {
                return crearVistaSpinner(position, convertView, parent, true);
            }

            private View crearVistaSpinner(int position, View convertView, android.view.ViewGroup parent, boolean dropDown) {
                View row = getLayoutInflater().inflate(
                        dropDown ? R.layout.spinner_item1 : R.layout.spinner_item1,
                        parent,
                        false
                );

                android.widget.ImageView iv = row.findViewById(R.id.ivSpinnerImagen);
                android.widget.TextView tv = row.findViewById(R.id.tvSpinnerTexto);

                iv.setImageResource(imagenesSpinner[position]);
                tv.setText(nombresSpinner[position]);

                return row;
            }
        };

        spinnerAdapter.setDropDownViewResource(R.layout.spinner_item1);
        spinnerArticulos.setAdapter(spinnerAdapter);

        // Cuando cambie la selección, rellenamos el EditText nombre
        spinnerArticulos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                etNombre.setText(nombresSpinner[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Nada
            }
        });
    }

    private void configurarBotonAgregar() {
        findViewById(R.id.btnAgregar).setOnClickListener(v -> agregarItem());
    }

    private void agregarItem() {
        String nombre = etNombre.getText().toString().trim();
        String cantidadStr = etCantidad.getText().toString().trim();

        if (nombre.isEmpty() || cantidadStr.isEmpty()) {
            Toast.makeText(this, "Rellena nombre y cantidad", Toast.LENGTH_SHORT).show();
            return;
        }

        int cantidad;

        try {
            cantidad = Integer.parseInt(cantidadStr);
            if (cantidad==0){
                cantidad=1;
                Toast.makeText(this, "Cantidad no válida, como mínimo 1", Toast.LENGTH_SHORT).show();
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Cantidad no válida", Toast.LENGTH_SHORT).show();
            return;
        }

        int indexSpinner = spinnerArticulos.getSelectedItemPosition();
        int imagenResId = imagenesSpinner[indexSpinner];

        Item nuevo = new Item(nombre, cantidad, imagenResId);
        listaItems.add(nuevo);
        adapter.notifyDataSetChanged();

        etCantidad.setText("");
    }

    // -------- MENÚ CONTEXTUAL (añadir / eliminar) -------- //

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
            getMenuInflater().inflate(R.menu.menu_contextual, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        int position = info.position;
        int id = item.getItemId();

        if (id == R.id.menu_add) {

            // Duplicar elemento
            if (position >= 0 && position < listaItems.size()) {
                Item original = listaItems.get(position);
                Item copia = new Item(
                        original.getNombre(),
                        original.getCantidad(),
                        original.getImagenResId()
                );
                listaItems.add(copia);
                adapter.notifyDataSetChanged();
            }
            return true;

        } else if (id == R.id.menu_delete) {

            // Eliminar elemento
            if (position >= 0 && position < listaItems.size()) {
                listaItems.remove(position);
                adapter.notifyDataSetChanged();
            }
            return true;
        }

        return super.onContextItemSelected(item);
    }

}