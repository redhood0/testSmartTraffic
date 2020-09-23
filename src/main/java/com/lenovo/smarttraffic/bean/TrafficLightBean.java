package com.lenovo.smarttraffic.bean;

public class TrafficLightBean {

    /**
     * YellowTime : 5
     * GreenTime : 5
     * RedTime : 5
     * RESULT : S
     * ERRMSG : 成功
     */

    private int YellowTime;
    private int GreenTime;
    private int RedTime;
    private String RESULT;
    private String ERRMSG;


    public int getYellowTime() {
        return YellowTime;
    }

    public void setYellowTime(int YellowTime) {
        this.YellowTime = YellowTime;
    }

    public int getGreenTime() {
        return GreenTime;
    }

    public void setGreenTime(int GreenTime) {
        this.GreenTime = GreenTime;
    }

    public int getRedTime() {
        return RedTime;
    }

    public void setRedTime(int RedTime) {
        this.RedTime = RedTime;
    }

    public String getRESULT() {
        return RESULT;
    }

    public void setRESULT(String RESULT) {
        this.RESULT = RESULT;
    }

    public String getERRMSG() {
        return ERRMSG;
    }

    public void setERRMSG(String ERRMSG) {
        this.ERRMSG = ERRMSG;
    }

    @Override
    public String toString() {
        return "TrafficLightBean{" +
                "YellowTime=" + YellowTime +
                ", GreenTime=" + GreenTime +
                ", RedTime=" + RedTime +
                ", RESULT='" + RESULT + '\'' +
                ", ERRMSG='" + ERRMSG + '\'' +
                '}';
    }
}
