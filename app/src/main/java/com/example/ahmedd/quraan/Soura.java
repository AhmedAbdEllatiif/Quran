package com.example.ahmedd.quraan;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ahmedd.quraan.Adapters.SouraAdapter;
import com.example.ahmedd.quraan.Adapters.SouraListAdapter;
import com.example.ahmedd.quraan.Model.ItemView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;


public class Soura extends AppCompatActivity {

    private TextView txtSoura;
    private RecyclerView recyclerView;
    private SouraAdapter adapter;
    List<ItemView> itemViews;
    public static TextView innerTxtSouraName;
    public static String txtFile = "";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soura);

        LinearLayoutManager linearLayout  = new LinearLayoutManager(this);
        itemViews = new ArrayList<>();

        innerTxtSouraName = (TextView) findViewById(R.id.innerTxtSouraName);
        recyclerView = (RecyclerView) findViewById(R.id.ayatRecycler);
        recyclerView.setLayoutManager(linearLayout);

        ArrayList<String> ayat = new ArrayList<>();

        InputStream fIn = null;
        InputStreamReader isr = null;
        BufferedReader input = null;
        try {
            Context context = this;
            fIn = context.getResources().getAssets()
                    .open(txtFile, Context.MODE_WORLD_READABLE);
            isr = new InputStreamReader(fIn);
            input = new BufferedReader(isr);
            String line = "";
            int i = 1;
            while ((line = input.readLine()) != null) {
                ayat.add(line + "(" + i + ")" + "\n");
                i++;
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                if (isr != null)
                    isr.close();
                if (fIn != null)
                    fIn.close();
                if (input != null)
                    input.close();
            } catch (Exception e2) {
                e2.getMessage();
            }
        }

        for (int i =0; i<ayat.size(); i++){
            ItemView itemView = new ItemView(null,ayat.get(i));

            itemViews.add(itemView);
        }

        adapter = new SouraAdapter(this,itemViews);
        recyclerView.setAdapter(adapter);

    }//onCreate



}