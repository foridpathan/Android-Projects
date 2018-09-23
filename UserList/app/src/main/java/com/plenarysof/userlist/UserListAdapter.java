package com.plenarysof.userlist;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class UserListAdapter {

    public class UserListViewHolder extends RecyclerView.ViewHolder {

        ImageView ivProfilePic;
        TextView tvName, tvMobile;
        public UserListViewHolder(View itemView) {
            super(itemView);

            ivProfilePic = itemView.findViewById(R.id.profile_pic);
            tvName = itemView.findViewById(R.id.tv_name);
            tvMobile = itemView.findViewById(R.id.tv_mobile);
        }
    }

}
