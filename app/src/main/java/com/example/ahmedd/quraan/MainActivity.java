package com.example.ahmedd.quraan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    TextView txtHello;
    Button btnShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtHello = (TextView) findViewById(R.id.txtHello);
        btnShow = (Button)findViewById(R.id.btnShow);

      /*  btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = "";


                try {
                     InputStream  inputStream = getAssets().open("1.txt");
                    int size = inputStream.available();
                    byte[] buffer = new byte[size];
                    inputStream.read(buffer);
                    inputStream.close();
                    text = new String(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                txtHello.setText(text);
                Toast.makeText(getApplicationContext(),"The file read operation is finished successfully.",
                        Toast.LENGTH_SHORT).show();

            }
        });
*/

    }
}
