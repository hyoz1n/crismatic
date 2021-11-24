package com.example.crismatic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import Clases.Insumos;

public class Insumos_act extends AppCompatActivity {

    private Spinner insumos;
    private TextView resultado;
    private RatingBar calificar;
    private Insumos in = new Insumos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos);

        insumos = findViewById(R.id.spnInsumos);
        resultado = findViewById(R.id.result);
        calificar = findViewById(R.id.rB);

        Bundle bun = getIntent().getExtras();
        String[] listado = bun.getStringArray("insumos");

        ArrayAdapter adaptInsumos = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listado);
        insumos.setAdapter(adaptInsumos);
    }

    public void Calcular(View view)
    {
        String opcion = insumos.getSelectedItem().toString();
        int result = 0;

        for(int i = 0; i < opcion.length(); i++)
        {
            if(opcion.equals(in.getInsumos()[i]))
            {
                //result = in.getPrecios()[i];
                result = in.anadirAdicional(in.getPrecios()[i], 350);
                calificar.setRating(i+1);
                break;
            }

        }
        resultado.setText("La opción seleccionada es: " + opcion + "\n su precio es: " + result);
    }
}