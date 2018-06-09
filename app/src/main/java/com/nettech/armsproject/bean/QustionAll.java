package com.nettech.armsproject.bean;

import java.util.List;

/**
 * Created by ASUS on 2018/6/5.
 */

public class QustionAll {
    private MetaBean meta;
    private List<QuestionBean> data;
    public static class MetaBean {
        /**
         * success : true
         * message : ok
         */

        private boolean success;
        private String message;

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return "MetaBean{" +
                    "success=" + success +
                    ", message='" + message + '\'' +
                    '}';
        }
    }

    public MetaBean getMeta() {
        return meta;
    }

    public void setMeta(MetaBean meta) {
        this.meta = meta;
    }

    public List<QuestionBean> getData() {
        return data;
    }

    public void setData(List<QuestionBean> data) {
        this.data = data;
    }
}
