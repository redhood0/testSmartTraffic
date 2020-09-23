package com.lenovo.smarttraffic.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.model.Person;
import com.lenovo.smarttraffic.ui.fragment.Fragment921_1;
import com.lenovo.smarttraffic.ui.fragment.Fragment922_1;
import com.lenovo.smarttraffic.ui.fragment.Fragment922_2;
import com.lenovo.smarttraffic.ui.fragment.Fragment923_1;
import com.lenovo.smarttraffic.ui.fragment.Fragment_921_2;
import com.lenovo.smarttraffic.ui.fragment.Fragment_922_3;
import com.lenovo.smarttraffic.ui.fragment.Fragment_923_2;
import com.lenovo.smarttraffic.ui.fragment.Fragment_923_4;
import com.lenovo.smarttraffic.ui.fragment.Fragment_932_3;
import com.lenovo.smarttraffic.ui.fragment.Q54Fragment;

import org.litepal.LitePal;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.SupportFragment;
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.DefaultNoAnimator;

import static me.yokeyword.fragmentation.ISupportFragment.SINGLETASK;
import static me.yokeyword.fragmentation.ISupportFragment.STANDARD;

public class NewActivity921 extends SupportActivity {
    @BindView(R.id.toolbar01)
    Toolbar toolbar;
    @BindView(R.id.applayout01)
    AppBarLayout appBarLayout;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.fragment_container)
    LinearLayout ll_1;
    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;

    @BindView(R.id.btn4)
    Button btn4;

    @BindView(R.id.btn5)
    Button btn5;


    Fragment921_1 fragment921_1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_921);
        ButterKnife.bind(this);
//        setActionBar();
        toolbar.setTitle("921activity");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //-----------------
        ActionBarDrawerToggle toggle2 = new ActionBarDrawerToggle(this
                , drawerLayout, toolbar, 0, 0);
        drawerLayout.addDrawerListener(toggle2);
        toggle2.syncState();

        fragment921_1 = new Fragment921_1();
        loadRootFragment(R.id.fragment_container, fragment921_1);

        //全局改变Fragment的动画
        setFragmentAnimator(new DefaultHorizontalAnimator());
//提示下，fragment切换动画共有3种，无动画、横向和纵向切换，分别是DefaultNoAnimator、DefaultHorizontalAnimator和DefaultVerticalAnimator

        btn1.setOnClickListener(v -> {
            if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
                pop();
            } else {
                ActivityCompat.finishAfterTransition(this);
            }
//            loadRootFragment(R.id.fragment_container, new HomeFragment);
        });

        btn2.setOnClickListener(v -> {
//            start(new Fragment_921_2(), SINGLETASK);
            start(new Fragment922_1(), 2);
            //启动目标，并关闭当前
//            startWithPop();


            //查询所有
            List<Person> list = LitePal.findAll(Person.class);
            for (Person p : list) {
                Log.e("Newactivity921", "findAll : " + p);
            }
            //查询单个byid
            Person p = LitePal.find(Person.class, 1);
            Log.e("Newactivity921", "find : " + p);
            //查询by特定项
//            List<Person> ps = LitePal.where("name like ? and duration < ?", "song%", "200").order("duration").find(Person.class);
            List<Person> ps = LitePal.where("name = ?", "name1").find(Person.class);
            //查询所有
            for (Person pp : ps) {
                Log.e("Newactivity921", "findbyWhere : " + pp);
            }

        });

        btn3.setOnClickListener(v -> {
//            Person person = new Person(1, "2");
//            int i = person.updateAll("age=?", "2");
//            Log.e("Newactivity921", "person.updateAll num = : " + i);

            start(new Fragment922_2());
        });
        btn4.setOnClickListener(v -> {
            start(new Q54Fragment(), SINGLETASK);
        });
        btn5.setOnClickListener(v -> {
//            start(new Fragment_923_2());
//            start(new Fragment_923_4());
            Intent intent = new Intent(NewActivity921.this,Q62Activity.class);
            startActivity(intent);
        });

//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        View v= View.inflate()
//        builder.setView( v)



    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
