package com.nettech.armsproject.bean;

import java.util.List;

/**
 * Created by ASUS on 2018/5/17.
 */

public class ProductBean {

    /**
     * id : 310
     * questionId : 152455282288073
     * answerId : null
     * productId : 46
     * score : 0
     * product : {"id":46,"name":"Lush 岚舒 洗头皂","minPrice":80,"maxPrice":100,"score":8.75,"favoriteCount":0,"evaluateCount":3,"viewCount":5,"shareCount":0,"infoUrl":"http://www.ibbtech.cn/product/66.html","type":0,"favorite":false,"category":{"id":1105,"name":"洗发","icon":"http://oss.ibbtech.cn/category/images_xifa@3x.png","sequence":1,"parentId":113,"children":null},"brand":{"id":979,"nameCn":"岚舒","nameEn":"LUSH","nation":"英国","type":2},"imgs":["http://image.ibbtech.cn/image/LUSH洗发皂.JPG"],"infos":[{"id":46,"name":"控油","productId":46}],"baseAttribute":[{"id":9,"name":"清洁度","score":0},{"id":128,"name":"深层滋养","score":7},{"id":129,"name":"修复效果","score":8},{"id":45,"name":"光泽度","score":10},{"id":130,"name":"去屑效果","score":0},{"id":6,"name":"性价比","score":0}]}
     * attrs : [{"id":403,"questionProductId":310,"attributeId":128,"score":0,"attribute":{"id":128,"name":"深层滋养"}},{"id":404,"questionProductId":310,"attributeId":129,"score":0,"attribute":{"id":129,"name":"修复效果"}},{"id":405,"questionProductId":310,"attributeId":45,"score":0,"attribute":{"id":45,"name":"光泽度"}}]
     */

    private int id;
    private long questionId;
    private Object answerId;
    private int productId;
    private float score;
    private Product product;
    private List<AttrsBean> attrs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public Object getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Object answerId) {
        this.answerId = answerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<AttrsBean> getAttrs() {
        return attrs;
    }

    public void setAttrs(List<AttrsBean> attrs) {
        this.attrs = attrs;
    }


    public static class AttrsBean {
        /**
         * id : 403
         * questionProductId : 310
         * attributeId : 128
         * score : 0
         * attribute : {"id":128,"name":"深层滋养"}
         */

        private int id;
        private int questionProductId;
        private int attributeId;
        private int score;
        private AttributeBean attribute;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getQuestionProductId() {
            return questionProductId;
        }

        public void setQuestionProductId(int questionProductId) {
            this.questionProductId = questionProductId;
        }

        public int getAttributeId() {
            return attributeId;
        }

        public void setAttributeId(int attributeId) {
            this.attributeId = attributeId;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public AttributeBean getAttribute() {
            return attribute;
        }

        public void setAttribute(AttributeBean attribute) {
            this.attribute = attribute;
        }

        public static class AttributeBean {
            /**
             * id : 128
             * name : 深层滋养
             */

            private int id;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
