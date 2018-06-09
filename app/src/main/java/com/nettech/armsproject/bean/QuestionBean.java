package com.nettech.armsproject.bean;

import java.util.List;

/**
 * Created by ASUS on 2018/5/15.
 */

public class QuestionBean {

    /**
     * id : 152455282288073
     * state : 0
     * time : 1524552822000
     * title : 这不是一家烤肉店吗？桌子上怎么没有烤炉.大家有什么推荐的吗？
     * content : 这不是一家烤肉店吗？桌子上怎么没有烤炉.这不是一家烤肉店吗？桌子上怎么没有烤炉.这不是一家烤肉店吗？桌子上怎么没有烤炉.这不是一家烤肉店吗？桌子上怎么没有烤炉.这不是一家烤肉店吗？桌子上怎么没有烤炉.
     * answerCount : 2
     * replyCount : 10
     * likeCount : 1
     * followCount : 0
     * viewCount : 79
     * shareCount : 0
     * mentionProducts : [{"id":313,"questionId":152455282288073,"answerId":76,"productId":3,"score":10,"product":{"id":3,"name":"Pechoin 百雀羚 百雀羚甘油一号","minPrice":10,"maxPrice":30,"score":6.5,"favoriteCount":0,"evaluateCount":2,"viewCount":9,"shareCount":0,"infoUrl":"http://www.ibbtech.cn/product/23.html","type":0,"favorite":false,"category":{"id":1098,"name":"身体护理","icon":"http://oss.ibbtech.cn/category/images_shentihuli@3x.png","sequence":3,"parentId":112,"children":null},"brand":{"id":1236,"nameCn":"百雀羚","nameEn":"Pechoin","nation":"中国","type":2},"imgs":["http://image.ibbtech.cn/image/百雀羚甘油一号.jpg"],"infos":[{"id":3,"name":"干性皮肤","productId":3}],"baseAttribute":[{"id":51,"name":"使用效果","score":5.5},{"id":1,"name":"温和度","score":4.5},{"id":4,"name":"清爽度","score":4},{"id":32,"name":"持久度","score":8},{"id":46,"name":"气味","score":6},{"id":6,"name":"性价比","score":0}]},"attrs":[{"id":410,"questionProductId":313,"attributeId":51,"score":5,"attribute":{"id":51,"name":"使用效果"}}]},{"id":310,"questionId":152455282288073,"answerId":null,"productId":46,"score":9,"product":{"id":46,"name":"Lush 岚舒 洗头皂","minPrice":80,"maxPrice":100,"score":8.75,"favoriteCount":0,"evaluateCount":3,"viewCount":4,"shareCount":0,"infoUrl":"http://www.ibbtech.cn/product/66.html","type":0,"favorite":false,"category":{"id":1105,"name":"洗发","icon":"http://oss.ibbtech.cn/category/images_xifa@3x.png","sequence":1,"parentId":113,"children":null},"brand":{"id":979,"nameCn":"岚舒","nameEn":"LUSH","nation":"英国","type":2},"imgs":["http://image.ibbtech.cn/image/LUSH洗发皂.JPG"],"infos":[{"id":46,"name":"控油","productId":46}],"baseAttribute":[{"id":9,"name":"清洁度","score":0},{"id":128,"name":"深层滋养","score":7},{"id":129,"name":"修复效果","score":8},{"id":45,"name":"光泽度","score":10},{"id":130,"name":"去屑效果","score":0},{"id":6,"name":"性价比","score":0}]},"attrs":[{"id":403,"questionProductId":310,"attributeId":128,"score":6,"attribute":{"id":128,"name":"深层滋养"}},{"id":404,"questionProductId":310,"attributeId":129,"score":0,"attribute":{"id":129,"name":"修复效果"}},{"id":405,"questionProductId":310,"attributeId":45,"score":0,"attribute":{"id":45,"name":"光泽度"}}]},{"id":311,"questionId":152455282288073,"answerId":null,"productId":46,"score":8.5,"product":{"id":46,"name":"Lush 岚舒 洗头皂","minPrice":80,"maxPrice":100,"score":8.75,"favoriteCount":0,"evaluateCount":3,"viewCount":4,"shareCount":0,"infoUrl":"http://www.ibbtech.cn/product/66.html","type":0,"favorite":false,"category":{"id":1105,"name":"洗发","icon":"http://oss.ibbtech.cn/category/images_xifa@3x.png","sequence":1,"parentId":113,"children":null},"brand":{"id":979,"nameCn":"岚舒","nameEn":"LUSH","nation":"英国","type":2},"imgs":["http://image.ibbtech.cn/image/LUSH洗发皂.JPG"],"infos":[{"id":46,"name":"控油","productId":46}],"baseAttribute":[{"id":9,"name":"清洁度","score":0},{"id":128,"name":"深层滋养","score":7},{"id":129,"name":"修复效果","score":8},{"id":45,"name":"光泽度","score":10},{"id":130,"name":"去屑效果","score":0},{"id":6,"name":"性价比","score":0}]},"attrs":[{"id":406,"questionProductId":311,"attributeId":128,"score":8,"attribute":{"id":128,"name":"深层滋养"}},{"id":407,"questionProductId":311,"attributeId":129,"score":8,"attribute":{"id":129,"name":"修复效果"}},{"id":408,"questionProductId":311,"attributeId":45,"score":10,"attribute":{"id":45,"name":"光泽度"}}]}]
     * categorys : []
     * user : {"id":34183373848578,"nickname":"测试人员111","portrait":"http://image.ibbtech.cn/image/8b648aa9-557c-4c23-811f-016c95cfe8de.jpg","signature":"签名不知道怎么填","location":null,"sex":0,"relation":0}
     * follow : false
     * share : false
     */

    private long id;
    private int state;
    private long time;
    private String title;
    private String content;
    private int answerCount;
    private int replyCount;
    private int likeCount;
    private int followCount;
    private int viewCount;
    private int shareCount;
    private UserBean user;
    private boolean follow;
    private boolean share;
    private List<MentionProductsBean> mentionProducts;
    private List<CategoryBean> categorys;
    private AnswerBean answer;

    public AnswerBean getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerBean answer) {
        this.answer = answer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
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

    public int getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getFollowCount() {
        return followCount;
    }

    public void setFollowCount(int followCount) {
        this.followCount = followCount;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public boolean isFollow() {
        return follow;
    }

    public void setFollow(boolean follow) {
        this.follow = follow;
    }

    public boolean isShare() {
        return share;
    }

    public void setShare(boolean share) {
        this.share = share;
    }

    public List<MentionProductsBean> getMentionProducts() {
        return mentionProducts;
    }

    public void setMentionProducts(List<MentionProductsBean> mentionProducts) {
        this.mentionProducts = mentionProducts;
    }

    public List<CategoryBean> getCategorys() {
        return categorys;
    }

    public void setCategorys(List<CategoryBean> categorys) {
        this.categorys = categorys;
    }

    public static class UserBean {
        /**
         * id : 34183373848578
         * nickname : 测试人员111
         * portrait : http://image.ibbtech.cn/image/8b648aa9-557c-4c23-811f-016c95cfe8de.jpg
         * signature : 签名不知道怎么填
         * location : null
         * sex : 0
         * relation : 0
         */

        private long id;
        private String nickname;
        private String portrait;
        private String signature;
        private Object location;
        private int sex;
        private int relation;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getPortrait() {
            return portrait;
        }

        public void setPortrait(String portrait) {
            this.portrait = portrait;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public Object getLocation() {
            return location;
        }

        public void setLocation(Object location) {
            this.location = location;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public int getRelation() {
            return relation;
        }

        public void setRelation(int relation) {
            this.relation = relation;
        }
    }

    public static class MentionProductsBean {
        /**
         * id : 313
         * questionId : 152455282288073
         * answerId : 76
         * productId : 3
         * score : 10
         * product : {"id":3,"name":"Pechoin 百雀羚 百雀羚甘油一号","minPrice":10,"maxPrice":30,"score":6.5,"favoriteCount":0,"evaluateCount":2,"viewCount":9,"shareCount":0,"infoUrl":"http://www.ibbtech.cn/product/23.html","type":0,"favorite":false,"category":{"id":1098,"name":"身体护理","icon":"http://oss.ibbtech.cn/category/images_shentihuli@3x.png","sequence":3,"parentId":112,"children":null},"brand":{"id":1236,"nameCn":"百雀羚","nameEn":"Pechoin","nation":"中国","type":2},"imgs":["http://image.ibbtech.cn/image/百雀羚甘油一号.jpg"],"infos":[{"id":3,"name":"干性皮肤","productId":3}],"baseAttribute":[{"id":51,"name":"使用效果","score":5.5},{"id":1,"name":"温和度","score":4.5},{"id":4,"name":"清爽度","score":4},{"id":32,"name":"持久度","score":8},{"id":46,"name":"气味","score":6},{"id":6,"name":"性价比","score":0}]}
         * attrs : [{"id":410,"questionProductId":313,"attributeId":51,"score":5,"attribute":{"id":51,"name":"使用效果"}}]
         */

        private int id;
        private long questionId;
        private int answerId;
        private int productId;
        private float score;
        private ProductBean product;
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

        public int getAnswerId() {
            return answerId;
        }

        public void setAnswerId(int answerId) {
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

        public ProductBean getProduct() {
            return product;
        }

        public void setProduct(ProductBean product) {
            this.product = product;
        }

        public List<AttrsBean> getAttrs() {
            return attrs;
        }

        public void setAttrs(List<AttrsBean> attrs) {
            this.attrs = attrs;
        }

        public static class ProductBean {
            /**
             * id : 3
             * name : Pechoin 百雀羚 百雀羚甘油一号
             * minPrice : 10
             * maxPrice : 30
             * score : 6.5
             * favoriteCount : 0
             * evaluateCount : 2
             * viewCount : 9
             * shareCount : 0
             * infoUrl : http://www.ibbtech.cn/product/23.html
             * type : 0
             * favorite : false
             * category : {"id":1098,"name":"身体护理","icon":"http://oss.ibbtech.cn/category/images_shentihuli@3x.png","sequence":3,"parentId":112,"children":null}
             * brand : {"id":1236,"nameCn":"百雀羚","nameEn":"Pechoin","nation":"中国","type":2}
             * imgs : ["http://image.ibbtech.cn/image/百雀羚甘油一号.jpg"]
             * infos : [{"id":3,"name":"干性皮肤","productId":3}]
             * baseAttribute : [{"id":51,"name":"使用效果","score":5.5},{"id":1,"name":"温和度","score":4.5},{"id":4,"name":"清爽度","score":4},{"id":32,"name":"持久度","score":8},{"id":46,"name":"气味","score":6},{"id":6,"name":"性价比","score":0}]
             */

            private int id;
            private String name;
            private int minPrice;
            private int maxPrice;
            private float score;
            private int favoriteCount;
            private int evaluateCount;
            private int viewCount;
            private int shareCount;
            private String infoUrl;
            private int type;
            private boolean favorite;
            private CategoryBean category;
            private BrandBean brand;
            private List<String> imgs;
            private List<InfosBean> infos;
            private List<BaseAttributeBean> baseAttribute;

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

            public int getMinPrice() {
                return minPrice;
            }

            public void setMinPrice(int minPrice) {
                this.minPrice = minPrice;
            }

            public int getMaxPrice() {
                return maxPrice;
            }

            public void setMaxPrice(int maxPrice) {
                this.maxPrice = maxPrice;
            }

            public float getScore() {
                return score;
            }

            public void setScore(float score) {
                this.score = score;
            }

            public int getFavoriteCount() {
                return favoriteCount;
            }

            public void setFavoriteCount(int favoriteCount) {
                this.favoriteCount = favoriteCount;
            }

            public int getEvaluateCount() {
                return evaluateCount;
            }

            public void setEvaluateCount(int evaluateCount) {
                this.evaluateCount = evaluateCount;
            }

            public int getViewCount() {
                return viewCount;
            }

            public void setViewCount(int viewCount) {
                this.viewCount = viewCount;
            }

            public int getShareCount() {
                return shareCount;
            }

            public void setShareCount(int shareCount) {
                this.shareCount = shareCount;
            }

            public String getInfoUrl() {
                return infoUrl;
            }

            public void setInfoUrl(String infoUrl) {
                this.infoUrl = infoUrl;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public boolean isFavorite() {
                return favorite;
            }

            public void setFavorite(boolean favorite) {
                this.favorite = favorite;
            }

            public CategoryBean getCategory() {
                return category;
            }

            public void setCategory(CategoryBean category) {
                this.category = category;
            }

            public BrandBean getBrand() {
                return brand;
            }

            public void setBrand(BrandBean brand) {
                this.brand = brand;
            }

            public List<String> getImgs() {
                return imgs;
            }

            public void setImgs(List<String> imgs) {
                this.imgs = imgs;
            }

            public List<InfosBean> getInfos() {
                return infos;
            }

            public void setInfos(List<InfosBean> infos) {
                this.infos = infos;
            }

            public List<BaseAttributeBean> getBaseAttribute() {
                return baseAttribute;
            }

            public void setBaseAttribute(List<BaseAttributeBean> baseAttribute) {
                this.baseAttribute = baseAttribute;
            }

            public static class CategoryBean {
                /**
                 * id : 1098
                 * name : 身体护理
                 * icon : http://oss.ibbtech.cn/category/images_shentihuli@3x.png
                 * sequence : 3
                 * parentId : 112
                 * children : null
                 */

                private int id;
                private String name;
                private String icon;
                private int sequence;
                private int parentId;
                private Object children;

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

                public String getIcon() {
                    return icon;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }

                public int getSequence() {
                    return sequence;
                }

                public void setSequence(int sequence) {
                    this.sequence = sequence;
                }

                public int getParentId() {
                    return parentId;
                }

                public void setParentId(int parentId) {
                    this.parentId = parentId;
                }

                public Object getChildren() {
                    return children;
                }

                public void setChildren(Object children) {
                    this.children = children;
                }
            }

            public static class BrandBean {
                /**
                 * id : 1236
                 * nameCn : 百雀羚
                 * nameEn : Pechoin
                 * nation : 中国
                 * type : 2
                 */

                private int id;
                private String nameCn;
                private String nameEn;
                private String nation;
                private int type;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getNameCn() {
                    return nameCn;
                }

                public void setNameCn(String nameCn) {
                    this.nameCn = nameCn;
                }

                public String getNameEn() {
                    return nameEn;
                }

                public void setNameEn(String nameEn) {
                    this.nameEn = nameEn;
                }

                public String getNation() {
                    return nation;
                }

                public void setNation(String nation) {
                    this.nation = nation;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }
            }

            public static class InfosBean {
                /**
                 * id : 3
                 * name : 干性皮肤
                 * productId : 3
                 */

                private int id;
                private String name;
                private int productId;

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

                public int getProductId() {
                    return productId;
                }

                public void setProductId(int productId) {
                    this.productId = productId;
                }
            }

            public static class BaseAttributeBean {
                /**
                 * id : 51
                 * name : 使用效果
                 * score : 5.5
                 */

                private int id;
                private String name;
                private double score;

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

                public double getScore() {
                    return score;
                }

                public void setScore(double score) {
                    this.score = score;
                }
            }
        }

        public static class AttrsBean {
            /**
             * id : 410
             * questionProductId : 313
             * attributeId : 51
             * score : 5
             * attribute : {"id":51,"name":"使用效果"}
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
                 * id : 51
                 * name : 使用效果
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
}
