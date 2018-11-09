package com.ea222.team4reminderlistr1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    List<String> list;
    adapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // DATA TO SCREEN

        list = new ArrayList<>();
        for(int i = 0; i < 20; ++i) {
            list.add(String.valueOf(i));
        }

        myadapter = new adapter(this, list,
                 new adapterClickListener(){
            @Override
            public void onClickListener(int position){
           //    Toast.makeText(MainActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
            }

        },
                new adapterDeleteListener(){
         @Override
         public void onDeleteListener(int position){
                list.remove(position);
                myadapter.notifyDataSetChanged();
         }
        });

        recyclerView.setAdapter(myadapter);

    }
}
