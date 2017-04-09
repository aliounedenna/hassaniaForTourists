package denna.hassanaiafortourists.com.hassaniafortourists.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import denna.hassanaiafortourists.com.hassaniafortourists.R;
import denna.hassanaiafortourists.com.hassaniafortourists.adapteurs.CustomSlamList;

public class SlamActivity extends AppCompatActivity {

    private ListView lv;
    private  String[] hassania ={
            "Slam",
            "El Matar",
            "El Boutique",
            "Hotel"
    };
    private  String[] englais ={
            "Greeting",
            "Aeroport",
            "Shop",
            "Hotel"
    };
    private   Integer[] icons={
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slam);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        lv=(ListView)findViewById(R.id.Slam_list);
        CustomSlamList adapter=new CustomSlamList(this, hassania, englais,icons);
        lv.setAdapter(adapter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
