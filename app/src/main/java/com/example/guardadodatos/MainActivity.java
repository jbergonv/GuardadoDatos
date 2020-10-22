package com.example.guardadodatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity implements DialogHora.CuandoEsteSeleccionadaLaHora {

    Button guardar,cargar,borrar,hora;
    EditText nombre,edad;
    TextView textoHora;
    Switch selector;
    static final String NOMBRE_FICHERO="DATOS";
    static final String NOMBRE = "NOMBRE";
    static final String EDAD = "EDAD";
    static final String SWITCH = "SWITCH";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guardar = findViewById(R.id.buttonGuardar);
        cargar = findViewById(R.id.buttonCargar);
        nombre = findViewById(R.id.editTextTextNombre);
        edad = findViewById(R.id.editTextEdad);
        borrar = findViewById(R.id.buttonBorrar);
        selector = findViewById(R.id.switch1);
        hora = findViewById(R.id.buttonHora);
        textoHora = findViewById(R.id.textViewHora);

            guardar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    SharedPreferences misPreferencias = getSharedPreferences(NOMBRE_FICHERO,MODE_PRIVATE);

                        SharedPreferences.Editor editor = misPreferencias.edit();
                        editor.putString(NOMBRE,nombre.getText().toString());
                        editor.putInt(EDAD,Integer.parseInt(edad.getText().toString()));
                        editor.putBoolean(SWITCH,selector.isChecked());
                        editor.apply();



                }
            });

            cargar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    SharedPreferences misPreferencias = getSharedPreferences(NOMBRE_FICHERO,MODE_PRIVATE);
                    nombre.setText(misPreferencias.getString(NOMBRE,"-Sin nombre"));
                    edad.setText(""+misPreferencias.getInt(EDAD,0));
                    selector.setChecked(misPreferencias.getBoolean(SWITCH,false));


                }
            });

            borrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    SharedPreferences misPreferencias = getSharedPreferences(NOMBRE_FICHERO,MODE_PRIVATE);
                    misPreferencias.edit().clear().apply();

                }
            });


            hora.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    DialogHora dialogHora = new DialogHora();

                    dialogHora.show(getSupportFragmentManager(),"Mi ventana de hora");


                }
            });

    }

    @Override
    public void miSeleccion(GregorianCalendar hora) {

        textoHora.setText(hora.get(GregorianCalendar.HOUR)+":"+hora.get(GregorianCalendar.MINUTE));

    }
}