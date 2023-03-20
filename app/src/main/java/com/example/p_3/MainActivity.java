package com.example.p_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView resultado;
    private static int LA_OTRA_ACTIVIDAD_ID = 13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textoResultado = (TextView) findViewById(R.id.resultado);
    }

        public void botonLlamada_pulsado (View quien){
            Intent intencion = new Intent(this, otraActividad.class);
            super.startActivity(intencion);
        }

}
