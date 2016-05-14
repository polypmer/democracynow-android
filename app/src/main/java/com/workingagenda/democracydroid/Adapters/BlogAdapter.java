package com.workingagenda.democracydroid.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.workingagenda.democracydroid.Objects.Episode;
import com.workingagenda.democracydroid.R;

import java.util.List;

/**
 * Created by fen on 4/10/16.
 */
public class BlogAdapter extends ArrayAdapter<Episode> {

    public BlogAdapter(Context context, int textViewResourceId){
        super(context, textViewResourceId);
    }

    public BlogAdapter(Context context, int resource, List<Episode> episodes){
        super(context, resource, episodes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View v = convertView;

        if(v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.row_blog, null);
        }

        Episode b = getItem(position);
        if (b != null) {
            ImageView img = (ImageView) v.findViewById(R.id.row_image);
            TextView txt = (TextView) v.findViewById(R.id.row_title);
            if(b.getVideoUrl() != null){
                try {
                    Picasso.with(getContext()).load(b.getImageUrl()).into(img);
                } catch (Exception ex) {
                    Log.v("Blog Adapter", "exception");
                }
            } else {
                Picasso.with(getContext()).load(R.drawable.ic_library_books_black_24dp).into(img);
            }


            if (txt != null) {
                txt.setText(b.getTitle());

            }
        }

        return v;
    }
}
