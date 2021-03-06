package denna.hassanaiafortourists.com.hassaniafortourists.fragment;


import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import denna.hassanaiafortourists.com.hassaniafortourists.R;
import denna.hassanaiafortourists.com.hassaniafortourists.adapteurs.CustomLexiconList;
import denna.hassanaiafortourists.com.hassaniafortourists.helper.SQLiteHelper;
import denna.hassanaiafortourists.com.hassaniafortourists.models.Word;
import denna.hassanaiafortourists.com.hassaniafortourists.rest.ApiClient;
import denna.hassanaiafortourists.com.hassaniafortourists.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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


    private getWords getRemoteTask = null;

    public void updateView(String fro) {
        SQLiteHelper db = new SQLiteHelper(this.getActivity());
        words = db.getAllRecords();
        Log.e("update view from :", fro);
        if(words.size()!=0){

            CustomLexiconList adapter = new CustomLexiconList(this.getActivity(), words);
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    // TODO Lancer le son relatif a ce mots clicker

                }
            });
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =inflater.inflate(R.layout.fragment_lexicon, container, false);
        final ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        lv = (ListView) rootView.findViewById(R.id.lexiconlist);


        updateView("main");

        if (getRemoteTask == null) {
            getRemoteTask = new getWords(apiService, lv, rootView, getActivity());
            getRemoteTask.execute((Void) null);
        }

        return rootView;
    }

    public class getWords extends AsyncTask<Void, Void, Boolean> {

        private final ApiInterface apiService;
        private final ListView lv;
        private final View rootView;
        private Activity context;

        getWords(ApiInterface apiService, ListView lv, View rootView, Activity context) {
            this.apiService = apiService;
            this.lv = lv;
            this.rootView = rootView;
            this.context = context;

        }

        @Override
        protected Boolean doInBackground(Void... params) {

            try {
             //Log.e("doInBackground", "getting words");
                // cat, km, page, sort, search
                // les valeurs que tu veux pas utiliser tu peux les changer par null
                //TODO change api to get next days events without specifing category
                final retrofit2.Call<List<Word>> call = this.apiService.getWords(1);
                call.enqueue(new Callback<List<Word>>() {
                    @Override
                    public void onResponse(Call<List<Word>> call, Response<List<Word>> response) {
                        Log.e("onResponse", "got response");

                        // après le telechargement de la base de données distante
                        List<Word> words = response.body();
                        SQLiteHelper db = new SQLiteHelper(context);
                        // inserer dans la base de données local

                        for (int i = 0; i < words.size(); i++) {
                            // db.insertRecord est modifié, elle va pas anouté un mot en "hassaniya" qui existe deja"
                            db.insertRecord(words.get(i));
                        }
                        // update the view after fetching
                        updateView("async");

                    }

                    @Override
                    public void onFailure(retrofit2.Call<List<Word>> call, Throwable t) {
                        // Log error here since request failed
                        Log.e("Error on async", t.toString());
                    }
                });


            } catch (Exception e) {
                Log.e("Error: ", e.toString());
                return false;
            }

            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            getRemoteTask = null;

        }


        @Override
        protected void onCancelled() {
            getRemoteTask = null;
        }

    }
}
