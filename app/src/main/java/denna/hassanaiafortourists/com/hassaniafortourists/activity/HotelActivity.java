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

public class HotelActivity extends AppCompatActivity {
    private ListView lv;
    private ImageView icon_photo;
    private  String[] hassania ={
            "Salamoou alikoum",
            "wa alikoum selam",
            "Ane adalet reservation sbou lavayet ve net",
            "esmak chenhou",
            "Jack Mayer",
            "Eheh. Reservation l sbou.",
            "wallahi",
            "Atini passport we dor netaloulak bagagek. hak mouvtahak. chambre 5",
            "Choukrane.",
            "Merehba bik vi Mauritania."
    };
    private  String[] englais ={
            "Peace be upon on you",
            "Peace be upon on you too",
            "I have made a reservation last week via internet",
            "What's your name?",
            "Jack Mayer",
            "Yes. a reservation for one week?",
            "Yes",
            "Give me your passport and we will send yourluggage just after you. Take you keys. Room number 5.",
            "Thank you.",
            "welcom in Mauritania."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        lv=(ListView)findViewById(R.id.hotel_list);
        //TODO a remplacer par icon Slame
        icon_photo= (ImageView) findViewById(R.id.iconhotel);

        CustomSlamList adapter=new CustomSlamList(this, hassania, englais);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }

}
