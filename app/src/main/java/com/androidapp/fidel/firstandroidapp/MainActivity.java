package com.androidapp.fidel.firstandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public final static String MICONSTANTE="message";
    public final static int RETURN_CODE = 1;

    ArrayList<Movies> movieArray = new ArrayList<Movies>();
//        add(new Movies("test", 120,"test","test", 1994));
//        add(new Movies("test", 75,"test","test", 1992));
//        add(new Movies("test", 120,"test","test", 2006));
//        add(new Movies("test", 120,"test","test", 1991));
//        add(new Movies("test", 120,"test","test", 2014));
//    }};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        Button btn_click = (Button) findViewById(R.id.btnClick);
        Button addMovieBtn_click = (Button) findViewById(R.id.addMovie);
        Button deleteMovieBtn = (Button) findViewById(R.id.rmMovie);

        final EditText txt_name = (EditText) findViewById(R.id.txtName);
        final EditText txt_movieName = (EditText) findViewById(R.id.movieName);
        final EditText txt_directorName = (EditText) findViewById(R.id.dirText);
        final EditText txt_duration = (EditText) findViewById(R.id.durationText);
        final EditText txt_genre = (EditText) findViewById(R.id.genreText);
        final EditText txt_year = (EditText) findViewById(R.id.yearText);
        final EditText txt_removeMovie = (EditText) findViewById(R.id.rmMovieText);

        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),txt_name.getText().toString(), Toast.LENGTH_LONG).show();
                Snackbar.make(view,txt_name.getText().toString(), Snackbar.LENGTH_LONG).setAction("Action",null).show();
            }
        });


        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ActividadUno.class);
                EditText editText = (EditText) findViewById(R.id.txtName);
                String message = editText.getText().toString();
                intent.putExtra(MICONSTANTE,message);
                startActivity(intent);

            }
        });

        addMovieBtn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MovieListActivity.class);
                String name = txt_movieName.getText().toString();
                String director = txt_directorName.getText().toString();
                String duration = txt_duration.getText().toString();
                String genre = txt_genre.getText().toString();
                String year = txt_year.getText().toString();
                Movies movie = new Movies(
                  name, duration, director, genre, year
                );
                movieArray.add(movie);
                intent.putExtra("Array", movieArray);
                //startActivity(intent);
                startActivityForResult(intent,RETURN_CODE);
            }
        });

        deleteMovieBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean activity = false;
                String name = txt_removeMovie.getText().toString();
                for(int i = 0; i<movieArray.size(); i++)
                {
                    String deleteName = movieArray.get(i).getName();
                    if(deleteName.equals(name)){
                        Toast.makeText(getApplicationContext(), "Movie " + deleteName+ " is deleted" , Toast.LENGTH_LONG).show();
                        movieArray.remove(i);
                        activity = true;
                    }
                }
                if (activity) {
                    Intent intent = new Intent(getApplicationContext(), MovieListActivity.class);
                    intent.putExtra("Array", movieArray);
                    startActivityForResult(intent,RETURN_CODE);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Movie doesn't exist"  , Toast.LENGTH_LONG).show();
                }
            }
        });




    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK && requestCode == RETURN_CODE) {
            movieArray = data.getParcelableArrayListExtra("returnResult");
            //Toast.makeText(getApplicationContext(),"Movie size: " , Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
