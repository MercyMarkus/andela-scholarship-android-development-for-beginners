package com.mercy.markus.javadevelopersongithub.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mesy on 24/08/17.
 */

public class DevResponse {
    @SerializedName("items")
    @Expose
    private List<Dev> items = null;

    public List<Dev> getItems() {
        return items;
    }

}
