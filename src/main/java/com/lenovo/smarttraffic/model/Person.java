package com.lenovo.smarttraffic.model;

import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;
public class Person extends LitePalSupport {
    @Column(unique = true)
   private int age = 0;
    private String name = "sb";

    public Person() {
    }

    public Person(int id, String name) {
        this.age = id;
        this.name = name;
    }

    public int getId() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.age = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
