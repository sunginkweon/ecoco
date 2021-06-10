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
            int num_result = 0; // 값 초기화
            StringBuilder result=new StringBuilder();
            result.append("축하해요 🎉");
            if (cb1.isChecked())
            {
                num_result += 0x3;
                result.append("\n\uD83C\uDF21보일러 끄기");
            }
            if (cb2.isChecked())
            {
                num_result += 0x3;
                result.append("\n\uD83D\uDED2식자제 다회용기에 구매");
            }
            if (cb3.isChecked())
            {
                num_result += 1;
                result.append("\n\uD83C\uDF56육류 50g 이하");
            }
            if (cb4.isChecked())
            {
                num_result += 0x2;
                result.append("\n\uD83E\uDD641회용품 쓰지 않기");
            }
            if (cb5.isChecked())
            {
                num_result += 0x5;
                result.append("\n\uD83E\uDD66육류 안 먹기");
            }
            if (cb6.isChecked())
            {
                num_result += 0x5;
                result.append("\n\uD83D\uDE89대중교통 or 걷기");
            }
            if (cb7.isChecked())
            {
                num_result += 0x1;
                result.append("\n\uD83C\uDF31식물 키우기");
            }
            if (cb8.isChecked())
            {
                num_result += 0x2;
                result.append("\n♻분리수거 확실히");
            }
            if (cb9.isChecked())
            {
                num_result += 0x1;
                result.append("\n\uD83D\uDEBF샤워 5분 이내");
            }
            if (cb10.isChecked())
            {
                num_result += 0x1;
                result.append("\n\uD83D\uDD0C코드 뽑기");
            }
            if (cb11.isChecked())
            {
                num_result += 0x2;
                result.append("\n\uD83D\uDCA8선풍기 사용");
            }
            result.append("\n오늘 총 ").append(num_result).append("점을 획득했어요!");
            Toast.makeText(getActivity(), result.toString(), Toast.LENGTH_SHORT).show();
            Total.setText("오늘의 점수 : " + num_result + "점");
            int yesterday = ((MainActivity) getActivity()).sumPoints();
            ((MainActivity) getActivity()).insertData(format_time1, num_result, result);
            int today = ((MainActivity) getActivity()).sumPoints();
            if (yesterday/100 != today/100) {
                Toast.makeText(getActivity(), "\uD83D\uDC36어플을 껐다 새로 열어주시면\uD83D\uDC2F \n\uD83C\uDF81새로운 동물 친구가 도착해 있을거예요!\uD83C\uDF81", Toast.LENGTH_LONG).show();
            }
        });
        return rootView;

    }
}