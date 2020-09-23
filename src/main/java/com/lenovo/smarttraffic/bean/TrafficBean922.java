package com.lenovo.smarttraffic.bean;

public class TrafficBean922 {
    String lukou;
    String redtime;
    String yellowtime;
    String greentime;

    public TrafficBean922(String lukou, String redtime, String yellowtime, String greentime) {
        this.lukou = lukou;
        this.redtime = redtime;
        this.yellowtime = yellowtime;
        this.greentime = greentime;
    }

    public TrafficBean922() {
    }

    public void setLukou(String lukou) {
        this.lukou = lukou;
    }

    public void setRedtime(String redtime) {
        this.redtime = redtime;
    }

    public void setYellowtime(String yellowtime) {
        this.yellowtime = yellowtime;
    }

    public void setGreentime(String greentime) {
        this.greentime = greentime;
    }

    public String getLukou() {
        return lukou;
    }

    public String getRedtime() {
        return redtime;
    }

    public String getYellowtime() {
        return yellowtime;
    }

    public String getGreentime() {
        return greentime;
    }
}
