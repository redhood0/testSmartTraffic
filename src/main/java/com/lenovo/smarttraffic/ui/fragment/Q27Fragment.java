package com.lenovo.smarttraffic.ui.fragment;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q27Fragment extends SupportFragment {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.tv_pm)
    TextView tvPm;
    @BindView(R.id.tv_wendu)
    TextView tvWendu;
    @BindView(R.id.tv_shidu)
    TextView tvShidu;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.iv_1)
    ImageView iv1;
    @BindView(R.id.style1)
    TextView style1;
    @BindView(R.id.detial)
    TextView detial;
    @BindView(R.id.iv_2)
    ImageView iv2;
    @BindView(R.id.style2)
    TextView style2;
    @BindView(R.id.detial2)
    TextView detial2;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q27, container, false);
        unbinder = ButterKnife.bind(this, v);


                Notification.Builder builder = new Notification.Builder(getContext());
                builder.setContentTitle("11111D");
                builder.setContentText("22222222");
                builder.setSmallIcon(R.mipmap.icon101);
                Notification notification = builder.getNotification();
                NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(1,notification);


        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
