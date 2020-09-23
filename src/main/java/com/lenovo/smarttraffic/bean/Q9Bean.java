package com.lenovo.smarttraffic.bean;

public class Q9Bean {
    int num;
    int chepaiImg;
    String chepai;
    int yue;
    boolean checked;

    public Q9Bean(int num, int chepaiImg, String chepai, int yue, boolean checked) {
        this.num = num;
        this.chepaiImg = chepaiImg;
        this.chepai = chepai;
        this.yue = yue;
        this.checked = checked;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getChepaiImg() {
        return chepaiImg;
    }

    public void setChepaiImg(int chepaiImg) {
        this.chepaiImg = chepaiImg;
    }

    public String getChepai() {
        return chepai;
    }

    public void setChepai(String chepai) {
        this.chepai = chepai;
    }

    public int getYue() {
        return yue;
    }

    public void setYue(int yue) {
        this.yue = yue;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
