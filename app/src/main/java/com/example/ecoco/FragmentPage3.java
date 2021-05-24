package com.example.ecoco;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class FragmentPage3 extends Fragment{

    TextView name, detail;
    ImageView mainC;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View rootView = inflater.inflate(R.layout.fragment_page_3, container, false);
        Button buttonForDetail = rootView.findViewById(R.id.ButtonForDetail);
        mainC = (ImageView) rootView.findViewById(R.id.main_character);
        View c1 = rootView.findViewById(R.id.c1);
        View c2 = rootView.findViewById(R.id.c2);
        View c3 = rootView.findViewById(R.id.c3);
        View c4 = rootView.findViewById(R.id.c4);
        View c5 = rootView.findViewById(R.id.c5);
        View c6 = rootView.findViewById(R.id.c6);
        View c7 = rootView.findViewById(R.id.c7);
        View c8 = rootView.findViewById(R.id.c8);
        View c9 = rootView.findViewById(R.id.c9);
        name = rootView.findViewById(R.id.main_name);
        detail = rootView.findViewById(R.id.main_detail);






        buttonForDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getActivity(), CharacterDetail.class);
                startActivity(myIntent);
            }
        });
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainC.setImageResource(R.drawable.ochotonidae);
                name.setText("우는 토끼");
                detail.setText("북부아시아의 고산지대, 부서진 바위더미나 돌무더기에 서식하는 우는토끼는 작은 덩치와 귀를 가져 언뜻 쥐처럼 보이기도 합니다.\n" +
                        "        이름에서 알 수 있듯이 독특한 울음소리로 표현을 하며, 꽃과 과일, 곤충 등을 좋아합니다.\n" +
                        "        추운 지역에서 서식하는 우는토끼들은 기후변화로 더위가 심해지면서 생명의 위협을 받고 있습니다.\n" +
                        "        또 서식지의 식물유형이 바뀌면서 먹이를 찾기도 점점 어려워지고 있다고 합니다.");
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainC.setImageResource(R.drawable.chipmunk);
                name.setText("하늘 다람쥐");
                detail.setText("긴 가뭄으로 지리산 계곡이 말라 하늘다람쥐가 마실 물이 고갈되고 주위의 침엽수가 고사되어 하늘다람쥐의 생존에 위협을 주고 있습니다. 기후변화에 의한 생태계의 변화가 하늘다람쥐의 수를 더욱 감소시키고 있습니다.");
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainC.setImageResource(R.drawable.marmotte);
                name.setText("마모트");
                detail.setText("동면에 들어가야 하는데 이상기후로 일찍 깨거나 아예 동면하지 못하기에 겨울철에 잡아먹힐 위험성도 높고 겨울철동안 먹이도 충분하지 않게 된다.");
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainC.setImageResource(R.drawable.cheetah);
                name.setText("아프리카 치타");
                detail.setText("아프리카 치타는 세상에서 가장 빠른 동물입니다. 그래도 기후변화의 속도를 따라가기엔 역부족인걸까요? 극심한 폭염으로 인해 수컷 치타의 남성호르몬 수치가 낮아져 더이상 아이를 가질 수 없는 상태에 이르렀습니다. 단 7,100마리밖에 남지 않은 치타는 무사히 대를 이어갈 수 있을까요?");
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainC.setImageResource(R.drawable.odobenus);
                name.setText("바다코끼리");
                detail.setText("새끼바다코끼리는 2년동안 사냥을 못하는데 이때 어미가 사냥을 할 동안 쉬고 있을 유빙이 사라지고 있다.");
            }
        });
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainC.setImageResource(R.drawable.panda);
                name.setText("판다");
                detail.setText("영화 <쿵푸팬더>의 주인공, 자이언트 판다도 기후변화의 위협에서 자유롭지 못합니다. 생존에 필요한 영양 뿐 아니라 서식처를 제공하는 대나무 숲이 기후변화로 인해 빠른 속도로 없어지고 있기 때문입니다. 2014년 기준, 약 1,854마리의 자이언트 판다가 야생에서 살고 있습니다.");
            }
        });
        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainC.setImageResource(R.drawable.polarbear);
                name.setText("북극곰");
                detail.setText("빙하가 사라져 터전도 사라지고 수온 상승으로 인해 적절한 사냥감도 줄어들고 있다.");
            }
        });
        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainC.setImageResource(R.drawable.tiger);
                name.setText("벵갈호랑이");
                detail.setText("방글라데시와 인도의 습지에는 현재 약 5,000 마리의 벵갈 호랑이가 살고 있습니다. 그러나 기후변화로 인한 해수면 상승으로 인해 벵갈호랑이의 서식처가 물에 잠길 위험에 처했습니다. 유엔은 2070년이 되면 벵갈호랑이가 살 수 있는 습지가 모두 물에 잠겨 완전히 멸종할 것이라고 경고했습니다.");
            }
        });
        c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainC.setImageResource(R.drawable.turtle);
                name.setText("바다거북");
                detail.setText("바닷속 플라스틱으로 괴로운 바다거북은 지구온난화의 피해자이기도 합니다. 바다거북은 해변가 모래 속에 알을 낳습니다. 모래에 수분기가 많고 시원할수록 수컷이 많이 부화하고, 모래가 따뜻하고 건조할수록 암컷이 많이 부화합니다. 지구 온도 상승으로 인해 이제 수컷 바다거북은 거의 태어나지 않습니다. 지난 20년 동안 태어난 바다거북의 99%가 암컷이었습니다.");
            }
        });




        return rootView;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}