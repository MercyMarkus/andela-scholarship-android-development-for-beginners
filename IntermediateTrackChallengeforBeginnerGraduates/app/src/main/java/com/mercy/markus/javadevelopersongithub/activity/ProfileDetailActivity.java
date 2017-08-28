package com.mercy.markus.javadevelopersongithub.activity;


import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.util.Linkify;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mercy.markus.javadevelopersongithub.R;
import com.mercy.markus.javadevelopersongithub.model.Dev;
import com.mercy.markus.javadevelopersongithub.utils.share;

import me.saket.bettermovementmethod.BetterLinkMovementMethod;

public class ProfileDetailActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
       TextView userName, githubUrl;
        ImageView profileImage;
        CollapsingToolbarLayout collapsingToolbarLayout;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareDeveloperProfile();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setTitle("");

        profileImage = (ImageView) collapsingToolbarLayout.findViewById(R.id.dev_profile_image);
        userName = (TextView) findViewById(R.id.dev_user_name);
        githubUrl= (TextView) findViewById(R.id.dev_github_url);

        Dev dev = getIntent().getParcelableExtra("dev");


        userName.setText(getString(R.string.user_name_full, dev.getLogin()));
        githubUrl.setText(getString(R.string.user_url_full, dev.getHtmlUrl()));

        Glide.with(getApplicationContext()).load(dev.getAvatarUrl()).into(profileImage);

        BetterLinkMovementMethod movementMethod = BetterLinkMovementMethod.linkify(Linkify.WEB_URLS, githubUrl);
        movementMethod.setOnLinkClickListener(new BetterLinkMovementMethod.OnLinkClickListener() {
            @Override
            public boolean onClick(TextView textView, String url) {
                getCustomTabIntentInstance().launchUrl(ProfileDetailActivity.this, Uri.parse(url));
                return true;
            }
        });

    }
    private CustomTabsIntent getCustomTabIntentInstance() {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        return builder.build();
    }



    private void shareDeveloperProfile() {

        Dev developer = getIntent().getParcelableExtra("dev");


        String message = "Check out this awesome developer @" + developer.getLogin() + ", " + developer.getHtmlUrl();

        share.shareCustom(message, this);

    }
}

