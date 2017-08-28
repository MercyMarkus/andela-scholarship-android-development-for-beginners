package com.mercy.markus.javadevelopersongithub.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mesy on 24/08/17.
 */

public class apiClient {

    private static final String BASE_URL = "https://api.github.com";

    private Retrofit retrofit;

    public apiClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public apiResponse getService() {
        return retrofit.create(apiResponse.class);
    }
}
