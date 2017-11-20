package com.example.admin.actividad3a;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.admin.actividad3a.MainActivity.PREFS;

public class SegundaVentana extends AppCompatActivity {

    private TextView tvNombre, tvDni, tvFecha;
    private TextView tvSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segon_finestra);

        tvNombre = (TextView)findViewById(R.id.textMuestraNombre);
        tvDni = (TextView)findViewById(R.id.textMuestraDNI);
        tvFecha = (TextView)findViewById(R.id.textMuestraFecha);
        tvSexo = (TextView) findViewById(R.id.textMuestraSexo);

        SharedPreferences sp = getSharedPreferences(PREFS,MODE_PRIVATE);
        String nombre = sp.getString("nombre","");
        String dni = sp.getString("dni","");
        String fecha = sp.getString("fecha","");
        String sexo = sp.getString("sexo","");

        tvNombre.setText(nombre);
        tvDni.setText(dni);
        tvFecha.setText(fecha);
        tvSexo.setText(sexo);


    }
}
