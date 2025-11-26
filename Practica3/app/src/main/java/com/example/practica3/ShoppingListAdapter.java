package com.example.practica3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ShoppingListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Item> items;

    public ShoppingListAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder {
        ImageView ivImagen;
        TextView tvNombre;
        TextView tvCantidad;
        Button btnEliminar;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_shopping, parent, false);
            holder = new ViewHolder();
            holder.ivImagen = convertView.findViewById(R.id.ivImagen);
            holder.tvNombre = convertView.findViewById(R.id.tvNombre);
            holder.tvCantidad = convertView.findViewById(R.id.tvCantidad);
            holder.btnEliminar = convertView.findViewById(R.id.btnEliminar);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Item item = items.get(position);

        holder.tvNombre.setText(item.getNombre());
        holder.tvCantidad.setText("Cantidad: " + item.getCantidad());
        holder.ivImagen.setImageResource(item.getImagenResId());

        holder.btnEliminar.setOnClickListener(v -> {
            items.remove(position);
            notifyDataSetChanged();
        });

        return convertView;
    }
}