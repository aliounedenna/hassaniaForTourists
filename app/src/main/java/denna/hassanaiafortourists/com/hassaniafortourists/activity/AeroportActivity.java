package denna.hassanaiafortourists.com.hassaniafortourists.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import denna.hassanaiafortourists.com.hassaniafortourists.R;
import denna.hassanaiafortourists.com.hassaniafortourists.adapteurs.CustomSlamList;


public class AeroportActivity extends AppCompatActivity {
    private ListView lv;
    private ImageView icon_photo;
    private  String[] hassania ={
            "Salamoou alikoum",
            "wa alikoum selam.passport mine vadlak",
            "Wallahi. Tfadal.",
            "Nte jaye siyaha walla chakle?",
            "jaye chakla. andi randez-vous maa cherike lahi nesetathmar vihe. yalla ioudou ihanouni",
            "ok. andak rakemhoum?",
            "oui. hak",
            "ok.merehba bik vi Mauritania",
            "choukrane :)"
    };
    private  String[] englais ={
            "Peace be upon on you",
            "Peace be upon on you too. Passport please",
            "ok. Here it is",
            "are you here for tourism or for work?",
            "I am here for work. I have a rendez-vous with a company i am witing to in. They shoud be waiting for me",
            "ok. do you have their phone number.",
            "yes. Here it is.",
            "ok. Welcome in Mauritania",
            "Thank you"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aeroport);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lv=(ListView)findViewById(R.id.aeroport_list);
        //TODO a remplacer par icon Slame
        icon_photo= (ImageView) findViewById(R.id.iconaeroport);

        CustomSlamList adapter=new CustomSlamList(this, hassania, englais);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

}
