package com.lenovo.smarttraffic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.ChongzhiRecoder;
import com.lenovo.smarttraffic.ui.activity.Item11Activity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q34ChongzhiFragment extends SupportFragment {

    @BindView(R.id.tv_all)
    TextView tvAll;
    @BindView(R.id.gv)
    GridView gv;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q34_recorder, container, false);

        unbinder = ButterKnife.bind(this, v);
        initView();

        return v;
    }

    private void initView() {
        Item11Activity item11Activity = (Item11Activity) getActivity();
        List<ChongzhiRecoder> recoder = item11Activity.recoders;
        List<String> list = new ArrayList<>();
        list.add("车辆编号");
        list.add("车牌号");
        list.add("充值金额");
        list.add("充值时间");

        int all = 0;
        if (recoder.size() <= 0) {
            return;
        } else {
            Collections.reverse(recoder);

            int i = 1;
            for (ChongzhiRecoder rec : recoder) {
                all += rec.getMoney();
                list.add(""+i);
                list.add(""+rec.getChepai());
                list.add(""+rec.getMoney());
                list.add(rec.getDate());
                i++;
            }
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(),R.layout.item_just_text,R.id.tv,list);
            gv.setAdapter(arrayAdapter);
            tvAll.setText("合计充值：" + all + "元");
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
