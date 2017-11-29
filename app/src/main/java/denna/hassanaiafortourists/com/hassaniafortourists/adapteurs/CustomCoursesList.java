package denna.hassanaiafortourists.com.hassaniafortourists.adapteurs;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import denna.hassanaiafortourists.com.hassaniafortourists.R;
import denna.hassanaiafortourists.com.hassaniafortourists.models.Word;

/**
 * Created by Denna on 21/09/2016.
 */
public class CustomCoursesList extends ArrayAdapter<String> {
    private final Activity context;
    private String[] hassania,englais;
    private int[] icons;

    public CustomCoursesList(Activity context, String[] hassania ,String[] englais,int[] icons) {
        super(context, R.layout.customcourses_layout);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.hassania = hassania;
        this.englais = englais;
        this.icons = icons;
    }

    @Override
    public int getCount() {
        return hassania.length;
    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Log.e("course adapter", "adapter get view");
        LayoutInflater inflater = (LayoutInflater) context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.customcourses_layout, null, true);


        ImageView icon = (ImageView) rowView.findViewById(R.id.icon_course);
        TextView hassania = (TextView) rowView.findViewById(R.id.english);
        TextView englais = (TextView) rowView.findViewById(R.id.hassinia_text);

        icon.setImageResource(this.icons[position]);
        hassania.setText(this.hassania[position]);
        englais.setText(this.englais[position]);
        return rowView;

    }
}
