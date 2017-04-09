package denna.hassanaiafortourists.com.hassaniafortourists.adapteurs;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import denna.hassanaiafortourists.com.hassaniafortourists.R;

/**
 * Created by Denna on 22/09/2016.
 */
public class CustomLexiconList extends ArrayAdapter<String> {
    private final Activity context;
    private  String[] Hassania;
    private  String[] englais ;


    public CustomLexiconList(Activity context, String[] Hassania, String[] englais) {
        super(context, R.layout.customlexiconlist, Hassania);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.Hassania=Hassania;
        this.englais = englais;

    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.customlexiconlist, null, true);



        TextView hassania = (TextView) rowView.findViewById(R.id.singleHassania);
        TextView englais = (TextView) rowView.findViewById(R.id.singleEnglish);


        hassania.setText(Hassania[position]);
        englais.setText(this.englais[position]);
        return rowView;

    }
}
