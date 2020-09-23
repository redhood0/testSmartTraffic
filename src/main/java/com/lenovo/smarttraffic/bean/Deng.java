package com.lenovo.smarttraffic.bean;

public class Deng {
    int id;
    int redTime;
    int yellowTime;
    int greenTime;

    public Deng(int id, int redTime, int yellowTime, int greenTime) {
        this.id = id;
        this.redTime = redTime;
        this.yellowTime = yellowTime;
        this.greenTime = greenTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRedTime() {
        return redTime;
    }

    public void setRedTime(int redTime) {
        this.redTime = redTime;
    }

    public int getYellowTime() {
        return yellowTime;
    }

    public void setYellowTime(int yellowTime) {
        this.yellowTime = yellowTime;
    }

    public int getGreenTime() {
        return greenTime;
    }

    public void setGreenTime(int greenTime) {
        this.greenTime = greenTime;
    }
}
