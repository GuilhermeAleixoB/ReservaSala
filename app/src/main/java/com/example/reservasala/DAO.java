package com.example.reservasala;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DAO extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "ReservaSala.db";
    private static final String TABELA1 = "Sala";
    private static final String ID = "_id";
    private static final String NSALA = "nSala";
    private static final String INFOSALA = "infoSala";
    private static final String TABELA2 = "Equipamento";
    private static final String IDEQUIP = "_idEquip";
    private static final String EQUIP = "equip";
    private static final String INFOEQUIP = "InfoEquip";
    private static final String TABELA3 = "EquipSala";
    private static final String IDEQUIPSALA = "_idEquipsala";
    private static final String TABELA4 = "Reserva";
    private static final String IDRESERVA = "_idReserva";
    private static final String NOME = "nome";
    private static final String DATA = "data";
    private static final String TABELA5 = "Login";
    private static final String IDLOGIN = "_idLogin";
    private static final String LNOME = "Lnome";
    private static final String LOGIN = "login";
    private static final String SENHA = "senha";
    private static final int VERSAO = 9;

    public DAO(Context context) {
        super(context, getNomeBanco(), null, getVERSAO());
    }

    public static String getNomeBanco() {
        return NOME_BANCO;
    }

    public static String getTABELA1() {
        return TABELA1;
    }

    public static String getID() {
        return ID;
    }

    public static String getNSALA() {
        return NSALA;
    }

    public static String getINFOSALA() {
        return INFOSALA;
    }

    public static String getTABELA2() {
        return TABELA2;
    }

    public static String getIDEQUIP() {
        return IDEQUIP;
    }

    public static String getEQUIP() {
        return EQUIP;
    }

    public static String getINFOEQUIP() {
        return INFOEQUIP;
    }

    public static String getTABELA3() {
        return TABELA3;
    }

    public static String getTABELA4() {
        return TABELA4;
    }

    public static String getNOME() {
        return NOME;
    }

    public static String getDATA() {
        return DATA;
    }

    public static int getVERSAO() {
        return VERSAO;
    }


    SQLiteDatabase db;
    DAO banco;

    public static String getIDEQUIPSALA() {
        return IDEQUIPSALA;
    }

    public static String getSENHA() {
        return SENHA;
    }

    public static String getTABELA5() {
        return TABELA5;
    }

    public static String getIDLOGIN() {
        return IDLOGIN;
    }

    public static String getLNOME() {
        return LNOME;
    }

    public static String getLOGIN() {
        return LOGIN;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+ getTABELA1() +"("
            + getID() + " integer primary key autoincrement,"
            + getNSALA() + " text,"
            + getINFOSALA() + " text"
            +")";
        db.execSQL(sql);

        String sql1 = "CREATE TABLE "+ getTABELA2() +"("
                + getID() + " integer primary key autoincrement,"
                + getEQUIP() + " text,"
                + getINFOEQUIP() + " text"
                +")";
        db.execSQL(sql1);

        String sql2 = "CREATE TABLE "+ getTABELA3() +"("
                + getID() + " integer primary key autoincrement,"
                + getNSALA() + " text,"
                + getEQUIP() + " text"
                + ")";
        db.execSQL(sql2);

        String sql3 = "CREATE TABLE "+ getTABELA4() +"("
                + getID() + " integer primary key autoincrement,"
                + getNOME() + " text,"
                + getDATA() + " text,"
                + getNSALA() + " text"
                +")";
        db.execSQL(sql3);


        String sql4 = "CREATE TABLE "+ getTABELA5() +"("
                + getIDLOGIN() + " integer primary key autoincrement,"
                + getLNOME() + " text,"
                + getLOGIN() + " text,"
                + getSENHA() + " text"
                +")";
        db.execSQL(sql4);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Sala");
        db.execSQL("DROP TABLE IF EXISTS Equipamento");
        db.execSQL("DROP TABLE IF EXISTS EquipSala");
        db.execSQL("DROP TABLE IF EXISTS Reserva");
        db.execSQL("DROP TABLE IF EXISTS Login");
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public Cursor getSalas() {
        try {
            String selectQuery = "SELECT * FROM Sala";
            SQLiteDatabase database = this.getWritableDatabase();
            Cursor cursor = database.rawQuery(selectQuery, null);
            return cursor;
        } catch (Exception ex) {
            return null;
        }
    }

    public Cursor getEquip() {
        try {
            String selectQuery = "SELECT * FROM Equipamento";
            SQLiteDatabase database = this.getWritableDatabase();
            Cursor cursor = database.rawQuery(selectQuery, null);
            return cursor;
        } catch (Exception ex) {
            return null;
        }
    }

    public Cursor getEquipSala() {
        try {
            String selectQuery = "SELECT * FROM EquipSala";
            SQLiteDatabase database = this.getWritableDatabase();
            Cursor cursor = database.rawQuery(selectQuery, null);
            return cursor;
        } catch (Exception ex) {
            return null;
        }
    }

    public Cursor getReserva() {
        try {
            String selectQuery = "SELECT * FROM Reserva";
            SQLiteDatabase database = this.getWritableDatabase();
            Cursor cursor = database.rawQuery(selectQuery, null);
            return cursor;
        } catch (Exception ex) {
            return null;
        }
    }

    public int deletarSala(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(getTABELA1(), "_id = ?", new String[] {id});
    }

    public int deletarEquip(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(getTABELA2(), "_id = ?", new String[] {id});
    }

    public int deletarEquipSala(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(getTABELA3(), "_id = ?", new String[] {id});
    }

    public int deletarReserva(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(getTABELA4(), "_id = ?", new String[] {id});
    }

    public Usuario findByLogin(String login, String senha) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql0 = "SELECT * FROM " + getTABELA5() + " WHERE " + getLOGIN() +" = ? and " + getSENHA() +" = ?";
        String[] selectionArgs = new String[] {login, senha};
        Cursor cursor = db.rawQuery(sql0, selectionArgs);
        cursor.moveToFirst();

        return montaUsuario(cursor);
    }

    public Usuario montaUsuario(Cursor cursor) {
        if (cursor.getCount() == 0){
            return null;
        }
        Integer id = cursor.getInt(cursor.getColumnIndex("_idLogin"));
        String nome = cursor.getString(cursor.getColumnIndex("Lnome"));
        String login = cursor.getString(cursor.getColumnIndex("login"));
        String senha = cursor.getString(cursor.getColumnIndex("senha"));

        return new Usuario(id, nome, login, senha);
    }

    public boolean findBySala(String sala) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql0 = "SELECT * FROM " + getTABELA1() + " WHERE nSala = ?";
        String[] selectionArgs = new String[] {sala};
        Cursor cursor = db.rawQuery(sql0, selectionArgs);
        cursor.moveToFirst();

        if (cursor.getCount() == 0){
            return false;
        }

        String cursorSala = cursor.getString(cursor.getColumnIndex("nSala"));
        if (cursorSala.equals(sala)){
            return true;
        }else{
            return false;
        }

    }

    public boolean findByEquip(String equip) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql0 = "SELECT * FROM " + getTABELA2() + " WHERE equip = ?";
        String[] selectionArgs = new String[] {equip};
        Cursor cursor = db.rawQuery(sql0, selectionArgs);
        cursor.moveToFirst();

        if (cursor.getCount() == 0){
            return false;
        }

        String cursorEquip = cursor.getString(cursor.getColumnIndex("equip"));
        if (cursorEquip.equals(equip)){
            return true;
        }else{
            return false;
        }

    }


    public boolean findByData(String sala, String data) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql0 = "SELECT * FROM " + getTABELA4() + " WHERE nSala = ? AND data = ?";
        String[] selectionArgs = new String[] {sala, data};
        Cursor cursor = db.rawQuery(sql0, selectionArgs);
        cursor.moveToFirst();

        if (cursor.getCount() == 0){
            return true;
        }else{
            return false;
        }

    }

    public boolean findSala(String sala) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql0 = "SELECT * FROM " + getTABELA1() + " WHERE nSala = ?";
        String[] selectionArgs = new String[] {sala};
        Cursor cursor = db.rawQuery(sql0, selectionArgs);
        cursor.moveToFirst();

        if (cursor.getCount() == 0){
            return true;
        }else{
            return false;
        }

    }

    public boolean findEquip(String equip) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql0 = "SELECT * FROM " + getTABELA2() + " WHERE equip = ?";
        String[] selectionArgs = new String[] {equip};
        Cursor cursor = db.rawQuery(sql0, selectionArgs);
        cursor.moveToFirst();

        if (cursor.getCount() == 0){
            return true;
        }else{
            return false;
        }

    }

    public boolean findBySalaEquip(String sala, String equip) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql0 = "SELECT * FROM " + getTABELA3() + " WHERE nSala = ? AND equip = ?";
        String[] selectionArgs = new String[] {sala, equip};
        Cursor cursor = db.rawQuery(sql0, selectionArgs);
        cursor.moveToFirst();

        if (cursor.getCount() == 0){
            return true;
        }else{
            return false;
        }

    }


}
