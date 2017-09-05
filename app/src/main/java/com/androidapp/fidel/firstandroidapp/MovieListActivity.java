package com.androidapp.fidel.firstandroidapp;

import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MovieListActivity extends AppCompatActivity {
    MovieAdapter objectMovieAdapter;
    ListView objectListView;
    ArrayList<Movies> movieArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       // Button deleteMovieBtn = (Button) findViewById(R.id.deleteMovie);

        objectListView=(ListView) findViewById(R.id.lv_movieList);
        objectMovieAdapter=new MovieAdapter(this);
        objectListView.setAdapter(objectMovieAdapter);


        movieArray = this.getIntent().getParcelableArrayListExtra("Array");
        fillMovieDatabase(movieArray);

//        deleteMovieBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                View parentRow = (View) view.getParent();
////                ListView listView = (ListView) parentRow.getParent();
////                final int position = listView.getPositionForView(parentRow);
//                //movieArray.remove(position);
//
//            }
//        });
    }


    @Override
    public void onBackPressed() {
        back();
    }

    public void back(){
        Intent oIntent = new Intent();
        oIntent.putExtra("returnResult",movieArray);
        setResult(MainActivity.RESULT_OK,oIntent);
        finish();
    }

    private void fillMovieDatabase(ArrayList<Movies> lMovies) {
        objectMovieAdapter.clear();

        for(Movies oMovie:lMovies) {
            objectMovieAdapter.add(oMovie);

        }

        objectMovieAdapter.notifyDataSetChanged();
    }
}
