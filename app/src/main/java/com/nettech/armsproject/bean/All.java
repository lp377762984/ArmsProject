package com.nettech.armsproject.bean;

public class All {

    /**
     * code : 200
     * msg : 登录成功
     * login_access : {"sessionId":"672be49d801183fd017c66a184da7dfc"}
     * data : {"update_token":{"sessionId":"990f58e52dabc89c91876591e8029d03","accessToken":"eb90a6ac61ea25a130b65db3576dd95a"},"user_info":{"mobile":"15510115653","nickname":"疯狂牛仔衬衫","realname":"李平","sex":"保密","age":18,"location":"未设置","avatar":"http","card_status":1,"store_score":0,"is_level_pwd":1,"company_status":3,"group_name":"钱来钱往商家","is_weixin":1}}
     * version_upgrade : {"android_type":2,"ios_type":2}
     */

    private int code;
    private String msg;
    private LoginAccessBean login_access;
    private DataBean data;
    private VersionUpgradeBean version_upgrade;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public LoginAccessBean getLogin_access() {
        return login_access;
    }

    public void setLogin_access(LoginAccessBean login_access) {
        this.login_access = login_access;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public VersionUpgradeBean getVersion_upgrade() {
        return version_upgrade;
    }

    public void setVersion_upgrade(VersionUpgradeBean version_upgrade) {
        this.version_upgrade = version_upgrade;
    }

    public static class LoginAccessBean {
        /**
         * sessionId : 672be49d801183fd017c66a184da7dfc
         */

        private String sessionId;

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }
    }

    public static class DataBean {
        /**
         * update_token : {"sessionId":"990f58e52dabc89c91876591e8029d03","accessToken":"eb90a6ac61ea25a130b65db3576dd95a"}
         * user_info : {"mobile":"15510115653","nickname":"疯狂牛仔衬衫","realname":"李平","sex":"保密","age":18,"location":"未设置","avatar":"http","card_status":1,"store_score":0,"is_level_pwd":1,"company_status":3,"group_name":"钱来钱往商家","is_weixin":1}
         */

        private UpdateTokenBean update_token;
        private UserInfoBean user_info;

        public UpdateTokenBean getUpdate_token() {
            return update_token;
        }

        public void setUpdate_token(UpdateTokenBean update_token) {
            this.update_token = update_token;
        }

        public UserInfoBean getUser_info() {
            return user_info;
        }

        public void setUser_info(UserInfoBean user_info) {
            this.user_info = user_info;
        }

        public static class UpdateTokenBean {
            /**
             * sessionId : 990f58e52dabc89c91876591e8029d03
             * accessToken : eb90a6ac61ea25a130b65db3576dd95a
             */

            private String sessionId;
            private String accessToken;

            public String getSessionId() {
                return sessionId;
            }

            public void setSessionId(String sessionId) {
                this.sessionId = sessionId;
            }

            public String getAccessToken() {
                return accessToken;
            }

            public void setAccessToken(String accessToken) {
                this.accessToken = accessToken;
            }
        }

        public static class UserInfoBean {
            /**
             * mobile : 15510115653
             * nickname : 疯狂牛仔衬衫
             * realname : 李平
             * sex : 保密
             * age : 18
             * location : 未设置
             * avatar : http
             * card_status : 1
             * store_score : 0
             * is_level_pwd : 1
             * company_status : 3
             * group_name : 钱来钱往商家
             * is_weixin : 1
             */

            private String mobile;
            private String nickname;
            private String realname;
            private String sex;
            private int age;
            private String location;
            private String avatar;
            private int card_status;
            private int store_score;
            private int is_level_pwd;
            private int company_status;
            private String group_name;
            private int is_weixin;

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getRealname() {
                return realname;
            }

            public void setRealname(String realname) {
                this.realname = realname;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public int getCard_status() {
                return card_status;
            }

            public void setCard_status(int card_status) {
                this.card_status = card_status;
            }

            public int getStore_score() {
                return store_score;
            }

            public void setStore_score(int store_score) {
                this.store_score = store_score;
            }

            public int getIs_level_pwd() {
                return is_level_pwd;
            }

            public void setIs_level_pwd(int is_level_pwd) {
                this.is_level_pwd = is_level_pwd;
            }

            public int getCompany_status() {
                return company_status;
            }

            public void setCompany_status(int company_status) {
                this.company_status = company_status;
            }

            public String getGroup_name() {
                return group_name;
            }

            public void setGroup_name(String group_name) {
                this.group_name = group_name;
            }

            public int getIs_weixin() {
                return is_weixin;
            }

            public void setIs_weixin(int is_weixin) {
                this.is_weixin = is_weixin;
            }
        }
    }

    public static class VersionUpgradeBean {
        /**
         * android_type : 2
         * ios_type : 2
         */

        private int android_type;
        private int ios_type;

        public int getAndroid_type() {
            return android_type;
        }

        public void setAndroid_type(int android_type) {
            this.android_type = android_type;
        }

        public int getIos_type() {
            return ios_type;
        }

        public void setIos_type(int ios_type) {
            this.ios_type = ios_type;
        }
    }
}
