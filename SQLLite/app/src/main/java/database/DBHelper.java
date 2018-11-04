package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static  String DATABASE_NAME = "SQLite_text";
    public static final String TABLE_NAME = "studenbs";
    public static final String CULMN_ID = "id";
    public static final String CULMN_NAME = "name";
    public static final String CULMN_EMAIL = "email";
    public static final String CULMN_PHONE = "phone";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +"("+CULMN_ID+" INTEGER PRIMARY KEY, " + CULMN_NAME + " VARCHAR, " + CULMN_EMAIL + " VARCHAR, "+CULMN_PHONE+" VARCHAR)";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
