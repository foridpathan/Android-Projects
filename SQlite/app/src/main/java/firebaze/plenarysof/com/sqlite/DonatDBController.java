package firebaze.plenarysof.com.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;

public class DonatDBController {
    private DbHelper dbHelper;
    private Context dContext;
    private SQLiteDatabase sqLiteDatabase;


    public DonatDBController (Context context) {
        dContext = context;
    }

    public DonatDBController open() throws SQLException {
        dbHelper = new DbHelper(dContext);
        sqLiteDatabase = dbHelper.getWritableDatabase();
        return  this;
    }

    public void close() {
        dbHelper.close();
    }

    public long insertDonar(String name, String email, String number, String blood_group, String date) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.COLUMN_DONAR_NAME, name);
        contentValues.put(DbHelper.COLUMN_DONAR_EMAIL, email);
        contentValues.put(DbHelper.COLUMN_DONAR_NUMBER, number);
        contentValues.put(DbHelper.COLUMN_DONAR_BL_GROUP, blood_group);
        contentValues.put(DbHelper.COLUMN_DONAR_DATE, date);

        return sqLiteDatabase.insert(DbHelper.TABLE_NAME, null, contentValues);
    }

    public ArrayList<Donar> getAll() {
        ArrayList<Donar> donateList = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + DbHelper.TABLE_NAME, null);
        if (cursor != null && cursor.getCount() > 0) {
            try {
                cursor.moveToFirst();
                while (cursor.isAfterLast() == false) {
                    int programId = cursor.getInt(cursor.getColumnIndex(DbHelper.COLUMN_ID));
                    String programName = cursor.getString(cursor.getColumnIndex(DbHelper.COLUMN_DONAR_NAME));
                    String programHostName = cursor.getString(cursor.getColumnIndex(DbHelper.COLUMN_DONAR_EMAIL));
                    String programStartTime = cursor.getString(cursor.getColumnIndex(DbHelper.COLUMN_DONAR_NUMBER));
                    String programEndTime = cursor.getString(cursor.getColumnIndex(DbHelper.COLUMN_DONAR_BL_GROUP));
                    String programDuration = cursor.getString(cursor.getColumnIndex(DbHelper.COLUMN_DONAR_DATE));

                    donateList.add(new Donar(programId, programName, programHostName, programStartTime, programEndTime, programDuration));

                    cursor.moveToNext();
                }
            } catch (Exception ex) {
            }
        }
        return donateList;
    }

}
