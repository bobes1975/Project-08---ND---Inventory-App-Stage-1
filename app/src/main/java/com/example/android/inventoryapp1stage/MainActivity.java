package com.example.android.inventoryapp1stage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.example.android.inventoryapp1stage.data.DatabaseContract.GameEntry;
import com.example.android.inventoryapp1stage.data.DatabaseHelper;

import java.lang.reflect.GenericArrayType;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = "Cursor Log";

    private DatabaseHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper = new DatabaseHelper(this);

        insertRecord();
        readFromDatabase();
    }

    // Create and/or open a database to read from it
    private void readFromDatabase() {

        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        //read all column from database, in 2nd Stage can be rewrite for
        String [] project = {
                GameEntry._ID,
                GameEntry.COLUMN_NAME,
                GameEntry.COLUMN_CATEGORY,
                GameEntry.COLUMN_QUANTITY,
                GameEntry.COLUMN_PRICE,
                GameEntry.COLUMN_SUPPLIER,
                GameEntry.COLUMN_SUPPLIER_PHONE
        };

        //Define "where" part of query
        String selection = GameEntry._ID + "=?";

        //Specify arguments in placeholder order, for now is line No. 1.
        //This part of code will be rewrite in 2nd Stage

         String [] selectionArg = {"1"} ;

        Cursor cursor = db.query(
                GameEntry.TABLE_NAME,
                project,
                selection,
                selectionArg,
                null,
                null,
                null);

        //here will be code for displaying information from cursor (2nd Stage)

        //control if cursor works properly, this part will be remove in final app
        cursor.moveToNext();
        int nameColumnIndex = cursor.getColumnIndex(GameEntry.COLUMN_NAME);
        String cursorString = cursor.getString(nameColumnIndex);
        Log.i(LOG_TAG, cursorString );

        cursor.close();
}

    // Insert a record
    private void insertRecord (){

        //Here will be code for getting information from EditLayout (2nd Stage)

        String nameString = "Diablo";
        String categoryString = "RPG";
        int quantityValue = 1;
        int priceValue = 10;
        String supplierString = "Blizzard";
        String supplierPhoneString = "+1 123 456 789";

        //

        //Get a writable database
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        //Create a ContentValues object where column names are the keys and Diablo's game attributes are the values as example
        //In 2nd Stage will be replace with real inputs from EditLayout (2nd Stage)

        ContentValues values = new ContentValues();
        values.put(GameEntry.COLUMN_NAME, nameString);
        values.put(GameEntry.COLUMN_CATEGORY, categoryString);
        values.put(GameEntry.COLUMN_QUANTITY, quantityValue);
        values.put(GameEntry.COLUMN_PRICE, priceValue);
        values.put(GameEntry.COLUMN_SUPPLIER, supplierString);
        values.put(GameEntry.COLUMN_SUPPLIER_PHONE,supplierPhoneString );



        //Insert a new row for in the database,returning the ID of that new row.
        //The first argument for db.insert() is the table name.
        //The second argument provides the name of column in which the framework can insert NULL in the event that ContentValues is empty
        //(if this is set "null", then the framework will not insert a row when there are no values.
        //The third argument is the ContentValues object containing info for new game.

        long newRowId = db.insert(GameEntry.TABLE_NAME, null, values);
    }}

