package com.plenarysof.retrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MyUsers {

    @SerializedName("getUsers")
    @Expose
    private ArrayList<GetUser> getUsers = null;

    public ArrayList<GetUser> getGetUsers() {
        return getUsers;
    }

    public void setGetUsers(ArrayList<GetUser> getUsers) {
        this.getUsers = getUsers;
    }
}
