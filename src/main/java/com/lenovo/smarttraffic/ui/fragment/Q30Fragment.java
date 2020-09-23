package com.lenovo.smarttraffic.ui.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.lenovo.smarttraffic.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q30Fragment extends SupportFragment {
    @BindView(R.id.video)
    VideoView video;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q59_vedio, container, false);
        unbinder = ButterKnife.bind(this, v);
       // "android.resource://com.lenovo.smarttraffic/"+R.raw.vediotest3
        video.setVideoURI(Uri.parse("android.resource://com.lenovo.smarttraffic/" + R.raw.vediotest3));

        video.setMediaController(new MediaController(getContext()));
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
