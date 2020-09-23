package com.lenovo.smarttraffic.bean;

import java.util.List;

public class GetCarParkConsumptionRecord {

    /**
     * ERRMSG : 成功
     * ROWS_DETAIL : [{"Id":1,"CarId":1,"InTime":"2017-06-04 03:19:21","OutTime":"2017-06-04 04:19:21","Money":5,"CarParkId":1},{"Id":2,"CarId":1,"InTime":"2017-06-04 04:19:20","OutTime":"2017-06-05 04:19:21","Money":4,"CarParkId":1},{"Id":3,"CarId":3,"InTime":"2018-05-20 21:30:59","OutTime":"2018-05-21 04:30:59","Money":30,"CarParkId":1},{"Id":4,"CarId":2,"InTime":"2016-05-20 21:30:59","OutTime":"2016-05-21 05:30:59","Money":10,"CarParkId":1},{"Id":5,"CarId":2,"InTime":"2013-05-20 21:30:59","OutTime":"2013-05-21 03:30:59","Money":10,"CarParkId":1},{"Id":6,"CarId":1,"InTime":"2017-05-20 21:30:59","OutTime":"2017-05-21 03:30:59","Money":20,"CarParkId":1},{"Id":7,"CarId":1,"InTime":"2016-05-20 21:30:59","OutTime":"2016-05-21 07:30:59","Money":20,"CarParkId":1},{"Id":8,"CarId":1,"InTime":"2017-05-20 21:30:59","OutTime":"2017-05-21 07:30:59","Money":10,"CarParkId":1},{"Id":9,"CarId":1,"InTime":"2017-05-20 21:30:59","OutTime":"2017-05-21 01:30:59","Money":10,"CarParkId":1},{"Id":10,"CarId":1,"InTime":"2017-05-20 21:30:59","OutTime":"2017-05-21 07:30:59","Money":10,"CarParkId":2},{"Id":11,"CarId":1,"InTime":"2017-05-20 21:30:59","OutTime":"2017-05-20 22:30:59","Money":10,"CarParkId":2},{"Id":12,"CarId":1,"InTime":"2017-05-20 21:30:59","OutTime":"2017-05-20 22:30:59","Money":10,"CarParkId":2},{"Id":13,"CarId":1,"InTime":"2017-05-20 21:30:59","OutTime":"2017-05-20 22:30:59","Money":10,"CarParkId":2},{"Id":14,"CarId":1,"InTime":"2018-05-20 21:31:20","OutTime":"2018-05-20 22:31:20","Money":10,"CarParkId":1},{"Id":15,"CarId":1,"InTime":"2017-05-20 21:30:59","OutTime":"2017-05-20 23:30:59","Money":10,"CarParkId":2},{"Id":16,"CarId":1,"InTime":"2016-06-04 03:19:21","OutTime":"2016-06-04 06:19:21","Money":4,"CarParkId":3},{"Id":19,"CarId":1,"InTime":"2017-06-02 03:19:21","OutTime":"2017-06-02 07:19:21","Money":4,"CarParkId":1},{"Id":20,"CarId":1,"InTime":"2015-06-03 03:19:21","OutTime":"2015-06-03 06:19:21","Money":4,"CarParkId":2}]
     * RESULT : S
     */

    private String ERRMSG;
    private String RESULT;
    private List<ROWSDETAILBean> ROWS_DETAIL;

    public String getERRMSG() {
        return ERRMSG;
    }

    public void setERRMSG(String ERRMSG) {
        this.ERRMSG = ERRMSG;
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
         * Id : 1
         * CarId : 1
         * InTime : 2017-06-04 03:19:21
         * OutTime : 2017-06-04 04:19:21
         * Money : 5
         * CarParkId : 1
         */

        private int Id;
        private int CarId;
        private String InTime;
        private String OutTime;
        private int Money;
        private int CarParkId;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public int getCarId() {
            return CarId;
        }

        public void setCarId(int CarId) {
            this.CarId = CarId;
        }

        public String getInTime() {
            return InTime;
        }

        public void setInTime(String InTime) {
            this.InTime = InTime;
        }

        public String getOutTime() {
            return OutTime;
        }

        public void setOutTime(String OutTime) {
            this.OutTime = OutTime;
        }

        public int getMoney() {
            return Money;
        }

        public void setMoney(int Money) {
            this.Money = Money;
        }

        public int getCarParkId() {
            return CarParkId;
        }

        public void setCarParkId(int CarParkId) {
            this.CarParkId = CarParkId;
        }
    }
}
