package com.lenovo.smarttraffic.bean;

public class ChongzhiRecoder {
    String chepai;
    int money;
    String date;

    @Override
    public String toString() {
        return "ChongzhiRecoder{" +
                "chepai='" + chepai + '\'' +
                ", money=" + money +
                ", date='" + date + '\'' +
                '}';
    }

    public String getChepai() {
        return chepai;
    }

    public void setChepai(String chepai) {
        this.chepai = chepai;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
