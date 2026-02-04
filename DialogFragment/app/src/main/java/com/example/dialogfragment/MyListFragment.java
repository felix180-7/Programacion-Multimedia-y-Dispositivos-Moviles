package com.example.dialogfragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

public class MyListFragment extends ListFragment {

    public void onActivityCreated (@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        //Datos para la lista
        String [] items = {"Elemento 1", "Elemento 2", "Elemento 3"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1,items);
        setListAdapter(adapter);
    }

    public void onListItemClick(@Nullable ListView l, @Nullable View v, int position, long id) {
        super.onListItemClick(l,v,position,id);
        String item = (String) l.getItemAtPosition(position);
        Toast.makeText(getContext(),"Seleccionaste: "+item,Toast.LENGTH_SHORT).show();
    }

}
