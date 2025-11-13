package com.example.gestorbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etTotalCuenta;
    private CheckBox cbPropina;
    private SeekBar seekBarPropina;
    private TextView tvPorcentaje, tvResultado;
    private RadioGroup rgMetodoPago;
    private RatingBar ratingBar;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar controles
        etTotalCuenta = findViewById(R.id.etTotalCuenta);
        cbPropina = findViewById(R.id.cbPropina);
        seekBarPropina = findViewById(R.id.seekBarPropina);
        tvPorcentaje = findViewById(R.id.tvPorcentaje);
        rgMetodoPago = findViewById(R.id.rgMetodoPago);
        ratingBar = findViewById(R.id.ratingBar);
        btnCalcular = findViewById(R.id.btnCalcular);
        tvResultado = findViewById(R.id.tvResultado);

        // Actualizar porcentaje de propina
        seekBarPropina.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvPorcentaje.setText("Propina: " + progress + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        // Botón calcular
        btnCalcular.setOnClickListener(v -> calcularTotal());
    }

    private void calcularTotal() {
        String textoTotal = etTotalCuenta.getText().toString().trim();

        if(textoTotal.isEmpty()) {
            tvResultado.setTextColor(Color.RED);
            tvResultado.setText("Por favor, ingrese el total de la cuenta");
            return;
        }

        double total;
        try {
            total = Double.parseDouble(textoTotal);
        } catch (NumberFormatException e) {
            tvResultado.setTextColor(Color.RED);
            tvResultado.setText("Valor no válido, ingrese solo números");
            return;
        }

        if(total <= 0) {
            tvResultado.setTextColor(Color.RED);
            tvResultado.setText("El total debe ser mayor que 0");
            return;
        }

        // Calcular propina
        if(cbPropina.isChecked()) {
            int porcentaje = seekBarPropina.getProgress();
            total += total * porcentaje / 100.0;
        }

        // Método de pago
        int idSeleccionado = rgMetodoPago.getCheckedRadioButtonId();
        String metodoPago = ((RadioButton)findViewById(idSeleccionado)).getText().toString();

        // Calificación
        float calificacion = ratingBar.getRating();

        // Mostrar resultado
        tvResultado.setTextColor(Color.BLACK);
        tvResultado.setText(String.format("Total: %.2f\nMétodo de pago: %s\nCalificación: %.1f estrellas", total, metodoPago, calificacion));
    }
}
