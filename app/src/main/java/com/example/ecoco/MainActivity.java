package com.example.ecoco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase database = null;


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
        };

    public void openDatabase(String databaseName){
        Log.i("dbex", "openDatabase() called");
        database = openOrCreateDatabase(databaseName, MODE_PRIVATE, null);
        if(database != null) Log.i("dbex","database opened");
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

    public void openDatabase(View view) {
    }
}

