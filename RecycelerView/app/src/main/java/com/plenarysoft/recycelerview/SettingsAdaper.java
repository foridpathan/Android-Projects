package com.plenarysoft.recycelerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SettingsAdaper extends RecyclerView.Adapter<SettingsAdaper.SettingsViewHolder> {


    List<SettingsModel> dataList;
    Context context;

    public SettingsAdaper(List<SettingsModel> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public SettingsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View avd = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_setting, parent, false);

        return new SettingsViewHolder(avd);
    }

    @Override
    public void onBindViewHolder(SettingsViewHolder holder, int position) {
        holder.tvSettingsName.setText(dataList.get(position).getSettingName());
        holder.ivSettingIcon.setImageDrawable(context.getResources().getDrawable(dataList.get(position).getImage()));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class SettingsViewHolder extends RecyclerView.ViewHolder {

        ImageView ivSettingIcon;
        TextView tvSettingsName;

        public SettingsViewHolder(View itemView) {
            super(itemView);

            ivSettingIcon = itemView.findViewById(R.id.iv_settings_icon);
            tvSettingsName = itemView.findViewById(R.id.tv_setting_name);

        }
    }


}
