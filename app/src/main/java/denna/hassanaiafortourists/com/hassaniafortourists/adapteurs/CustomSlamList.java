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
    private   Integer[] icons;

    public CustomSlamList(Activity context, String[] Hassania, String[] englais,   Integer[] icons) {
        super(context, R.layout.customslamlist_layout, Hassania);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.Hassania=Hassania;
        this.englais = englais;
        this.icons=icons;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.customslamlist_layout, null, true);


        ImageView icon = (ImageView) rowView.findViewById(R.id.voie);
        TextView hassania = (TextView) rowView.findViewById(R.id.anglais);
        TextView englais = (TextView) rowView.findViewById(R.id.Hassania);

        icon.setImageResource(icons[position]);
        hassania.setText(Hassania[position]);
        englais.setText(this.englais[position]);
        return rowView;

    }
}
