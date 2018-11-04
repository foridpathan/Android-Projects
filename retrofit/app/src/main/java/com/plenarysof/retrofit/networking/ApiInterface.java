package com.plenarysof.retrofit.networking;

import com.plenarysof.retrofit.model.MyUsers;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("getUsers.php/")
    Call<MyUsers> findMyUsers();

}
