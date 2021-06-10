package com.ecoco.ecoco;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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




        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            ((MainActivity) getActivity()).openDatabase("database");
            Change_date.setText(String.format("%d-%d-%d",year,month+1,dayOfMonth));
            sy = year;
            sm = month;
            sd = dayOfMonth;
            int pt = ((MainActivity) getActivity()).selectDatapoint(sy,sm,sd);
            String list = ((MainActivity) getActivity()).selectDatalist(sy,sm,sd);
            int total = ((MainActivity) getActivity()).sumPoints();
            dayp.setText("선택한 날짜에 총 " + pt + "포인트를 모았어요!" + list);
            t1.setText("Total : " + total);
        });
        return rootView;
    }

}