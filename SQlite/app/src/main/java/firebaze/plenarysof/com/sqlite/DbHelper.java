package firebaze.plenarysof.com.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper{

    private static final int dbversion = 1;
    private static final String dbname="Blood_db";

    public static final String TABLE_NAME = "donate_blood";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DONAR_NAME = "donar_name";
    public static final String COLUMN_DONAR_EMAIL = "donar_email";
    public static final String COLUMN_DONAR_NUMBER = "donar_number";
    public static final String COLUMN_DONAR_BL_GROUP = "donar_bl_group";
    public static final String COLUMN_DONAR_DATE = "donar_date";

    private static final String CREATE_DONAL_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_DONAR_NAME + " TEXT,"
            + COLUMN_DONAR_EMAIL + " TEXT,"
            + COLUMN_DONAR_NUMBER + " TEXT,"
            + COLUMN_DONAR_BL_GROUP + "VARCHAR(45),"
            + COLUMN_DONAR_DATE + "DATEIME"
            +")";

    private static DbHelper dbHelper = null;

    public static DbHelper getInstance(Context context) {
        if(dbHelper == null) {
            dbHelper =  new DbHelper(context);
        }
        return dbHelper;
    }


    public DbHelper(Context context) {
        super(context, dbname, null, dbversion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_DONAL_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CREATE_DONAL_TABLE);
        onCreate(sqLiteDatabase);

    }
}
