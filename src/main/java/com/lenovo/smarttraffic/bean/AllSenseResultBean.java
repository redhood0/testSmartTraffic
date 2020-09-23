package com.lenovo.smarttraffic.bean;

import com.google.gson.annotations.SerializedName;

public class AllSenseResultBean {

    /**
     * RESULT : S
     * ERRMSG : 成功
     * pm2.5 : 8
     * co2 : 5919
     * LightIntensity : 1711
     * humidity : 44
     * temperature : 28
     */

    private String RESULT;
    private String ERRMSG;
    @SerializedName("pm2.5")
    private int _$Pm25190; // FIXME check this code
    private int co2;
    private int LightIntensity;
    private int humidity;
    private int temperature;

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

    public int get_$Pm25190() {
        return _$Pm25190;
    }

    public void set_$Pm25190(int _$Pm25190) {
        this._$Pm25190 = _$Pm25190;
    }

    public int getCo2() {
        return co2;
    }

    public void setCo2(int co2) {
        this.co2 = co2;
    }

    public int getLightIntensity() {
        return LightIntensity;
    }

    public void setLightIntensity(int LightIntensity) {
        this.LightIntensity = LightIntensity;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "AllSenseResultBean{" +
                "RESULT='" + RESULT + '\'' +
                ", ERRMSG='" + ERRMSG + '\'' +
                ", _$Pm25190=" + _$Pm25190 +
                ", co2=" + co2 +
                ", LightIntensity=" + LightIntensity +
                ", humidity=" + humidity +
                ", temperature=" + temperature +
                '}';
    }
}
