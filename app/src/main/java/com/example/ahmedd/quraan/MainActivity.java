package com.example.ahmedd.quraan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<ItemView> list;
    ItemView itemView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        list = new ArrayList<>();
        adapter = new MyAdapter(this, list);

        adapter.setOnItemClickListener(new MyAdapter.onItemClickListener() {
            @Override
            public void onClick(int position, ItemView itemView) {
                Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
            }
        });



    for (int i=0; i<115; i++ ){

        ItemView itemView = new ItemView("Name " + (i+1));

        list.add(itemView);
    }

    recyclerView.setAdapter(adapter);

    }
}
