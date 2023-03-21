package com.example.p_3;

import android.os.Bundle;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

//poner siempre el EXTENDS al crear una nueva clase
public class otraActividad extends AppCompatActivity {
private String valor1;
private int primerNumero;
private EditText valor2;
private int segundoNumero;
private int suma;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        //recibe el String mandado de la actividad 1
        Log.d("recibe", "recibe string valor 1");
        Intent origen = getIntent();
        valor1 = origen.getExtras().getString("Valor1");

        //convertir el string en un valor int
        Log.d("convertir", "convierte string a int del valor 1");
        primerNumero = Integer.parseInt(valor1);

        //pasar ID a variables
        valor2 = (EditText) findViewById(R.id.segundoNumero);

    }


    public void botonSumar_pulsado (View quien){
         Log.d("botón", "hacer suma");

        //coger string del campo de texto y convertirlo en int
        Log.d("convertir2", "conveirte string a int del valor 2");
        segundoNumero = Integer.parseInt(String.valueOf(valor2.getText()));

        //sumar los int
        suma = primerNumero + segundoNumero;

        //al volver a pasarlo usar vlueOf para hacer una string de la suma
        Intent resultadoIntent = new Intent();
        resultadoIntent.putExtra("suma", "String.valueOf(suma)");
        setResult(RESULT_OK, resultadoIntent);
        finish();
    }


}
