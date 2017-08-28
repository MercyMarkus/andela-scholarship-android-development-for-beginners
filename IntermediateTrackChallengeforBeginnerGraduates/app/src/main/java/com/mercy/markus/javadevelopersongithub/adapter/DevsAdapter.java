package com.mercy.markus.javadevelopersongithub.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mercy.markus.javadevelopersongithub.R;
import com.mercy.markus.javadevelopersongithub.activity.ProfileDetailActivity;
import com.mercy.markus.javadevelopersongithub.model.Dev;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by mesy on 24/08/17.
 */

public class DevsAdapter extends RecyclerView.Adapter<DevsAdapter.MyViewHolder> {

    private List<Dev> devsList;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        CircleImageView user_profile_avatar;
        TextView username;


        public MyViewHolder(View view) {
            super(view);
            user_profile_avatar = (CircleImageView) view.findViewById(R.id.profile_image);
            username = (TextView) view.findViewById(R.id.user_name);

        }
    }


    public DevsAdapter(List<Dev> devsList) {
        this.devsList = devsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_profile_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Dev dev = devsList.get(position);

        holder.username.setText(dev.getLogin());



        //Loading the image using Glide
        Context context = holder.user_profile_avatar.getContext();
        Glide.with(context).load(dev.getAvatarUrl()).into(holder.user_profile_avatar);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = holder.itemView.getContext();
                Intent intent = new Intent(context, ProfileDetailActivity.class);
                intent.putExtra("dev", dev);
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return devsList.size();
    }
}
