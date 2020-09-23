package com.lenovo.smarttraffic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.ui.activity.Item11Activity;
import com.lenovo.smarttraffic.ui.adapter.Q53RvAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q53Fragment extends SupportFragment {
    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_q53_home, container, false);

        unbinder = ButterKnife.bind(this, v);


        initview();
        return v;
    }


    private void initview() {
        Item11Activity item11Activity = (Item11Activity) getActivity();
        item11Activity.initToolBar(item11Activity.getToolbar(), true, "日志查询");

        List<String> d = new ArrayList<>();
        d.add("");
        d.add("");
        d.add("");
        d.add("");
        d.add("");
        d.add("");
        d.add("");
        d.add("");
        d.add("");
        d.add("");
        Q53RvAdapter q53RvAdapter = new Q53RvAdapter(d);
        rv.setAdapter(q53RvAdapter);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.scrollToPosition(1);

        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                View head = recyclerView.getLayoutManager().findViewByPosition(0);
                if (head != null) {
                    if (dy > 0) {
                        return;
                    }
                    int height = head.getLayoutParams().height;
                    if ((height + head.getY()) < height / 2) {
                        //改字
                        Log.e("ssss", "onScrolledaaaaaaaaaaaaaaaaaaa: >>>>>" + dy + ">>>>>>" + head.getY() + ">>>>" + head.getTop() + ":::::" + head.getLayoutParams().height);
                        TextView tv = head.findViewById(R.id.tv_content);
                        tv.post(new Runnable() {
                            @Override
                            public void run() {
                                tv.setText("下拉刷新");
                            }
                        });

                    } else if ((height + head.getY()) > height / 2 && (height + head.getY()) < height - 30) {
                        //改字
                        TextView tv = head.findViewById(R.id.tv_content);
                        tv.post(new Runnable() {
                            @Override
                            public void run() {
                                tv.setText("即将刷新");
                            }
                        });
                        Log.e("ssss", "onScrolledbbbbbbbbbbbbbbbbbb: >>>>>" + dy + ">>>>>>" + head.getY() + ">>>>" + head.getTop() + ":::::" + head.getLayoutParams().height);

                    } else if ((height + head.getY()) > (height - 30) && (height + head.getY()) <= height) {
                        rv.smoothScrollToPosition(0);
                        //改字
                        TextView tv = head.findViewById(R.id.tv_content);
                        tv.post(new Runnable() {
                            @Override
                            public void run() {
                                tv.setText("正在刷新");
                            }
                        });

                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    TimeUnit.SECONDS.sleep(5);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                tv.post(new Runnable() {
                                    @Override
                                    public void run() {

                                        tv.setText("刷新完成");
                                    }
                                });
                            }
                        }).start();


                        Log.e("ssss", "onScrolledvvvvvvvvvvvvvvvvvvvv: >>>>>" + dy + ">>>>>>" + head.getY() + ">>>>" + head.getTop() + ":::::" + head.getLayoutParams().height);

                    }
//                    Log.e("ssss", "onScrolled: >>>>>"+dy + ">>>>>>"+head.getY() + ">>>>" + head.getTop() +":::::" +head.getLayoutParams().height);

                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
