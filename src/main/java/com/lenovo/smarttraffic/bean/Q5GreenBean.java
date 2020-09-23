package com.lenovo.smarttraffic.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

import java.util.Date;

@Entity
public class Q5GreenBean {
    @Id(autoincrement  = true)
    Long id;

    int wendu;
    int shidu;
    int guangzhao;
    int cq2;
    int pm;
    int tfStatus;
    Date date;
    @Generated(hash = 843362581)
    public Q5GreenBean(Long id, int wendu, int shidu, int guangzhao, int cq2,
            int pm, int tfStatus, Date date) {
        this.id = id;
        this.wendu = wendu;
        this.shidu = shidu;
        this.guangzhao = guangzhao;
        this.cq2 = cq2;
        this.pm = pm;
        this.tfStatus = tfStatus;
        this.date = date;
    }
    @Generated(hash = 2062348294)
    public Q5GreenBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getWendu() {
        return this.wendu;
    }
    public void setWendu(int wendu) {
        this.wendu = wendu;
    }
    public int getShidu() {
        return this.shidu;
    }
    public void setShidu(int shidu) {
        this.shidu = shidu;
    }
    public int getGuangzhao() {
        return this.guangzhao;
    }
    public void setGuangzhao(int guangzhao) {
        this.guangzhao = guangzhao;
    }
    public int getCq2() {
        return this.cq2;
    }
    public void setCq2(int cq2) {
        this.cq2 = cq2;
    }
    public int getPm() {
        return this.pm;
    }
    public void setPm(int pm) {
        this.pm = pm;
    }
    public int getTfStatus() {
        return this.tfStatus;
    }
    public void setTfStatus(int tfStatus) {
        this.tfStatus = tfStatus;
    }
    public Date getDate() {
        return this.date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Q5GreenBean{" +
                "id=" + id +
                ", wendu=" + wendu +
                ", shidu=" + shidu +
                ", guangzhao=" + guangzhao +
                ", cq2=" + cq2 +
                ", pm=" + pm +
                ", tfStatus=" + tfStatus +
                ", date=" + date +
                '}';
    }
}
