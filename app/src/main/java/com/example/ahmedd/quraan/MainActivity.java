package com.example.ahmedd.quraan;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.ahmedd.quraan.Adapters.SouraListAdapter;
import com.example.ahmedd.quraan.Model.ItemView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SouraListAdapter adapter;
    private List<ItemView> list;
    public static int p = 0;


    SouraName souraName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        souraName = new SouraName();




        list = new ArrayList<>();
        adapter = new SouraListAdapter(this, list);


        for (int i=0; i<souraName.souraName().size(); i++ ){

            ItemView itemView = new ItemView(souraName.souraName().get(i) + " (" + (i+1) + ")");

            list.add(itemView);
        }


        adapter.setOnItemClickListener(new SouraListAdapter.onItemClickListener() {
            @Override
            public void onClick(int position, ItemView itemView) {
                Intent intent = new Intent(MainActivity.this,Soura.class);
                Soura.txtFile = (position+1) + ".txt";
                intent.putExtra(Soura.txtFile,  position);
                startActivity(intent);

            }
        });
    recyclerView.setAdapter(adapter);

    }


}
