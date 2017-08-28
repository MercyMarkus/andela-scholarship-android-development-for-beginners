package com.mercy.markus.javadevelopersongithub.network;

import com.mercy.markus.javadevelopersongithub.model.DevResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mesy on 24/08/17.
 */

public interface apiResponse {
    @GET("/search/users")
    Call<DevResponse> getUserList(@Query("q") String filter);
}
