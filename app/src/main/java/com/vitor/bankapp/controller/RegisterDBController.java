
package com.vitor.bankapp.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.vitor.bankapp.Db.RegisterDB;
import com.vitor.bankapp.authentication.Login;

public class RegisterDBController {
    private SQLiteDatabase db;
    private RegisterDB register;

    public RegisterDBController(Context context) {
        register = new RegisterDB(context);
    }

    public void insert(String name, String phone, String email, String password) {
        ContentValues data;

        db = register.getWritableDatabase();
        data = new ContentValues();
        data.put(RegisterDB.NAME, name);
        data.put(RegisterDB.PHONE, phone);
        data.put(RegisterDB.EMAIL, email);
        data.put(RegisterDB.PASSWORD, password);

        db.insert(RegisterDB.TABLE, null, data);

    }

    public boolean loginRegister(Login login) {
        db = register.getReadableDatabase();

        String query = "SELECT * FROM " + RegisterDB.TABLE +
                " WHERE " + RegisterDB.EMAIL + " = ?" +
                " AND " + RegisterDB.PASSWORD + " = ?";

        String[] args = {login.getEmail(), login.getPassword()};

        Cursor cursor = db.rawQuery(query, args);

        boolean loginValido = cursor.getCount() > 0;

        cursor.close();
        db.close();

        return loginValido;
    }
}
