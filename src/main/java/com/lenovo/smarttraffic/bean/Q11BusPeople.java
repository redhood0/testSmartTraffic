package com.lenovo.smarttraffic.bean;

public class Q11BusPeople {
    int id;
    int peopleNum;

    public Q11BusPeople(int id, int peopleNum) {
        this.id = id;
        this.peopleNum = peopleNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(int peopleNum) {
        this.peopleNum = peopleNum;
    }
}
