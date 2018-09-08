package com.example.ahmedd.quraan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class Soura extends AppCompatActivity {

    TextView txtSoura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soura);

        txtSoura = (TextView) findViewById(R.id.txtSoura);

        

        String text = "";
        try {
            InputStream inputStream = getAssets().open("1.txt");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            text = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        txtSoura.setText(text);
    }
}
