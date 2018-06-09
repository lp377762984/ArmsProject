package com.nettech.armsproject.bean;

import java.util.List;

/**
 * Created by ASUS on 2018/5/17.
 */

public class AnswerBean {
    /**
     * id : 76
     * content : 在一起的时候真的有点难过！我的手机号码已经收到没有什么时候可以发信息啦？我在外面玩手的你知道我不想你了，我们的生活方式是什么时候回来呀，你的人生态度就是这样吧
     * questionId : 152455282288073
     * likeCount : 1
     * replyCount : 0
     * favoriteCount : 0
     * shareCount : 0
     * viewCount : 3
     * time : 1524553013000
     * like : false
     * favorite : false
     * user : {"id":34183373848578,"nickname":"测试人员111","portrait":"http://image.ibbtech.cn/image/8b648aa9-557c-4c23-811f-016c95cfe8de.jpg","signature":"签名不知道怎么填","location":"北京市 北京市 房山区","sex":1,"relation":0}
     * myProducts : []
     * questionProducts : []
     * relateQuestions : []
     */

    private int id;
    private String title;
    private String content;
    private long questionId;
    private int likeCount;
    private int replyCount;
    private int favoriteCount;
    private int shareCount;
    private int viewCount;
    private long time;
    private boolean like;
    private boolean favorite;
    private User user;
    private List<ProductBean> myProducts;
    private List<ProductBean> questionProducts;
    private List<QuestionBean> relateQuestions;
    private List<Attr> attrs;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ProductBean> getQuestionProducts() {
        return questionProducts;
    }

    public void setQuestionProducts(List<ProductBean> questionProducts) {
        this.questionProducts = questionProducts;
    }

    public List<Attr> getAttrs() {
        return attrs;
    }

    public void setAttrs(List<Attr> attrs) {
        this.attrs = attrs;
    }

    public AnswerBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public int getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(int favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ProductBean> getMyProducts() {
        return myProducts;
    }

    public void setMyProducts(List<ProductBean> myProducts) {
        this.myProducts = myProducts;
    }

    public List<QuestionBean> getRelateQuestions() {
        return relateQuestions;
    }

    public void setRelateQuestions(List<QuestionBean> relateQuestions) {
        this.relateQuestions = relateQuestions;
    }

    public static class Attr{

        /**
         * id : 406
         * questionProductId : 311
         * attributeId : 128
         * score : 8
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
