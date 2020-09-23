package com.lenovo.smarttraffic.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

//记录车辆号、充值金额、操作人、时间。
@Entity
public class ChongZhiRecord {
    @Id(autoincrement  = true)
    Long id;

    int carId;
    int money;
    String username;
    String time;
    @Generated(hash = 29214381)
    public ChongZhiRecord(Long id, int carId, int money, String username,
            String time) {
        this.id = id;
        this.carId = carId;
        this.money = money;
        this.username = username;
        this.time = time;
    }
    @Generated(hash = 266281005)
    public ChongZhiRecord() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getCarId() {
        return this.carId;
    }
    public void setCarId(int carId) {
        this.carId = carId;
    }
    public int getMoney() {
        return this.money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    
}
