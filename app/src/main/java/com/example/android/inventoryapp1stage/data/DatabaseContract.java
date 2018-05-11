package com.example.android.inventoryapp1stage.data;

import android.provider.BaseColumns;

public final class DatabaseContract {

     private DatabaseContract (){}

        public static final class GameEntry implements BaseColumns {

         //public static final string for ear row of table that we need to refer - inside and or outside this class
            public final static String TABLE_NAME = "Games";

            public final static String _ID = BaseColumns._ID;
            public final static String COLUMN_NAME = "name";
            public final static String COLUMN_CATEGORY = "category";
            public static final String COLUMN_QUANTITY = "quantity";
            public static final String COLUMN_PRICE = "price";

            public final static String COLUMN_SUPPLIER = "supplier";
            public final static String COLUMN_SUPPLIER_PHONE = "phone";
     };
    }


