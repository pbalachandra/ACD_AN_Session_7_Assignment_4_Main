package com.acadgild.balu.acd_an_session_7_assignment_4_main;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by BALU on 4/20/2016.
 */
public class DBHelper extends SQLiteOpenHelper
{
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "DB_EMPLOYEE";

    private static final String TABLE_NAME = "EMPLOYEE";
    private static final String COL_ID = "EMPLOYEE_ID";
    private static final String COL_FIRST_NAME = "FIRST_NAME";
    private static final String COL_LAST_NAME = "LAST_NAME";

    public DBHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String str_create_table = "CREATE TABLE " + TABLE_NAME + " ( "
                                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                                + COL_FIRST_NAME + " TEXT, "
                                + COL_LAST_NAME + " TEXT )";
        db.execSQL(str_create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        this.onCreate(db);
    }

    public void add_new_employee(Employee employee)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_FIRST_NAME, employee.getEmp_first_name());
        values.put(COL_LAST_NAME, employee.getEmp_last_name());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<Employee> get_all_employees()
    {
        ArrayList<Employee> arrayList_employee = new ArrayList<>();

        String str_query = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(str_query, null);

        Employee employee = null;

        if (cursor.moveToFirst())
        {
            do {
                employee = new Employee();

                employee.setEmp_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COL_ID))));
                employee.setEmp_first_name(cursor.getString(cursor.getColumnIndex(COL_FIRST_NAME)));
                employee.setEmp_last_name(cursor.getString(cursor.getColumnIndex(COL_LAST_NAME)));

                arrayList_employee.add(employee);
            }while (cursor.moveToNext());

        }
        cursor.close();
        return arrayList_employee;
    }

    public void clear_table()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DELETE FROM " + TABLE_NAME);

        db.close();

    }
}
