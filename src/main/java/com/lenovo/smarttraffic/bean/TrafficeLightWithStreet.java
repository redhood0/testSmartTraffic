package com.lenovo.smarttraffic.bean;

public class TrafficeLightWithStreet {
    TrafficLightBean tl;
    int StreetId;

    public TrafficeLightWithStreet(TrafficLightBean tl, int streetId) {
        this.tl = tl;
        StreetId = streetId;
    }

    public TrafficLightBean getTl() {
        return tl;
    }

    public void setTl(TrafficLightBean tl) {
        this.tl = tl;
    }

    public int getStreetId() {
        return StreetId;
    }

    public void setStreetId(int streetId) {
        StreetId = streetId;
    }
}
