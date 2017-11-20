package com.example.admin.actividad3a;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;


public class MainActivity extends AppCompatActivity {

    public static final String PREFS="Preferences";
    private Button b;
    private EditText nombre, dni, fecha;
    private RadioButton sexoHombre, sexoMujer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (Button)findViewById(R.id.boton);

        nombre = (EditText)findViewById(R.id.editNombre);
        dni = (EditText)findViewById(R.id.editDNI);
        fecha = (EditText)findViewById(R.id.editFecha);
        sexoHombre = (RadioButton)findViewById(R.id.sexoHombre);
        sexoMujer = (RadioButton)findViewById(R.id.sexoMujer);

        b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // Creamos o recuperamos el objeto de preferencias compartidas
                SharedPreferences sp = getSharedPreferences(PREFS,MainActivity.MODE_PRIVATE);

                //Obtenemos un editor para modificar las preferencias
                SharedPreferences.Editor editor = sp.edit();

                //Guardamos nuevos valores
                editor.putString("nombre",nombre.getText().toString());
                editor.putString("dni",dni.getText().toString());
                editor.putString("fecha",fecha.getText().toString());

                if (sexoHombre.isChecked()) {
                    editor.putString("sexo", "Hombre");
                } else if (sexoMujer.isChecked()){
                    editor.putString("sexo","Mujer");
                }

                editor.commit();

                Intent i = new Intent(MainActivity.this,SegundaVentana.class);
                startActivity(i);
            }
        });
    }
}
