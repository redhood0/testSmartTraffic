package com.lenovo.smarttraffic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lenovo.smarttraffic.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class FragmentQ12P1 extends SupportFragment {
    @BindView(R.id.add)
    ImageView add;
    @BindView(R.id.minus)
    ImageView minus;
    @BindView(R.id.show_card)
    LinearLayout showCard;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q12_p1, container, false);

        unbinder = ButterKnife.bind(this, v);

        minus.setOnClickListener(n -> {
            showCard.setVisibility(View.GONE);
        });
        add.setOnClickListener(n -> {
            start(new FragmentQ12p2());
        });
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
