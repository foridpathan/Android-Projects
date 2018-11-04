package com.plenarysof.simplemediaplayer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PlayerRecyclerAdapter extends RecyclerView.Adapter<PlayerRecyclerAdapter.PlayerRecyclerHolder> {

    List<PlayerRecyclerModal> dataList;
    Context context;

    public PlayerRecyclerAdapter(List<PlayerRecyclerModal> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public PlayerRecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View avd = LayoutInflater.from(parent.getContext()).inflate(R.layout.music_item, parent, false);
        return new PlayerRecyclerHolder(avd);
    }

    @Override
    public void onBindViewHolder(PlayerRecyclerHolder holder, int position) {
        holder.musicName.setText(dataList.get(position).getMusicName());
        holder.musicIcon.setImageDrawable(context.getResources().getDrawable(dataList.get(position).getMusicIcon()));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class PlayerRecyclerHolder extends RecyclerView.ViewHolder {

        ImageView musicIcon;
        TextView musicName;

        public PlayerRecyclerHolder(View itemView) {
            super(itemView);
            musicIcon = itemView.findViewById(R.id.iv_music_icon);
            musicName = itemView.findViewById(R.id.tv_music_name);
        }
    }
}
