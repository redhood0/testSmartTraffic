package com.lenovo.smarttraffic.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.lenovo.smarttraffic.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Q62Activity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.AppBarLayout01)
    AppBarLayout AppBarLayout01;
    @BindView(R.id.radar)
    RadarChart radar;

    @Override
    protected int getLayout() {
        return R.layout.activity_q62;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        initToolBar(toolbar,true,"违章类型分析");

        initview();
    }

    private void initview() {
        setChartData2_2();
    }

    private void setChartData2_2() {
//        List<IRadarDataSet> dataSets = new ArrayList<>();
//        List<RadarEntry> yVals = new ArrayList<>();
//
//        RadarDataSet radarDataSet = new RadarDataSet(yVals,"xxx");
//        dataSets.add(radarDataSet);
//
//        RadarData radarData = new RadarData();
        /* RadarData的无参构造方法 */
//        RadarData data = new RadarData();
//        data.addDataSet(creatingData("学习驾驶人不按指定时间上盗录学习驾驶的"));
//        data.addDataSet(creatingData("拖拉机驶入大中城市中心城区内道路的"));
        /* RadarData的不限参数的构造方法 */
//        RadarData data = new RadarData(
//                creatingData("驾驶摩托车在车把上悬挂物品的"),
//                creatingData("拖拉机驶入大中城市中心城区内道路的"),
//                creatingData("拖拉机违法规定载人的"),
//                creatingData("拖拉机牵引多辆挂车的"),
//                creatingData("学习驾驶人不按指定时间上盗录学习驾驶的")
//        );
        /* RadarData的List类型参数的构造方法 */
        List<IRadarDataSet> dataSets = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("力量");
        strings.add("防御");
        strings.add("速度");
        strings.add("血量");
        strings.add("法力");
        strings.add("幸运");
        dataSets.add(creatingData("驾驶摩托车在车把上悬挂物品的",Color.BLUE));
        dataSets.add(createData2("拖拉机驶入大中城市中心城区内道路的",Color.YELLOW));
        dataSets.add(createData2("拖拉机违法规定载人的",Color.GREEN));
        dataSets.add(createData2("拖拉机牵引多辆挂车的",Color.GRAY));
        dataSets.add(createData2("学习驾驶人不按指定时间上盗录学习驾驶的",Color.RED));

        dataSets.add(createData3(""));

        RadarData data = new RadarData(dataSets);

        radar.setData(data);
        radar.getYAxis().setAxisMaximum(80f);
        radar.getYAxis().setLabelCount(5,false);
        radar.getYAxis().setMinWidth(0);
        radar.setPadding(300,300,300,300);


//        radar.offsetTopAndBottom(140);
//        radar.offsetLeftAndRight(140);
       Legend legend = radar.getLegend();
       legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);

       radar.setRotationEnabled(false);
        radar.animateXY(1400, 1400);

//        List<IRadarDataSet> dataSets = new ArrayList<>();
//        RadarDataSet radarDataSet = new RadarDataSet();
//        dataSets.add()
//        RadarData data= new RadarData(dataSets);
//        radar.setData(data);

    }

    private IRadarDataSet createData3(String s) {
        List<RadarEntry> yVals = new ArrayList<>();
        RadarEntry radarEntry = new RadarEntry(100f);

        radarEntry.setIcon(getResources().getDrawable(R.drawable.dot));
        yVals.add(radarEntry);
        yVals.add(radarEntry);
        yVals.add(radarEntry);
        yVals.add(radarEntry);
        yVals.add(radarEntry);
        RadarDataSet radarDataSet = new RadarDataSet(yVals,"");
        radarDataSet.setColor(Color.TRANSPARENT);

        return radarDataSet;
    }


    /**
     * 创建虚拟图表数据
     * @param lable 数据标签
     * @return
     */
    private RadarDataSet creatingData(String lable,int color) {
        List<RadarEntry> yVals = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            yVals.add(new RadarEntry((float) (Math.random() * 100))); // 生成1-100的随机数
        }
        RadarDataSet ds = new RadarDataSet(yVals,"");

        List<RadarEntry> values = new ArrayList<>();
        for(int i = 0; i < 5 ; i++){
            RadarEntry radarEntry = new RadarEntry((float) Math.random()*100);
            radarEntry.setIcon(getResources().getDrawable(R.drawable.shape_round));
            values.add(radarEntry);

        }
        RadarDataSet radarDataSet = new RadarDataSet(values,lable);
        radarDataSet.setLabel("");

        radarDataSet.setColor(color,40);
        radarDataSet.setDrawFilled(true);
        radarDataSet.setFillColor(color);
        radarDataSet.setFillAlpha(40);
        return radarDataSet;
    }

    public RadarDataSet createData2(String label,int color){
        List<RadarEntry> yVals = new ArrayList<>();
        yVals.add(new RadarEntry(0));
        yVals.add(new RadarEntry(0));
        yVals.add(new RadarEntry(0));
        yVals.add(new RadarEntry(0));
        yVals.add(new RadarEntry(0));
        RadarDataSet radarDataSet = new RadarDataSet(yVals,label);
        radarDataSet.setColor(color);
        return radarDataSet;

    }



}
