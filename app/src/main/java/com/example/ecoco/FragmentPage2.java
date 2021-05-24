package com.example.ecoco;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentPage2 extends Fragment {
    public CalendarView calendarView;
    SQLiteDatabase database = null;
    public TextView Change_date;
    public int sy,sm,sd;
    private Button b;
    TextView point;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View rootView = inflater.inflate(R.layout.fragment_page_2, container, false);

        calendarView = rootView.findViewById(R.id.calendarView);
        Change_date = rootView.findViewById(R.id.Date);
        b = rootView.findViewById(R.id.clicktotal);
        point = rootView.findViewById(R.id.point);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).openDatabase("database");
                ((MainActivity) getActivity()).createTable();
                int result = 0;
                String sql = "SELECT point FROM daily";
                Cursor cursor = database.rawQuery(sql, null);
                cursor.moveToFirst();
                result = cursor.getInt(1);
                point.setText("현재까지 획득한 총 포인트는" + result + "점 입니다.");
            }
        });


        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Change_date.setText(String.format("%d-%d-%d",year,month+1,dayOfMonth));
                sy = year;
                sm = month;
                sd = dayOfMonth;
            }

        });
        return rootView;
    }

}