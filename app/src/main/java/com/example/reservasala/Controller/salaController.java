package com.example.reservasala.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.reservasala.DAO;

public class salaController {

    private SQLiteDatabase db;
    private DAO banco;

    public salaController(Context context){
        banco = new DAO(context);
    }

    public String insereDado(String nSala, String infoSala){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(DAO.getNSALA(), nSala);
        valores.put(DAO.getINFOSALA(), infoSala);

        boolean isValid = banco.findSala(nSala);

        if (isValid) {
            resultado = db.insert(DAO.getTABELA1(), null, valores);
            db.close();

            if (resultado == -1)
                return "Erro ao inserir registro!";
            else
                return "Registro inserido com sucesso!";

        }else{
            return "Sala já cadastrada!";
        }
    }


}
