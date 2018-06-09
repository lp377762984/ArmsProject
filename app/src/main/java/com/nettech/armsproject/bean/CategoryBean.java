package com.nettech.armsproject.bean;

/**
 * Created by ASUS on 2018/5/17.
 */

public class CategoryBean {
    /**
     * id : 1069
     * name : 祛痘
     * icon : null
     * sequence : 17
     * parentId : 109
     * children : null
     */

    private int id;
    private String name;
    private Object icon;
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

    public Object getIcon() {
        return icon;
    }

    public void setIcon(Object icon) {
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
