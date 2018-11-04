package com.plenarysof.simplemediaplayer;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PlayerRecyclerAdapter playerRecyclerAdapter;
    List<PlayerRecyclerModal> dataList;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initVariable();
        loadData();
        initFunctions();

    }

    private void initView() {
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_list);
    }

    private void initVariable() {
        dataList = new ArrayList<>();
        context = getApplicationContext();
    }

    private void loadData() {
        dataList.add(new PlayerRecyclerModal("Ami banglay gan gai", R.drawable.music_icon));
        dataList.add(new PlayerRecyclerModal("Ami banglay gan gai", R.drawable.music_icon));
        dataList.add(new PlayerRecyclerModal("Ami banglay gan gai", R.drawable.music_icon));
        dataList.add(new PlayerRecyclerModal("Ami banglay gan gai", R.drawable.music_icon));
    }

    private void initFunctions() {
        playerRecyclerAdapter = new PlayerRecyclerAdapter(dataList, context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayout.VERTICAL, false));
        recyclerView.setAdapter(playerRecyclerAdapter);
    }

}
