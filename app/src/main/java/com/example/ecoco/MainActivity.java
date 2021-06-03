package com.example.ecoco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.sql.Date;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase database;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView mBottomNV = findViewById(R.id.nav_view);
        //NavigationItemSelected
        mBottomNV.setOnNavigationItemSelectedListener(menuItem -> {
            BottomNavigate(menuItem.getItemId());
            return true;
        });
        mBottomNV.setSelectedItemId(R.id.navigation_1);
    }

    public SQLiteDatabase openDatabase(String databaseName){
        Log.i("dbex", "openDatabase() called");
        database = openOrCreateDatabase(databaseName, MODE_PRIVATE, null);
        if(database != null) Log.i("dbex","database opened");
        return database;
    }

    public void createTable(){
        if(database != null){
            String sql = "CREATE TABLE IF NOT EXISTS daily (datano integer PRIMARY KEY autoincrement, date text, point int, list text)";
            database.execSQL(sql);
            Log.i("dbex","Table opened");
        } else {
            Log.i("dbex","error");
        }
    }

    public int selectDatapoint(int year, int month, int day){
        String seldate = null;
        seldate = String.format("%d-%d-%d",year,month+1,day);
        if(database != null)
        {
            String sql = "SELECT * FROM daily WHERE date='"+ seldate +"'";
            Cursor cursor = database.rawQuery(sql, null);
            int resultdata = 0;
            while(cursor.moveToNext()) {
                String date = cursor.getString(1);
                int point = cursor.getInt(2);
                String list = cursor.getString(3);
                resultdata = point;
            }
            cursor.close();
            return resultdata;
        } else {
            return  0;
        }
    }
    public int sumPoints(){
        if(database != null)
        {
            String sql = "SELECT SUM(point) FROM daily";
            Cursor cursor = database.rawQuery(sql, null);
            int result = 0;
            while(cursor.moveToNext()) {
                int point = cursor.getInt(0);
                result = point;
            }
            cursor.close();
            return result;
        } else {
            return  0;
        }
    }

    public String selectDatalist(int year, int month, int day){
        String seldate = null;
        seldate = String.format("%d-%d-%d",year,month+1,day);
        if(database != null)
        {
            String sql = "SELECT * FROM daily WHERE date='"+ seldate +"'";
            Cursor cursor = database.rawQuery(sql, null);
            String resultdata = "이 날은 기록이 없습니다";
            while(cursor.moveToNext()) {
                String date = cursor.getString(1);
                int point = cursor.getInt(2);
                String list = cursor.getString(3);
                resultdata = list;
            }
            cursor.close();
            return resultdata;
        } else {
            return  "이 날은 기록이 없습니다";
        }
    }



    public void insertData(String date, int point, StringBuilder list){

        if(database != null){
            String sql = "INSERT INTO daily(date, point, list) VALUES(?, ?, ?)";
            Object[] params = {date, point, list};
            database.execSQL(sql, params);
        } else {
            Log.i("dbex","error");
        }
    }




    private void BottomNavigate(int id) {  //BottomNavigation 페이지 변경
        String tag = String.valueOf(id);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment currentFragment = fragmentManager.getPrimaryNavigationFragment();
        if (currentFragment != null) {
            fragmentTransaction.hide(currentFragment);
        }

        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment == null) {
            if (id == R.id.navigation_1) {
                fragment = new FragmentPage1();
            } else if (id == R.id.navigation_2){
                fragment = new FragmentPage2();
            }else if (id == R.id.navigation_3){
                fragment = new FragmentPage3();
            }else {
                fragment = new FragmentPage4();
            }

            fragmentTransaction.add(R.id.content_layout, fragment, tag);
        } else {
            fragmentTransaction.show(fragment);
        }

        fragmentTransaction.setPrimaryNavigationFragment(fragment);
        fragmentTransaction.setReorderingAllowed(true);
        fragmentTransaction.commitNow();
    }

}

