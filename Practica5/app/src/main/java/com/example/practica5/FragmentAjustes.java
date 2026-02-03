package com.example.practica5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

// Fragment de la tercera pestaña
public class FragmentAjustes extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflamos el layout del fragment
        return inflater.inflate(R.layout.fragment_ajustes, container, false);
    }
}
