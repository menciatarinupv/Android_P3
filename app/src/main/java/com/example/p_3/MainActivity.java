package com.example.p_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private TextView textoResultado;
    private EditText primerNumero;
    private static int LA_OTRA_ACTIVIDAD_ID = 13;
    private String StringPrimerNumero;
    private Intent mandarprimero;
    private Intent intencion;
    private String respuesta;
    private Intent empieza_SEGUNDA;
    private Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("onCreate", "estoy en onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoResultado = (TextView) findViewById(R.id.resultado);
        primerNumero = (EditText) findViewById(R.id.primerNumero);
    }

    public void botonLlamada_pulsado (View quien){
        Log.d("botón", "Botón pulsado");

        //intent `para empezar la otra actividad
        mandarprimero = new Intent(this, otraActividad.class);

        //convierte los datos en String para pasarlos porque en la otra actividad
        // recibe con un getString y lo añade a la intención
        StringPrimerNumero = String.valueOf(primerNumero.getText());
        Log.d("aaaa", "StringPrimerNumero");
        mandarprimero.putExtra("Valor1", StringPrimerNumero);
        //empieza la actividad
        this.startActivityForResult(mandarprimero, 1234);

        }
        public void boton_siguiente2 (View quien){
            Log.d("botón2", "Botón2 pulsado");
            i = new Intent("empieza.SEGUNDA");

            StringPrimerNumero = String.valueOf(primerNumero.getText());
            Log.d("aaaa", "StringPrimerNumero");
            i.putExtra("Valor1", StringPrimerNumero);

            // o también: i.setAction(“jordi.PRUEBA”);
            this.startActivityForResult(i,1234);
        }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intentRespuesta) {
        // si acaba la "otra" actividad
        super.onActivityResult(requestCode, resultCode, intentRespuesta);
        if (requestCode == 1234) {
            respuesta = intentRespuesta.getExtras().getString("suma");
            this.textoResultado.setText("la suma es " + respuesta);
        }
    }

    public void compartir (View quien){
        Intent enviar = new Intent(Intent.ACTION_SEND);
        enviar.setType("text/plain");
        enviar.putExtra(Intent.EXTRA_TEXT, respuesta);
        startActivity(Intent.createChooser(enviar, "Compartir resultado con:"));
    }

}
