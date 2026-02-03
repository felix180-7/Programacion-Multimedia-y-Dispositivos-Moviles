package com.example.practica5;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Cargamos el layout principal
        setContentView(R.layout.activity_main);

        // Referencias a los elementos de la vista
        ViewPager viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        FloatingActionButton fab = findViewById(R.id.fab);

        // Creamos el adaptador para gestionar los fragments
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        // Añadimos los fragments al adaptador
        adapter.addFragment(new FragmentFormulario(), "Formulario");
        adapter.addFragment(new FragmentInfo(), "Info");
        adapter.addFragment(new FragmentAjustes(), "Ajustes");

        // Asignamos el adaptador al ViewPager
        viewPager.setAdapter(adapter);

        // Conectamos el TabLayout con el ViewPager
        tabLayout.setupWithViewPager(viewPager);

        // Asignamos iconos a cada pestaña
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_edit);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_info);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_settings);

        // Acción del Floating Action Button
        fab.setOnClickListener(view ->
                Snackbar.make(view, "Acción realizada correctamente", Snackbar.LENGTH_LONG)
                        .setAction("DESHACER", v -> {
                            // Acción del botón DESHACER
                        })
                        .show()
        );
    }
}
