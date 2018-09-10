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
import android.text.method.ScrollingMovementMethod;
import android.view.ViewGroup;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;


public class Soura extends AppCompatActivity {

    TextView txtSoura;
    public ViewGroup.LayoutParams params;
    public static TextView innerTxtSouraName;
    private Paint paint;

    SouraName souraName;
    ArrayList<String> arrayName;
    public static String txtFile = "";

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soura);

        innerTxtSouraName = (TextView) findViewById(R.id.innerTxtSouraName);
        txtSoura = (TextView) findViewById(R.id.txtSoura);
        txtSoura.setMovementMethod(new ScrollingMovementMethod());
        paint = new Paint();

        //SouraName.innerSouraName();
       /* switch (MainActivity.p){
            case(0) : innerTxtSouraName.setText(arrayName.get(0));
            case(1) : innerTxtSouraName.setText(arrayName.get(1));
            case(3) : Soura.innerTxtSouraName.setText(arrayName.get(3));
            case(4) : Soura.innerTxtSouraName.setText(arrayName.get(4));
            case(5) : Soura.innerTxtSouraName.setText(arrayName.get(5));
            case(6) : Soura.innerTxtSouraName.setText(arrayName.get(6));
        }*/
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
                txtSoura.append(line + "(" + i + ")" + "\n");
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
    }//onCreate



}