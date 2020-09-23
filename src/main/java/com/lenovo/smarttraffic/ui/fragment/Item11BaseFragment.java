package com.lenovo.smarttraffic.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.ui.activity.Q10Activity;
import com.lenovo.smarttraffic.ui.activity.Q45Activity;
import com.lenovo.smarttraffic.ui.activity.Q47HomeActivity;
import com.lenovo.smarttraffic.ui.activity.Q51Activity;
import com.lenovo.smarttraffic.ui.activity.Q55Activity;
import com.lenovo.smarttraffic.ui.activity.Q62Activity;
import com.lenovo.smarttraffic.ui.activity.Q63Activity;
import com.lenovo.smarttraffic.ui.activity.Q64Activity;
import com.lenovo.smarttraffic.ui.activity.Q8Activity;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Item11BaseFragment extends SupportFragment {
    @BindView(R.id.q8)
    Button q8;
    @BindView(R.id.q9)
    Button q9;
    @BindView(R.id.q10)
    Button q10;
    @BindView(R.id.q11)
    Button q11;
    @BindView(R.id.q64)
    Button q64;
    @BindView(R.id.q63)
    Button q63;
    @BindView(R.id.q62)
    Button q62;
    @BindView(R.id.q61)
    Button q61;
    @BindView(R.id.q60)
    Button q60;
    @BindView(R.id.q59)
    Button q59;
    @BindView(R.id.q58)
    Button q58;
    @BindView(R.id.q57)
    Button q57;
    @BindView(R.id.q56)
    Button q56;
    @BindView(R.id.q55)
    Button q55;
    Unbinder unbinder;
    @BindView(R.id.q54)
    Button q54;
    @BindView(R.id.q53)
    Button q53;
    @BindView(R.id.q52)
    Button q52;
    @BindView(R.id.q51)
    Button q51;
    @BindView(R.id.q50)
    Button q50;
    @BindView(R.id.q49)
    Button q49;
    @BindView(R.id.q48)
    Button q48;
    @BindView(R.id.q47)
    Button q47;
    @BindView(R.id.q46)
    Button q46;
    @BindView(R.id.q45)
    Button q45;
    @BindView(R.id.q44)
    Button q44;
    @BindView(R.id.q43)
    Button q43;
    @BindView(R.id.q42)
    Button q42;
    @BindView(R.id.q41)
    Button q41;
    @BindView(R.id.q40)
    Button q40;
    @BindView(R.id.q39)
    Button q39;
    @BindView(R.id.q38)
    Button q38;
    @BindView(R.id.q37)
    Button q37;
    @BindView(R.id.q36)
    Button q36;
    @BindView(R.id.q35)
    Button q35;
    @BindView(R.id.q34)
    Button q34;
    @BindView(R.id.q33)
    Button q33;
    @BindView(R.id.q32)
    Button q32;
    @BindView(R.id.q31)
    Button q31;
    @BindView(R.id.q30)
    Button q30;
    @BindView(R.id.q29)
    Button q29;
    @BindView(R.id.q28)
    Button q28;
    @BindView(R.id.q27)
    Button q27;
    @BindView(R.id.q26)
    Button q26;
    @BindView(R.id.q25)
    Button q25;
    @BindView(R.id.q24)
    Button q24;
    @BindView(R.id.q23)
    Button q23;
    @BindView(R.id.q22)
    Button q22;
    @BindView(R.id.q21)
    Button q21;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item11_content, container, false);
        unbinder = ButterKnife.bind(this, view);
//        EventBus.getDefault().register(this);
        initView();
        return view;
    }

    private void initView() {
        q8.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), Q8Activity.class);
            startActivity(intent);
        });
        q10.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), Q10Activity.class);
            startActivity(intent);
        });

        q64.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), Q64Activity.class);
            startActivity(intent);
        });
        q63.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), Q63Activity.class);
            startActivity(intent);
        });

        q62.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), Q62Activity.class);
            startActivity(intent);
        });

        q61.setOnClickListener(v -> {
//            EventBus.getDefault().postSticky(new TestBean1("sbbbbbb"));
//            EventBus.getDefault().postSticky();
            start(new Q61Fragment());
        });

        q60.setOnClickListener(v -> {

            start(new Q60Fragment());
        });

        q59.setOnClickListener(v -> {

            start(new Q59HomeFragment());
        });

        q58.setOnClickListener(v -> {

            start(new Q58Fragment());
        });
        q57.setOnClickListener(v -> {

            start(new Q57Fragment());
        });
        q56.setOnClickListener(v -> {

            start(new Q56FragmentHome());
        });
        q55.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), Q55Activity.class);
            startActivity(intent);
            getActivity().finish();
//            start(new Q56FragmentHome());
        });
        q54.setOnClickListener(v -> {

            start(new Q54Fragment());
        });
        q53.setOnClickListener(v -> {

            start(new Q53Fragment());
        });

        q51.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), Q51Activity.class);
            startActivity(intent);
//            start(new Q51Fragment());
        });

        q50.setOnClickListener(v -> {

            start(new Q50Fragment());
        });

        q49.setOnClickListener(v -> {

            start(new Q49Fragment());
        });
        q47.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), Q47HomeActivity.class);
            startActivity(intent);
            getActivity().finish();
        });

        q45.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), Q45Activity.class);
            startActivity(intent);
            getActivity().finish();
        });
        q43.setOnClickListener(v -> {
            start(new Q43Fragment());
        });

        q42.setOnClickListener(v -> {
            start(new Q42Fragment());
        });

        q41.setOnClickListener(v -> {
            start(new Q41FragmentHome());
        });

        q40.setOnClickListener(v -> {
            start(new Q40Fragment());
        });

        q39.setOnClickListener(v -> {
            start(new Q39Fragment());
        });
        q38.setOnClickListener(v -> {
            start(new Q38Fragment());
        });

        q37.setOnClickListener(v -> {
            start(new Q37FragmentHome());
        });

        q36.setOnClickListener(v -> {
            start(new Q36Fragment());
        });

        q35.setOnClickListener(v -> {
            start(new Q35Fragment());
        });

        q34.setOnClickListener(v -> {
            start(new Q34Fragment());
        });

        q34.setOnClickListener(v -> {
            start(new Q34Fragment());
        });

        q33.setOnClickListener(v -> {
            start(new Q33Fragment());
        });

        q32.setOnClickListener(v -> {
            start(new Q32Fragment());
        });

        q31.setOnClickListener(v -> {
            start(new Q33Fragment());
        });

        q30.setOnClickListener(v -> {
            start(new Q30Fragment());
        });

        q29.setOnClickListener(v -> {
            start(new Q29GrahmentHome());
        });

        q28.setOnClickListener(v -> {
            start(new Q28Fragment());
        });
        q27.setOnClickListener(v -> {
            start(new Q27Fragment());
        });

        q26.setOnClickListener(v -> {
            start(new Q26FragmentHome());
        });

        q25.setOnClickListener(v -> {
            start(new Q25Frgment());
        });
        q24.setOnClickListener(v -> {
            start(new Q24Fragment());
        });

        q23.setOnClickListener(v -> {
            start(new Q23Fragment());
        });

        q22.setOnClickListener(v -> {
            start(new Q22Fragment());
        });



    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onEvent(String x){
//        Log.e("xxx", "getMsg-from [[[[[[[[[[[[[[[:>>>> "+x );
//
//    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
//        null.unbind();
    }
}
