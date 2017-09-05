package com.androidapp.fidel.firstandroidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActividadUno extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView txtShow;
        Button btn_close;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_uno);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.MICONSTANTE);
        txtShow = (TextView) findViewById(R.id.txtView);
        btn_close = (Button) findViewById(R.id.btnClose);
        txtShow.setText(message);

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
