package com.example.practica4;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Evento> eventos;
    private ArrayAdapter<String> adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eventos = new ArrayList<>();
        listView = findViewById(R.id.listViewEventos);
        Button btnAgregar = findViewById(R.id.btnAgregarEvento);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<String>());
        listView.setAdapter(adapter);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDialogoNombre();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mostrarToastPersonalizado(eventos.get(position));
            }
        });
    }

    private void mostrarDialogoNombre() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Nombre del evento");

        final EditText input = new EditText(this);
        builder.setView(input);

        builder.setPositiveButton("Siguiente", (dialog, which) -> {
            String nombre = input.getText().toString();
            mostrarDatePicker(nombre);
        });

        builder.setNegativeButton("Cancelar", (dialog, which) -> dialog.cancel());
        builder.show();
    }

    private void mostrarDatePicker(final String nombre) {
        final Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePicker = new DatePickerDialog(this,
                (view, year, month, dayOfMonth) -> {
                    String fecha = dayOfMonth + "/" + (month + 1) + "/" + year;
                    mostrarTimePicker(nombre, fecha);
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        datePicker.show();
    }

    private void mostrarTimePicker(final String nombre, final String fecha) {
        final Calendar calendar = Calendar.getInstance();
        TimePickerDialog timePicker = new TimePickerDialog(this,
                (view, hourOfDay, minute) -> {
                    String hora = String.format("%02d:%02d", hourOfDay, minute);
                    Evento evento = new Evento(nombre, fecha, hora);
                    agregarEvento(evento);
                },
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                true);
        timePicker.show();
    }

    private void agregarEvento(Evento evento) {
        eventos.add(evento);
        ArrayList<String> nombres = new ArrayList<>();
        for (Evento e : eventos) {
            nombres.add(e.getNombre());
        }
        adapter.clear();
        adapter.addAll(nombres);
        adapter.notifyDataSetChanged();

        mostrarNotificacion(evento);
    }

    private void mostrarNotificacion(Evento evento) {
        String channelId = "evento_channel";
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId, "Eventos", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.drawable.ic_event)
                .setContentTitle(evento.getNombre())
                .setContentText(evento.getFecha() + " " + evento.getHora())
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        notificationManager.notify((int) System.currentTimeMillis(), builder.build());
    }

    private void mostrarToastPersonalizado(Evento evento) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_custom, null);
        TextView text = layout.findViewById(R.id.toast_text);
        text.setText(evento.getNombre() + "\n" + evento.getFecha() + " " + evento.getHora());

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}