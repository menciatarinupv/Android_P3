package com.example.p_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private TextView resultado;
    private static int LA_OTRA_ACTIVIDAD_ID = 13;
    TextView textoResultado = (TextView) findViewById(R.id.resultado);
    EditText primerNumero = (EditText) findViewById(R.id.primerNumero);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("onCreate", "estoy en onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void botonLlamada_pulsado (View quien){
            Log.d("botón", "Botón pulsado");

            Intent intencion = new Intent(this, otraActividad.class);
            super.startActivity(intencion);

            //convierte los datos en String para pasarlos porque en la otra actividad
            // recibe con un getString
            intencion.putExtra("Valor1", "String.valueOf(primerNumero.getText())");
        }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intentRespuesta) {
        // si acaba la "otra" actividad
        super.onActivityResult(requestCode, resultCode, intentRespuesta);
        if (requestCode == 1234) {
            String respuesta = intentRespuesta.getExtras().getString("suma");
            this.textoResultado.setText("la suma es " + respuesta);
        }
    }

}
