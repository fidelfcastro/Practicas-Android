package com.androidapp.fidel.firstandroidapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by fidel on 8/25/2017.
 */

public class MovieAdapter extends ArrayAdapter<Movies>{
    public MovieAdapter(Context context){
        super(context,R.layout.movie_row,R.id.txtMovieName);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View objectView=super.getView(position,convertView,parent);

        TextView txtMovieName=(TextView) objectView.findViewById(R.id.txtMovieName);
        TextView txtMovieDirector=(TextView) objectView.findViewById(R.id.txtMovieDirector);
        TextView txtMovieDuration=(TextView) objectView.findViewById(R.id.txtMovieDuration);
        TextView txtMovieGenre=(TextView) objectView.findViewById(R.id.txtMovieGenre);
        TextView txtMovieYear=(TextView) objectView.findViewById(R.id.txtMovieYear);

        Movies objectMovie = this.getItem(position);
        txtMovieDirector.setText(objectMovie.getDirector());
        txtMovieDuration.setText(String.valueOf(objectMovie.getDuration()));
        txtMovieGenre.setText(objectMovie.getGenre());
        txtMovieName.setText(objectMovie.getName());
        txtMovieYear.setText(String.valueOf(objectMovie.getYear()));

        return objectView;
    }
}
