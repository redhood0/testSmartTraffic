package com.lenovo.smarttraffic.ui.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bigkoo.pickerview.view.TimePickerView;
import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.ui.zujian.CalenDarTest1;
import com.lenovo.smarttraffic.ui.zujian.MyDialogTest1;

import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class FragmentTest3 extends SupportFragment {
    //    @BindView(R.id.tab)
//    TabLayout tab;
//    @BindView(R.id.vp)
//    ViewPager vp;
    Unbinder unbinder;
    @BindView(R.id.et)
    EditText et;
    @BindView(R.id.input)
    TextInputLayout input;
    @BindView(R.id.pb)
    ProgressBar pb;
    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;
//    @BindView(R.id.wv)
//    WebView wv;
//    Unbinder unbinder;
//    @BindView(R.id.video)
//    VideoView video;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_test4, container, false);

//        input.setHint("sssssb");
        //assets加载html文件，raw加载视频
//
//
//        unbinder = ButterKnife.bind(this, v);
//        video.setVideoURI(Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+ R.raw.vediotest3));
//        //video.setVideoURI(Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.vediotest3));
//        video.setMediaController(new MediaController(getActivity()));
//        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mp) {
//
//            }
//        });
//
//        wv.loadUrl("file:///android_asset/test.html");
//        wv.loadUrl("file:///android_asset/xxx.html");
//        new AssetManager().openXmlResourceParser("dd");
//       Question21To1Activity question21To1Activity = (Question21To1Activity) getActivity();
//        question21To1Activity.initToolBar(question21To1Activity.toolbar,true,"sn");

//       assert getActivity()!=null;
//       getActivity().runOnUiThread(new Runnable() {
//           @Override
//           public void run() {
//
//           }
//       });
//        question21To1Activity.runOnUiThread();
//
//
//        Intent i = new Intent(getContext(), MyNetWorkService.class);
//        getActivity().startService(i);

        //getActivity().stopService(i);

        unbinder = ButterKnife.bind(this, v);
//
//        tab.setupWithViewPager(vp);
//
//        MyAdapter m =  new MyAdapter(getChildFragmentManager());
//        m.fragments = new ArrayList<>();
//
//        m.fragments.add(new ItemTest4());
//        m.fragments.add(new FirstFragment());
//
//        vp.setAdapter(m);
//        vp.invalidate();

        btn1.setOnClickListener(n -> {
            AlertDialog.Builder b  =new  AlertDialog.Builder(getActivity());
            EditText editText = new EditText(getActivity());
            b.setView(editText).setTitle("dialog1").setPositiveButton(R.string.auto_login, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            }).setNegativeButton("sss", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            }).show();
        });


        btn2.setOnClickListener(n -> {
            MyDialogTest1 myDialogTest1 =  new MyDialogTest1();
            myDialogTest1.setCancelable(false);
//            myDialogTest1.getDialog().getWindow().getAttributes().width = 400;
            myDialogTest1.show(getChildFragmentManager(),"ss");
        });

        btn3.setOnClickListener(n -> {

//            start(new TestBar1());
//            startWithPop(new TestBar2());
//            CalenDarTest1 c = new CalenDarTest1();
//            c.show(getChildFragmentManager(),"calendar");
            TimePickerView timePickerView = new TimePickerBuilder(getActivity(), new OnTimeSelectListener() {
                @Override
                public void onTimeSelect(Date date, View v) {

                }
            })
                    .setType(new boolean[]{true,true,true,false,false,false})
                    .isDialog(true)

                    .build();
            timePickerView.show();

//            OptionsPickerView pickerView =  new  OptionsPickerBuilder(getActivity(),null,null).build();
//            pickerView.setPicker();


        });
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        unbinder.unbind();
        unbinder.unbind();
    }

    class MyAdapter extends FragmentPagerAdapter {
        public List<Fragment> fragments;
        String[] strings = {"第一页", "第二页"};

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return strings[position];
        }
    }
}
