package com.lenovo.smarttraffic.bean;

import java.util.List;

public class GetNewsInfo {

    /**
     * RUSULT : S
     * ERRMSG : 成功
     * ROWS_DETAIL : [{"id":1,"category":1,"title":"新 闻标题","content":"新闻内容","createtime":"2017-06-03 14:19:21"},{"id":1,"category":1,"title":"新 闻标题","content":"新闻内容","createtime":"2017-06-03 14:19:21"}]
     */

    private String RUSULT;
    private String ERRMSG;
    private List<ROWSDETAILBean> ROWS_DETAIL;

    public String getRUSULT() {
        return RUSULT;
    }

    public void setRUSULT(String RUSULT) {
        this.RUSULT = RUSULT;
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

    public static class ROWSDETAILBean {
        /**
         * id : 1
         * category : 1
         * title : 新 闻标题
         * content : 新闻内容
         * createtime : 2017-06-03 14:19:21
         */

        private int id;
        private int category;
        private String title;
        private String content;
        private String createtime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCategory() {
            return category;
        }

        public void setCategory(int category) {
            this.category = category;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }
    }
}

