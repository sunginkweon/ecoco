package com.example.ecoco;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UserData extends AppCompatActivity {

    SimpleDateFormat format1 = new SimpleDateFormat( "yyyy-M-d");
    SQLiteDatabase database = null;
    public TextView Change_date;
    String d1 = format1.format(20210522);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);
        database = openDatabase("database");
        Change_date = findViewById(R.id.Date);

        String resultdata = selectDataOne();
        String clickday = selectday();
        TextView info = findViewById(R.id.info);
        info.setText(resultdata);
        TextView ckday = findViewById(R.id.ckday);
        ckday.setText(clickday);

    }

    public SQLiteDatabase openDatabase(String databaseName){
        Log.i("dbex", "openDatabase() called");
        database = openOrCreateDatabase(databaseName, MODE_PRIVATE, null);
        if(database != null) Log.i("dbex","database opened");
        return database;
    }
    public String selectday(){
        if(database != null)
        {
            String sql = "SELECT * FROM daily";
            Cursor cursor = database.rawQuery(sql, null);
            String clickday = null;
            while(cursor.moveToNext()) {
                int number = cursor.getInt(0);
                String date = cursor.getString(1);
                int point = cursor.getInt(2);
                String list = cursor.getString(3);
                clickday = date;
            }
            cursor.close();
            return clickday;
        } else {
            return  "해당 날짜에는 기록이 없습니다.";
        }
    }
    public String selectDataOne(){
        if(database != null)
        {
            String sql = "SELECT * FROM daily";
            Cursor cursor = database.rawQuery(sql, null);
            String resultdata = null;
            while(cursor.moveToNext()) {
                int number = cursor.getInt(0);
                String date = cursor.getString(1);
                int point = cursor.getInt(2);
                String list = cursor.getString(3);
                resultdata = list;
             }
            cursor.close();
            return resultdata;
        } else {
            return  "해당 날짜에는 기록이 없습니다.";
        }
    }

}
