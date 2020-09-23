package com.lenovo.smarttraffic.bean;

public class AccountAdd {

    /**
     * CarId : 1
     * Money : 200
     * UserName : user1
     */

    private int CarId;
    private int Money;
    private String UserName;

    public AccountAdd(int carId, int money, String userName) {
        CarId = carId;
        Money = money;
        UserName = userName;
    }

    public int getCarId() {
        return CarId;
    }

    public void setCarId(int CarId) {
        this.CarId = CarId;
    }

    public int getMoney() {
        return Money;
    }

    public void setMoney(int Money) {
        this.Money = Money;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }
}
