package com.plenarysof.retrofit.networking;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.plenarysof.retrofit.MainActivity;
import com.plenarysof.retrofit.model.GetUser;
import com.plenarysof.retrofit.model.MyUsers;

import java.util.ArrayList;

public class InvokeApi {

    public static void makeApiRequest(final MainActivity.NetWorkCall netWorkCall) {

        ApiInterface apiInterface = RetrofitClient.getClient().create(ApiInterface.class);
        Call<MyUsers> myUsersCall = apiInterface.findMyUsers();
        myUsersCall.enqueue(new Callback<MyUsers>() {
            @Override
            public void onResponse(Call<MyUsers> call, Response<MyUsers> response) {
                Log.d("DataTesting", "onResponse");
                MyUsers myUsers = (MyUsers) response.body();
                ArrayList<GetUser> userArrayList = myUsers.getGetUsers();
                netWorkCall.onSuccess(userArrayList);
            }

            @Override
            public void onFailure(Call<MyUsers> call, Throwable t) {
                Log.d("DataTesting", "onFailure");
                netWorkCall.onFailed();
            }
        });
    }

}
