package com.plenarysof.retrofit.networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
        private static Retrofit retrofit = null;

        public static Retrofit getClient() {
            if (retrofit == null) {
                String url = "https://plenarysoft.com/volley/";
                retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
            }
            return retrofit;
        }
}
