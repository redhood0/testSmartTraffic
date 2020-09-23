package com.lenovo.smarttraffic.bean;

public class TrafficLightSearchBean {


    public TrafficLightSearchBean(String trafficLightId, String userName) {
        TrafficLightId = trafficLightId;
        UserName = userName;
    }

    /**
     * TrafficLightId : 2
     * UserName : user1
     */

    private String TrafficLightId;
    private String UserName;

    public String getTrafficLightId() {
        return TrafficLightId;
    }

    public void setTrafficLightId(String TrafficLightId) {
        this.TrafficLightId = TrafficLightId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }
}
