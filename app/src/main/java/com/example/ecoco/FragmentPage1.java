package com.example.ecoco;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static android.content.Context.MODE_PRIVATE;

public class FragmentPage1 extends Fragment {
    @SuppressLint("SimpleDateFormat")
    SimpleDateFormat format1 = new SimpleDateFormat( "yyyy-MM-dd");
    Calendar time = Calendar.getInstance();
    String format_time1 = format1.format(time.getTime());

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    int today_total;

    private CheckBox cb1;
    private CheckBox cb2;
    private CheckBox cb3;
    private CheckBox cb4;
    private CheckBox cb5;
    private CheckBox cb6;
    private CheckBox cb7;
    private CheckBox cb8;
    private CheckBox cb9;
    private CheckBox cb10;
    private CheckBox cb11;
    private TextView Total;
    private Button b;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View rootView = inflater.inflate(R.layout.fragment_page_1, container, false);
        cb1 = rootView.findViewById(R.id.CB_Boiler);
        cb2 = rootView.findViewById(R.id.CB_Container);
        cb3 = rootView.findViewById(R.id.CB_Meat50);
        cb4 = rootView.findViewById(R.id.CB_NoDisposable);
        cb5 = rootView.findViewById(R.id.CB_NoMeat);
        cb6 = rootView.findViewById(R.id.CB_PublicTransport);
        cb7 = rootView.findViewById(R.id.CB_Plant);
        cb8 = rootView.findViewById(R.id.CB_SeperateCollection);
        cb9 = rootView.findViewById(R.id.CB_Shower5);
        cb10 = rootView.findViewById(R.id.CB_code);
        cb11 = rootView.findViewById(R.id.CB_fan);
        b = rootView.findViewById(R.id.BT_save);
        Total = rootView.findViewById(R.id.Total);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).openDatabase("database");
                ((MainActivity) getActivity()).createTable();
                int num_result = 0; // 값 초기화
                StringBuilder result=new StringBuilder();
                result.append("축하해요 🎉");
                if (cb1.isChecked())
                {
                    num_result += 0x3;
                    result.append("\n보일러 끄기");
                }
                if (cb2.isChecked()) 
                {
                    num_result += 0x3;
                    result.append("\n다회 용기에 담기");
                }
                if (cb3.isChecked()) 
                {
                    num_result += 10;
                    result.append("\n육류 50g 이하");
                }
                if (cb4.isChecked()) 
                {
                    num_result += 0x2;
                    result.append("\n1회용품 쓰지 않기");
                }
                if (cb5.isChecked()) 
                {
                    num_result += 0x5;
                    result.append("\n육류 안 먹기");
                }
                if (cb6.isChecked()) 
                {
                    num_result += 0x5;
                    result.append("\n대중교통 or 걷기");
                }
                if (cb7.isChecked()) 
                {
                    num_result += 0x1;
                    result.append("\n식물 키우기");
                }
                if (cb8.isChecked()) 
                {
                    num_result += 0x2;
                    result.append("\n분리수거 확실히");
                }
                if (cb9.isChecked()) 
                {
                    num_result += 0x1;
                    result.append("\n샤워 5분 이내");
                }
                if (cb10.isChecked()) 
                {
                    num_result += 0x1;
                    result.append("\n코드 뽑기");
                }
                if (cb11.isChecked()) 
                {
                    num_result += 0x2;
                    result.append("\n선풍기 사용");
                }
                result.append("\n오늘 총 " + num_result + "점을 획득했어요!");
                Toast.makeText(getActivity(), result.toString(), Toast.LENGTH_SHORT).show();
                Total.setText("오늘의 점수 : " + num_result + "점");
                ((MainActivity) getActivity()).insertData(format_time1, num_result, result);

            }
        }); // end setOnClickListener
        return rootView;

    }
}