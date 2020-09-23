package com.lenovo.smarttraffic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.Fragment932_3Bean;
import com.lenovo.smarttraffic.bean.ResultBean;
import com.lenovo.smarttraffic.util.CkyCoonUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Fragment_932_3 extends SupportFragment implements CkyCoonUtil.Mycallback {
    Unbinder unbinder;

    @BindView(R.id.gv)
    GridView gv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_923_3, container, false);
        Unbinder unbinder = ButterKnife.bind(this, v);
        doPost();
        initView();
        return v;
    }

    private void doPost() {
        String url = "http://192.168.50.158:8080/transportservice/action/GetBusInfo.do";
//        String obj = "{\"Line\":0,\"UserName\":\"user1\"}";
        HashMap<String, Object> obj = new HashMap<>();
        obj.put("Line", 0);
        obj.put("UserName", "user1");
        CkyCoonUtil.doPost(url, obj, ResultBean.class, this, 0);
    }

    private void initView() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void sendResult(Object obj, int type) {
        if (type == 0) {
            Log.e("sssss", "sendResult: >>>>>>>>");
            ResultBean resultBean = (ResultBean) obj;
            Log.e("sssss", "sendResult: " + resultBean.toString());

            List<Map<String, String>> arrays = new ArrayList<>();
            List<String> arrays2 = new ArrayList<>();
            for (Fragment932_3Bean fragment932_3Bean : resultBean.getROWS_DETAIL()) {
//                array.add(""+fragment932_3Bean.getId());
//                array.add(""+fragment932_3Bean.getName());
//                array.add(""+fragment932_3Bean.getMile());
//                array.add(""+fragment932_3Bean.getMoney());
                HashMap<String, String> hashMap1 = new HashMap<>();
                hashMap1.put("", "" + fragment932_3Bean.getId());
                HashMap<String, String> hashMap2 = new HashMap<>();
                hashMap2.put("", "" + fragment932_3Bean.getName());
                HashMap<String, String> hashMap3 = new HashMap<>();
                hashMap3.put("", "" + fragment932_3Bean.getMile());
                HashMap<String, String> hashMap4 = new HashMap<>();
                hashMap4.put("", "" + fragment932_3Bean.getMoney());

                arrays.add(hashMap1);
                arrays.add(hashMap2);
                arrays.add(hashMap3);
                arrays.add(hashMap4);

                arrays2.add("" + fragment932_3Bean.getId());
                arrays2.add("" + fragment932_3Bean.getName());
                arrays2.add("" + fragment932_3Bean.getMile());
                arrays2.add("" + fragment932_3Bean.getMoney());

            }
            String[] ss = {""};
            int[] ints = {R.id.tv};
            SimpleAdapter adapter = new SimpleAdapter(getContext(), arrays, R.layout.item_932_3, ss, ints);

            ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), R.layout.item_932_3,R.id.tv, arrays2);

            getActivity().runOnUiThread(() -> {
                gv.setAdapter(arrayAdapter);
            });


        }
    }
}
