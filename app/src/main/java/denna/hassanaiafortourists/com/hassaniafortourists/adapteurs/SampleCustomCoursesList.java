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
 * Created by Denna on 21/09/2016.
 */
public class SampleCustomCoursesList extends ArrayAdapter<String> {
    private final Activity context;

    public SampleCustomCoursesList(Activity context) {
        super(context, R.layout.customcourses_layout);
        this.context = context;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.customcourses_layout, null, true);
        return rowView;

    }
}
