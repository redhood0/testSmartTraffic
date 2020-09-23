package com.lenovo.smarttraffic.bean;

import java.util.List;

public class GetWeather {

    /**
     * ERRMSG : 成功
     * WCurrent : -11
     * ROWS_DETAIL : [{"temperature":"-9~-2","WData":"2020-01-28","type":"晴"},{"temperature":"-15~-7","WData":"2020-01-29","type":"阴"},{"temperature":"-11~-4","WData":"2020-01-30","type":"小雨"},{"temperature":"-11~-4","WData":"2020-01-31","type":"晴"},{"temperature":"-12~-4","WData":"2020-02-01","type":"晴"},{"temperature":"-10~-6","WData":"2020-02-02","type":"晴"}]
     * RESULT : S
     */

    private String ERRMSG;
    private int WCurrent;
    private String RESULT;
    private List<ROWSDETAILBean> ROWS_DETAIL;

    public String getERRMSG() {
        return ERRMSG;
    }

    public void setERRMSG(String ERRMSG) {
        this.ERRMSG = ERRMSG;
    }

    public int getWCurrent() {
        return WCurrent;
    }

    public void setWCurrent(int WCurrent) {
        this.WCurrent = WCurrent;
    }

    public String getRESULT() {
        return RESULT;
    }

    public void setRESULT(String RESULT) {
        this.RESULT = RESULT;
    }

    public List<ROWSDETAILBean> getROWS_DETAIL() {
        return ROWS_DETAIL;
    }

    public void setROWS_DETAIL(List<ROWSDETAILBean> ROWS_DETAIL) {
        this.ROWS_DETAIL = ROWS_DETAIL;
    }

    public static class ROWSDETAILBean {
        /**
         * temperature : -9~-2
         * WData : 2020-01-28
         * type : 晴
         */

        private String temperature;
        private String WData;
        private String type;

        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }

        public String getWData() {
            return WData;
        }

        public void setWData(String WData) {
            this.WData = WData;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "ROWSDETAILBean{" +
                    "temperature='" + temperature + '\'' +
                    ", WData='" + WData + '\'' +
                    ", type='" + type + '\'' +
                    '}';
        }
    }
}
