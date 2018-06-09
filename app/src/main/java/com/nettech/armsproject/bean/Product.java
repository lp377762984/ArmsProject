package com.nettech.armsproject.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ASUS on 2018/5/16.
 * 商品实体类
 */

public class Product implements Serializable {

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
    private double score;
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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
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

    public static class CategoryBean implements Serializable {
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

    public static class BrandBean implements Serializable {
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

    public static class InfosBean implements Serializable {
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

    public static class BaseAttributeBean implements Serializable {
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
