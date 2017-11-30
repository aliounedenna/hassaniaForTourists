package denna.hassanaiafortourists.com.hassaniafortourists.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import denna.hassanaiafortourists.com.hassaniafortourists.R;
import denna.hassanaiafortourists.com.hassaniafortourists.adapteurs.CustomSlamList;

public class ShopActivity extends AppCompatActivity {
    private ListView lv;
    private ImageView icon_photo;
    private  String[] hassania ={
            "Salamoou alikoum",
            "wa alikoum selam",
            "Atini mbouraye wa bouche men leben",
            "Wallahy. mbouraye bi 100 MRO(Mite ouguiya) we bouche leben be 250 MRO(miteyn wi kamsine ouguiya). lmejmou thalath miya w kamsine(350 MRO). wi tove?",
            "Manala. zidni bouch mine lme",
            "ok. Arba miya wa kamsine(450 MRO).",
            "Hak. Andi elve(1000 MRO).",
            "Hak. degdig",
            "Non Khalihe lak :)",
            "Choukrane."
    };
    private  String[] englais ={
            "Peace be upon on you",
            "Peace be upon on you too",
            "give me one bread and one bottle of milk.",
            "ok.100 MRO for the bread and 250 MRO for the bottel of milk. the total is 350 MRO. Is that all?",
            "No. add a bottle of water",
            "ok. 450 MRO",
            "Take. I am having 1000 MRO...",
            "Take. here is your change.",
            "No. Keep it",
            "Thank you"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        lv=(ListView)findViewById(R.id.shop_list);
        //TODO a remplacer par icon Slame
        icon_photo= (ImageView) findViewById(R.id.iconshop);

        CustomSlamList adapter=new CustomSlamList(this, hassania, englais);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

}
