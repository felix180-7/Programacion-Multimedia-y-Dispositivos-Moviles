package com.cuentabar.example;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
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
    private AutoCompleteTextView etNombreCamarero;
    private CheckBox cbPropina;
    private SeekBar sbPropina;
    private TextView tvPorcentajePropina;
    private RadioGroup radioGroupMetodoPago;
    private RadioButton rbEfectivo, rbTarjeta;
    private RatingBar ratingBarServicio;
    private Button btnCalcularTotal;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar vistas con los ids del layout XML
        etTotalCuenta = findViewById(R.id.etTotalCuenta);
        etNombreCamarero = findViewById(R.id.etNombreCamarero);
        cbPropina = findViewById(R.id.cbPropina);
        sbPropina = findViewById(R.id.sbPropina);
        tvPorcentajePropina = findViewById(R.id.tvPorcentajePropina);
        radioGroupMetodoPago = findViewById(R.id.radioGroupMetodoPago);
        rbEfectivo = findViewById(R.id.rbEfectivo);
        rbTarjeta = findViewById(R.id.rbTarjeta);
        ratingBarServicio = findViewById(R.id.ratingBarServicio);
        btnCalcularTotal = findViewById(R.id.btnCalcularTotal);
        tvResultado = findViewById(R.id.tvResultado);

        // Configurar el AutoCompleteTextView con las sugerencias de nombres de camareros
        String[] camareros = {"Marta", "Marcos", "Maria", "Miguel", "Martín", "Margarita"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, camareros);
        etNombreCamarero.setAdapter(adapter);

        // Preseleccionar "Efectivo" como método de pago
        rbEfectivo.setChecked(true); // Aseguramos que "Efectivo" esté marcado por defecto

        // Configuración inicial de SeekBar
        sbPropina.setProgress(10); // El valor inicial de la propina es 10%

        // Actualizar el porcentaje de la propina en el TextView
        sbPropina.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvPorcentajePropina.setText("Porcentaje de la propina: " + progress + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        // Acción del botón Calcular Total
        btnCalcularTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularTotal();
            }
        });
    }

    // Método para calcular el total de la cuenta con propina
    private void calcularTotal() {
        // Obtener el nombre del camarero
        String nombreCamarero = etNombreCamarero.getText().toString();

        // Obtener el total de la cuenta ingresado por el usuario
        String totalCuentaStr = etTotalCuenta.getText().toString();
        if (totalCuentaStr.isEmpty()) {
            tvResultado.setText("¡Por favor ingrese el total de la cuenta!");
            tvResultado.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            return;
        }

        // Convertir a número el total ingresado
        double totalCuenta = Double.parseDouble(totalCuentaStr);
        if (totalCuenta <= 0) {
            tvResultado.setText("El total de la cuenta debe ser mayor a 0");
            tvResultado.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            return;
        }

        // Obtener el porcentaje de la propina
        double porcentajePropina = sbPropina.getProgress();
        double propina = (porcentajePropina / 100) * totalCuenta;

        // Verificar si se seleccionó la opción de incluir propina
        if (!cbPropina.isChecked()) {
            propina = 0;
        }

        // Obtener el método de pago seleccionado
        String metodoPago = "";
        int selectedId = radioGroupMetodoPago.getCheckedRadioButtonId();
        if (selectedId == rbEfectivo.getId()) {
            metodoPago = "Efectivo";
        } else if (selectedId == rbTarjeta.getId()) {
            metodoPago = "Tarjeta";
        }

        // Obtener la calificación del servicio
        float calificacionServicio = ratingBarServicio.getRating();

        // Calcular el total final con propina
        double totalConPropina = totalCuenta + propina;

        // Mostrar resultado
        String resultado = "Atendido por: " + nombreCamarero + "\n";
        resultado += "Total de la cuenta: " + totalCuenta + "\n";
        resultado += "Propina: " + propina + "\n";
        resultado += "Método de pago: " + metodoPago + "\n";
        resultado += "Calificación del servicio: " + calificacionServicio + " estrellas\n";
        resultado += "Total con propina: " + totalConPropina;

        tvResultado.setText(resultado);
    }
}
