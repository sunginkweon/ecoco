package com.example.ecoco;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.FileInputStream;
import java.io.IOException;

public class FragmentPage2 extends Fragment {
    public CalendarView calendarView;
    public TextView diaryTextView,dailydata;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View rootView = inflater.inflate(R.layout.fragment_page_2, container, false);

        calendarView = rootView.findViewById(R.id.calendarView);
        diaryTextView= rootView.findViewById(R.id.Date);
        dailydata = rootView.findViewById(R.id.dailylist);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                diaryTextView.setText(String.format("%d / %d / %d",year,month+1,dayOfMonth));
            }

        });
        return rootView;
    }

}