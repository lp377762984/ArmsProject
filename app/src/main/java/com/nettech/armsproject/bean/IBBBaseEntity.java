package com.nettech.armsproject.bean;

/**
 * Created by ASUS on 2018/5/11.
 */

public class IBBBaseEntity<T> {
    public IBBBaseEntity(MetaBean meta, T data) {
        this.meta = meta;
        this.data = data;
    }

    private MetaBean meta;
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public MetaBean getMeta() {
        return meta;
    }

    public void setMeta(MetaBean meta) {
        this.meta = meta;
    }

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

    @Override
    public String toString() {
        return "HttpBaseEntity{" +
                "meta=" + meta +
                ", data=" + data +
                '}';
    }
}
