package com.ecoco.ecoco;

import android.annotation.SuppressLint;
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

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FragmentPage1 extends Fragment {
    @SuppressLint("SimpleDateFormat")
    SimpleDateFormat format1 = new SimpleDateFormat( "yyyy-M-d");
    Calendar time = Calendar.getInstance();
    String format_time1 = format1.format(time.getTime());

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

        b.setOnClickListener(v -> {
            ((MainActivity) getActivity()).openDatabase("database");
            ((MainActivity) getActivity()).createTable();
            ((MainActivity) getActivity()).deleteData();
            int num_result = 0; // ??? ?????????
            StringBuilder result=new StringBuilder();
            result.append("???????????? ????");
            if (cb1.isChecked())
            {
                num_result += 0x3;
                result.append("\n\uD83C\uDF21????????? ??????");
            }
            if (cb2.isChecked())
            {
                num_result += 0x3;
                result.append("\n\uD83D\uDED2????????? ??????????????? ??????");
            }
            if (cb3.isChecked())
            {
                num_result += 1;
                result.append("\n\uD83C\uDF56?????? 50g ??????");
            }
            if (cb4.isChecked())
            {
                num_result += 0x2;
                result.append("\n\uD83E\uDD641????????? ?????? ??????");
            }
            if (cb5.isChecked())
            {
                num_result += 0x5;
                result.append("\n\uD83E\uDD66?????? ??? ??????");
            }
            if (cb6.isChecked())
            {
                num_result += 0x5;
                result.append("\n\uD83D\uDE89???????????? or ??????");
            }
            if (cb7.isChecked())
            {
                num_result += 0x1;
                result.append("\n\uD83C\uDF31?????? ?????????");
            }
            if (cb8.isChecked())
            {
                num_result += 0x2;
                result.append("\n??????????????? ?????????");
            }
            if (cb9.isChecked())
            {
                num_result += 0x1;
                result.append("\n\uD83D\uDEBF?????? 5??? ??????");
            }
            if (cb10.isChecked())
            {
                num_result += 0x1;
                result.append("\n\uD83D\uDD0C?????? ??????");
            }
            if (cb11.isChecked())
            {
                num_result += 0x2;
                result.append("\n\uD83D\uDCA8????????? ??????");
            }
            result.append("\n?????? ??? ").append(num_result).append("?????? ???????????????!");
            Toast.makeText(getActivity(), result.toString(), Toast.LENGTH_SHORT).show();
            Total.setText("????????? ?????? : " + num_result + "???");
            int yesterday = ((MainActivity) getActivity()).sumPoints();
            ((MainActivity) getActivity()).insertData(format_time1, num_result, result);
            int today = ((MainActivity) getActivity()).sumPoints();
            if (yesterday/100 != today/100) {
                Toast.makeText(getActivity(), "\uD83D\uDC36????????? ?????? ?????? ???????????????\uD83D\uDC2F \n\uD83C\uDF81????????? ?????? ????????? ????????? ???????????????!\uD83C\uDF81", Toast.LENGTH_LONG).show();
            }
        });
        return rootView;

    }
}