package com.lenovo.smarttraffic.bean;

import java.util.List;

public class GetBusStationInfoResult {

    /**
     * RESULT : S
     * ERRMSG : 查询成功
     * ROWS_DETAIL : [{"Distance":2250,"BusId":1},{"Distance":36450,"BusId":2}]
     */

    private String RESULT;
    private String ERRMSG;
    private List<ROWSDETAILBean> ROWS_DETAIL;

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

    public List<ROWSDETAILBean> getROWS_DETAIL() {
        return ROWS_DETAIL;
    }

    public void setROWS_DETAIL(List<ROWSDETAILBean> ROWS_DETAIL) {
        this.ROWS_DETAIL = ROWS_DETAIL;
    }

    @Override
    public String toString() {
        return "GetBusStationInfoResult{" +
                "RESULT='" + RESULT + '\'' +
                ", ERRMSG='" + ERRMSG + '\'' +
                ", ROWS_DETAIL=" + ROWS_DETAIL +
                '}';
    }

    public static class ROWSDETAILBean {
        /**
         * Distance : 2250
         * BusId : 1
         */

        private int Distance;
        private int BusId;

        public int getDistance() {
            return Distance;
        }

        public void setDistance(int Distance) {
            this.Distance = Distance;
        }

        public int getBusId() {
            return BusId;
        }

        public void setBusId(int BusId) {
            this.BusId = BusId;
        }

        @Override
        public String toString() {
            return "ROWSDETAILBean{" +
                    "Distance=" + Distance +
                    ", BusId=" + BusId +
                    '}';
        }
    }
}
