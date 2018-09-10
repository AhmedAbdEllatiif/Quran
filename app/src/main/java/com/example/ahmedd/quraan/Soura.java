package com.example.ahmedd.quraan;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;
import com.example.ahmedd.quraan.Adapters.SouraAdapter;
import com.example.ahmedd.quraan.Model.ItemView;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Soura extends AppCompatActivity {

    private TextView txtSoura;
    private RecyclerView recyclerView;
    private SouraAdapter adapter;
    List<ItemView> itemViews;
    public static TextView innerTxtSouraName;
    public static String txtFile = "";
    GestureDetector gestureDetector;
    float x1, x2, y1, y2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ayat_recycler);

        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
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

        for (int i = 0; i < ayat.size(); i++) {
            ItemView itemView = new ItemView(null, ayat.get(i));

            itemViews.add(itemView);
        }

        adapter = new SouraAdapter(this, itemViews);
        recyclerView.setAdapter(adapter);
        gestureDetector = new GestureDetector(this, new MyGesture());

    }//onCreate

    public boolean onTouchEvent(MotionEvent touchEvent) {
        this.gestureDetector.onTouchEvent(touchEvent);
        return super.onTouchEvent(touchEvent);

    }

class MyGesture extends GestureDetector.SimpleOnGestureListener{
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2,
                           float velocityX, float velocityY) {

        if (e2.getX() > e1.getX()){
        onBackPressed();
        }
        if(e2.getX() < e1.getX()){

        return false;
        }
        return true;
    }
}
}