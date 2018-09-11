package com.example.ahmedd.quraan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.ahmedd.quraan.Adapters.SouraListAdapter;
import com.example.ahmedd.quraan.Model.ItemView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static String inner;
    SouraName souraName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        souraName = new SouraName();


        List<ItemView> list = new ArrayList<>();
        SouraListAdapter adapter = new SouraListAdapter(this, list);


        for (int i = 0; i< SouraName.souraName().size(); i++ ){

            ItemView itemView = new ItemView(SouraName.souraName().get(i) + " (" + (i+1) + ")");

            list.add(itemView);
        }


        adapter.setOnItemClickListener(new SouraListAdapter.onItemClickListener() {
            @Override
            public void onClick(int position, ItemView itemView) {

                Intent intent = new Intent(MainActivity.this,Soura.class);
                Soura.txtFile = (position+1) + ".txt";
                intent.putExtra(Soura.txtFile,  position);
                intent.putExtra(inner = SouraName.souraName().get(position), position);
                startActivity(intent);
            }
        });

    recyclerView.setAdapter(adapter);

    }


}
