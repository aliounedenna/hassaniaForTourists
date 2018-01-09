package denna.hassanaiafortourists.com.hassaniafortourists.adapteurs;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import denna.hassanaiafortourists.com.hassaniafortourists.R;
import denna.hassanaiafortourists.com.hassaniafortourists.models.Word;

/**
 * Created by Denna on 22/09/2016.
 */
public class CustomLexiconList extends ArrayAdapter<String> {
    private final Activity context;
    private List<Word> words;


    public CustomLexiconList(Activity context, List<Word> words) {

        super(context, R.layout.customlexiconlist);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.words = words;

        Log.e("waslou size:", String.valueOf(words.size()));

    }


    @Override
    public int getCount() {
        return words.size();
    }


    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.customlexiconlist, null, true);


        Log.e("get view:", String.valueOf(words.size()));
        TextView hassania = (TextView) rowView.findViewById(R.id.singleHassania);

        TextView englais = (TextView) rowView.findViewById(R.id.singleEnglish);

        hassania.setText(words.get(position).getWdHassania());
        System.out.println(words.get(position).getWdHassania());
        englais.setText(words.get(position).getWdEnglish());
        System.out.println(words.get(position).getWdEnglish());
        return rowView;

    }
}
