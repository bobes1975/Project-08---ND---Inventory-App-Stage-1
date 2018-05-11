package com.example.android.inventoryapp1stage.data;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

import com.example.android.inventoryapp1stage.data.DatabaseContract.GameEntry;


/**
 * Database helper for PC Games database app. Manages database creation and version management.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    // Name of the database file */
    public static final String DATABASE_NAME = "pcgames.db";

    // Database version. If you change the database schema, you have to increment the database version.

    public static final int DATABASE_VERSION = 1;

    /**
     * Constructs a new instance of {@link DatabaseHelper}.
     *
     * @param context of the app
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_GAMES_TABLE = "CREATE TABLE " + GameEntry.TABLE_NAME + " ("
                + GameEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + GameEntry.COLUMN_NAME + " TEXT NOT NULL, "
                + GameEntry.COLUMN_CATEGORY + " TEXT NOT NULL, "
                + GameEntry.COLUMN_QUANTITY +" INTEGER NOT NULL DEFAULT 0, "
                + GameEntry.COLUMN_PRICE + " INTEGER NOT NULL DEFAULT 0, "
                + GameEntry.COLUMN_SUPPLIER  + " TEXT NOT NULL, "
                + GameEntry.COLUMN_SUPPLIER_PHONE + " INTEGER NOT NULL DEFAULT 0);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_GAMES_TABLE);
    }

    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
