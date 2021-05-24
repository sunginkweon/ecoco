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
    public TextView Change_date;
    public int sy,sm,sd;
    TextView dayp, t1;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View rootView = inflater.inflate(R.layout.fragment_page_2, container, false);

        calendarView = rootView.findViewById(R.id.calendarView);
        Change_date = rootView.findViewById(R.id.Date);
        dayp = rootView.findViewById(R.id.daypoint);
        t1 = rootView.findViewById(R.id.totalpt);




        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                ((MainActivity) getActivity()).openDatabase("database");
                Change_date.setText(String.format("%d-%d-%d",year,month+1,dayOfMonth));
                sy = year;
                sm = month;
                sd = dayOfMonth;
                int pt = ((MainActivity) getActivity()).selectDatapoint(sy,sm,sd);
                String list = ((MainActivity) getActivity()).selectDatalist(sy,sm,sd);
                int total = ((MainActivity) getActivity()).sumPoints();
                dayp.setText("선택한 날짜에 \n총" + pt + "포인트를 모았습니다 \n" + list);
                t1.setText("현재까지 모은\n 포인트는 총" + total + "pt입니다");
            }

        });
        return rootView;
    }

}