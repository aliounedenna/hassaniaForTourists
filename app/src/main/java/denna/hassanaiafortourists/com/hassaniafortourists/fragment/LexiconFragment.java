package denna.hassanaiafortourists.com.hassaniafortourists.fragment;


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
import denna.hassanaiafortourists.com.hassaniafortourists.models.Word;


/**
 * A simple {@link Fragment} subclass.
 */
public class LexiconFragment extends Fragment {


    SQLiteHelper db;//base de donnée local
    private ListView lv;
    private List<Word>  words ;
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
        //relier la liste view a son liste view xml
        lv=(ListView)rootView.findViewById(R.id.lexiconlist);
        //unitaite db  with local db
    db = new SQLiteHelper(this.getContext());

        //ajouter des informations a la base de données local pour verifier
        for(int i=0;i<hassania.length;i++){
           // db.insertRecord(new HassaniaToEnglish(hassania[i],englais[i]));
        }




        // prendre tout les mots de la base de donnée local
        words= db.getAllRecords();
        //remplire la liste view avec les mots et leurs traductiton
        if(words.size()!=0){
            CustomLexiconList adapter=new CustomLexiconList(this.getActivity(),words);
            lv.setAdapter(adapter);
        }


        return rootView;
    }


}
