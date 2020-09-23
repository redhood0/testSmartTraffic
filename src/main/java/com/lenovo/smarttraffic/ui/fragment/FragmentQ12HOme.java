package com.lenovo.smarttraffic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lenovo.smarttraffic.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class FragmentQ12HOme extends SupportFragment {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.num)
    EditText num;
    @BindView(R.id.search)
    Button search;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q12, container, false);
        unbinder = ButterKnife.bind(this, v);

        initAction();
        return v;
    }

    private void initAction() {
        search.setOnClickListener(v ->{
           String id =  num.getText().toString();
           if("B10001".equals(id)){
               start(new FragmentQ12P1());

           }else {
               Toast.makeText(_mActivity, "没有查询到"+id+"的违法记录", Toast.LENGTH_SHORT).show();
           }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
