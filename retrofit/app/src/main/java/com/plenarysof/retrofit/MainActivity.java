package com.plenarysof.retrofit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.plenarysof.retrofit.model.GetUser;
import com.plenarysof.retrofit.model.MyUsers;
import com.plenarysof.retrofit.networking.InvokeApi;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private RecyclerView rvContacts;
    private RecyclerView.LayoutManager layoutManager;
    private UsersRecycler usersRecycler;
    private ArrayList<GetUser> getUserArrayList = new ArrayList<>();

    private FloatingActionButton fabAddNewUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initListener();

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading...");


        layoutManager = new LinearLayoutManager(this, LinearLayout.VERTICAL, false);
        usersRecycler = new UsersRecycler(getUserArrayList, this);
        rvContacts.setLayoutManager(layoutManager);
        rvContacts.setAdapter(usersRecycler);

        initCallApi();


    }

    private void initView() {
        setContentView(R.layout.activity_main);
        rvContacts = findViewById(R.id.rv_users);
        fabAddNewUser = findViewById(R.id.fab_add_new_user);
    }

    private void initListener() {
        fabAddNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, activity_add_user.class);
                startActivity(intent);
            }
        });
    }

    public interface NetWorkCall {
        void onSuccess(ArrayList<GetUser> users);
        void onFailed();
    }

    private void initCallApi() {
        progressDialog.show();
        InvokeApi.makeApiRequest(new NetWorkCall() {
            @Override
            public void onSuccess(ArrayList<GetUser> users) {
                for (int i=0; i<users.size(); i++) {
                    GetUser user = users.get(i);

                    String id = user.getId();
                    String name = user.getName();
                    String email = user.getEmail();
                    String phone = user.getPhone();
                    String address = user.getAddress();
                    String occupation = user.getOccupation();
                    String educational_qualification = user.getEducationalQualification();

                    GetUser getUser = new GetUser(id, name, email, phone, address, occupation, educational_qualification);
                    getUserArrayList.add(getUser);

                }
                usersRecycler.notifyDataSetChanged();
                progressDialog.hide();
            }

            @Override
            public void onFailed() {
                progressDialog.hide();
            }
        });
    }
}
