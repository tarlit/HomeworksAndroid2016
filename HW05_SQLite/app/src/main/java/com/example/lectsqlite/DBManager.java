package com.example.lectsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Random;


public class DBManager extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "contactsdb";

    public static final String TABLE_CONTACTS = "Contacts";
    // columns
    public static final String ID_KEY = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";

    ArrayList<Contacts> contactsList;

    public DBManager(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String create_table_contacts =
                "create table " + TABLE_CONTACTS +
                "(id integer primary key autoincrement, " +
                KEY_NAME + " text, " +
                KEY_EMAIL + " text)";

        db.execSQL(create_table_contacts);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("drop table if exists " + TABLE_CONTACTS);
        //onCreate(db);
    }

    void add60Contacts() {

        Random rnd = new Random();
        SQLiteDatabase currentDB = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        for (int i = 0; i < 30; i++) {
            values.put(KEY_NAME, "Name#" + rnd.nextInt(10000));
            values.put(KEY_EMAIL, "name" + rnd.nextInt(10000) + "@abv.bg");

            currentDB.insert(TABLE_CONTACTS, null, values);
        }

        currentDB.close();
    }

    ArrayList<Contacts> getAllContacts() {

        SQLiteDatabase currentDB = this.getWritableDatabase();
        contactsList = new ArrayList<>();

        String rawQuery = "select * from " + TABLE_CONTACTS;

        Cursor allItemsCursor = currentDB.rawQuery(rawQuery, null);

        if (allItemsCursor != null) {
            while(allItemsCursor.moveToNext()) {
                Contacts currentContact = new Contacts(Integer.parseInt(allItemsCursor.getString(0)), allItemsCursor.getString(1), allItemsCursor.getString(2));

                contactsList.add(currentContact);
            }
        }

        allItemsCursor.close();
        currentDB.close();
        return contactsList;
    }
}
