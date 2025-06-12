package com.vitor.bankapp.Db;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class RegisterDB extends SQLiteOpenHelper implements BaseColumns {

    public static final String DB_NAME = "Users";
    public static final String TABLE = "UserData";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String PHONE = "phone";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final int VERSION = 3;

    public RegisterDB(Context context){
        super(context, DB_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String criarDB = "CREATE TABLE " + RegisterDB.TABLE + " ( "
                + RegisterDB.ID + " INTEGER PRIMARY KEY, " +
                RegisterDB.NAME + " text, " +
                RegisterDB.PHONE + " text, " +
                RegisterDB.EMAIL + " text, " +
                RegisterDB.PASSWORD + " text)";

        sqLiteDatabase.execSQL(criarDB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(sqLiteDatabase);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}

