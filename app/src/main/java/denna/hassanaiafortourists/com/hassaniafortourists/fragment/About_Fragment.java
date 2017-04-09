package denna.hassanaiafortourists.com.hassaniafortourists.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import denna.hassanaiafortourists.com.hassaniafortourists.R;

/**
 * Created by Denna on 04/12/2016.
 */
public class About_Fragment extends Fragment {

    TextView about_TextView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =inflater.inflate(R.layout.fragment_about, container, false);


        about_TextView=(TextView)rootView.findViewById(R.id.about_text_view);

        return rootView;
    }
}
