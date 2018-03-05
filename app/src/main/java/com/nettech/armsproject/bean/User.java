package com.nettech.armsproject.bean;

public class User {

    /**
     * avatar : http://apidebug.qlqwp2p.com/public/uploads/avatar/92/92.png?1503481238
     * expiring_in : 1800
     */

    private String avatar;
    private int expiring_in;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getExpiring_in() {
        return expiring_in;
    }

    public void setExpiring_in(int expiring_in) {
        this.expiring_in = expiring_in;
    }

    @Override
    public String toString() {
        return "User{" +
                "avatar='" + avatar + '\'' +
                ", expiring_in=" + expiring_in +
                '}';
    }
}
