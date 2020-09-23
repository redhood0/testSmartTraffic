package com.lenovo.smarttraffic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class FragmentQ5 extends SupportFragment {
    @BindView(R.id.title1)
    TextView title1;
    @BindView(R.id.num1)
    TextView num1;
    @BindView(R.id.cl1)
    ConstraintLayout cl1;
    @BindView(R.id.title2)
    TextView title2;
    @BindView(R.id.num2)
    TextView num2;
    @BindView(R.id.cl2)
    ConstraintLayout cl2;
    @BindView(R.id.title3)
    TextView title3;
    @BindView(R.id.num3)
    TextView num3;
    @BindView(R.id.cl3)
    ConstraintLayout cl3;
    @BindView(R.id.title4)
    TextView title4;
    @BindView(R.id.num4)
    TextView num4;
    @BindView(R.id.cl4)
    ConstraintLayout cl4;
    @BindView(R.id.title5)
    TextView title5;
    @BindView(R.id.num5)
    TextView num5;
    @BindView(R.id.cl5)
    ConstraintLayout cl5;
    @BindView(R.id.title6)
    TextView title6;
    @BindView(R.id.num6)
    TextView num6;
    @BindView(R.id.cl6)
    ConstraintLayout cl6;
    Unbinder unbinder;


    List<String> data;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q5, container, false);

        unbinder = ButterKnife.bind(this, v);

        title1.setText("温度");
        title2.setText("湿度");
        title3.setText("光照");
        title4.setText("co2");
        title5.setText("pm2.5");
        title6.setText("道路状态");
        random();
        num1.setText(data.get(0));
        num2.setText(data.get(1));
        num3.setText(data.get(2));
        num4.setText(data.get(3));
        num5.setText(data.get(4));
        num6.setText(data.get(5));





        return v;
    }

    private  void random(){
        data = new ArrayList<>();
        data.add("32");
        data.add("88");
        data.add("2002");
        data.add("222");
        data.add("334");
        data.add("2");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
