package com.mercy.markus.javadevelopersongithub.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mesy on 24/08/17.
 */

public class Dev implements Parcelable {
    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("avatar_url")
    @Expose
    private String avatarUrl;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("html_url")
    @Expose
    private String htmlUrl;

    private Dev(Parcel in) {
        login = in.readString();
        avatarUrl = in.readString();
        url = in.readString();
        htmlUrl = in.readString();
    }

    public static final Creator<Dev> CREATOR = new Creator<Dev>() {
        @Override
        public Dev createFromParcel(Parcel in) {
            return new Dev(in);
        }

        @Override
        public Dev[] newArray(int size) {
            return new Dev[size];
        }
    };

    public String getLogin() {
        return login;
    }


    public String getAvatarUrl() {
        return avatarUrl;
    }


    public String getUrl() {
        return url;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(login);
        dest.writeString(avatarUrl);
        dest.writeString(url);
        dest.writeString(htmlUrl);
        }
}
