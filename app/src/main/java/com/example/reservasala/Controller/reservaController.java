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
        valores.put(DAO.getIDSALA(), sala);

        resultado = db.insert(DAO.getTABELA4(), null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao reservar sala";
        else
            return "Sala reservada";

    }


}