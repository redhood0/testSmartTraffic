package com.lenovo.smarttraffic.bean;

public class Q18Bean {
    String type;
    int yuzhi;
    int now;

    public Q18Bean(String type, int yuzhi, int now) {
        this.type = type;
        this.yuzhi = yuzhi;
        this.now = now;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYuzhi() {
        return yuzhi;
    }

    public void setYuzhi(int yuzhi) {
        this.yuzhi = yuzhi;
    }

    public int getNow() {
        return now;
    }

    public void setNow(int now) {
        this.now = now;
    }
}
