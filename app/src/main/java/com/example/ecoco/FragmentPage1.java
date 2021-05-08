package com.example.ecoco;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
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

import static android.content.Context.MODE_PRIVATE;

public class FragmentPage1 extends Fragment {

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
        cb1 = (CheckBox) rootView.findViewById(R.id.CB_Boiler);
        cb2 = (CheckBox) rootView.findViewById(R.id.CB_Container);
        cb3 = (CheckBox) rootView.findViewById(R.id.CB_Meat50);
        cb4 = (CheckBox) rootView.findViewById(R.id.CB_NoDisposable);
        cb5 = (CheckBox) rootView.findViewById(R.id.CB_NoMeat);
        cb6 = (CheckBox) rootView.findViewById(R.id.CB_PublicTransport);
        cb7 = (CheckBox) rootView.findViewById(R.id.CB_Plant);
        cb8 = (CheckBox) rootView.findViewById(R.id.CB_SeperateCollection);
        cb9 = (CheckBox) rootView.findViewById(R.id.CB_Shower5);
        cb10 = (CheckBox) rootView.findViewById(R.id.CB_code);
        cb11 = (CheckBox) rootView.findViewById(R.id.CB_fan);
        b = rootView.findViewById(R.id.BT_save);
        Total = (TextView) rootView.findViewById(R.id.Total);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View rootView) {
                int num_result = 0; // 값 초기화
                StringBuilder result=new StringBuilder();
                result.append("축하해요 🎉");
                if (cb1.isChecked()) num_result += 0x3;
                if (cb2.isChecked()) num_result += 0x3;
                if (cb3.isChecked()) num_result += 0x10;
                if (cb4.isChecked()) num_result += 0x2;
                if (cb5.isChecked()) num_result += 0x5;
                if (cb6.isChecked()) num_result += 0x5;
                if (cb7.isChecked()) num_result += 0x1;
                if (cb8.isChecked()) num_result += 0x2;
                if (cb9.isChecked()) num_result += 0x1;
                if (cb10.isChecked()) num_result += 0x1;
                if (cb11.isChecked()) num_result += 0x2;
                result.append("\n오늘 총 " + num_result + "점을 획득했어요!");
                Toast.makeText(getActivity(), result.toString(), Toast.LENGTH_SHORT).show();
                Total.setText("오늘의 점수 : " + num_result + "점");

                ;

            }
        }); // end setOnClickListener
        return rootView;

    }
}