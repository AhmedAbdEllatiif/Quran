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

    private RecyclerView recyclerView;
    private SouraListAdapter adapter;
    private List<ItemView> list;
    public static int p = 0;

    public static ItemView itemView;
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





/*


                switch (position){
                    case (0): Soura.txtFile = "1.txt";  p=position;break;
                    case (1): Soura.txtFile = "2.txt";  p =position ;break;
                    case (2): Soura.txtFile = "3.txt";  p =position ;break;
                    case (4): Soura.txtFile = "5.txt";  p =position ;break;
                    case (5): Soura.txtFile = "6.txt";  p =position ;break;
                    case (6): Soura.txtFile = "7.txt";  p =position ;break;
                    case (7): Soura.txtFile = "8.txt";  p =position ;break;
                    case (8): Soura.txtFile = "9.txt";  p =position ;break;
                    case (9): Soura.txtFile = "10.txt";  p =position ;break;
                    case (10): Soura.txtFile = "11.txt";  p =position ;break;
                    case (11): Soura.txtFile = "12.txt";  p =position ;break;
                    case (12): Soura.txtFile = "13.txt";  p =position ;break;
                    case (13): Soura.txtFile = "14.txt";  p =position ;break;
                    case (14): Soura.txtFile = "15.txt";  p =position ;break;
                    case (15): Soura.txtFile = "16.txt";  p =position ;break;
                    case (16): Soura.txtFile = "17.txt";  p =position ;break;
                    case (17): Soura.txtFile = "18.txt";  p =position ;break;
                    case (18): Soura.txtFile = "19.txt";  p =position ;break;
                    case (19): Soura.txtFile = "20.txt";  p =position ;break;
                    case (20): Soura.txtFile = "21.txt";  p =position ;break;
                    case (21): Soura.txtFile = "22.txt";  p =position ;break;
                    case (22): Soura.txtFile = "23.txt";  p =position ;break;
                    case (23): Soura.txtFile = "24.txt";  p =position ;break;
                    case (24): Soura.txtFile = "25.txt";  p =position ;break;
                    case (25): Soura.txtFile = "26.txt";  p =position ;break;
                    case (26): Soura.txtFile = "27.txt";  p =position ;break;
                    case (27): Soura.txtFile = "28.txt";  p =position ;break;
                    case (28): Soura.txtFile = "29.txt";  p =position ;break;
                    case (29): Soura.txtFile = "30.txt";  p =position ;break;
                    case (30): Soura.txtFile = "31.txt";  p =position ;break;
                    case (31): Soura.txtFile = "32.txt";  p =position ;break;
                    case (32): Soura.txtFile = "33.txt";  p =position ;break;
                    case (33): Soura.txtFile = "34.txt";  p =position ;break;
                    case (34): Soura.txtFile = "35.txt";  p =position ;break;
                    case (35): Soura.txtFile = "36.txt";  p =position ;break;
                    case (36): Soura.txtFile = "37.txt";  p =position ;break;
                    case (37): Soura.txtFile = "38.txt";  p =position ;break;
                    case (38): Soura.txtFile = "38.txt";  p =position ;break;
                    case (39): Soura.txtFile = "40.txt";  p =position ;break;
                    case (40): Soura.txtFile = "41.txt";  p =position ;break;
                    case (41): Soura.txtFile = "42.txt";  p =position ;break;
                    case (42): Soura.txtFile = "43.txt";  p =position ;break;
                    case (43): Soura.txtFile = "44.txt";  p =position ;break;
                    case (44): Soura.txtFile = "45.txt";  p =position ;break;
                    case (45): Soura.txtFile = "46.txt";  p =position ;break;
                    case (46): Soura.txtFile = "47.txt";  p =position ;break;
                    case (47): Soura.txtFile = "48.txt";  p =position ;break;
                    case (48): Soura.txtFile = "49.txt";  p =position ;break;
                    case (49): Soura.txtFile = "50.txt";  p =position ;break;
                    case (50): Soura.txtFile = "51.txt";  p =position ;break;
                    case (51): Soura.txtFile = "52.txt";  p =position ;break;
                    case (52): Soura.txtFile = "52.txt";  p =position ;break;
                    case (53): Soura.txtFile = "54.txt";  p =position ;break;
                    case (54): Soura.txtFile = "55.txt";  p =position ;break;
                    case (55): Soura.txtFile = "56.txt";  p =position ;break;
                    case (56): Soura.txtFile = "57.txt";  p =position ;break;
                    case (57): Soura.txtFile = "58.txt";  p =position ;break;
                    case (58): Soura.txtFile = "59.txt";  p =position ;break;
                    case (59): Soura.txtFile = "60.txt";  p =position ;break;
                    case (60): Soura.txtFile = "61.txt";  p =position ;break;
                    case (61): Soura.txtFile = "62.txt";  p =position ;break;
                    case (62): Soura.txtFile = "62.txt";  p =position ;break;
                    case (63): Soura.txtFile = "64.txt";  p =position ;break;
                    case (64): Soura.txtFile = "65.txt";  p =position ;break;
                    case (65): Soura.txtFile = "66.txt";  p =position ;break;
                    case (66): Soura.txtFile = "67.txt";  p =position ;break;
                    case (67): Soura.txtFile = "68.txt";  p =position ;break;
                    case (68): Soura.txtFile = "69.txt";  p =position ;break;
                    case (69): Soura.txtFile = "70.txt";  p =position ;break;
                    case (70): Soura.txtFile = "71.txt";  p =position ;break;
                    case (71): Soura.txtFile = "72.txt";  p =position ;break;
                    case (72): Soura.txtFile = "73.txt";  p =position ;break;
                    case (73): Soura.txtFile = "74.txt";  p =position ;break;
                    case (74): Soura.txtFile = "75.txt";  p =position ;break;
                    case (75): Soura.txtFile = "76.txt";  p =position ;break;
                    case (76): Soura.txtFile = "77.txt";  p =position ;break;
                    case (77): Soura.txtFile = "78.txt";  p =position ;break;
                    case (78): Soura.txtFile = "79.txt";  p =position ;break;
                    case (79): Soura.txtFile = "80.txt";  p =position ;break;
                    case (80): Soura.txtFile = "81.txt";  p =position ;break;
                    case (81): Soura.txtFile = "82.txt";  p =position ;break;
                    case (82): Soura.txtFile = "83.txt";  p =position ;break;
                    case (83): Soura.txtFile = "84.txt";  p =position ;break;
                    case (84): Soura.txtFile = "85.txt";  p =position ;break;
                    case (85): Soura.txtFile = "86.txt";  p =position ;break;
                    case (86): Soura.txtFile = "87.txt";  p =position ;break;
                    case (87): Soura.txtFile = "88.txt";  p =position ;break;
                    case (88): Soura.txtFile = "89.txt";  p =position ;break;
                    case (89): Soura.txtFile = "90.txt";  p =position ;break;
                    case (90): Soura.txtFile = "91.txt";  p =position ;break;
                    case (91): Soura.txtFile = "92.txt";  p =position ;break;
                    case (92): Soura.txtFile = "93.txt";  p =position ;break;
                    case (93): Soura.txtFile = "94.txt";  p =position ;break;
                    case (94): Soura.txtFile = "95.txt";  p =position ;break;
                    case (95): Soura.txtFile = "96.txt";  p =position ;break;
                    case (96): Soura.txtFile = "97.txt";  p =position ;break;
                    case (97): Soura.txtFile = "98.txt";  p =position ;break;
                    case (98): Soura.txtFile = "99.txt";  p =position ;break;
                    case (99): Soura.txtFile = "100.txt";  p =position ;break;
                    case (100): Soura.txtFile = "101.txt";  p =position ;break;
                    case (101): Soura.txtFile = "102.txt";  p =position ;break;
                    case (102): Soura.txtFile = "103.txt";  p =position ;break;
                    case (103): Soura.txtFile = "104.txt";  p =position ;break;
                    case (104): Soura.txtFile = "105.txt";  p =position ;break;
                    case (105): Soura.txtFile = "106.txt";  p =position ;break;
                    case (106): Soura.txtFile = "107.txt";  p =position ;break;
                    case (107): Soura.txtFile = "108.txt";  p =position ;break;
                    case (108): Soura.txtFile = "109.txt";  p =position ;break;
                    case (109): Soura.txtFile = "110.txt";  p =position ;break;
                    case (110): Soura.txtFile = "111.txt";  p =position ;break;
                    case (111): Soura.txtFile = "112.txt";  p =position ;break;
                    case (112): Soura.txtFile = "113.txt";  p =position ;break;
                    case (113): Soura.txtFile = "114.txt";  p =position ;break;
                }
*/

            }
        });
    recyclerView.setAdapter(adapter);

    }


}
