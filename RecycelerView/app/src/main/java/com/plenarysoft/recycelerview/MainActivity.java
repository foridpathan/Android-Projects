package com.plenarysoft.recycelerview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvSettings;
    SettingsAdaper settingsAdaper;
    List<SettingsModel> dataList;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initVariables();
        loadData();
        initFunctionality();
    }

    private void initView () {
        setContentView(R.layout.activity_main);
        rvSettings = findViewById(R.id.rv_list);
    }

    private void initVariables() {
        dataList = new ArrayList<>();
        context = getApplicationContext();
    }

    private void loadData() {
        dataList.add(new SettingsModel("Bluetooth", R.drawable.bluetooth));
        dataList.add(new SettingsModel("Messanger", R.drawable.message));
        dataList.add(new SettingsModel("Brithness", R.drawable.select_brightness_button));
        dataList.add(new SettingsModel("Phone", R.drawable.call));
        dataList.add(new SettingsModel("Network", R.drawable.network));
        dataList.add(new SettingsModel("Wifi", R.drawable.wifi_connection_signal_symbol));

        dataList.add(new SettingsModel("Bluetooth", R.drawable.bluetooth));
        dataList.add(new SettingsModel("Messanger", R.drawable.message));
        dataList.add(new SettingsModel("Brithness", R.drawable.select_brightness_button));
        dataList.add(new SettingsModel("Phone", R.drawable.call));
        dataList.add(new SettingsModel("Network", R.drawable.network));
        dataList.add(new SettingsModel("Wifi", R.drawable.wifi_connection_signal_symbol));
    }

    private void initFunctionality() {
        settingsAdaper = new SettingsAdaper(dataList, context);
        rvSettings.setLayoutManager(new LinearLayoutManager(context, LinearLayout.VERTICAL, false));
        rvSettings.setAdapter(settingsAdaper);
    }

}
