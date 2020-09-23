package com.lenovo.smarttraffic.bean;

public class AccountSearch {

    /**
     * CarId : 2
     * UserName : user1
     */

    private int CarId;
    private String UserName;

    public AccountSearch(int carId, String userName) {
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
