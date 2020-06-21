package com.example.reservasala.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.reservasala.DAO;

public class reservaController {

    private SQLiteDatabase db;
    private DAO banco;

    public reservaController(Context context){
        banco = new DAO(context);
    }

    public String insereDado(String nome, String data, String sala){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(DAO.getNOME(), nome);
        valores.put(DAO.getDATA(), data);
        valores.put(DAO.getNSALA(), sala);

        boolean isValid1 = banco.findBySala(sala);
        boolean isValid2 = banco.findByData(sala, data);

        if (isValid1 && isValid2) {
            resultado = db.insert(DAO.getTABELA4(), null, valores);
            db.close();

            if (resultado == -1)
                return "Erro ao reservar sala!";
            else
                return "Sala reservada!";

        }else if (!isValid1){
            return "Sala não existe!";
        }else{
            return "Sala já reservada para esse dia!";
        }

    }


}