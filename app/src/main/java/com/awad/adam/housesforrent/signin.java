package com.awad.adam.housesforrent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class signin extends AppCompatActivity {
    private Button  btnRentHouse;
    private Button btnRentyourhouse;
    private Button btnmessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        btnRentHouse=(Button)findViewById(R.id.btnRentHouse);
        btnRentyourhouse=(Button)findViewById(R.id.btnRentYourHouse);
        btnmessage=(Button)findViewById(R.id.btnMessage);

    }
}
