package com.lenovo.smarttraffic.bean;

public class ReqBean1 {

    /**
     * CarId : 1
     * UserName : user1
     */

    private int CarId;
    private String UserName;

    public ReqBean1(int carId, String userName) {
        CarId = carId;
        UserName = userName;
    }

    public int getCarId() {
        return CarId;
    }

    public void setCarId(int CarId) {
        this.CarId = CarId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }
}
