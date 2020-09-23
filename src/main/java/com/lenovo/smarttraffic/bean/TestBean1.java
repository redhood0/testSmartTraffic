package com.lenovo.smarttraffic.bean;

public class TestBean1 {

    /**
     * Balance : 100
     * RESULT : S
     * ERRMSG : 成功
     */

    private int Balance;
    private String RESULT;
    private String ERRMSG;

    public TestBean1(String ERRMSG) {
        this.ERRMSG = ERRMSG;
    }

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int Balance) {
        this.Balance = Balance;
    }

    public String getRESULT() {
        return RESULT;
    }

    public void setRESULT(String RESULT) {
        this.RESULT = RESULT;
    }

    public String getERRMSG() {
        return ERRMSG;
    }

    public void setERRMSG(String ERRMSG) {
        this.ERRMSG = ERRMSG;
    }

    @Override
    public String toString() {
        return "TestBean1{" +
                "Balance=" + Balance +
                ", RESULT='" + RESULT + '\'' +
                ", ERRMSG='" + ERRMSG + '\'' +
                '}';
    }
}
