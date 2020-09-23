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
import com.lenovo.smarttraffic.ui.activity.Q10ActivityHome;
import com.lenovo.smarttraffic.ui.activity.Q6ActivityHome;
import com.lenovo.smarttraffic.ui.activity.Q7ActivityHome;
import com.lenovo.smarttraffic.ui.activity.Q8Activity;
import com.lenovo.smarttraffic.ui.activity.Q9ActivityHome;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class QuestionsFragment21to1 extends SupportFragment {

    @BindView(R.id.q21)
    Button q21;
    @BindView(R.id.q20)
    Button q20;
    @BindView(R.id.q19)
    Button q19;
    @BindView(R.id.q18)
    Button q18;
    @BindView(R.id.q17)
    Button q17;
    @BindView(R.id.q16)
    Button q16;
    @BindView(R.id.q15)
    Button q15;
    Unbinder unbinder;
    @BindView(R.id.q14)
    Button q14;
    @BindView(R.id.q13)
    Button q13;
    @BindView(R.id.q12)
    Button q12;
    @BindView(R.id.q11)
    Button q11;
    @BindView(R.id.q10)
    Button q10;
    @BindView(R.id.q9)
    Button q9;
    @BindView(R.id.q8)
    Button q8;
    @BindView(R.id.q7)
    Button q7;
    @BindView(R.id.q6)
    Button q6;
    @BindView(R.id.q5)
    Button q5;
    @BindView(R.id.q4)
    Button q4;
    @BindView(R.id.q3)
    Button q3;
    @BindView(R.id.q2)
    Button q2;
    @BindView(R.id.q1)
    Button q1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_question_21_1, container, false);
        unbinder = ButterKnife.bind(this, v);


        q21.setOnClickListener(n -> {
            start(new Q21Fragment());
        });
        q20.setOnClickListener(n -> {
            start(new Q20Fragment());
        });
        q19.setOnClickListener(n -> {
            start(new Q19HomeFragment());
        });

        q18.setOnClickListener(n -> {
            start(new Q18Fragment());
        });

        q17.setOnClickListener(n -> {
            start(new Q17Fragment());
        });
        q16.setOnClickListener(n -> {
            start(new Q16FragmentHOme());
        });
        q15.setOnClickListener(n -> {
            start(new FragmentQ15Home());
        });

        q14.setOnClickListener(n -> {
            start(new FragmentQ14());
        });

        q13.setOnClickListener(n -> {
            start(new Q13Fragment());
        });

        q12.setOnClickListener(n -> {
            start(new FragmentQ12HOme());
        });

        q11.setOnClickListener(n -> {
            start(new FragmentQ11Home());
        });

        q10.setOnClickListener(n -> {
            Intent intent = new Intent(getActivity(), Q10ActivityHome.class);
            getActivity().startActivity(intent);
            getActivity().finish();
        });
        q9.setOnClickListener(n -> {
            Intent intent = new Intent(getActivity(), Q9ActivityHome.class);
            getActivity().startActivity(intent);
            getActivity().finish();
        });

        q8.setOnClickListener(n -> {
//            Intent intent = new Intent(getActivity(), Q8Activity.class);
//            getActivity().startActivity(intent);
//            getActivity().finish();
            start(new FragmentTest3());
        });

        q7.setOnClickListener(n -> {
            Intent intent = new Intent(getActivity(), Q7ActivityHome.class);
            getActivity().startActivity(intent);
            getActivity().finish();
        });

        q6.setOnClickListener(n -> {
            Intent intent = new Intent(getActivity(), Q6ActivityHome.class);
            getActivity().startActivity(intent);
            getActivity().finish();
        });

        q5.setOnClickListener(n -> {
           start(new FragmentQ5());
        });

        q4.setOnClickListener(n -> {
            start(new FragmentQ4());
        });

        q3.setOnClickListener(n -> {
            start(new FragmentQ3());
        });
        q2.setOnClickListener(n -> {
            start(new FragmentQ11Home());
        });

        q1.setOnClickListener(n -> {
            start(new FragmentQ1Home());
        });
        return v;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
