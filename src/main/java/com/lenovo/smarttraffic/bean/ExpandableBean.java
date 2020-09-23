package com.lenovo.smarttraffic.bean;

public class ExpandableBean {
    private String carNUm;
    private int num;
    private int minute;
    private int distance;

    public ExpandableBean() {
    }

    public ExpandableBean(String carNUm, int num, int minute, int distance) {
        this.carNUm = carNUm;
        this.num = num;
        this.minute = minute;
        this.distance = distance;
    }

    public String getCarNUm() {
        return carNUm;
    }

    public void setCarNUm(String carNUm) {
        this.carNUm = carNUm;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
