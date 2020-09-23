package com.lenovo.smarttraffic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatSpinner;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.lenovo.smarttraffic.R;

import java.util.Comparator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class FragmentQ3 extends SupportFragment {
    @BindView(R.id.spinner)
    AppCompatSpinner spinner;
    @BindView(R.id.btn)
    Button btn;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q3, container, false);
        unbinder = ButterKnife.bind(this, v);

        String[] titles = {"xxxx1","xxxx2"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(),R.layout.item_just_text,R.id.tv,titles);
        spinner.setAdapter(arrayAdapter);
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
