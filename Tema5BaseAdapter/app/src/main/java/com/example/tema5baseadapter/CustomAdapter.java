package com.example.tema5baseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private List<ListItem> items;
    private int selectedPosition = -1;

    public CustomAdapter(Context context,List<ListItem> items) {
        this.context = context;
        this.items=items;
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            convertView= LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        }

        ImageView imageView = convertView.findViewById(R.id.itemImage);
        TextView titletextView = convertView.findViewById(R.id.itemTitle);
        TextView contenttextView = convertView.findViewById(R.id.itemcontent);
        RadioButton radioButton = contenttextView.findViewById(R.id.itemradiobutton);

        ListItem item = items.get(position);
        imageView.setImageResource(item.getImageResId());
        titletextView.setText(item.getTitle());
        contenttextView.setText(item.getContent());

        radioButton.setChecked(position == selectedPosition);
        radioButton.setOnClickListener(v -> {
            selectedPosition=position;
            notifyDataSetChanged();
        });

        return convertView;
    }
}
