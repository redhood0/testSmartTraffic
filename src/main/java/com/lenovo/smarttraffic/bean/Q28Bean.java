package com.lenovo.smarttraffic.bean;

import java.util.List;

public class Q28Bean {
    String group;
    List<String> childs;

    public Q28Bean(String group, List<String> childs) {
        this.group = group;
        this.childs = childs;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<String> getChilds() {
        return childs;
    }

    public void setChilds(List<String> childs) {
        this.childs = childs;
    }
}
