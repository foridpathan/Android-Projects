package com.plenarysof.retrofit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.plenarysof.retrofit.model.GetUser;

import java.util.ArrayList;

public class UsersRecycler extends RecyclerView.Adapter<UsersRecycler.myViewHolder> {

    ArrayList<GetUser> getUsers;
    Context context;

    public UsersRecycler(ArrayList<GetUser> getUsers, Context context) {
        this.getUsers = getUsers;
        this.context = context;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_single_user, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        GetUser user = getUsers.get(position);

        holder.tvId.setText(user.getId());
        holder.tvName.setText(user.getName());
        holder.tvEmail.setText(user.getEmail());
        holder.tvPhone.setText(user.getPhone());
        holder.tvAddress.setText(user.getAddress());
        holder.tvOccupation.setText(user.getOccupation());
        holder.tvEducation.setText(user.getEducationalQualification());
    }

    @Override
    public int getItemCount() {
        return getUsers.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView tvId, tvName, tvEmail, tvPhone, tvAddress, tvOccupation, tvEducation;

        public myViewHolder(View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.tv_id);
            tvName = itemView.findViewById(R.id.tv_name);
            tvEmail = itemView.findViewById(R.id.tv_email);
            tvPhone = itemView.findViewById(R.id.tv_phone);
            tvAddress = itemView.findViewById(R.id.tv_Address);
            tvOccupation = itemView.findViewById(R.id.tv_occumation);
            tvEducation = itemView.findViewById(R.id.tv_education);

        }
    }

}
