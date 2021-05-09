package com.example.ecoco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase sqlitedb = null;


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
    public SQLiteDatabase openDatabase (String name)
    {
        SQLiteDatabase sqlitedb = openOrCreateDatabase(name, MODE_PRIVATE, null);
        return sqlitedb;
    }
    public void funDBopen (View v)
    {
        sqlitedb = openDatabase("sqlitedb");
        String sql = "create table IF NOT EXISTS daily (date date, list text, point integer)";
        sqlitedb.execSQL(sql);
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

