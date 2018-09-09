package com.example.ahmedd.quraan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    public static MyAdapter adapter;
    private List<ItemView> list;
    ItemView itemView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        list = new ArrayList<>();
        adapter = new MyAdapter(this, list);

        adapter.setOnItemClickListener(new MyAdapter.onItemClickListener() {
            @Override
            public void onClick(int position, ItemView itemView) {
                Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,Soura.class);
                startActivity(intent);


                switch (position){
                    case (0): Soura.txtFile = "1.txt";break;
                    case (1): Soura.txtFile = "2.txt";break;
                    case (2): Soura.txtFile = "3.txt";break;

                }
            }
        });



    for (int i=0; i<souraName().size(); i++ ){

        ItemView itemView = new ItemView(souraName().get(i) + " (" + (i+1) + ")");

        list.add(itemView);
    }

    recyclerView.setAdapter(adapter);

    }

    private ArrayList<String> souraName(){

        ArrayList<String> arrayName = new ArrayList<>();

        arrayName.add(" سورة الفاتحة");
        arrayName.add("سورة البقرة");
        arrayName.add("سورة آل عمران");
        arrayName.add("سورة النساء");
        arrayName.add("سورة المائدة");
        arrayName.add("سورة الأنعام");
        arrayName.add("سورة الأعراف");
        arrayName.add("سورةالانفال");
        arrayName.add("سورةالتوبة");
        arrayName.add("سورة يونس");
        arrayName.add("سورة هود");
        arrayName.add("سورةيوسف ");
        arrayName.add("سورة الرعد");
        arrayName.add("سورة ابراهيم");
        arrayName.add("سورة الحجر");
        arrayName.add("سورة النحل");
        arrayName.add("سورة الاسراء");
        arrayName.add("سورة الكهف");
        arrayName.add("سورة مريم");
        arrayName.add("سورة طه");
        arrayName.add("سورة الأنبياء");
        arrayName.add("سورة  الحج");
        arrayName.add("سورة المؤمنون");
        arrayName.add("سورة النور");
        arrayName.add("سورة الفرقان");
        arrayName.add("سورة الشعراء");
        arrayName.add("سورة النمل");
        arrayName.add("سورة القصص");
        arrayName.add("سورة العنكبوت");
        arrayName.add("سورة الروم");
        arrayName.add("سورة لقمان");
        arrayName.add("سورة السجدة");
        arrayName.add("سورة الأحزاب");
        arrayName.add("سورة سبأ");
        arrayName.add("سورة فاطر");
        arrayName.add("سورة  يس");
        arrayName.add("سورة  الصّافّات");
        arrayName.add("سورة ص");
        arrayName.add("سورة الزمر");
        arrayName.add("سورة غافر");
        arrayName.add("سورة فصلت");
        arrayName.add("سورة الشورى");
        arrayName.add("سورة الزخرف");
        arrayName.add("سورة الدخان");
        arrayName.add("سورة الجاثية");
        arrayName.add("سورة الأحقاف");
        arrayName.add("سورة محمد");
        arrayName.add("سورة الفتح");
        arrayName.add("سورة الحجرات");
        arrayName.add("سورة ق");
        arrayName.add("سورة الذاريات");
        arrayName.add("سورة الطور");
        arrayName.add("سورة النجم");
        arrayName.add("سورة القمر");
        arrayName.add("سورة الرحمن");
        arrayName.add("سورة الواقعة");
        arrayName.add("سورة الحديد");
        arrayName.add("سورة المجادلة");
        arrayName.add("سورة الحشر");
        arrayName.add("سورة الممتحنة");
        arrayName.add("سورة الصف");
        arrayName.add("سورة الجمعة");
        arrayName.add("سورة المنافقون");
        arrayName.add("سورة التغابن");
        arrayName.add("سورة الطلاق");
        arrayName.add("سورة التحريم");
        arrayName.add("سورة الملك");
        arrayName.add("سورة القلم");
        arrayName.add("سورة الحّاقة");
        arrayName.add("سورة المعارج");
        arrayName.add("سورة  نوح");
        arrayName.add("سورة الجن");
        arrayName.add("سورة المزمل");
        arrayName.add("سورة المدثر");
        arrayName.add("سورة القيامة");
        arrayName.add("سورة الانسان");
        arrayName.add("سورة المرسلات");
        arrayName.add("سورة النبأ");
        arrayName.add("سورة النازعات");
        arrayName.add("سورة عبس");
        arrayName.add("سورة التكوير");
        arrayName.add("سورة الانفطار");
        arrayName.add("سورة المطففين");
        arrayName.add("سورة الانشقاق");
        arrayName.add("سورة البروج");
        arrayName.add("سورة الطارق");
        arrayName.add("سورة الأعلى");
        arrayName.add("سورة الغاشية");
        arrayName.add("سورة الفجر");
        arrayName.add("سورة البلد");
        arrayName.add("سورة الشمس");
        arrayName.add("سورة الليل");
        arrayName.add("سورة الضحى");
        arrayName.add("سورة الشرح");
        arrayName.add("سورة التين");
        arrayName.add("سورة العلق");
        arrayName.add("سورة القدر");
        arrayName.add("سورة البينة");
        arrayName.add("سورة الزلزلة");
        arrayName.add("سورة العاديات");
        arrayName.add("سورة القارعة");
        arrayName.add("سورة التكاثر");
        arrayName.add("سورة العصر");
        arrayName.add("سورة الهمزة");
        arrayName.add("سورة الفيل");
        arrayName.add("سورة قريش");
        arrayName.add("سورة الماعون");
        arrayName.add("سورة الكوثر");
        arrayName.add("سورة الكافرون");
        arrayName.add("سورة النصر");
        arrayName.add("سورة المسد");
        arrayName.add("سورة الاخلاص");
        arrayName.add("سورة الفلق");
        arrayName.add("سورة الناس");

        return arrayName;
    }
}
