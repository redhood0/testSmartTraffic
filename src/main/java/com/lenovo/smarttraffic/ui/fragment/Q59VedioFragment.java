package com.lenovo.smarttraffic.ui.fragment;

import android.media.MediaPlayer;
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
import com.lenovo.smarttraffic.ui.activity.Item11Activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q59VedioFragment extends SupportFragment {
    @BindView(R.id.video)
    VideoView video;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_q59_vedio, container, false);

        Item11Activity item11Activity = (Item11Activity) getActivity();
        item11Activity.getToolbar().setTitle("视频播放");

        unbinder = ButterKnife.bind(this, v);

        video.setVideoURI(Uri.parse("android.resource://com.lenovo.smarttraffic/"+R.raw.vediotest3));
//        video.setVideoURI(Uri.parse("android.resource://baoming/R.xxx.xxx"));

        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                video.start();
            }
        });
        video.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ((Item11Activity) getActivity()).pop();
                return false;
            }
        });

        video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                ((Item11Activity) getActivity()).pop();
            }
        });

        video.setMediaController(new MediaController(getContext()));
        return v;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
