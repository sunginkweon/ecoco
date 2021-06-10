package com.ecoco.ecoco;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentPage4 extends Fragment {

    private Button SendFeedback;
    private Button AppRate;
    private Button INSTAGRAMecoco;
    private Button More;
    private Button Developers;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View rootView = inflater.inflate(R.layout.fragment_page_4, container, false);
        SendFeedback = rootView.findViewById(R.id.SendFeedback);
        AppRate = rootView.findViewById(R.id.AppRate);
        INSTAGRAMecoco = rootView.findViewById(R.id.INSTAGRAMecoco);
        More = rootView.findViewById(R.id.More);
        Developers = rootView.findViewById(R.id.Developers);


        SendFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com"));
                startActivity(myIntent);
            }
        });

        AppRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com"));
                startActivity(myIntent);
            }
        });

        More.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=gUhxcdzRgLQ"));
                startActivity(myIntent);
            }
        });

        Developers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getActivity(), developers.class);
                startActivity(myIntent);
            }
        });

        INSTAGRAMecoco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        /* id : app_ecoco, pw : ecoco0000*/



        return rootView;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }



}