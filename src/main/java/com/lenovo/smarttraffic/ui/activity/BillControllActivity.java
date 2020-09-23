package com.lenovo.smarttraffic.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

import com.lenovo.smarttraffic.InitApp;
import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.ChongZhiRecord;
import com.lenovo.smarttraffic.greendao.ChongZhiRecordDao;
import com.lenovo.smarttraffic.greendao.DaoSession;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;

public class BillControllActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    //    @BindView(R.id.AppBarLayout01)
//    AppBarLayout AppBarLayout01;
    @BindView(R.id.sp_time_order)
    Spinner spTimeOrder;
    @BindView(R.id.btn_search)
    Button btnSearch;
    @BindView(R.id.gv_recoder)
    GridView gvRecoder;
    @BindView(R.id.tv_none)
    TextView tv_none;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initToolBar(toolbar, true, "账单管理");

        initCompent();

    }

    private void initCompent() {
        ArrayList<String> list = new ArrayList<>(2);
        list.add("时间升序");
        list.add("时间降序");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this, R.layout.spinner_item, R.id.tv_spinner, list);

        spTimeOrder.setAdapter(arrayAdapter);
        search(0);

        btnSearch.setOnClickListener(v -> {
            int po = spTimeOrder.getSelectedItemPosition();
            if(po == 0){
                search(0);
            }else {
                search(1);
            }
        });
    }

    private void search(int type) {
        DaoSession daoSession = InitApp.getDaoSession();
        ChongZhiRecordDao dao = daoSession.getChongZhiRecordDao();
        List<ChongZhiRecord> recordList = dao.loadAll();
        //Log.e("sss", "search: "+ recordList.size() );
        initGridView(recordList,type);
    }

    private void initGridView(List<ChongZhiRecord> recordList,int type) {
        if (recordList.size() == 0) {
            tv_none.setVisibility(View.VISIBLE);
            return;
        } else {
            tv_none.setVisibility(View.GONE);
            List<String> gridcontrnt = new ArrayList<>();
            gridcontrnt.add("序号");
            gridcontrnt.add("车号");
            gridcontrnt.add("充值金额");
            gridcontrnt.add("操作人");
            gridcontrnt.add("充值时间");
            int i = 1;
            if(type == 1) {
                Collections.reverse(recordList);
            }

            for(ChongZhiRecord record : recordList){
                gridcontrnt.add(String.valueOf(i));
                i++;
                gridcontrnt.add(String.valueOf(record.getCarId()));
                gridcontrnt.add(String.valueOf(record.getMoney()));
                gridcontrnt.add(record.getUsername());
                gridcontrnt.add(record.getTime());
            }

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter(
                        this,R.layout.spinner_item,R.id.tv_spinner,gridcontrnt);
                gvRecoder.setAdapter(arrayAdapter);
        }
    }

    private void deleteAll() {
        DaoSession daoSession = InitApp.getDaoSession();
        ChongZhiRecordDao dao = daoSession.getChongZhiRecordDao();
        dao.deleteAll();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_bill_controll;
    }
}
