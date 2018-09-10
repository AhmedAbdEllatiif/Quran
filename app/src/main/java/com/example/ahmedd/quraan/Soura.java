package com.example.ahmedd.quraan;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import com.example.ahmedd.quraan.Adapters.SouraAdapter;
import com.example.ahmedd.quraan.Model.ItemView;
import com.r0adkll.slidr.Slidr;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Soura extends AppCompatActivity {

    private List<ItemView> itemViews;
    private TextView innerTxtSouraName;
    public static String txtFile = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ayat_recycler);

        setupViews();
        innerTxtSouraName.setText(MainActivity.inner);
        fillRecyclerLineByLine();
        Slidr.attach(this);





    }//onCreate

    @SuppressLint("WorldReadableFiles")
    private void fillRecyclerLineByLine(){
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
            String line;
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

        for (int i = 0; i < ayat.size(); i++) {
            ItemView itemView = new ItemView(null, ayat.get(i));

            itemViews.add(itemView);
        }

    }

    private void setupViews(){
        itemViews = new ArrayList<>();
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        SouraAdapter adapter = new SouraAdapter(this, itemViews);

        innerTxtSouraName = findViewById(R.id.innerTxtSouraName);
        RecyclerView recyclerView = findViewById(R.id.ayatRecycler);
        recyclerView.setLayoutManager(linearLayout);
        recyclerView.setAdapter(adapter);
    }

}