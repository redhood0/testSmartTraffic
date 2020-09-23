package com.lenovo.smarttraffic.bean;

import com.lenovo.smarttraffic.ui.fragment.Fragment_932_3;

import java.util.List;

public class ResultBean {
    String ERRMSG;
    String RUSULT;
    List<Fragment932_3Bean> ROWS_DETAIL;

    public String getERRMSG() {
        return ERRMSG;
    }

    public void setERRMSG(String ERRMSG) {
        this.ERRMSG = ERRMSG;
    }

    public String getRUSULT() {
        return RUSULT;
    }

    public void setRUSULT(String RUSULT) {
        this.RUSULT = RUSULT;
    }

    public List<Fragment932_3Bean> getROWS_DETAIL() {
        return ROWS_DETAIL;
    }

    public void setROWS_DETAIL(List<Fragment932_3Bean> ROWS_DETAIL) {
        this.ROWS_DETAIL = ROWS_DETAIL;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "ERRMSG='" + ERRMSG + '\'' +
                ", RUSULT='" + RUSULT + '\'' +
                ", ROWS_DETAIL=" + ROWS_DETAIL +
                '}';
    }
}
