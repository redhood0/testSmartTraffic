package com.lenovo.smarttraffic.bean;

public class Fragment932_3Bean {
    int id;
    String name;
    String mile;
    int money;

    public Fragment932_3Bean(int id, String name, String mile, int money) {
        this.id = id;
        this.name = name;
        this.mile = mile;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMile() {
        return mile;
    }

    public void setMile(String mile) {
        this.mile = mile;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Fragment932_3Bean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mile='" + mile + '\'' +
                ", money=" + money +
                '}';
    }
}
