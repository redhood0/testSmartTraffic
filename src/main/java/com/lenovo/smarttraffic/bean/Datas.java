package com.lenovo.smarttraffic.bean;

import com.lenovo.smarttraffic.R;

import java.util.ArrayList;
import java.util.List;

public  class Datas {
    public static List<Q64Bean> beans = new ArrayList<>();
    public static List<Q64Recoder> recoders = new ArrayList<>();

    static {
        beans.add(new Q64Bean(1, "苏A00000", "张三", 0, R.mipmap.benchi));
        beans.add(new Q64Bean(2, "苏A00001", "张四", 0, R.mipmap.baoma));
        beans.add(new Q64Bean(3, "苏A00002", "张三", 0, R.mipmap.benchi));

    }
}
