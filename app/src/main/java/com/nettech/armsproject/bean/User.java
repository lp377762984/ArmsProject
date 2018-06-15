package com.nettech.armsproject.bean;

import java.io.Serializable;

public class User implements Serializable {

    /**
     * avatar : http://apidebug.qlqwp2p.com/public/uploads/avatar/92/92.png?1503481238
     * expiring_in : 1800
     */

    public String avatar;
    public int expiring_in;


    /**
     * mobile : 15510115653
     * nickname : 疯狂牛仔衬衫
     * sex : 男
     * age : 25
     * location : 未设置
     * card_status : 1
     * company_status : 1
     * group_name : 中级合伙人
     * is_level_pwd : 1
     */

    public String mobile;
    public String nickname;
    public String sex;
    public int age;
    public String location;
    public int card_status;
    public int company_status;
    public String group_name;
    public int is_level_pwd;

    @Override
    public String toString() {
        return "User{" +
                "avatar='" + avatar + '\'' +
                ", expiring_in=" + expiring_in +
                ", mobile='" + mobile + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", location='" + location + '\'' +
                ", card_status=" + card_status +
                ", company_status=" + company_status +
                ", group_name='" + group_name + '\'' +
                ", is_level_pwd=" + is_level_pwd +
                '}';
    }
}
