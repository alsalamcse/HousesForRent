package com.awad.adam.housesforrent;

import android.content.Intent;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class rentapartment extends AppCompatActivity implements View.OnClickListener{


    private EditText etcity;
    private EditText etcost;
    private EditText etunivardyl;
    private EditText etpeople;
    private Button btnsearch;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rentapartment);

        etcity=(EditText)findViewById(R.id.etcity);
        etcost=(EditText)findViewById(R.id.etcost);
        etunivardyl=(EditText)findViewById(R.id.etunivardy);
        etpeople=(EditText)findViewById(R.id.etpeople);
        btnsearch=(Button)findViewById(R.id.btnsearch);


    }

        @Override
        public void onClick(View view) {
            if (btnsearch == view) {
                Intent intent = new Intent(this, interyourhouse.class);
                startActivity(intent);


            }
        }
}







