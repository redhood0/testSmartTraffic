package com.lenovo.smarttraffic.bean;

import org.litepal.LitePal;
import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

public class PersonA extends LitePalSupport {
    @Column()
    String name;

    public static void main(String[] args) {
        PersonA personA = new PersonA();
        personA.save();

        personA.update(0);

        LitePal.where("name=?","aa").find(PersonA.class);
        LitePal.deleteAll(PersonA.class,"name=?","a");
    }

}
