package com.plenarysof.userlist;

public class UserListModal {

    String name, mobile;
    int image;

    public UserListModal(String name, String mobile, int image) {
        this.name = name;
        this.mobile = mobile;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public int getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
