package com.lenovo.smarttraffic.bean;

public class SerachResult {

    /**
     * RESULT : S
     * ERRMSG : 成功
     * Balance : 966
     */

    private String RESULT;
    private String ERRMSG;
    private int Balance;

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

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int Balance) {
        this.Balance = Balance;
    }

    @Override
    public String toString() {
        return "SerachResult{" +
                "RESULT='" + RESULT + '\'' +
                ", ERRMSG='" + ERRMSG + '\'' +
                ", Balance=" + Balance +
                '}';
    }
}
