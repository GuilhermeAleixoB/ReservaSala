package com.example.reservasala.Controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.reservasala.DAO;
import com.example.reservasala.Usuario;
import com.example.reservasala.login;

public class loginController {

    private SQLiteDatabase db;
    private static DAO banco;
    private static loginController instance;

    public static loginController getInstance(Context context){
        if (instance == null){
            instance = new loginController();
            banco = new DAO(context);
        }
        return instance;
    }

    public boolean validaLogin (String login, String senha) throws Exception{
        Usuario user = banco.findByLogin(login, senha);
        if (user == null || user.getLogin() == null || user.getSenha() == null) {
            return false;
        }

        String informado = login + senha;
        String esperado = user.getLogin() + user.getSenha();

        if (informado.equals(esperado)){
            return true;
        }
        return false;
    }

}
