package com.example.ahmedd.quraan.Soura;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.ahmedd.quraan.Adapters.SouraAdapter;
import com.example.ahmedd.quraan.BaseActivities.BaseActivity;
import com.example.ahmedd.quraan.Model.SouraModel;
import com.example.ahmedd.quraan.R;
import com.r0adkll.slidr.Slidr;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Soura extends BaseActivity {

    private List<SouraModel> souraModels;
    private TextView innerTxtSouraName;
    private String innerTitle;
    private String txtFile;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ayat_recycler);

        setupViews();
        setInnerTitle();
        fillRecyclerLineByLine();
        Slidr.attach(activity);

    }//onCreate


    private void setInnerTitle() {
        if (getIntent().getStringExtra("InnerTitle") != null) {
            Log.e("InnerTitle", "Put extra From QuranFragment Succeed");
            innerTitle = getIntent().getStringExtra("InnerTitle");
        } else {
            Log.e("InnerTitle", "InnerTitle =Null,Check putExtra QuranFragment");
        }
        innerTxtSouraName.setText(innerTitle);
    }

    @SuppressLint("WorldReadableFiles")
    private void fillRecyclerLineByLine() {
        ArrayList<String> ayat = new ArrayList<>();

        if (getIntent().getStringExtra("txtFile") != null) {
            txtFile = getIntent().getStringExtra("txtFile");
        } else {
            Log.e("TextFile Quran", "TextFile =Null,Check putExtra QuranFragment");
        }

        InputStream fIn = null;
        InputStreamReader isr = null;
        BufferedReader input = null;
        try {
            fIn = activity.getResources().getAssets()
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
            SouraModel souraModel = new SouraModel(null, ayat.get(i));
            souraModels.add(souraModel);
        }

    }

    private void setupViews() {
        souraModels = new ArrayList<>();
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        SouraAdapter adapter = new SouraAdapter(activity, souraModels);

        innerTxtSouraName = findViewById(R.id.innerTxtSouraName);
        RecyclerView recyclerView = findViewById(R.id.ayatRecycler);
        recyclerView.setLayoutManager(linearLayout);
        recyclerView.setAdapter(adapter);
    }

}