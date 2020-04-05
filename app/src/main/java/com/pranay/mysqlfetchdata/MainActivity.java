package com.pranay.mysqlfetchdata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Databaselist> list;
    Adapter adapter;
    SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        swipeRefreshLayout=findViewById(R.id.swip);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getdata();
            }
        });


        getdata();
    }

    private void getdata()
    {
        list=new ArrayList<>();
        Call<List<Databaselist>> call= Retrofitclient.getInstance().getapi().getdata();

        swipeRefreshLayout.setRefreshing(true);
        call.enqueue(new Callback<List<Databaselist>>() {
            @Override
            public void onResponse(Call<List<Databaselist>> call, Response<List<Databaselist>> response)
            {
                try
                {
                    list=response.body();
                    adapter=new Adapter(MainActivity.this,list);
                    recyclerView.setAdapter(adapter);
                    swipeRefreshLayout.setRefreshing(false);
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    swipeRefreshLayout.setRefreshing(false);
                }


            }

            @Override
            public void onFailure(Call<List<Databaselist>> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }
}
