package com.example.reservasala;

import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import android.widget.*;

import com.example.reservasala.R;


public class reservaSala extends Activity implements View.OnClickListener{
    Button btnReservar;

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservasala);
    }

    @Override
    public void onClick(View v) {
        reservar();
    }

    public void reservar(){
        Spinner sala, equip;
        TextView resultado;

        sala = (Spinner) findViewById(R.id.spiNumsala);
        equip = (Spinner) findViewById(R.id.spiEquip);
        resultado = (TextView) findViewById(R.id.tvResultado);

        resultado.setText(String.valueOf("inserido"));
    }

}
