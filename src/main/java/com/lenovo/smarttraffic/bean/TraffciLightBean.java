package com.lenovo.smarttraffic.bean;

public class TraffciLightBean {
    int lukou;
    int redtime;
    int yellowtime;
    int greentime;

    public TraffciLightBean(int lukou, int redtime, int yellowtime, int greentime) {
        this.lukou = lukou;
        this.redtime = redtime;
        this.yellowtime = yellowtime;
        this.greentime = greentime;
    }

    public int getLukou() {
        return lukou;
    }

    public void setLukou(int lukou) {
        this.lukou = lukou;
    }

    public int getRedtime() {
        return redtime;
    }

    public void setRedtime(int redtime) {
        this.redtime = redtime;
    }

    public int getYellowtime() {
        return yellowtime;
    }

    public void setYellowtime(int yellowtime) {
        this.yellowtime = yellowtime;
    }

    public int getGreentime() {
        return greentime;
    }

    public void setGreentime(int greentime) {
        this.greentime = greentime;
    }
}
