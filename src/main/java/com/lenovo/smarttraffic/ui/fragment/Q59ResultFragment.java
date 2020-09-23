package com.lenovo.smarttraffic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.Q59Bean;
import com.lenovo.smarttraffic.ui.activity.Item11Activity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q59ResultFragment extends SupportFragment {
    @BindView(R.id.tv_location)
    TextView tvLocation;
    @BindView(R.id.iv_left_arrow)
    ImageView ivLeftArrow;
    @BindView(R.id.iv_pic)
    ImageView ivPic;
    @BindView(R.id.iv_vedio)
    ImageView ivVedio;
    @BindView(R.id.iv_right_arrow)
    ImageView ivRightArrow;
    Unbinder unbinder;

    int[] imgs = {R.mipmap.weizhang01,R.mipmap.weizhang02,R.mipmap.weizhang03,R.mipmap.weizhang04};

    Q59Bean data;
    List<Q59Bean.ROWSDETAILBean> beans;
    int position = 0;


    void setQ59Bean(Q59Bean bean) {
        data = bean;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_q59_result, container, false);
        unbinder = ButterKnife.bind(this, v);

        Item11Activity item11Activity = (Item11Activity) getActivity();
        item11Activity.getToolbar().setTitle("查询结果");

        initView();
        initAction();
        return v;
    }
    boolean imgFlag = true;
    private void initAction() {
        ivLeftArrow.setOnClickListener(v -> {
            if(position > 0){
                position--;
                ivPic.setImageResource(imgs[position]);
                tvLocation.setText(beans.get(position).getPaddr());
            }else {
                Toast.makeText(_mActivity, "已经到第一条了", Toast.LENGTH_SHORT).show();
            }
        });

        ivRightArrow.setOnClickListener(v -> {
            if(position < 3){
                position++;
                ivPic.setImageResource(imgs[position]);
                tvLocation.setText(beans.get(position).getPaddr());
            }else {
                Toast.makeText(_mActivity, "最后一条", Toast.LENGTH_SHORT).show();
            }
        });

        ivPic.setOnClickListener(v->{
            if(imgFlag){
                ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
                int w = (int) (layoutParams.width*1.5);
                int h = (int) (layoutParams.height*1.5);
                v.setLayoutParams(new LinearLayout.LayoutParams(w,h));
                imgFlag = false;
            }else {
                ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
                int w = (int) (layoutParams.width/1.5);
                int h = (int) (layoutParams.height/1.5);
                v.setLayoutParams(new LinearLayout.LayoutParams(w,h));
                imgFlag = true;
            }
        });

        ivVedio.setOnClickListener(v ->{
            start(new Q59VedioFragment());
        });

    }

    private void initView() {
        if (data != null) {
            beans = data.getROWS_DETAIL();
            Q59Bean.ROWSDETAILBean bean = beans.get(0);
            Log.e("sss", "initView: " + bean);
            tvLocation.setText(bean.getPaddr());
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
