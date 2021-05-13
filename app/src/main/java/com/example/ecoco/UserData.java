package com.example.ecoco;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class UserData extends AppCompatActivity {

    SQLiteDatabase database = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);
        database = openDatabase("database");

        String resultdata = selectDataOne();
        TextView info = findViewById(R.id.info);
        info.setText(resultdata);

    }
    public SQLiteDatabase openDatabase(String databaseName){
        Log.i("dbex", "openDatabase() called");
        database = openOrCreateDatabase(databaseName, MODE_PRIVATE, null);
        if(database != null) Log.i("dbex","database opened");
        return database;
    }
    public String selectDataOne(){
        if(database != null)
        {
            String sql = "SELECT * FROM daily WHERE date = '2021-5-13'";
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
            return  "";
        }
    }
}
