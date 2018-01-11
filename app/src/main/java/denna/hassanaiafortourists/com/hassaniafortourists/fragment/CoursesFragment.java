package denna.hassanaiafortourists.com.hassaniafortourists.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import denna.hassanaiafortourists.com.hassaniafortourists.R;
import denna.hassanaiafortourists.com.hassaniafortourists.activity.AeroportActivity;
import denna.hassanaiafortourists.com.hassaniafortourists.activity.HotelActivity;
import denna.hassanaiafortourists.com.hassaniafortourists.activity.ShopActivity;
import denna.hassanaiafortourists.com.hassaniafortourists.activity.SlamActivity;
import denna.hassanaiafortourists.com.hassaniafortourists.adapteurs.CustomCoursesList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CoursesFragment extends Fragment {

    private ListView lv;
    private String[] hassania = {
            "Slam",
            "El Matar",
            "El Boutique",
            "Hotel"
    };

    private String[] englais = {
            "Greeting",
            "Aeroport",
            "Shop",
            "Hotel"
    };
    private int[] icons = {
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_courses, container, false);

        //relier la liste view a son liste view xml
        lv = (ListView) rootView.findViewById(R.id.coursesList);


        CustomCoursesList adapter = new CustomCoursesList(this.getActivity(), hassania, englais, icons);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Faut passer l'argument "position" en tant que "Bundle" pour l'Activity
                //if(position==1){
                //1 activity slam
                //2 activity El Matar
                //3 activity El Boutique
                //4 activity Hotel
                if(position==0){
                    Intent intent = new Intent(getActivity(), SlamActivity.class);
                    startActivity(intent);
                }
                if(position==1){
                    Intent intent = new Intent(getActivity(), AeroportActivity.class);
                    startActivity(intent);
                }if(position==2){
                    Intent intent = new Intent(getActivity(), ShopActivity.class);
                    startActivity(intent);
                }
                if (position == 3) {
                    Intent intent = new Intent(getActivity(), HotelActivity.class);
                    startActivity(intent);
                }

            }
        });
        return rootView;
    }


}
