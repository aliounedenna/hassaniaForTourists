package denna.hassanaiafortourists.com.hassaniafortourists.fragment;


import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import denna.hassanaiafortourists.com.hassaniafortourists.R;
import denna.hassanaiafortourists.com.hassaniafortourists.helper.SQLiteHelper;
import denna.hassanaiafortourists.com.hassaniafortourists.models.Word;
import denna.hassanaiafortourists.com.hassaniafortourists.activity.SlamActivity;
import denna.hassanaiafortourists.com.hassaniafortourists.adapteurs.CustomCoursesList;
import denna.hassanaiafortourists.com.hassaniafortourists.adapteurs.SampleCustomCoursesList;
import denna.hassanaiafortourists.com.hassaniafortourists.rest.ApiInterface;
import denna.hassanaiafortourists.com.hassaniafortourists.rest.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class CoursesFragment extends Fragment {

    private ListView lv;
    private getWords getRemoteTask = null;

    public void updateView(String fro) {
        Log.e("called from:", fro);
        SQLiteHelper db = new SQLiteHelper(this.getActivity());
        List<Word> words = db.getAllRecords();

        CustomCoursesList adapter = new CustomCoursesList(this.getActivity(), words);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // TODO Faut passer l'argument "position" en tant que "Bundle" pour l'Activity
                Intent intent = new Intent(getActivity(), SlamActivity.class);
                startActivity(intent);
            }
        });

        lv.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_courses, container, false);


        final ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        lv = (ListView) rootView.findViewById(R.id.coursesList);


        updateView("main");

        if (getRemoteTask == null) {
            getRemoteTask = new getWords(apiService, lv, rootView, this.getActivity());
            getRemoteTask.execute((Void) null);
        }

        return rootView;
    }


    public class getWords extends AsyncTask<Void, Void, Boolean> {

        private Activity context;
        private final ApiInterface apiService;
        private final ListView lv;
        private final View rootView;

        getWords(ApiInterface apiService, ListView lv, View rootView, Activity context) {
            this.apiService = apiService;
            this.lv = lv;
            this.rootView = rootView;
            this.context = context;

        }

        @Override
        protected Boolean doInBackground(Void... params) {

            try {
                Log.e("doInBackground", "getting words");
                // cat, km, page, sort, search
                // les valeurs que tu veux pas utiliser tu peux les changer par null
                //TODO change api to get next days events without specifing category
                final Call<List<Word>> call = this.apiService.getWords();
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
                    public void onFailure(Call<List<Word>> call, Throwable t) {
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
