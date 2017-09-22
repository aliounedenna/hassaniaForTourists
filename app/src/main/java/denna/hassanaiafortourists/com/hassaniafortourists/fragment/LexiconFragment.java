package denna.hassanaiafortourists.com.hassaniafortourists.fragment;


import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import denna.hassanaiafortourists.com.hassaniafortourists.R;
import denna.hassanaiafortourists.com.hassaniafortourists.adapteurs.CustomLexiconList;
import denna.hassanaiafortourists.com.hassaniafortourists.helper.SQLiteHelper;
import denna.hassanaiafortourists.com.hassaniafortourists.models.HassaniaToEnglish;


/**
 * A simple {@link Fragment} subclass.
 */
public class LexiconFragment extends Fragment {


    private ListView lv;
    SQLiteOpenHelper db;//base de donnée local
    private List<HassaniaToEnglish> [] words ;
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
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =inflater.inflate(R.layout.fragment_lexicon, container, false);


    db = new SQLiteHelper(this.getContext());

        words= db.get();
   lv=(ListView)rootView.findViewById(R.id.lexiconlist);

        CustomLexiconList adapter=new CustomLexiconList(this.getActivity(),words);
        lv.setAdapter(adapter);
        return rootView;
    }


}
