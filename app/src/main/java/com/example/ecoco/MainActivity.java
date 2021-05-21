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

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase database = null;
    public TextView Change_date;


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
            String sql = "CREATE TABLE IF NOT EXISTS daily (number integer PRIMARY KEY AUTOINCREMENT, date TEXT, point INT, list TEXT)";
            database.execSQL(sql);
            Log.i("dbex","Table opened");
        } else {
            Log.i("dbex","error");
        }
    }

    public String selectData1(int year, int month, int day){
        Change_date.setText(String.format("%d-%d-%d",year,month+1,day));
        if(database != null)
        {
            String sql = "SELECT * FROM daily= '" + Change_date + "'";
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

    public void funcDataView(View v)
    {
        Intent it = new Intent(MainActivity.this, UserData.class);
        startActivity(it);

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

    public double sumPoints(){
        if(database != null)
        {
            String sql = "SELECT SUM(point) FROM daily";
            Cursor cursor = database.rawQuery(sql, null);
            cursor.moveToFirst();
            double i=cursor.getDouble(2);

            return i;
        } else {
            return  0;
        }
    }

    public String selectData(int year, int month, int dayOfMonth){
        Change_date.setText(String.format("%d-%d-%d",year,month+1,dayOfMonth));
        if(database != null){ String sql = "SELECT list FROM daily WHERE date =" + Change_date;
            Cursor cursor = database.rawQuery(sql, null);
            String list = cursor.getString(0);
            cursor.close();
            return list;
        } else {
            return  "";
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

