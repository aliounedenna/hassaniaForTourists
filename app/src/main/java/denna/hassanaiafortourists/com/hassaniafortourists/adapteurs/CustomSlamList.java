package denna.hassanaiafortourists.com.hassaniafortourists.adapteurs;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import denna.hassanaiafortourists.com.hassaniafortourists.R;

/**
 * Created by Denna on 22/09/2016.
 */
public class CustomSlamList  extends ArrayAdapter<String> {
    private final Activity context;
    private  String[] Hassania;
    private  String[] englais ;


    public CustomSlamList(Activity context, String[] Hassania, String[] englais) {
        super(context, R.layout.customslamlist_layout, Hassania);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.Hassania=Hassania;
        this.englais = englais;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.customslamlist_layout, null, true);


        ImageView icon = (ImageView) rowView.findViewById(R.id.voie);
        TextView hassania = (TextView) rowView.findViewById(R.id.Hassania);
        TextView englais = (TextView) rowView.findViewById(R.id.anglais);
//TODO remplacer l'icon par icon voie
        icon.setImageResource(R.drawable.play);
        hassania.setText(Hassania[position]);
        englais.setText(this.englais[position]);
        return rowView;

    }
}
