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

public class SlamActivity extends AppCompatActivity {

    private ListView lv;
    private ImageView icon_photo;
    private  String[] hassania ={
            "Salamoou alikoum",
            "wa alikoum selam",
            "Nte chahalak?",
            "lebas, chahalak ente?",
            "lebas, chahal ehel dar?",
            "lebas alihoum,bikheyr. chatari",
            "Mareytou, ela chakle w dar.",
            "ok. wedatak lmoulana. selemli ala ehl dar.",
            "balek, wedatak lmoulane."
    };
    private  String[] englais ={
            "Peace be upon on you",
            "Peace be upon on you too",
            "How are you",
            "fine, and you",
            "fine, how is your familly?",
            "they are fine and safe, wht's up?",
            "nothing, judt work and home.",
            "ok. god bless you. gret all the familly.",
            "I will. god bless you."
    };



    // TODO preparer les coures et activer l'option lire en activans la connection et lire un vocal distant
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slam);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        lv=(ListView)findViewById(R.id.Slam_list);
        //TODO a remplacer par icon Slame
        icon_photo= (ImageView) findViewById(R.id.iconSlame);

        CustomSlamList adapter=new CustomSlamList(this, hassania, englais);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }

}
