package com.lenovo.smarttraffic.ui.activity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import com.lenovo.smarttraffic.R;

import java.net.URI;

import butterknife.BindView;

public class VedioActivity extends BaseActivity {

    @BindView(R.id.vv)
    VideoView vv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.vediotest3);
        Log.e("uri", "onCreate: "+getPackageName() );
        vv.setVideoURI(uri);

        vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Log.e("vedio", "onPrepared: success" );
                vv.start();
            }
        });
        vv.requestFocus();
        vv.setMediaController(new MediaController(this));
        //vv.start();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_vedio;
    }
}
