package com.example.reservasala.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.reservasala.DAO;

public class cadastroController {


    private SQLiteDatabase db;
    private DAO banco;

    public cadastroController(Context context){
        banco = new DAO(context);
    }

    public String insereDado(String nome, String login, String senha){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(DAO.getLNOME(), nome);
        valores.put(DAO.getLOGIN(), login);
        valores.put(DAO.getSENHA(), senha);

        resultado = db.insert(DAO.getTABELA5(), null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao cadastrar usuario!";
        else
            return "Usuario cadastrado com sucesso!";

    }
}
