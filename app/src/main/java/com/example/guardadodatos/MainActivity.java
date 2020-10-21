package com.example.guardadodatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button guardar,cargar,borrar;
    EditText nombre,edad;
    static final String NOMBRE_FICHERO="DATOS";
    static final String NOMBRE = "NOMBRE";
    static final String EDAD = "EDAD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guardar = findViewById(R.id.buttonGuardar);
        cargar = findViewById(R.id.buttonCargar);
        nombre = findViewById(R.id.editTextTextNombre);
        edad = findViewById(R.id.editTextEdad);
        borrar = findViewById(R.id.buttonBorrar);

            guardar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    SharedPreferences misPreferencias = getSharedPreferences(NOMBRE_FICHERO,MODE_PRIVATE);

                        SharedPreferences.Editor editor = misPreferencias.edit();
                        editor.putString(NOMBRE,nombre.getText().toString());
                        editor.putInt(EDAD,Integer.parseInt(edad.getText().toString()));
                        editor.apply();



                }
            });

            cargar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    SharedPreferences misPreferencias = getSharedPreferences(NOMBRE_FICHERO,MODE_PRIVATE);
                    nombre.setText(misPreferencias.getString(NOMBRE,"-Sin nombre"));
                    edad.setText(""+misPreferencias.getInt(EDAD,0));


                }
            });

            borrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    SharedPreferences misPreferencias = getSharedPreferences(NOMBRE_FICHERO,MODE_PRIVATE);
                    misPreferencias.edit().clear().apply();

                }
            });

    }
}