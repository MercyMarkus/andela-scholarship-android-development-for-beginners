package com.mercy.markus.javadevelopersongithub.activity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.mercy.markus.javadevelopersongithub.R;
import com.mercy.markus.javadevelopersongithub.adapter.DevsAdapter;
import com.mercy.markus.javadevelopersongithub.model.DevResponse;
import com.mercy.markus.javadevelopersongithub.network.ApiClient;
import com.mercy.markus.javadevelopersongithub.network.ApiResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilesListActivity extends AppCompatActivity {
private  RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        CoordinatorLayout coordinatorLayout;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiles_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_devs_list);
        GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        //checking for network connectivity
        if (!isNetworkAvailable()) {
            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, "No Network connection", Snackbar.LENGTH_LONG)
                    .setAction("RETRY", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            getUsersData();
                        }
                    });

            snackbar.show();
        } else {
            getUsersData();
        }


    }

    private void prepareData(DevResponse devResponse) {
        DevsAdapter adapter;
        adapter = new DevsAdapter(devResponse.getItems());
        recyclerView.setAdapter(adapter);

    }


    private void getUsersData() {
        String searchParams = "language:java location:lagos";
        ApiResponse apiService = new ApiClient().getService();
        Call<DevResponse> devListCall = apiService.getUserList(searchParams);
        devListCall.enqueue(new Callback<DevResponse>() {
            @Override
            public void onResponse(Call<DevResponse> call, Response<DevResponse> response) {
                if (response.isSuccessful()) {
                    DevResponse devList = response.body();
                    prepareData(devList);
                } else {
                    Toast.makeText(ProfilesListActivity.this,
                            "Request not Sucessful",
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DevResponse>  call, Throwable t) {
                Toast.makeText(ProfilesListActivity.this,
                        "Request failed. Check your internet connection",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


}
